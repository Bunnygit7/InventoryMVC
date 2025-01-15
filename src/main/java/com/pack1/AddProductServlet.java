package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		InventoryBean ib=new InventoryBean();
		
		ib.setProductName(req.getParameter("productName"));
		ib.setProductBrand(req.getParameter("productBrand"));
		ib.setGender(req.getParameter("gender"));
		ib.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		ib.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
		ib.setSellingPrice(Integer.parseInt(req.getParameter("sellingPrice")));
		ib.setCategory(req.getParameter("category"));
		ib.setVendor(req.getParameter("vendor"));
		ib.setDescription(req.getParameter("description"));
		
		AddProductDAO apdao=new AddProductDAO();
		int rowCount=apdao.addProduct(ib);
		
		if(rowCount>0)
		{
//			System.out.println("Data enterd Successfully");
			
			req.setAttribute("msg", "Product Stored Successfully!!");
			RequestDispatcher rd=req.getRequestDispatcher("AddProduct.jsp");
			rd.forward(req, res);
		}
		else {
//			System.out.println("Failed to insert data!!");
			
			req.setAttribute("msg", "Failed to insert data!!!");
			RequestDispatcher rd=req.getRequestDispatcher("AddProduct.jsp");
			rd.forward(req, res);
		}
		
	}

}
