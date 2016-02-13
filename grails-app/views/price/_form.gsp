<%@ page import="theprizypricer.Price" %>



<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="price.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="text" name="amount" required="" value="${fieldValue(bean: priceInstance, field: 'amount')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="price.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${priceInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="price.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${theprizypricer.Product.list()}" optionKey="id" required="" value="${priceInstance?.product?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'store', 'error')} required">
	<label for="store">
		<g:message code="price.store.label" default="Store" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="store" name="store.id" from="${theprizypricer.Store.list()}" optionKey="id" required="" value="${priceInstance?.store?.id}" class="many-to-one"/>
</div>

