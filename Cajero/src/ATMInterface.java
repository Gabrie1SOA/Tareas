import javax.swing.*;
import java.awt.*;

public class ATMInterface extends JFrame {
    private static final String pass = "1234";
    private static final double balance = 200.00;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ATMInterface() {
        setTitle("Banco del Búho");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Pantalla de bienvenida
        JPanel welcomePanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Bienvenido al Banco del Búho", SwingConstants.CENTER);
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomePanel.add(passwordField, BorderLayout.CENTER);
        welcomePanel.add(loginButton, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String password = new String(passwordField.getPassword());
            if (pass.equals(password)) {
                cardLayout.show(mainPanel, "menu");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Menú de opciones
        JPanel menuPanel = new JPanel(new GridLayout(4, 1));
        JButton balanceButton = new JButton("Ver Saldo");
        JButton withdrawButton = new JButton("Retiro");
        JButton depositButton = new JButton("Depósito");
        JButton exitButton = new JButton("Salir");

        menuPanel.add(balanceButton);
        menuPanel.add(withdrawButton);
        menuPanel.add(depositButton);
        menuPanel.add(exitButton);

        balanceButton.addActionListener(e -> cardLayout.show(mainPanel, "balance"));
        withdrawButton.addActionListener(e -> cardLayout.show(mainPanel, "withdraw"));
        depositButton.addActionListener(e -> cardLayout.show(mainPanel, "deposit"));
        exitButton.addActionListener(e -> System.exit(0));

        // Pantalla de ver saldo
        JPanel balancePanel = new JPanel(new BorderLayout());
        JLabel balanceLabel = new JLabel("Saldo: $" + balance, SwingConstants.CENTER);
        JButton balanceMenuButton = new JButton("Menú");

        balancePanel.add(balanceLabel, BorderLayout.CENTER);
        balancePanel.add(balanceMenuButton, BorderLayout.SOUTH);

        balanceMenuButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        // Pantalla de retiro
        JPanel withdrawPanel = new JPanel(new BorderLayout());
        JTextField withdrawAmountField = new JTextField();
        JButton withdrawMenuButton = new JButton("Menú");

        withdrawPanel.add(new JLabel("Retiro:", SwingConstants.CENTER), BorderLayout.NORTH);
        withdrawPanel.add(withdrawAmountField, BorderLayout.CENTER);
        withdrawPanel.add(withdrawMenuButton, BorderLayout.SOUTH);

        withdrawMenuButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        // Pantalla de depósito
        JPanel depositPanel = new JPanel(new BorderLayout());
        JTextField depositAmountField = new JTextField();
        JButton depositMenuButton = new JButton("Menú");

        depositPanel.add(new JLabel("Depósito:", SwingConstants.CENTER), BorderLayout.NORTH);
        depositPanel.add(depositAmountField, BorderLayout.CENTER);
        depositPanel.add(depositMenuButton, BorderLayout.SOUTH);

        depositMenuButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        mainPanel.add(welcomePanel, "welcome");
        mainPanel.add(menuPanel, "menu");
        mainPanel.add(balancePanel, "balance");
        mainPanel.add(withdrawPanel, "withdraw");
        mainPanel.add(depositPanel, "deposit");

        add(mainPanel);
        cardLayout.show(mainPanel, "welcome");
    }
}