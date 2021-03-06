package com.tcgl.web.service.impl;

import com.tcgl.common.vo.ResultVo;
import com.tcgl.serviceapi.api.UserApi;
import com.tcgl.serviceapi.entity.UserEntity;
import com.tcgl.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;


/**
 * @author Shuguang_Liux
 * @package com.record.tcgl.service.impl
 * @Description ToDo
 * @Date 2020/9/9 16:09
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @DubboReference
    private UserApi userApi;


    /**
     * 根据角色判断用户登录
     * @return
     */
    @Override
    public ResultVo<Boolean> userRoles(UserEntity userEntity) {
        ResultVo<Boolean> resultVo = new ResultVo<>();
        if(StringUtils.isEmpty(userEntity.getUsername())|| StringUtils.isEmpty(userEntity.getPassword())){
            resultVo.setError(400,"用户名或密码不正确！");
            return resultVo;
        }
        return userApi.checkUserRole(userEntity);
    }

    /**
     * 根据用户名称更新用户密码
     * @return
     */
    @Override
    public ResultVo<Boolean> updateAccountInfo(UserEntity userEntity) {
        ResultVo<Boolean> resultVo = new ResultVo<>();
        if (StringUtils.isEmpty(userEntity.getUsername())||StringUtils.isEmpty(userEntity.getPassword())){
            resultVo.setError(400,"用户名或密码不能为空");
            return resultVo;
        }
        return userApi.updateAccountInfo(userEntity);
    }

    @Override
    public ResultVo<?> register(UserEntity userEntity) {
        ResultVo<?> resultVo = new ResultVo<>();
        if (StringUtils.isEmpty(userEntity.getUsername()) ||
                StringUtils.isEmpty(userEntity.getPassword())){
            resultVo.setError(400,"信息不全");
            return resultVo;
        }
        return userApi.register(userEntity);
    }

    @Override
    public ResultVo<Boolean> delete(String ids) {
        return null;
    }
}
