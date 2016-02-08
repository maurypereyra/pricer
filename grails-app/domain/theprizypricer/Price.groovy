package theprizypricer

class Price {
    Date dateCreated
    /*Store store
    Product product*/
    BigDecimal amount
    String notes

    static belongsTo = [product:Product, store: Store]

    static constraints = {
    }

    static mapping = {
        version false
        autoTimestamp true
    }
}
