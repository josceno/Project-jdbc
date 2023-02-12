package application;

import db.DB;
import db.DbException;
import models.entities.Department;
import models.entities.Seller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args)   {
       Seller seller = new Seller(1,"Bob","bob@gmail.com",new Date(1,1,1), 3000.0, new Department(1,"dep"));
       System.out.println(seller);
    }
}