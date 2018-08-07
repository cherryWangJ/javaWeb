package com.pg.Dao;

import java.sql.*;

import java.util.ArrayList;

import bean.UserMessage;

import com.DB.conn.DataBaseUtil;


public class userInfoDao {
	
	@SuppressWarnings("finally")
	public ArrayList<UserMessage> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<UserMessage> list=new ArrayList<UserMessage>();  
        String sql="select * from user_message";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                UserMessage obj=new UserMessage();  
                obj.setUser_Id(rs.getInt(1));  
                obj.setUserName(rs.getString(2));  
                obj.setUserPassword(rs.getString(3));  
                obj.setAge(rs.getString(4));  
                obj.setBuildNo(rs.getInt(5));  
                obj.setRoomNo(rs.getString(6));  
                obj.setTelPhone(rs.getString(7)); 
                obj.setUserOrAdmin(rs.getString(8));
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
	public boolean save(UserMessage obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="insert into user_message values(null,?,?,?,?,?,?,?)";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, obj.getUserName());  
            psta.setString(2, obj.getUserPassword());  
            psta.setString(3, obj.getAge()+"");  
            psta.setInt(4, obj.getBuildNo());  
            psta.setString(5, obj.getRoomNo());  
            psta.setString(6, obj.getTelPhone());
            psta.setString(7, obj.getUserOrAdmin());  
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
        String sql="delete from user_message where user_Id=?";  
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
	public ArrayList<UserMessage> findByName(String userName){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;
        ArrayList<UserMessage> list1=new ArrayList<UserMessage>();
        String sql="select * from user_message where userName=?";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, userName);  
            rs=psta.executeQuery();  
            if(rs.next()){  
                 UserMessage obj=new UserMessage();
                obj.setUser_Id(rs.getInt(1));
                obj.setUserName(rs.getString(2));  
                obj.setUserPassword(rs.getString(3));  
                obj.setAge(rs.getString(4));  
                obj.setBuildNo(rs.getInt(5));  
                obj.setRoomNo(rs.getString(6));  
                obj.setTelPhone(rs.getString(7));
                obj.setUserOrAdmin(rs.getString(8));
                list1.add(obj);
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                DataBaseUtil.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return list1;  
        }  
    } 
	
	@SuppressWarnings("finally")
	public boolean update(UserMessage obj){  
		System.out.println(obj.toString());
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update user_message set userName=?,userPassword=?,age=?,buildNo=?,roomNo=?,telPhone=?,userOrAdmin=? where user_Id=?";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, obj.getUserName());  
            psta.setString(2, obj.getUserPassword());  
            psta.setString(3, obj.getAge()+"");  
            psta.setInt(4, obj.getBuildNo());  
            psta.setString(5, obj.getRoomNo());  
            psta.setString(6, obj.getTelPhone());  
            psta.setString(7,obj.getUserOrAdmin());
            psta.setInt(8,obj.getUser_Id());
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
