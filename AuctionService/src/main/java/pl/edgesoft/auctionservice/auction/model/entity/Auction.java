package pl.edgesoft.auctionservice.auction.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.edgesoft.auctionservice.auction.model.enums.AvailabilityStatus;
import pl.edgesoft.auctionservice.offer.model.Offer;
import pl.edgesoft.auctionservice.user.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "auctions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Auction {

    private static final AvailabilityStatus FIRST_AVAILABILITY_STATUS = AvailabilityStatus.DRAFT;

    @Id
    private String id;
    @NotBlank
    @Size(min=10, max=50, message = "Name must be between 10 and 50 characters")
    private String name;
    @NotBlank
    private String description;
    private AvailabilityStatus availabilityStatus = FIRST_AVAILABILITY_STATUS;
    private BigDecimal startingBid;
    private BigDecimal currentHighestBid;
    private Currency currency;
    private List<Offer> offerList;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private long endsAt;
    @Version
    private long version;
    private User owner;

    public boolean hasNoOffers(){
        return this.offerList.isEmpty();
    }

    /**
     * This method is used to instantiate Builder with default values
     * @return AuctionBuilder
     */
    public static AuctionBuilder builder() {
        return new AuctionBuilder().availabilityStatus(FIRST_AVAILABILITY_STATUS);
    }

}
