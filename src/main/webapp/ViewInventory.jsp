<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.InventoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack1.ViewInventoryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>
<%
ArrayList<InventoryBean> inventory=(ArrayList<InventoryBean>)request.getAttribute("inventory");

if(inventory.size()==0)
{
	out.println("Data not found");
}
else
{
	Iterator<InventoryBean> i=inventory.iterator();
	while(i.hasNext())
	{
		InventoryBean ib=i.next();
		out.println(ib.getProductId()+" | "+ib.getProductName()+" | "+ib.getProductBrand()+" | "+ib.getGender()+" | "+ib.getQuantity()+" | "+ib.getProductPrice()+" | "+ib.getSellingPrice()+" | "+ib.getCategory()+" | "+ib.getVendor()+" | "+ib.getDescription()+" | <a href='RetriveProductServlet?productId="+ib.getProductId()+"'>Edit</a>/<a href='dps?productId="+ib.getProductId()+"'>Delete</a> |<br>");
		out.println("----------------------------------------------------------------------------------------------------------------------------------<br>");
	}
}
%>

</body>
</html>