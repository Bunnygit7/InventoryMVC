package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dps")
public class DeleteProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		int productId=Integer.parseInt(req.getParameter("productId"));
		
		DeleteProductDAO dpdao=new DeleteProductDAO();
		int rowCount=dpdao.deleteProduct(productId);
		
		if(rowCount>0)
		{
//			System.out.println("Row Deleted Successfully!!");
			
			req.setAttribute("msg", "Product Deleted Successfully!!");
			RequestDispatcher rd=req.getRequestDispatcher("ViewMsg.jsp");
			rd.include(req, res);
		}
		else
		{
//			System.out.println("Failed to Delete!!");
			
			req.setAttribute("msg", "Failed to delete product!!");
			RequestDispatcher rd=req.getRequestDispatcher("ViewMsg.jsp");
			rd.include(req, res);
		}
		
	}

}
