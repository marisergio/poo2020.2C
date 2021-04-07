
package aula4.escola.modelo;

public class App1 {
    
    public static void main(String[] args){
        
        int[] teste = {1454,2};
        
        int test[] = new int[2];
        test[0] = 3333;
        
        Matricula ms[] = new Matricula[10];
        
        System.out.println(test[0]);
        
      ///  Aluno a1 = new Aluno("M2021SI5001");
      //  a1.nome = "Pedro José";
        
        Aluno a2 = new Aluno();
        
        Turma tA = new Turma();
     //   tA.nome = "A";
      //  tA.serie = "1º Ano";
     //   tA.turno = "Manhã";
        
        Matricula m1 = new Matricula("Cursando");
      //  m1.aluno = a1;
        m1.turma = tA;
        
        ms[0] = m1;
        
    //    System.out.println("Status Matricula: " + ms[0].status + " Aluno: " + m1.aluno.nome +
   //             " Turma: " + m1.turma.serie  + " - " + m1.turma.nome);
        
        
        
     
        
    }
    
}
