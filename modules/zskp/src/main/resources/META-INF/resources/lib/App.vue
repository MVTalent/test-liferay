<script>
    import MapboxMap from "./components/MapboxMap.vue";
    import MapboxMarkers from "./components/MapboxMarkers.vue";
    import MapboxNavigation from "./components/MapboxNavigation.vue";

    export default {
        components: {
            MapboxMap,
            MapboxMarkers,
            MapboxNavigation
        },
        data() {
            return {
                cities: [
                    {
                        name: "KoHub Koh Lanta",
                        lat: 7.609905,
                        long: 99.037081
                    },
                    {
                        name: "Outpost Ubud",
                        lat: -8.527471,
                        long: 115.255696
                    },
                    {
                        name: "Outpost Phnom Penh",
                        lat: 11.574608,
                        long: 104.934995
                    },
                    {
                        name: "Hubba Ekkamai",
                        lat: 13.725451,
                        long: 100.587596
                    },
                    {
                        name: "Hub Hoi An",
                        lat: 15.891092,
                        long: 108.344190
                    }
                ]
            };
        }
    };
</script>

<template>
    <div id="app">
        <MapboxMap
                access-token="pk.eyJ1IjoiY2hyaXN2ZnJpdHoiLCJhIjoiY2lxMjAzYW9oMDExOGZ2bm80MTI2MDh6cSJ9.cbVt5KGuKqYkI2Lx7ysIFw"
        >
            <MapboxMarkers
                    :items="cities"
                    primary
            >
                <template slot-scope="city">
                    {{ city.name }}
                </template>
            </MapboxMarkers>
            <MapboxNavigation/>
        </MapboxMap>
    </div>
</template>

<style lang="scss" scoped>
    *,
    *::before,
    *::after {
        box-sizing: content-box;
    }

</style>
