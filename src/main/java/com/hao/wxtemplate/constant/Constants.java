package com.hao.wxtemplate.constant;

public class Constants {

    //openId
    public static String appId = "wxb34d3b6a77f6c382";
    // appSecret
    public static String appSecret = "7141781337e89213f992d43833f4f337";
    //获取tokenUrl
    public static String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ appId +"&secret=" + appSecret;
    //模板ID
    public static String templateId = "P7BhQ2lKh7_Zda8nYoxIYz_gQ43KWNOpQiiv74GtBbI";
    //用户id
    public static String userId = "oFm645vlJvldYxahRW7Zab6cTOv0";
    //发送消息Url
    public static String sendMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
}
