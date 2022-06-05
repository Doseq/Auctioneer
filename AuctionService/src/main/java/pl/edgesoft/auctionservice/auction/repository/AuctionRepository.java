package pl.edgesoft.auctionservice.auction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.edgesoft.auctionservice.auction.model.Auction;

public interface AuctionRepository extends MongoRepository<Auction, String> {
}
