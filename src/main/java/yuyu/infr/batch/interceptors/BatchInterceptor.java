package yuyu.infr.batch.interceptors;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.batch.exception.BatchInterruptedException;
import jp.co.slcs.swak.core.exception.InvalidMethodException;
import jp.co.slcs.swak.core.exception.Messageable;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.reflect.ClassUtils;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_LogLevelKbn;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.id.PKAS_BatchOrder;
import yuyu.def.db.id.PKAT_BatchJob;
import yuyu.def.db.meta.QAT_BatchLog;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.common.invalidfunctioncheck.InvalidFunctionChecker;
import yuyu.infr.exception.InvalidFunctionException;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infrext.RayDB2Util;
import yuyu.infrext.RayUtil;
import yuyu.infrext.exception.RayDB2DeadLockException;

import com.google.common.base.Strings;

/**
 * バッチインターセプター 業務バッチ運行の前後はバッチジョブの処理です。
 */
public class BatchInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory
        .getLogger(BatchInterceptor.class);


    public static final BatchInterceptor INSTANCE = new BatchInterceptor();

    private String UNEXPECTED_ERROR_MSG = null;

    private BatchInterceptor() {
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        RayUtil.setupDBConnectionLogInfo();

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        KinouMode kinouMode = new KinouMode();
        AS_KinouMode kinouModeTable = kinou.getKinouMode(kinouMode.getKinouMode());

        if (!InvalidFunctionChecker.isValid(kinou, kinouModeTable)) {
            throw new InvalidFunctionException("機能モードテーブルの有効区分が有効状態でないため、機能が利用できません。");
        }

        BatchParam param = ((Batch) invocation.getThis()).getParam();

        if (param.getSyoriYmd() == null || "".equals(param.getSyoriYmd())) {
            param.setSyoriYmd(getBatchDate(param));
        }

        preExecute(param);
        Throwable throwable = null;
        BatchLogger batchLogger = SWAKInjector.getInstance(BatchLogger.class);

        YuyuBaseConfig yuyuBaseConfig = SWAKInjector.getInstance(YuyuBaseConfig.class);

        try {
            batchLogger.info(MessageUtil.getMessage(yuyuBaseConfig.getBatchLogMessageCode().getBeginMessage() , kinou.getKinouNm()));
            SWAKInjector.getInstance(ClientExecute.class).invoke();
            return invocation.proceed();

        } catch (Throwable th) {
            if(RayDB2Util.isDeadRockException(th)){
                throw new RayDB2DeadLockException(th);
            }

            batchRollBack(invocation);
            throwable = th;
            throw th;
        } finally {
            RayUtil.clearDBConnectionLogInfo();

            postExecute(throwable);
            batchOrderDelExecute();
            batchLogger.info(MessageUtil.getMessage(yuyuBaseConfig.getBatchLogMessageCode().getEndMessage(), kinou.getKinouNm()));
        }
    }

    private void batchRollBack(MethodInvocation invocation) throws Throwable{
        boolean methodNotFound = true;
        for (Class<?> c : ClassUtils.superClasses(invocation.getThis().getClass(), true)) {
            for (Method method : c.getDeclaredMethods()) {
                if(method.isAnnotationPresent(AppBatchExceptionTerminate.class)){
                    if (! method.getReturnType().equals(Void.TYPE)) {
                        throw new InvalidMethodException(method, "@AppBatchExceptionTerminate annotated method return type must be 'void'.");
                    }
                    if ( method.getParameterTypes().length > 0) {
                        throw new InvalidMethodException(method, "@AppBatchExceptionTerminate annotated method should have no parameters.");
                    }
                    boolean accessible = method.isAccessible();
                    try {
                        methodNotFound = false;
                        if (! method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        method.invoke(invocation.getThis());
                    } catch (InvocationTargetException e) {
                        throw e.getCause();
                    } finally {
                        if (method.isAccessible() != accessible) {
                            method.setAccessible(accessible);
                        }
                    }
                }
            }
        }
        if(methodNotFound){
            logger.trace("@{} annotated method is not found. Invocation skipped.", "AppBatchExceptionTerminate");
        }
    }


    private BizDate getBatchDate(BatchParam param) {

        BizDate batchDate = SWAKInjector.getInstance(BaseDomManager.class).getBatchDate();
        if (batchDate != null) {
            return batchDate;
        }

        return BizDate.getSysDate();
    }

    private void batchOrderDelExecute() {
        final BatchJob job = SWAKInjector.getInstance(BatchJob.class);
        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    AS_BatchOrder batchOrder = entityManager.findByPK(new PKAS_BatchOrder(job.getBatchJobId()));
                    if (null != batchOrder) {
                        entityManager.remove(batchOrder);
                    }
                }
            }
            );
    }

    private void preExecute(BatchParam param) throws Exception {
        BatchJob job = SWAKInjector.getInstance(BatchJob.class);

        final AT_BatchJob jobEntity = new AT_BatchJob();
        jobEntity.setBatchJobId(job.getBatchJobId());
        jobEntity.setBatchId(job.getBatchDef().getBatchId());
        jobEntity.setBatchKidouKbn(param.getKidouKbn());

        if (job.getStartTime() == null) {
            jobEntity.setBatchJyoutaiKbn(C_BatchJyoutaiKbn.TAIKI);
        } else {
            jobEntity.setBatchJyoutaiKbn(C_BatchJyoutaiKbn.SYORI);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            jobEntity.setBatchStartTime(sdf.format(job.getStartTime()));
        }
        jobEntity.setBatchSyoriYmd(param.getSyoriYmd());

        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    if (!entityManager.getTransaction().isActive()) {
                        entityManager.getTransaction().begin();
                    }
                    entityManager.persist(jobEntity);
                    entityManager.flush();
                }
            }
            );
    }

    private void postExecute(final Throwable throwable) {
        final boolean interrupted = isInterrupted(throwable);

        final BatchJob job = SWAKInjector.getInstance(BatchJob.class);

        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
                    if (!entityManager.getTransaction().isActive()) {
                        entityManager.getTransaction().begin();
                    }
                    AT_BatchJob jobEntity = entityManager.findByPK(new PKAT_BatchJob(
                        job.getBatchJobId()));

                    jobEntity.setBatchJyoutaiKbn(C_BatchJyoutaiKbn.SYUURYOU);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                    Date endTime = BizDate.getSystemDate().getTime();
                    jobEntity.setBatchEndTime(sdf.format(endTime));

                    long elapsedSeconds = (endTime.getTime() - job.getStartTime()
                        .getTime()) / 1000;
                    jobEntity.setElapsedSeconds(elapsedSeconds);
                    jobEntity.setElapsedTime(getElapsedTime(elapsedSeconds));

                    if (interrupted) {
                        jobEntity.setBatchResultKbn(C_BatchResultKbn.INTERRUPT);
                        SWAKInjector.getInstance(BatchLogger.class).info(MessageUtil.getMessage(MessageId.WAC0009, kinou.getKinouNm()));
                    } else if (throwable != null) {
                        jobEntity.setBatchResultKbn(C_BatchResultKbn.ERROR);
                        String errorMessage = null;
                        if (throwable instanceof Messageable) {
                            errorMessage = ((Messageable) throwable).getMessage();
                        } else {
                            if (UNEXPECTED_ERROR_MSG == null) {
                                UNEXPECTED_ERROR_MSG = MessageUtil
                                    .getMessage(MessageId.EAS0027);
                            }
                            errorMessage = UNEXPECTED_ERROR_MSG;
                            logger.error("error while batch executing.", throwable);
                        }
                        SWAKInjector.getInstance(BatchLogger.class).error(errorMessage);
                    } else {
                        QAT_BatchLog qBl = new QAT_BatchLog("l");
                        String query = $SELECT + $MAX(qBl.logLevelKbn) + $FROM
                            + qBl.AT_BatchLog() + $WHERE
                            + qBl.batchJobId.eq(job.getBatchJobId());
                        C_LogLevelKbn maxLogLevelKbn = entityManager.createJPQL(query)
                            .bind(qBl).getSingleResult();
                        C_BatchResultKbn resultKbn = null;
                        if (maxLogLevelKbn == null
                            || maxLogLevelKbn.eq(C_LogLevelKbn.INFO)) {
                            resultKbn = C_BatchResultKbn.NORMAL;
                        } else if (maxLogLevelKbn.eq(C_LogLevelKbn.ERROR)) {
                            resultKbn = C_BatchResultKbn.ERROR;
                        } else if (maxLogLevelKbn.eq(C_LogLevelKbn.WARN)) {
                            resultKbn = C_BatchResultKbn.WARN;
                        }
                        jobEntity.setBatchResultKbn(resultKbn);
                    }
                    entityManager.flush();
                }
            }
            );
    }

    boolean isInterrupted(Throwable throwable) {
        if (throwable == null) {
            return false;
        }

        if (throwable instanceof BatchInterruptedException) {
            return true;
        } else if (throwable instanceof InvocationTargetException) {
            Throwable t = ((InvocationTargetException) throwable)
                .getTargetException();
            return isInterrupted(t);
        }

        return false;
    }

    String getElapsedTime(long elapsedSeconds) {
        long es = elapsedSeconds;
        StringBuilder sb = new StringBuilder();
        sb.append(es / 3600);
        sb.append(":");
        es = es % 3600;
        sb.append(Strings.padStart(String.valueOf(es / 60), 2, '0'));
        sb.append(":");
        sb.append(Strings.padStart(String.valueOf(es % 60), 2, '0'));

        return sb.toString();
    }

}
