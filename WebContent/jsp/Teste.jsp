<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>
			.impar {
				background-color: #f00;
			}
			.par {
				background-color: #0f0;
			}
		</style>
	</head>
	<body>
	 	<%
	 		for(int i = 1;i <= 100; i++){
	 			if(i%2 == 0){
	 				out.println("<p class='par'>"+ i +"</p>");
	 			}else {
	 				out.println("<p class='impar'>"+ i +"</p>");
	 			}
	 		}
	 	%>
	</body>
</html>