package com.example.bibased;

import com.aliyuncs.exceptions.ClientException;
import com.example.bibased.service.MailService;
import com.example.bibased.serviceImple.RedisServiceImple;
import com.example.bibased.util.RandomUtils;
import com.example.bibased.util.SendDuanXinUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BibasedApplicationTests {

	@Autowired
	private MailService mailService;

	@Autowired
	private TemplateEngine templateEngine;


	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@Autowired
	private RedisServiceImple redisServiceImple ;


	@Test
	public void contextLoads() {
	}

	/**
	 * 发送文档型的邮件
	 * @throws Exception
	 */
	@Test
	public void testSimpleMail() throws Exception {
		mailService.sendSimpleMail("kakurry@126.com","邮件的标题"," 这是我的第一封文档的邮件！Hello Girl！");
	}

	/**
	 * @Description:发送模板邮件
	 * @author:zoey
	 * @date:2018年3月16日
	 */
	@Test
	public void sendTemplateMail() {
		//创建邮件正文
		Context context = new Context();
		context.setVariable("user", "小懒猪");
		context.setVariable("web", "留香阁餐厅");
		context.setVariable("company", "kakurry工作室");
		context.setVariable("product","留香阁网站");
		String emailContent = templateEngine.process("emailTemplate", context);
		mailService.sendHtmlMail("16411165306@qq.com","主题：这是模板邮件",emailContent);
	}

	/**
	 * @Description:发送带有附件的邮件
	 *
	 * @author:zoey
	 * @date:2018年3月16日
	 */
	@Test
	public void sendAttachmentsMail() {
		String filePath="C:\\Users\\HDX-HXX\\Desktop\\Linux.docx";
		mailService.sendAttachmentsMail("kakurry@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}

	/**
	 * 用于测试发送短信的功能
	 */
	@Test
	public void sendDuanxin() {
		try {
			String message = SendDuanXinUtils.sendDuanxin("18211136084","\"小懒猪\"");
			System.out.println(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成随机数的验证码
	 */
	@Test
	public void getRandom(){
		String random = RandomUtils.getRandom();
		System.out.println(random);
	}


	/*
	用于测试使用redis
	*/
	@Test
	public void testRedis(){
		//得到一个连接
		stringRedisTemplate.opsForValue().set("testconnect","hello world"); //设置值
		String firtgetValue = stringRedisTemplate.opsForValue().get("testconnect");//取值
		System.out.println(firtgetValue);
	}

	/**
	 * 运用这个类进行Reids的操作
	 *
	 */
	@Test
	public void RedisServiceImpl(){
		redisServiceImple.set("黄欣欣","何东旭");
		Object name = redisServiceImple.get("黄欣欣");
		System.out.println(name);
	}


}
