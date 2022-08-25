package com.hao.wxtemplate.server;

import com.google.gson.Gson;
import com.hao.wxtemplate.constant.Constants;
import com.hao.wxtemplate.domain.TemplateData;
import com.hao.wxtemplate.domain.WxTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendMessageServer {

    public void sendMessage(){

        Gson gson = new Gson();

        //封装post的请求体
        WxTemplate temp = new WxTemplate();
        temp.setToUser(Constants.userId);
        temp.setTemplateId(Constants.templateId);
        Map<String, TemplateData> m = new HashMap<>();
        TemplateData first = new TemplateData();
        first.setColor("#000000");
        first.setValue("");
        m.put("first", first);
        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#000000");
        keyword1.setValue("***太仓分公司");
        m.put("keyword1", keyword1);
        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#000000");
        keyword2.setValue("原料卸货");
        m.put("keyword2", keyword2);
        TemplateData keyword3 = new TemplateData();
        keyword3.setColor("#000000");
        keyword3.setValue("见送货单");
        m.put("keyword3", keyword3);
        TemplateData keyword4 = new TemplateData();
        keyword4.setColor("#000000");
        keyword4.setValue("");
        m.put("keyword4", keyword4);
        TemplateData remark = new TemplateData();
        remark.setColor("#000000");
        remark.setValue("");
        m.put("remark", remark);
        temp.setData(m);
        String data = gson.toJson(temp);
        //请求
        RestTemplate restTemplate = new RestTemplate();
//        String tokenResult = restTemplate.getForObject(Constants.getTokenUrl, String.class);
//        System.out.println(tokenResult);
//        Map map = gson.fromJson(tokenResult, Map.class);
//        String access_token = map.get("access_token").toString();
        String access_token = "60_4sjugHMB9e_wtSbKzJT1e3FTR4Yb5jTTbG2C38-whHKJZRqOuGC0sOhUJ0dYk209Rc0EirU7i1HRGBkwDXG0lDsRdZ1vHttGMBnveWz0tlr0sbCljuVUE5S6okNFEpf-YIby79Cj7UY6jhh1TYPjAAAINE";
        System.out.println(access_token);

        String sendMessageUrl = Constants.sendMessageUrl + access_token;
        String result = restTemplate.postForObject(sendMessageUrl, data, String.class);
    }


}
