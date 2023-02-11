package db.DBservices;

import Models.Department;
import Models.Seller;
import db.DB;
import db.Exceptions.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
            this.getDepartments();
            System.out.println("Successfully Departments Data importing");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
            throw  new DbException("Failure in import departments process ");
        }
        try {
            this.getSellers();
            System.out.println("Successfully Departments Data importing: ");
        }catch (Exception e){
            //throw  new DbException("Failure in import Sellers process ");
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public  List<Department> getDepartments() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from department");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Department> departamentos = new ArrayList<>();
        while (resultSet.next()){
            departamentos.add(new Department(resultSet.getInt(1),resultSet.getString(2)));
        }
        return  departamentos;
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
    @Override
    public List<Seller> getSellers()  {
        List<Seller> sellers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from seller");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Stream<Department> department;
                department  =  getDepartments().stream().filter(x ->
                        {
                            try {
                                return x.getId() == resultSet.getInt(6);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
                sellers.add(
                        new Seller(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getDate(4),
                                resultSet.getDouble(5),
                                department.collect(Collectors.toList()).get(0)
                        )
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return  sellers;
    }
    
   
}




