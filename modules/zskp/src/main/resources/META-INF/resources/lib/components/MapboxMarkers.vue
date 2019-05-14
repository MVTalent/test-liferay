<script>
    import Vue from "vue";
    import mapboxgl from "mapbox-gl";
    import cuid from "cuid";

    const markerIconPadding = 10;
    const markerTextPadding = 10;
    const markerHeight = 15;
    const markerTextSize = 14;
    const markerTextOffsetVertical = 0.7;
    const markerTextBorderSize = 2;
    const markerWidth = 10;

    export default {
        props: {
            items: {
                type: Array,
                required: true
            },
            primary: {
                type: Boolean,
                default: false
            }
        },
        data() {
            const sourceName = cuid();
            const layerId = `${sourceName}-markers`;

            return {
                sourceName,
                layerId,
                lastAddedPopup: null
            };
        },
        computed: {
            map() {
                return this.$parent.map;
            },
            lats() {
                return this.items.map(this.getLat);
            },
            longs() {
                return this.items.map(this.getLong);
            },
            minLat() {
                return Math.min(...this.lats);
            },
            maxLat() {
                return Math.max(...this.lats);
            },
            minLong() {
                return Math.min(...this.longs);
            },
            maxLong() {
                return Math.max(...this.longs);
            },
            centerLat() {
                return (this.minLat + this.maxLat) / 2;
            },
            centerLong() {
                return (this.minLong + this.maxLong) / 2;
            },
            itemsGeoJson() {
                return {
                    type: "FeatureCollection",
                    features: this.items.map(item => {
                        return {
                            type: "Feature",
                            properties: {
                                id: cuid(),
                                ...item,
                                icon: "marker-15"
                            },
                            geometry: {
                                type: "Point",
                                coordinates: [this.getLong(item), this.getLat(item)]
                            }
                        };
                    })
                };
            }
        },
        watch: {
            items: {
                handler() {
                    this.removeOpenPopups();

                    const source = this.map.getSource(this.sourceName);
                    if (source) {
                        source.setData(this.itemsGeoJson);
                    }

                    if (this.primary) {
                        this.$parent.map.fitBounds(
                            [[this.minLong, this.minLat], [this.maxLong, this.maxLat]],
                            {
                                padding: 50
                            }
                        );
                    }
                },
                deep: true
            }
        },
        mounted() {
            this.$nextTick(() => {
                if (this.primary) {
                    this.map.fitBounds(
                        [[this.minLong, this.minLat], [this.maxLong, this.maxLat]],
                        {
                            padding: 50,
                            easing: () => 1
                        }
                    );
                }

                this.map.on("load", () => {
                    this.map.addSource(this.sourceName, {
                        type: "geojson",
                        data: this.itemsGeoJson,
                        cluster: true,
                        clusterMaxZoom: 12,
                        clusterRadius: 40
                    });

                    // Property Markers
                    const markerLayerOptions = {
                        id: this.layerId,
                        type: "symbol",
                        source: this.sourceName,
                        layout: {
                            "icon-image": "{icon}",
                            "icon-allow-overlap": true,
                            "text-optional": true,
                            "text-field": "{name}",
                            "text-font": ["Open Sans Bold", "Arial Unicode MS Bold"],
                            "text-size": markerTextSize,
                            "text-transform": "uppercase",
                            "text-letter-spacing": 0.05,
                            "text-offset": [0, markerTextOffsetVertical],
                            "text-anchor": "top",
                            "icon-padding": markerIconPadding,
                            "text-padding": markerTextPadding
                        },
                        paint: {
                            "text-color": "#B1383D",
                            "text-halo-color": "white",
                            "text-halo-width": markerTextBorderSize
                        }
                    };

                    // Add markers
                    this.map.addLayer(markerLayerOptions);

                    const markerClusterTypes = [50, 25, 10, 5, 0];

                    markerClusterTypes.forEach((clusterSize, index) => {
                        this.map.addLayer({
                            id: `${this.sourceName}-clusters-${index}`,
                            type: "circle",
                            source: this.sourceName,
                            paint: {
                                "circle-color": "white",
                                "circle-radius": 15,
                                "circle-blur": 0.7
                            },
                            filter:
                                index === 0
                                    ? [">=", "point_count", clusterSize]
                                    : [
                                        "all",
                                        [">=", "point_count", clusterSize],
                                        ["<", "point_count", markerClusterTypes[index - 1]]
                                    ]
                        });
                    });

                    // Names of all marker cluster layers
                    const markerClusterLayers = markerClusterTypes.map(
                        (_, index) => `${this.sourceName}-clusters-${index}`
                    );

                    this.map.addLayer({
                        id: `${this.sourceName}-cluster-counts`,
                        type: "symbol",
                        source: this.sourceName,
                        layout: {
                            "text-field": "{point_count}",
                            "text-font": ["DIN Offc Pro Medium", "Arial Unicode MS Bold"],
                            "text-size": 13
                        },
                        paint: {
                            "text-color": "#B1383D"
                        }
                    });

                    // Set mouse pointer styles depending on mouse position
                    this.map.on("mousemove", event => {
                        const hoveredMarkers = this.map.queryRenderedFeatures(event.point, {
                            layers: [this.layerId]
                        });

                        const hoveredMarkerClusters = this.map.queryRenderedFeatures(
                            event.point,
                            {
                                layers: [...markerClusterLayers]
                            }
                        );

                        if (hoveredMarkers.length) {
                            this.createPopup(hoveredMarkers[0]);
                        } else {
                            this.removeOpenPopups();
                        }

                        if (hoveredMarkerClusters.length) {
                            this.map.getCanvas().style.cursor = "pointer";
                        } else {
                            this.map.getCanvas().style.cursor = "";
                        }
                    });

                    this.map.on("click", event => {
                        // If clicking on a property marker...
                        const clickedMarkers = this.map.queryRenderedFeatures(event.point, {
                            layers: [this.layerId]
                        });
                        if (clickedMarkers.length) {
                            // const clickedMarker = clickedMarkers[0]
                            // Display a popup for the marker
                            // store.dispatch('openPropertyModal', clickedMarker.properties.id)
                            return;
                        }

                        // If clicking on a cluster
                        const clickedClusters = this.map.queryRenderedFeatures(event.point, {
                            layers: markerClusterLayers
                        });
                        if (clickedClusters.length) {
                            const clickedCluster = clickedClusters[0];
                            // Zoom in on the cluster
                            this.map.flyTo({
                                center: clickedCluster.geometry.coordinates,
                                zoom: this.map.getZoom() + 2
                            });
                        }
                    });
                });
            });
        },
        methods: {
            getLat(item) {
                return item.latitude || item.lat;
            },
            getLong(item) {
                return item.longitude || item.long || item.lon;
            },
            createPopup(marker) {
                const popupContentVNodes = this.$scopedSlots.default(marker.properties);
                const popupHtml = new Vue({
                    render: h => h("div", popupContentVNodes)
                }).$mount().$el.innerHTML;

                this.removeOpenPopups();

                this.lastAddedPopup = new mapboxgl.Popup({
                    offset: {
                        top: [
                            0,
                            (markerHeight +
                                markerTextOffsetVertical +
                                markerIconPadding +
                                markerTextPadding) /
                            2 +
                            markerTextSize
                        ],
                        right: [(markerWidth + markerIconPadding) / -2, 0],
                        bottom: [0, (markerHeight + markerIconPadding) / -2],
                        left: [(markerWidth + markerIconPadding) / 2, 0]
                    }
                })
                    .setLngLat(marker.geometry.coordinates)
                    .setHTML(popupHtml)
                    .addTo(this.map);
            },
            removeOpenPopups() {
                if (this.lastAddedPopup) {
                    this.lastAddedPopup.remove();
                    this.lastAddedPopup = null;
                }
            }
        },
        render() {
            return null;
        }
    };
</script>

<style lang="scss" scoped>
    #app {
        .mapboxgl-popup {
            pointer-events: none;
        }

        .mapboxgl-popup-content {
            padding: 10px 15px;
            pointer-events: none;
        }

        .mapboxgl-popup-close-button {
            display: none;
        }
    }
</style>
