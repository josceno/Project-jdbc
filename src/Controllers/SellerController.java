package Controllers;

import Models.Seller;
import db.Exceptions.DbIntegrityException;

import java.sql.*;
import java.text.SimpleDateFormat;

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
            pst.setInt(5,seller.getDepartment().getId());

            pst.executeUpdate();

            System.out.println("done");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
    public static  void updateSellers(Connection connection, Seller seller){


        try{
            PreparedStatement pst = connection.prepareStatement(
                    "UPDATE seller "
                            +"SET baseSalary = BaseSalary + ?"
                            +"WHERE "
                            +"(DepartmentId = ?)");

            pst.setDouble(1,200.00);
            pst.setInt(2,seller.getDepartment().getId());

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static  void updateSellers(Connection connection, int id){
        try{
            PreparedStatement pst = connection.prepareStatement(
                    "UPDATE seller "
                            +"SET baseSalary = BaseSalary + ?"
                            +"WHERE "
                            +"(DepartmentId = ?)");

            pst.setDouble(1,200.00);
            pst.setInt(2,id);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public  static  void deleteSeller(Connection connection, int id){
        try{
            PreparedStatement pst = connection.prepareStatement(
                    "DELETE FROM seller "
                    +"WHERE "
                    +"(Id = ?)"
            );
            pst.setInt(1,id);
            int rowsAffected =pst.executeUpdate();

            System.out.println("Rows affectd number: "+ rowsAffected);
        }catch (SQLException e){
            throw  new DbIntegrityException(e.getMessage());
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
