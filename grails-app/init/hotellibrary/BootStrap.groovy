package hotellibrary

class BootStrap {

    CountryService countryService
    HotelService hotelService
    SearchHotelService searchHotelService

    def init = { servletContext ->
        countryService.saveCountry("Китай", "Пекин")
        countryService.saveCountry("Россия", "Москва")
        countryService.saveCountry("Чехия", "Прага")
        hotelService.saveHotel("Сарог", 4, "Россия")
        hotelService.saveHotel("Сагор", 4, "Россия")
        hotelService.saveHotel("Свогор", 3, "Россия")
        hotelService.saveHotel("Логор", 4, "Россия")
        hotelService.saveHotel("Свагор", 3, "Китай")
        hotelService.saveHotel("Асагор", 3, "Китай")
        hotelService.saveHotel("Асагор", 3, "Китай")
        hotelService.saveHotel("Прошол", 5, "Чехия")
    }
    def destroy = {

    }
}
