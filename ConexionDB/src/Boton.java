import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Boton extends JFrame {
    private JButton button1;
    private JPanel panel1;
    private JLabel nombre;
    private JLabel edad;
    private JTextField nombreT;
    private JTextField edadT;
    private JTextField nota1T;
    private JTextField nota2T;
    private JButton consulta;
    private JLabel label;


    public void visual() throws  SQLException{
        String name = nombreT.getText();
        Connection conex =conexion ();
        String sql="SELECT * FROM estudiante WHERE nombre=?;";
        PreparedStatement pstm = conex.prepareStatement(sql);
        pstm.setString(1,name);
        ResultSet rs=pstm.executeQuery();

        if(rs.next()){
            String age= rs.getString("edad");
            JOptionPane.showMessageDialog(null,"Nombre: "+name+" Edad: "+age);

        }

        rs.close();
        pstm.close();
        conex.close();
    }

    public void Insertar()throws SQLException{

        String name= nombreT.getText(); // OBTIENE INFORMACION DE TEXTO
        String age=edadT.getText();
        String nota1=nota1T.getText();
        String nota2=nota2T.getText();

        Connection conex =conexion ();
        // valores no fijos
        String query="INSERT INTO estudiante (nombre,edad,nota1,nota2) VALUES (?,?,?,?);";

        //cadena de conexion setea la informacion
        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1,name);
        pstm.setInt(2,Integer.parseInt(age));
        pstm.setDouble(3,Double.parseDouble(nota1));
        pstm.setDouble(4,Double.parseDouble(nota2));

        //ACTUALIZACION
        int rowsAffected=pstm.executeUpdate();
        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null,"INSERTADO");
        }

        pstm.close();
        conex.close();

    }

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/esfotventas";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

    public Boton(){
        setTitle("Conexion");
        setContentPane(panel1);
        setSize(500, 500);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conexion();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    Insertar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });


        consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conexion();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    visual();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

}
