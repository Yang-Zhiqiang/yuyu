package yuyu.testinfr.inject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import yuyu.def.classification.C_LogLevelKbn;
import yuyu.infr.batch.inject.YuyuBatchModule;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.testinfr.AbstractBatchTest;

/**
 * バッチUnitTest用の GoogleGuiceバインディング定義モジュールです。
 */
public class YuyuMockBatchModule extends YuyuBatchModule {

    @Override
    protected void configure() {
        super.configure();
        //        bind(BatchLogger.class).to(NothingBatchLogger.class);
        //        bindInterceptor(Matchers.subclassesOf(AbstractBatchTest.class), Matchers.annotatedWith(Test.class), new BatchTestInterceptor());
    }

    //    @Override
    //    protected Class<? extends BatchJob> getBatchJobClass() {
    //        return MockBatchJob.class;
    //    }

    public static class NothingBatchLogger extends BatchLogger {
        @Override
        public void info(String msg) {
            info(msg, null);
        }

        @Override
        public void info(String msg, String hiddenMsg) {
            log(C_LogLevelKbn.INFO, msg, hiddenMsg);
        }

        @Override
        public void warn(String msg) {
            warn(msg, null);
        }

        @Override
        public void warn(String msg, String hiddenMsg) {
            log(C_LogLevelKbn.WARN, msg, hiddenMsg);
        }

        @Override
        public void error(String msg) {
            error(msg, null);
        }

        @Override
        public void error(String msg, String hiddenMsg) {
            log(C_LogLevelKbn.ERROR, msg, hiddenMsg);
        }

        @SuppressWarnings("unused")
        private void log(C_LogLevelKbn level, String msg, String hiddenMsg) {
        }
    }

    private static class BatchTestInterceptor implements MethodInterceptor {

        BatchTestInterceptor() {}

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            AbstractBatchTest batchTest = (AbstractBatchTest) invocation.getThis();
            batchTest.beforeCase();
            try {
                batchTest.preTestCase(invocation.getMethod().getName());
                return invocation.proceed();
            } finally {
                batchTest.postTestCase(invocation.getMethod().getName());
                batchTest.afterCase();
            }
        }
    }

    //    @BatchScoped
    //    public static class MockBatchJob extends YuyuBatchJob {
    //
    //        private static final long serialVersionUID = 7090481411807506001L;
    //
    //        private String jobId = null;
    //
    //        @Override
    //        public String getBatchJobId() {
    //            if (jobId == null) {
    //                jobId = SWAKInjector.getInstance(UniqueKeyGenerator.class).generateUniqueKey();
    //            }
    //            return jobId;
    //        }
    //
    //        @Override
    //        public BatchDef getBatchDef() {
    //            return new BatchDef() {
    //
    //                private static final long serialVersionUID = -8250195782203835599L;
    //
    //                @Override
    //                public boolean isMultiplex() {
    //                    return false;
    //                }
    //
    //                @Override
    //                public String getParamBeanClass() {
    //                    return null;
    //                }
    //
    //                @Override
    //                public String getMethodName() {
    //                    return null;
    //                }
    //
    //                @Override
    //                public String getDefaultParamBeanClass() {
    //                    return null;
    //                }
    //
    //                @Override
    //                public String getClassName() {
    //                    return SWAKInjector.getInstance(Class.class, "TestClass").getName();
    //                }
    //
    //                @Override
    //                public String getBatchId() {
    //                    String batchId = SWAKInjector.getInstance(String.class, "BatchId");
    //                    return Strings.isNullOrEmpty(batchId) ? SWAKInjector.getInstance(Class.class, "TestClass").getSimpleName() : batchId;
    //                }
    //            };
    //        }
    //
    //        @Override
    //        public Date getStartTime() {
    //            return new Date();
    //        }
    //
    //        @Override
    //        public Date getEndTime() {
    //            return new Date();
    //        }
    //
    //    }
}
