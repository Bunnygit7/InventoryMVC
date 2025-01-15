package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO
{
	public int deleteProduct(int productId)
	{
		int rowCount=0;
		try
		{
			Connection con=DBConnect.getConnect();
			PreparedStatement pstmt=con.prepareStatement("delete from inventory where productid=?");
			pstmt.setInt(1, productId);
			
			rowCount=pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

}
