/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rhconnect;

/**
 *
 * @author vitor
 */
public class Endereco {
    
    private String longad,bairro,cidade,compl,estado;
    private int Id_func,nmr,cep,valid;

    public Endereco(String longad, String bairro, String cidade, String compl, String estado, int Id_func, int nmr, int cep) {
        this.longad = longad;
        this.bairro = bairro;
        this.cidade = cidade;
        this.compl = compl;
        this.estado = estado;
        this.Id_func = Id_func;
        this.nmr = nmr;
        this.cep = cep;
    }

    public Endereco(){
        
    }

    public void setValid(int Valid){
        this.valid = Valid;
    }
    
    public int getValid() {
        return valid;
    }
        

    public int getId_func() {
        return Id_func;
    }

    public void setId_func(int Id_func) {
        this.Id_func = Id_func;
    }

    public String getLongad() {
        return longad;
    }

    public void setLongad(String longad) {
        this.longad = longad;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNmr() {
        return nmr;
    }

    public void setNmr(int nmr) {
        this.nmr = nmr;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
    
    
    
}
