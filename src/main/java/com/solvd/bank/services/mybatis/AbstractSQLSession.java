package com.solvd.bank.services.mybatis;

import com.solvd.bank.exceptions.SessionException;
import com.solvd.bank.utils.connectionPool.IDBConstants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

public class AbstractSQLSession {

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
