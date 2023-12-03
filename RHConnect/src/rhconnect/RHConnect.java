/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rhconnect;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class RHConnect {

    private static Conexao conexao;

    /* DECLAREI A VARIAVEL */
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        conexao = new Conexao("jdbc:mysql://localhost:3306/projectm2", "root", "");
        /*INSTANCIEI A CONEXAO*/
        
        Scanner scan = new Scanner(System.in);
        Funcionario func = new Funcionario();        
        Cadastro_Func funcD = new Cadastro_Func();
        
        
        Endereco end = new Endereco();
        Cadastro_End endC = new Cadastro_End();
        
        System.out.println("""
                       Ola... Qual acao voce deseja: 
                        1- Cadastrar
                        2- Atualizar
                        3- Deletar
                        4- Consultar 1 Funcionario
                        5- Consultar Funcionarios Cadastrados 
                        
                        6- Cadastrar Endereco Funcionario
                        7- Atualizar endereco
                        8- Deletar endereco
                        9- Consultar endereco de funcionario""");
        int decisao = scan.nextInt();
        
        switch (decisao) {
            case 1 -> {
                System.out.println("Digite o nome do Funcionario..");
                clearBuffer(scan);
                func.setNome(scan.nextLine());
                System.out.println("Digite o CPF do Funcionario..");
                func.setCpf(scan.nextLine());
                System.out.println("Digite o Id cargo do Funcionario..");
                func.setId_Cargo(scan.nextInt());
                System.out.println("Digite o Pis do Funcionario..");
                clearBuffer(scan);
                func.setPis(scan.nextLine());
                System.out.println("Digite o Data de nascimento do Funcionario..");
                func.setData_nasc(scan.nextLine());
                System.out.println("Digite o Celular do Funcionario..");
                func.setCell(scan.nextInt());
                System.out.println("Digite o Salario bruto do Funcionario..");
                clearBuffer(scan);
                func.setSal_bruto(scan.nextDouble());
                System.out.println("Digite o Jornada mensal do Funcionario..");
                clearBuffer(scan);
                func.setJornada_mensal(scan.nextInt());
                System.out.println("Digite o Data Admissao do Funcionario..");
                clearBuffer(scan);
                func.setData_adm(scan.nextLine());
                
                try {
                    funcD.cadastrar(func);
                    System.out.println("Cadastrado com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
                
            }
            case 2 -> {
                System.out.println("Digite os dados a serem atualizados ! ...");
                System.out.println("Digite o Id do Funcionario..");
                func.setId_func(scan.nextInt());
                System.out.println("Digite o Celular do Funcionario..");
                func.setCell(scan.nextInt());
                System.out.println("Digite o Salario bruto do Funcionario..");
                clearBuffer(scan);
                func.setSal_bruto(scan.nextDouble());
                System.out.println("Digite o Jornada mensal do Funcionario..");
                clearBuffer(scan);
                func.setJornada_mensal(scan.nextInt());
                
                try {
                    funcD.atualizar(func);
                    System.out.println("atualizado com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            case 3 -> {
                System.out.println("Digite o Id do Funcionario..");
                func.setId_func(scan.nextInt());
                
                try {
                    funcD.deletar(func);
                    System.out.println("Deletado com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            case 4 -> {
                System.out.print("Digite ID do funcionario: ");
                func.setId_func(scan.nextInt());
                try {
                    func = funcD.getFuncionarioById(func);
                    if (func.getNome() != null) {
                        System.out.println("Nome..: " + func.getNome());
                        System.out.println("CPF......: " + func.getCpf());
                        System.out.println("PIS... " + func.getPis());
                        System.out.println("\n");
                    } else {
                        System.out.println("ID nao encontrado.");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            case 5 -> {
                try {
                    
                    List<Funcionario> listaFuc = funcD.consultarG();
                    
                    for (Funcionario func1 : listaFuc) {
                        System.out.println("\n ID do funcionario....: " + func1.getId_func());
                        System.out.println("Nome....................: " + func1.getNome());
                        System.out.println("CPF.....................: " + func1.getCpf());
                    }
                    
                } catch (SQLException ex) {
                    System.out.println("Erro irmao: " + ex.getMessage());
                    
                }
            }
            case 6 -> {
                
                System.out.println("Digite o Id do funcionario..");
                end.setId_func(scan.nextInt());
                if (endC.executarContagem(end) == 1){
                    
                    System.out.println("Digite o nome do Longadouro..");
                    clearBuffer(scan);
                    end.setLongad(scan.nextLine());
                    System.out.println("Digite o nome do Bairro..");
                    end.setBairro(scan.nextLine());
                    System.out.println("Digite o nome da Cidade..");
                    end.setCidade(scan.nextLine());
                    System.out.println("Digite o numero da residencia..");
                    end.setNmr(scan.nextInt());
                    System.out.println("Informe o Complemento, (Casa, apto ..)");
                    clearBuffer(scan);
                    end.setCompl(scan.nextLine());
                    System.out.println("Digite o CEP..");
                    end.setCep(scan.nextInt());
                    System.out.println("Informe o Estado de moradia");
                    clearBuffer(scan);
                    end.setEstado(scan.nextLine());
                    
                    try {
                        endC.cadastroEnd(end);
                        System.out.println("Endereco cadastrado com Sucesso.");
                    } catch (SQLException ex) {
                        System.out.println("Erro irmao>>>" + ex.getMessage());
                    }
                } 
                else {
                    System.out.println("Desculpe esse Id, nao esta cadastrado no nosso banco de dados !");
                    break;
                }
            }
            case 7 -> {
                
            }
            case 8 -> {
                
            }
            default -> {
                
            }
        }
    }
    
    public static Conexao getConexao() {
        return conexao;
        /* CRIEI UM METODO PARA CONSUMIR A CONEXAO */
    }

    public static void clearBuffer(Scanner sc) {
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
    }
}
