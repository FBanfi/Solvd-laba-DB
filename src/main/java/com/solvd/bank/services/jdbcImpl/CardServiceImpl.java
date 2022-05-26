package com.solvd.bank.services.jdbcImpl;

import com.solvd.bank.dao.ICardDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.CardDAO;
import com.solvd.bank.domain.Card;
import com.solvd.bank.services.ICardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class CardServiceImpl implements ICardService {
    private final static Logger LOGGER = LogManager.getLogger(CardServiceImpl.class);

    @Override
    public Card getCard(long id) {
        ICardDAO cardDAO = new CardDAO();

        Card cardToReturn = null;
        try {
            cardToReturn = cardDAO.getEntityById(id);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            LOGGER.error("There was an error with the service of the card", e);
            throw new RuntimeException(e);
        }

        return cardToReturn;
    }

    @Override
    public void saveCard(Card card) {
        ICardDAO cardDAO = new CardDAO();
        cardDAO.saveEntity(card);
    }

    @Override
    public void deleteCard(long id) {
        ICardDAO cardDAO = new CardDAO();
        cardDAO.removeEntity(id);
    }

    @Override
    public void updateCardById(long id,Card cardWithNewValues) {
        ICardDAO cardDAO = new CardDAO();
        cardDAO.updateEntity(id,cardWithNewValues);
    }

    @Override
    public Card getCardByAccount(long id) {
        ICardDAO cardDAO = new CardDAO();
        return cardDAO.getCardByAccountId(id);
    }
}
