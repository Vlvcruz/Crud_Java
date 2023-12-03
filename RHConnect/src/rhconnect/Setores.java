/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rhconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vitor
 */
public class Setores {
    
    private int Id_Cargo;
    private String cargo;

    public int getId_Cargo() {
        return Id_Cargo;
    }

    public void setId_Cargo(int Id_Cargo) {
        this.Id_Cargo = Id_Cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
