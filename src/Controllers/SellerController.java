package Controllers;

import Models.Department;
import Models.Seller;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class SellerController {
    public static void createSeller(Connection connection){
        try{
            Statement st = connection.createStatement();
            st.executeUpdate("CREATE TABLE seller (\n" +
                    "  Id int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  Name varchar(60) NOT NULL,\n" +
                    "  Email varchar(100) NOT NULL,\n" +
                    "  BirthDate datetime NOT NULL,\n" +
                    "  BaseSalary double NOT NULL,\n" +
                    "  DepartmentId int(11) NOT NULL,\n" +
                    "  PRIMARY KEY (Id),\n" +
                    "  FOREIGN KEY (DepartmentId) REFERENCES department (id)\n" +
                    ")");
            System.out.println("Seller created");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }public  static  void insertSeller(Connection connection, Seller seller){

        try{
            PreparedStatement pst = connection.prepareStatement("" +
                    "INSERT INTO seller "+
                    "(Name,Email,BirthDate,BaseSalary,DepartmentId)"+
                    "VALUES"+
                    "(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS
            );

            pst.setString(1,seller.getName());
            pst.setString(2,seller.getEmail());
            pst.setDate(3, seller.getBirthday());
            pst.setDouble(4,seller.getBaseSalary());
            pst.setInt(5,seller.getDepId().getId());

            pst.executeUpdate();

            System.out.println("done");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
    public  static  void  showSellers(Connection connection){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            PreparedStatement statement = connection.prepareStatement("select * from seller");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(
                        resultSet.getInt(1)+"|"+
                        resultSet.getString(2)+"|"+
                        resultSet.getString(3)+"|"+
                        sdf.format(resultSet.getDate(4))+"|"+
                        resultSet.getDouble(5)+"|"+
                        resultSet.getInt(6)
                );

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}