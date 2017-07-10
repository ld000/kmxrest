package com.k2data.app.kmx.cond;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.k2data.app.kmx.KmxInitParams;
import com.k2data.app.kmx.domain.Rule;
import com.k2data.app.kmx.domain.StreamRule;
import com.k2data.app.kmx.enums.KmxCondType;
import com.k2data.app.kmx.enums.RequestType;
import com.k2data.app.kmx.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidong9144@163.com 17-7-10.
 */
public class RuleBuilder extends KmxCondBuilder {

    private KmxInitParams initParams;

    public RuleBuilder(KmxInitParams initParams) {
        this.initParams = initParams;
    }

    public PostBuilder post() {
        return new PostBuilder();
    }

    public PutBuilder put() {
        return new PutBuilder();
    }

    public GetBuilder get() {
        return new GetBuilder();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class PostBuilder {
        private Rule rule;

        public PostBuilder() {
            this.rule = new Rule();
        }

        public PostBuilder namespace(String namespace) {
            this.rule.setNamespace(namespace);
            return this;
        }
        public PostBuilder level(Integer level) {
            this.rule.setLevel(level);
            return this;
        }
        public PostBuilder fieldGroupId(String fieldGroupId) {
            this.rule.setFieldGroupId(fieldGroupId);
            return this;
        }
        public PostBuilder addCompoundId(String key, Object value) {
            this.rule.getCompoundId().put(key, value);
            return this;
        }
        public PostBuilder compoundId(Map<String, Object> compoundIds) {
            this.rule.setCompoundId(compoundIds);
            return this;
        }
        public PostBuilder fieldId(String fieldId) {
            this.rule.setFieldId(fieldId);
            return this;
        }
        public PostBuilder operator(String operator) {
            this.rule.setOperator(operator);
            return this;
        }
        public PostBuilder value(String value) {
            this.rule.setValue(value);
            return this;
        }
        public PostBuilder description(String description) {
            this.rule.setDescription(description);
            return this;
        }
        public KmxCond build() {
            Map<String, String> params = new HashMap<>();
            params.put("query", JsonUtils.toJsonString(this.rule));

            KmxCond kmxCond = new KmxCond();
            kmxCond.setUrl(initParams.getUrls().get(KmxCondType.streamRules));
            kmxCond.setParams(params);
            kmxCond.setClazz(StreamRule.class);
            kmxCond.setRequestType(RequestType.POST);

            return kmxCond;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class PutBuilder {
        private Rule rule;

        public PutBuilder() {
            this.rule = new Rule();
        }

        public PutBuilder namespace(String namespace) {
            this.rule.setNamespace(namespace);
            return this;
        }
        public PutBuilder level(Integer level) {
            this.rule.setLevel(level);
            return this;
        }
        public PutBuilder fieldGroupId(String fieldGroupId) {
            this.rule.setFieldGroupId(fieldGroupId);
            return this;
        }
        public PutBuilder addCompoundId(String key, Object value) {
            this.rule.getCompoundId().put(key, value);
            return this;
        }
        public PutBuilder compoundId(Map<String, Object> compoundIds) {
            this.rule.setCompoundId(compoundIds);
            return this;
        }
        public PutBuilder fieldId(String fieldId) {
            this.rule.setFieldId(fieldId);
            return this;
        }
        public PutBuilder operator(String operator) {
            this.rule.setOperator(operator);
            return this;
        }
        public PutBuilder value(String value) {
            this.rule.setValue(value);
            return this;
        }
        public PutBuilder description(String description) {
            this.rule.setDescription(description);
            return this;
        }
        public PutBuilder id(Long id) {
            this.rule.setId(id);
            return this;
        }
        public PutBuilder state(Integer state) {
            this.rule.setState(state);
            return this;
        }
        public KmxCond build() {
            Map<String, String> params = new HashMap<>();
            params.put("query", JsonUtils.toJsonString(this.rule));

            KmxCond kmxCond = new KmxCond();
            kmxCond.setUrl(initParams.getUrls().get(KmxCondType.streamRules) + "/" + this.rule.getId());
            kmxCond.setParams(params);
            kmxCond.setClazz(StreamRule.class);
            kmxCond.setRequestType(RequestType.PUT);

            return kmxCond;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class GetBuilder {
        private Long id;
        private Integer pageSize;
        private Integer page;
        private String order;
        private String aggregation;
        private String fieldGroupId;
        private String fieldId;
        private Integer state;
        private Integer level;
        private String select;

        public GetBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public GetBuilder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        public GetBuilder page(Integer page) {
            this.page = page;
            return this;
        }
        public GetBuilder order(String order) {
            this.order = order;
            return this;
        }
        public GetBuilder aggregation() {
            this.aggregation = "count";
            return this;
        }
        public GetBuilder fieldGroupId(String fieldGroupId) {
            this.fieldGroupId = fieldGroupId;
            return this;
        }
        public GetBuilder fieldId(String fieldId) {
            this.fieldId = fieldId;
            return this;
        }
        public GetBuilder state(Integer state) {
            this.state = state;
            return this;
        }
        public GetBuilder level(Integer level) {
            this.level = level;
            return this;
        }
        public GetBuilder select(String select) {
            this.select = select;
            return this;
        }
        public KmxCond build() {
            Map<String, String> params = new HashMap<>();
            params.put("query", JsonUtils.toJsonString(this));

            String url = initParams.getUrls().get(KmxCondType.streamRules);
            if (this.id != null) {
                url += "/" + id;
            }

            KmxCond kmxCond = new KmxCond();
            kmxCond.setUrl(url);
            kmxCond.setParams(params);
            kmxCond.setClazz(StreamRule.class);
            kmxCond.setRequestType(RequestType.GET);

            return kmxCond;
        }
    }

}
