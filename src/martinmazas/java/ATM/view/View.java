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
        private JFrame loginFrame, registerFrame;
        private JPanel loginPanel, loginButtonsPanel, registerPanel, registerButtonsPanel;
        private JLabel welcomeLabel, registerLabel;
        private JButton registerButton, loginButton, backButton, registerButton2;

        public ApplicationUI() {
            loginFrame = new JFrame("ATM");
            initial();
            loginFrame.setVisible(true);
        }

        public void initial() {
            // loginPanel
            loginPanel = new JPanel();
            loginPanel.setLayout(new FlowLayout());
            loginPanel.setBackground(Color.white);

            // welcomeLabel
            welcomeLabel = new JLabel("Welcome to ATM service");
            welcomeLabel.setFont(new Font("Verdana",Font.PLAIN,25));

            // Login Buttons
            loginButtonsPanel = new JPanel();
            loginButtonsPanel.setBackground(Color.white);
            registerButton = new JButton();
            registerButton.setText("Register");
            loginButton = new JButton();
            loginButton.setText("Login");

            loginPanel.add(welcomeLabel);
            loginButtonsPanel.add(registerButton);
            loginButtonsPanel.add(loginButton);

            // login Frame
            loginFrame.setLayout(new GridLayout(2,2));
            loginFrame.add(loginPanel);
            loginFrame.add(loginButtonsPanel);
            loginFrame.setSize(500,500);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginFrame.setVisible(false);
                    registerFrame.setVisible(true);
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
            backButton = new JButton("Back");
            registerButton2 = new JButton("Register");
            registerButtonsPanel.add(backButton);
            registerButtonsPanel.add(registerButton2);

            registerFrame.add(registerPanel);
            registerFrame.add(registerButtonsPanel);

            registerFrame.setLayout(new GridLayout(2,2));
            registerFrame.setSize(500, 500);
            registerFrame.setLocationRelativeTo(null);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
            });
        }

        public void init() {
            register();
        }
    }
}