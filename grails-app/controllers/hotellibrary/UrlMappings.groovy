package hotellibrary

class UrlMappings {

    static mappings = {
        "/"(controller: "home", action:"home")
        "/home"(controller: "home", action:"home")
        "/home/search/$searchName?/$country?"(controller: "home", action:"search")

        "/hotels/$page?"(controller: "hotel", action:"hotels", page: 0)
        "/hotel/$id?"(controller: "hotel", action:"hotel", id: null)
        "/hotel/create/"(controller: "hotel", action:"createHotel")
        "/hotel/delete/"(controller: "hotel", action:"deleteHotel")
        "/hotel/update/"(controller: "hotel", action:"editHotel")

        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
