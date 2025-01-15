package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO
{
	
	
	public int addProduct(InventoryBean ib)
	{
		int rowCount=0;
		
		try
		{
			Connection con=DBConnect.getConnect();
			PreparedStatement pstmt=con.prepareStatement("insert into inventory (productname,productbrand,gender,quantity,productprice,sellingprice,category,vendor,description) values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,ib.getProductName() );
			pstmt.setString(2,ib.getProductBrand() );
			pstmt.setString(3,ib.getGender() );
			pstmt.setInt(4,ib.getQuantity() );
			pstmt.setInt(5,ib.getProductPrice() );
			pstmt.setInt(6,ib.getSellingPrice() );
			pstmt.setString(7,ib.getCategory() );
			pstmt.setString(8,ib.getVendor() );
			pstmt.setString(9,ib.getDescription() );
			
			rowCount=pstmt.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
		
	}

}
