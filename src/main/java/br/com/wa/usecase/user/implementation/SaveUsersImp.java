package br.com.wa.usecase.user.implementation;

import br.com.wa.amqp.domain.KafkaConstants;
import br.com.wa.amqp.domain.UserAmqpMessage;
import br.com.wa.domain.user.User;
import br.com.wa.http.domain.request.UsersRequest;
import br.com.wa.http.domain.response.UserResponse;
import br.com.wa.usecase.user.SaveUsers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SaveUsersImp implements SaveUsers {

    @Autowired
    private KafkaTemplate<String, UserAmqpMessage> kafkaProducer;

    @Override
    public UserResponse execute(UsersRequest request) {
        var userResponse = new UserResponse(new ModelMapper().map(request.getUsers().get(0), User.class));
        kafkaProducer.send(KafkaConstants.TOPIC_REGISTER, new UserAmqpMessage().withRegisters(request.getUsers()));
        return userResponse;
    }

}
