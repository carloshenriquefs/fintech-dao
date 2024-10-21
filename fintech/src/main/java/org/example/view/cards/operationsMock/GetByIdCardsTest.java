package org.example.view.cards.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Card;

import static org.example.factory.cards.CardsFactory.getCardsDao;

public class GetByIdCardsTest {

    public static void main(String[] args) {
        try {
            Card card = getCardsDao().getById(2L);

            System.out.println(card.getCode() + " - " + card.getNumberCard() + ", " + card.getFlag() + ", " + card.getValidate());

            getCardsDao().closeConnection();
        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
