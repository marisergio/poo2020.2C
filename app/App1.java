package aula4.escola.app;

import aula4.escola.controle.AlunoControle;
import aula4.escola.dao.AlunoDao;
import aula4.escola.modelo.Aluno;
import aula4.escola.modelo.Turma;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App1 {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();

        int opcao = 7;
        Scanner teclado = new Scanner(System.in);

        do {

            menu();
            opcao = Integer.parseInt(teclado.nextLine());

            if (opcao == 1) {

                System.out.println("Digite o nome do aluno: ");
                String nome = teclado.nextLine();
                System.out.println("Digite a matricula: ");
                String matricula = teclado.nextLine();

                Aluno a1 = AlunoControle.cadastrarAluno(nome, matricula);
                a1.setId(AlunoDao.salvar(a1));
                System.out.println("id: " + a1.getId());
                AlunoDao.getAlunos(alunos);
                AlunoDao.atulizar(a1);
                listarAlunos(alunos);
                AlunoDao.delete(a1.getId());
                listarAlunos(alunos);

            } else if (opcao == 4) {
                listarAlunos(alunos);
            }

        } while (opcao != 7);

    }

    

    public static void menu() {
        System.out.println("Menu\n"
                + "---------------------------------\n"
                + "1 – Cadastrar Aluno\n"
                + "2 – Cadastrar Turma\n"
                + "3 – Matricular\n"
                + "4 – Listar Alunos\n"
                + "5 – Listar Turmas\n"
                + "6 – Listar Matrículas\n"
                + "7 – Sair\n"
                + "---------------------------------\n"
                + "\n"
                + "Digite a opção: ");
    }

    public static void listarAlunos(List<Aluno> alunos) {
        System.out.println("\n\n---------LISTANDO OS ALUNOS CADASTRADOS -----------\n");

        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome());
        }

    }
    
    

}
