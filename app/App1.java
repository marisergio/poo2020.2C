
package aula4.escola.app;

import aula4.escola.controle.AlunoControle;
import aula4.escola.modelo.Aluno;
import java.util.Scanner;


public class App1 {
    
   
    
    public static void main(String[] args){
        Aluno[] alunos = new Aluno[10];
        int opcao = 7;
        Scanner teclado = new Scanner(System.in);
       
        do{

            
            menu();
            opcao = Integer.parseInt(teclado.nextLine());
            
            if(opcao==1){
                System.out.println("Digite o nome do aluno: ");
                String nome = teclado.nextLine();
                System.out.println("Digite a matricula: ");
                String matricula = teclado.nextLine();
              //  System.out.println(Aluno.qtde);
                alunos[Aluno.qtde] = AlunoControle.cadastrarAluno(nome, matricula);
                
            }else if(opcao==4){
                listarAlunos(alunos);
            }
            
        }while(opcao!=7);

    }
    
    public static void menu(){
        System.out.println("Menu\n" +
                        "---------------------------------\n" +
                        "1 – Cadastrar Aluno\n" +
                        "2 – Cadastrar Turma\n" +
                        "3 – Matricular\n" +
                        "4 – Listar Alunos\n" +
                        "5 – Listar Turmas\n" +
                        "6 – Listar Matrículas\n" +
                        "7 – Sair\n" +
                        "---------------------------------\n" +
                        "\n" +
                        "Digite a opção: ");
    }
    
    public static void listarAlunos(Aluno[] alunos){
        System.out.println("\n\n---------LISTANDO OS ALUNOS CADASTRADOS -----------\n");
        for(int i=0; i<Aluno.qtde; i++){
            System.out.println("Nome: " + alunos[i].getNome());
        }
        
    }
    
}
