package com.zaynukov.dev.utils;

import org.jibx.runtime.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public final class XmlUtils {
    private XmlUtils() {
    }

    public static String marshalling(Object o) {
        try (StringWriter stringWriter = new StringWriter();) {
            IMarshallingContext context = BindingDirectory.getFactory(o.getClass()).createMarshallingContext();
            context.setIndent(2);
            context.setOutput(stringWriter);
            context.marshalDocument(o, "UTF-8", null);
            return stringWriter.toString();
        } catch (JiBXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshalling(Class<T> rootElementClass, InputStream is) {
        try {
            IBindingFactory jc = BindingDirectory.getFactory(rootElementClass);
            IUnmarshallingContext unmarshaller = jc.createUnmarshallingContext();
            return (T) unmarshaller.unmarshalDocument(is, "UTF-8");
        } catch (JiBXException e) {
            e.printStackTrace();
            return null;
        }
    }
}
