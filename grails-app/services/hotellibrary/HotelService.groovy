package hotellibrary

import grails.gorm.transactions.Transactional
import javassist.NotFoundException

@Transactional
class HotelService {

    private final maxItemsInPage = 10

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

    def getHotels(Integer page){
        return [hotels: Hotel.list().drop(page * maxItemsInPage).take(maxItemsInPage),
                hasPrev: page > 0,
                hasNext: Hotel.count() > maxItemsInPage * (page + 1)]
    }
}
