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

    }public  static  void insertSeller(Connection connection){
        try{
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES \n" +
                    "  ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1),\n" +
                    "  ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2),\n" +
                    "  ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1),\n" +
                    "  ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4),\n" +
                    "  ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3),\n" +
                    "  ('Alex Pink2','bob@gmail.com','1997-03-04 00:00:00',3000,2);");

            System.out.println("Successfully inserted into Seller");
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
