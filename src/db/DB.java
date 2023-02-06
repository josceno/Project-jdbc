package db;

import Models.Department;
import Models.Seller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface DB {
    static Connection connection = null;

    public Connection getConnection();
       
  
    

    default void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                throw  new DbException(e.getMessage());
            }
        }
    }
    public  Properties loadProperties();
       
    default  void closeStatament(Statement st){
        try {
            if(st != null){
                st.close();
            }
            System.out.println("statement closed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    default void closeResultSet(ResultSet rs){
        try{
            if(rs !=null){
                rs.close();
            }
            System.out.println("ResultSet closed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public  List<Department> getDepartments() throws SQLException;

    public List<Seller> getSellers();

}
