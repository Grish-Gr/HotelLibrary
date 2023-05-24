package hotellibrary

class HomeController {
    SearchHotelService searchHotelService
    CountryService countryService

    def home(){
        render view: "home", model: [countries: countryService.getCountries().name]
    }

    def search(String searchName, String country) {
        List<Hotel> hotels = searchHotelService.searchHotelByName(searchName, country)
        render view: "table", model: [hotels: hotels]
    }
}
