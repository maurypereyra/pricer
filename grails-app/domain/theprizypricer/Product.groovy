package theprizypricer

class Product {
    long barCode
    String description

    static hasMany = [prices:Price]
    static constraints = {
        barCode blank: false, nullable: false
        description blank: false, nullable: false
    }

    static mapping = {
        version false
        barCode (nullable: false, unique: true, blank:false)
        description (nullable: false, blank:false)
    }

}
