package yuyu.batch.sinkeiyaku.sknyuukin.skcreditkaiinqrkekkahaneipre;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skcreditkaiinqrkekkahaneipre.dba.SkCreditKaiinQRKekkaHaneiPreDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoUtil;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 入金 クレジットカード会員ＱＲ登録結果反映前処理
 */
public class SkCreditKaiinQRKekkaHaneiPreBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "ZT_SkCreditTourokukekkaQrTr";

    private static final String RECOVERYFILTERIDKBNID = "Bz111";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkCreditKaiinQRKekkaHaneiPreDao skCreditKaiinQRKekkaHaneiPreDao;

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
        long syoriKensuu = 0;
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouID = khozenCommonParam.getFunctionId();
        String sousasyaCd  = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        CreditKessaiyouNoUtil creditKessaiyouNoUtil = SWAKInjector.getInstance(CreditKessaiyouNoUtil.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        try (
            ExDBResults<ZT_SkCreditTourokukekkaQrTr> skCreditTourokukekkaQrTrList =
            skCreditKaiinQRKekkaHaneiPreDao.getSkCreditTourokukekkaQrTrs(kakutyoujobCd);

            EntityInserter<HT_SkCreditCardQrTrkMihanei> skCreditCardQrTrkMihaneiInserter =
                new EntityInserter<HT_SkCreditCardQrTrkMihanei>();
            ) {

            for (ZT_SkCreditTourokukekkaQrTr skCreditTourokukekkaQrTr : skCreditTourokukekkaQrTrList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skCreditTourokukekkaQrTr.getZtrcreditkessaiyouno());

                String nykmosno = creditKessaiyouNoUtil.getMosNo(skCreditTourokukekkaQrTr.getZtrcreditkessaiyouno());

                HT_SkCreditCardQrTrkMihanei skCreditCardQrTrkMihanei = new HT_SkCreditCardQrTrkMihanei(
                    syoriYMD,
                    BizDate.valueOf(skCreditTourokukekkaQrTr.getZtrsystemjyusinymd()),
                    skCreditTourokukekkaQrTr.getZtrsystemjyusintime(),
                    skCreditTourokukekkaQrTr.getZtrcreditkessaiyouno()
                    );

                skCreditCardQrTrkMihanei.setCreditqrtrkkbn(skCreditTourokukekkaQrTr.getZtrcreditqrtrkkbn());
                skCreditCardQrTrkMihanei.setCreditqrsousinkbn(skCreditTourokukekkaQrTr.getZtrcreditqrsousinkbn());
                skCreditCardQrTrkMihanei.setNykmosno(nykmosno);
                skCreditCardQrTrkMihanei.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                skCreditCardQrTrkMihanei.setCreditauthorigk(BizCurrency.valueOf(
                    Long.valueOf(StringUtil.lrTrim(skCreditTourokukekkaQrTr.getZtrauthorigkjyusin()))));
                skCreditCardQrTrkMihanei.setTyuumonno(skCreditTourokukekkaQrTr.getZtrtyuumonno());
                skCreditCardQrTrkMihanei.setBluegateshopid(skCreditTourokukekkaQrTr.getZtrbluegateshopid());
                skCreditCardQrTrkMihanei.setKessaisyoriymd(
                    BizDate.valueOf(skCreditTourokukekkaQrTr.getZtrkessaisyoriymd()));
                skCreditCardQrTrkMihanei.setCreditqrerrorcd(skCreditTourokukekkaQrTr.getZtrcreditqrerrorcd());
                skCreditCardQrTrkMihanei.setSyouninnoseven(skCreditTourokukekkaQrTr.getZtrsyouninno7keta());
                skCreditCardQrTrkMihanei.setBluegateerrorcd(skCreditTourokukekkaQrTr.getZtrbluegateerrorcd());
                skCreditCardQrTrkMihanei.setHisimukekaisyacd(skCreditTourokukekkaQrTr.getZtrhisimukekaisyacd());
                skCreditCardQrTrkMihanei.setBluegatejyusinymdtime(
                    skCreditTourokukekkaQrTr.getZtrbluegatejyusinymdtime());
                skCreditCardQrTrkMihanei.setGyoumuKousinKinou(kinouID);
                skCreditCardQrTrkMihanei.setGyoumuKousinsyaId(sousasyaCd);
                skCreditCardQrTrkMihanei.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(skCreditCardQrTrkMihanei);

                syoriKensuu = syoriKensuu + 1;

                skCreditCardQrTrkMihaneiInserter.add(skCreditCardQrTrkMihanei);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syoriKensuu), "クレジットカード会員ＱＲ登録結果反映前処理"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
