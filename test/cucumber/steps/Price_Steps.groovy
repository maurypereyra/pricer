import pages.price.PriceListPage
import pages.price.PriceNewPage
import pages.price.PriceShowPage

import static cucumber.runtime.groovy.EN.*

Given(~'^I open create price$') { ->
    to PriceListPage
    at PriceListPage
}

When(~'^I add a price with amount "([^"]*)", with the note "([^"]*)" for "([^"]*)" on "([^"]*)"$') { String arg1, String arg2, String arg3, String arg4 ->
    page.toPriceNewPage()
    at PriceNewPage

    page.add(arg1, arg2, arg3, arg4)
}

Then(~'^I see the new with amount "([^"]*)", with the note "([^"]*)" for "([^"]*)" on "([^"]*)"$') { String arg1, String arg2, String arg3, String arg4 ->
    at PriceShowPage

    page.check(arg1, arg2, arg3, arg4)
}
