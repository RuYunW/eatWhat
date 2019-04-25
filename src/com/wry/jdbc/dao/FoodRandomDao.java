package com.wry.jdbc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

import com.wry.jdbc.domain.Food;
import com.wry.jdbc.domain.User;
import com.wry.jdbc.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;

public class FoodRandomDao {

    //查询所有Food对象
    public ArrayList<Food> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Food> list = new ArrayList<Food>();
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "SELECT * FROM tb_food";
            rs = stmt.executeQuery(sql);
            //处理结果集
            while (rs.next()){
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodname(rs.getString("foodname"));
                food.setFoodloc(rs.getString("foodloc"));
                food.setDetailloc(rs.getString("detailloc"));
                food.setFoodprice(rs.getFloat("foodprice"));
//                food.setPassword(rs.getString("password"));
                list.add(food);

            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }

    //根据id查找指定的food
    public Food find(int foodnum){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "select * from tb_food where id='"+foodnum+"'";
            rs = stmt.executeQuery(sql);

            //处理结果集
            while (rs.next()){
                Food food = new Food();
                food.setFoodname(rs.getString("foodname"));
                food.setFoodloc(rs.getString("foodloc"));
                food.setDetailloc(rs.getString("detailloc"));
                food.setFoodprice(rs.getFloat("foodprice"));
//                food.setPassword(rs.getString("password"));
                return food;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }

    //增加记录
    public boolean insert(Food food){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into tb_food (foodname,foodloc,detailloc,foodprice) values('"+food.getFoodname()+"','"+food.getFoodloc()+"','"+food.getDetailloc()+"','"+food.getFoodprice()+"')";
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

}
