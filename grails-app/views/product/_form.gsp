<%@ page import="theprizypricer.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'barCode', 'error')} required">
	<label for="barCode">
		<g:message code="product.barCode.label" default="Bar Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="barCode" required="" value="${fieldValue(bean: productInstance, field: 'barCode')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${productInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'prices', 'error')} ">
	<label for="prices">
		<g:message code="product.prices.label" default="Prices" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${productInstance?.prices?}" var="p">
    <li><g:link controller="price" action="show" id="${p.id}">${p.amount?.encodeAsHTML()} - ${p.store.name?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="price" action="create" params="['product.id': productInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'price.label', default: 'Price')])}</g:link>
</li>
</ul>

</div>

