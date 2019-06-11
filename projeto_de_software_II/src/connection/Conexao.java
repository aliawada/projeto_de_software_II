/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.sql.Connection;

/**
 *
 * @author admin
 */
public class Conexao {
    protected Connection conexao;
    protected static String info = "";

    /**
     * @return the conexao
     */
    protected Connection getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    protected void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public static String getInfo() {
        return info;
    }
}
