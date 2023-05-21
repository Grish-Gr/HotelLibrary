package hotellibrary

import grails.gorm.transactions.Transactional

@Transactional
class CountryService {

    Country saveCountry(String name, String capital){
        return new Country(name: name, capital: capital).save()
    }

    Country deleteCountry(Long id){
        return Country.get(id).delete()
    }

    Country updateInfoCountry(Long id, String name, String capital){
        Country country = Country.get(id)
        country.name = name
        country.capital = capital
        return country.save()
    }

    List<Country> getCountries(){
        return Country.list()
    }
}
