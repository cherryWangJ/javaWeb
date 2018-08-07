package com.pg.Dao;

import java.sql.*;

import java.util.ArrayList;

import bean.*;

import com.DB.conn.DataBaseUtil;

public class buildInfoDao {
	
	@SuppressWarnings("finally")
	public ArrayList<BuildMessage> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<BuildMessage> list=new ArrayList<BuildMessage>();  
        String sql="select * from build_message";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                BuildMessage obj=new BuildMessage();  
                obj.setBuildNo(rs.getInt(1));  
                obj.setBuildHeight(rs.getString(2));  
                obj.setBuildArea(rs.getString(3));  
                obj.setBuildTime(rs.getString(4));  
                obj.setBuildType(rs.getString(5));                
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
	public boolean save(BuildMessage obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="insert into build_message values(?,?,?,?,?)";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setInt(1, obj.getBuildNo());  
            psta.setString(2, obj.getBuildHeight());  
            psta.setString(3, obj.getBuildArea());  
            psta.setString(4, obj.getBuildTime());  
            psta.setString(5, obj.getBuildType());             
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
        String sql="delete from build_message where buildNo=?";  
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
	public boolean update(BuildMessage obj){  
		System.out.println(obj.toString());
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update build_message set buildHeight=?,buildArea=?,buildTime=?,buildType=? where buildNo=?";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);   
            psta.setString(1, obj.getBuildHeight());  
            psta.setString(2, obj.getBuildArea());   
            psta.setString(3, obj.getBuildTime());  
            psta.setString(4, obj.getBuildType());
            psta.setInt(5, obj.getBuildNo()); 
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
