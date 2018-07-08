package com.cnhtcqk.uaaservice.service;

import com.alibaba.fastjson.JSON;
import com.cnhtcqk.uaaservice.config.RabbitConfig;
import com.cnhtcqk.uaaservice.entity.SysLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fuxuelong
 */
@Service
public class LoggerService {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public  void log(SysLog sysLog){
        rabbitTemplate.convertAndSend(RabbitConfig.queueName, JSON.toJSONString(sysLog));
    }
}
