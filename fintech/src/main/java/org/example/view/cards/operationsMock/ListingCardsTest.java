package org.example.view.cards.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Card;

import java.util.List;

import static org.example.factory.cards.CardsFactory.getCardsDao;

public class ListingCardsTest {

    public static void main(String[] args) {
        try {
            List<Card> cards = getCardsDao().getAll();

            for (Card card : cards) {
                System.out.println(card.getBalance() + " - " + card.getNumberCard() + ", " + card.getFlag() + ", " + card.getValidate());
            }

            getCardsDao().closeConnection();
        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
