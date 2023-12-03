/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rhconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class Cadastro_Func{
    
    Conexao con = RHConnect.getConexao(); /* REFERENCIEI CONEXAO */
    /*QUERY PARA CADASTRO DE FUNCIONARIO*/
    
    public void cadastrar (Funcionario func) throws SQLException, ClassNotFoundException{
         PreparedStatement comando = con.getCon().prepareStatement("INSERT INTO funcionario(nome, cpf, Id_cargo, pis, data_nasc, cell, sal_bruto, jornada_mensal, data_adm) VALUES (?,?,?,?,?,?,?,?,?)");
         
         comando.setString(1, func.getNome());
         comando.setString(2,func.getCpf());
         comando.setInt(3, func.getId_Cargo());
         comando.setString(4, func.getPis());
         comando.setString(5, func.getData_nasc());
         comando.setInt(6, func.getCell());
         comando.setDouble(7, func.getSal_bruto());
         comando.setInt(8, func.getJornda_mensal());
         comando.setString(9, func.getData_adm());
         
         comando.execute();
    }
    /*QUERY PARA DELETAR REGISTRO DE FUNCIONARIO*/
    public void deletar (Funcionario func) throws SQLException, ClassNotFoundException{
        PreparedStatement comando = con.getCon().prepareStatement("DELETE FROM funcionario WHERE Id_func = ?");
        
        comando.setInt(1, func.getId_func());
        comando.execute();
    }
    /*QUERY PARA ATUALIZAR UM CADASTRO*/
    public void atualizar (Funcionario func) throws SQLException, ClassNotFoundException{
        PreparedStatement comando = con.getCon().prepareStatement("UPDATE funcionario SET cell=?, sal_bruto=?, jornada_mensal=? WHERE Id_func = ?");
    
        comando.setInt(1, func.getCell());
        comando.setDouble(2,func.getSal_bruto());
        comando.setInt(3,func.getJornda_mensal());
        comando.setInt(4, func.getId_func());
        
        
        comando.execute();
    }
    
    /*QUEY PARA CONSULTAR UM FUNCIONARIO ESPECIFICO*/
    public Funcionario getFuncionarioById(Funcionario func) throws SQLException, ClassNotFoundException{
     PreparedStatement comando = con.getCon().prepareStatement("SELECT * FROM funcionario WHERE id_func = ?");

     comando.setInt(1, func.getId_func());
     /*ARMAZENA OS RESULTADOS TRAZIDOS PELA QUERY*/
     ResultSet rs = comando.executeQuery(); 
     
     
     if(rs.next()){ /*ATRIBUI OS VALOR */
         func.setNome(rs.getString("Nome"));
         func.setCpf(rs.getString("CPF"));
         func.setPis(rs.getString("PIS"));
     }
     
        return new Funcionario(rs.getInt("Id_func"), rs.getString("cpf"), rs.getInt("Id_cargo"), rs.getString("pis"), rs.getInt("cell"), rs.getInt("jornada_mensal"), rs.getString("nome"), rs.getString("data_nasc"), rs.getString("data_adm"), rs.getDouble("sal_bruto"));

    }
    
    /*QUERY PARA CONSULTAR TODOS REGISTROS DE FUNCIONARIOS */
    public List<Funcionario> consultarG() throws SQLException, ClassNotFoundException{
        PreparedStatement comando = con.getCon().prepareStatement("SELECT * FROM Funcionario WHERE 1");
        ResultSet rs = comando.executeQuery();
        
        List<Funcionario> listafunc = new ArrayList<>();
        
        while (rs.next()){
            Funcionario func = new Funcionario(rs.getInt("Id_func"), rs.getString("cpf"), rs.getInt("Id_cargo"), rs.getString("pis"), rs.getInt("cell"), rs.getInt("jornada_mensal"), rs.getString("nome"), rs.getString("data_nasc"), rs.getString("data_adm"), rs.getDouble("sal_bruto"));
            func.setId_func(rs.getInt("Id_Func"));
            func.setNome(rs.getString("Nome"));
            func.setCpf(rs.getString("CPF"));
            listafunc.add(func);
        }
        return listafunc;
    } 
     
}
