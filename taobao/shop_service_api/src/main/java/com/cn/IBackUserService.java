package com.cn;

import java.util.List;

public interface IBackUserService {
    List<BackUser> quarryAll();

    BackUser login(String username, String password);
}
