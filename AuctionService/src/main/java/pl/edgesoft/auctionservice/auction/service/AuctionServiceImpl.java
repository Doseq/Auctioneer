package pl.edgesoft.auctionservice.auction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edgesoft.auctionservice.auction.model.dto.BasicInfoAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.NewAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.UpdateAuctionDto;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.auction.model.exception.EntityNotFoundException;
import pl.edgesoft.auctionservice.auction.model.mapper.AuctionMapper;
import pl.edgesoft.auctionservice.auction.repository.AuctionRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;

    @Override
    public BasicInfoAuctionDto findAuctionById(String id) {
        return auctionRepository.findById(id)
                .map(AuctionMapper.INSTANCE::auctionToBasicInfoAuctionDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cannot find auction with given id: %s", id)));
    }

    @Override
    public Page<BasicInfoAuctionDto> findAllAuctions(Pageable pageable) {
        return auctionRepository.findAll(pageable)
                .map(AuctionMapper.INSTANCE::auctionToBasicInfoAuctionDto);
    }

    @Override
    public BasicInfoAuctionDto createAuction(NewAuctionDto auctionDto) { // TODO: return DTO and user mapper
        Auction auction = AuctionMapper.INSTANCE.newAuctionDtoToAuction(auctionDto, LocalDateTime.now(), null);
        return AuctionMapper.INSTANCE.auctionToBasicInfoAuctionDto(auctionRepository.save(auction));
    }

    @Override
    public BasicInfoAuctionDto updateAuction(UpdateAuctionDto auctionDto) {
        Optional<Auction> auctionOpt = auctionRepository.findById(auctionDto.getId());
        if(auctionOpt.isPresent()){
            Auction auction = auctionOpt.get();
            auction.setName(auctionDto.getName());
            auction.setDescription(auctionDto.getDescription());
            auction.setStartingBid(AuctionUpdateUtil.computeStartingBidBasedOnOffers(auction, auctionDto.getStartingBid()));
            auction.setCurrency(AuctionUpdateUtil.computeCurrencyBasedOnOffers(auction, auctionDto.getCurrency()));
            auction.setEndsAt(AuctionUpdateUtil.computeEndsTimeBasedOnTime(auction, auctionDto.getEndsAt()));
            return AuctionMapper.INSTANCE.auctionToBasicInfoAuctionDto(auctionRepository.save(auction));
        } else {
            throw new EntityNotFoundException(String.format("Cannot update auction with id: %s because entity not found by this id", auctionDto.getId()));
        }
    }

    @Override
    public void deleteAuctionById(String id) { //TODO: check if user is able to delete auction (if he is owner or administrator) @PreAuthorize
        try {
            auctionRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
