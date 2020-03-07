package com.cn.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.BackUser;
import com.cn.IBackUserService;
import com.cn.dao.BackUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/12/12 21:53
 */
@Service
public class BackUserServiceImpl implements IBackUserService {
    @Autowired
    private BackUserMapper backUserMapper;

    @Override
    public List<BackUser> quarryAll() {
        return null;
    }

    @Override
    public BackUser login(String username, String password) {
        BackUser backUser = backUserMapper.queryByUserName(username);
        if (backUser != null && backUser.getPassword().equals(password)) {
            //登录成功
            return backUser;
        }
        return null;
    }
}
