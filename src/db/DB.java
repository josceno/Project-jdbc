package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private  static Connection connection = null;

    public static  Connection getConnection(){
        if(connection == null){
           try{
                Properties properties = loadPerties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url,properties);
                System.out.println("Successful connection");
           }catch (SQLException e){
               throw  new DbException(e.getMessage());
           }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                throw  new DbException(e.getMessage());
            }
        }
    }
    private  static Properties loadPerties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return  props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
        }

    }
    public static  void closeStatment(Statement st) {
        if(st !=null){
            try {
                st.close();
            } catch (SQLException e) {
                throw  new DbException("statement already closed");
            }
        }

    }
    public static  void closeResultSet(ResultSet rs) {
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw  new DbException("Result already closed");
            }
        }

    }



    }
