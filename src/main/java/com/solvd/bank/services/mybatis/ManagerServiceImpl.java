package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IClientDAO;
import com.solvd.bank.dao.IManagerDAO;
import com.solvd.bank.domain.Manager;
import com.solvd.bank.exceptions.ServiceException;
import com.solvd.bank.services.IManagerService;
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

public class ManagerServiceImpl extends AbstractSQLSession implements IManagerService {

  @Override
  public Manager getManager(long id) {
    try(SqlSession session = getSession()) {
      IManagerDAO managerDAO = session.getMapper(IManagerDAO.class);
      return managerDAO.getEntityById(id);
    } catch (SQLException | IOException | ClassNotFoundException e) {
      throw new ServiceException("There was an error using mybatis service: " + e);
    }
  }

  @Override
  public Manager getManagerByPhoneId(long id) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
