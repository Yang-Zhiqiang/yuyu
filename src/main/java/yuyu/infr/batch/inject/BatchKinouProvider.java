package yuyu.infr.batch.inject;

import java.lang.reflect.Method;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import jp.co.slcs.swak.batch.engine.BatchDef;
import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.BatchTester;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;

/**
 * バッチ機能Provider
 */
public class BatchKinouProvider implements Provider<AS_Kinou> {

    @Inject
    @Named("commandLine")
    String commandLine;

    @Inject
    BatchDef batchDef;

    @Inject
    BaseDomManager domManager;

    @SuppressWarnings("deprecation")
    @Override
    public AS_Kinou get() {
        AccessLog.pause();
        try {
            return Optional
              .fromNullable(domManager.getDetachedKinou(batchDef.getBatchId()))
              .or(
                new Supplier<AS_Kinou>() {
                    @Override
                    public AS_Kinou get() {
                        if (commandLine.contentEquals("junit")) {
                            return Optional.fromNullable(batchDef.getClassName())
                                .transform(
                                    new Function<String, Class<?>>() {
                                        @Override
                                        public Class<?> apply(String testClassName) {
                                            try {
                                                return Class.forName(testClassName);
                                            } catch (ClassNotFoundException e) {
                                                throw new RuntimeException(e);
                                            }
                                        }
                                    }
                                )
                                .transform(
                                    new Function<Class<?>, AS_Kinou>() {
                                        @Override
                                        public AS_Kinou apply(Class<?> testClass) {
                                            BatchTester tester = testClass.getAnnotation(BatchTester.class);
                                            if (tester == null) {
                                                return null;
                                            }
                                            return domManager.getDetachedKinou(tester.value());
                                        }
                                    }
                                )
                                .orNull();
                        }

                        Method batchMethod = SWAKInjector.getInstance(Method.class, "batchMethod");
                        if (batchMethod.getDeclaringClass().getPackage().getName().equals("jp.co.slcs.swak.batch.command")) {
                            AS_Kinou kinou = new AS_Kinou(batchDef.getBatchId());
                            kinou.setSubSystemId("swak");
                            kinou.setCategoryId ("batch");
                            return kinou;
                        }
                        return null;
                    }
                }
              );
        } finally {
            AccessLog.resume();
        }
    }

}
