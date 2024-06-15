package com.example.layeredarchitecture.Dao.DAO_IMPL;

import com.example.layeredarchitecture.Dao.DAO_IMPL.ItemDAOImpl;
import com.example.layeredarchitecture.Dao.ItemDAO;
import com.example.layeredarchitecture.Dao.OrderDetailDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    public Connection connection = DBConnection.getDbConnection().getConnection();
    ItemDAO itemDAO = new ItemDAOImpl();
    public void OrderDetailsDAOImpl() throws SQLException, ClassNotFoundException {
    }

    public OrderDetailDAOImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean addOrderDetails(String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {


        for (OrderDetailDTO detail : orderDetails) {

            String itemCode = detail.getItemCode();
            BigDecimal unitPrice = detail.getUnitPrice();
            int qty = detail.getQty();


            boolean added = saveOrderDetail(orderId, new OrderDetailDTO(itemCode, qty, unitPrice));


            //Search & Update Item



            ItemDTO item = itemDAO.findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());


            int x =itemDAO.update(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));


            if (!added && !(x > 0)) {

                return false;
            }


        }
        return  true;
    }
    @Override
    public boolean saveOrderDetail(String id ,OrderDetailDTO orderDetailDTO) throws SQLException {

        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        stm.setString(1, id);
        stm.setString(2, orderDetailDTO.getItemCode());
        stm.setBigDecimal(3, orderDetailDTO.getUnitPrice());
        stm.setInt(4, orderDetailDTO.getQty());
        return stm.executeUpdate()==1;
    }

}
