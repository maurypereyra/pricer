<%@ page import="theprizypricer.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'barCore', 'error')} ">
	<label for="barCore">
		<g:message code="product.barCore.label" default="Bar Core" />
		
	</label>
	<g:textField name="barCore" value="${productInstance?.barCore}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${productInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'prices', 'error')} ">
	<label for="prices">
		<g:message code="product.prices.label" default="Prices" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${productInstance?.prices?}" var="p">
    <li><g:link controller="price" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="price" action="create" params="['product.id': productInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'price.label', default: 'Price')])}</g:link>
</li>
</ul>

</div>

