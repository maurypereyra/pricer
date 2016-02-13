package theprizypricer

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class PriceTests {

    Price price

    void setUp() {
        price = new Price(product: new Product(), store: new Store(), amount: 5, notes: "note1").save()
        price.save(flush: true)
    }

    void testValidateNullableFields() {
        mockForConstraintsTests(Price)
        price = new Price()
        assertFalse price.validate()
        assertEquals 'nullable', price.errors['amount']
        assertEquals 'nullable', price.errors['product']
        assertEquals 'nullable', price.errors['store']
        assertNull price.errors["dateCreated"]
        assertNull price.errors["notes"]
        System.out.println(price.errors.errorCount)
        assertEquals 3, price.errors.errorCount
    }

    void testValidateRangeConstraints() {
        mockForConstraintsTests(Price)
        setUp()
        price.amount = 0
        assertFalse price.validate()
        assertEquals 'min', price.errors['amount']
    }

    void testValidateEmptyConstraints(){
        mockForConstraintsTests(Price)
        setUp()
        price.notes = ""
        assertTrue price.validate()
    }
}
