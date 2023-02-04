package application;

import Controllers.DepartmentController;
import Controllers.SellerController;
import Models.Department;
import db.DB;
import db.DbException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DB.getConnection();
            statement = connection.createStatement();
            resultSet= statement.executeQuery("select * from department");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id")+","+resultSet.getString("Name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DB.closeResultSet(resultSet);
            DB.closeStatament(statement);
            DB.closeConnection();
        }




        DB.closeConnection();
    }
}