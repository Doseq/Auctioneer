package pl.edgesoft.auctionservice.offer.dto;

import lombok.*;
import pl.edgesoft.auctionservice.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * This dto represents basic information of newly created offer entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class NewOfferDto {

    private String id;
    private User user;
    private BigDecimal bid;
    private LocalDateTime bidTime;

}
