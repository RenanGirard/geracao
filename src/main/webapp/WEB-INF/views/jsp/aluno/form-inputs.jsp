<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label class="control-label col-md-3" for="nome">Nome</label>
	<div class="col-md-7">
		<form:input class="form-control" path='nome' type='text' />
		<form:errors path='nome' />
	</div>
</div>
<div class="form-group">
	<label class="control-label col-md-3" for="sexo">Sexo</label>
	<div class="col-lg-7">
		<span class="input-group-addon"> <form:radiobutton path="sexo"
				value="M" /> <label class="control-label col-md-3" for="sexo">Masculino</label>

		</span> <span class="input-group-addon"> <form:radiobutton path="sexo"
				value="F" /> <label class="control-label col-md-3" for="sexo">Feminino</label>
		</span>
		<form:errors path='sexo' />

		<!-- /input-group -->
	</div>
</div>

<div class="form-group">
	<label class="control-label col-md-3" for="dataDeNascimento">Data
		de Nascimento</label>
	<div class="col-md-7">
		<form:input class="form-control" path='dataDeNascimento' type='date' />
		<form:errors path='dataDeNascimento' />
	</div>
</div>
<div class="form-group">
	<label class="control-label col-md-3" for="turma.id">Turma</label>
	<div class="col-md-7">
		<form:select class="form-control" path='turma.id' items='${turmaList}' itemValue='id'
			itemLabel='nomeDaTurma'>
		</form:select>
		<form:errors path='turma.id' />
	</div>
</div>



