<script>
    import mapboxgl from 'mapbox-gl'

    export default {
        props: {
            position: {
                type: String,
                default: 'bottom-right',
                validator (value) {
                    const validValues = [
                        'top-left',
                        'top-right',
                        'bottom-right',
                        'bottom-left'
                    ]
                    const valueIsValid = validValues.indexOf(value) !== -1
                    if (!valueIsValid) {
                        console.warn('Acceptable prop values:', validValues)
                    }
                    return valueIsValid
                }
            }
        },
        mounted () {
            this.$nextTick(() => {
                this.$parent.map.addControl(
                    new mapboxgl.NavigationControl(),
                    this.position
                )
            })
        },
        render () {
            return null
        }
    }
</script>
