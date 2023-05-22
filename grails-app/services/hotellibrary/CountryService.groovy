package hotellibrary

import grails.gorm.transactions.Transactional

@Transactional
class CountryService {
    private final maxItemsInPage = 10

    def getById(Long id){
        return Country.get(id)
    }

    Country saveCountry(String name, String capital){
        return new Country(name: name, capital: capital).save()
    }

    Country deleteCountry(Long id){
        Country country = Country.get(id)
        Hotel.findByCountry(country).delete()
        return country.delete()
    }

    Country updateInfoCountry(Long id, String name, String capital){
        Country country = Country.get(id)
        country.name = name
        country.capital = capital
        return country.save()
    }

    def getCountries(Integer page){
        return [countries: Country.list().drop(maxItemsInPage * page).take(maxItemsInPage),
                hasPrev: page > 0,
                hasNext: Country.count() > maxItemsInPage * (page + 1)]
    }

    List<Country> getCountries(){
        return Country.list()
    }
}
