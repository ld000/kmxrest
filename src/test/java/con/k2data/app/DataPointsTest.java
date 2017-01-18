package con.k2data.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.k2data.app.kmx.KmxClient;
import com.k2data.app.kmx.KmxInitParams;
import com.k2data.app.kmx.cond.KmxCond;
import com.k2data.app.kmx.domain.DataPointsDomain;
import com.k2data.app.kmx.enums.KmxCondType;
import com.k2data.app.kmx.enums.KmxRestVersion;
import com.k2data.app.kmx.enums.Shift;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author lidong 17-1-18.
 */
public class DataPointsTest {

    private KmxInitParams initParams = new KmxInitParams(KmxRestVersion.V120)
            .setIdField("turbineId")
            .addUrl(KmxCondType.dataRows, "http://192.168.130.115:8089/data-service/v4/data-rows")
            .addUrl(KmxCondType.dataPoints, "http://192.168.130.115:8089/data-service/v4/data-points")
            .addUrl(KmxCondType.dataStreams, "http://192.168.130.115:8089/data-service/v4/data-streams");

    @Test
    public void F2_5() {
        KmxCond kmxCond = KmxCond.dataPoints(initParams)
                .field("generatorSpeed")
                .sampleTime("2016-08-21T18:02:52.249%2B08:00")
                .shift(Shift.NEAR)
                .idValue("turbine_001_FCJtT_002")
                .resultFormatIso()
                .build();

        DataPointsDomain dataPointsDomain = KmxClient.getSync(kmxCond);
        System.out.println(JSON.toJSONString(dataPointsDomain, SerializerFeature.DisableCircularReferenceDetect));

        Assert.assertNotNull(JSON.toJSONString(dataPointsDomain, SerializerFeature.DisableCircularReferenceDetect));
    }

}