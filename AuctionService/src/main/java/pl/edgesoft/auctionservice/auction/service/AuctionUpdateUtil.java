package pl.edgesoft.auctionservice.auction.service;

import pl.edgesoft.auctionservice.auction.configuration.ConfigurationVariables;
import pl.edgesoft.auctionservice.auction.model.entity.Auction;
import pl.edgesoft.auctionservice.auction.model.entity.Currency;

import java.math.BigDecimal;
import java.time.Instant;

public class AuctionUpdateUtil {

    public static BigDecimal computeStartingBidBasedOnOffers(Auction auction, BigDecimal updatedBid) {
        return (auction.hasNoOffers()) ? updatedBid : auction.getStartingBid();
    }

    public static Currency computeCurrencyBasedOnOffers(Auction auction, Currency updatedCurrency) {
        return (auction.hasNoOffers()) ? updatedCurrency : auction.getCurrency();
    }

    public static long computeEndsTimeBasedOnTime(Auction auction, long updatedEndsAt) {
        return (Instant.now().toEpochMilli() < updatedEndsAt &&
                Instant.now().minusSeconds(ConfigurationVariables.timeBeforeEndsAtUpdateLockInSeconds)
                        .isAfter(Instant.ofEpochMilli(updatedEndsAt))) ? updatedEndsAt : auction.getEndsAt();
    }

}
