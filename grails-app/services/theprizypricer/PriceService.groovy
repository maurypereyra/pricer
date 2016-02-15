package theprizypricer

class PriceService {

    def idealPriceStrategy

    def getAveragePrice(List<Price> prices) {
        def price = null

        if(prices?.amount?.size() > 0) {
            def amountSet = prices?.amount
            price = (amountSet.sum() / amountSet.size()).setScale(2, BigDecimal.ROUND_HALF_UP)
        }

        return price
    }

    def getLowestPrice(List<Price> prices) {
        def price = null

        if(prices?.amount?.size() > 0) {
            price = prices?.amount.min().setScale(2, BigDecimal.ROUND_HALF_UP)
        }
        return price
    }

    def getHighestPrice(List<Price> prices) {
        def price = null

        if(prices?.amount?.size() > 0) {
            price = prices.amount.max().setScale(2, BigDecimal.ROUND_HALF_UP)
        }

        return price
    }

    def getIdealPrice(List<Price> prices) {
        def price = null

        if(prices?.amount?.size() > 0) {
            price = idealPriceStrategy.doCalculation(prices)
        }

        return price
    }

    def getPricesCount(List<Price> prices) {
        return prices?.size()
    }
}
