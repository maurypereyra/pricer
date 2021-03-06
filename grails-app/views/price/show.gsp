
<%@ page import="theprizypricer.Price" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'price.label', default: 'Price')}" />
		<title>Show Price</title>
	</head>
	<body>
		<a href="#show-price" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-price" class="content scaffold-show" role="main">
			<h1>Show Price</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list price">
			
				<g:if test="${priceInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="price.amount.label" default="Amount" /></span>
					
						<span id="amount-value" class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${priceInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${priceInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="price.notes.label" default="Notes" /></span>
					
						<span id="notes-value" class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${priceInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${priceInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="price.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${priceInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${priceInstance?.product}">
				<li class="fieldcontain">
					<span id="product-label" class="property-label"><g:message code="price.product.label" default="Product" /></span>

						<span id="product-value" class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show" id="${priceInstance?.product?.id}">${priceInstance?.product.description?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>
			
				<g:if test="${priceInstance?.store}">
				<li class="fieldcontain">
					<span id="store-label" class="property-label"><g:message code="price.store.label" default="Store" /></span>
					
						<span id="store-value" class="property-value" aria-labelledby="store-label"><g:link controller="store" action="show" id="${priceInstance?.store?.id}">${priceInstance?.store.name?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${priceInstance?.id}" />
					<g:link class="edit" action="edit" id="${priceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
