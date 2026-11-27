package se.iths.madeleine.model;

import java.time.LocalDate;

public class AccessCard {

    private int cardId;
    private String cardNumber;
    private LocalDate dateOfIssue;
    private LocalDate expiryDate;

    public AccessCard(int cardId, String cardNumber, LocalDate dateOfIssue, LocalDate expiryDate) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.dateOfIssue = dateOfIssue;
        this.expiryDate = expiryDate;
    }

    public int getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
