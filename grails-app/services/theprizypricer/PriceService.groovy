package theprizypricer

class PriceService {

    def idealPriceStrategy

    def getAveragePrice(Set<Price> prices) {
        def amountSet = prices.amount
        return (amountSet.sum() / amountSet.size()).setScale(2, BigDecimal.ROUND_HALF_UP)
    }

    def getLowestPrice(Set<Price> prices) {
        return prices.amount.min()
    }

    def getHighestPrice(Set<Price> prices) {
        return prices.amount.max()
    }

    def getIdealPrice(Set<Price> prices) {
        return idealPriceStrategy.doCalculation(prices)
    }

    def getPricesCount(Set<Price> prices) {
        prices.size()
    }
}
