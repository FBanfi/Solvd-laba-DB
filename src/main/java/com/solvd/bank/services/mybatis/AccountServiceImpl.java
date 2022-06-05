package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.domain.Account;
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

public class AccountServiceImpl implements IAccountService {
  private final static Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);

  @Override
  public Account getAccount(long id) {
    IAccountDAO accountDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      accountDAO = sqlSessionFactory.openSession().getMapper(IAccountDAO.class);
      return accountDAO.getEntityById(id);
    } catch (SQLException | IOException | ClassNotFoundException e) {
      LOGGER.info("There was a problem while trying to do the select statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void saveAccount(Account account) {
    IAccountDAO accountDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      SqlSession session = sqlSessionFactory.openSession();
      accountDAO = session.getMapper(IAccountDAO.class);
      accountDAO.saveEntity(account);
      session.commit();
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the insert statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteAccount(long id) {
    IAccountDAO accountDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      SqlSession session = sqlSessionFactory.openSession();
      accountDAO = session.getMapper(IAccountDAO.class);
      accountDAO.removeEntity(id);
      session.commit();
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the delete statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void updateAccountById(long id, Account accountWithNewValues) {
    IAccountDAO accountDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      SqlSession session = sqlSessionFactory.openSession();
      accountDAO = session.getMapper(IAccountDAO.class);
      accountDAO.updateEntity(id, accountWithNewValues);
      session.commit();
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the update statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public Account getAccountByAlias(String alias) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
