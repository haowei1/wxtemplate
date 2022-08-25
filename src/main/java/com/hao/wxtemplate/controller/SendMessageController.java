package com.hao.wxtemplate.controller;

import com.hao.wxtemplate.server.SendMessageServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sendMessage")
public class SendMessageController {

    @Autowired
    SendMessageServer sendMessageServer;

    @RequestMapping("zaoan")
    public String sendZaoAnMessage() {
        sendMessageServer.sendMessage();
        return "早安";
    }

    @RequestMapping("wuan")
    public String sendWuAnMessage() {
        return "午安";
    }

    @RequestMapping("wanan")
    public String sendWanAnMessage() {
        return "晚安";
    }

}
