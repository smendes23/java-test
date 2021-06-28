package br.com.wa.amqp.domain;

import br.com.wa.http.domain.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserAmqpMessage {

    private List<UserRequest> registers;

}
