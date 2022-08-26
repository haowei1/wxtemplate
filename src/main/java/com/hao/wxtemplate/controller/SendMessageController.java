package com.hao.wxtemplate.controller;

import com.hao.wxtemplate.constant.Constants;
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
        sendMessageServer.sendMessage(Constants.templateId_ZAO);
        return "早安";
    }

    @RequestMapping("wuan")
    public String sendWuAnMessage() {
        sendMessageServer.sendMessage(Constants.templateId_WU);
        return "午安";
    }

    @RequestMapping("wanan")
    public String sendWanAnMessage() {
        sendMessageServer.sendMessage(Constants.templateId_WAN);
        return "晚安";
    }

}
