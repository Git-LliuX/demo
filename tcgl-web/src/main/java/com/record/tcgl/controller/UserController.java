package com.record.tcgl.controller;

import com.record.tcgl.entity.UserEntity;
import com.record.tcgl.service.UserService;
import com.record.tcgl.vo.ResultVo;
import com.record.tcgl.interfaces.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shuguang_Liux
 * @package com.record.tcgl.controller
 * @Description ToDo
 * @Date 2020/9/14 15:43
 **/
@RestController
@RequestMapping("login")
public class UserController {

}
