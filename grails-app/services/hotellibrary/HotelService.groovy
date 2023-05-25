package hotellibrary

import grails.gorm.transactions.Transactional
import javassist.NotFoundException
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class HotelService {

    Hotel getById(Long id){
        return Hotel.get(id)
    }

    Hotel saveHotel(String name, Integer rating, String nameCountry, String linkToWebsite = null) {
        Country country = Country.findByName(nameCountry)
        return new Hotel(name: name, rating: rating, country: country, linkToWebsite: linkToWebsite).save()
    }

    Hotel deleteHotel(Long id){
        return Hotel.get(id).delete()
    }

    Hotel updateInfoHotel(Long id, String name, Integer rating, String nameCountry, String linkToWebsite){
        Hotel hotel = Hotel.get(id)
        hotel.name = name
        hotel.rating = rating
        hotel.linkToWebsite = linkToWebsite
        if (hotel.country.name != nameCountry){
            hotel.country = Country.findByName(nameCountry)
        }
        return hotel.save()
    }

    def getHotels(Integer page, Integer maxItemsInPage){
        BuildableCriteria criteria = Hotel.createCriteria()
        List<Hotel> hotels = criteria.list {
            firstResult(page * maxItemsInPage)
            maxResults(maxItemsInPage)
        }
        int countPages = (Hotel.count() + maxItemsInPage - 1) / maxItemsInPage
        return [hotels: hotels, countPages: countPages]
    }
}
