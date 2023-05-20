package hotellibrary

import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.hibernate.Criteria

@Transactional
class SearchHotelService {

    List<Hotel> searchHotelByName(String name){
        BuildableCriteria criteria = Hotel.createCriteria()
        return criteria.list {
            ilike("name", "%${name}%")
        } as List<Hotel>
    }
}