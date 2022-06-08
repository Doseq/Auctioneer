package pl.edgesoft.auctionservice.auction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;

@Repository
public interface AuctionRepository extends MongoRepository<Auction, String> {

}
