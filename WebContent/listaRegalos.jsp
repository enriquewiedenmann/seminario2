<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.List"
    import = "view.ImagenDTO"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%

List<ImagenDTO> regalos = (List<ImagenDTO>) session.getAttribute("regalos");

for(ImagenDTO img : regalos){
	

	out.print("<img src=\""+img.getNombre()+" \"> Para: ");
	out.println(img.getPara());
}%>





	
	
	
	




</body>
</html>