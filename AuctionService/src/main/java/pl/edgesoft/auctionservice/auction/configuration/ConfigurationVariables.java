package pl.edgesoft.auctionservice.auction.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationVariables {

    @Value("${auctioneer.auction.time.timeBeforeEndsAtUpdateLockInSeconds}")
    public static long timeBeforeEndsAtUpdateLockInSeconds;

}
