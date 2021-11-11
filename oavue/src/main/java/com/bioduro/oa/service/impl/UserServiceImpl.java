package com.bioduro.oa.service.impl;

import com.bioduro.oa.entity.User;
import com.bioduro.oa.mapper.UserMapper;
import com.bioduro.oa.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanh
 * @since 2021-11-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
