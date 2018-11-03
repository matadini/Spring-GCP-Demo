package pl.matadini.springservice.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="uzytkownicy")
@ToString
class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer userId;

    String login;

    String password;

    LocalDateTime createDate;
}