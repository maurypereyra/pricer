import static cucumber.runtime.groovy.EN.*
import pages.store.StoreListPage

Given(~'^I open create store$') { ->
    // Express the Regexp above with the code you wish you had
    to StoreListPage
    at StoreListPage
    assert false
}

When(~'^I add "([^"]*)" located in "([^"]*)"$') { String arg1, String arg2 ->
    // Express the Regexp above with the code you wish you had
    assert false
}

Then(~'^I see "([^"]*)"s details$') { String arg1 ->
    // Express the Regexp above with the code you wish you had
    assert false
}
