package pl.edgesoft.auctionservice.offer.service.vaildator;

import org.springframework.stereotype.Component;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.offer.enums.OfferValidatorError;
import pl.edgesoft.auctionservice.offer.model.Offer;

@Component
public class OfferBidValidator implements OfferValidator {

    @Override
    public boolean validate(Auction auction, Offer offer) {
        return (auction.hasNoOffers() || auction.getCurrentHighestBid().compareTo(offer.getBid()) >= 0) &&
                (auction.hasOffers() || auction.getStartingBid().compareTo(offer.getBid()) >= 0);
    }

    @Override
    public OfferValidatorError getValidatorError() {
        return OfferValidatorError.OFFER_BID_ERROR;
    }
}
