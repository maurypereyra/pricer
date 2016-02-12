package theprizypricer

class Store {
    String name
    String address

    static hasMany = [prices:Price]

    static constraints = {
        name(nullable: false)
    }

}
