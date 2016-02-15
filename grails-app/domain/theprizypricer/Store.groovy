package theprizypricer

class Store {
    String name
    String address

    static hasMany = [prices:Price]

    static constraints = {
        name blank: false, nullable: false
        address blank: true, nullable: true
    }

    static mapping = {
        version false
        name nullable: false
        address nullable: true
    }
}
