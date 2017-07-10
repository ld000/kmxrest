package com.k2data.app.kmx.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidong9144@163.com 17-7-10.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rule {

    private Long id;
    private String namespace;
    private Integer level;
    private String fieldGroupId;
    private String fieldGroupSysid;
    private Map<String, Object> compoundId;
    private String fieldId;
    private String fieldSysid;
    private String operator;
    private String value;
    private Integer state;
    private Long ctime;
    private Long mtime;
    private String description;
    private String url;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFieldGroupId() {
        return fieldGroupId;
    }

    public void setFieldGroupId(String fieldGroupId) {
        this.fieldGroupId = fieldGroupId;
    }

    public Map<String, Object> getCompoundId() {
        if (compoundId == null) {
            compoundId = new HashMap<>();
        }
        return compoundId;
    }

    public void setCompoundId(Map<String, Object> compoundId) {
        this.compoundId = compoundId;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFieldGroupSysid() {
        return fieldGroupSysid;
    }

    public void setFieldGroupSysid(String fieldGroupSysid) {
        this.fieldGroupSysid = fieldGroupSysid;
    }

    public String getFieldSysid() {
        return fieldSysid;
    }

    public void setFieldSysid(String fieldSysid) {
        this.fieldSysid = fieldSysid;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
