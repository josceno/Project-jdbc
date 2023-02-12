package application;

import Controllers.DepartmentController;
import Controllers.SellerController;
import db.DB;
import db.DBservices.MySqlDBconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

            SellerController.deleteSeller(connection,2);
            SellerController.showSellers(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            db.closeResultSet(resultSet);
            db.closeStatament(statement);
            db.closeConnection();
        }

    }
}