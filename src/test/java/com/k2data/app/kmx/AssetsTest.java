package com.k2data.app.kmx;

import com.k2data.app.kmx.enums.KmxCondType;
import com.k2data.app.kmx.enums.KmxRestVersion;

/**
 * @author lidong 17-1-19.
 */
public class AssetsTest {

    private KmxInitParams initParams = new KmxInitParams(KmxRestVersion.V040)
            .setIdField("turbineId")
            .addUrl(KmxCondType.assets, "http://192.168.130.115:8081/data-service/v2/assets");

}
