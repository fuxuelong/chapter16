package com.cnhtcqk.logservice.receive;

import com.alibaba.fastjson.JSON;
import com.cnhtcqk.logservice.entity.SysLog;
import com.cnhtcqk.logservice.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;


/**
 * @author fuxuelong
 */
@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    SysLogService sysLogService;
    public void  receiveMessage(String message){
        System.out.println("Receive<"+message+">");
        SysLog sysLog = JSON.parseObject(message,SysLog.class);
        sysLogService.saveLogger(sysLog);
        latch.countDown();

    }
}
