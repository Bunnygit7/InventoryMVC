package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditProductDAO
{
	
	public int editproduct(InventoryBean ib,int productId)
	{
		int rowCount=0;
		try 
		{
			Connection con=DBConnect.getConnect();
			PreparedStatement pstmt=con.prepareStatement(" update inventory set productname=?,productbrand=?,gender=?,quantity=?,productprice=?,sellingprice=?,category=?,vendor=?,DESCRIPTION=? where productid=?");
			
			pstmt.setString(1,ib.getProductName() );
			pstmt.setString(2,ib.getProductBrand() );
			pstmt.setString(3,ib.getGender() );
			pstmt.setInt(4,ib.getQuantity() );
			pstmt.setInt(5,ib.getProductPrice() );
			pstmt.setInt(6,ib.getSellingPrice() );
			pstmt.setString(7,ib.getCategory() );
			pstmt.setString(8,ib.getVendor() );
			pstmt.setString(9,ib.getDescription() );
			pstmt.setInt(10, productId);
			
			rowCount=pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}

}
