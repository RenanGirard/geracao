<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
<jsp:attribute name="extraStyles">
<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
<jsp:body>
  <div>
    <div class =" container text-center">
      <h2 class="basic-title">Lista das Turmas</h2>
        <div class="table-responsive">
          <table class="table table-striped table-bordered text-left">
          		  <thead>
	                  <tr>
		                  	<th>Nome da turma</th>
		                  	<th>Inicio</th>
		                  	<th>Fim</th>
		                    <th></th>
		                    <th></th>
						
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='object'>         		
	                  <tr>
		                  	<td>${object.nomeDaTurma}</td>
		                  	<td>${object.idadeDe}</td>
		                  	<td>${object.idadeAte}</td>
		                  	<td><a href="/turma/${object.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="/turma/remove/${object.id}"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
	                   
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/turma"/>
          <a href="<c:url value='/turma/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Adicionar</a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
