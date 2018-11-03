package pl.matadini.springservice.domain.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UserServiceImpl implements UserService {

    UserRepository userRepository;

    AtomicInteger atomicInteger;

    ModelMapper modelMapper;

    @Autowired
    UserServiceImpl(UserRepository repository, AtomicInteger atomic, ModelMapper mapper) {
        this.userRepository = repository;
        this.atomicInteger = atomic;
        this.modelMapper = mapper;
    }

    @Override
    public Integer createExampleUser() {

        int value = atomicInteger.incrementAndGet();

        User user = new User();
        user.setLogin("login_" + value);
        user.setPassword("password_" + value);
        user.setCreateDate(LocalDateTime.now());
        return userRepository.save(user).getUserId();
    }

    @Override
    public Optional<UserDTO> getUser(Integer userId) {

        Optional<User> find = userRepository.findById(userId);
        return find.isPresent() ? 
                Optional.ofNullable(modelMapper.map(find.get(), UserDTO.class))    
                : Optional.empty();
     
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> result = userRepository.findAll();
        return !result.isEmpty() ? 
                result.stream().map(item -> modelMapper.map(item, UserDTO.class)).collect(Collectors.toList()) 
                : Lists.newArrayList();
	}
}