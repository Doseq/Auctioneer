package pl.edgesoft.auctionservice.offer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.auction.model.exception.EntityNotFoundException;
import pl.edgesoft.auctionservice.auction.repository.AuctionRepository;
import pl.edgesoft.auctionservice.offer.dto.BasicInfoOfferDto;
import pl.edgesoft.auctionservice.offer.dto.NewOfferDto;
import pl.edgesoft.auctionservice.offer.enums.OfferValidatorError;
import pl.edgesoft.auctionservice.offer.mapper.OfferMapper;
import pl.edgesoft.auctionservice.offer.model.Offer;
import pl.edgesoft.auctionservice.offer.service.vaildator.OfferValidator;
import pl.edgesoft.auctionservice.offer.wrapper.NewOfferWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final AuctionRepository auctionRepository;
    private final List<OfferValidator> offerValidators;

    @Override
    public Page<BasicInfoOfferDto> findByAuctionId(String auctionId, PageRequest of) {
        return null;
    }

    @Override
    public NewOfferWrapper createOfferForAuction(String auctionId, NewOfferDto newOfferDto) {

        Offer offer = OfferMapper.INSTANCE.newOfferDtoToOffer(newOfferDto);

        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Auction with ID %s not found", auctionId)));

        Map<OfferValidatorError, String> validatorErrors = offerValidators.stream()
                .filter(validator -> !validator.validate(auction, offer))
                .map(OfferValidator::getValidatorError)
                .collect(Collectors.toMap(Function.identity(), OfferValidatorError::getMessage));

        if(validatorErrors.isEmpty()) {
            auction.getOffers().add(offer);
            auctionRepository.save(auction);
        }

        return NewOfferWrapper.builder()
                .offer(validatorErrors.isEmpty() ? OfferMapper.INSTANCE.offerToBasicInfoDto(offer) : null) //TODO: return actual offer instance added to DB
                .errors(validatorErrors.isEmpty() ? null : validatorErrors)
                .build();
    }

}
