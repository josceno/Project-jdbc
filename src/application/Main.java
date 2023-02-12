package application;

import db.DB;
import db.DbException;
import models.Dao.DaoFactory;
import models.Dao.SellerDao;
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
       SellerDao sellerDao = DaoFactory.createSellerDao();

       System.out.println(seller);
    }
}