package pl.edgesoft.auctionservice.offer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.edgesoft.auctionservice.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Offer {

    @Id
    private String id;
    private User user;
    private BigDecimal bid;
    private LocalDateTime bidTime;

}
