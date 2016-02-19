import theprizypricer.Price
import theprizypricer.Product
import theprizypricer.Store

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                def store01 = new Store(name: "Carrefour", address: "USA").save()
                def store02 = new Store(name: "Walmart", address: "USA").save()

                def product01 = new Product(barCode: 1, description: "Honey").save()
                def product02 = new Product(barCode: 2, description: "Butter").save()

                new Price(product: product01, store: store01, amount: 5, notes: "note1").save()
                new Price(product: product01, store: store02, amount: 10, notes: "note1").save()
                new Price(product: product01, store: store01, amount: 15, notes: "note1").save()
                new Price(product: product01, store: store02, amount: 20, notes: "note1").save()
                new Price(product: product01, store: store01, amount: 25, notes: "note1").save()
                new Price(product: product01, store: store02, amount: 30, notes: "note1").save()
                new Price(product: product02, store: store01, amount: 5, notes: "note1").save()
                new Price(product: product02, store: store02, amount: 4, notes: "note1").save()
            }

            test {
                def store01 =new Store(name: "Carrefour", address: "USA").save()
                def store02 = new Store(name: "Walmart", address: "USA").save()
                new Store(name: "Market01", address: "USA").save()
                new Store(name: "Market02", address: "USA").save()

                def product01 = new Product(barCode: 1, description: "Honey").save()
                def product02 = new Product(barCode: 2, description: "Butter").save()
                new Product(barCode: 3, description: "Milk").save()
                new Product(barCode: 4, description: "Cereals").save()

                new Price(product: product01, store: store01, amount: 5, notes: "Testing Note").save()
                new Price(product: product01, store: store02, amount: 10, notes: "Testing Note").save()
                new Price(product: product01, store: store01, amount: 15, notes: "Testing Note").save()
                new Price(product: product01, store: store02, amount: 20, notes: "Testing Note").save()
                new Price(product: product01, store: store01, amount: 25, notes: "Testing Note").save()
                new Price(product: product01, store: store02, amount: 30, notes: "Testing Note").save()
                new Price(product: product02, store: store01, amount: 5, notes: "Testing Note").save()
                new Price(product: product02, store: store02, amount: 4, notes: "Testing Note").save()
            }
        }
    }
    def destroy = {
    }
}
