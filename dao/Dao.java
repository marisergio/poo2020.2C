
package aula4.escola.dao;

import aula4.escola.util.ConnectionFactoy;
import java.sql.Connection;

public class Dao {
    
    protected Connection con;
    
    public Dao(){
        this.con = ConnectionFactoy.getConexao();
    }
    
}
