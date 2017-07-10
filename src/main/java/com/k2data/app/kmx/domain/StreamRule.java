package com.k2data.app.kmx.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidong9144@163.com 17-7-10.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StreamRule {

    private Integer code;
    private String message;
    private PageInfo pageInfo;
    private Rule dataRule;
    private List<Rule> dataRules;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Rule getDataRule() {
        return dataRule;
    }

    public void setDataRule(Rule dataRule) {
        this.dataRule = dataRule;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Rule> getDataRules() {
        if (this.dataRules == null) {
            this.dataRules = new ArrayList<>();
        }
        return dataRules;
    }

    public void setDataRules(List<Rule> dataRules) {
        this.dataRules = dataRules;
    }
}
