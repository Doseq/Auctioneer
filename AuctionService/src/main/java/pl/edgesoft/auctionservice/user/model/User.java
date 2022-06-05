package pl.edgesoft.auctionservice.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {

    private String login;
    @Email
    private String email;

}
