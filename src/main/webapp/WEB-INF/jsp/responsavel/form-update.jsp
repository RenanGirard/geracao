<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
  <div>
    <div class ="container text-center">      
    <h2 class="basic-title">Add</h2>
      <form:form role="form" class="form-horizontal" commandName="responsavel" servletRelativeAction="/responsavel/${responsavel.id}" method="POST">
		
		<%@include file="form-inputs.jsp" %>
        <button type="submit" class="btn btn-primary">Submit</button>

      </form:form>	
    </div>
  </div>
</template:admin>
