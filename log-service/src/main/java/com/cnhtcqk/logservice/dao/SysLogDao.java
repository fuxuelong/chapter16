package com.cnhtcqk.logservice.dao;

import com.cnhtcqk.logservice.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fuxuelong
 */
public interface SysLogDao extends JpaRepository<SysLog,Long> {
}

