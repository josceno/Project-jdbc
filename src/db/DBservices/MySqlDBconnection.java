package db.DBservices;

import Models.Department;
import Models.Seller;
import db.DB;
import db.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MySqlDBconnection implements DB {
    private  static Connection connection = null;

    @Override
    public  Connection getConnection(){
        if(connection == null){
           try{
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url,properties);
                System.out.println("Successful connection");


           }catch (SQLException e){
               throw new DbException("Connection Attempt failed");
           }
        }
        try {
            DB.getDepartments();
            System.out.println("Successfully Departments Data importing");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw  new DbException("Failure in import departments process ");
        }
        try {
            DB.getSellers();
            System.out.println("Successfully Departments Data importing");
        }catch (Exception e){
            //throw  new DbException("Failure in import Sellers process ");
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return  props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
        }

    }
    
   
}




