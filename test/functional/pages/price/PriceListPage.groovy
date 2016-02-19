package pages.price

import geb.Page

/**
 * Created by Mauricio Pereyra on 18/02/2016.
 */
class PriceListPage extends Page {
    static url = "price/list"

    static at = {
        title ==~ /Price List/
    }

    static content = {
        create (to: PriceNewPage) {
            $ ('a.create')
        }
    }

    def toPriceNewPage () {
        create.click()
    }
}
