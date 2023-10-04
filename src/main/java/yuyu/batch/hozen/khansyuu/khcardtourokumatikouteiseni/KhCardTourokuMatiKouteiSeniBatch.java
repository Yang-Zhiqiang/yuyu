package yuyu.batch.hozen.khansyuu.khcardtourokumatikouteiseni;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khcardtourokumatikouteiseni.dba.CardTourokuMatiBean;
import yuyu.batch.hozen.khansyuu.khcardtourokumatikouteiseni.dba.KhCardTourokuMatiKouteiSeniDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.koutei.KhIwfApiRuleBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.IT_CardTourokuMati;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 カード情報登録待ち契約工程遷移処理
 */
public class KhCardTourokuMatiKouteiSeniBatch implements Batch{

    private static final String TYSYTTAISYOUTABLEID = IT_CardTourokuMati.TABLE_NAME;

    private static final String RECOVERYFILTERIDKBNID = "Bz003";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhCardTourokuMatiKouteiSeniDao khCardTourokuMatiKouteiSeniDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private WorkflowDomManager workflowDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long syoriKensuu = 0;
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouID = khozenCommonParam.getFunctionId();
        String sousasyaCd  = khozenCommonParam.getUserID();
        String kosTime = BizDate.getSysDateTimeMilli();
        List<String> kouteiKanriIdLsit = new ArrayList<String>();
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYMD)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobCd));

        try (
            ExDBResults<CardTourokuMatiBean> cardTourokuMatiBeanList =
            khCardTourokuMatiKouteiSeniDao.getCardTourokuMatiBeans(kakutyoujobCd);
            EntityUpdater<IT_CardTourokuMati> entityUpdater = new EntityUpdater<>()) {

            for (CardTourokuMatiBean cardTourokuMatiBean : cardTourokuMatiBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(cardTourokuMatiBean.getKouteikanriid());

                Long hrhnCreditCardTourokuCount = khCardTourokuMatiKouteiSeniDao.getHrhnCreditCardTourokuCount(
                    cardTourokuMatiBean.getCreditKessaiyouNo());

                if (hrhnCreditCardTourokuCount > 0) {
                    syoriKensuu ++;

                    kouteiKanriIdLsit.add(cardTourokuMatiBean.getKouteikanriid());

                    List<DM_JimutetuzukiTask> jimutetuzukiTaskList =
                        workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(
                            IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU,
                            IKhozenCommonConstants.NODEID_CARDTOUROKUMATI);

                    KhIwfApiRuleBean khIwfApiRuleBean = new KhIwfApiRuleBean();
                    khIwfApiRuleBean.setSyoriKekkaKbnNaiyou(C_SyorikekkaKbn.KANRYOU.getContent());

                    BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean =
                        SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);
                    bzProcessForwardForBatchInBean.setKouteiKanriId(cardTourokuMatiBean.getKouteikanriid());
                    bzProcessForwardForBatchInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
                    bzProcessForwardForBatchInBean.setTaskNm(jimutetuzukiTaskList.get(0).getWorkflowTskNm());
                    bzProcessForwardForBatchInBean.setIwfApiRuleBean(khIwfApiRuleBean);

                    bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (syoriKensuu > 0) {
                BzProcessForwardForBatch bzProcessForwardForBatch = SWAKInjector.getInstance(BzProcessForwardForBatch.class);
                bzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanLst);

                for (String kouteiKanriId : kouteiKanriIdLsit) {
                    IT_CardTourokuMati cardTourokuMati = hozenDomManager.getCardTourokuMati(kouteiKanriId);

                    cardTourokuMati.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                    cardTourokuMati.setGyoumuKousinKinou(kinouID);
                    cardTourokuMati.setGyoumuKousinsyaId(sousasyaCd);
                    cardTourokuMati.setGyoumuKousinTime(kosTime);

                    BizPropertyInitializer.initialize(cardTourokuMati);

                    entityUpdater.add(cardTourokuMati);
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
