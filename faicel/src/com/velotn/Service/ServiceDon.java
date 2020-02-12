package com.velotn.Service;

import com.velotn.Entite.Don;
import com.velotn.IService.IService;
import com.velotn.Utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDon implements IService<Don> {

    private Connection con;
    private Statement ste;

    public ServiceDon() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Don don) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `don` (`somme`, `date_don`, `user_id`) VALUES (?,?,?);");
        pre.setDouble(1,don.getSomme());
        pre.setString(2,don.getDate());
        pre.setInt(3,don.getUserId());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(Don don) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `don` WHERE id = ?");
        pre.setInt(1,don.getId());
        pre.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Don don) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE `don` SET somme = ? where id = ?");
        pre.setDouble(1,don.getSomme());
        pre.setInt(2,don.getId());
        pre.executeUpdate();
        return true;
    }

    @Override
    public List<Don> readAll() throws SQLException {
        List<Don> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM don");
        while(rs.next()){
            int id = rs.getInt(1);
            Double somme = rs.getDouble(2);
            String date = rs.getString(3);
            int userid = rs.getInt(4);
            Don don = new Don(id,somme,date,userid);
            arr.add(don);
        }
        return arr;
    }
}
