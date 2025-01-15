package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RetriveProductServlet")
public class RetriveProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		int productId=Integer.parseInt(req.getParameter("productId"));
		
		RetriveProductDAO rpdao=new RetriveProductDAO();
		InventoryBean ib=rpdao.retriveProduct(productId);
		String pid=Integer.toString(ib.getProductId());
		
		ServletContext context=req.getServletContext();
		context.setAttribute("bean", ib  );
		Cookie c=new Cookie("cName",pid);
		res.addCookie(c);
		
		req.setAttribute("bean", ib);
		req.setAttribute("productId", productId);
		RequestDispatcher rd=req.getRequestDispatcher("EditProduct.jsp");
		
		rd.forward(req, res);
		
		
	}

}
