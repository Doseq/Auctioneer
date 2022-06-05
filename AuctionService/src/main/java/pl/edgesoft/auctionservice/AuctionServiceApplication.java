package pl.edgesoft.auctionservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edgesoft.auctionservice.auction.model.Auction;
import pl.edgesoft.auctionservice.auction.model.AvailabilityStatus;
import pl.edgesoft.auctionservice.auction.repository.AuctionRepository;
import pl.edgesoft.auctionservice.offer.model.Offer;
import pl.edgesoft.auctionservice.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AuctionServiceApplication implements CommandLineRunner {

    private AuctionRepository auctionRepository;


    public AuctionServiceApplication(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AuctionServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User owner = User.builder()
                .login("kekb")
                .email("wd@wd.pl")
                .build();
        User user = User.builder()
                .login("berws")
                .email("err@er.pl")
                .build();
        Offer offer = Offer.builder()
                .bidTime(LocalDateTime.now())
                .bid(BigDecimal.valueOf(5000))
                .user(user)
                .id(UUID.randomUUID().toString())
                .build();
        Auction auction = Auction.builder()
                .availabilityStatus(AvailabilityStatus.DRAFT)
                .id(UUID.randomUUID().toString())
                .description("twoja strara")
                .name("twoj stary")
                .createdAt(LocalDateTime.now())
                .owner(owner)
                .offerList(List.of(offer))
                .build();
        auctionRepository.save(auction);
    }
}
