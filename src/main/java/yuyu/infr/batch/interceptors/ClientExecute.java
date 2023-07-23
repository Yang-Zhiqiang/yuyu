package yuyu.infr.batch.interceptors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.batch.engine.BatchDef;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BatchDousaModeKbn;
import yuyu.def.classification.C_BatchHeisouKbn;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_LogLevelKbn;
import yuyu.def.classification.C_OrderStatusuKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_BatchHeisouList;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.infr.processor.OnlineKadouCheck;

/**
 * 全てのオンライン起動バッチの処理です<br/>
 */
public class ClientExecute {

    public static final ClientExecute INSTANCE = new ClientExecute();
    private int retryCount = 0;
    private long batchRetryWaitTime = 0;
    int batchRetryCount = 0;

    ClientExecute() {
    }

    public void invoke() throws Throwable {
        batchRetryWaitTime = YuyuBaseConfig.getInstance().getBatchRetryWaitTime();
        batchRetryCount = YuyuBaseConfig.getInstance().getBatchRetryCount();
        onLineBatchCheck();
    }

    private void onLineBatchCheck() throws Throwable {
        BatchDef batchDef = SWAKInjector.getInstance(BatchDef.class);
        BatchJob batchJob = SWAKInjector.getInstance(BatchJob.class);
        BaseDomManager baseDomManager = SWAKInjector
            .getInstance(BaseDomManager.class);
        AM_Batch amBatch = baseDomManager.getBatch(batchDef.getBatchId());
        retryCount = 0;
        if (C_KahiKbn.KA.eq(amBatch.getOnlineHeisouKahiKbn())) {
            batchHeisouKbnCheck(batchDef.getBatchId(), batchJob.getBatchJobId(), amBatch.getBatchHeisouKbn(), null,
                baseDomManager);
        } else {
            final AS_BatchOrder batchOrder = new AS_BatchOrder();
            batchOrder.setBatchJobId(batchJob.getBatchJobId());
            batchOrder.setKinouId(batchDef.getBatchId());
            batchOrder.setOrderStatus(C_OrderStatusuKbn.APPOINTMENT);
            batchOrder.setOrderTime(BizDate.getSysDateTimeMilli());
            ExDBTransactional.run(
                new TransactionalCode() {
                    @Override
                    public void accept(ExDBEntityManager entityManager) {
                        entityManager.persist(batchOrder);
                    }
                }
                );
            OnlineKadouCheck onlineKadouCheck = SWAKInjector.getInstance(OnlineKadouCheck.class);
            if (YuyuBaseConfig.getInstance().getBatchDousaModeKbn().eq(C_BatchDousaModeKbn.ALL)) {
                if (onlineKadouCheck.isOnlineKadouOnBatch()) {
                    Thread.sleep(batchRetryWaitTime);
                }
            }
            try {
                batchHeisouKbnCheck(batchDef.getBatchId(), batchJob.getBatchJobId(),
                    amBatch.getBatchHeisouKbn(), batchOrder,
                    baseDomManager);
            } catch (Throwable e) {
                throw e;
            }
        }
    }

    public void batchHeisouKbnCheck(String kinouId,
        String jobId, C_BatchHeisouKbn batchHeisouKbn, AS_BatchOrder batchOrder,
        BaseDomManager baseDomManager) throws Throwable {
        if (C_BatchHeisouKbn.None.eq(batchHeisouKbn)) {
            if (null != batchOrder) {
                batchExecutePrev(batchOrder, kinouId, jobId);
            }
        } else {
            listCheck(kinouId, jobId, batchHeisouKbn,
                batchOrder);
        }
    }

