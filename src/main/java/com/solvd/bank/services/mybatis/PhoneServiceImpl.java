package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IManagerDAO;
import com.solvd.bank.dao.IPhoneDAO;
import com.solvd.bank.domain.Phone;
import com.solvd.bank.services.IPoneService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class PhoneServiceImpl implements IPoneService {
  private final static Logger LOGGER = LogManager.getLogger(PhoneServiceImpl.class);
  @Override
  public Phone getPhone(long id) {
    IPhoneDAO iPhoneDAO;
    try {
      Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      iPhoneDAO = sqlSessionFactory.openSession().getMapper(IPhoneDAO.class);
      iPhoneDAO.getEntityById(id);
    } catch (IOException | SQLException | ClassNotFoundException e) {
      LOGGER.info("There was a problem while trying to do the select statement with mybatis" + e);
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public Phone getPhoneByClientId(long id) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}