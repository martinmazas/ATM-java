package martinmazas.java.ATM.model;

import java.sql.*;

public class DerbyDBModel implements IModel {
    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:atmDB;create=true";

    public void createTable(String tableName, String columns) throws ATMException {
        Connection connection;
        Statement statement;
//        ResultSet rs = null;

        String query = "CREATE TABLE " + tableName + " " + columns;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(protocol);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ATMException("Problem with the connection", e);
        }

        try {
            statement.execute(query);
            System.out.println("Table " + tableName + " created successfully");
        } catch (SQLException e) {
            throw new ATMException("Problem with creation a table!", e);
        }

        try {
            statement.close();
        } catch (SQLException e) {
            throw new ATMException("Problem with closing statement!", e);
        }
    }

    public void deleteTable(String tableName) throws ATMException {
        Connection connection;
        Statement statement;
//        ResultSet rs = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(protocol);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ATMException("Problem with the connection", e);
        }

        String query = "DROP table " + tableName;
        try {
            statement.execute(query);
            System.out.println("Deleted table " + tableName);
        } catch (SQLException e) {
            throw new ATMException("Problem with adding cost!", e);
        }

        try {
            statement.close();
        } catch (SQLException e) {
            throw new ATMException("Problem with closing statement!", e);
        }
    }

    @Override
    public void addUser(User user) throws ATMException {
        // Need to make a query to add user
    }
}
