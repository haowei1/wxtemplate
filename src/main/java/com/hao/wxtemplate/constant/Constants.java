package com.hao.wxtemplate.constant;

public class Constants {

    //openId
    public static String appId = "wxb34d3b6a77f6c382";
    // appSecret
    public static String appSecret = "7141781337e89213f992d43833f4f337";
    //获取tokenUrl
    public static String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ appId +"&secret=" + appSecret;
    //用户id
    public static String userId = "oFm645vlJvldYxahRW7Zab6cTOv0";
    public static String userId_HWY = "oFm645vlJvldYxahRW7Zab6cTOv0";
    public static String userId_XJJ = "oFm645moqrPRrllHuEUbMpV7Iyzs";
    //发送消息Url
    public static String sendMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    //模板ID
    public static String templateId_ZAO = "ehdueSiJ2AxMjHwEl-K-KFvnZfOs3iuK5biGByKZM90";
    public static String templateId_WU = "hqKugwhT0rIchxOPwYcba4mkMKWfsLKVVWZ6t4jSyrY";
    public static String templateId_WAN = "Nf6gKbYCQl0xqDoSkBpF3_bSe7WUgBBOGEOq48N4z0g";

    public static String city = "北京市";
    public static String cityCode = "101010100";
    public static String weatherUrl = "http://www.weather.com.cn/data/cityinfo/" + cityCode + ".html";

    // 日期
    public static String festival1 = "中秋节";
    public static String date1 = "2022-09-10";
    public static String festival2 = "国庆节";
    public static String date2 = "2022-10-01";
    public static String birthday = "2023-06-13";



    // 谚语
    public static String proverb = "";
    public static String proverbs = "";

    // 备注
    public static String remark = "";
}
