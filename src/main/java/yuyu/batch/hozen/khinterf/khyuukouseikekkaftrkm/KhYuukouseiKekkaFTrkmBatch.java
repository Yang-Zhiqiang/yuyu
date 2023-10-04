package yuyu.batch.hozen.khinterf.khyuukouseikekkaftrkm;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.batch.hozen.khinterf.khyuukouseikekkaftrkm.dba.KhYuukouseiKekkaFTrkmDao;
import yuyu.batch.hozen.khinterf.khyuukouseikekkaftrkm.dba.YuukouKakKekkaDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 有効性確認結果Ｆ取込クラス
 */
public class KhYuukouseiKekkaFTrkmBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "ZT_YuukouKakKekkaFTr";

    private static final String RECOVERYFILTERIDKBNID = "Kh003";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhYuukouseiKekkaFTrkmDao khYuukouseiKekkaFTrkmDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long sinSyoriKensuu = 0;
        long kiSyoriKensuu = 0;
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouID = khozenCommonParam.getFunctionId();
        String sousasyaCd  = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        khYuukouseiKekkaFTrkmDao.deleteYuukouKakKekkaShinkyk();
        khYuukouseiKekkaFTrkmDao.deleteYuukouKakKekkaKikyk();

        try (
            ExDBResults<YuukouKakKekkaDataBean> yuukouKakKekkaDataBeanList =
            khYuukouseiKekkaFTrkmDao.getYuukouKakKekkaDataBeans(kakutyoujobCd);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            ) {

            for (YuukouKakKekkaDataBean yuukouKakKekkaDataBean : yuukouKakKekkaDataBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(yuukouKakKekkaDataBean.getZtrcreditkessaiyouno());

                String creditCardNo = "";
                BizDateYM yuukoukakym = null;
                C_Yuukoukakkekka yuukoukakkekka = null;

                creditCardNo = StringUtil.rTrim(yuukouKakKekkaDataBean.getZtrcardno());

                setCreditUriageSeikyuubi.exec(syoriYMD);
                yuukoukakym = setCreditUriageSeikyuubi.getJikaiUrskbi().getBizDateYM();

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(yuukouKakKekkaDataBean.getZtryuukouhanteikekka(),
                    C_Yuukoukakkekka.class, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);
                yuukoukakkekka = C_Yuukoukakkekka.valueOf(kbnInfoBean.getKbnData());

                IT_YuukouKakKekkaSk yuukouKakKekkaSk = null;

                if (C_CreditCardKeySyuruiKbn.MOSNO.getValue().equals(
                    yuukouKakKekkaDataBean.getZtrcreditkessaiyouno().substring(1,2))) {

                    yuukouKakKekkaSk = new IT_YuukouKakKekkaSk(yuukouKakKekkaDataBean.getZtrcreditkessaiyouno());

                    yuukouKakKekkaSk.setCreditcardno(creditCardNo);
                    yuukouKakKekkaSk.setCardyuukoukigen4keta(yuukouKakKekkaDataBean.getZtrcardyuukoukigen());
                    yuukouKakKekkaSk.setCredityuukoukakym(yuukoukakym);
                    yuukouKakKekkaSk.setCredityuukoukakkekka(yuukoukakkekka);
                    yuukouKakKekkaSk.setCreditkigyoucd(yuukouKakKekkaDataBean.getZtrcreditkigyoucd());
                    yuukouKakKekkaSk.setGyoumuKousinKinou(kinouID);
                    yuukouKakKekkaSk.setGyoumuKousinsyaId(sousasyaCd);
                    yuukouKakKekkaSk.setGyoumuKousinTime(sysTime);

                    BizPropertyInitializer.initialize(yuukouKakKekkaSk);

                    sinSyoriKensuu = sinSyoriKensuu + 1;
                }

                IT_YuukouKakKekkaKikyk yuukouKakKekkaKikyk =
                    new IT_YuukouKakKekkaKikyk(yuukouKakKekkaDataBean.getZtrcreditkessaiyouno());

                yuukouKakKekkaKikyk.setCreditcardno(creditCardNo);
                yuukouKakKekkaKikyk.setCardyuukoukigen4keta(yuukouKakKekkaDataBean.getZtrcardyuukoukigen());
                yuukouKakKekkaKikyk.setCredityuukoukakym(yuukoukakym);
                yuukouKakKekkaKikyk.setCredityuukoukakkekka(yuukoukakkekka);
                yuukouKakKekkaKikyk.setCreditkigyoucd(yuukouKakKekkaDataBean.getZtrcreditkigyoucd());
                yuukouKakKekkaKikyk.setGyoumuKousinKinou(kinouID);
                yuukouKakKekkaKikyk.setGyoumuKousinsyaId(sousasyaCd);
                yuukouKakKekkaKikyk.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(yuukouKakKekkaKikyk);

                if (yuukouKakKekkaSk != null) {

                    multipleEntityInserter.add(yuukouKakKekkaSk);
                }

                multipleEntityInserter.add(yuukouKakKekkaKikyk);

                kiSyoriKensuu = kiSyoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(sinSyoriKensuu), "新契約分"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kiSyoriKensuu), "既契約分"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
