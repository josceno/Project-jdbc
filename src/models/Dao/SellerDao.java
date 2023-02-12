package models.Dao;

import java.util.List;

import models.entities.Seller;

public interface SellerDao {
    void createSeller(Seller Seller);
    void insertSellers(Seller Seller);
    void deleteSellers(Integer id);
    Seller findSellerById(Integer id);
    List<Seller>  getSellers(); 
}
