package hotellibrary

class HotelController {
    HotelService hotelService
    CountryService countryService

    def hotels(Integer page) {
        render view: "hotels", model: [listHotel: hotelService.getHotels()]
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
        println(params)
        hotelService.saveHotel(
                params.hotelName as String,
                Integer.parseInt(params.rating),
                params.country as String
        )
        redirect(action: "hotels")
    }

    def editHotel(){
        hotelService.updateInfoHotel(
                Long.parseLong(params.id),
                params.hotelName as String,
                Integer.parseInt(params.rating),
                params.country as String
        )
        redirect(action: "hotels")
    }

    def deleteHotel(){
        hotelService.deleteHotel(Long.parseLong(params.id))
        redirect(action: "hotels")
    }
}
