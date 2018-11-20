package com.wl.core.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wl.core.UserService;
import com.wl.dao.UserDao;
import com.wl.domain.User;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 江苏博沣
 * @since 2018-08-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
