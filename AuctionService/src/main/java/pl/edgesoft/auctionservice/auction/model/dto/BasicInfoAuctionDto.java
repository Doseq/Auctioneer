package pl.edgesoft.auctionservice.auction.model.dto;

import lombok.*;
import pl.edgesoft.auctionservice.auction.model.entity.Currency;
import pl.edgesoft.auctionservice.auction.model.enums.AvailabilityStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * This dto represents basic information of auction entity (without fetching offers)
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BasicInfoAuctionDto {

    private String id;
    private String name;
    private String description;
    private AvailabilityStatus availabilityStatus;
    private BigDecimal startingBid;
    private Currency currency;
    private LocalDateTime createdAt;
    private long endsAt;

}
