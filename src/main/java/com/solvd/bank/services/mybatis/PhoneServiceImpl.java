package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IManagerDAO;
import com.solvd.bank.dao.IPhoneDAO;
import com.solvd.bank.domain.Phone;
import com.solvd.bank.exceptions.ServiceException;
import com.solvd.bank.services.IPoneService;
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

public class PhoneServiceImpl extends AbstractSQLSession implements IPoneService {

  @Override
  public Phone getPhone(long id) {
    try(SqlSession session = getSession()) {
      IPhoneDAO phoneDAO = session.getMapper(IPhoneDAO.class);
      return phoneDAO.getEntityById(id);
    } catch (SQLException | IOException | ClassNotFoundException e) {
      throw new ServiceException("There was an error using mybatis service: " + e);
    }
  }

  @Override
  public Phone getPhoneByClientId(long id) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
