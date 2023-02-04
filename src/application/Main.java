package application;

import Controllers.SellerController;
import Models.Department;
import db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DB.getConnection();
        //Department.createDepartment(connection);
        //SellerController.createSeller(connection);
        DB.closeConnection();
    }
}