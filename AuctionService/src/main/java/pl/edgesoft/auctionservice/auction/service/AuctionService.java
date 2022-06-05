package pl.edgesoft.auctionservice.auction.service;

import org.springframework.data.domain.Pageable;
import pl.edgesoft.auctionservice.auction.model.Auction;
import pl.edgesoft.auctionservice.auction.model.NewAuctionDto;
import pl.edgesoft.auctionservice.auction.model.UpdateAuctionDto;

import java.util.List;

public interface AuctionService {

    Auction createAuction(NewAuctionDto auctionDto);
    Auction updateAuction(UpdateAuctionDto auctionDto);
    Auction removeAuction(String id);
    Auction getAuction(String id);
    List<Auction> getAuctions(Pageable pageable);

}
