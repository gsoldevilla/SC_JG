<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>MANTENIMIENTO DE USUARIOS</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--<link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="css/form.css" type="text/css" rel="stylesheet"/>-->
    </head>
    <body>        
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        
        <form id="form" class="formal" style= "margin: auto; display: table">
            <fieldset>
                <legend>Mantenimiento de Usuarios</legend>    
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>FECHA DE NACIMIENTO</th>
                            <th>EMAIL</th>
                            <th colspan=2 class="text-center">ACCION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td><c:out value="${user.codigo}" /></td>
                                <td><c:out value="${user.nombres}" /></td>
                                <td><c:out value="${user.apellidos}" /></td>
                                <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.fecNac}" /></td>
                                <td><c:out value="${user.email}" /></td>
                                <td><a href="UserController?action=edit&userId=<c:out value="${user.codigo}"/>" class="btn btn-sm btn-info">ACTUALIZAR</a></td>
                                <td><a href="UserController?action=delete&userId=<c:out value="${user.codigo}"/>" class="btn btn-sm btn-danger">ELIMINAR</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p><a href="UserController?action=insert" class="btn btn-sm btn-primary">AGREGAR USUARIO</a></p>
            </fieldset>
        </form>
    </body>
</html>