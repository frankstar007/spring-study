package com.frankstar.spring.boot.controller;

import cn.hutool.core.lang.Dict;
import com.frankstar.spring.boot.properties.ApplicationProperty;
import com.frankstar.spring.boot.properties.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.controller
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年08月24日 11:26
 */
@RestController
public class PropertyController {

    @Autowired
    private ApplicationProperty applicationProperty;

    @Autowired
    private DeveloperProperty developerProperty;

    @GetMapping("property")
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty)
                .set("developerProperty", developerProperty);

    }
}
