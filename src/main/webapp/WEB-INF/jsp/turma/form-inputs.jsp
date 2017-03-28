<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="form-group">
	<label class="control-label col-md-3" for="nomeDaTurma">Nome Da Turma</label>
	<div class="col-md-7">
		<form:input class="form-control" path='nomeDaTurma' type='text' />
		<form:errors path='nomeDaTurma' />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-md-3" for="idadeDe">Inicio</label>
	<div class="col-md-7">
		<form:input class="form-control" path='idadeDe' type='text' />
		<form:errors path='idadeDe' />
	</div>
</div>


<div class="form-group">
	<label class="control-label col-md-3" for="idadeAte">Fim</label>
	<div class="col-md-7">
		<form:input class="form-control" path='idadeAte' type='text' />
		<form:errors path='idadeAte' />
	</div>
</div>

