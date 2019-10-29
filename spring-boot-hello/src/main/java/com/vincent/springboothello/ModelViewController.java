package com.vincent.springboothello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ModelViewController {


    @RequestMapping("/viewHtml")
    public String viewHtml() {
        return "<a href=\"www.baidu.com\">百度一下</a>";
    }


    @RequestMapping("/viewHtml2")
    public String viewHtml2() {
        return "helloview";
    }

    @RequestMapping("/view")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "我是消息内容");
        modelAndView.setViewName("helloview");
        return modelAndView;
    }
}
