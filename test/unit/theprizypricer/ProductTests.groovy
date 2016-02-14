package theprizypricer

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import static org.junit.Assert.*

@TestMixin(GrailsUnitTestMixin)
class ProductTests {
    def Product product

    void setUp() {
        product = new Product(barCode: 1L, description: "Honey").save()
    }

    void testValidateNullableFields() {
        mockForConstraintsTests(Product)
        Product product = new Product()
        assertFalse product.validate()
        assertNull product.errors['barCode']
        assertEquals 'nullable', product.errors['description']
        assertNull product.errors["prices"]
        assertEquals 1, product.errors.errorCount
    }

    void testValidateEmptyConstraints(){
        mockForConstraintsTests(Product)
        setUp()
        product.description = ""
        assertFalse product.validate()
        assertEquals 'blank', product.errors['description']
    }


}
