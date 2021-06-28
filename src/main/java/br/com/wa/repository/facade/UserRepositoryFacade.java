package br.com.wa.repository.facade;

import br.com.wa.domain.user.User;

import java.util.List;

public interface UserRepositoryFacade {

    public User save(User user);

    public List<User> findAll();

}
