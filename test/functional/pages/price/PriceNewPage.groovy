package pages.price

import geb.Page


class PriceNewPage extends Page{
    static url = "price/create"

    static at = {
        title ==~ /Create Price/
    }

    static content = {
        create() {
            $ ('input#create')
        }

    }

    def add(String newAmount, String newNotes, String productName, String storeName) {
        def selectedStoreId = PriceData.findByStoreName(storeName)
        def selectedProductId = PriceData.findByProductName(productName)

        $("form").amount = newAmount
        $("form").notes = newNotes
        $("form")."product.id" = productName
        $("form")."store.id" = storeName

        create.click ()
    }


}
