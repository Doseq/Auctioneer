package pl.edgesoft.auctionservice.auction.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.edgesoft.auctionservice.auction.model.dto.BasicInfoAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.NewAuctionDto;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.user.model.User;

import java.time.LocalDateTime;

@Mapper
public interface AuctionMapper {

    AuctionMapper INSTANCE = Mappers.getMapper(AuctionMapper.class);

    BasicInfoAuctionDto auctionToBasicInfoAuctionDto(Auction auction);
    Auction newAuctionDtoToAuction(NewAuctionDto auctionDto, LocalDateTime createdAt, User owner);
}
