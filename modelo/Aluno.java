
package aula4.escola.modelo;

import java.util.Date;

public class Aluno extends Pessoa{
    
    public static int qtde = 0;
    private String matricula;
    
    public Aluno(){
        Aluno.qtde++;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
    
    
}
