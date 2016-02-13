package theprizypricer

class Price {
    Date dateCreated
    BigDecimal amount
    String notes

    static belongsTo = [product:Product, store: Store]

    static constraints = {
        amount blank: false, nullable: false, scale:2, min: 0.1
        notes blank: true, nullable: true
    }

    static mapping = {
        version false
        autoTimestamp true
        amount(nullable:false, scale:2)
        notes(nullable: true)
    }
}
