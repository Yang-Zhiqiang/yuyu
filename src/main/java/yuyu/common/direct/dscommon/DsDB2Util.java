package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.util.ExceptionUtil;

import org.hibernate.exception.GenericJDBCException;
import org.slf4j.Logger;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳＤＢ２ユーティリティ
 */
public class DsDB2Util {

    private static final String DB2_SQL_BACKOFFICE_EXCEPTION = "com.ibm.db2.jcc.am.SqlException";

    private static final String DB2_SQL_NETSERVICE_EXCEPTION = "com.ibm.websphere.ce.cm.ObjectClosedException";

    private static final String REASON_CODE_DEADLOCK = "00C90088";

    private static final String REASON_CODE_BACKOFFICE_QUERY_TIMEOUT = "00C9008E";

    private static final String REASON_CODE_NETSEVICE_QUERY_TIMEOUT = "DSRA9110E";

    private static final String EXCEPTION_CLASS_NAME = "ObjectClosedException";

    public enum E_Result {
        QUERY_TIMEOUT,

        DEADLOCK,

        OTHER
    }

    @Inject
    private static Logger logger;

    public E_Result exec(Throwable pThrowable) {

        logger.debug("▽ ＤＳＤＢ２ユーティリティ 開始");

        boolean genericJdbcException = false;

        genericJdbcException =ExceptionUtil.contains(pThrowable, GenericJDBCException.class);

        boolean objectClosedException = false;

        objectClosedException =siteiReigaiGanyuuHantei(pThrowable, EXCEPTION_CLASS_NAME);


        if (genericJdbcException == true || objectClosedException == true) {
            for (Throwable t : ExceptionUtil.getCauses(pThrowable)) {
                if (DB2_SQL_BACKOFFICE_EXCEPTION.equals(t.getClass().getName())) {
                    if (t.getMessage().contains(REASON_CODE_DEADLOCK)) {
                        logger.debug("△ ＤＳＤＢ２ユーティリティ 終了");

                        return E_Result.DEADLOCK;
                    }
                    else if (t.getMessage().contains(REASON_CODE_BACKOFFICE_QUERY_TIMEOUT)) {
                        logger.debug("△ ＤＳＤＢ２ユーティリティ 終了");

                        return E_Result.QUERY_TIMEOUT;
                    }
                }
                else if (DB2_SQL_NETSERVICE_EXCEPTION.equals(t.getClass().getName())) {
                    if (t.getMessage().contains(REASON_CODE_NETSEVICE_QUERY_TIMEOUT)) {
                        logger.debug("△ ＤＳＤＢ２ユーティリティ 終了");

                        return E_Result.QUERY_TIMEOUT;
                    }
                }
            }
        }

        logger.debug("△ ＤＳＤＢ２ユーティリティ 終了");

        return E_Result.OTHER;
    }

    private boolean siteiReigaiGanyuuHantei(Throwable pError, String pExceptionClassName) {
    	
        if(pError == null) {
        	
            return false;
        }if(pError.getClass().getSimpleName().equals(pExceptionClassName)){
        	
            return true;
        }
        return siteiReigaiGanyuuHantei(pError.getCause(), pExceptionClassName);
    }
}
