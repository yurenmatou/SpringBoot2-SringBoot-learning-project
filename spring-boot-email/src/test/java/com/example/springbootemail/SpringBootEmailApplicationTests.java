package com.example.springbootemail;

import com.example.springbootemail.service.MailService;
import com.example.springbootemail.service.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootEmailApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private MailService service;


    @Test
    public void sendSimpleMail() {
        service.sendSimpleMail("vincentaijava@163.com", "尊敬的网易云客户", "你好啊");
    }


    @Test
    public void sendHtmlMail() {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "    <a href='http://www.baidu.com'>白你一下，度我如何</a>\n" +
                "</body>\n" +
                "</html>";
        service.sendHtmlMail("vincentaijava@163.com", "标题哦", content);
    }

    @Test
    public void sendAttachmentsMail() {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "    <a href='http://www.baidu.com'>白你一下，度我如何</a>\n" +
                "</body>\n" +
                "</html>";
        String filePath = "F:\\email\\163email.txt";
        FileOutputStream outputStream = null;
        try {
//            FileInputStream inputStream = new FileInputStream(new File(filePath));
            outputStream = new FileOutputStream(new File(filePath));
            int len = 0;
            byte[] arr = new byte[1024];
            outputStream.write(content.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        service.sendAttachmentsMail("vincentaijava@163.com", "这个是带附件的测试哦", content, filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封有图片的邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        String rscId = "uid10086";
        String filePath = "F:\\email\\timg.gif";
        service.sendInlineResourceMail("vincentaijava@163.com", "这个是带附件的测试哦", content, filePath,rscId);
    }

}
