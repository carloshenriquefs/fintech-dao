package org.example.view.cards.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;

import static org.example.constants.Constants.CARDS_REGISTERED;
import static org.example.factory.cards.CardsFactory.createCards;
import static org.example.factory.cards.CardsFactory.getCardsDao;

public class RegistrationCardsTest {

    public static void main(String[] args) {
        try {

            getCardsDao().insert(createCards(), 2L);

            getCardsDao().closeConnection();

            System.out.println(CARDS_REGISTERED);

        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }
}
