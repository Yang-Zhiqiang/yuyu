package yuyu.testinfr.inject;

import java.lang.reflect.Method;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;

public class MockModuleBinder {

    public static void bind(AbstractModule module) {
        Injector injector = SWAKInjector.getInjector().createChildInjector(module);
        Class<?> cls;
        try {
            cls = Class.forName("jp.co.slcs.swak.core.test.SWAKTestInjector");
            Method m = cls.getDeclaredMethod("setInjector", Injector.class);

            m.setAccessible(true);
            m.invoke(null, injector);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
