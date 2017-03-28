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
<script type="text/javascript">
function myFunction() {
	var texto = $(this).val();
	$("#ulItens td").css("display", "block");
	$("#ulItens td").each(function(){
		if($(this).text().indexOf(texto) < 0)
		   $(this).css("display", "none");
	});
}
</script>
  <div>
    <div class ="container text-center">
      <h2 class="basic-title">Lista de Aluno</h2>
            <div class="row">
		      <div class="col-lg-4">
			    <div class="input-group">
			      <input  id="txtBusca" onkeyup="myFunction()" type="text" class="form-control" placeholder="Search for...">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">Go!</button>
			      </span>
			    </div>
			  </div>
		</div>
        <div class="table-responsive ">
  
          <table class="table table-striped table-bordered text-left ">
          		  <thead>
	                  <tr >
		                  	<td>Nome</td>
		                  	<td>Data de Nascimento</td>
						 <th></th>
		                 <th></th>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='object'>         		
	                  <tr  id="ulItens" >
		                  	<td>${object.nome}</td>
		                  	<td><fmt:formatDate pattern="dd/MM/yyyy" value="${object.dataDeNascimento}"/></td>
							<td><a href="/aluno/${object.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="/aluno/remove/${object.id}"><span class="glyphicon glyphicon-trash"></span></a>					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/aluno"/>
          <a href="<c:url value='/aluno/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Add New</a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
