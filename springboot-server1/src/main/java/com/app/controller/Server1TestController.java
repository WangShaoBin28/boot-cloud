package com.app.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.app.controller
 * @ClassName Server1TestController
 * @Author shaobin.wang
 * @Date 2019/07/04 16:57
 * @Version 1.0
 * @Description:
 **/
@Slf4j
@RestController
public class Server1TestController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration freemarkerConfiguration;


    @GetMapping("/helloServer1")
    public String helloServer1() {
        log.info("idea中代码调用");
        //制造异常让fegin进行熔断处理
//        int i = 1 / 0;
        return "调用成功：helloServer1";
    }

    //发送邮件
    @GetMapping("/sendEmail")
    public String sendEmail() throws MessagingException, IOException, TemplateException {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        FreeMarkerTemplateUtils.processTemplateIntoString(new Template())
//        // 发件人邮箱
//        mailMessage.setFrom("wsbsmile@163.com");
//        // 收信人邮箱
//        mailMessage.setTo("1418307288@qq.com");
//        // 邮件主题
//        mailMessage.setSubject("简单邮件测试");
//        // 邮件内容
//        mailMessage.setText("简单邮件测试");
//        this.javaMailSender.send(mailMessage);

        MimeMessage message = this.javaMailSender.createMimeMessage();
        // 第二个参数表示是否开启multipart模式
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom("");
        messageHelper.setTo("");
        messageHelper.setSubject("基于freemarker模板的邮件测试");

        Map<String, Object> model = new HashMap<>();

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(this.freemarkerConfiguration.getTemplate("index.ftl"), model);

        // 第二个参数表示是否html，设为true
        messageHelper.setText(content, true);

        this.javaMailSender.send(message);

        return "ok";
    }

}
