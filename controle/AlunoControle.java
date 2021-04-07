
package aula4.escola.controle;

import aula4.escola.modelo.Aluno;


public class AlunoControle {
    
    public static Aluno cadastrarAluno(String nome, String matricula){
        
        Aluno a = new Aluno();
        a.setNome(nome);
        a.setMatricula(matricula);
        
        return a;
        
    }
    
}
