package com.vincent.springboothello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/helloC")//这里的话是localhost:8080/helloC/xxx方法
public class HelloWorldController {


    /**
     * 默认不写是localhost:8080
     * 写的就是代表localhost:8080/xxx方法
     *
     * @return
     */
    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "我是消息内容");
        modelAndView.setViewName("helloview");
        return modelAndView;
    }

}
