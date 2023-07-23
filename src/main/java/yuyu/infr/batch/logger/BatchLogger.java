package yuyu.infr.batch.logger;

import javax.inject.Inject;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;

import org.slf4j.Logger;

import yuyu.def.classification.C_LogLevelKbn;
import yuyu.def.db.entity.AT_BatchLog;

import com.google.common.base.Strings;

/**
 * バッチロガー
 */
@BatchScoped
public class BatchLogger {

    private static final Logger logger = LoggerFactory.getLogger(BatchLogger.class);

    @Inject
    private BatchJob batchJob;

    private int logEdaNo = 0;

    public void info(String msg) {
        info(msg, null);
    }

    public void info(String msg, String hiddenMsg) {
        log(C_LogLevelKbn.INFO, msg, hiddenMsg);
    }

    public void warn(String msg) {
        warn(msg, null);
    }

    public void warn(String msg, String hiddenMsg) {
        log(C_LogLevelKbn.WARN, msg, hiddenMsg);
    }

    public void error(String msg) {
        error(msg, null);
    }

    public void error(String msg, String hiddenMsg) {
        log(C_LogLevelKbn.ERROR, msg, hiddenMsg);
    }

    private void log(C_LogLevelKbn level, String msg, String hiddenMsg) {
        int batchLogEdaNo = ++logEdaNo;
        StringBuilder sb = new StringBuilder();
        sb.append("batchJobId = '");
        sb.append(batchJob.getBatchJobId());
        sb.append("', batchLogEdaNo = '");
        sb.append(batchLogEdaNo);
        sb.append("', msg = '");
        sb.append(msg);
        sb.append("'");
        if (!Strings.isNullOrEmpty(hiddenMsg)) {
            sb.append("\n");
            sb.append(hiddenMsg);
        }
        if (C_LogLevelKbn.INFO.eq(level)) {
            logger.info(sb.toString());
        } else if (C_LogLevelKbn.WARN.eq(level)) {
            logger.warn(sb.toString());
        } else if (C_LogLevelKbn.ERROR.eq(level)) {
            logger.error(sb.toString());
        }

        final AT_BatchLog batchLog = new AT_BatchLog();
        batchLog.setBatchJobId(batchJob.getBatchJobId());
        batchLog.setBatchLogEdaNo(Integer.valueOf(batchLogEdaNo));
        batchLog.setLogOutputTime(BizDate.getSysDateTimeMilli());
        batchLog.setLogLevelKbn(level);
        String logNaiyou = null;
        if (msg.length() > 1000) {
            logNaiyou = msg.substring(0, 997) + "...";
        } else {
            logNaiyou = msg;
        }
        batchLog.setLogNaiyou(logNaiyou);

        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    entityManager.persist(batchLog);
                }
            }
            );
    }
}
