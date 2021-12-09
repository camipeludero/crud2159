/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author camip
 */
public class Conexion {
    public String driver = "org.postgresql.Driver";
    //POSTGRESQL HEROKU DB CREDENTIALS
    String DB_HOST = "ec2-54-157-113-118.compute-1.amazonaws.com";
    int DB_PORT = 5432;
    String DB_NAME = "d1b93ssg45cpsm?sslmode=require";
    String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    String DB_USER = "sgtxxqjmejabwp";
    String DB_PASS = "8b5f104e862118c333d39ccf9d2936b37a79410cb45abecec9aa6160e7eec662";
    
    public Connection getConnection (){
        Connection conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); 
        } catch(ClassNotFoundException|SQLException e){
            System.out.println(e);
        }
        return conexion;
    }
    /* *********** CHECKEANDO CONEXION A LA BD *************
    public static void main(String [] args) throws SQLException{
        Connection Conexion = null;
        Conexion con = new Conexion();
        Conexion = con.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        
        ps = Conexion.prepareStatement("SELECT * FROM alumnos");
        rs = ps.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String mail = rs.getString("mail");
            System.out.println("id: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nMail: " + mail);
        }
    }*/
}

