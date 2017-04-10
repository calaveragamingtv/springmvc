<script>
  $(document).ready(
	function($) {

		$("#dolarHoy").click(function(event) {

			var usuario = new Object();
			usuario.id = 22;
// 			var data = {}
// 			data["id"] = $("valor").val("22");

			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: "dolarHoy.html",
		             data: JSON.stringify(usuario),
		             timeout: 600000,
		             success: function (data) {
                        alert("Valor dolar: "+data );	                
		             },
		             error: function (e) {
			             alert("Error");
		             }
			});


		});

	});
</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

	<div class="container">
	    <div align="center">
	    	   <a href="reporteUsuario.html" class="btn btn-success">Reportes usuarios</a>
	    	   <button type="button" class="btn btn-warning" id="dolarHoy">Dolar Hoy</button>
	    	   <a href="excepcionUsuario.html" class="btn btn-danger">Forzar Excepcion</a>
	        <h1>Lista de usuarios</h1>

	        <table border="1" class="table table-striped">
	 			<tr>
		            <th>Id</th>
		            <th>Nombre</th>
		            <th>Apellido</th>
		            <th>Accion</th>
	            </tr>
	
	 
	            <c:forEach var="usuario" items="${listUsuarios}">
	                <tr>
	 
	                    <td>${usuario.id}</td>
	                    <td>${usuario.nombre}</td>
	                    <td>${usuario.apellido}</td>
	                    <td>
	                        <div>
	                    	<a href="modifcarUsuario.html?id=${usuario.id}" class="btn">Edit</a>
	                    	<a href="borrarUsuario.html?id=${usuario.id}"   class="btn">Borrar</a>
	                    	</div>
	                    
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
	    <div>
	           <a href="nuevoUsuario.html" class="btn btn-success">Nuevo Usuario</a>
	    </div>
    </div>
