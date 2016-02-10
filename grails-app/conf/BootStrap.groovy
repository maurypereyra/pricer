import theprizypricer.Price
import theprizypricer.Product
import theprizypricer.Store

class BootStrap {

    def init = { servletContext ->
        def store01 = new Store(name: "Carrefour", address: "USA").save()
        def store02 = new Store(name: "Walmart", address: "USA").save()

        def product01 = new Product(barCore: 1, description: "Honey").save()
        def product02 = new Product(barCore: 2, description: "Butter").save()

        new Price(product: product01, store: store01, amount: 5, notes: "note1").save()
        new Price(product: product01, store: store02,amount: 10, notes: "note1").save()
        new Price(product: product01, store: store01, amount: 15, notes: "note1").save()
        new Price(product: product01, store: store02,amount: 20, notes: "note1").save()
        new Price(product: product01, store: store01, amount: 25, notes: "note1").save()
        new Price(product: product01, store: store02,amount: 30, notes: "note1").save()
        new Price(product: product02, store: store01,amount: 5, notes: "note1").save()
        new Price(product: product02, store: store02,amount: 4, notes: "note1").save()
    }
    def destroy = {
    }
}
