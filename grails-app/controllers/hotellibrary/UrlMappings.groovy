package hotellibrary

class UrlMappings {

    static mappings = {
        "/"(controller: "home", action:"home")
        "/home"(controller: "home", action:"home")
        "/home/search/$searchName?/$country?"(controller: "home", action:"search")

        "/hotels/$page?"(controller: "hotel", action:"hotels")
        "/hotel/$id?"(controller: "hotel", action:"hotel")
        "/hotel/create/"(controller: "hotel", action:"createHotel")
        "/hotel/delete/"(controller: "hotel", action:"deleteHotel")
        "/hotel/update/"(controller: "hotel", action:"editHotel")

        "/countries/$page?"(controller: "country", action:"countries")
        "/country/$id?"(controller: "country", action:"country")
        "/country/create/"(controller: "country", action:"createCountry")
        "/country/delete/"(controller: "country", action:"deleteCountry")
        "/country/update/"(controller: "country", action:"editCountry")

        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
