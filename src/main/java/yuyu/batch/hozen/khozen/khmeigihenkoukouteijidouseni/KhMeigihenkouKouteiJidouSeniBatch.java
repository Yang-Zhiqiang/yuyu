package yuyu.batch.hozen.khozen.khmeigihenkoukouteijidouseni;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khmeigihenkoukouteijidouseni.dba.KhMeigihenkouKouteiJidouSeniDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 名義変更工程自動遷移
 */
public class KhMeigihenkouKouteiJidouSeniBatch implements Batch {

    private final String TYSYTTAISYOUTABLEID = "IW_KhMeigiHenkouWk";

    private final String RECOVERYFILTERID = "Bz003";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMeigihenkouKouteiJidouSeniDao khMeigihenkouKouteiJidouSeniDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        try (ExDBResults<IW_KhMeigiHenkouWk> khMeigiHenkouWkLst = khMeigihenkouKouteiJidouSeniDao.
            getKhMeigiHenkouWkByKakutyoujobcdMeigihnkjiyuu(kakutyouJobCd, C_Meigihnkjiyuu.KYKSB)) {

            List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = new ArrayList<>();

            long KhSyoriKanoubiHanteiCount = 0;

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            for (IW_KhMeigiHenkouWk khMeigiHenkouWk : khMeigiHenkouWkLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khMeigiHenkouWk.getKouteikanriid());

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance
                    (BzGetProcessSummaryInBean.class);

                bzGetProcessSummaryInBean.setKouteiKanriId(khMeigiHenkouWk.getKouteikanriid());

                bzGetProcessSummaryInBean.setTaskId(IKhozenCommonConstants.NODEID_SYOUNINMATI);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.
                    exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanLst.size() > 0) {

                    if (BizDateUtil.compareYmd(khMeigiHenkouWk.getSyoruiukeymd(), syoriYmd) ==
                        BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(khMeigiHenkouWk.getSyoruiukeymd(), syoriYmd) ==
                        BizDateUtil.COMPARE_EQUAL) {

                        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean = SWAKInjector.getInstance
                            (BzProcessForwardForBatchInBean.class);

                        bzProcessForwardForBatchInBean.setKouteiKanriId(khMeigiHenkouWk.getKouteikanriid());

                        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(IKhozenCommonConstants.
                            JIMUTETUZUKICD_MEIGIHENKOU);

                        bzProcessForwardForBatchInBean.setTaskNm("承認待ち");

                        bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);

                        KhSyoriKanoubiHanteiCount = KhSyoriKanoubiHanteiCount + 1;
                    }
                }
            }

            BzProcessForwardForBatch bzProcessForwardForBatch = SWAKInjector.getInstance
                (BzProcessForwardForBatch.class);

            bzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanLst);

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(KhSyoriKanoubiHanteiCount)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
