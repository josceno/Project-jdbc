package application;

import Controllers.DepartmentController;
import Controllers.SellerController;
import Models.Department;
import Models.Employees;
import Models.Seller;
import db.DB;
import db.DbException;
import db.DBservices.MySqlDBconnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        DB db = new MySqlDBconnection();

        try{
            connection = db.getConnection();

            /*SellerController.updateSellers(connection, new Seller("Genesinho",
                    "Genesinho@gmail.com",
                    new java.sql.Date(sdf.parse("25/04/2018").getTime()),
                    3000.00,
                    db.getDepartments().get(0)
            ));*/
            //SellerController.showSellers(connection);
            //db.getSellers().forEach(System.out::println);

            DepartmentController.updateDepartments(connection,"UpdateTestName0",
                    db.getDepartments().get(5)
                    );
            db.getDepartments().forEach(System.out::println);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            db.closeResultSet(resultSet);
            db.closeStatament(statement);
            db.closeConnection();
        }

    }
}