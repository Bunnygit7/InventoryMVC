package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		InventoryBean ib=new InventoryBean();
		String id=null;
		
		Cookie arr[]=req.getCookies();
		for(Cookie ck:arr)
		{
			if("cName".equals(ck.getName()))
			{
				id=ck.getValue();
			}
		}
		
		
//		System.out.println(id);
		
		ib.setProductName(req.getParameter("productName"));
		ib.setProductBrand(req.getParameter("productBrand"));
		ib.setGender(req.getParameter("gender"));
		ib.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		ib.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
		ib.setSellingPrice(Integer.parseInt(req.getParameter("sellingPrice")));
		ib.setCategory(req.getParameter("category"));
		ib.setVendor(req.getParameter("vendor"));
		ib.setDescription(req.getParameter("description"));
		
//		int productId=(int) req.getAttribute("productId");
		
		EditProductDAO epdao=new EditProductDAO();
		int rowCount=epdao.editproduct(ib,Integer.parseInt(id));
		
		if(rowCount>0)
		{
			
//			System.out.println("Data updated successfully!!");
			
			req.setAttribute("msg", "Data updated successfully!!");
			RequestDispatcher rd=req.getRequestDispatcher("ViewMsg.jsp");
			rd.forward(req, res);
		}
		else
		{
			
//			System.out.println("Data not updated");
			
			req.setAttribute("msg", "Something went wrong Data not updated!!");
			RequestDispatcher rd=req.getRequestDispatcher("ViewMsg.jsp");
			rd.forward(req, res);
		}
		
	}

}
