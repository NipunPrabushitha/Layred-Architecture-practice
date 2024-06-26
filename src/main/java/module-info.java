module com.example.layeredarchitecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;

    opens com.example.layeredarchitecture to javafx.fxml;
    opens com.example.layeredarchitecture.controller to javafx.fxml;
    opens com.example.layeredarchitecture.view.tdm to javafx.base;

    exports com.example.layeredarchitecture;
    exports com.example.layeredarchitecture.controller;
    exports com.example.layeredarchitecture.Dao;
    opens com.example.layeredarchitecture.Dao to javafx.fxml;
    exports com.example.layeredarchitecture.Dao.DAO_IMPL;
    opens com.example.layeredarchitecture.Dao.DAO_IMPL to javafx.fxml;
}
