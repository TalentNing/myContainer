package util;

import sun.util.logging.PlatformLogger;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by tkn on 2016/10/29.
 */
final class Tripwire {
    private static final String TRIPWIRE_PROPERTY = "org.openjdk.java.util.stream.tripwire";

    static final boolean ENABLED = AccessController.doPrivileged(
            (PrivilegedAction<Boolean>)()->Boolean.getBoolean(TRIPWIRE_PROPERTY)
    );

    private Tripwire(){ };

    static void trip(Class<?> trippingClass,String msg){
        PlatformLogger.getLogger(trippingClass.getName()).warning(msg,trippingClass.getName());
    }

}
