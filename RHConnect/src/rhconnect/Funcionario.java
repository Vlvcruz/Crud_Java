/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rhconnect;
/**
 *
 * @author vitor
 */
public class Funcionario {
    private int id_func,Id_Cargo,cell,jornada_mensal;
    private String nome,data_nasc,data_adm,cpf,pis;
    private double sal_bruto;
    
    public Funcionario(int id_func, String cpf, int Id_Cargo, String pis, int cell, int jornada_mensal, String nome, String data_nasc, String data_adm, double sal_bruto) {
        this.id_func = id_func;
        this.cpf = cpf;
        this.Id_Cargo = Id_Cargo;
        this.pis = pis;
        this.cell = cell;
        this.jornada_mensal = jornada_mensal;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.data_adm = data_adm;
        this.sal_bruto = sal_bruto;
    }
    
    public Funcionario(){
        
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public int getId_Cargo() {
        return Id_Cargo;
    }

    public void setId_Cargo(int Id_Cargo) {
        this.Id_Cargo = Id_Cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getJornda_mensal() {
        return jornada_mensal;
    }

    public void setJornada_mensal(int jornada_mensal) {
        this.jornada_mensal = jornada_mensal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getData_adm() {
        return data_adm;
    }

    public void setData_adm(String data_adm) {
        this.data_adm = data_adm;
    }

    public double getSal_bruto() {
        return sal_bruto;
    }

    public void setSal_bruto(double sal_bruto) {
        this.sal_bruto = sal_bruto;
    }
       
}
