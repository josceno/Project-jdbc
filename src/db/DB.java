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
    public static List<Department> getDepartments() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from department");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Department> departamentos = new ArrayList<>();
        while (resultSet.next()){
            departamentos.add(new Department(resultSet.getInt(1),resultSet.getString(2)));
        }
        return  departamentos;
    }
    public static List<Seller> getSellers()  {
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
