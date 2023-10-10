package yuyu.app.base.log.batchjyoukyousyoukai;

import static yuyu.app.base.log.batchjyoukyousyoukai.GenBatchJyoukyouSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiConstants.E_OutputKbn;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiConstants.E_SubsystemYuukouHanteiKbn;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiConstants.E_ViewKbn;
import yuyu.common.base.format.ReportBizDateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.infr.batchclient.YuyuBatchClient;
import yuyu.infr.report.OutputReport;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * バッチ状況照会 のビジネスロジックです。
 */
public class BatchJyoukyouSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BatchJyoukyouSyoukaiUiBean uiBean;

    @Inject
    private MessageManager message;

    @Inject
    private BaseDomManager manager;

    @Inject
    private YuyuBaseConfig baseConfig;

    @Inject
    private YuyuBatchClient yuyuBatchClient;

    @Inject
    private OutputReport outputReport;


    void output() {
        //        FileSearchCondition condition = new FileSearchCondition();
        //        condition.setFileName("test");
        //        condition.setFileSyuruiCd("CSV");
        //        condition.setSakuseiKinouId("batchJyoukyouSyoukai");
        //        condition.setTourokuTimeFrom("201508011600");
        //        condition.setTourokuTimeTo("201508011601");
    }

    void init() {

        clear();
        setSubSystemInfoList();
        chkBatchJobCountExceed(getBatchJobCount());
        setBatchJobList();
    }

    void clear() {
        uiBean.setSubSystemId(null);
        uiBean.setSyoriYmdFrom(BizDate.getSysDate().getPreviousDay());
        uiBean.setSyoriYmdTo(null);
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL,
            C_BatchResultKbn.WARN,
            C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);
        setAutoUpdateUmuFlg_Ari();

        if(baseConfig.isSubSystemEnableFlg()){
            uiBean.setSubsystemYuukouHanteiFlg(E_SubsystemYuukouHanteiKbn.YUUKOU);
        } else {
            uiBean.setSubsystemYuukouHanteiFlg(E_SubsystemYuukouHanteiKbn.MUKOU);
        }
        uiBean.setOutputFlg(E_OutputKbn.NOOUTPUT);
    }

    void setAutoUpdateUmuFlg_Ari() {
        uiBean.setJidouKousinUmuFlg(C_UmuKbn.ARI);
    }

    void setAutoUpdateUmuFlg_None() {
        uiBean.setJidouKousinUmuFlg(C_UmuKbn.NONE);
    }

    void searchBatchJob() {

        chkSyoriYmdContext();
        chkBatchJobResultOrJyoutaiSelected();
        getAndChkBatchJobCountZeroOrExceed();
        clearBatchJobList();
        setBatchJobList();
    }

    void setBatchDetailInfo() {

        message.removeConversationMessageId(MessageId.WAC0010, uiBean.getBatchJobCount(), uiBean.getMaxShutokuKensu());
        setSelectedBatchJobId();
        if (!isExistenceSelectedBatchJob()) {
            throw new BizLogicException(MessageId.EAF0034, MessageUtil.getMessage(MessageId.IAW0056));
        }
        setBatchLogInfo4Header();
        setBatchLogList();
        setTyuudanBtnDispFlg();

    }

    void renewalBatchJob() {

        clearBatchJobList();
        getAndChkBatchJobCountZeroOrExceed();
        setBatchJobList();
    }


    void commandIntterupt() {

        if (!isExistenceSelectedBatchJob()) {
            throw new BizLogicException(MessageId.EAF0034, MessageUtil.getMessage(MessageId.IAW0056));
        }

        if (!isBatchJobEnd()) {
            commandIntterupt2BatchServer();
        }

        setBatchLogInfo4Header();
        setBatchLogList();
        setBatchJobList();

        if (isBatchJobEnd()) {
            throw new BizLogicException(MessageId.EAF0041);
        }
    }

    void execPrePrint() {

        setSelectedBatchJobId();
        List<AT_BatchLogReport> batchLogReportList = manager.getBatchLogReportByBatchJobId(uiBean.getBatchJobId());
        if (batchLogReportList.size() == 0) {
            throw new BizLogicException(MessageId.EAF0034, MessageUtil.getMessage(MessageId.IAW0056));
        }

        if (manager.getTyouhyouHozon(batchLogReportList.get(0).getReportKey()) == null ) {
            throw new BizLogicException(MessageId.EAF0040);
        }

        uiBean.setOutputFlg(E_OutputKbn.OUTPUT);
    }

    void print() {

        uiBean.setOutputFlg(E_OutputKbn.NOOUTPUT);
        List<AT_BatchLogReport> batchLogReportList = manager.getBatchLogReportByBatchJobId(uiBean.getBatchJobId());
        Set<String> reportKeySet = Sets.newHashSet();
        int reportCount = 0;
        for (AT_BatchLogReport at_BatchLogReport : batchLogReportList) {
            reportKeySet.add(at_BatchLogReport.getReportKey());
            reportCount++;
        }

        outputReport.outputPDFByKeys(reportKeySet.toArray(new String[reportCount]));
    }

    void chkBatchJobCountExExceed() {

        if (!StringUtils.isEmpty(uiBean.getBatchJobCount())) {
            int pCount = Integer.parseInt(uiBean.getBatchJobCount());
            chkBatchJobCountExceed(pCount);
        }
    }

    void clearEntity(){
        uiBean.setBatchJob(new AT_BatchJob());
    }


    private void clearBatchJobList() {
        uiBean.setBatchJobList(null);
    }

    private void setSelectedBatchJobId() {
        uiBean.setBatchJobId(uiBean.getBatchJobListDataSource().getSelectedBean().getBatchJobId());
    }

    private void setTyuudanBtnDispFlg() {

        uiBean.setViewControlFlg(E_ViewKbn.INVISIBLE);
        AT_BatchJob selectedBatchJob = manager.getBatchJob(uiBean.getBatchJobId());
        if (C_KahiKbn.KA.eq(selectedBatchJob.getBatch().getTyuudanKahi())) {
            if (!C_BatchJyoutaiKbn.SYUURYOU.eq(selectedBatchJob.getBatchJyoutaiKbn())) {
                uiBean.setViewControlFlg(E_ViewKbn.VISIBLE);
            }
        }
    }

    private void setBatchJobList() {

        List<BatchJobListDataSourceBean> batchJob4Disp = new ArrayList<BatchJobListDataSourceBean>();

        C_BatchJyoutaiKbn[] batchJyoutais = makeBatchJyoutaiKbnArray();

        if(uiBean.getBatchJyoutai() && uiBean.getBatchResultKbn() != null){
            getAndsetBatchJobList(batchJob4Disp,batchJyoutais,null);
            getAndsetBatchJobList(batchJob4Disp,new C_BatchJyoutaiKbn[]{C_BatchJyoutaiKbn.SYUURYOU },uiBean.getBatchResultKbn());
        }
        else{
            getAndsetBatchJobList(batchJob4Disp,batchJyoutais,uiBean.getBatchResultKbn());
        }

        for(int i = batchJob4Disp.size()-1 ; i >= YuyuBaseConfig.getInstance().getMaxShutokuKensu() ; i--){
            batchJob4Disp.remove(i);
        }

        uiBean.setBatchJobList(batchJob4Disp);
    }

    private void getAndsetBatchJobList(List<BatchJobListDataSourceBean> pBatchJobListDataSourceBean,
        C_BatchJyoutaiKbn[] pBatchJyoutai,
        C_BatchResultKbn[] pBatchResultKbn) {
        List<AT_BatchJob> selectedBatchJob =
            manager.getBatchJobListByIdbatchStartTimebatchEndTimeJyoutaiKbnResultKbn(makeBatchIdArray(),
                uiBean.getSyoriYmdFrom(),
                uiBean.getSyoriYmdTo(),
                pBatchJyoutai,
                pBatchResultKbn);

        for (AT_BatchJob at_BatchJob : selectedBatchJob) {
            BatchJobListDataSourceBean batchJobListDataSource = new BatchJobListDataSourceBean();

            AM_Batch batch = at_BatchJob.getBatch();
            AS_Kinou kinou = batch.getKinou();
            AS_Category category = kinou.getCategory();
            AS_SubSystem subSystem = kinou.getSubSystem();

            batchJobListDataSource.setBatchJobId(at_BatchJob.getBatchJobId());
            batchJobListDataSource.setSubSystemNm(subSystem.getSubSystemNm());
            batchJobListDataSource.setCategoryNm(category.getCategoryNm());
            batchJobListDataSource.setKinouNm(kinou.getKinouNm());
            batchJobListDataSource.setBatchKidouKbn(at_BatchJob.getBatchKidouKbn());
            batchJobListDataSource.setBatchStartTime(editTime4View(at_BatchJob.getBatchStartTime()));
            batchJobListDataSource.setBatchEndTime(editTime4View(at_BatchJob.getBatchEndTime()));
            batchJobListDataSource.setBatchResultKbn(at_BatchJob.getBatchResultKbn());
            batchJobListDataSource.setBatchJyoutaiKbn(at_BatchJob.getBatchJyoutaiKbn());
            batchJobListDataSource.setSyousaiLink(MessageUtil.getMessage(DDID_BATCHJOBLIST_SYOUSAILINK.getErrorResourceKey()));
            List<AT_BatchLogReport> batchLogReportList = at_BatchJob.getBatchLogReports();
            if (batchLogReportList.size() > 0) {
                batchJobListDataSource.setTyouhyouSyuturyokuLink(MessageUtil.getMessage(DDID_BATCHJOBLIST_TYOUHYOUSYUTURYOKULINK.getErrorResourceKey()));
            }
            pBatchJobListDataSourceBean.add(batchJobListDataSource);

        }

    }

    private void setBatchLogInfo4Header() {

        AT_BatchJob selectedBatchJob = manager.getBatchJob(uiBean.getBatchJobId());

        selectedBatchJob.setBatchStartTime(editTime4View(selectedBatchJob.getBatchStartTime()));
        selectedBatchJob.setBatchEndTime(editTime4View(selectedBatchJob.getBatchEndTime()));

        AM_Batch batch = selectedBatchJob.getBatch();
        AS_Kinou kinou = batch.getKinou();
        AS_Category category = kinou.getCategory();
        AS_SubSystem subSystem = kinou.getSubSystem();

        selectedBatchJob.detach();

        uiBean.setBatchJob(selectedBatchJob);
        uiBean.setSubSystemNm(subSystem.getSubSystemNm());
        uiBean.setCategoryNm(category.getCategoryNm());
        uiBean.setKinouNm(kinou.getKinouNm());
        AM_User batchSyoriuser = manager.getUser(selectedBatchJob.getKousinsyaId());

        if (batchSyoriuser != null) {
            uiBean.setUserNm(batchSyoriuser.getUserNm());
        }
        else {
            uiBean.setUserNm(null);
        }
    }

    private void setBatchLogList() {

        List<AT_BatchLog> batchLogList = manager.getBatchLogByBatchJobId(uiBean.getBatchJobId());

        if (batchLogList.size() == 0) {
            message.addMessageId(MessageId.IAF0003, MessageUtil.getMessage(MessageId.IAW0055));
        }

        List<BatchLogListDataSourceBean> dispBatchLog = Lists.newArrayList();
        for (AT_BatchLog at_BatchLog : batchLogList) {

            String formatLogOutputTime = editTime4View(at_BatchLog.getLogOutputTime());

            BatchLogListDataSourceBean batchLog = new BatchLogListDataSourceBean();
            batchLog.setLogOutputTime(formatLogOutputTime);
            batchLog.setLogLevelKbn(at_BatchLog.getLogLevelKbn());
            batchLog.setLogNaiyou(at_BatchLog.getLogNaiyou());
            dispBatchLog.add(batchLog);

        }
        uiBean.setBatchLogList(dispBatchLog);
    }

    private void commandIntterupt2BatchServer() {
        yuyuBatchClient.interrupt(uiBean.getBatchJobId());
        message.addMessageId(MessageId.IAF0004);
    }

    private String[] makeBatchIdArray() {

        List<AM_Batch> batchList = manager.getBatchBySubSystem(uiBean.getSubSystemId());

        Set<String> batchIdSet = Sets.newHashSet();
        int batchCount = 0;
        for (AM_Batch am_Batch : batchList) {
            batchIdSet.add(am_Batch.getKinouId());
            batchCount++;
        }
        return batchIdSet.toArray(new String[batchCount]);
    }

    private C_BatchJyoutaiKbn[] makeBatchJyoutaiKbnArray() {
        C_BatchJyoutaiKbn[] batchJyoutais = null;

        if (uiBean.getBatchJyoutai()) {
            batchJyoutais = new C_BatchJyoutaiKbn[]{
                C_BatchJyoutaiKbn.TAIKI,
                C_BatchJyoutaiKbn.SYORI,
                C_BatchJyoutaiKbn.SYUURYOU_TYU};
        }else{
            batchJyoutais = new C_BatchJyoutaiKbn[]{C_BatchJyoutaiKbn.SYUURYOU};
        }
        return batchJyoutais;
    }

    private void setSubSystemInfoList() {

        List<AS_SubSystem> allSubSystem = manager.getAllSubSystemsSortNoOrder();
        UserDefsList userDefsList = new UserDefsList();
        userDefsList.add(new LabelValuePair());
        for (AS_SubSystem as_SubSystem : allSubSystem) {

            List<AM_Batch> batchList = manager.getBatchBySubSystem(as_SubSystem.getSubSystemId());
            if (batchList.size() > 0) {
                LabelValuePair labelValuePair = new LabelValuePair(as_SubSystem.getSubSystemNm(),
                    as_SubSystem.getSubSystemId());
                userDefsList.add(labelValuePair);
            }
        }
        uiBean.setSubSystemIdOptionBeanList(userDefsList);
    }

    private long getBatchJobCount() {

        C_BatchJyoutaiKbn[] batchJyoutais = makeBatchJyoutaiKbnArray();
        if(uiBean.getBatchJyoutai() && uiBean.getBatchResultKbn() != null){

            long syorityuuCount = manager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(makeBatchIdArray(),
                uiBean.getSyoriYmdFrom(),
                uiBean.getSyoriYmdTo(),
                batchJyoutais,
                null);

            long syuuryouCount = manager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(makeBatchIdArray(),
                uiBean.getSyoriYmdFrom(),
                uiBean.getSyoriYmdTo(),
                new C_BatchJyoutaiKbn[]{C_BatchJyoutaiKbn.SYUURYOU },
                uiBean.getBatchResultKbn());

            return syorityuuCount + syuuryouCount ;

        }
        return manager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(makeBatchIdArray(),
            uiBean.getSyoriYmdFrom(),
            uiBean.getSyoriYmdTo(),
            batchJyoutais,
            uiBean.getBatchResultKbn());
    }

    private void getAndChkBatchJobCountZeroOrExceed() {

        message.removeConversationMessageId(MessageId.WAC0010, uiBean.getBatchJobCount(), uiBean.getMaxShutokuKensu());

        long batchJobCount = getBatchJobCount();

        chkBatchJobCountZero(batchJobCount);
        chkBatchJobCountExceed(batchJobCount);
    }

    private void chkBatchJobCountZero(long pCount) {

        if (pCount == 0) {
            message.addMessageId(MessageId.IAC0021, MessageUtil.getMessage(MessageId.IAW0056));
            return;
        }
    }

    private void chkBatchJobCountExceed(long pCount) {

        uiBean.setBatchJobCount(String.valueOf(pCount));

        if (pCount > baseConfig.getMaxShutokuKensu()) {

            uiBean.setMaxShutokuKensu(String.valueOf(YuyuBaseConfig.getInstance().getMaxShutokuKensu()));
            message.addConversationMessageId(MessageId.WAC0010, uiBean.getBatchJobCount(), uiBean.getMaxShutokuKensu());

        }
    }

    private void chkSyoriYmdContext() {

        BizDate syoriYmd_From = uiBean.getSyoriYmdFrom();
        BizDate syoriYmd_To   = uiBean.getSyoriYmdTo();
        if (syoriYmd_From != null && syoriYmd_To != null) {
            if (syoriYmd_From.compareTo(syoriYmd_To) > 0) {
                throw new BizLogicException(MessageId.EAC0005, DDID_KEYINFO_SYORIYMDFROM, DDID_KEYINFO_SYORIYMDTO);
            }
        }
    }

    private void chkBatchJobResultOrJyoutaiSelected() {

        if (uiBean.getBatchResultKbn() == null && !uiBean.getBatchJyoutai()) {
            throw new BizLogicException(MessageId.EAF0039);
        }
    }

    private boolean isExistenceSelectedBatchJob() {

        if (manager.getBatchJob(uiBean.getBatchJobId()) == null) {
            return false;
        }
        return true;
    }

    private boolean isBatchJobEnd() {

        AT_BatchJob selectedBatchJob = manager.getBatchJob(uiBean.getBatchJobId());
        if (C_BatchJyoutaiKbn.SYUURYOU.eq(selectedBatchJob.getBatchJyoutaiKbn())) {
            return true;
        }
        return false;
    }

    private String editTime4View(String pTime) {

        if (pTime == null) {
            return null;
        }

        if (pTime.length() != 17) {
            return null;
        }
        String ymd = pTime.substring(0, 8);
        BizDate pBizDate = BizDate.valueOf(ymd);
        ymd = ReportBizDateFormatUtil.toFormatedYmd(pBizDate);

        return ymd + " " + pTime.substring(8, 10) + ":" + pTime.substring(10, 12) + ":" + pTime.substring(12, 14);
    }

}
