package pl.edgesoft.auctionservice.auction.model.mapper;

import org.junit.jupiter.api.Test;
import pl.edgesoft.auctionservice.auction.model.dto.BasicInfoAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.NewAuctionDto;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.auction.model.entity.Currency;
import pl.edgesoft.auctionservice.auction.model.enums.AvailabilityStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AuctionMapperTest {

    @Test
    void shouldMapAuctionToBasicInfoAuctionDto() {
        //GIVEN
        LocalDateTime createdAt = LocalDateTime.parse("2011-12-03T10:15:30");
        Auction auction = Auction.builder()
                .id("abc")
                .availabilityStatus(AvailabilityStatus.BANNED)
                .currency(Currency.EUR)
                .currentHighestBid(BigDecimal.TEN)
                .endsAt(1000)
                .createdAt(createdAt)
                .name("Auction 1")
                .description("Description 1")
                .startingBid(BigDecimal.ONE)
                .build();

        //WHEN
        BasicInfoAuctionDto result = AuctionMapper.INSTANCE.auctionToBasicInfoAuctionDto(auction);

        //THEN
        assertThat(result.getId()).isEqualTo("abc");
        assertThat(result.getName()).isEqualTo("Auction 1");
        assertThat(result.getAvailabilityStatus()).isEqualTo(AvailabilityStatus.BANNED);
        assertThat(result.getCurrency()).isEqualTo(Currency.EUR);
        assertThat(result.getCreatedAt()).isEqualTo(createdAt);
        assertThat(result.getStartingBid()).isEqualTo(BigDecimal.ONE);
        assertThat(result.getEndsAt()).isEqualTo(1000);
    }

    @Test
    void shouldMapNewAuctionDtoToAuction() {
        //GIVEN
        LocalDateTime createdAt = LocalDateTime.parse("2011-12-03T10:15:30");
        NewAuctionDto newAuctionDto = NewAuctionDto.builder()
                .currency(Currency.EUR)
                .endsAt(1000)
                .name("Auction 1")
                .description("Description 1")
                .startingBid(BigDecimal.ONE)
                .build();

        //WHEN
        Auction result = AuctionMapper.INSTANCE.newAuctionDtoToAuction(newAuctionDto, createdAt, null);

        //THEN
        assertThat(result.getName()).isEqualTo("Auction 1");
        assertThat(result.getAvailabilityStatus()).isEqualTo(AvailabilityStatus.DRAFT);
        assertThat(result.getCurrency()).isEqualTo(Currency.EUR);
        assertThat(result.getCreatedAt()).isEqualTo(createdAt);
        assertThat(result.getStartingBid()).isEqualTo(BigDecimal.ONE);
        assertThat(result.getEndsAt()).isEqualTo(1000);
    }
}