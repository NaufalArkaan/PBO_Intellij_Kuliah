package perpustakaan;

import java.util.Date;

public class LibraryCard {
    private String cardId;
    private Date expiryDate;

    public LibraryCard(String cardId, Date expiryDate) {
        this.cardId = cardId;
        this.expiryDate = expiryDate;
    }

    public String getCardId() { return cardId; }

    public Date getExpiryDate() { return expiryDate; }
}
