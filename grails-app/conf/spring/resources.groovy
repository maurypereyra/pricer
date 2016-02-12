import common.idealPriceStrategy.SpecialAverageIdealPriceStrategy
import theprizypricer.PriceService

// Place your Spring DSL code here
beans = {
    idealPriceStrategy(SpecialAverageIdealPriceStrategy)

    priceService(PriceService) {
        idealPriceStrategy = ref("idealPriceStrategy")
    }
}
