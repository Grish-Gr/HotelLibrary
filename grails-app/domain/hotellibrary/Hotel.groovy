package hotellibrary

import groovy.transform.CompileStatic

class Hotel {
    String name
    Integer rating
    static belongsTo = [country: Country]

    static constraints = {
        name maxSize: 255
        rating min: 1, max: 5
    }
}
