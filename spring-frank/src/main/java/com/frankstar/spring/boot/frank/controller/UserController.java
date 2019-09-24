package com.frankstar.spring.boot.frank.controller;

import com.frankstar.spring.boot.frank.model.User;
import com.frankstar.spring.boot.frank.processor.UserProcessor;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.frank.controller
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年09月23日 23:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserProcessor userProcessor;

    @RequestMapping("/{userid}")
    public User loadUser(@PathVariable("userid") int userId) {
        return userProcessor.loadUser(userId);

    }

    //查询所有用户
    @GetMapping("/userlist")
    public ModelAndView userList(Model model) {
        List<User> userList = userProcessor.loadAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("title", "用户管理");
        return new ModelAndView("user/list", "userModel", model);
    }
}
