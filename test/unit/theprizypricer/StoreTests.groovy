package theprizypricer

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import org.junit.Before

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class StoreTests {
    def Store store

    @Before
    void setUp() {
        store = new Store(name: "Walmart", address: "USA")
    }

    void testValidateNullableFields() {
        mockForConstraintsTests(Store)
        store = new Store()
        assertFalse store.validate()
        assertNull store.errors['address']
        assertEquals 'nullable', store.errors['name']
        assertEquals 1, store.errors.errorCount
    }

    void testValidateEmptyConstraints(){
        mockForConstraintsTests(Store)
        store.name = ""
        store.address = ""
        assertFalse store.validate()
        assertNull store.errors['address']
        assertEquals 'blank', store.errors['name']
        assertEquals 1, store.errors.errorCount
    }
}
