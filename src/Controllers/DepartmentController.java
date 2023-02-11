package Controllers;

import Models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}
