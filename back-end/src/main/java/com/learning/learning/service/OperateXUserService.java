package com.learning.learning.service;

import cn.hutool.crypto.SecureUtil;
import com.learning.learning.config.MyConfig;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.grpc.ManagerOperationRequest;
import com.learning.learning.mapper.satoken.XUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


/**
 * @author jbk-xiao
 * @version 2021-06-08-18:41
 */
@Slf4j
@Service
public class OperateXUserService {
    private final MyConfig config;
    private final XUserMapper xUserMapper;

    public OperateXUserService(XUserMapper xUserMapper, MyConfig config) {
        this.xUserMapper = xUserMapper;
        this.config = config;
    }

    public boolean insertXUser(String userId, String name, String password, String createByAid) {
        try {
            String sPassword = SecureUtil.md5(config.getMd5Salt() + userId + password).toUpperCase();
            xUserMapper.add(userId, name, sPassword, password, createByAid);
        } catch (Exception e) {
            log.warn(e.toString());
            return false;
        }
        return true;
    }

    protected boolean deleteXUser(String userId) {
        try {
            xUserMapper.delete(userId);
            //deleteUser?
        } catch (Exception e) {
            log.warn(e.toString());
            return false;
        }
        return true;
    }

    protected boolean updateXUser(String userId, String name, String password) {
        try {
            String sPassword = SecureUtil.md5(config.getMd5Salt() + userId + password).toUpperCase();
            xUserMapper.update(userId, name, sPassword, password);
        } catch (Exception e) {
            log.warn(e.toString());
            return false;
        }
        return true;
    }

    protected XUser selectXUser(String userId) throws Exception {
        return this.xUserMapper.getById(userId);
    }
}
