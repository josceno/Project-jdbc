package application;

import Controllers.DepartmentController;
import Controllers.SellerController;
import Models.entities.Department;
import db.DB;
import db.DBservices.MySqlDBconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        Department obj = new Department(1,"book");
        System.out.println(obj);

    }
}