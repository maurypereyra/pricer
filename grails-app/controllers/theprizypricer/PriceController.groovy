package theprizypricer

import org.springframework.dao.DataIntegrityViolationException

class PriceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [priceInstanceList: Price.list(params), priceInstanceTotal: Price.count()]
    }

    def create() {
        [priceInstance: new Price(params)]
    }

    def save() {
        def priceInstance = new Price(params)
        if (!priceInstance.save(flush: true)) {
            render(view: "create", model: [priceInstance: priceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'price.label', default: 'Price'), priceInstance.id])
        redirect(action: "show", id: priceInstance.id)
    }

    def show() {
        def priceInstance = Price.get(params.id)
        if (!priceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'price.label', default: 'Price'), params.id])
            redirect(action: "list")
            return
        }
        [priceInstance: priceInstance]
    }

    def edit() {
        def priceInstance = Price.get(params.id)
        if (!priceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'price.label', default: 'Price'), params.id])
            redirect(action: "list")
            return
        }

        [priceInstance: priceInstance]
    }

    def update() {
        def priceInstance = Price.get(params.id)
        if (!priceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'price.label', default: 'Price'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (priceInstance.version > version) {
                priceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'price.label', default: 'Price')] as Object[],
                        "Another user has updated this Price while you were editing")
                render(view: "edit", model: [priceInstance: priceInstance])
                return
            }
        }

        priceInstance.properties = params

        if (!priceInstance.save(flush: true)) {
            render(view: "edit", model: [priceInstance: priceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'price.label', default: 'Price'), priceInstance.id])
        redirect(action: "show", id: priceInstance.id)
    }

    def delete() {
        def priceInstance = Price.get(params.id)
        if (!priceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'price.label', default: 'Price'), params.id])
            redirect(action: "list")
            return
        }

        try {
            priceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'price.label', default: 'Price'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'price.label', default: 'Price'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
