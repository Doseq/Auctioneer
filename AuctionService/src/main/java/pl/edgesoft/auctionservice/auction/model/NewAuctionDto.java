package pl.edgesoft.auctionservice.auction.model;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
public class NewAuctionDto {

    private String name;
    private String description;
    private BigDecimal startingBid;
    private long endsAt;

}
