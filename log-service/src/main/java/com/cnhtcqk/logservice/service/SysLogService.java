package com.cnhtcqk.logservice.service;

import com.cnhtcqk.logservice.dao.SysLogDao;
import com.cnhtcqk.logservice.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fuxuelong
 */
@Service
public class SysLogService {
    @Autowired
    SysLogDao sysLogDao;
    public void  saveLogger(SysLog sysLog){
        sysLogDao.save(sysLog);
    }
}
