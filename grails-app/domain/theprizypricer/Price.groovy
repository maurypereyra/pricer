package theprizypricer

class Price {
    Date dateCreated
    /*Store store
    Product product*/
    BigDecimal amount
    String notes

    //static hasOne = [product: Product, store: Store]
    static belongsTo = [product:Product, store: Store]

    static constraints = {
    }

    static mapping = {
        version false
        autoTimestamp true
        //store column: "store_id"
        //product column: "product_barCore"
    }
}
