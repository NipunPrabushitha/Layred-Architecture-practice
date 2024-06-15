package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    public void save(String id, String name, String address) throws SQLException, ClassNotFoundException;
    public void update(String id, String name, String address) throws SQLException, ClassNotFoundException;
    public boolean excistCustomer(String id) throws SQLException, ClassNotFoundException;
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public String nextId() throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;
}
