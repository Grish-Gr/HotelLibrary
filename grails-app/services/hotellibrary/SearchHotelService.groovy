package hotellibrary

import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class SearchHotelService {

    List<Hotel> searchHotelByName(String name, String nameCountry){
        Country country = Country.findByName(nameCountry)
        BuildableCriteria criteria = Hotel.createCriteria()
        return criteria.list {
            ilike("name", "%${name}%")
            if (country != null){
                eq("country", country)
            }
            order("rating", "desc")
            order("name", "asc")
        } as List<Hotel>
    }
}
