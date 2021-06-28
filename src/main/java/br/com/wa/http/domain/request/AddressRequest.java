package br.com.wa.http.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @NotNull
    private String street;

    @NotNull
    private String postalCode;

}
