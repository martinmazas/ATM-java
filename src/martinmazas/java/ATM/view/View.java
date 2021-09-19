package martinmazas.java.ATM.view;

import martinmazas.java.ATM.viewmodel.IViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements IView {
    private IViewModel vm;
    private ApplicationUI ui;

    public View() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View.this.ui = new ApplicationUI();
                View.this.ui.init();
            }
        });
    }

    public static class ApplicationUI
    {
        private JFrame initialFrame, registerFrame, loginFrame;
        private JPanel initialPanel, initialButtonsPanel, registerPanel, registerButtonsPanel, loginPanel,
                loginButtonsPanel;
        private JLabel welcomeLabel, registerLabel, loginLabel;
        private JButton registerButton, loginButton, backRegisterButton, registerButton2, backLoginButton, loginButton2;

        public ApplicationUI() {
            initialFrame = new JFrame("ATM");
            initial();
            initialFrame.setVisible(true);
        }

        public void initial() {
            // loginPanel
            initialPanel = new JPanel();
            initialPanel.setLayout(new FlowLayout());
            initialPanel.setBackground(Color.white);

            // welcomeLabel
            welcomeLabel = new JLabel("Welcome to ATM service");
            welcomeLabel.setFont(new Font("Verdana",Font.PLAIN,25));

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
            initialFrame.setLayout(new GridLayout(2,2));
            initialFrame.add(initialPanel);
            initialFrame.add(initialButtonsPanel);
            initialFrame.setSize(500,500);
            initialFrame.setLocationRelativeTo(null);
            initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    initialFrame.setVisible(false);
                    registerFrame.setVisible(true);
                }
            });

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    initialFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
            });
        }

        public void register() {
            registerFrame = new JFrame("Register");
            registerPanel = new JPanel();

            registerPanel.setLayout(new FlowLayout());
            registerPanel.setBackground(Color.white);

            registerLabel = new JLabel("Please fill your data to register");
            registerLabel.setFont(new Font("Verdana",Font.PLAIN,25));
            registerPanel.add(registerLabel);

            registerButtonsPanel = new JPanel();
            registerButtonsPanel.setBackground(Color.white);
            backRegisterButton = new JButton("Back");
            registerButton2 = new JButton("Register");
            registerButtonsPanel.add(backRegisterButton);
            registerButtonsPanel.add(registerButton2);

            registerFrame.add(registerPanel);
            registerFrame.add(registerButtonsPanel);

            registerFrame.setLayout(new GridLayout(2,2));
            registerFrame.setSize(500, 500);
            registerFrame.setLocationRelativeTo(null);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            backRegisterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerFrame.setVisible(false);
                    initialFrame.setVisible(true);
                }
            });
        }

        public void login() {
            loginFrame = new JFrame("Login");
            loginPanel = new JPanel();
            loginPanel.setLayout(new FlowLayout());
            loginPanel.setBackground(Color.white);

            loginLabel = new JLabel("Login");
            loginLabel.setFont(new Font("Verdana",Font.PLAIN,25));
            loginPanel.add(loginLabel);

            loginButtonsPanel = new JPanel();
            loginButtonsPanel.setBackground(Color.white);
            backLoginButton = new JButton("Back");
            loginButton2 = new JButton("Login");
            loginButtonsPanel.add(backLoginButton);
            loginButtonsPanel.add(loginButton2);

            loginFrame.add(loginPanel);
            loginFrame.add(loginButtonsPanel);

            loginFrame.setLayout(new GridLayout(2,2));
            loginFrame.setSize(500, 500);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            backLoginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginFrame.setVisible(false);
                    initialFrame.setVisible(true);
                }
            });

        }

        public void init() {
            register();
            login();
        }
    }
}