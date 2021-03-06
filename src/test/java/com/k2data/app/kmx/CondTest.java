package com.k2data.app.kmx;

import com.k2data.app.kmx.cond.KmxCond;
import com.k2data.app.kmx.enums.Aggregation;
import com.k2data.app.kmx.enums.KmxCondType;
import com.k2data.app.kmx.enums.KmxRestVersion;
import com.k2data.app.kmx.enums.Sign;
import org.junit.Test;

/**
 * @author lidong 17-1-20.
 */
public class CondTest {

    private KmxInitParams initParams = new KmxInitParams(KmxRestVersion.V040)
            .setIdField("turbineId")
            .addUrl(KmxCondType.dataRows, "http://192.168.130.115:8089/data-service/v4/data-rows")
            .addUrl(KmxCondType.dataPoints, "http://192.168.130.115:8089/data-service/v4/data-points")
            .addUrl(KmxCondType.dataStreams, "http://192.168.130.115:8089/data-service/v4/data-streams");

    @Test
    public void test1() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            KmxCond kmxCond = KmxCond.dataRows(initParams)
                    .idValue("turbine_001_FCJtT_002")
                    .start("2016-07-01T00:00:00.000%2B08:00")
                    .end("2016-07-08T00:00:00.000%2B08:00")
                    .fields(new String[]{"windSpeed", "powerActive"})
                    .valueTrans("powerActive", "powerActive * 1/120")
                    .andNonIdFieldFilter("pitchAngle", Sign.GTE, 0)
                    .andNonIdFieldFilter("pitchAngle", Sign.LTE, 25)
                    .aggregations("windSpeed", Aggregation.VARIANCE)
                    .aggregations("powerProduction", "powerActive", Aggregation.STDDEV)
                    .interval("1d")
                    .fill(0)
                    .resultFormatIso()
                    .build();

//            KmxCond kmxCond = KmxCond.dataPoints(initParams)
//                    .field("generatorSpeed")
//                    .sampleTime("2016-08-21T18:02:52.249%2B08:00")
//                    .shift(Shift.NEAR)
//                    .idValue("turbine_001_FCJtT_002")
//                    .resultFormatIso()
//                    .build();
//
//            System.out.println(kmxCond.getParams());

//            DPTestDomain domain = new DPTestDomain();
//            List<String> fields = new ArrayList<>();
//            fields.add("generatorSpeed");
//            domain.setFields(fields);
//            domain.setSampleTime("2016-08-21T18:02:52.249%2B08:00");
//            List<String> shift = new ArrayList<>();
//            shift.add("{ \"$default\": \"near\" }");
//            domain.setShift(shift);
//            IdFilterTestDomain idFilterTestDomain = new IdFilterTestDomain();
//            idFilterTestDomain.setDeivce("{ \"$eq\": \"turbine_001_FCJtT_002\" }");
//            domain.setCoValueFilter(idFilterTestDomain);
//            OptionTest optionTest = new OptionTest();
//            optionTest.setResultTimeFormat("iso");
//            domain.setOptions(optionTest);
//            JSON.toJSONString(domain);
//        Map<String, String> params = new HashMap<>();
//        params.put("query", "");
//
//        KmxCond cond = new KmxCond();
//        cond.setUrl(initParams.getUrls().get(KmxCondType.dataPoints));
//        cond.setParams(params);
//        cond.setClazz(DataPoints.class);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        // 100000  1700 ~ 1800ms
    }

}
