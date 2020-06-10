var application = new Vue({
    el: '#app',
    data() {
        return {
            small: false,
            map: null,
            map2: null,
            loading: false,
            items: [],
            search: null,
            select: null,
            checkbox: true,
            radioGroup: 2,
            slider: 45,
            volume: 10,
            price: [130, 300],
            rating: 2,
            like: 0,
            select: "TEST",
            cardToggle:
            {
                display: "none",
            },
            button:
            {
                icon: "menu"
            },

            nVisible: 0,
            btnVisible: false,
            fineResults: false,
            mapMarkers: [],
            hotel: {
                attivita: {},
                servizi: [],
                affitti: []
            }
        }
    },
    watch: {
        search(val) {
            val && val !== this.select && this.querySelections(val)
        }
    },
    created: function () {

        axios.get("https://travellos.herokuapp.com/api/attivita/detail" + window.location.search)
            //.then(response => (this.items = response))
            .then(function (response) {
                application.hotel.attivita = response.data;
                application.createMapSelf([parseFloat(application.hotel.attivita.lon), parseFloat(application.hotel.attivita.lat)])
            })
        axios.get("https://travellos.herokuapp.com/api/serviziHotel" + window.location.search)
            //.then(response => (this.items = response))
            .then(function (response) {
                application.hotel.servizi = response.data;
            })
        axios.get("https://travellos.herokuapp.com/api/affitto" + window.location.search)
            //.then(response => (this.items = response))
            .then(function (response) {
                application.hotel.affitti = response.data;
            })
    },
    methods: {
        /*
        onResize: function () {
            console.log(this.$vuetify.breakpoint.name);
            switch (this.$vuetify.breakpoint.name) {
                case "xs":
                    this.small = true;
                    break;
                case "sm": this.small = true; break;
                case "md": this.small = false; break;
                case "lg": this.small = false; break;
                case "xl": this.small = false; break;
            }
            //mettere la risoluzione automatica
            var w = window.innerWidth;
            var h = window.innerHeight;
            console.log(w, h);
        },
        */
        createMapSelf: function (pos) {
            console.log(pos)
            this.map = L.map('mapid').setView(pos, 13);
            L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
                "autoscale": true,
                maxZoom: 18,
                id: 'mapbox.streets',
                accessToken: 'pk.eyJ1Ijoic2VidGhldHJhbXAiLCJhIjoiY2pscXpqMTIzMHFtdjNwcGxnNWl3NHV1MiJ9.9eZSKexjBV2RdXorrwyBzg'
            }).addTo(this.map);
            this.addMarker(pos);
        },
        getUrlImage(link) {
            console.log(link)
            if (link == null) {
                return "https://hotel-bambini.quantomanca.com/wp-content/uploads/2015/09/Residence-Mich-123FAMILYHOTELS-hotel-bambini.QUANTOMANCA.COM_.jpg";
            }
            else {
                return link;
            }
        },
        addMarker: function (pos) {
            console.log(pos)
            var marker = L.marker(pos).addTo(this.map)
            this.mapMarkers.push(marker);
            var group = new L.featureGroup(this.mapMarkers);
            this.map.fitBounds(group.getBounds());
        },
        openDetail(id) {
            console.log(id, window.location)
            window.open(window.location + "pages/detail/detail.html?" + id);
        }
    },
});

application.loadMap()