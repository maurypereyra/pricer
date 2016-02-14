package theprizypricer

import theprizypricer.idealPriceStrategy.SpecialAverageIdealPriceStrategy
import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PriceService)
@Mock([Price])
class PriceServiceTest {

    def List <Price> prices
    def product01 = new Product(barCode: 1, description: "Honey")
    def store01 = new Store(name: "Walmart", address: "USA")
    void setUp(){

        prices = new ArrayList<Price>()
        prices.add(new Price(product: product01, store: store01, amount: 10, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 20, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 30, notes: "testNote"))
    }

    /**
     * Test ideal price
     * Result=120
     */
    void testIdealPrice(){
        PriceService pricesService = new PriceService()
        def firstFormula = mockFor(SpecialAverageIdealPriceStrategy)
        firstFormula.demand.doCalculation { bestPrice -> 120 }
        pricesService.idealPriceStrategy=firstFormula.createMock()
        def bestPrice = pricesService.getIdealPrice(prices)
        assert bestPrice != null
        assert bestPrice == 120.0
    }

    /**
     * Test Minimum price
     * Minimum = 100
     */
    void testGetLowestPrice() {
        PriceService pricesService = new PriceService()
        def minPrice = pricesService.getLowestPrice(prices)
        assertEquals 10, minPrice, 0
    }

    /**
     * Test Maximum price
     * Maximum = 100.5
     */
    void testMaxValue() {
        PriceService pricesService = new PriceService()
        def maxPrice = pricesService.getHighestPrice(prices)
        assertEquals  30, maxPrice, 0
    }

    /**
     * Test average price for the product
     * Average = 100.17
     */
    void testAveragePrice() {
        PriceService pricesService = new PriceService()
        def avgPrice = pricesService.getAveragePrice(prices)
        assertEquals 20, avgPrice, 0
    }

    /**
     * Test average price for the product
     * Average = 233.83
     */
    void testPricesCollected() {
        PriceService pricesService = new PriceService()
        def pricesCollected = pricesService.getPricesCount(prices)
        assertEquals 3, pricesCollected, 0
    }

}
