package com.frankstar.spring.boot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: spring-study
 * @Package com.frankstar.spring.boot.properties
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年08月24日 11:23
 */
@Data
@Component
@ConfigurationProperties(prefix = "developer")
public class DeveloperProperty {

    private String name;

    private String website;

    private String qq;

    private String phoneNumber;
}
