package com.hao.wxtemplate.server;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hao.wxtemplate.constant.Constants;
import com.hao.wxtemplate.domain.TemplateData;
import com.hao.wxtemplate.domain.Weather;
import com.hao.wxtemplate.domain.WeatherInfo;
import com.hao.wxtemplate.domain.WxTemplate;
import com.hao.wxtemplate.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class SendMessageServer {

    @Autowired
    private RestTemplate restTemplate;

    private String access_token = "";

    private String[] names = {"小郑", "小居居", "居居霞", "郑宝宝", "霞妹er", "郑美女", "郑可爱"};

    public void sendMessage(String templateId){

        Gson gson = new Gson();
        //封装post的请求体
        WxTemplate temp = new WxTemplate();
        temp.setTouser(Constants.userId);
        temp.setTemplate_id(templateId);
        temp.setUrl("");
        temp.setTopcolor(CommonUtil.getRandomColor());
        Map<String, TemplateData> m = new HashMap<>();
        TemplateData name = new TemplateData();
        name.setColor(CommonUtil.getRandomColor());
        name.setValue(names[new Random().nextInt(7)]);
        m.put("name", name);
        TemplateData date = new TemplateData();
        date.setColor(CommonUtil.getRandomColor());
        date.setValue(CommonUtil.getDate("yyyy年MM月dd日"));
        m.put("date", date);
        TemplateData day = new TemplateData();
        day.setColor(CommonUtil.getRandomColor());
        day.setValue("2");
        m.put("day", day);
        TemplateData calendar = new TemplateData();
        calendar.setColor(CommonUtil.getRandomColor());
        calendar.setValue(CommonUtil.getCalendar());
        m.put("calendar", calendar);
        TemplateData week = new TemplateData();
        week.setColor(CommonUtil.getRandomColor());
        week.setValue(CommonUtil.getWeek());
        m.put("week", week);
        TemplateData city = new TemplateData();
        city.setColor(CommonUtil.getRandomColor());
        city.setValue(Constants.city);
        m.put("city", city);
        TemplateData weather = new TemplateData();
        weather.setColor(CommonUtil.getRandomColor());
        weather.setValue("晴间多云 17°~28°");
        m.put("weather", weather);
        TemplateData festival1 = new TemplateData();
        festival1.setColor(CommonUtil.getRandomColor());
        festival1.setValue(Constants.festival1);
        m.put("festival1", festival1);
        TemplateData date1 = new TemplateData();
        date1.setColor(CommonUtil.getRandomColor());
        date1.setValue(CommonUtil.getDateCount(date.getValue(), Constants.date1));
        m.put("date1", date1);
        TemplateData festival2 = new TemplateData();
        festival2.setColor(CommonUtil.getRandomColor());
        festival2.setValue(Constants.festival2);
        m.put("festival2", festival2);
        TemplateData date2 = new TemplateData();
        date2.setColor(CommonUtil.getRandomColor());
        date2.setValue(CommonUtil.getDateCount(date.getValue(), Constants.date2));
        m.put("date2", date2);
        TemplateData birthday = new TemplateData();
        birthday.setColor(CommonUtil.getRandomColor());
        birthday.setValue(CommonUtil.getDateCount(date.getValue(), Constants.birthday));
        m.put("birthday", birthday);
        TemplateData proverb = new TemplateData();
        proverb.setColor(CommonUtil.getRandomColor());
        proverb.setValue(Constants.proverb);
        m.put("proverb", proverb);
        TemplateData proverbs = new TemplateData();
        proverbs.setColor(CommonUtil.getRandomColor());
        proverbs.setValue(Constants.proverbs);
        m.put("proverbs", proverbs);
        TemplateData remark = new TemplateData();
        remark.setColor(CommonUtil.getRandomColor());
        remark.setValue(Constants.remark);
        m.put("remark", remark);
        temp.setData(m);
        String data = gson.toJson(temp);
        //请求
        if (access_token == null || access_token.equals("")) {
            System.out.println("---accessToken为空获取accessToken----");
            access_token = getAccessToken();
        }

        String sendMessageUrl = Constants.sendMessageUrl + access_token;
        System.out.println(data);
        String resultStr = restTemplate.postForObject(sendMessageUrl, data, String.class);
        Map resultMap = gson.fromJson(resultStr, Map.class);
        String errCode = resultMap.get("errcode").toString();
        if (errCode.equals("40001") || errCode.equals("41001")) {
            System.out.println("---accessToken过期accessToken----");
            access_token = getAccessToken();
            sendMessageUrl = Constants.sendMessageUrl + access_token;
            System.out.println(data);
            String result = restTemplate.postForObject(sendMessageUrl, data, String.class);
            System.out.println(result);
        }
    }

    /**
     * 获取请求需要的 access_token
     * @return access_token
     */
    public String getAccessToken() {
        Gson gson = new Gson();
        String tokenResult = restTemplate.getForObject(Constants.getTokenUrl, String.class);
        Map map = gson.fromJson(tokenResult, Map.class);
        String token = map.get("access_token").toString();
        System.out.println(token);
        return token;
    }

    public static String getWeather() {
        RestTemplate restTemplate1 = new RestTemplate();
        WeatherInfo forObject = restTemplate1.getForObject(Constants.weatherUrl, WeatherInfo.class);
        System.out.println(forObject);
        List<Weather> weatherinfo = forObject.getWeatherinfo();
        Weather weather = weatherinfo.get(0);
        System.out.println(weather.toString());
//        Weather weather1 = new Gson().fromJson(weather, Weather.class);
        return weather.getCity();
    }

    public static void main(String[] args) {
        String week = getWeather();
        System.out.println(week);
    }


}
