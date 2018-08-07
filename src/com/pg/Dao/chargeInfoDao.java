package com.pg.Dao;

import java.sql.*;

import java.util.ArrayList;

import bean.Chargemessage;

import com.DB.conn.*;
public class chargeInfoDao {

	@SuppressWarnings("finally")
	public ArrayList<Chargemessage> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<Chargemessage> list=new ArrayList<Chargemessage>();  
        String sql="select * from charge_message";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                Chargemessage obj=new Chargemessage();  
                obj.setChargeNo(rs.getInt(1));  
                obj.setChargeName(rs.getString(2));  
                obj.setChargeNumber(rs.getString(3));  
                obj.setChargeUser(rs.getString(4));  
                obj.setChargeTime(rs.getString(5));
                obj.setChargeContent(rs.getString(6));
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
	public boolean save(Chargemessage obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="insert into charge_message values(?,?,?,?,?,?)";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setInt(1, obj.getChargeNo());  
            psta.setString(2, obj.getChargeName());  
            psta.setString(3, obj.getChargeNumber());  
            psta.setString(4, obj.getChargeUser());  
            psta.setString(5, obj.getChargeTime());
            psta.setString(6, obj.getChargeContent());
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
        String sql="delete from charge_message where chargeNo=?";  
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
	public boolean update(Chargemessage obj){  
		System.out.println(obj.toString());
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update charge_message set chargeName=?,chargeNumber=?,chargeUser=?,chargeTime=?,chargeContent=? where chargeNo=?";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);   
            psta.setString(1, obj.getChargeName());  
            psta.setString(2, obj.getChargeNumber());   
            psta.setString(3, obj.getChargeUser());  
            psta.setString(4, obj.getChargeTime());
            psta.setString(5, obj.getChargeContent());
            psta.setInt(6, obj.getChargeNo()); 
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
