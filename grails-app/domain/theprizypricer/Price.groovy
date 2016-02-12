package theprizypricer

class Price {
    Date dateCreated
    BigDecimal amount
    String notes

    static belongsTo = [product:Product, store: Store]

    static constraints = {
    }

    static mapping = {
        version false
        autoTimestamp true
        amount(nullable:false, scale:2)
    }
}
