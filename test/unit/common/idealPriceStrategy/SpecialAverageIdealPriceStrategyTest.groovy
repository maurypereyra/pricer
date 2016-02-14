package common.idealPriceStrategy

import theprizypricer.Price
import theprizypricer.Product
import theprizypricer.Store


/**
 * Created by Mauricio Pereyra on 14/02/2016.
 */
class SpecialAverageIdealPriceStrategyTest extends GroovyTestCase {

    def BigDecimal expectedPrice
    def List <Price> prices
    def product01 = new Product(barCode: 1, description: "Honey")
    def store01 = new Store(name: "Walmart", address: "USA")
    def SpecialAverageIdealPriceStrategy strategy

    void setUp() {
        super.setUp()
        expectedPrice = new BigDecimal(10)
        prices = new ArrayList<Price>()

        prices.add(new Price(product: product01, store: store01, amount: 10, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 10, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 10, notes: "testNote"))
    }

    void testDoCalculationWhenPriceCountIsGreaterThanFour() {
        prices.add(new Price(product: product01, store: store01, amount: 5, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 10, notes: "testNote"))
        prices.add(new Price(product: product01, store: store01, amount: 25, notes: "testNote"))
        expectedPrice = new BigDecimal(12)

        strategy = new SpecialAverageIdealPriceStrategy()

        def idealPrice = strategy.doCalculation(prices)
        assertNotNull idealPrice
        assertEquals expectedPrice, idealPrice
    }

    void testDoCalculationWhenPriceCountIsLessThanFour() {
        strategy = new SpecialAverageIdealPriceStrategy()

        def idealPrice = strategy.doCalculation(prices)
        assertNotNull idealPrice
        assertEquals expectedPrice, idealPrice
    }

    void testDoCalculationWhenPriceCountIsFour() {
        prices.add(new Price(product: product01, store: store01, amount: 10, notes: "testNote"))

        strategy = new SpecialAverageIdealPriceStrategy()

        def idealPrice = strategy.doCalculation(prices)
        assertNotNull idealPrice
        assertEquals expectedPrice, idealPrice
    }

    void testDoCalculationWhenPriceCountIsZero() {
        prices.clear()

        strategy = new SpecialAverageIdealPriceStrategy()

        assertNull strategy.doCalculation(prices)
    }

    void testDoCalculationWhenPriceIsNull() {
        strategy = new SpecialAverageIdealPriceStrategy()

        assertNull strategy.doCalculation(null)
    }
}
