<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<template:admin>
<jsp:attribute name="extraStyles">
<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
<jsp:body>
  <div>
    <div class ="container text-center">
      <h2 class="basic-title">List responsavel</h2>
        <div class="table-responsive">
          <table class="table table-striped table-bordered text-left">
          		  <thead>
	                  <tr>
		                  	<td>Nome</td>
		                  	<td>Data de Nascimento</td>
		                  	<td>Telefone</td>
		                  	<td>E-mail</td>
						 <th></th>
		                    <th></th>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='object'>         		
	                  <tr>
		                  	<td>${object.nome}</td>
		                  	<td><fmt:formatDate pattern="dd/MM/yyyy" value="${object.dataDeNascimento}"/></td>
		                  	<td>${object.telefone}</td>
		                  	<td>${object.email}</td>
							<td><a href="/responsavel/${object.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="/responsavel/remove/${object.id}"><span class="glyphicon glyphicon-trash"></span></a>					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/responsavel"/>
          <a href="<c:url value='/responsavel/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Add New</a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
