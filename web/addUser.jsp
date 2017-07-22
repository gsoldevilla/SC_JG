<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <script type="text/javascript" src="js/Javascript1.js" ></script>
        
        <title>Add new user</title>
        <!--<link href="css/main.css" type="text/css" rel="stylesheet"/>-->
        <!--<link href="css/form.css" type="text/css" rel="stylesheet"/>-->
        
    </head>
    <body>        
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        
        <script>
            $(function () {
                $('input[name=dob]').datepicker();
            });
        </script>

        <form method="POST" action='UserController' name="frmAddUser" id="form" class="formal" style= "margin: auto; display: table">
            <fieldset>
                <legend>Agregar Usuario</legend>
                <table class="table table-striped">        
                    <tbody>            
                        <!--<tr>                
                            <td>CODIGO DE USUARIO</td>                        
                            <td><input type="text" readonly="readonly" name="userid" /> 
                            </td>                        
                        </tr>-->
                        <tr>
                            <td>NOMBRES</td>
                            <td><input type="text" name="firstName" required class="form-control"/> 
                            </td>                        
                        </tr>
                        <tr>
                            <td>APELLIDOS</td>
                            <td><input type="text" name="lastName" required class="form-control"/> 
                            </td>                        
                        </tr>
                        <tr>
                            <td>FECHA NACIMIENTO</td>
                            <td><input type="text" name="dob" required class="form-control"/> 
                            </td>                        
                        </tr>
                        <tr>
                            <td>EMAIL</td>
                            <td><input type="text" name="email" required class="form-control"/>
                            </td>                        
                        </tr>
                        <tr>
                            <td>DEPARTAMENTO</td>
                            <td><select id="cboDepartamento" name="codigoDep" required class="form-control">
                                    <option value="">[Seleccione el Departamento]</option>                                    
                                    <c:forEach items="${departamentos}" var="departamento"> <!--com.servlets - SessionListener-->
                                        <option value="${departamento.codigo}">${departamento.nombre}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>PROVINCIA</td>
                            <td><select id="cboProvincia" name="codigoProv" required class="form-control"> 
                                    <option value="">[Seleccione la Provincia]</option>                                    
                                    <c:forEach items="${provincias}" var="provincia"> <!--com.servlets - SessionListener-->
                                        <option value="${provincia.codigo}#${provincia.codigoDep}" hidden>${provincia.nombre}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>DISTRITO</td>
                            <td><select id="cboDistrito" name="codigoDis" required class="form-control">
                                    <option value="">[Seleccione el Distrito]</option>
                                    <c:forEach items="${distritos}" var="distrito"> <!--com.servlets - SessionListener-->
                                        <option value="${distrito.codigo}#${distrito.codigoDep}#${distrito.codigoProv}" hidden>${distrito.nombre}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan=2 align="center"> 
                                <input type="submit" value="ACEPTAR" class="btn btn-sm btn-primary" />
                            </td>                                     
                        </tr>

                    </tbody>
                </table>
            </fieldset>
        </form>
    </body>
</html>