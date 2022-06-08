package pl.edgesoft.auctionservice.auction.model.exception;

public class CannotUpdateStartingBidException extends RuntimeException {

    public CannotUpdateStartingBidException(String message) {
        super(message);
    }
}
