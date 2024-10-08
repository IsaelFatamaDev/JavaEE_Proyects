package edu.pe.vallegrande.importaciones.service;

import edu.pe.vallegrande.importaciones.db.AccesoDB;
import edu.pe.vallegrande.importaciones.dto.OfficeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfficeService {
    public List<OfficeDto> getOffice() {
        List<OfficeDto> drivers = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT * FROM office;";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OfficeDto driver = new OfficeDto();
                driver.setOffice_id(rs.getInt("office_id"));
                driver.setOffice_name(rs.getString("office_name"));
                driver.setAddress(rs.getString("address"));
                driver.setCity(rs.getString("city"));
                driver.setPhone(rs.getString("phone"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public void insertOffice(OfficeDto office) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "INSERT INTO office(office_name, address, city, phone) VALUES(?, ?, ?, ?);";
            ps = cn.prepareStatement(sql);
            ps.setString(1, office.getOffice_name());
            ps.setString(2, office.getAddress());
            ps.setString(3, office.getCity());
            ps.setString(4, office.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOffice(OfficeDto office) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "UPDATE office SET office_name = ?, address = ?, city = ?, phone = ? WHERE office_id = ?;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, office.getOffice_name());
            ps.setString(2, office.getAddress());
            ps.setString(3, office.getCity());
            ps.setString(4, office.getPhone());
            ps.setInt(5, office.getOffice_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOffice(int office_id) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "DELETE FROM office WHERE office_id = ?;";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, office_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    // metodo de editar
    public OfficeDto getOfficeById(int office_id) {
        OfficeDto driver = new OfficeDto();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT * FROM office WHERE office_id = ?;";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, office_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                driver.setOffice_id(rs.getInt("office_id"));
                driver.setOffice_name(rs.getString("office_name"));
                driver.setAddress(rs.getString("address"));
                driver.setCity(rs.getString("city"));
                driver.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }



}
