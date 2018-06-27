package com.example.bibased.util;

import java.util.UUID;

/**
 * <P>Description: 生成UUID业务类</P>
 * @ClassName: UUIDGenerator
 * @author A   2012-1-13 下午02:24:24
 * @see
 */
public class UUIDGenerator {
	/**
	 * <p>Title: createKey</p>
	 * <p>Description: 生成UUID公用业务方法</p>
	 * @return
	 * @author A   2012-1-13 下午02:25:11
	 */
	public static String createKey() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 
	 * <p>Title: create32Key</p>
	 * <p>Description: 创建32位的UUID</p>
	 * @return
	 * @author 许世选  2012-1-16 下午03:29:32
	 */
	public static String create32Key() {
		return UUID.randomUUID().toString().replaceAll("\\-", "");
	}
}
