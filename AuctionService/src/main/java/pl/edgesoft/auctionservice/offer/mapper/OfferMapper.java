package pl.edgesoft.auctionservice.offer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.edgesoft.auctionservice.auction.model.dto.BasicInfoAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.NewAuctionDto;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.offer.dto.BasicInfoOfferDto;
import pl.edgesoft.auctionservice.offer.dto.NewOfferDto;
import pl.edgesoft.auctionservice.offer.model.Offer;
import pl.edgesoft.auctionservice.user.model.User;

import java.time.LocalDateTime;

@Mapper
public interface OfferMapper {

    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);

    Offer newOfferDtoToOffer(NewOfferDto newOfferDto);
    BasicInfoOfferDto offerToBasicInfoDto(Offer offer);
}
