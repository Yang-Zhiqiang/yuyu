package yuyu.batch.hozen.khansyuu.khauthorikekkabunritrsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.batch.hozen.khansyuu.khauthorikekkabunritrsks.dba.BunrimaeAuthoriKekkaBean;
import yuyu.batch.hozen.khansyuu.khauthorikekkabunritrsks.dba.KhAuthoriKekkaBunriTrSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditCardBrand;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.entity.IT_SkCreditCardTourokuKekka;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 オーソリ結果分離およびＴＲ作成
 */
public class KhAuthoriKekkaBunriTrSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_BunrimaeAuthoriKekka";

    private static final String RECOVERYFILTERIDKBNID = "Kh004";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhAuthoriKekkaBunriTrSksDao khAuthoriKekkaBunriTrSksDao;

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
        long sinSyoriKensuu = 0;
        long kiSyoriKensuu = 0;
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouID = khozenCommonParam.getFunctionId();
        String sousasyaCd  = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        SetCreditCardBrand setCreditCardBrand = SWAKInjector.getInstance(SetCreditCardBrand.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        khAuthoriKekkaBunriTrSksDao.deleteSkCreditCardTourokuKekka();

        try (
            ExDBResults<BunrimaeAuthoriKekkaBean> bunrimaeAuthoriKekkaBeanList =
            khAuthoriKekkaBunriTrSksDao.getBunrimaeAuthoriKekka(kakutyoujobCd);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            ) {

            for (BunrimaeAuthoriKekkaBean bunrimaeAuthoriKekkaBean : bunrimaeAuthoriKekkaBeanList) {

                String keySyuruiKbn = bunrimaeAuthoriKekkaBean.getCreditkessaiyouno().substring(1,2);
                String cardNo = bunrimaeAuthoriKekkaBean.getCreditcardno();

                IT_SkCreditCardTourokuKekka skCreditCardTourokuKekka = null;
                IT_KhTRAuthoriKekkaHihoji khTRAuthoriKekkaHihoji = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bunrimaeAuthoriKekkaBean.getCreditkessaiyouno());

                cardNo = StringUtil.rTrim(cardNo);

                if (C_CreditCardKeySyuruiKbn.MOSNO.getValue().equals(keySyuruiKbn)) {

                    skCreditCardTourokuKekka = new IT_SkCreditCardTourokuKekka(
                        bunrimaeAuthoriKekkaBean.getCreditkessaiyouno(), bunrimaeAuthoriKekkaBean.getDatajyusinymd());

                    skCreditCardTourokuKekka.setSyoriYmd(syoriYMD);
                    skCreditCardTourokuKekka.setKaiintourokukbn(bunrimaeAuthoriKekkaBean.getKaiintourokukbn());
                    skCreditCardTourokuKekka.setCreditcardno(cardNo);
                    skCreditCardTourokuKekka.setCardyuukoukigen4keta(bunrimaeAuthoriKekkaBean.getCardyuukoukigen4keta());
                    skCreditCardTourokuKekka.setAuthorigk7keta(bunrimaeAuthoriKekkaBean.getAuthorigk7keta());
                    skCreditCardTourokuKekka.setAuthorikekkaerrorcd(bunrimaeAuthoriKekkaBean.getAuthorikekkaerrorcd());
                    skCreditCardTourokuKekka.setBluegateerrorcd(bunrimaeAuthoriKekkaBean.getBluegateerrorcd());
                    skCreditCardTourokuKekka.setHisimukekaisyacd(bunrimaeAuthoriKekkaBean.getHisimukekaisyacd());
                    skCreditCardTourokuKekka.setWentryuserid(bunrimaeAuthoriKekkaBean.getWentryuserid());
                    skCreditCardTourokuKekka.setErrorcomment(bunrimaeAuthoriKekkaBean.getErrorcomment());
                    skCreditCardTourokuKekka.setNiniinfo(bunrimaeAuthoriKekkaBean.getNiniinfo());
                    skCreditCardTourokuKekka.setDatasyorijyoukyou(bunrimaeAuthoriKekkaBean.getDatasyorijyoukyou());
                    skCreditCardTourokuKekka.setGyoumuKousinKinou(kinouID);
                    skCreditCardTourokuKekka.setGyoumuKousinsyaId(sousasyaCd);
                    skCreditCardTourokuKekka.setGyoumuKousinTime(sysTime);

                    BizPropertyInitializer.initialize(skCreditCardTourokuKekka);

                    syoriKensuu = syoriKensuu + 1;
                    sinSyoriKensuu = sinSyoriKensuu + 1;
                }

                if (C_CreditCardKeySyuruiKbn.SYONO.getValue().equals(keySyuruiKbn) &&
                    "3".equals(bunrimaeAuthoriKekkaBean.getDatasyorijyoukyou())) {

                    String syono = bunrimaeAuthoriKekkaBean.getCreditkessaiyouno().substring(2, 13);

                    C_CardBrandKbn cardBrandKbn = setCreditCardBrand.exec(cardNo.substring(0, 6));

                    String cardNo4keta = cardNo.substring(cardNo.length() - 4);

                    khTRAuthoriKekkaHihoji = new IT_KhTRAuthoriKekkaHihoji(
                        bunrimaeAuthoriKekkaBean.getCreditkessaiyouno(), syoriYMD);

                    khTRAuthoriKekkaHihoji.setSyono(syono);
                    khTRAuthoriKekkaHihoji.setCardbrandkbn(cardBrandKbn);
                    khTRAuthoriKekkaHihoji.setCreditkaiinnosimo4keta(cardNo4keta);
                    khTRAuthoriKekkaHihoji.setAuthorijkkbn(C_AuthorijkKbn.OK);
                    khTRAuthoriKekkaHihoji.setDatajyusinymd(bunrimaeAuthoriKekkaBean.getDatajyusinymd());
                    khTRAuthoriKekkaHihoji.setGyoumuKousinKinou(kinouID);
                    khTRAuthoriKekkaHihoji.setGyoumuKousinsyaId(sousasyaCd);
                    khTRAuthoriKekkaHihoji.setGyoumuKousinTime(sysTime);

                    BizPropertyInitializer.initialize(khTRAuthoriKekkaHihoji);

                    syoriKensuu = syoriKensuu + 1;
                    kiSyoriKensuu = kiSyoriKensuu + 1;
                }

                if (skCreditCardTourokuKekka != null) {

                    multipleEntityInserter.add(skCreditCardTourokuKekka);
                }

                if (khTRAuthoriKekkaHihoji != null) {

                    multipleEntityInserter.add(khTRAuthoriKekkaHihoji);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(sinSyoriKensuu), "新契約"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kiSyoriKensuu), "既契約"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
