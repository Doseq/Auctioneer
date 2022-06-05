package pl.edgesoft.auctionservice.auction.model;

/**
 * This status describes auction availability
 */
public enum AvailabilityStatus {

    /**
     * Auction is prepared but not listed yet
     */
    DRAFT,

    /**
     * Auction is submitted by seller and listed
     */
    LISTED,

    /**
     * Auction is delisted by seller before it's ending
     */
    REMOVED_BY_SELLER,

    /**
     * Auction is banned by administrator due to rules violation
     */
    BANNED,

    /**
     * Auction is ended with purchase offer
     */
    ENDED_SOLD,

    /**
     * Auction is ended without purchase offer
     */
    ENDED_UNSOLD

}
