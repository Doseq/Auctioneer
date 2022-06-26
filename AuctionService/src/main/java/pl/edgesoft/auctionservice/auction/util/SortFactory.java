package pl.edgesoft.auctionservice.auction.util;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.Arrays;
import java.util.List;

public class SortFactory {

    public static final String SEPARATOR = ";";
    public static final Sort.Direction DEFAULT_SORTING_DIRECTION = Direction.ASC;

    private SortFactory() {}

    public static Sort of(String[] properties) {
        final List<Order> orders = Arrays.stream(properties)
                .map(property -> property.split(SEPARATOR))
                .map(splitted -> new Order(Direction.fromOptionalString(splitted[1])
                        .orElse(DEFAULT_SORTING_DIRECTION), splitted[0]))
                .toList();
        return Sort.by(orders);
    }

}
