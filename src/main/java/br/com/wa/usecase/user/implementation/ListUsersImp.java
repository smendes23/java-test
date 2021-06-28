package br.com.wa.usecase.user.implementation;

import br.com.wa.http.domain.response.UserListResponse;
import br.com.wa.services.UserServices;
import br.com.wa.usecase.user.ListUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListUsersImp implements ListUsers {
    @Autowired
    private UserServices userServices;

    @Override
    public UserListResponse execute() {
        var userListResponse = new UserListResponse(userServices.findAll());
        return userListResponse;
    }

}
