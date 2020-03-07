package com.cn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.BackUser;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/12/12 22:13
 */
public interface BackUserMapper extends BaseMapper<BackUser> {
    BackUser queryByUserName(String username);

}
