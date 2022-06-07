package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.domain.Account;
import com.solvd.bank.exceptions.ServiceException;
import com.solvd.bank.services.IAccountService;
import com.solvd.bank.utils.connectionPool.DBPropertiesUtil;
import com.solvd.bank.utils.connectionPool.IDBConstants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class AccountServiceImpl extends AbstractSQLSession implements IAccountService {

  @Override
  public Account getAccount(long id) {
    try(SqlSession session = getSession()) {
      IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
      return accountDAO.getEntityById(id);
    } catch (SQLException | IOException | ClassNotFoundException e) {
      throw new ServiceException("There was an error using mybatis service: " + e);
    }
  }

  @Override
  public void saveAccount(Account account) {
    try(SqlSession session = getSession()) {
      IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
      accountDAO.saveEntity(account);
      session.commit();
    }
  }

  @Override
  public void deleteAccount(long id) {
    try(SqlSession session = getSession()) {
      IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
      accountDAO.removeEntity(id);
      session.commit();
    }
  }

  @Override
  public void updateAccountById(long id, Account accountWithNewValues) {
    try(SqlSession session = getSession()) {
      IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
      accountDAO.updateEntity(id,accountWithNewValues);
      session.commit();
    }
  }

  @Override
  public Account getAccountByAlias(String alias) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
