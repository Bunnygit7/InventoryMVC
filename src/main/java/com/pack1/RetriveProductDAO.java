package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetriveProductDAO
{

	public InventoryBean retriveProduct(int productId)
	{
//		ArrayList<InventoryBean> al=new ArrayList<InventoryBean>();
		
		InventoryBean ib=null;
		
		try 
		{
			Connection con=DBConnect.getConnect();
			PreparedStatement pstmt=con.prepareStatement("select * from inventory where productid=?");
			pstmt.setInt(1, productId);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				ib=new InventoryBean();
				
				ib.setProductId(productId);
				ib.setProductName(rs.getString(2));
				ib.setProductBrand(rs.getString(3));
				ib.setGender(rs.getString(4));
				ib.setQuantity(rs.getInt(5));
				ib.setProductPrice(rs.getInt(6));
				ib.setSellingPrice(rs.getInt(7));
				ib.setCategory(rs.getString(8));
				ib.setVendor(rs.getString(9));
				ib.setDescription(rs.getString(10));
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return ib;
	}

}
