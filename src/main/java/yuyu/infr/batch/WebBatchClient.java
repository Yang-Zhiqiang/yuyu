package yuyu.infr.batch;

import java.util.concurrent.Future;

import jp.co.slcs.swak.batch.engine.BatchDef;
import jp.co.slcs.swak.batch.engine.BatchParam;
import jp.co.slcs.swak.batch.exception.BatchException;
import jp.co.slcs.swak.batch.exception.BatchInterruptedException;
import jp.co.slcs.swak.batch.exception.BatchInvocationException;
import jp.co.slcs.swak.batch.exception.BatchWarningException;
import jp.co.slcs.swak.batch.exception.ConnectFailedException;
import jp.co.slcs.swak.batch.exception.MultiplexBatchException;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import yuyu.def.MessageId;
import yuyu.infr.batchclient.YuyuBatchClient;
import yuyu.infr.exception.InvalidFunctionException;


public class WebBatchClient extends YuyuBatchClient {

    @Override
    @Deprecated
    public String execute(String batchKinouId, String batchParams) throws BatchWarningException{
        try {
            return super.execute(batchKinouId, batchParams);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }

    @Override
    public String execute(BatchDef batchDef, BatchParam batchParam) throws BatchWarningException {
        try {
            return super.execute(batchDef, batchParam);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchInvocationException  ) {
                if (t.getCause() instanceof InvalidFunctionException) {
                    throw (InvalidFunctionException) t.getCause();
                }
            }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }

    @Override
    public String execute(BatchDef batchDef) throws BatchWarningException {
        try {
            return super.execute(batchDef);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }

    @Override
    public String executeBackground(BatchDef batchDef, BatchParam batchParam)  throws BatchWarningException {
        try {
            return super.executeBackground(batchDef, batchParam);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }

    @Override
    public <T> T invoke(String batchKinouId, String batchParams) throws BatchWarningException {
        try {
            return super.invoke(batchKinouId, batchParams);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }

    @Override
    public <T> T invoke(BatchDef batchDef, BatchParam batchParam) throws BatchWarningException {
        try {
            return super.invoke(batchDef, batchParam);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }

    @Override
    public <T> T invoke(BatchDef batchDef) throws BatchWarningException {
        try {
            return super.invoke(batchDef);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }

    @Override
    public <T> Future<T> invokeBackground(BatchDef batchDef, BatchParam batchParam)  throws BatchWarningException {
        try {
            return super.invokeBackground(batchDef, batchParam);
        } catch (Throwable t) {
            if (t instanceof BatchWarningException)     { throw (BatchWarningException)t; }
            if (t instanceof BatchInterruptedException) { throw new BizLogicException( MessageId.IAC0005); }
            if (t instanceof ConnectFailedException   ) { throw new BizAppException(t, MessageId.EAF0043); }
            if (t instanceof BatchException           ) {
                if (t instanceof MultiplexBatchException) {
                    throw new BizLogicException(MessageId.EAS0038);
                }
                throw new BizAppException(t, MessageId.EAF0045);
            }
            throw new BizAppException(t, MessageId.EAS0027);
        }
    }


}
