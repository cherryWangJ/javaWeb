package com.pg.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import bean.ComplainMessage;

import com.DB.conn.DataBaseUtil;;

public class complainInfoDao {

	@SuppressWarnings("finally")
	public ArrayList<ComplainMessage> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<ComplainMessage> list=new ArrayList<ComplainMessage>();  
        String sql="select * from complain_message";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	ComplainMessage obj = new ComplainMessage();
                obj.setComplainNo(rs.getInt(1));  
                obj.setComplainName(rs.getString(2));  
                obj.setComplainTime(rs.getString(3));  
                obj.setComplainContent(rs.getString(4));                  
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
	public boolean save(ComplainMessage obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="insert into complain_message values(?,?,?,?)";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setInt(1, obj.getComplainNo());  
            psta.setString(2, obj.getComplainName());  
            psta.setString(3, obj.getComplainTime());  
            psta.setString(4, obj.getComplainContent());               
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
        String sql="delete from complain_message where complainNo=?";  
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
	public boolean update(ComplainMessage obj){  
		System.out.println(obj.toString());
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update complain_message set complainName=?,complainTime=?,complainContent=? where complainNo=?";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);   
            psta.setString(1, obj.getComplainName());  
            psta.setString(2, obj.getComplainTime());   
            psta.setString(3, obj.getComplainContent());  
            psta.setInt(4, obj.getComplainNo()); 
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
