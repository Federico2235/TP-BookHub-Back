package fr.eni.bookhubback.service;

import fr.eni.bookhubback.businessObject.DTO.UserDTO;
import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.exception.UseByMailNotFoundException;
import fr.eni.bookhubback.exception.UserNotFoundException;
import fr.eni.bookhubback.mapper.DTOUserMapper;
import fr.eni.bookhubback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements CrudService<User, UserDTO>{

    private final UserRepository userRepository;
    private final DTOUserMapper dtoUserMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    public User selectById(long id) {
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void delete(long id) {
    userRepository.deleteById(id);
    }

    @Override
    public User save(UserDTO userDTO) {
            User user = dtoUserMapper.toUser(userDTO);
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            return userRepository.save(user);
    }

    public User findByEmail(String email){return userRepository.findByEmail(email).orElseThrow(()-> new UseByMailNotFoundException(email));
    }
}
