import java.sql.*;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Boton ventana= new Boton();
        ventana.setVisible(true);
        /*
        String url = "jdbc:mysql://localhost:3306/esfotventas";
        String user = "root";
        String password = "";

        try(Connection conex = DriverManager.getConnection(url,user,password) ){
            if(conex != null){
                System.out.println("Conectado");
            }else {
                System.out.println("Error");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        */
    }
}