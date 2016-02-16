package theprizypricer

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import theprizypricer.idealPriceStrategy.SpecialAverageIdealPriceStrategy

@TestFor(ProductController)
@Mock([Product])
class ProductControllerTests {


    def populateValidParams(params) {
        assert params != null

        Store store = new Store(name: "Walmart", address: "USA")
        Product product = new Product(barCode: 1, description: "Honey")
        .addToPrices(store: store, amount: 5, notes: "note1")
        .addToPrices(store: store, amount: 10, notes: "note1")
        .addToPrices(store: store, amount: 10, notes: "note1")
        .addToPrices(store: store, amount: 10, notes: "note1")
        .addToPrices(store: store, amount: 10, notes: "note1")
        .addToPrices(store: store, amount: 30, notes: "note1")


        params["barCode"] = 1
        params["description"] = "Testing description"
        params["notes"] = "A testing note"
        params["prices"] = product.getPrices()
    }

    void testIndex() {
        controller.index()
        assert "/product/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.productInstanceList.size() == 0
        assert model.productInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.productInstance != null
    }

    void testSave() {
        controller.save()

        assert model.productInstance != null
        assert view == '/product/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/product/show/1'
        assert controller.flash.message != null
        assert Product.count() == 1
    }

    void testShow() {
        controller.priceService = new PriceService()
        controller.priceService.idealPriceStrategy = new SpecialAverageIdealPriceStrategy();
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/product/list'


        populateValidParams(params)
        def product = new Product(params)

        assert product.save() != null

        params.id = product.id

        def model = controller.show()

        assertEquals 12.50, flash.averagePrice, 0
        assertEquals 5, flash.lowestPrice, 0
        assertEquals 30, flash.highestPrice, 0
        assertEquals 12, flash.idealPrice, 0
        assertEquals 6, flash.pricesCount, 0


        assert model.productInstance == product
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/product/list'


        populateValidParams(params)
        def product = new Product(params)

        assert product.save() != null

        params.id = product.id

        def model = controller.edit()

        assert model.productInstance == product
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/product/list'

        response.reset()


        populateValidParams(params)
        def product = new Product(params)

        assert product.save() != null

        params.id = product.id
        params.barCode = "BarCode"

        controller.update()

        assert view == "/product/edit"
        assert model.productInstance != null

        product.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/product/show/$product.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/product/list'

        response.reset()

        populateValidParams(params)
        def product = new Product(params)

        assert product.save() != null
        assert Product.count() == 1

        params.id = product.id

        controller.delete()

        assert Product.count() == 0
        assert Product.get(product.id) == null
        assert response.redirectedUrl == '/product/list'
    }
}
