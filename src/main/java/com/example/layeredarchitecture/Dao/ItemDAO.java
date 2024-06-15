package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getItems() throws SQLException, ClassNotFoundException ;

    public  void delete(String code) throws SQLException, ClassNotFoundException ;

    public void save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public int update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public boolean isExists(String code) throws SQLException, ClassNotFoundException ;

    public String lastId() throws SQLException, ClassNotFoundException ;
    public ItemDTO findItem(String s) throws SQLException, ClassNotFoundException ;

    public ArrayList<String> loadItemIds() throws SQLException, ClassNotFoundException ;
}
