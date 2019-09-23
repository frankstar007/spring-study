package com.frankstar.spring.boot.action.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
@Slf4j
public class DateUtils {

	public static final String  SIMPLE_FORMAT = "yyyy-MM-dd hh:mm:ss";

	public static Date format(String date, String format) {
		if (StringUtils.isEmpty(date)) return new Date();
		try {
			DateFormat dateFormat =  new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (ParseException e) {
			log.error("", e);
		}
		return new Date();
	}
}
