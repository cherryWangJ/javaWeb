package com.pg.Dao;

import java.sql.*;

import java.util.ArrayList;

import bean.RoomMessage;

import com.DB.conn.DataBaseUtil;

public class roomInfoDao {

	@SuppressWarnings("finally")
	public ArrayList<RoomMessage> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<RoomMessage> list=new ArrayList<RoomMessage>();  
        String sql="select * from room_message";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                RoomMessage obj=new RoomMessage();  
                obj.setRoomNo(rs.getString(1));  
                obj.setUserName(rs.getString(2));  
                obj.setBuildNo(rs.getInt(3));  
                obj.setRoomArea(rs.getString(4));  
                obj.setRoomType(rs.getString(5));  
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
	public boolean save(RoomMessage obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="insert into room_message values(?,?,?,?,?)";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, obj.getRoomNo());  
            psta.setString(2, obj.getUserName());  
            psta.setInt(3, obj.getBuildNo());    
            psta.setString(4, obj.getRoomArea());  
            psta.setString(5, obj.getRoomType());  
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
	public boolean remove(String id){  
        Connection con=null;  
        PreparedStatement psta=null;  
        boolean flag=false;  
        String sql="delete from room_message where roomNo=?";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, id);  
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
	public boolean update(RoomMessage obj){  
		System.out.println(obj.toString());
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update room_message set userName=?,buildNo=?,roomArea=?,roomType=? where roomNo=?";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, obj.getUserName());  
            psta.setInt(2, obj.getBuildNo());  
            psta.setString(3, obj.getRoomArea());  
            psta.setString(4, obj.getRoomType());;  
            psta.setString(5, obj.getRoomNo());  
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
