package theprizypricer

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.junit.Before
import theprizypricer.idealPriceStrategy.SpecialAverageIdealPriceStrategy

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PriceService)
@Mock([Price])
class PriceServiceTest {

    def List <Price> prices
    def product01 = new Product(barCode: 1, description: "Honey")
    def store01 = new Store(name: "Walmart", address: "USA")
    def PriceService priceService

    @Before
    void setUp(){
        prices = new ArrayList<Price>()
        prices.add(new Price(product: product01, store: store01, amount: 10, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 20, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 30, notes: "testNote"))

        priceService = new PriceService()
    }

    void testGetIdealPriceWhenPricesIsNullOrEmpty() {
        assertNull priceService.getIdealPrice(null)
        assertNull priceService.getIdealPrice(new ArrayList<Price>())
    }

    void testGetLowestPriceWhenPricesIsNullOrEmpty() {
        assertNull priceService.getLowestPrice(null)
        assertNull priceService.getLowestPrice(new ArrayList<Price>())
    }

    void testGetHighestPriceWhenPricesIsNullOrEmpty() {
        assertNull priceService.getHighestPrice(null)
        assertNull priceService.getHighestPrice(new ArrayList<Price>())
    }

    void testGetAveragePriceWhenPricesIsNullOrEmpty() {
        assertNull priceService.getAveragePrice(null)
        assertNull priceService.getAveragePrice(new ArrayList<Price>())
    }

    void testGetPricesCountWhenPricesIsNullOrEmpty() {
        assertNull priceService.getPricesCount(null)
        assertEquals 0, priceService.getPricesCount(new ArrayList<Price>()), 0
    }

    void testGetIdealPrice() {
        def firstFormula = mockFor(SpecialAverageIdealPriceStrategy)
        firstFormula.demand.doCalculation { bestPrice -> 120 }
        priceService.idealPriceStrategy=firstFormula.createMock()

        def bestPrice = priceService.getIdealPrice(prices)

        assertNotNull bestPrice
        assertEquals 120, bestPrice, 0
    }

    void testGetLowestPrice() {
        def minPrice = priceService.getLowestPrice(prices)

        assertEquals 10, minPrice, 0
    }

    void testGetHighestPrice() {
        def maxPrice = priceService.getHighestPrice(prices)

        assertEquals  30, maxPrice, 0
    }

    void testGetAveragePrice() {
        def avgPrice = priceService.getAveragePrice(prices)

        assertEquals 20, avgPrice, 0
    }

    void testGetPricesCount() {
        def pricesCollected = priceService.getPricesCount(prices)

        assertEquals 3, pricesCollected, 0
    }

}
