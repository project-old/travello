var application = new Vue({
    el: '#app',
    vuetify: new Vuetify(),
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
            states:
                [],
            noResults: {
                display: "block"
            },
            results: {
                display: "block"
            },
            dataServer: [],                                    
            mapMarkers: [],
            dataVisible: [],
            show: true,
        }
    },
    watch: {
        search(val) {
            val && val !== this.select && this.querySelections(val)
        }
    },
    created: function () {
        console.log("Ciao")
        axios.get("https://travellos.herokuapp.com/api/comuni/names")
            //.then(response => (this.items = response))
            .then(function (response) {                
                application.states = response.data
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
        addLike: function (n) {
            console.log(n)
        },
        toggle: function (type) {
            switch (type) {
                case "impostazioni":
                    console.log("impostazioni")
                    if (this.cardToggle.display == "none") {
                        this.cardToggle.display = "block"
                        this.button.icon = "keyboard_arrow_up"
                    } else {
                        this.cardToggle.display = "none"
                        this.button.icon = "menu"
                    }
                    break;
            }
        },
        querySelections(v) {
            this.loading = true;
            setTimeout(() =>{
                this.items = this.states.filter(e => {
                    return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                })
            })
            this.loading = false;
        },
        get_data_spring: function () {
            this.clearMarkers()
            var that = this            
            this.noResults.display = "none";
            received = [];

            //request to the website
            //can it do it in localhost?
            this.clearMarkers();
            axios.get("https://travellos.herokuapp.com/api/attivita?localita=" + this.select)
                
                .then(function (response) {
                    var last = [];                    
                    application.dataServer = response.data;        
                    application.show = false   
                    application.dataServer.forEach(item => {                        
                        last = [item.lon, item.lat]
                        application.addMarker([item.lon, item.lat])
                    })         
                    application.setView(last);
                })
        },
        loadMap: function () {
            this.map = L.map('mapid').setView([46.064276, 11.124129], 13);
            L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
                "autoscale": true,
                minZoom: 9,
                maxZoom: 18,
                id: 'mapbox.streets',
                accessToken: 'pk.eyJ1Ijoic2VidGhldHJhbXAiLCJhIjoiY2tiOWw3OHprMGZjZTMxanBncng1NjltbSJ9.LxBvYETwF-pPSqoGGq3ltw'
            }).addTo(this.map);
            this.addMarker([46.064276, 11.124129])
            //this.setView([46.064276, 11.124129])          
        },
        getUrlImage(link){            
          if(link == null)
          {
              return "https://hotel-bambini.quantomanca.com/wp-content/uploads/2015/09/Residence-Mich-123FAMILYHOTELS-hotel-bambini.QUANTOMANCA.COM_.jpg";              
          }  
          else{
              return link;
          }
        },
        addMarker: function (pos) {
            var marker = L.marker(pos).addTo(this.map)
            this.mapMarkers.push(marker);
            var group = new L.featureGroup(this.mapMarkers);
            this.map.fitBounds(group.getBounds());
        },
        clearMarkers: function () {
            this.mapMarkers.forEach(element => {
                this.map.removeLayer(element);
            });
        },
        setView: function (pos) {
            this.map.setView(pos, 13);
        },
        dataBind: function (data) {
            this.nVisible += 5;
            this.dataVisible = this.dataServer.slice(0, this.nVisible)
            this.dataVisible.forEach(element => {
                console.log(element)
                if (element.headquartersLat != null && element.headquartersLon != null) {
                    this.addMarker([element.headquartersLat, element.headquartersLon])
                }
            });
            if (this.nVisible >= this.dataServer.length) {
                this.btnVisible = false
                this.fineResults = true
            }
        },
        openSite: function (site) {
            console.log(site)
            window.open("//" + site);
        },
        openDetail(id){
            console.log(id)
            window.open(window.location + "pages/detail/detail.html?id=" + id);
        }
    },
});

application.loadMap()