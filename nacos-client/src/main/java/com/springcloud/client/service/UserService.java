package com.springcloud.client.service;



import com.springcloud.client.domain.User;

import java.util.List;

/**
 * Created by macro on 2019/8/29.
 */
public interface UserService {
    void create(User user);

    User getUser(Long id) throws InterruptedException;

    void update(User user);

  //  void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
