package pl.edgesoft.auctionservice.offer.enums;

public enum OfferValidatorError {

    OFFER_BID_ERROR("Offer bid is lower than highest bid or starting bid."),
    OFFER_STATUS_ERROR("Auction is not marked as listed."),
    OFFER_USER_ERROR("User that created auction cannot create offers for it.");

    private final String message;

    OfferValidatorError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
