package com.k2data.app.kmx.cond;

import com.k2data.app.kmx.KmxInitParams;
import com.k2data.app.kmx.domain.DataRows;
import com.k2data.app.kmx.enums.KmxCondType;
import com.k2data.app.kmx.enums.Sign;
import com.k2data.app.kmx.utils.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lidong9144@163.com 17-7-17.
 */
public class DataRowsRealTimeV4Builder extends DataRowsV4Builder {

    public DataRowsRealTimeV4Builder(KmxInitParams initParams) {
        super(initParams);
    }

    @Override
    public KmxCond build() {
        Assert.notEmpty(fields, "Field must not be null");
        Assert.notNull(start, "Start must not be null");
        Assert.notNull(end, "End must not be null");

        String paramsSb = "{" + noSignList(
                objField("fieldGroup", fieldGroup),
                list("fields", new ArrayList<>(fields), true),
                obj("timeRange",
                        objField("start", start),
                        objField("end", end)
                ),
                list("valueFilters", valueFilters),
                list("valueTrans", valueTrans),
                obj("coValueFilter",
                        obj("idFieldFilter",
                                obj(initParams.getIdField(), objField(Sign.EQ.getValue(), idValue)),
                                list(Sign.OR.getValue(), orIdValue),
                                list(Sign.AND.getValue(), andIdValue)
                        ),
                        obj("nonIdFieldFilter",
                                list(Sign.AND.getValue(),
                                        andNonIdFieldFilter
                                ),
                                list(Sign.OR.getValue(),
                                        orNonIdFieldFilter
                                )
                        )
                ),
                list("aggregations", aggregations),
                obj("aggregationOptions",
                        objField("interval", interval),
                        objField("naturalTimeBoundary", naturalTimeBoundary),
                        objField("fill", fill)
                ),
                objField("order", order),
                objField("size", size),
                objField("page", page),
                obj("options", objField("resultTimeFormat", resultFormatIso))
        ) + "}";

        Map<String, String> params = new HashMap<>();
        params.put("query", paramsSb);

        KmxCond cond = new KmxCond();
        cond.setUrl(initParams.getUrls().get(KmxCondType.dataRowsRealTime));
        cond.setParams(params);
        cond.setClazz(DataRows.class);
        cond.setRequestType(requestType);

        return cond;
    }

}
