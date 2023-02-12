package Controllers;

import db.Exceptions.DbIntegrityException;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import Models.entities.Department;

public class DepartmentController {
    public static void createDepartment(Connection connection){
        try{
            Statement st = connection.createStatement();

            st.executeUpdate("CREATE TABLE department (\n" +
                    "  Id int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  Name varchar(60) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (Id)\n" +
                    ")");
            System.out.println("Department created");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  static void insertDepartments(Connection connection, Department department){

        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO department (Name) VALUES \n" +
                    "(?)");
            st.setString(1,department.getName());
            st.executeUpdate();
            System.out.println("Successfully inserted into Departments");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static  void deleteDepartments(Connection connection, Integer id){

        try {
            PreparedStatement pst = connection.prepareStatement(
                    "DELETE FROM department "
                            +"WHERE "
                            +"(Id = ?)"
            );

            pst.setInt(1,id);

           int rowsAffected = pst.executeUpdate();

            System.out.println("Number of rous deleted: " + rowsAffected);



        }catch (SQLException e){
            throw  new DbIntegrityException(e.getMessage());
        }

    }
    public  static  void  updateDepartments(Connection connection, String name, Department department){
        try{
            PreparedStatement pst = connection.prepareStatement(
                    "UPDATE department "
                            +"SET Name = ? "
                            +"WHERE "
                            +"(Id = ?)",Statement.RETURN_GENERATED_KEYS);

            pst.setString(1,name);
            pst.setInt(2,department.getId());
            pst.executeUpdate();
            int rowsaffected = pst.executeUpdate();

            if(rowsaffected>0){

                ResultSet resultSet = pst.getGeneratedKeys();
                Set<Integer> affctedId = new HashSet<>();

                while (resultSet.next()){
                    System.out.println("reach");
                    int id = resultSet.getInt(1);
                    affctedId.add(id);

                    System.out.println("Affected rows: "+affctedId.toString());
                    System.out.println(":"+id);

                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public  static  void  updateDepartments(Connection connection, String name, Integer id){
        try{
            PreparedStatement pst = connection.prepareStatement(
                    "UPDATE department "
                            +"SET Name = ? "
                            +"WHERE "
                            +"(Id = ?)");

            pst.setString(1,name);
            pst.setInt(2,id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
