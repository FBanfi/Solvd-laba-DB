package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IManagerDAO;
import com.solvd.bank.domain.Manager;
import com.solvd.bank.services.IManagerService;
import com.solvd.bank.utils.connectionPool.DBPropertiesUtil;
import com.solvd.bank.utils.connectionPool.IDBConstants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class ManagerServiceImpl implements IManagerService {
  private final static Logger LOGGER = LogManager.getLogger(ManagerServiceImpl.class);

  @Override
  public Manager getManager(long id) {
    IManagerDAO managerDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      managerDAO = sqlSessionFactory.openSession().getMapper(IManagerDAO.class);
      managerDAO.getEntityById(id);
    } catch (IOException | SQLException | ClassNotFoundException e) {
      LOGGER.info("There was a problem while trying to do the select statement with mybatis" + e);
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public Manager getManagerByPhoneId(long id) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
