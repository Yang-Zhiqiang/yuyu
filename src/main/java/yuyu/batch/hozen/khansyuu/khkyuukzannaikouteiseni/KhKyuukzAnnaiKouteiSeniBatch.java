package yuyu.batch.hozen.khansyuu.khkyuukzannaikouteiseni;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkyuukzannaikouteiseni.dba.KhKyuukzAnnaiKouteiSeniDao;
import yuyu.batch.hozen.khansyuu.khkyuukzannaikouteiseni.dba.KyuukzAnnaimatiBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.koutei.KhIwfApiRuleBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 旧口座案内契約工程遷移処理
 */
public class KhKyuukzAnnaiKouteiSeniBatch implements Batch {

    private static final String TABLEID = IT_KyuukzAnnaimati.TABLE_NAME;

    private static final String FILTERID = "Bz003";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKyuukzAnnaiKouteiSeniDao khKyuukzAnnaiKouteiSeniDao;

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

        String kakutyouJobcd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        long syoriCnt = 0;

        try (ExDBResults<KyuukzAnnaimatiBean> kyuukzAnnaimatiBeanLst = khKyuukzAnnaiKouteiSeniDao
            .getKyuukzAnnaimatiBeans(kakutyouJobcd);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();){

            List<String> kouteiKanriIdLst = new ArrayList<>();
            List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = new ArrayList<>();

            for (KyuukzAnnaimatiBean bean : kyuukzAnnaimatiBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bean.getKouteikanriid());

                syoriCnt++;

                BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean = SWAKInjector
                    .getInstance(BzProcessForwardForBatchInBean.class);

                kouteiKanriIdLst.add(bean.getKouteikanriid());

                List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager
                    .getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(
                        IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU, IKhozenCommonConstants.NODEID_KYUUKZANNAIMATI);

                KhIwfApiRuleBean khIwfApiRuleBean = new KhIwfApiRuleBean();

                khIwfApiRuleBean.setSyoriKekkaKbnNaiyou(C_SyorikekkaKbn.KANRYOU.getContent());

                bzProcessForwardForBatchInBean.setKouteiKanriId(bean.getKouteikanriid());
                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
                bzProcessForwardForBatchInBean.setTaskNm(jimutetuzukiTaskLst.get(0).getWorkflowTskNm());
                bzProcessForwardForBatchInBean.setIwfApiRuleBean(khIwfApiRuleBean);


                bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (syoriCnt > 0) {

                BzProcessForwardForBatch bzProcessForwardForBatch = SWAKInjector
                    .getInstance(BzProcessForwardForBatch.class);
                KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
                String kinouId = khozenCommonParam.getFunctionId();
                String userId = khozenCommonParam.getUserID();
                String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

                bzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanLst);

                for (String kouteiKanriId : kouteiKanriIdLst) {

                    IT_KyuukzAnnaimati kyuukzAnnaimati = hozenDomManager
                        .getKyuukzAnnaimati(kouteiKanriId);

                    kyuukzAnnaimati.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                    kyuukzAnnaimati.setGyoumuKousinKinou(kinouId);
                    kyuukzAnnaimati.setGyoumuKousinsyaId(userId);
                    kyuukzAnnaimati.setGyoumuKousinTime(sysDateTimeMilli);

                    IW_KhHaraikataHenkouWk khHaraikataHenkouWk = hozenDomManager.getKhHaraikataHenkouWk(kouteiKanriId);

                    khHaraikataHenkouWk.setKyuukouzaannaikbn(C_KyuukouzaAnnaiKbn.BLNK);
                    khHaraikataHenkouWk.setGyoumuKousinKinou(kinouId);
                    khHaraikataHenkouWk.setGyoumuKousinsyaId(userId);
                    khHaraikataHenkouWk.setGyoumuKousinTime(sysDateTimeMilli);

                    multipleEntityUpdater.add(kyuukzAnnaimati);
                    multipleEntityUpdater.add(khHaraikataHenkouWk);
                }
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCnt)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
