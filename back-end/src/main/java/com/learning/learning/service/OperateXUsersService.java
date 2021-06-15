package com.learning.learning.service;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.config.MyConfig;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.grpc.ManagerOperationRequest;
import com.learning.learning.mapper.satoken.XUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author jbk-xiao
 * @version 2021-06-15-15:11
 */
@Slf4j
@Service
public class OperateXUsersService {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final MyConfig config;
    private final XUserMapper xUserMapper;
    private final OperateXUserService operateXUserService;
    public OperateXUsersService(XUserMapper xUserMapper, MyConfig config, OperateXUserService operateXUserService) {
        this.xUserMapper = xUserMapper;
        this.config = config;
        this.operateXUserService = operateXUserService;
    }

    public boolean insertXUsers(String xUsersInfo, String createByAid) {
        List<Map<String, String>> xUsers = gson.fromJson(xUsersInfo,
                new TypeToken<List<Map<String, String>>>() {}.getType());
        try {
            for (Map<String, String> xUser : xUsers) {
                operateXUserService.insertXUser(xUser.get("userId"), xUser.get("name"), xUser.get("password"), createByAid);
            }
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    protected boolean deleteXUsers(String userId) {
        return true;
    }

    protected boolean updateXUsers(ManagerOperationRequest request) {
        return true;
    }

    protected List<XUser> selectXUsers() throws Exception {
        return this.xUserMapper.getAll();
    }
}
