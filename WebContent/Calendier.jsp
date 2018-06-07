<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="java.util.ArrayList" %>
	<%@page import="Model.date" %>
	<%@page import="Model.Fonctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%request.setAttribute("calendrier",Fonctions.listesdatesdispo(1)); %>

<%-- <table border="1">
	
    
    
  
  <%for(int i=1;i<=calendrier.size();i+=4){ %>
  <tr >
  <th colspan="4"><%out.print(calendrier.get(i).getDate()); %></th>
  </tr>
  <tr>
    <td>
    <form action="">
    <input type="hidden" name="date" value=<%=calendrier.get(i-1).getDate() %>>
    <input type="submit" name="heure" value=<%=calendrier.get(i-1).getHeur()%>>
    </form>
    </td>
    <td>
    <form action="">
    <input type="hidden" name="date" value=<%=calendrier.get(i).getDate() %>>
    <input type="submit" name="heure" value=<%=calendrier.get(i).getHeur()%>>
    </form>
    </td>
    <td>
    <form action="">
    <input type="hidden" name="date" value=<%=calendrier.get(i+1).getDate() %>>
    <input type="submit" name="heure" value=<%=calendrier.get(i+1).getHeur()%>>
    </form>
    </td>
    <td>
    <form action="">
    <input type="hidden" name="date" value=<%=calendrier.get(i+2).getDate() %>>
    <input type="submit" name="heure" value=<%=calendrier.get(i+2).getHeur()%>>
    </form>
    </td>
  </tr>
  
  <%} %>
  
</table> --%>

<table border="1">
	
    
    
  
  <c:forEach items="${calendrier}" var="date">
  <tr>
  <th>${date.getDate()}</th>
  </tr>
  <tr>
    <td>
    <form action="">
    <input type="hidden" name="date" value="${date.getHeur()}">
    <input type="submit" name="heure" value="${date.getHeur()}">
    </form>
    </td>
  </tr>
  
  </c:forEach>
  
</table>


</body>
</html>