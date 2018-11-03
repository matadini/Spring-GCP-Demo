package pl.matadini.springservice.domain.user;

import java.time.LocalDateTime;

import lombok.Data;

@Data
class UserDTO {

    String login;

    LocalDateTime createDate;

}
