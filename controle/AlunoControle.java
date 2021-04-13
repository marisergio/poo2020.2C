
package aula4.escola.controle;

import aula4.escola.dao.DaoFactory;
import aula4.escola.modelo.Aluno;
import java.util.List;


public class AlunoControle {
    
    public static Aluno cadastrarAluno(String nome, String matricula){
        
        Aluno a = new Aluno();
        a.setNome(nome);
        a.setMatricula(matricula);
        
        a.setId(DaoFactory.getAlunoDao().salvar(a));
        
        return a;
        
    }
    
    public static List<Aluno> listar(){
        
        return DaoFactory.getAlunoDao().getAlunos();
        
    }
    
    public static Boolean delete(Integer id){
        
        return DaoFactory.getAlunoDao().delete(id);
        
    }
    
    
    public static Boolean atualizar(Integer id, String matricula, String nome){
        Aluno a = new Aluno();
        a.setId(id);
        a.setMatricula(matricula);
        a.setNome(nome);
        
        return DaoFactory.getAlunoDao().atulizar(a);
        
    }
    
    public static Aluno buscarPorId(Integer id){
        
        return DaoFactory.getAlunoDao().buscarPorId(id);
        
    }
    
}
