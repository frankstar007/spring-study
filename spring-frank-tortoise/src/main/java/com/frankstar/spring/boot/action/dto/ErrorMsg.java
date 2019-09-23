package com.frankstar.spring.boot.action.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMsg implements Serializable {

	private static final long serialVersionUID = -8827541213471298979L;

	private String title;

	private int status;

	private Date timestamp;

	private String messages;

	private String error;

}
