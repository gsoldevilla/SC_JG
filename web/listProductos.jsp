<%-- 
    Document   : listProductos
    Created on : 22/07/2017, 07:35:51 PM
    Author     : Java-Sab
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID CATEGORIA</th>
                    <th>ID SUB CATEGORIA</th>
                    <th>DESCRIPCION</th>                                        
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productos}" var="producto">
                    <tr>
                        <td><c:out value="${producto.id}" /></td>
                        <td><c:out value="${producto.idCategoria}" /></td>
                        <td><c:out value="${producto.idSubCategoria}" /></td>
                        <td><c:out value="${producto.descripcion}" /></td>                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
