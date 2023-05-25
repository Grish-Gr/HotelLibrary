package hotellibrary

class HomeController {
    SearchHotelService searchHotelService
    CountryService countryService
    private final int countAvailablePages = 5
    private final int maxItemsInPage = 10

    def home(){
        render view: "home", model: [countries: countryService.getCountries().name]
    }

    def search(Integer page, String searchName, String country) {
        int currentPage = page ?: 0
        currentPage = currentPage < 0 ? 0 : currentPage
        def res = searchHotelService.searchHotelByName(searchName, country, currentPage, maxItemsInPage)
        List<Integer> listPaginationPages = PaginationResolver.getListAvailablePages(
                currentPage, res.countPages, countAvailablePages
        )
        render view: "table", model: [hotels: res.hotels,
                                      currentPage: currentPage,
                                      listPaginationPages: listPaginationPages,
                                      lastPage: res.countPages,
                                      countEntries: res.countEntries]
    }
}
