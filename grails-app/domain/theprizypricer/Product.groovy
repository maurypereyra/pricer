package theprizypricer

class Product {
    String barCore
    String description

    static hasMany = [prices:Price]
    static constraints = {
    }

    static mapping = {
        version false
        id column: 'barCore'
    }

}
