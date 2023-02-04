package Controllers;

import java.sql.Connection;
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

    public  static void insertDepartments(Connection connection){

        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO department (Name) VALUES \n" +
                    "  ('Computers'),\n" +
                    "  ('Electronics'),\n" +
                    "  ('Fashion'),\n" +
                    "  ('Books'),\n"+
                    "('groceries');\n");

            System.out.println("Successfully inserted into Departments");
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}