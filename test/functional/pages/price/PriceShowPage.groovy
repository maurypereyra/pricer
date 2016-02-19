package pages.price

import geb.Page

/**
 * Created by Mauricio Pereyra on 19/02/2016.
 */
class PriceShowPage extends Page{
    static url = "price/show"

    static at = {
        title ==~ /Show Price/
    }

    static content = {

    }

    def check(String newAmount, String newNotes, String productName, String storeName) {
        $('#amount-value') == newAmount
        $('#notes-value') == newNotes
        $('#product-value') == productName
        $('#store-value') == storeName
    }


}
