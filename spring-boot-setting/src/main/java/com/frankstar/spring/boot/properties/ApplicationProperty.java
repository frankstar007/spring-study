package com.frankstar.spring.boot.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.properties
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年08月24日 11:13
 */
@Data
@Component
public class ApplicationProperty {

    @Value("${application.name}")
    private String name;

    @Value("${application.version}")
    private String version;
}
