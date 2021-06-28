package br.com.wa.resource;

import br.com.wa.http.URLMapping;
import br.com.wa.http.UserWS;
import br.com.wa.http.domain.request.UserRequest;
import br.com.wa.http.domain.request.UsersRequest;
import br.com.wa.http.domain.response.UserListResponse;
import br.com.wa.http.domain.response.UserResponse;
import br.com.wa.usecase.user.implementation.ListUsersImp;
import br.com.wa.usecase.user.implementation.SaveUserImp;
import br.com.wa.usecase.user.implementation.SaveUsersImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Validated
@RestController
public class UserController implements UserWS {

    @Autowired
    private SaveUserImp saveUser;
    @Autowired
    private ListUsersImp listUsers;
    @Autowired
    private SaveUsersImp saveUsers;

    @PostMapping(value = URLMapping.POST_SAVE_REGISTER)
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public UserResponse saveRegister(@RequestBody UserRequest request) {
        return Optional.of(saveUser.execute(request)).orElseThrow(() -> {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        });
    }

    @PostMapping(value = URLMapping.POST_SAVE_REGISTERS)
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public UserResponse saveRegisters(@RequestBody UsersRequest request) {
        return Optional.of(saveUsers.execute(request)).orElseThrow(() -> {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        });
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = URLMapping.GET_LIST_REGISTER, produces = "application/json")
    @Override
    public UserListResponse listRegisters() {
        var userListResponse = Optional.of(new UserListResponse(listUsers.execute().getUserList()));
        return userListResponse.orElseThrow(() -> {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        });
    }

}
