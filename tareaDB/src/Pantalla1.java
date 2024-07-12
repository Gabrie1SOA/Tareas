import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Pantalla1 extends JFrame{

    private JTextField codmat;
    private JTextField name;
    private JTextField direct;
    private JTextField age;
    private JTextField phone;
    private JTextField email;
    private JTextField nota1T;
    private JTextField nota2T;
    private JButton INSERTARButton;
    private JButton CONSULTARButton;
    private JLabel bienvenido;
    private JLabel cod;
    private JLabel nom;
    private JLabel dir;
    private JLabel ag;
    private JLabel tel;
    private JLabel mail;
    private JLabel not1;
    private JLabel not2;
    private JPanel pantalla1;

    public void visual() throws  SQLException{
        String codigo = codmat.getText();

        Connection conex =conexion ();
        String sql="SELECT * FROM estudiantes WHERE codigo_matricula=?;";

        PreparedStatement pstm = conex.prepareStatement(sql);
        pstm.setString(1,codigo);

        ResultSet rs=pstm.executeQuery();
        if(rs.next()){
            String name2= rs.getString("nombre_apellido");
            JOptionPane.showMessageDialog(null,"Codigo: "+codigo+" Nombre: "+name2);

        }

        rs.close();
        pstm.close();
        conex.close();
    }

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/curso";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }

    public void Insertar()throws SQLException{
        String code = codmat.getText();
        String names = name.getText(); // OBTIENE INFORMACION DE TEXTO
        String direc= direct.getText();
        String ages = age.getText();
        String cel = phone.getText();
        String mail = email.getText();
        String nota1=nota1T.getText();
        String nota2=nota2T.getText();

        Connection conex =conexion ();
        // valores no fijos
        String query="insert into estudiantes(codigo_matricula,nombre_apellido,direccion,edad,telefono,correo,nota1,nota2) VALUES (?,?,?,?,?,?,?,?);";

        //cadena de conexion setea la informacion
        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1,code);
        pstm.setString(2,names);
        pstm.setString(3,direc);
        pstm.setInt(4,Integer.parseInt(ages));
        pstm.setString(5,cel);
        pstm.setString(6,mail);
        pstm.setDouble(7,Double.parseDouble(nota1));
        pstm.setDouble(8,Double.parseDouble(nota2));

        //ACTUALIZACION
        int rowsAffected=pstm.executeUpdate();
        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null,"INSERTADO");
        }

        pstm.close();
        conex.close();

    }

    public Pantalla1() {

        setContentPane(pantalla1);
        setSize(500, 500);

        INSERTARButton.addActionListener(new ActionListener() {
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


        CONSULTARButton.addActionListener(new ActionListener() {
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
