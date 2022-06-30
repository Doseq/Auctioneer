package pl.edgesoft.auctionservice.offer.service.vaildator;

import org.springframework.stereotype.Component;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.auction.model.enums.AvailabilityStatus;
import pl.edgesoft.auctionservice.offer.enums.OfferValidatorError;
import pl.edgesoft.auctionservice.offer.model.Offer;

@Component
public class OfferStatusValidator implements OfferValidator {

    @Override
    public boolean validate(Auction auction, Offer offer) {
        return auction.getAvailabilityStatus().equals(AvailabilityStatus.LISTED);
    }

    @Override
    public OfferValidatorError getValidatorError() {
        return OfferValidatorError.OFFER_STATUS_ERROR;
    }

}
