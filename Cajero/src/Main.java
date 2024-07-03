import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATMInterface atm = new ATMInterface();
            atm.setVisible(true);
        });
    }
}