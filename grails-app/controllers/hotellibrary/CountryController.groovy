package hotellibrary

import grails.gorm.DetachedCriteria

class CountryController {
    HotelService hotelService
    CountryService countryService
    private final int countAvailablePages = 5
    private final int maxItemsInPage = 10

    def countries(Integer page) {
        def res = countryService.getCountries(page ?: 0, maxItemsInPage)
        List<Integer> listPaginationPages = PaginationResolver.getListAvailablePages(
                page ?: 0, res.countPages, countAvailablePages
        )
        render view: "countries", model: [listCountry: res.countries,
                                          currentPage: page ?: 0,
                                          listPaginationPages: listPaginationPages,
                                          lastPage: res.countPages]
    }

    def country(Long id){
        if (id == null){
            render view: "create_country"
        } else {
            render view: "edit_country", model: [country: countryService.getById(id)]
        }
    }

    def createCountry(){
        countryService.saveCountry(
                params.countryName as String,
                params.capitalName as String
        )
        redirect(action: "countries")
    }

    def editCountry(){
        countryService.updateInfoCountry(
                Long.parseLong(params.id),
                params.countryName as String,
                params.capitalName as String
        )
        redirect(action: "countries")
    }

    def deleteCountry(){
        countryService.deleteCountry(Long.parseLong(params.id))
        redirect(action: "countries")
    }
}
