/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ariya
 */
public class koneksi {
    private static Connection koneksi;
    
    public static Connection getkoneksi(){
        if (koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/rumahkucing";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, pass);
                JOptionPane.showMessageDialog(null, "Selamat Datang ");
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "                          Gagal Terhubung"
                        + "\n Masalah pada jaringan silahkan cek jaringan anda");
                System.exit(0);
            }
        }
        return koneksi;
    }
    public static void main(String[] args) {
        getkoneksi();
    }
}
