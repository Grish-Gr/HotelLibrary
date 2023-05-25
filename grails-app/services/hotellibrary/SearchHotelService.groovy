package hotellibrary

import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class SearchHotelService {

    def searchHotelByName(String name, String nameCountry, Integer page, Integer maxItemsInPage){
        Country country = Country.findByName(nameCountry)
        int countEntries = Hotel.createCriteria().get {
            ilike("name", "%${name}%")
            if (country != null){
                eq("country", country)
            }
            projections{
                count("id")
            }
        }
        List<Hotel> hotels = Hotel.createCriteria().list {
            firstResult(page * maxItemsInPage)
            maxResults(maxItemsInPage)
            ilike("name", "%${name}%")
            if (country != null){
                eq("country", country)
            }
            order("rating", "desc")
            order("name", "asc")
        }
        int countPages = (countEntries + maxItemsInPage - 1) / maxItemsInPage
        return [hotels: hotels, countPages: countPages, countEntries: countEntries]
    }
}
