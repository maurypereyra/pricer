
<%@ page import="theprizypricer.Store" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'store.label', default: 'Store')}" />
		<title>Store List</title>
	</head>
	<body>
		<a href="#list-store" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-store" class="content scaffold-list" role="main">
			<h1>Store List</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'store.name.label', default: 'Name')}" />

						<g:sortableColumn property="address" title="${message(code: 'store.address.label', default: 'Address')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${storeInstanceList}" status="i" var="storeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${storeInstance.id}">${fieldValue(bean: storeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: storeInstance, field: "address")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${storeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
