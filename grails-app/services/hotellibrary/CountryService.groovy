package hotellibrary

import grails.gorm.DetachedCriteria
import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class CountryService {

    def getById(Long id){
        return Country.get(id)
    }

    Country saveCountry(String name, String capital){
        return new Country(name: name, capital: capital).save()
    }

    Country deleteCountry(Long id){
        Country country = Country.get(id)
        Hotel.where {
            it.country == country
        } as DetachedCriteria
        return country.delete()
    }

    Country updateInfoCountry(Long id, String name, String capital){
        Country country = Country.get(id)
        country.name = name
        country.capital = capital
        return country.save()
    }

    def getCountries(int page, int maxItemsInPage){
        BuildableCriteria criteria = Country.createCriteria()
        List<Country> countries = criteria.list {
            firstResult(page * maxItemsInPage)
            maxResults(maxItemsInPage)
        }
        int countPages = (Country.count() + maxItemsInPage - 1) / maxItemsInPage
        return [countries: countries, countPages: countPages]
    }

    List<Country> getCountries(){
        return Country.list()
    }
}
