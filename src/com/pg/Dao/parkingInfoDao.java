package com.pg.Dao;

import java.sql.*;

import java.util.ArrayList;

import bean.ParkingMessage;

import com.DB.conn.DataBaseUtil;

public class parkingInfoDao {

	@SuppressWarnings("finally")
	public ArrayList<ParkingMessage> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<ParkingMessage> list=new ArrayList<ParkingMessage>();  
        String sql="select * from parking_message";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                ParkingMessage obj=new ParkingMessage();  
                obj.setParkingNo(rs.getInt(1)); 
                obj.setParkingArea(rs.getString(2));
                obj.setUserName(rs.getString(3));  
                obj.setCarType(rs.getString(4));    
                obj.setCarNumber(rs.getString(5));    
                obj.setTelPhone(rs.getString(6)); 
                list.add(obj);  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                DataBaseUtil.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return list;  
        }  
    }
	
	@SuppressWarnings("finally")
	public boolean save(ParkingMessage obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="insert into parking_message values(?,?,?,?,?,?)";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setInt(1, obj.getParkingNo());  
            psta.setString(2, obj.getParkingArea());  
            psta.setString(3, obj.getUserName());   
            psta.setString(4, obj.getCarType());  
            psta.setString(5, obj.getCarNumber());
            psta.setString(6, obj.getTelPhone());  
            flag=psta.executeUpdate()>0;  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                DataBaseUtil.close(null, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return flag;  
        }  
    }
	
	@SuppressWarnings("finally")
	public boolean remove(int id){  
        Connection con=null;  
        PreparedStatement psta=null;  
        boolean flag=false;  
        String sql="delete from parking_message where parkingNo=?";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setInt(1, id);  
            flag=psta.executeUpdate()>0;  
        }catch(Exception e){  
            e.printStackTrace();  
            
        }finally{  
            try{  
                DataBaseUtil.close(null, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return flag;  
        }  
    }
	
	@SuppressWarnings("finally")
	public boolean update(ParkingMessage obj){  
		System.out.println(obj.toString());
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update parking_message set parkingArea=?,userName=?,carType=?,carNumber=?,telPhone=? where parkingNo=?";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, obj.getParkingArea());  
            psta.setString(2, obj.getUserName());    
            psta.setString(3, obj.getCarType());  
            psta.setString(4, obj.getCarNumber());  
            psta.setString(5, obj.getTelPhone());  
            psta.setInt(6,obj.getParkingNo());
            flag=psta.executeUpdate()>0;  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                DataBaseUtil.close(null, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return flag;  
        }  
    }  

}
