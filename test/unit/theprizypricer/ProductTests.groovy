package theprizypricer

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import static org.junit.Assert.*

@TestMixin(GrailsUnitTestMixin)
class ProductTests {
    def product

    void setUp() {
        product = Product(barCode: 1, description: "Honey")
        product.save()
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
        assertTrue product.validate()
    }


}
