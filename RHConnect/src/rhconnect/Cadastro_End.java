/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rhconnect;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
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
public class Cadastro_End {
    
    Conexao con = RHConnect.getConexao();

    public void cadastroEnd(Endereco end) throws SQLException, ClassNotFoundException {
        PreparedStatement comando = con.getCon().prepareStatement("INSERT INTO endereco(Id_func, longadouro, bairro, cidade, nmr, compl, cep, estado) VALUES (?,?,?,?,?,?,?,?)");

        comando.setInt(1, end.getId_func());
        comando.setString(2, end.getLongad());
        comando.setString(3, end.getBairro());
        comando.setString(4, end.getCidade());
        comando.setInt(5, end.getNmr());
        comando.setString(6, end.getCompl());
        comando.setInt(7, end.getCep());
        comando.setString(8, end.getEstado());

        comando.execute();
    }

    public void atualizar_end(Endereco end) throws SQLException, ClassNotFoundException {
        PreparedStatement comando = con.getCon().prepareStatement("UPDATE endereco SET longadouro=?, bairro =?, cidade =?, nmr =?, compl =?, cep =?, estado =? WHERE Id_func = ?");

        comando.setString(1, end.getLongad());
        comando.setString(2, end.getBairro());
        comando.setString(3, end.getCidade());
        comando.setInt(4, end.getNmr());
        comando.setString(5, end.getCompl());
        comando.setInt(6, end.getCep());
        comando.setString(7, end.getEstado());

        comando.execute();
    }

    public void deletar_end(Endereco end) throws SQLException, ClassNotFoundException {
        PreparedStatement comando = con.getCon().prepareStatement("DELETE FROM endereco WHERE Id_func = ?");

        comando.setInt(1, end.getId_func());

        comando.execute();
    }

    public Endereco getEdnderecoById(Endereco end) throws SQLException, ClassNotFoundException {
        PreparedStatement comando = con.getCon().prepareStatement("SELECT * FROM endereco WHERE id_func = ?");

        comando.setInt(1, end.getId_func());
        ResultSet rs = comando.executeQuery();

        end.setId_func(rs.getInt("Id_Func"));
        end.setLongad(rs.getString("Longad"));
        end.setNmr(rs.getInt("Nmr"));
        end.setBairro(rs.getString("Bairro"));
        end.setCidade(rs.getString("Cidade"));
        end.setCep(rs.getInt("Cep"));

        return new Endereco(rs.getString("longad"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("compl"), rs.getString("estado"), rs.getInt("Id_func"), rs.getInt("nmr"), rs.getInt("cep"));

    }

    public ResultSet executarContagem(Endereco end) throws SQLException, ClassNotFoundException {
        
        PreparedStatement comando = con.getCon().prepareStatement("select count(Id_func) from funcionario where Id_func = ? ");

        comando.setInt(1, end.getId_func());

        ResultSet rs = comando.executeQuery();
        // Verifica se há resultados
        if (rs.next()) {
            // Obtém o resultado da função COUNT
            int resultadoCount = rs.getInt(1);
            
            // Agora você pode usar resultadoCount conforme necessário
            System.out.println("Número de linhas: " + resultadoCount);
        }else{
            System.out.println("sem retorno de linhas: ");

        }
        return rs;
        
    }

}

