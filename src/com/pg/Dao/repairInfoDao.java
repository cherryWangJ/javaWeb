package com.pg.Dao;

import java.sql.*;

import java.util.ArrayList;

import bean.RepairMessage;

import com.DB.conn.*;

public class repairInfoDao {

	@SuppressWarnings("finally")
	public ArrayList<RepairMessage> findAll(){  
        Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList<RepairMessage> list=new ArrayList<RepairMessage>();  
        String sql="select * from repair_message";  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                RepairMessage obj=new RepairMessage();  
                obj.setRepairNo(rs.getInt(1));  
                obj.setRepairName(rs.getString(2));  
                obj.setBuildNo(rs.getInt(3));  
                obj.setRoomNo(rs.getString(4));  
                obj.setRepairTime(rs.getString(5));
                obj.setRepairContent(rs.getString(6));
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
	public boolean save(RepairMessage obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="insert into repair_message values(?,?,?,?,?,?)";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setInt(1, obj.getRepairNo());  
            psta.setString(2, obj.getRepairName());  
            psta.setInt(3, obj.getBuildNo());  
            psta.setString(4, obj.getRoomNo());  
            psta.setString(5, obj.getRepairTime());
            psta.setString(6, obj.getRepairContent());
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
        String sql="delete from repair_message where repairNo=?";  
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
	public boolean update(RepairMessage obj){
		System.out.println(obj.toString());
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update repair_message set repairName=?,buildNo=?,roomNo=?,repairTime=?,repairContent=? where repairNo=?";  
        boolean flag=false;  
        try{  
            con=DataBaseUtil.getConnection();  
            psta=con.prepareStatement(sql);   
            psta.setString(1, obj.getRepairName());  
            psta.setInt(2, obj.getBuildNo());   
            psta.setString(3, obj.getRoomNo());  
            psta.setString(4, obj.getRepairTime());
            psta.setString(5, obj.getRepairContent());
            psta.setInt(6, obj.getRepairNo()); 
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
