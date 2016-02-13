
<%@ page import="theprizypricer.Price" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'price.label', default: 'Price')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-price" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-price" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="amount" title="${message(code: 'price.amount.label', default: 'Amount')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'price.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'price.dateCreated.label', default: 'Date Created')}" />
					
						<th><g:message code="price.product.label" default="Product" /></th>
					
						<th><g:message code="price.store.label" default="Store" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${priceInstanceList}" status="i" var="priceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${priceInstance.id}">${fieldValue(bean: priceInstance, field: "amount")}</g:link></td>
					
						<td>${fieldValue(bean: priceInstance, field: "notes")}</td>
					
						<td><g:formatDate date="${priceInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: priceInstance, field: "product")}</td>
					
						<td>${fieldValue(bean: priceInstance, field: "store")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${priceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
