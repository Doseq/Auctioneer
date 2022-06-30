package pl.edgesoft.auctionservice.offer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.edgesoft.auctionservice.offer.dto.BasicInfoOfferDto;
import pl.edgesoft.auctionservice.offer.dto.NewOfferDto;
import pl.edgesoft.auctionservice.offer.wrapper.NewOfferWrapper;

public interface OfferService {
    Page<BasicInfoOfferDto> findByAuctionId(String auctionId, PageRequest of);

    NewOfferWrapper createOfferForAuction(String auctionId, NewOfferDto newOfferDto);
}
