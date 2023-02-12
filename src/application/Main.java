package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args)   {
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       Connection connection= null;
       Statement st = null;
       ResultSet resultSet = null;

       try {
           connection = DB.getConnection();
           connection.setAutoCommit(false);
           
           st  = connection.createStatement();

           int rows1 = st.executeUpdate("Update seller SET baseSalary = 2060 WHERE DepartmentId = 1");
          
           int rows2 = st.executeUpdate("Update seller SET baseSalary = 3060 WHERE DepartmentId = 2");

           System.out.println(rows1);
           System.out.println(rows2);
           
           connection.commit();


       }catch (SQLException e){
           try{
                connection.rollback();
                throw new DbException("Trasation rolled back: "+ e.getMessage());
           }catch(SQLException ex){
                throw new DbException(ex.getMessage());
           }
           
       } catch (RuntimeException e) {
           throw new RuntimeException(e.getMessage());
       }finally {
           DB.closeStatment(st);
           DB.closeResultSet(resultSet);
           DB.closeConnection();
       }
    }
}