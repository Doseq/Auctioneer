package pl.edgesoft.auctionservice.offer.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.edgesoft.auctionservice.offer.dto.BasicInfoOfferDto;
import pl.edgesoft.auctionservice.offer.enums.OfferValidatorError;
import pl.edgesoft.auctionservice.offer.model.Offer;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class NewOfferWrapper {

    private BasicInfoOfferDto offer;
    private Map<OfferValidatorError, String> errors;

}
