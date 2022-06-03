package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.ICardDAO;
import com.solvd.bank.domain.Card;
import com.solvd.bank.services.ICardService;
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

public class CardServiceImpl implements ICardService {
  private final static Logger LOGGER = LogManager.getLogger(CardServiceImpl.class);

  @Override
  public Card getCard(long id) {
    ICardDAO cardDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      cardDAO = sqlSessionFactory.openSession().getMapper(ICardDAO.class);
      cardDAO.getEntityById(id);
    } catch (SQLException | IOException | ClassNotFoundException e) {
      LOGGER.info("There was a problem while trying to do the select statement with mybatis" + e);
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public void saveCard(Card card) {
    ICardDAO cardDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      SqlSession session = sqlSessionFactory.openSession();
      cardDAO = session.getMapper(ICardDAO.class);
      cardDAO.saveEntity(card);
      session.commit();
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the insert statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteCard(long id) {
    ICardDAO cardDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      SqlSession session = sqlSessionFactory.openSession();
      cardDAO = session.getMapper(ICardDAO.class);
      cardDAO.removeEntity(id);
      session.commit();
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the delete statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void updateCardById(long id, Card cardWithNewValues) {
    ICardDAO cardDAO;
    try {
      Reader reader = Resources.getResourceAsReader(IDBConstants.MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      SqlSession session = sqlSessionFactory.openSession();
      cardDAO = session.getMapper(ICardDAO.class);
      cardDAO.updateEntity(id,cardWithNewValues);
      session.commit();
    } catch (IOException e) {
      LOGGER.info("There was a problem while trying to do the update statement with mybatis" + e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public Card getCardByAccount(long i) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
