package hotellibrary

import groovy.transform.CompileStatic

class Country {
    String name
    String capital

    static constraints = {
        name maxSize: 255
        capital maxSize: 128
    }
}
