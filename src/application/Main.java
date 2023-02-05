package application;

import db.DB;

import javax.swing.text.DefaultEditorKit;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args)  {
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       Connection connection= null;
       PreparedStatement pst = null;
       ResultSet resultSet = null;

       try {
           connection = DB.getConnection();

           pst  = connection.prepareStatement(
                   "INSERT INTO seller "+
                           "(Name,Email,BirthDate,BaseSalary,DepartmentId)"+
                           "VALUES "+
                           "(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
           pst.setString(1,"Carl purple");
           pst.setString(2,"carl@gmail.com");
           pst.setDate(3, new java.sql.Date(sdf.parse("22/04/1984").getTime()));
           pst.setDouble(4,3000.0);
           pst.setInt(5,4);

           int rowsAffected = pst.executeUpdate();
           if(rowsAffected >0){
              ResultSet rs = pst.getGeneratedKeys();

              while (rs.next()){
                  int id = rs.getInt(1);
                  System.out.println("Done Id =" + id);
              }
           }else {
               System.out.println("no rowls affected.");
           }


           resultSet = pst.executeQuery("select * from seller");
           while(resultSet.next()){
               System.out.println(resultSet.getInt(1)+","
                       +resultSet.getString(2)+","
                       +resultSet.getString(3)+","
                       +sdf.format(resultSet.getDate(4))
               );


           }

           System.out.println("Done Rows affected: "+ rowsAffected);

       }catch (SQLException e){
           e.printStackTrace();
       } catch (ParseException e) {
           throw new RuntimeException(e);
       }finally {
           DB.closeStatment(pst);
           DB.closeResultSet(resultSet);
           DB.closeConnection();
       }
    }
}