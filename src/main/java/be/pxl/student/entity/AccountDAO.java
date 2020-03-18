package be.pxl.student.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DAO<Account, AccountException>
{
    private DAOManager manager;

    public AccountDAO(DAOManager manager) {
        this.manager = manager;
    }

    @Override
    public Account create(Account account) throws AccountException {
        try(PreparedStatement preparedStatement = manager.getConnection().prepareStatement("insert into Account (`IBAN`, `name`) values(?, ?)")) {
            preparedStatement.setString(1, account.getIBAN());
            preparedStatement.setString(2, account.getName());
            int result = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.first()) {
                int accountId = generatedKeys.getInt(1);
                account.setId(accountId);
            }

            if(result == 1) {
                return account;
            }

            manager.commit();

        } catch (SQLException e) {
            manager.rollback(e);
            throw new AccountException(e);
        }

        throw new AccountException("Could not create Account");
    }

    @Override
    public List<Account> getAll() throws AccountException {
        List<Account> accountList = new ArrayList<>();
        try(PreparedStatement preparedStatement = manager.getConnection().prepareStatement("select * from Account")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                accountList.add(
                        new Account(
                                resultSet.getInt("id"),
                                resultSet.getString("IBAN"),
                                resultSet.getString("name")
                        )
                );
            }
        } catch (SQLException e) {
            throw new AccountException(e);
        }
        return accountList;
    }

    @Override
    public Account getById(int id) throws AccountException {
        try (PreparedStatement preparedStatement = manager.getConnection().prepareStatement("select * from Account where id = ?;")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                return new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("IBAN"),
                        resultSet.getString("name")
                );
            } else {
                throw new AccountNotFoundException(String.format("Account with id %d not found", id));
            }
        } catch (SQLException e) {
            throw new AccountException(e);
        }
    }

    @Override
    public Account update(Account account) throws AccountException {
        throw new AccountException("Not yet implemented");
    }

    @Override
    public Account delete(Account account) throws AccountException {
        throw new AccountException("Not yet implemented");
    }
}
