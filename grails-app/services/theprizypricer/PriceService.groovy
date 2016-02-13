package theprizypricer

class PriceService {

    def idealPriceStrategy

    def getAveragePrice(Set<Price> prices) {
        def price = null

        if(prices?.amount.size() > 0) {
            def amountSet = prices?.amount
            price = (amountSet.sum() / amountSet.size()).setScale(2, BigDecimal.ROUND_HALF_UP)
        }

        return price
    }

    def getLowestPrice(Set<Price> prices) {
        def price = null

        if(prices?.amount.size() > 0) {
            price = prices?.amount.min().setScale(2, BigDecimal.ROUND_HALF_UP)
        }
        return price
    }

    def getHighestPrice(Set<Price> prices) {
        def price = null

        if(prices?.amount.size() > 0) {
            price = prices.amount.max().setScale(2, BigDecimal.ROUND_HALF_UP)
        }

        return price
    }

    def getIdealPrice(Set<Price> prices) {
        def price = null

        if(prices?.amount.size() > 0) {
            price = idealPriceStrategy.doCalculation(prices).setScale(2, BigDecimal.ROUND_HALF_UP)
        }

        return price
    }

    def getPricesCount(Set<Price> prices) {
        return prices != null ? prices.size() : null
    }
}
