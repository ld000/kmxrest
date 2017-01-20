package com.k2data.app.kmx.cond.serializer;

import com.k2data.app.kmx.cond.KmxCondBuilder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author lidong 17-1-20.
 */
public interface BaseSerializer {

    void write(SerializeWriter writer,
               String key,
               Object object, //
               Object fieldName, //
               Type fieldType) throws IOException;

}
