package pages.store

import geb.Page

/**
 * Created by Mauricio Pereyra on 09/02/2016.
 */
class StoreListPage extends Page{
    static url = "store/list"

    static at = {
        title ==~ /Store List/
    }

    static content = {
    }
}
