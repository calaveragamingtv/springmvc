<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <div class="container">
        <h1>Nuevo/Editar Usuario</h1>
        <form:form action="guardarUsuario.html" method="post" modelAttribute="usuario">
  
            <form:hidden path="id"/>

             <div class="form-group">
                 <label for="nombre" ><spring:message code="usuario.nombre"/></label>
            	 <form:input path="nombre" class="form-control" id="nombre"/>
                 <font color="red"><form:errors path="nombre" cssClass="error"/></font>
              </div>

            <div class="form-group">
                <label for="apellido" >Apellido</label>
                <form:input path="apellido" class="form-control" id="apellido"/>
                	<font color="red"><form:errors path="apellido" cssClass="error"/></font>
			</div>

           
                <td colspan="2" align="center"><input type="submit" class="btn btn-success" value="Save"></td>
 

        </form:form>
    </div>
