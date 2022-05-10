package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.domain.Account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class AccountDAO implements IAccountDAO {

    @Override
    public void getAccountByClientId() {
        //TODO
    }

    @Override
    public Account getEntityById(long id) throws IOException, SQLException, ClassNotFoundException {
        Properties p = readPropertiesFile("C:\\Users\\cocob\\IdeaProjects\\Solvd-laba-DB\\src\\main\\resources\\db.properties");
        String url = p.getProperty("db.url");
        String user = p.getProperty("db.username");
        String password = p.getProperty("db.pass");

        Class.forName("com.mysql.jdbc.Driver");
        PreparedStatement pr = null;
        ResultSet rs = null;
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            pr = con.prepareStatement("SELECT balance FROM Accounts WHERE idAccounts=?");
            pr.setLong(1, id);
            rs = pr.executeQuery();

            Account account = new Account();
            rs.next();
            account.setBalance(Double.parseDouble(rs.getString("balance")));

            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            pr.close();
            rs.close();
        }

        return null;
    }

    @Override
    public void saveEntity(Account entity) {

    }

    @Override
    public void updateEntity(Account entity) {

    }

    @Override
    public void removeEntity(long id) {

    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
