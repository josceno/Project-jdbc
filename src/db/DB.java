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
                Properties properties = loadProperties();
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
    private  static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return  props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
        }

    }
    public  static  void closeStatament(Statement st){
        try {
            if(st != null){
                st.close();
            }
            System.out.println("statement closed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static  void closeResultSet(ResultSet rs){
        try{
            if(rs !=null){
                rs.close();
            }
            System.out.println("ResultSet closed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}
