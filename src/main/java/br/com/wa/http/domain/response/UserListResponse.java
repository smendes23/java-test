package br.com.wa.http.domain.response;

import br.com.wa.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserListResponse extends DefaultResponse {

    @Getter
    @Setter
    private List<User> userList;

    public UserListResponse(List<User> userList) {
        this.userList = userList;
    }


}
