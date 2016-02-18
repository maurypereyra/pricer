package pages.store

class PriceData {
    static def stores = [
            [id: 1, name: "Carrefour", address: "USA"],
            [id: 2, name: "Walmart", address: "USA"],
            [id: 3, name: "Market01", address: "USA"],
            [id: 4, name: "Market02", address: "USA"]
    ]

    static def products = [
            [id: 1, barCode: 1, description: "Honey"],
            [id: 2, barCode: 2, description: "Butter"],
            [id: 3, barCode: 3, description: "Milk"],
            [id: 4, barCode: 4, description: "Cereals"]
    ]

    static public def findByStoreName(String storeName) {
        stores.find { store ->
            store.name == storeName
        }
    }

    static public def findByProductName(String productName) {
        stores.find { product ->
            product.description == productName
        }
    }
}
