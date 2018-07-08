package com.cnhtcqk.logservice.config;

import com.cnhtcqk.logservice.receive.Receiver;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuxuelong
 */
@Configuration
public class MessageListenerConfig {
    MessageListenerAdapter listenerAdapter(Receiver receiver){
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }
}

