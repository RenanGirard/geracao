<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Listing</title>

  <!-- bootstrap -->
  <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap-theme.min.css'/>">

  <!-- style -->
   <link rel="stylesheet" href="<c:url value='/assets/css/index.css'/>">
   <link rel="stylesheet" href="<c:url value='/assets/css/forms.css'/>">
   <jsp:invoke fragment="extraStyles"/>
</head>

<body>
  
  <!-- INICIO NAV (alterar pra include)-->

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">

        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">Geração Futuro</a>
      </div>

      <div class="collapse navbar-collapse" id="menu">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
            <ul class="dropdown-menu">
	            	              <li><a href="<c:url value='/professor/form'/>"><span class="glyphicon glyphicon-plus-sign"></span> Voluntários</a></li>	              
	              <li><a href="<c:url value='/professor'/>"><span class="glyphicon glyphicon-menu-hamburger"></span> Voluntários</a></li>
				  <li role="separator" class="divider"></li>
	              <li><a href="<c:url value='/aluno/form'/>"><span class="glyphicon glyphicon-plus-sign"></span> Aluno</a></li>	              
	              <li><a href="<c:url value='/aluno'/>"><span class="glyphicon glyphicon-menu-hamburger"></span> Aluno</a></li>
				  <li role="separator" class="divider"></li>
				  <li><a href="<c:url value='/turma/form'/>"><span class="glyphicon glyphicon-plus-sign"></span> Turmas</a></li>	              
	              <li><a href="<c:url value='/turma'/>"><span class="glyphicon glyphicon-menu-hamburger"></span> Turmas</a></li>
				  <li role="separator" class="divider"></li>
				  
				  <li><a href="<c:url value='/responsavel/form'/>"><span class="glyphicon glyphicon-plus-sign"></span> Responsaveis</a></li>	              
	              <li><a href="<c:url value='/responsavel'/>"><span class="glyphicon glyphicon-menu-hamburger"></span> Responsaveis</a></li>
				  <li role="separator" class="divider"></li>
            </ul>
          </li>
        </ul>
        
      </div>
    </div>
  </nav>

  <!-- FINAL NAV -->
	<jsp:doBody />

<script src="<c:url value='/assets/js/jquery-2.1.4.min.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
<jsp:invoke fragment="extraScripts"/>

</body>
</html>