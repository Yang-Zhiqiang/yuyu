package yuyu.batch.hozen.khansyuu.khcreditmisyuuinfosel;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.batch.hozen.khansyuu.khcreditmisyuuinfosel.dba.CreditMisyuuInfoBean;
import yuyu.batch.hozen.khansyuu.khcreditmisyuuinfosel.dba.KhCreditMisyuuInfoSelDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.EditCreditMinyuuTuutiParam;
import yuyu.common.hozen.ascommon.EditMinyuuTuuti;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 クレカ未収契約情報抽出
 */
public class KhCreditMisyuuInfoSelBatch implements Batch {

    private static final String TABLEID = IT_KykKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhCreditMisyuuInfoSelDao khCreditMisyuuInfoSelDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        Integer syoriKensuu = 0;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        try (ExDBResults<CreditMisyuuInfoBean> creditMisyuuInfoBeanList =
            khCreditMisyuuInfoSelDao.getCreditMisyuuInfoBean(kakutyoujobCd, syoriYmd.getBizDateYM());

            EntityInserter<IT_KouzahuriMinyuTuuti> entityInserter = new EntityInserter<IT_KouzahuriMinyuTuuti>();) {

            AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector
                .getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);

            ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(100);

            for (CreditMisyuuInfoBean creditMisyuuInfoBean : creditMisyuuInfoBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(creditMisyuuInfoBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(creditMisyuuInfoBean.getSyono());

                syoriKensuu++;

                SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector
                    .getInstance(SetCreditUriageSeikyuubi.class);
                setCreditUriageSeikyuubi.exec(syoriYmd);
                BizDate tykgoJikaiUrskbi = setCreditUriageSeikyuubi.getJikaiUrskbi();
                BizDate tykzenJikaiUrskbi = setCreditUriageSeikyuubi.getZenkaiUrskbi();
                BizDateYM ryousyuuYm = tykzenJikaiUrskbi.getBizDateYM();

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(creditMisyuuInfoBean.getSyono());

                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

                setYuuyokknmanryobi.exec(creditMisyuuInfoBean.getSyono(), ansyuKihon.getJkipjytym());

                BizDate tksnYuuyokknMnryBi = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();

                if (BizDateUtil.compareYmd(tykgoJikaiUrskbi, tksnYuuyokknMnryBi) == BizDateUtil.COMPARE_GREATER) {
                    ansyuKihon.detach();
                    continue;
                }

                List<IT_KouzahuriMinyuTuuti> kouzahuriMinyuTuutiList = khCreditMisyuuInfoSelDao.getKouzahuriMinyuTuutis(
                    creditMisyuuInfoBean.getSyono(),
                    ansyuKihon.getJkipjytym(),
                    BizDate.valueOf(syoriYmd.getPreviousMonth().getBizDateYM(), 27),
                    BizDate.valueOf(syoriYmd.getPreviousMonth().getBizDateYM(), 15));

                if (kouzahuriMinyuTuutiList.size() > 0) {
                    ansyuKihon.detach();
                    continue;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(creditMisyuuInfoBean.getSyono());

                IT_CreditCardInfo creditCardInfo = kykKihon.getCreditCardInfo();
                if (!C_Yuukoukakkekka.YUUKOUKAK_OK.eq(creditCardInfo.getCredityuukoukakkekka())  &&
                    !C_Yuukoukakkekka.YUUKOUKAK_NG.eq(creditCardInfo.getCredityuukoukakkekka())) {
                    ansyuKihon.detach();
                    kykKihon.detach();
                    continue;
                }

                if (!C_DattairiyuuKbn.HRHENKIBOU.eq(creditMisyuuInfoBean.getDattairiyuukbn()) &&
                    !C_DattairiyuuKbn.KAIYAKUKIBOU.eq(creditMisyuuInfoBean.getDattairiyuukbn()) &&
                    !C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(creditMisyuuInfoBean.getDattairiyuukbn()) &&
                    !C_DattairiyuuKbn.OTHER.eq(creditMisyuuInfoBean.getDattairiyuukbn())) {
                    ansyuKihon.detach();
                    kykKihon.detach();
                    continue;
                }

                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(creditMisyuuInfoBean.getSyono());

                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    checkYuukouJyoutai.detachAllEntities(creditMisyuuInfoBean.getSyono());
                    continue;
                }

                C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
                String tuutisyuruicd = "";

                IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

                if (khTtdkTyuui != null && C_KktyuitaKbn.DNGNMEMOARI.eq(khTtdkTyuui.getKktyuitakbn())) {
                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                    tuutisyuruicd = "Z01";
                }
                if (StringUtil.isNullOrBlank(tuutisyuruicd)) {

                    IT_Tokusin tokusin = ansyuKihon.getTokusin();

                    if (tokusin != null && C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn()) &&
                        (BizDateUtil.compareYmd(tokusin.getTokusinendymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER ||
                        (BizDateUtil.compareYmd(tokusin.getTokusinendymd(), syoriYmd) == BizDateUtil.COMPARE_EQUAL))) {
                        hassouKbn = C_HassouKbn.HONSYAKAISOU;
                        tuutisyuruicd = "A01";
                    }
                }

                if (StringUtil.isNullOrBlank(tuutisyuruicd)) {
                    List<IT_Kariukekin> kariukekinList =  khCreditMisyuuInfoSelDao.getKariukekins(creditMisyuuInfoBean.getSyono());

                    if (kariukekinList.size() > 0) {
                        hassouKbn = C_HassouKbn.HONSYAKAISOU;
                        tuutisyuruicd = "A02";
                    }
                }

                C_CreditUriageNgJiyuuKbn credituriagengjiyuu = C_CreditUriageNgJiyuuKbn.BLNK;
                List<IT_AnsyuRireki> ansyuRirekiList = khCreditMisyuuInfoSelDao.getAnsyuRirekis(creditMisyuuInfoBean.getSyono());

                if (ansyuRirekiList.size() > 0) {
                    credituriagengjiyuu = ansyuRirekiList.get(0).getCredituriagengjiyuu();
                }

                int minyuTukisuu = 0;
                BizDateYM syoriYm = syoriYmd.getBizDateYM();
                BizDateYM syuharaimanYm = ansyuKihon.getSyuharaimanymd().getBizDateYM();

                if (BizDateUtil.compareYm(syuharaimanYm, syoriYm) == BizDateUtil.COMPARE_LESSER) {
                    minyuTukisuu = BizDateUtil.calcDifferenceMonths(syuharaimanYm, ansyuKihon.getJkipjytym());
                }
                else {
                    minyuTukisuu = BizDateUtil.calcDifferenceMonths(syoriYm, ansyuKihon.getJkipjytym());
                }

                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                C_ErrorKbn resultKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.CREDIT, C_NyknaiyouKbn.KEIZOKUP,
                    tykgoJikaiUrskbi, ansyuKihon.getJkipjytym(), 0, minyuTukisuu);

                if (C_ErrorKbn.ERROR.eq(resultKbn)) {

                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    kykKihon.detach();
                    ansyuKihon.detach();

                    continue;
                }

                KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();

                BizCurrency minyuGk = keisanRsgkOutBean.getRsgakuGoukei();

                EditCreditMinyuuTuutiParam creditMinyuuTuutiParam = SWAKInjector.getInstance(EditCreditMinyuuTuutiParam.class);

                creditMinyuuTuutiParam.setDattaiUktkUmu(C_UmuKbn.ARI);
                creditMinyuuTuutiParam.setDattaiRiyuuKbn(creditMisyuuInfoBean.getDattairiyuukbn());
                creditMinyuuTuutiParam.setJkiPJytYm(ansyuKihon.getJkipjytym());
                creditMinyuuTuutiParam.setRyousyuuYm(ryousyuuYm);
                creditMinyuuTuutiParam.setYykknMnryYmd(tksnYuuyokknMnryBi);
                creditMinyuuTuutiParam.setJikaiUrskbi(tykgoJikaiUrskbi);
                creditMinyuuTuutiParam.setDattaikeiro(creditMisyuuInfoBean.getDattaikeiro());
                creditMinyuuTuutiParam.setYuukoukakkekka(creditCardInfo.getCredityuukoukakkekka());
                creditMinyuuTuutiParam.setCreditUriageNgJiyuuKbn(credituriagengjiyuu);
                creditMinyuuTuutiParam.setAnnaiGetusuu(minyuTukisuu);
                creditMinyuuTuutiParam.setAnnaiKingaku(minyuGk);

                EditMinyuuTuuti editMinyuuTuuti = SWAKInjector.getInstance(EditMinyuuTuuti.class);

                IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam,
                    kykKihon,
                    creditMinyuuTuutiParam,
                    syoriYmd,
                    hassouKbn,
                    tuutisyuruicd);

                entityInserter.add(kouzahuriMinyuTuuti);

                checkYuukouJyoutai.detachAllEntities(creditMisyuuInfoBean.getSyono());
            }
            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

                ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYmd);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, syoriKensuu.toString()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
