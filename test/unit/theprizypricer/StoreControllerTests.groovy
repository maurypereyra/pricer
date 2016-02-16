package theprizypricer

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(StoreController)
@Mock(Store)
class StoreControllerTests {


    def populateValidParams(params) {
        assert params != null

        params["name"] = "Walmart"
        params["address"] = "USA"
    }

    void testIndex() {
        controller.index()
        assert "/store/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.storeInstanceList.size() == 0
        assert model.storeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.storeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.storeInstance != null
        assert view == '/store/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/store/show/1'
        assert controller.flash.message != null
        assert Store.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/store/list'


        populateValidParams(params)
        def store = new Store(params)

        assert store.save() != null

        params.id = store.id

        def model = controller.show()

        assert model.storeInstance == store
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/store/list'


        populateValidParams(params)
        def store = new Store(params)

        assert store.save() != null

        params.id = store.id

        def model = controller.edit()

        assert model.storeInstance == store
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/store/list'

        response.reset()


        populateValidParams(params)
        def store = new Store(params)

        assert store.save() != null

        params.id = store.id
        params.name = new Store()

        controller.update()

        assert view == "/store/edit"
        assert model.storeInstance != null

        store.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/store/show/$store.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/store/list'

        response.reset()

        populateValidParams(params)
        def store = new Store(params)

        assert store.save() != null
        assert Store.count() == 1

        params.id = store.id

        controller.delete()

        assert Store.count() == 0
        assert Store.get(store.id) == null
        assert response.redirectedUrl == '/store/list'
    }
}
