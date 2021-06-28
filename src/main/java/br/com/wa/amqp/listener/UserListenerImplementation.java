package br.com.wa.amqp.listener;

import br.com.wa.amqp.domain.KafkaConstants;
import br.com.wa.amqp.domain.UserAmqpMessage;
import br.com.wa.usecase.user.implementation.SaveUserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserListenerImplementation implements UserListener {

    @Autowired
    private SaveUserImp saveUser;

    @KafkaListener(topics = KafkaConstants.TOPIC_REGISTER, containerFactory = KafkaConstants.FACTORY)
    @Override
    public void consumeMessage(UserAmqpMessage message) {
        message.getRegisters().forEach(userRequest -> saveUser.execute(userRequest));
    }

}
