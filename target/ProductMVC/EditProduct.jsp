<%@page import="com.pack1.InventoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
InventoryBean ib=(InventoryBean)request.getAttribute("bean");
//int productId=(int)request.getAttribute("productId");


%>

<center><h1>

	<form action="EditProductServlet" method="POST">
	
	    productName:<input type="text" name="productName" value=<%=ib.getProductName() %>><br>
	    productBrand:<input type="text" name="productBrand" value=<%=ib.getProductBrand() %>><br>
	    Gender:<br>
	    male:<input type="radio" name="gender" value="male" <%= (ib.getGender().equals("male")?"checked":"") %>>
	    Female:<input type="radio" name="gender" value="female" <%= (ib.getGender().equals("female")?"checked":"") %>>
	    Unisex:<input type="radio" name="gender" value="unisex" <%= (ib.getGender().equals("unisex")?"checked":"") %>><br>
	    Quantity:<input type="number" name="quantity" value=<%=ib.getQuantity() %>><br>
	    productPrice:<input type="number" name="productPrice" value=<%=ib.getProductPrice() %>><br>
	    sellingPrice:<input type="number" name="sellingPrice" value=<%=ib.getSellingPrice() %>><br>
	    category:<input type="text" name="category" value=<%=ib.getCategory() %>><br>
	    vendor:<input type="text" name="vendor" value=<%=ib.getVendor() %>><br>
	    description:<textarea name="description" rows="5" ><%=ib.getDescription() %></textarea><br>
		<input type="submit" value="Update">
	    
	</form>

</body>
</html>