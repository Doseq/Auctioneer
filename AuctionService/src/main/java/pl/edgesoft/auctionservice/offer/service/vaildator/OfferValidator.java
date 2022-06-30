package pl.edgesoft.auctionservice.offer.service.vaildator;

import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.offer.enums.OfferValidatorError;
import pl.edgesoft.auctionservice.offer.model.Offer;

public interface OfferValidator {

    boolean validate(Auction auction, Offer offer);
    OfferValidatorError getValidatorError();

}
