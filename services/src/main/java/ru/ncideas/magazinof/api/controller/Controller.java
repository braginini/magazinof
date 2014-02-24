package ru.ncideas.magazinof.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ncideas.magazinof.api.domain.User;
import ru.ncideas.magazinof.api.service.UserServiceApi;

import java.util.List;

/**
 * User: mbragin
 * Date: 28.04.12
 * Time: 15:33
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserServiceApi userServiceApi;

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public @ResponseBody
    User getUsrById(@PathVariable Long id) {
        return userServiceApi.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public @ResponseBody
    List<User> getAllUsers() {
        return userServiceApi.getAllUsers();
    }
}
