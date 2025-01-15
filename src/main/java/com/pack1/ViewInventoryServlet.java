package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ViewInventoryServlet")
public class ViewInventoryServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		ViewInventoryDAO vidao=new ViewInventoryDAO();
		ArrayList<InventoryBean> inventory=vidao.viewInventory();
		
		
		
		req.setAttribute("inventory", inventory);
		RequestDispatcher rd=req.getRequestDispatcher("ViewInventory.jsp");
		rd.forward(req, res);
		
	}

	
	

}
