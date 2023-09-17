package yuyu.def.base.manager.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.dao.AM_BatchDao;
import yuyu.def.db.dao.AS_BatchHeisouListDao;
import yuyu.def.db.dao.AS_BatchOrderDao;
import yuyu.def.db.dao.AT_AccessLogDao;
import yuyu.def.db.dao.AT_AccessLogSyousaiDao;
import yuyu.def.db.dao.AT_BatchDateDao;
import yuyu.def.db.dao.AT_BatchJobDao;
import yuyu.def.db.dao.AT_BatchLogDao;
import yuyu.def.db.dao.AT_BatchLogReportDao;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_BatchHeisouList;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.db.entity.AT_BatchDate;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.entity.AT_BatchLogReport;

/**
 * ログドメインDomマネージャー
 * ログドメインにおける、DB操作を提供する。
 * 処理対象となるTBL(Entity)は、E-R図を確認すること。
 */
class LogDomManager {

    @Inject
    private AT_AccessLogDao accessLogDao;

    @Inject
    private AT_AccessLogSyousaiDao accessLogSyousaiDao;

    @Inject
    private AM_BatchDao batchDao;

    @Inject
    private AS_BatchOrderDao batchOrderDao;

    @Inject
    private AS_BatchHeisouListDao batchHeisouListDao;

    @Inject
    private AT_BatchJobDao batchJobDao;

    @Inject
    private AT_BatchLogDao batchLogDao;

    @Inject
    private AT_BatchLogReportDao batchLogReportDao;

    @Inject
    private AT_BatchDateDao batchDateDao;

    List<AT_AccessLog> getAllAccessLogs() {
        List<AT_AccessLog> accessLogs = accessLogDao.selectAll();
        Collections.sort(accessLogs, new AccessLogCompByLogId());
        return accessLogs;
    }

    AT_AccessLog getAccessLog(String pLogId) {
        return accessLogDao.getAT_AccessLog(pLogId);
    }

    List<AT_AccessLogSyousai> getAccessLogSyousaisByLogIdEdaNoOrder(String pLogId) {
        return accessLogSyousaiDao.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);
    }

    class AccessLogCompByLogId implements Comparator<AT_AccessLog> {
        @Override
        public int compare(AT_AccessLog accessLog1, AT_AccessLog accessLog2) {
            return accessLog1.getLogId().compareTo(accessLog2.getLogId());
        }
    }

    List<AT_AccessLog> selAccessLogs(
        String  pSubSystemId,
        String  pCategoryId,
        String  pKinouId,
        C_KinouKbn pKinouKbn,
        BizDate pSyoriYmdFrom, String pSyoriTimeFrom,
        BizDate pSyoriYmdTo,   String pSyoriTimeTo,
        String  pUserId,
        String  pIpAddress,
        String  pSessionId,
        C_AccessLogSyubetuKbn pLogKindCd
        ) {

        return accessLogDao.getAccessLogs(
            pSubSystemId,
            pCategoryId,
            pKinouId,
            pKinouKbn,
            pSyoriYmdFrom, pSyoriTimeFrom,
            pSyoriYmdTo,   pSyoriTimeTo,
            pUserId,
            pIpAddress,
            pSessionId,
            pLogKindCd
            );
    }

    long getAccessLogCount(
        String  pSubSystemId,
        String  pCategoryId,
        String  pKinouId,
        C_KinouKbn pKinouKbn,
        BizDate pSyoriYmdFrom, String pSyoriTimeFrom,
        BizDate pSyoriYmdTo,   String pSyoriTimeTo,
        String  pUserId,
        String  pIpAddress,
        String  pSessionId,
        C_AccessLogSyubetuKbn pLogKindCd
        ) {

        return accessLogDao.getAccessLogCount(
            pSubSystemId,
            pCategoryId,
            pKinouId,
            pKinouKbn,
            pSyoriYmdFrom, pSyoriTimeFrom,
            pSyoriYmdTo,   pSyoriTimeTo,
            pUserId,
            pIpAddress,
            pSessionId,
            pLogKindCd
            );
    }

    List<AM_Batch> getBatchBySubSystem(String pSubSystemId) {
        return batchDao.getBatchBySubSystem(pSubSystemId);
    }

    long getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(
        String[] pBatchIds, BizDate pBatchSyoriYmdFrom,
        BizDate pBatchSyoriYmdTo, C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
        C_BatchResultKbn[] pBatchResultKbns) {
        return batchJobDao.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(pBatchIds, pBatchSyoriYmdFrom, pBatchSyoriYmdTo, pBatchJyoutaiKbns, pBatchResultKbns);
    }

    List<AT_BatchJob> getBatchJobListByIdbatchStartTimebatchEndTimeJyoutaiKbnResultKbn(
        String[] pBatchIds, BizDate pBatchSyoriYmdFrom,
        BizDate pBatchSyoriYmdTo, C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
        C_BatchResultKbn[] pBatchResultKbns) {
        return batchJobDao.getBatchJobListByIdbatchStartTimebatchEndTimeJyoutaiKbnResultKbn(pBatchIds, pBatchSyoriYmdFrom, pBatchSyoriYmdTo, pBatchJyoutaiKbns, pBatchResultKbns);
    }

    List<AT_BatchLog> getBatchLogByBatchJobId(String pBatchJobId) {
        return batchLogDao.getBatchLogByBatchJobId(pBatchJobId);
    }

    List<AT_BatchLogReport> getBatchLogReportByBatchJobId(String pBatchJobId) {
        return batchLogReportDao.getBatchLogReportByBatchJobId(pBatchJobId);
    }

    AT_BatchJob getBatchJob(String pBatchJobId) {
        return batchJobDao.getAT_BatchJob(pBatchJobId);
    }

    AM_Batch getBatch(String pKinouId) {
        return batchDao.getAM_Batch(pKinouId);
    }

    List<AS_BatchOrder> getBatchOrderByKinouId(String pKinouId) {
        return batchOrderDao.getBatchOrderByKinouId(pKinouId);
    }

    List<AS_BatchHeisouList> getBatchHeisouListBySelfKinouId(String pSelfKinouId) {
        return batchHeisouListDao.getBatchHeisouListBySelfKinouId(pSelfKinouId);
    }

    List<AS_BatchOrder> getBatchOrderExecuteList(String pBatchJobId){
        return batchOrderDao.getBatchOrderExecuteList(pBatchJobId);
    }

    List<AS_BatchOrder> getBatchOrderList(){
        return batchOrderDao.getBatchOrderList();
    }

    BizDate getBatchDate(){
        return batchDateDao.getBatchDate();
    }

    AT_BatchDate getAT_BatchDate() {
        return batchDateDao.getAT_BatchDate();
    }


    List<AT_BatchDate> getAT_BatchDateAll() {
        return batchDateDao.getAT_BatchDateAll();
    }

    AS_BatchHeisouList getBatchHeisouListBySelfKinouIdTargetKinouId(String pSelfKinouId, String pTargetKinouId){
        return batchHeisouListDao.getBatchHeisouListBySelfKinouIdTargetKinouId(pSelfKinouId, pTargetKinouId);
    }

    AS_BatchOrder getBatchOrderByBatchJobId(String pBatchJobId){
        return batchOrderDao.getBatchOrderByBatchJobId(pBatchJobId);
    }

    AT_BatchDate getBatchDateByDate(BizDate pBatchExecDate){
        return batchDateDao.getAT_BatchDateByDate(pBatchExecDate);
    }
}