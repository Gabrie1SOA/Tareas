import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login extends JFrame{


    private JPanel panel1;
    private JTextField usuario;
    private JTextField password;
    private JButton ENTRAR;
    private JLabel usr;
    private JLabel passw;
    private JLabel log;

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/curso";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }

    public Login() throws SQLException {
        setTitle("Conexion");
        setContentPane(panel1);
        setSize(500, 500);

        String user1= usuario.getText();
        String pass1= password.getText();

        Connection conex = conexion();

        String query1="select nombre from usuariosadministrador;";
        PreparedStatement pstm = conex.prepareStatement(query1);
        String query2="select cedula from usuariosadministrador;";
        PreparedStatement pstm2 = conex.prepareStatement(query2);



        ENTRAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // if(user1 == query1  && pass1==query2){
                    // pasar a la siguiente pantalla
                    JFrame frame = new JFrame("Pantalla1");
                    Pantalla1 pantalla1 = new Pantalla1();
                    frame.setContentPane(pantalla1.getContentPane());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                    dispose();

                    try {
                        pstm.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        pstm2.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        conex.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

               // }else{
                    //JOptionPane.showMessageDialog(null,"Credenciales Incorrectas");
               // }

            }
        });
    }





}
