package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private Connection conexao = null;
    
    public String conectar(){
        try {
        	
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            String url = "jdbc:mysql://localhost/psw?useTimezone=true&serverTimezone=UTC"; // a JDBC url
            setConexao(DriverManager.getConnection(url, "root", "root"));
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no driver de conexao MySQL!");
            e.printStackTrace();
            return e.getMessage();
        } catch (SQLException e) {
            System.out.println("Erro na conexão do Banco!");
            e.printStackTrace();
            return e.getMessage();
        }
        return "true";
    }


    public boolean desconectar(){
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao desconectar do banco");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @return the conexao
     */
    public Connection getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    

    


}
