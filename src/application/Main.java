package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args)  {
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       Connection connection= null;
       Statement st = null;
       ResultSet resultSet = null;

       try {
           connection = DB.getConnection();
           st  = connection.createStatement();

           int rows1 = st.executeUpdate("Update seller SET baseSalary = 2090 WHERE Department Id = 1");
           boolean error = (1>2) ? true:false;
           if(error){
               throw new SQLException("Fake error");
           }
           int rows2 = st.executeUpdate("Update seller SET baseSalary = 3090 WHERE Department Id = 2");

           System.out.println(rows1);
           System.out.println(rows2);



       }catch (SQLException e){
           e.printStackTrace();
       } catch (RuntimeException e) {
           throw new RuntimeException(e.getMessage());
       }finally {
           DB.closeStatment(st);
           DB.closeResultSet(resultSet);
           DB.closeConnection();
       }
    }
}