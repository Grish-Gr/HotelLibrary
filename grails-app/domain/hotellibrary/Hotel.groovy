package hotellibrary

import groovy.transform.CompileStatic

class Hotel {
    String name
    Integer rating
    String linkToWebsite
    static belongsTo = [country: Country]

    static constraints = {
        name maxSize: 255
        rating min: 1, max: 5
        linkToWebsite nullable: true, url: true
    }
}
