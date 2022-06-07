package com.solvd.bank.services.mybatis;

import com.solvd.bank.exceptions.SessionException;
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

public class AbstractSQLSession {

  private static final Logger LOGGER = LogManager.getLogger(AbstractSQLSession.class);

  public SqlSession getSession() {
    Reader e = null;
    try {
      e = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
    } catch (IOException ex) {
      throw new SessionException("Cant open the session" + ex);
    }
    SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
    return sql.openSession();
  }

}
