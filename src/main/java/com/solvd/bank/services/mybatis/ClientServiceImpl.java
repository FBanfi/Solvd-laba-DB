package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.dao.ICardDAO;
import com.solvd.bank.dao.IClientDAO;
import com.solvd.bank.domain.Client;
import com.solvd.bank.exceptions.ServiceException;
import com.solvd.bank.services.IClientService;
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

public class ClientServiceImpl extends AbstractSQLSession implements IClientService {

  @Override
  public Client getClient(long id) {
    try(SqlSession session = getSession()) {
      IClientDAO clientDAO = session.getMapper(IClientDAO.class);
      return clientDAO.getEntityById(id);
    } catch (SQLException | IOException | ClassNotFoundException e) {
      throw new ServiceException("There was an error using mybatis service: " + e);
    }
  }

  @Override
  public void saveClient(Client client) {
    try(SqlSession session = getSession()) {
      IClientDAO clientDAO = session.getMapper(IClientDAO.class);
      clientDAO.saveEntity(client);
      session.commit();
    }
  }

  @Override
  public void deleteClient(long id) {
    try(SqlSession session = getSession()) {
      IClientDAO clientDAO = session.getMapper(IClientDAO.class);
      clientDAO.removeEntity(id);
      session.commit();
    }
  }

  @Override
  public void updateClientById(long id, Client client) {
    try(SqlSession session = getSession()) {
      IClientDAO clientDAO = session.getMapper(IClientDAO.class);
      clientDAO.updateEntity(id,client);
      session.commit();
    }
  }

  @Override
  public Client getClientByLastName(String lastName) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
