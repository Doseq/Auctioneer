package pl.edgesoft.auctionservice.auction.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
public class UpdateAuctionDto {

    private String id;
    private String name;
    private String description;
    private BigDecimal startingBid;
    private Currency currency;
    private long endsAt;

}
