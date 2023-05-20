package hotellibrary

class BootStrap {

    CountryService countryService
    HotelService hotelService
    SearchHotelService searchHotelService

    def init = { servletContext ->
        countryService.saveCountry("Russia", "Moscow")
        hotelService.saveHotel("Savagresh", 4, "Russia")
        hotelService.saveHotel("sagor", 3, "Russia")
        hotelService.saveHotel("Svoa", 2, "Russia")
        hotelService.saveHotel("GaSaGa", 4, "Russia")

        searchHotelService.searchHotelByName("Sa").collect {
            println it.name
        }

        hotelService.updateInfoHotel(1, "Gaga", 5, "Russia")
        searchHotelService.searchHotelByName("sa").collect{println it.name}
        searchHotelService.searchHotelByName("ga").collect{println it.name}
    }
    def destroy = {

    }
}
