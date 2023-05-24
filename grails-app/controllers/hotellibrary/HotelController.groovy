package hotellibrary

class HotelController {
    HotelService hotelService
    CountryService countryService
    private final int countAvailablePages = 5
    private final int maxItemsInPage = 10

    def hotels(Integer page) {
        def res = hotelService.getHotels(page ?: 0, maxItemsInPage)
        List<Integer> listPaginationPages = PaginationResolver.getListAvailablePages(
                page ?: 0, res.countPages, countAvailablePages
        )
        render view: "hotels", model: [listHotel: res.hotels,
                                       currentPage: page ?: 0,
                                       listPaginationPages: listPaginationPages,
                                       lastPage: res.countPages]
    }

    def hotel(Long id){
        if (id == null){
            render view: "create_hotel", model: [countries: countryService.getCountries().name]
        } else {
            render view: "edit_hotel", model: [hotelInfo: hotelService.getById(id),
                                               countries: countryService.getCountries().name]
        }
    }

    def createHotel(){
        hotelService.saveHotel(
                params.hotelName as String,
                Integer.parseInt(params.rating),
                params.country as String,
                params.linkToWebsite as String
        )
        redirect(action: "hotels")
    }

    def editHotel(){
        hotelService.updateInfoHotel(
                Long.parseLong(params.id),
                params.hotelName as String,
                Integer.parseInt(params.rating),
                params.country as String,
                params.linkToWebsite as String
        )
        redirect(action: "hotels")
    }

    def deleteHotel(){
        hotelService.deleteHotel(Long.parseLong(params.id))
        redirect(action: "hotels")
    }
}
