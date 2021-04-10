
package aula4.escola.dao;

import aula4.escola.app.App1;
import aula4.escola.modelo.Aluno;
import aula4.escola.util.ConnectionFactoy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlunoDao {
    
    public static void atulizar(Aluno a) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sibd1", "root", "");
            PreparedStatement stmt = con.prepareStatement("update cliente set nome=? where id=?");
            stmt.setString(1, a.getNome());
            stmt.setInt(2, a.getId());
            stmt.executeUpdate();
            stmt.close();
             ConnectionFactoy.closeConexao(con);

        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Integer salvar(Aluno a) {
        Integer last_inserted_id = null;
        try {
            
            Connection con = ConnectionFactoy.getConexao();
            PreparedStatement stmt = con.prepareStatement("insert into cliente(nome,cpf)values(?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getMatricula());
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    last_inserted_id = rs.getInt(1);
                }

            stmt.close();
            ConnectionFactoy.closeConexao(con);
            

        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_inserted_id;
    }

    public static void delete(Integer id) {
        try {
            Connection con = ConnectionFactoy.getConexao();
            PreparedStatement stmt = con.prepareStatement("delete from cliente where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            ConnectionFactoy.closeConexao(con);
        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getAlunos(List<Aluno> alunos){
        try {
                    Connection con = ConnectionFactoy.getConexao();
                    PreparedStatement stmt = con.prepareStatement("select id, nome, cpf from cliente");
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        Aluno a = new Aluno();
                        a.setId(rs.getInt("id"));
                        a.setNome(rs.getString("nome"));
                        a.setMatricula(rs.getString("cpf"));
                        alunos.add(a);
                    }
                    rs.close();
                    stmt.close();
                     ConnectionFactoy.closeConexao(con);

                } catch (SQLException ex) {
                    Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
    
}
