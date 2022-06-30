package pl.edgesoft.auctionservice.offer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edgesoft.auctionservice.offer.dto.BasicInfoOfferDto;
import pl.edgesoft.auctionservice.offer.dto.NewOfferDto;
import pl.edgesoft.auctionservice.offer.service.OfferService;
import pl.edgesoft.auctionservice.offer.wrapper.NewOfferWrapper;

@RestController
@RequestMapping("/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/{auctionId}")
    public ResponseEntity<Page<BasicInfoOfferDto>> findByAuctionId(@PathVariable String auctionId,
                                                                   @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                                   @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(offerService.findByAuctionId(auctionId, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "bid"))));
    }

    @PostMapping("/{auctionId}")
    public ResponseEntity<NewOfferWrapper> createOfferForAuction(@PathVariable String auctionId, @RequestBody NewOfferDto newOfferDto) {
        return new ResponseEntity<>(offerService.createOfferForAuction(auctionId, newOfferDto), HttpStatus.CREATED);
    }

}
