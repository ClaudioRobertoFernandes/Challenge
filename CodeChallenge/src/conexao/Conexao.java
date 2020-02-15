package conexao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static String usuario="root";
    private static String senha="";
    private static String banco="zen";
    private static String ip="127.0.0.1:3306";
    private static String driver="com.mysql.jdbc.Driver";
    private static Connection conexao = null;
    
    public static Connection getConnection() {
        System.out.println(">>Conectando ao banco");
        try {
            Class.forName(driver);
            if(conexao==null || conexao.isClosed()){
                conexao=DriverManager.getConnection("jdbc:mysql://"+ip+"/"+banco+"",usuario, senha);
            }
            return conexao; 
        }catch (ClassNotFoundException e) {    
            throw new RuntimeException(e);    
        }catch (SQLException e) {

            closeConnection();
            throw new RuntimeException(e);
        }

    }

    public static void closeConnection(){
        try{
            if(conexao!=null && !conexao.isClosed()){
                conexao.close();
                System.out.println(">>Conexao encerrada com sucesso");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
