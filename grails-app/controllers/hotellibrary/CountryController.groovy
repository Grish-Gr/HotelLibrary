package hotellibrary

class CountryController {
    HotelService hotelService
    CountryService countryService

    def countries(Integer page) {
        def res = countryService.getCountries(page ?: 0)
        render view: "countries", model: [listCountry: res.countries,
                                          page: page ?: 0,
                                          hasNext: res.hasNext,
                                          hasPrev: res.hasPrev]
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
