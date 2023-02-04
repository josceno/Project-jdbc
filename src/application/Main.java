package application;

import Controllers.DepartmentController;
import Controllers.SellerController;
import Models.Department;
import db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DB.getConnection();
        //Department.createDepartment(connection);
        //SellerController.createSeller(connection);
        //DepartmentController.insertDepartments(connection);
        //SellerController.insertSeller(connection);



        DB.closeConnection();
    }
}