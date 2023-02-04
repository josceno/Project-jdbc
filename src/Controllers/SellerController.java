package Controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

    }
}
