package hotellibrary

import grails.gorm.transactions.Transactional
import javassist.NotFoundException

@Transactional
class HotelService {

    Hotel getById(Long id){
        return Hotel.get(id)
    }

    Hotel saveHotel(String name, Integer rating, String nameCountry) {
        Country country = Country.findByName(nameCountry)
        return new Hotel(name: name, rating: rating, country: country).save()
    }

    Hotel deleteHotel(Long id){
        return Hotel.get(id).delete()
    }

    Hotel updateInfoHotel(Long id, String name, Integer rating, String nameCountry){
        Hotel hotel = Hotel.get(id)
        hotel.name = name
        hotel.rating = rating
        if (hotel.country.name != nameCountry){
            hotel.country = Country.findByName(nameCountry)
        }
        return hotel.save()
    }

    List<Hotel> getHotels(){
        return Hotel.list()
    }
}
