package yuyu.batch.sinkeiyaku.sknyuukin.skhrkmnkkrkdi1kidengkhanei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 入金 振込入金仮受金第１回伝票金額反映
 */
public class SkHrkmNkKrkDi1kiDengkHaneiBatch implements Batch {

    private static final String TASKNM = "振込入金仮受金第１回伝票金額反映";

    private static final String TYSYTTAISYOUTABLEID = "HT_GaikaHrkmNyknData";

    private static final String RECOVERYFILTERID = "Sk002";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        String userId = bzBatchParam.getUserId();
        String sysTime = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataLst =
            sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk(kakutyouJobCd)) {

            for (HT_GaikaHrkmNyknData gaikaHrkmNyknData : gaikaHrkmNyknDataLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gaikaHrkmNyknData.getDensyskbn().toString());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(gaikaHrkmNyknData.getSyoriYmd().toString());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3(gaikaHrkmNyknData.getItirenno());

                C_ErrorKbn errorKbn = getKawaseRate.exec(gaikaHrkmNyknData.getKsnymd(), C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    gaikaHrkmNyknData.getTuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String errMessage = MessageUtil.getMessage(MessageId.ESA1004,
                        gaikaHrkmNyknData.getKsnymd().toString(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                        gaikaHrkmNyknData.getTuukasyu().getValue(),
                        C_Tuukasyu.JPY.getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.JISSEIRATE.getValue(),
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue()
                        );

                    batchLogger.error(errMessage);

                    throw new BizAppException(MessageId.EHA1045);

                }

                BizNumber kawaseRate = getKawaseRate.getKawaserate();

                keisanGaikakanzan.exec(C_Tuukasyu.JPY, gaikaHrkmNyknData.getTrhkkgk(), kawaseRate, C_HasuusyoriKbn.SUTE);
                BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

                gaikaHrkmNyknData.setDengk(kanzanGaku);
                gaikaHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
                gaikaHrkmNyknData.setGyoumuKousinsyaId(userId);
                gaikaHrkmNyknData.setGyoumuKousinTime(sysTime);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), TASKNM));
    }

    @AppBatchExceptionTerminate
    private void abendexec() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}