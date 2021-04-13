
package aula4.escola.dao;

public class DaoFactory {
    
    public static AlunoDao getAlunoDao(){
        return new AlunoDao();
    }
    
}
