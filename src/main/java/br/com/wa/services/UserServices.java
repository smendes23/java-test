package br.com.wa.services;

import br.com.wa.domain.user.User;
import br.com.wa.repository.UserRepository;
import br.com.wa.repository.facade.UserRepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserRepositoryFacade {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
