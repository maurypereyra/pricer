package pages.store

import geb.Page


class PriceNewPage extends Page{
    static url = "price/create"

    static at = {
        title ==~ /Crear Price/
    }

    static content = {

        amount {
            $('input#amount')
        }

        notes {
            $('input#notes')
        }

        product {
            $('select#product')
        }

        store {
            $('select#store')
        }

        save {
            $ ('input.save')
        }

    }

    def add (String newAmount, String newNotes, String productName, String storeName) {
        def selectedStoreId = PriceData.findByStoreName(storeName)
        def selectedProductId = PriceData.findByProductName(productName)

        amount.value = newAmount
        notes.value = newNotes
        product.value = selectedProductId
        store.value = selectedStoreId

        save.click ()
    }


}
