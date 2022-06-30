package pl.edgesoft.auctionservice.auction.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationVariables {

    @Value("${auctioneer.auction.time.timeBeforeEndsAtUpdateLockInSeconds}")
    public static long timeBeforeEndsAtUpdateLockInSeconds;

}
