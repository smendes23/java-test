package br.com.wa.config.amqp;

import br.com.wa.amqp.domain.KafkaConstants;
import br.com.wa.amqp.domain.UserAmqpMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.url}")
    private String kafkaAddress;

    @Bean(name = KafkaConstants.FACTORY)
    public ConcurrentKafkaListenerContainerFactory<String, UserAmqpMessage> registerKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserAmqpMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID);
        ConsumerFactory<String, UserAmqpMessage> registerConsumerFactory = new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(UserAmqpMessage.class));
        factory.setConsumerFactory(registerConsumerFactory);
        return factory;
    }

}
