package com.solvd.bank.services.mybatis;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.dao.ICardDAO;
import com.solvd.bank.domain.Card;
import com.solvd.bank.exceptions.ServiceException;
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

public class CardServiceImpl extends AbstractSQLSession implements ICardService {

  @Override
  public Card getCard(long id) {
    try(SqlSession session = getSession()) {
      ICardDAO cardDAO = session.getMapper(ICardDAO.class);
      return cardDAO.getEntityById(id);
    } catch (SQLException | IOException | ClassNotFoundException e) {
      throw new ServiceException("There was an error using mybatis service: " + e);
    }
  }

  @Override
  public void saveCard(Card card) {
    try(SqlSession session = getSession()) {
      ICardDAO cardDAO = session.getMapper(ICardDAO.class);
      cardDAO.saveEntity(card);
      session.commit();
    }
  }

  @Override
  public void deleteCard(long id) {
    try(SqlSession session = getSession()) {
      ICardDAO cardDAO = session.getMapper(ICardDAO.class);
      cardDAO.removeEntity(id);
      session.commit();
    }
  }

  @Override
  public void updateCardById(long id, Card cardWithNewValues) {
    try(SqlSession session = getSession()) {
      ICardDAO cardDAO = session.getMapper(ICardDAO.class);
      cardDAO.updateEntity(id,cardWithNewValues);
      session.commit();
    }
  }

  @Override
  public Card getCardByAccount(long i) {
    throw new UnsupportedOperationException("This method should be implemented");
  }
}
