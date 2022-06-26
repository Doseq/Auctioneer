package pl.edgesoft.auctionservice.auction.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edgesoft.auctionservice.auction.model.dto.BasicInfoAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.NewAuctionDto;
import pl.edgesoft.auctionservice.auction.model.dto.UpdateAuctionDto;
import pl.edgesoft.auctionservice.auction.service.AuctionService;
import pl.edgesoft.auctionservice.auction.util.SortFactory;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @GetMapping("/{id}")
    ResponseEntity<BasicInfoAuctionDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(auctionService.findAuctionById(id));
    }

    @GetMapping
    ResponseEntity<Page<BasicInfoAuctionDto>> findAllPaginated(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sort", defaultValue = "endsAt;asc") String[] sort) {
        return ResponseEntity.ok(auctionService.findAllAuctions(PageRequest.of(page, size, SortFactory.of(sort))));
    }

    @PostMapping
    ResponseEntity<BasicInfoAuctionDto> createAuction(@RequestBody NewAuctionDto auction) {
        return new ResponseEntity<>(auctionService.createAuction(auction), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<BasicInfoAuctionDto> updateAuction(@RequestBody UpdateAuctionDto auction) {
        return ResponseEntity.ok(auctionService.updateAuction(auction));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAuction(@PathVariable String id) {
        auctionService.deleteAuctionById(id);
        return ResponseEntity.ok().build();
    }

}
