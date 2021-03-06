package com.wry.jdbc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import com.wry.jdbc.domain.User;
import com.wry.jdbc.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;

public class UsersDao {
    public boolean insert(User user){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into tb_users values('"+user.getUsername()+"','"+user.getPassword()+"')";
            int num = stmt.executeUpdate(sql);
            if (num>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return false;
    }

    //查询所有user对象
    public ArrayList<User> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "SELECT * FROM tb_users";
            rs = stmt.executeQuery(sql);
            //处理结果集
            while (rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }

    //根据id查找指定的user
    public User find(String username){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "select * from tb_users where username='"+username+"'";
            rs = stmt.executeQuery(sql);

            //处理结果集
            while (rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }

    //删除用户
    public boolean delete(String username){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "DELETE FROM tb_users WHERE username='" + username+"'";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return false;
    }

    //修改用户
    public boolean update(User user){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "UPDATE tb_users SET password='"+user.getPassword()
                    +"' WHERE username='"+user.getUsername()+"'";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return false;

    }
}
