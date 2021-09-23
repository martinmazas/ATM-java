package martinmazas.java.ATM.view;

import martinmazas.java.ATM.viewmodel.IViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class View implements IView {
    private IViewModel vm;
    private ApplicationUI ui;

    public View() {
        SwingUtilities.invokeLater(() -> {
            View.this.ui = new ApplicationUI();
            View.this.ui.init();
        });
    }

    public static class ApplicationUI {
        private final JFrame initialFrame;
        private JFrame registerFrame;
        private JFrame loginFrame;

        public ApplicationUI() {
            initialFrame = new JFrame("ATM");
            initial();
            initialFrame.setVisible(true);
        }

        public void initial() {
            JPanel initialPanel, initialButtonsPanel;
            JLabel welcomeLabel;
            JButton registerButton, loginButton;
            // loginPanel
            initialPanel = new JPanel();
            initialPanel.setLayout(new FlowLayout());
            initialPanel.setBackground(Color.white);

            // welcomeLabel
            welcomeLabel = new JLabel("Welcome to ATM service");
            welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 25));

            // Login Buttons
            initialButtonsPanel = new JPanel();
            initialButtonsPanel.setBackground(Color.white);
            registerButton = new JButton();
            registerButton.setText("Register");
            loginButton = new JButton();
            loginButton.setText("Login");

            initialPanel.add(welcomeLabel);
            initialButtonsPanel.add(registerButton);
            initialButtonsPanel.add(loginButton);

            // login Frame
            initialFrame.setLayout(new GridLayout(2, 2));
            initialFrame.add(initialPanel);
            initialFrame.add(initialButtonsPanel);
            initialFrame.setSize(500, 500);
            initialFrame.setLocationRelativeTo(null);
            initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            registerButton.addActionListener(e -> {
                initialFrame.setVisible(false);
                registerFrame.setVisible(true);
            });

            loginButton.addActionListener(e -> {
                initialFrame.setVisible(false);
                loginFrame.setVisible(true);
            });
        }

        public void register() {
            JLabel nameLabel, idLabel, pinLabel, confirmPinLabel, registerLabel;
            JTextField nameField, idField;
            JPanel registerLabelsPanel, registerPanel, namePanel, idPanel, pinPanel, confirmPinPanel, registerButtonsPanel;
            JPasswordField pinField, confirmPinField;
            JButton backButton, registerButton;

            registerFrame = new JFrame("Register");

            registerPanel = new JPanel();
            registerPanel.setLayout(new FlowLayout());
            registerPanel.setBackground(Color.WHITE);

            registerLabel = new JLabel("Please fill your data to register");
            registerLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
            registerPanel.add(registerLabel);

            // Form
            registerLabelsPanel = new JPanel();
            registerLabelsPanel.setLayout(new BoxLayout(registerLabelsPanel, BoxLayout.Y_AXIS));
            registerLabelsPanel.setBackground(Color.WHITE);

            // name label
            nameLabel = new JLabel("Name");
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            nameField = new JTextField(10);
            nameField.setFont(new Font("Arial", Font.PLAIN, 15));

            // id label
            idLabel = new JLabel("Personal id");
            idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            idField = new JTextField(10);
            idField.setFont(new Font("Arial", Font.PLAIN, 15));

            // pin label
            pinLabel = new JLabel("Pin");
            pinLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            pinField = new JPasswordField(10);
            pinField.setFont(new Font("Arial", Font.PLAIN, 15));

            // confirm pin label
            confirmPinLabel = new JLabel("Pin confirmation");
            confirmPinLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            confirmPinField = new JPasswordField(10);
            confirmPinField.setFont(new Font("Arial", Font.PLAIN, 15));

            namePanel = new JPanel();
            namePanel.setBackground(Color.WHITE);
            namePanel.add(nameLabel);
            namePanel.add(nameField);

            idPanel = new JPanel();
            idPanel.setBackground(Color.WHITE);
            idPanel.add(idLabel);
            idPanel.add(idField);

            pinPanel = new JPanel();
            pinPanel.setBackground(Color.WHITE);
            pinPanel.add(pinLabel);
            pinPanel.add(pinField);

            confirmPinPanel = new JPanel();
            confirmPinPanel.setBackground(Color.WHITE);
            confirmPinPanel.add(confirmPinLabel);
            confirmPinPanel.add(confirmPinField);

            registerLabelsPanel.add(namePanel);
            registerLabelsPanel.add(idPanel);
            registerLabelsPanel.add(pinPanel);
            registerLabelsPanel.add(confirmPinPanel);

            registerButtonsPanel = new JPanel();
            registerButtonsPanel.setBackground(Color.white);
            backButton = new JButton("Back");
            registerButton = new JButton("Register");
            registerButtonsPanel.add(backButton);
            registerButtonsPanel.add(registerButton);

            registerFrame.add(registerPanel);
            registerFrame.add(registerLabelsPanel);
            registerFrame.add(registerButtonsPanel);

            registerFrame.setLayout(new GridLayout(3, 2));
            registerFrame.setSize(500, 500);
            registerFrame.setLocationRelativeTo(null);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            backButton.addActionListener(e -> {
                registerFrame.setVisible(false);
                initialFrame.setVisible(true);
            });

            registerButton.addActionListener(e -> {
                System.out.println(nameField.getText());
                System.out.println(idField.getText());
                System.out.println(pinField.getPassword());
                System.out.println(confirmPinField.getPassword());
                System.out.println(Arrays.equals(pinField.getPassword(), confirmPinField.getPassword()));
                nameField.setText("");
                idField.setText("");
                pinField.setText("");
                confirmPinField.setText("");
            });
        }

        public void login() {
            JPanel loginPanel, loginButtonsPanel, userPanel, pinPanel, loginLabelsPanel;
            JLabel loginLabel, userLabel, pinLabel;
            JButton backButton, loginButton;
            JTextField userField;
            JPasswordField pinField;

            loginFrame = new JFrame("Login");
            loginPanel = new JPanel();
            loginPanel.setLayout(new FlowLayout());
            loginPanel.setBackground(Color.white);

            loginLabel = new JLabel("Login");
            loginLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
            loginPanel.add(loginLabel);

            loginLabelsPanel = new JPanel();
            loginLabelsPanel.setLayout(new BoxLayout(loginLabelsPanel, BoxLayout.Y_AXIS));
            loginLabelsPanel.setBackground(Color.WHITE);

            // user
            userLabel = new JLabel("User");
            userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            userField = new JTextField(10);
            userField.setFont(new Font("Arial", Font.PLAIN, 15));

            //pin
            pinLabel = new JLabel("Pin");
            pinLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            pinField = new JPasswordField(10);
            pinField.setFont(new Font("Arial", Font.PLAIN, 15));

            userPanel = new JPanel();
            userPanel.setBackground(Color.WHITE);
            userPanel.add(userLabel);
            userPanel.add(userField);

            pinPanel = new JPanel();
            pinPanel.setBackground(Color.WHITE);
            pinPanel.add(pinLabel);
            pinPanel.add(pinField);

            loginLabelsPanel.add(userPanel);
            loginLabelsPanel.add(pinPanel);

            loginButtonsPanel = new JPanel();
            loginButtonsPanel.setBackground(Color.white);
            backButton = new JButton("Back");
            loginButton = new JButton("Login");
            loginButtonsPanel.add(backButton);
            loginButtonsPanel.add(loginButton);

            loginFrame.add(loginPanel);
            loginFrame.add(loginLabelsPanel);
            loginFrame.add(loginButtonsPanel);

            loginFrame.setLayout(new GridLayout(3, 2));
            loginFrame.setSize(500, 500);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            backButton.addActionListener(e -> {
                loginFrame.setVisible(false);
                initialFrame.setVisible(true);
            });

            loginButton.addActionListener(e -> {
                System.out.println(userField.getText());
                System.out.println(pinField.getPassword());
                userField.setText("");
                pinField.setText("");
            });

        }

        public void init() {
            register();
            login();
        }
    }
}