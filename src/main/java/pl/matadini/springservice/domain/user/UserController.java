package pl.matadini.springservice.domain.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
class UserController {

    UserService userService;

    @Autowired
    UserController(UserService service) {
        this.userService = service;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/create-example")
    ResponseEntity<Integer> createExampleUser() {
        return new ResponseEntity<>(userService.createExampleUser(), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") Integer id) {
        Optional<UserDTO> value = userService.getUser(id);
        return value.isPresent() ? new ResponseEntity<>(value.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> value = userService.getAll();
        return !value.isEmpty() ? new ResponseEntity<>(value, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}