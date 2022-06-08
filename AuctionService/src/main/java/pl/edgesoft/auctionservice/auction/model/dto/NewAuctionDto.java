package pl.edgesoft.auctionservice.auction.model.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.edgesoft.auctionservice.auction.model.entity.Currency;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
public class NewAuctionDto {

    private String name;
    private String description;
    private BigDecimal startingBid;
    private Currency currency;
    private long endsAt;

}
