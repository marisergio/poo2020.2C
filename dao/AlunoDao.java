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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao extends Dao {

    public Boolean atulizar(Aluno a) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("update cliente set nome=? where id=?");
            stmt.setString(1, a.getNome());
            stmt.setInt(2, a.getId());
            stmt.executeUpdate();
            stmt.close();
            ConnectionFactoy.closeConexao(this.con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Integer salvar(Aluno a) {
        Integer last_inserted_id = null;
        try {

            PreparedStatement stmt = this.con.prepareStatement("insert into cliente(nome,cpf)values(?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getMatricula());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                last_inserted_id = rs.getInt(1);
            }

            stmt.close();
            ConnectionFactoy.closeConexao(this.con);

        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_inserted_id;
    }

    public Boolean delete(Integer id) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("delete from cliente where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            ConnectionFactoy.closeConexao(this.con);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Aluno> getAlunos() {
        try {
            
            List<Aluno> alunos = new ArrayList<>();

            PreparedStatement stmt = this.con.prepareStatement("select id, nome, cpf from cliente");
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
            ConnectionFactoy.closeConexao(this.con);
            
            return alunos;

        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
        public Aluno buscarPorId(Integer id) {
        try {
            Aluno a = new Aluno();
            

            PreparedStatement stmt = this.con.prepareStatement("select id, nome, cpf from cliente where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {               
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setMatricula(rs.getString("cpf"));
            }
            rs.close();
            stmt.close();
            ConnectionFactoy.closeConexao(this.con);
            
            return a;

        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
