package hotellibrary

class HomeController {

    SearchHotelService searchHotelService

    def list(Long page) {
        println "${page} - ${params}"
        render view: "list", model: [list: searchHotelService.searchHotelByName(params.searchName as String),
                                     num: page]
    }
}
