package com.example.bibased.service;

/**
 * @Description:Service接口，定义邮件发送的方法
 * @author zoey
 * @date:2018年11月7日
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
    void sendHtmlMail(String to, String subject, String content);
    void sendAttachmentsMail(String to, String subject,String content, String filePath);
}
