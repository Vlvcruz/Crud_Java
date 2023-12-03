/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rhconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vitor
 */

/*TODA A CONEXAO*/
public class Conexao {
    private final Connection con;
    
    public Conexao(String URL, String USER, String PASSWORD){
        this.con = getConexao(URL,USER,PASSWORD); /* CONSTRUTOR */
        
    }
    
    public static final Connection getConexao(String URL, String USER, String PASSWORD){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } /* CASO DE ERRO */
    
    public Connection getCon(){
        return this.con;
    } 
    
}
