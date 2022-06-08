package pl.edgesoft.auctionservice.auction.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.edgesoft.auctionservice.auction.model.dto.BasicInfoAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.NewAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.UpdateAuctionDto;

//TODO: javadoc methods
public interface AuctionService {

    /**
     * Finds auction by given id
     * @param id of auction to find
     * @return basic info dto or throws EntityNotFoundException
     */
    BasicInfoAuctionDto findAuctionById(String id);
    Page<BasicInfoAuctionDto> findAllAuctions(Pageable pageable);
    BasicInfoAuctionDto createAuction(NewAuctionDto auctionDto);
    BasicInfoAuctionDto updateAuction(UpdateAuctionDto auctionDto);
    void deleteAuctionById(String id);

}
