<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center><h1>
	<form action="aps" method="POST">
	    productName:<input type="text" name="productName"><br>
	    productBrand:<input type="text" name="productBrand"><br>
	    Gender:<br>
	    male:<input type="radio" name="gender" value="male">
	    Female:<input type="radio" name="gender" value="female">
	    Unisex:<input type="radio" name="gender" value="unisex"><br>
	    Quantity:<input type="number" name="quantity"><br>
	    productPrice:<input type="number" name="productPrice"><br>
	    sellingPrice:<input type="number" name="sellingPrice"><br>
	    category:<input type="text" name="category"><br>
	    vendor:<input type="text" name="vendor"><br>
	    description:<textarea name="description" rows="5"></textarea><br>
		<input type="submit">
	    
	</form>
	
	
	<a href="ViewInventoryServlet">View inventory</a>

</body>
</html>