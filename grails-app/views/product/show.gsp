
<%@ page import="theprizypricer.Product" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-product" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list product">
			
				<g:if test="${productInstance?.barCore}">
				<li class="fieldcontain">
					<span id="barCore-label" class="property-label"><g:message code="product.barCore.label" default="Bar Core" /></span>
					
						<span class="property-value" aria-labelledby="barCore-label"><g:fieldValue bean="${productInstance}" field="barCore"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="product.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${productInstance}" field="description"/></span>
					
				</li>
				</g:if>

                <g:if test="${flash.averagePrice}">
                    <li class="fieldcontain">
                        <span id="averagePrice-label" class="property-label"><g:message code="product.description.label" default="Average Price" /></span>

                        <span class="property-value" aria-labelledby="averagePrice-label"> ${flash.averagePrice}</span>

                    </li>
                </g:if>

                <g:if test="${flash.lowestPrice}">
                    <li class="fieldcontain">
                        <span id="lowestPrice-label" class="property-label"><g:message code="product.description.label" default="Lowest Price" /></span>

                        <span class="property-value" aria-labelledby="lowestPrice-label"> ${flash.lowestPrice}</span>

                    </li>
                </g:if>

                <g:if test="${flash.highestPrice}">
                    <li class="fieldcontain">
                        <span id="highestPrice-label" class="property-label"><g:message code="product.description.label" default="Highest Price" /></span>

                        <span class="property-value" aria-labelledby="highestPrice-label"> ${flash.highestPrice}</span>

                    </li>
                </g:if>

                <g:if test="${flash.idealPrice}">
                    <li class="fieldcontain">
                        <span id="idealPrice-label" class="property-label"><g:message code="product.description.label" default="Ideal Price" /></span>

                        <span class="property-value" aria-labelledby="idealPrice-label"> ${flash.idealPrice}</span>

                    </li>
                </g:if>

                <g:if test="${flash.pricesCount}">
                    <li class="fieldcontain">
                        <span id="pricesCount-label" class="property-label"><g:message code="product.description.label" default="Prices Collected" /></span>

                        <span class="property-value" aria-labelledby="pricesCount-label"> ${flash.pricesCount}</span>

                    </li>
                </g:if>
			
				<g:if test="${productInstance?.prices}">
				<li class="fieldcontain">
					<span id="prices-label" class="property-label"><g:message code="product.prices.label" default="Prices" /></span>
					
						<g:each in="${productInstance.prices}" var="p">
						<span class="property-value" aria-labelledby="prices-label"><g:link controller="price" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${productInstance?.id}" />
					<g:link class="edit" action="edit" id="${productInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
