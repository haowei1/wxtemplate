package com.hao.wxtemplate.domain;

import lombok.Data;

import java.util.Map;

@Data
public class WxTemplate {

    private String template_id;
    private String touser;
    private String url;
    private String topcolor;
    private Map<String,TemplateData> data;
}
