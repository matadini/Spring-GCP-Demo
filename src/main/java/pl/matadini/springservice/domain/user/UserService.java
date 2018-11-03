package pl.matadini.springservice.domain.user;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
interface UserService  {
    Integer createExampleUser();

    Optional<UserDTO> getUser(Integer userId);

    List<UserDTO> getAll();
}