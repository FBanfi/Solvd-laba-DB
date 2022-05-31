package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IClientDAO;
import com.solvd.bank.domain.Client;
import com.solvd.bank.services.IClientService;
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

public class ClientServiceImpl implements IClientService {
  private final static Logger LOGGER = LogManager.getLogger(ClientServiceImpl.class);
  private final static String MYBATIS_CONFIG = DBPropertiesUtil.getInstance().getString(IDBConstants.MYBATIS_CONFIG);

  @Override
  public Client getClient(long id) {
    IClientDAO clientDAO;
    try {
      Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      clientDAO = sqlSessionFactory.openSession().getMapper(IClientDAO.class);
      clientDAO.getEntityById(id);
    } catch (IOException | SQLException | ClassNotFoundException e) {
      LOGGER.info("There was a problem while trying to do the select statement with mybatis" + e);
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public void saveClient(Client client) {
    IClientDAO clientDAO;
    try {
      Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      clientDAO = sqlSessionFactory.openSession().getMapper(IClientDAO.class);
      clientDAO.saveEntity(client);
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the insert statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteClient(long id) {
    IClientDAO clientDAO;
    try {
      Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      clientDAO = sqlSessionFactory.openSession().getMapper(IClientDAO.class);
      clientDAO.removeEntity(id);
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the delete statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void updateClientById(long id, Client client) {
    IClientDAO clientDAO;
    try {
      Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      clientDAO = sqlSessionFactory.openSession().getMapper(IClientDAO.class);
      clientDAO.updateEntity(id,client);
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the update statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public Client getClientByLastName(String lastName) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
