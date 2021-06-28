package br.com.wa.http.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersRequest {

    @Size(min = 2, max = 50)
    private List<UserRequest> users;

}