    public void listCheck(String kinouId, String jobId, C_BatchHeisouKbn batchHeisouKbn,
        AS_BatchOrder batchOrder) throws Throwable {
        BaseDomManager baseDomManager = SWAKInjector
            .getInstance(BaseDomManager.class);
        List<AS_BatchHeisouList> asBatchHeisouListList = baseDomManager
            .getBatchHeisouListBySelfKinouId(kinouId);
        Map<String, Boolean> asBatchHeisouListMap = new HashMap<String, Boolean>();
        for (AS_BatchHeisouList asBatchHeisou : asBatchHeisouListList) {
            asBatchHeisouListMap.put(
                String.valueOf(asBatchHeisou.getTargetKinouId()), true);
        }
        List<AS_BatchOrder> orderList = baseDomManager
            .getBatchOrderList();
        List<AS_BatchOrder> asBatchOrderList = new ArrayList<AS_BatchOrder>();
        for (AS_BatchOrder order : orderList) {
            if (C_OrderStatusuKbn.EXECUTE.equals(order.getOrderStatus())) {
                asBatchOrderList.add(order);
            }
        }
        if (asBatchHeisouListList.size() == 0) {
            if (C_BatchHeisouKbn.BL.eq(batchHeisouKbn)) {
                batchExecutePrev(batchOrder, kinouId, jobId);
            }
            if (C_BatchHeisouKbn.WL.eq(batchHeisouKbn)) {
                if (asBatchOrderList.size() > 0) {
                    retryCountCheck(kinouId, jobId, batchHeisouKbn, batchOrder, asBatchOrderList,
                        asBatchHeisouListMap);
                } else {
                    batchExecutePrev(batchOrder, kinouId, jobId);
                }
            }
        } else {
            boolean resultBoolBl = false;
            boolean resultBoolWl = false;
            if (C_BatchHeisouKbn.BL.eq(batchHeisouKbn)) {
                resultBoolBl = true;
                for (AS_BatchOrder obj : asBatchOrderList) {
                    if (null != asBatchHeisouListMap.get(obj.getKinouId())) {
                        resultBoolBl = false;
                        break;
                    }
                }
            }
            if (C_BatchHeisouKbn.WL.eq(batchHeisouKbn)) {
                resultBoolWl = true;
                for (AS_BatchOrder obj : asBatchOrderList) {
                    if (null == asBatchHeisouListMap.get(obj.getKinouId())) {
                        resultBoolWl = false;
                        break;
                    }
                }
            }
            if (resultBoolBl || resultBoolWl) {
                batchExecutePrev(batchOrder, kinouId, jobId);
            } else {
                retryCountCheck(kinouId, jobId, batchHeisouKbn, batchOrder, asBatchOrderList,
                    asBatchHeisouListMap);
            }
        }
    }

    private void retryCountCheck(String kinouId, final String jobId, C_BatchHeisouKbn batchHeisouKbn,
        AS_BatchOrder batchOrder, List<AS_BatchOrder> asBatchOrderList,
        Map<String, Boolean> asBatchHeisouListMap)
            throws Throwable {
        Boolean resultBoolBl = false;
        Boolean resultBoolWl = false;
        if (C_BatchHeisouKbn.BL.eq(batchHeisouKbn)) {
            for (AS_BatchOrder obj : asBatchOrderList) {
                if (null != asBatchHeisouListMap.get(obj.getKinouId())) {
                    resultBoolBl = true;
                    break;
                }
            }
        }
        if (C_BatchHeisouKbn.WL.eq(batchHeisouKbn)) {
            for (AS_BatchOrder obj : asBatchOrderList) {
                if (null == asBatchHeisouListMap.get(obj.getKinouId())) {
                    resultBoolWl = true;
                    break;
                }
            }
        }
        if (resultBoolBl || resultBoolWl) {
            retryCount++;
            if (batchRetryCount < retryCount) {
                BaseDomManager baseDomManager = SWAKInjector
                    .getInstance(BaseDomManager.class);
                final String logMessage = MessageUtil
                    .getMessage(MessageId.EAS0038);
                AT_BatchJob atBatchJob = baseDomManager
                    .getBatchJob(jobId);
                atBatchJob
                .setBatchJyoutaiKbn(C_BatchJyoutaiKbn.SYUURYOU);
                atBatchJob
                .setBatchResultKbn(C_BatchResultKbn.ERROR);
                baseDomManager.update(atBatchJob);
                ExDBTransactional.run(
                    new TransactionalCode() {
                        @Override
                        public void accept(ExDBEntityManager entityManager) {
                            AT_BatchLog batchLog = new AT_BatchLog();
                            batchLog.setBatchJobId(jobId);
                            batchLog.setBatchLogEdaNo(0);
                            batchLog.setLogOutputTime(BizDate
                                .getSysDateTimeMilli());
                            batchLog.setLogLevelKbn(C_LogLevelKbn.ERROR);
                            batchLog.setLogNaiyou(logMessage);
                            entityManager.persist(batchLog);
                        }
                    }
                    );
                throw new Exception(logMessage);
            }
            Thread.sleep(batchRetryWaitTime);
            listCheck(kinouId, jobId, batchHeisouKbn,
                batchOrder);
        }

    }

    private void batchExecutePrev(final AS_BatchOrder batchOrder, final String kinouId,
        final String jobId) throws Throwable {
        if (null == batchOrder) {
            ExDBTransactional.run(
                new TransactionalCode() {
                    @Override
                    public void accept(ExDBEntityManager entityManager) {
                        AS_BatchOrder batchOrderObj = new AS_BatchOrder();
                        batchOrderObj.setBatchJobId(jobId);
                        batchOrderObj.setKinouId(kinouId);
                        batchOrderObj.setOrderStatus(C_OrderStatusuKbn.EXECUTE);
                        batchOrderObj.setOrderTime(BizDate.getSysDateTimeMilli());
                        entityManager.persist(batchOrderObj);
                    }
                }
                );
        } else {
            ExDBTransactional.run(
                new TransactionalCode() {
                    @Override
                    public void accept(ExDBEntityManager entityManager) {
                        entityManager.findByPK(batchOrder).setOrderStatus(C_OrderStatusuKbn.EXECUTE);
                    }
                }
                );
        }
    }
}
