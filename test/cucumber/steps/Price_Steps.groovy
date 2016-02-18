import pages.store.PriceNewPage

import static cucumber.runtime.groovy.EN.Given
import static cucumber.runtime.groovy.EN.Then
import static cucumber.runtime.groovy.EN.When

import pages.store.PriceListPage

Given(~'^I open create price$') { ->
    // Express the Regexp above with the code you wish you had
    to PriceListPage
    at PriceListPage
}

When(~'^I add a price with amount "([^"]*)", with the note "([^"]*)" for "([^"]*)" on "([^"]*)"$') { String arg1, String arg2, String arg3, String arg4 ->
    // Express the Regexp above with the code you wish you had
    page.toPriceNewPage()
    at PriceNewPage

    page.add(arg1, arg2, arg3, arg4)
}

Then(~'^I see the new price for "([^"]*)" on "([^"]*)"$') { String product, String store ->
    // Express the Regexp above with the code you wish you had
    at PriceShowPage

    //page.check()//hacer el show
}
