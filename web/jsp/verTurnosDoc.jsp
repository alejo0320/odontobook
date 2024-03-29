<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.util.*, edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.*"%>
<head>
  <link href="css/custom-theme/jquery-ui-1.8.1.custom.css" rel="stylesheet" type="text/css"/>
  <link rel="icon" type="image/png" href="/img/logo.png" />
  <script src="jquery/js/jquery-1.4.2.min.js"></script>
  <script src="jquery/js/jquery-ui-1.8.1.custom.min.js"></script>
  
  <script>
  $(document).ready(function() {
	
    $("#datepicker").datepicker();
	$( ".selector" ).datepicker( "option", "dayNamesMin", ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'] );

  });
  
  function doIt(){
	var txt = document.getElementById("datepicker");
	if(txt.value != ""){
		document.turnoForm.submit();
	}
  }
  
  </script>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Odontobook</title>

</head>

<body>
<%  
	ResourceBundle bubdle = Bundle.getBundle(); %>
<div align="right">
      <%@include file="/jsp/menu.jsp" %>
</div>

<table id="tablaPrincipal">
<th></th>
<th id="thMedio"></th>
<th></th>
<tr>
<td valign="top">

<%@include file="/jsp/lista.jsp" %>

</td>
<td></td>
<td id="tdLista" valign="top">

<div align="center">
<p>
<form name="turnoForm" method="POST" action="SeleccionarVerTurno.do" >

<input type="text" name="datepicker" id="datepicker" />
<input id="buttonSubmit" type = "button" onClick="doIt()"  value=<%= bubdle.getString("buscar")%> />

</form>
</p>
</div>


<% List<Turno> lis = (List)request.getAttribute("lista");%>

<div align="center">
<p>
<table id="tabD">

<tr >
<th> <%= bubdle.getString("fecha")%>  </th>
<th> <%= bubdle.getString("hora")%> </th>
<th> <%= bubdle.getString("paciente")%></th>
</tr>
<%if (lis != null){ 
 for (int i = 0; i < lis.size(); i++){ %>
<tr>
<td> <%=  request.getAttribute("fecha") %> </td>
<td> <%= lis.get(i).hora() +":"+lis.get(i).minutos() %> </td>
<td> <%= lis.get(i).getPaciente().getNombre()+" "+lis.get(i).getPaciente().getApellido() %> </td>
</tr>
<%}}%>

</table>
</p>
</div>
</td>
</tr>
</table>
</body>
</html>
