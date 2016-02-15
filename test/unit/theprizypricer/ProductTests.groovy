package theprizypricer

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import org.junit.Before

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNull

@TestMixin(GrailsUnitTestMixin)
class ProductTests {
    def Product product

    @Before
    void setUp() {
        product = new Product(barCode: 1L, description: "Honey").save()
    }

    void testValidateNullableFields() {
        mockForConstraintsTests(Product)
        product = new Product()
        assertFalse product.validate()
        assertNull product.errors['barCode']
        assertEquals 'nullable', product.errors['description']
        assertNull product.errors["prices"]
        assertEquals 1, product.errors.errorCount
    }

    void testValidateEmptyConstraints(){
        mockForConstraintsTests(Product)
        product.description = ""
        assertFalse product.validate()
        assertEquals 'blank', product.errors['description']
    }


}
