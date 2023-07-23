package yuyu.infr.batch.inject;

import javax.inject.Named;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.batch.config.BatchDefLoader;
import jp.co.slcs.swak.batch.engine.BatchDef;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.batch.engine.BatchParam;
import jp.co.slcs.swak.batch.inject.BatchModule;
import jp.co.slcs.swak.batch.reportandfile.ReportAndFileManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.AppIdentifierManager;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.uniquekey.UnitUniqueKeyGenerator;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.WorkflowAuthInfoImpl;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.config.YuyuBatchConfigLoader;
import yuyu.infr.batch.interceptors.BatchInterceptor;
import yuyu.infr.batch.internal.YuyuBatchJob;
import yuyu.infr.batch.reportandfile.ReportAndFileControl;
import yuyu.infr.uniquekey.YuyuAppIdentifierManager;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;

/**
 * Yuyuバッチモジュール
 */
public class YuyuBatchModule extends BatchModule {

    @Override
    protected void configure() {
        super.configure();

        bind(C_BatchKidouKbn.class).toInstance(C_BatchKidouKbn.BATCH);

        bind(BatchJob.class).to(getBatchJobClass()).in(BatchScoped.class);
        bindInterceptor(Matchers.subclassesOf(Batch.class), Matchers.annotatedWith(Execute.class), BatchInterceptor.INSTANCE);
        bind(AS_Kinou    .class).toProvider(BatchKinouProvider.class).in(BatchScoped.class);
        bind(BaseUserInfo.class).toProvider(BatchUserProvider .class).in(BatchScoped.class);

        bind(WorkflowAuthInfo.class).to(WorkflowAuthInfoImpl.class).in(BatchScoped.class);

        bind(ReportAndFileManager.class).to(ReportAndFileControl.class);
    }

    @Override
    protected Class<? extends BatchDefLoader> getBatchConfigLoaderClass() {
        return YuyuBatchConfigLoader.class;
    }

    @Override
    protected UniqueKeyGenerator getUniqueKeyGenerator() {
        return new UnitUniqueKeyGenerator();
    }

    @Override
    protected Class<? extends AppIdentifierManager> getAppIdentifierManagerClass() {
        return YuyuAppIdentifierManager.class;
    }

    @Provides
    @BatchScoped
    public Credentials provideCredentials(@Named("userId") String userId) {
        Credentials credentials = new Credentials();
        credentials.setUsername(userId);
        return credentials;
    }

    protected Class<? extends BatchJob> getBatchJobClass() {
        return YuyuBatchJob.class;
    }

    @Provides
    @BatchScoped
    @SuppressWarnings("unchecked")
    protected BatchParam provideBatchParam(BatchDef batchDef) {
        String paramBeanClassName = Strings.isNullOrEmpty(batchDef.getParamBeanClass()) ?
            batchDef.getDefaultParamBeanClass() :
            batchDef.getParamBeanClass();

        if (paramBeanClassName == null) {
            return null;
        }

        Class<BatchParam> paramBeanClass;
        try {
            paramBeanClass = (Class<BatchParam>) Class.forName(paramBeanClassName);
        } catch (ClassNotFoundException e) {
            throw new jp.co.slcs.swak.core.exception.configuration.ClassNotFoundException(
                e,
                String.format("AM_Batch (kinouId='%s')", batchDef.getBatchId()),
                paramBeanClassName,
                "paramBeanClass"
            );
        }
        try {
            return paramBeanClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Provides
    @BatchScoped
    @Named("userId")
    protected String provideUserId(BatchParam param) {

        if(param instanceof yuyu.infr.batch.BatchParam){
            return Strings.isNullOrEmpty(((yuyu.infr.batch.BatchParam)param).getUserId()) ? "BatchSystem" : ((yuyu.infr.batch.BatchParam)param).getUserId();
        }

        return "BatchSystem";
    }

    @Provides
    @BatchScoped
    @Named("batchSyoriYmd")
    @SuppressWarnings("deprecation")
    protected BizDate provideBatchSyoriYmd(
        BaseDomManager domManager,
        @Named("commandLine") String commandLine
    ) {
        BizDate syoriYmd;
        AccessLog.pause();
        try {
            syoriYmd = domManager.getBatchDate();
        } finally {
            AccessLog.resume();
        }
        int batchExecOffsetDays = 0;
        if (syoriYmd == null) {
            throw new BizAppException("バッチ実行日更新が一度も実行されていません。");
        }
        if (null != commandLine) {
            String clList[] = commandLine.split(",");
            for (String s : clList) {
                if (null != s && !"".equals(s)) {
                    if (s.indexOf(" ") != -1) {
                        s = s.split(" ")[1];
                    }
                    if (null != s && s.indexOf("=") != -1) {
                        String sLists[] = s.split("=");
                        if (null != sLists[0] && sLists[0].equals("batchExecOffsetDays")) {
                            batchExecOffsetDays = Integer.valueOf(sLists[1]);
                        }
                        if (null != sLists[0] && sLists[0].equals("syoriYmd")) {
                            return BizDate.valueOf(sLists[1]);
                        }
                    }
                }
            }
            if (0 != batchExecOffsetDays) {
                return syoriYmd.addDays(batchExecOffsetDays);
            }
        }
        return syoriYmd;
    }
}
