package theprizypricer

class Product {
    String barCode
    String description

    static hasMany = [prices:Price]
    static constraints = {
    }

    static mapping = {
        version false
        barCode (nullable: false, unique: true, blank:false)
        description (nullable: false, blank:false)
    }

}
