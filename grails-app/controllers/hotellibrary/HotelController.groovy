package hotellibrary

class HotelController {
    HotelService hotelService
    CountryService countryService

    def hotels(Integer page) {
        def res = hotelService.getHotels(page ?: 0)
        List<Integer> listPaginationPages = getListAvailablePages(page ?: 0, res.countPages)
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

    private List<Integer> getListAvailablePages(int currentPage, int countPages){
        List<Integer> availablePages = new ArrayList<>()
        if (currentPage < 3){
            for (int i = 0; i < 5 && i < countPages; i++){
                availablePages.add(i + 1)
            }
            return availablePages
        }
        if (countPages - currentPage < 5){
            for (int i = countPages - 5; i < countPages; i++){
                availablePages.add(i + 1)
            }
            return availablePages
        }
        for (int i = currentPage - 2; i < currentPage + 3 && i < countPages; i++){
            availablePages.add(i + 1)
        }
        return availablePages
    }
}
