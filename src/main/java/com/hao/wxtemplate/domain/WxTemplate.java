package com.hao.wxtemplate.domain;

import lombok.Data;

import java.util.Map;

@Data
public class WxTemplate {

    private String templateId;
    private String toUser;
    private Map<String,TemplateData> data;
}
