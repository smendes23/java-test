package br.com.wa.http.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull
    private String name;

    private String email;

    @NotNull
    private int age;

    private AddressRequest address;

}
