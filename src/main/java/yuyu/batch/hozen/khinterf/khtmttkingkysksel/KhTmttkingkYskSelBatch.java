package yuyu.batch.hozen.khinterf.khtmttkingkysksel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khtmttkingkysksel.dba.KhTmttkingkYskSelBean;
import yuyu.batch.hozen.khinterf.khtmttkingkysksel.dba.KhTmttkingkYskSelDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkKykTmttkn;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.common.hozen.khcommon.KeisanTmHntiSisuuRendouTmttkn;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tmttknsyuruikbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.ZT_TumitateYosokuTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Sets;

/**
 * 契約保全 インターフェース 積立金額予測ファイル抽出
 */
public class KhTmttkingkYskSelBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = "IT_KykKihon";

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private Set<String> kensakuKeySet = Sets.newHashSet();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhTmttkingkYskSelDao khTmttkingkYskSelDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String tysyttaisyouTableId = TYSYTTAISYOU_TABLE_ID;

        String recoveryFilterId = RECOVERY_FILTER_KBNID;

        batchLogger.info(
            MessageUtil.getMessage(
                MessageId.IBA0016,
                MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(
            MessageUtil.getMessage(
                MessageId.IBA0016,
                MessageUtil.getMessage(MessageId.IBW1018),
                bzBatchParam.getIbKakutyoujobcd()));

        String syouhncdSyuukeiKey = null;

        BizDate kykymdSyuukeiKey = null;

        Integer hknkknSyuukeiKey = null;

        String sisuukbnSyuukeiKey = null;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.BLNK;

        C_UmuKbn teikiShrkinUmu = null;

        Long sisuuTmttknysktaisyouKensuu = Long.valueOf(0);

        Long teirituTmttknysktaisyouKensuu = Long.valueOf(0);

        BizCurrency sisuukytmttkngk = BizCurrency.valueOf(0);

        BizCurrency teiritukytmttkngk = BizCurrency.valueOf(0);

        BizCurrency sisuuKisitmttkngk = BizCurrency.valueOf(0);

        BizCurrency teirituKisitmttkngk = BizCurrency.valueOf(0);

        BizCurrency sisuuYsktmttkngk = BizCurrency.valueOf(0);

        BizCurrency teirituYsktmttkngk = BizCurrency.valueOf(0);

        Long tourokuKensuu = Long.valueOf(0);

        BizNumber blcon1 = BizNumber.ZERO;

        BizNumber blcon2 = BizNumber.ZERO;

        BizNumber tmmshanteiymdSisuu = BizNumber.ZERO;

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);

        KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn = SWAKInjector
            .getInstance(KeisanSisuuRendouNkKykTmttkn.class);

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector
            .getInstance(KeisanSisuuRendouNkTmttkn.class);

        KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector
            .getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

        try (ExDBResults<KhTmttkingkYskSelBean> khTmttkingkYskSelBeanLst = khTmttkingkYskSelDao
            .getTmttkingkYsk(bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<ZT_TumitateYosokuTy> tumitateYosokuTyLst = new EntityInserter<>();) {

            List<IM_Syorijtkahi> syorijtkahiLst = hozenDomManager.getSyorijtkahiByKinouidYuukoujyotaikahikbn(
                IKhozenCommonConstants.KINOUID_KHTMTTKINGKYSKSEL, C_YuukoujyotaikahiKbn.HUKA);

            for (IM_Syorijtkahi syoriJtKahi : syorijtkahiLst) {

                String syoriJimuttdkCd = syoriJtKahi.getSyorijimuttdkcd();

                String syoriTaskid = syoriJtKahi.getSyoritaskid();

                String kensakuKey = syoriJimuttdkCd + syoriTaskid;

                kensakuKeySet.add(kensakuKey);
            }

            getSisuu.exec(C_Sisuukbn.BLCON1, bzBatchParam.getSyoriYmd(), C_YouhiKbn.YOU);

            blcon1 = getSisuu.getSisuu();

            getSisuu.exec(C_Sisuukbn.BLCON2, bzBatchParam.getSyoriYmd(), C_YouhiKbn.YOU);

            blcon2 = getSisuu.getSisuu();

            for (KhTmttkingkYskSelBean khTmttkingkYskSelBean : khTmttkingkYskSelBeanLst) {

                tmmshanteiymdSisuu = BizNumber.ZERO;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khTmttkingkYskSelBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khTmttkingkYskSelBean.getSyono());

                C_KahiKbn kahiKbn = syoriJyotaiChk(khTmttkingkYskSelBean.getSyono());

                if (C_KahiKbn.HUKA.eq(kahiKbn)) {

                    continue;
                }

                if (khTmttkingkYskSelBean.getSyouhncd().equals(syouhncdSyuukeiKey)
                    && BizDateUtil.compareYmd(kykymdSyuukeiKey, khTmttkingkYskSelBean.getKykymd()) == BizDateUtil.COMPARE_EQUAL
                    && khTmttkingkYskSelBean.getHknkkn().equals(hknkknSyuukeiKey)
                    && khTmttkingkYskSelBean.getSisuukbn().getValue().equals(sisuukbnSyuukeiKey)) {

                }
                else {
                    tourokuKensuu = tourokuKensuu + addSyuukeiKekkaRecord(syouhncdSyuukeiKey, kykymdSyuukeiKey, hknkknSyuukeiKey, sisuukbnSyuukeiKey,
                        kyktuukasyu, teikiShrkinUmu, sisuuTmttknysktaisyouKensuu, sisuukytmttkngk, sisuuKisitmttkngk, sisuuYsktmttkngk,
                        teirituTmttknysktaisyouKensuu, teiritukytmttkngk, teirituKisitmttkngk, teirituYsktmttkngk, tumitateYosokuTyLst);

                    syouhncdSyuukeiKey = khTmttkingkYskSelBean.getSyouhncd();

                    kykymdSyuukeiKey = khTmttkingkYskSelBean.getKykymd();

                    hknkknSyuukeiKey = khTmttkingkYskSelBean.getHknkkn();

                    sisuukbnSyuukeiKey = khTmttkingkYskSelBean.getSisuukbn().getValue();

                    kyktuukasyu = khTmttkingkYskSelBean.getKyktuukasyu();

                    teikiShrkinUmu = khTmttkingkYskSelBean.getTeikisiharaikinumu();

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(khTmttkingkYskSelBean.getKyktuukasyu());

                    sisuuTmttknysktaisyouKensuu = Long.valueOf(0);
                    teirituTmttknysktaisyouKensuu = Long.valueOf(0);
                    sisuukytmttkngk = BizCurrency.valueOf(0, tuukaType);
                    teiritukytmttkngk = BizCurrency.valueOf(0, tuukaType);
                    sisuuKisitmttkngk = BizCurrency.valueOf(0, tuukaType);
                    teirituKisitmttkngk = BizCurrency.valueOf(0, tuukaType);
                    sisuuYsktmttkngk = BizCurrency.valueOf(0, tuukaType);
                    teirituYsktmttkngk = BizCurrency.valueOf(0, tuukaType);
                }

                if (BizDateUtil.compareYmd(
                    bzBatchParam.getSyoriYmd(), khTmttkingkYskSelBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                    keisanSisuuRendouNkKykTmttkn.exec(
                        khTmttkingkYskSelBean.getKyktuukasyu(),
                        khTmttkingkYskSelBean.getHokenryou(),
                        khTmttkingkYskSelBean.getKykjisisuurendourate());

                    BizCurrency sisuurendoutmttkngk = keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk();

                    BizCurrency teiritutmttkngk = keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk();

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())
                        || C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())) {

                        sisuuTmttknysktaisyouKensuu++;
                        sisuukytmttkngk = sisuukytmttkngk.add(sisuurendoutmttkngk);
                        sisuuKisitmttkngk = sisuuKisitmttkngk.add(sisuurendoutmttkngk);
                        sisuuYsktmttkngk = sisuuYsktmttkngk.add(sisuurendoutmttkngk);
                    }

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())
                        || C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())) {

                        teirituTmttknysktaisyouKensuu++;
                        teiritukytmttkngk = teiritukytmttkngk.add(teiritutmttkngk);
                        teirituKisitmttkngk = teirituKisitmttkngk.add(teiritutmttkngk);
                        teirituYsktmttkngk = teirituYsktmttkngk.add(teiritutmttkngk);
                    }
                }
                else {
                    Long khHenkouUktkKensuu = khTmttkingkYskSelDao
                        .getHenkouUktkTmttkinItenCountBySyono(khTmttkingkYskSelBean.getSyono());

                    if (khHenkouUktkKensuu > 0) {

                        keisanSisuuRendouNkKykTmttkn.exec(
                            khTmttkingkYskSelBean.getKyktuukasyu(),
                            khTmttkingkYskSelBean.getHokenryou(),
                            khTmttkingkYskSelBean.getKykjisisuurendourate());

                        teiritukytmttkngk = teiritukytmttkngk.add(keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk());

                        BizDate outouYmd = setOutoubi.exec(
                            C_TykzentykgoKbn.TYKGO,
                            khTmttkingkYskSelBean.getKykymd(),
                            C_Hrkkaisuu.NEN,
                            BizDate.valueOf(khTmttkingkYskSelBean.getTmttkntaisyouym(),
                                khTmttkingkYskSelBean.getKykymd().getDay()).getRekijyou());

                        keisanSisuuRendouNkTmttkn.exec(
                            khTmttkingkYskSelBean.getKykymd(),
                            khTmttkingkYskSelBean.getHknkkn(),
                            teikiShrkinUmu,
                            khTmttkingkYskSelBean.getKyktuukasyu(),
                            outouYmd,
                            outouYmd.getBizDateYM(),
                            khTmttkingkYskSelBean.getTmttkntaisyouym(),
                            khTmttkingkYskSelBean.getTumitateriritu(),
                            khTmttkingkYskSelBean.getTeiritutmttkngk(),
                            khTmttkingkYskSelBean.getSisuurendoutmttkngk());

                        BizCurrency teiritutmttkngk = keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();

                        if (C_Sisuukbn.BLCON1.eq(khTmttkingkYskSelBean.getSisuukbn())) {

                            tmmshanteiymdSisuu = blcon1;

                        }
                        else if (C_Sisuukbn.BLCON2.eq(khTmttkingkYskSelBean.getSisuukbn())) {

                            tmmshanteiymdSisuu = blcon2;
                        }

                        keisanTmHntiSisuuRendouTmttkn.exec(
                            khTmttkingkYskSelBean.getSyouhncd(),
                            khTmttkingkYskSelBean.getKyktuukasyu(),
                            tmmshanteiymdSisuu,
                            khTmttkingkYskSelBean.getTmttknhaneisisuu(),
                            khTmttkingkYskSelBean.getSetteibairitu(),
                            khTmttkingkYskSelBean.getTmttknzoukaritujygn(),
                            khTmttkingkYskSelBean.getSisuurendoutmttkngk(),
                            khTmttkingkYskSelBean.getRendouritu());

                        BizCurrency sisuurendoutmttkngk = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();

                        teirituKisitmttkngk = teirituKisitmttkngk
                            .add(sisuurendoutmttkngk)
                            .add(teiritutmttkngk);

                        teirituYsktmttkngk = teirituYsktmttkngk.add(sisuurendoutmttkngk).add(teiritutmttkngk);

                        teirituTmttknysktaisyouKensuu++;
                    }
                    else {

                        keisanSisuuRendouNkKykTmttkn.exec(
                            khTmttkingkYskSelBean.getKyktuukasyu(),
                            khTmttkingkYskSelBean.getHokenryou(),
                            khTmttkingkYskSelBean.getKykjisisuurendourate());

                        BizCurrency sisuurendoutmttkngk = keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk();

                        BizCurrency teiritutmttkngk = keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk();

                        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())
                            || C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())) {

                            sisuuTmttknysktaisyouKensuu++;
                            sisuukytmttkngk = sisuukytmttkngk.add(sisuurendoutmttkngk);
                            sisuuKisitmttkngk = sisuuKisitmttkngk.add(khTmttkingkYskSelBean.getSisuurendoutmttkngk());

                            if (C_Sisuukbn.BLCON1.eq(khTmttkingkYskSelBean.getSisuukbn())) {

                                tmmshanteiymdSisuu = blcon1;

                            }
                            else if (C_Sisuukbn.BLCON2.eq(khTmttkingkYskSelBean.getSisuukbn())) {

                                tmmshanteiymdSisuu = blcon2;
                            }

                            keisanTmHntiSisuuRendouTmttkn.exec(
                                khTmttkingkYskSelBean.getSyouhncd(),
                                khTmttkingkYskSelBean.getKyktuukasyu(),
                                tmmshanteiymdSisuu,
                                khTmttkingkYskSelBean.getTmttknhaneisisuu(),
                                khTmttkingkYskSelBean.getSetteibairitu(),
                                khTmttkingkYskSelBean.getTmttknzoukaritujygn(),
                                khTmttkingkYskSelBean.getSisuurendoutmttkngk(),
                                khTmttkingkYskSelBean.getRendouritu());

                            sisuuYsktmttkngk = sisuuYsktmttkngk.add(keisanTmHntiSisuuRendouTmttkn
                                .getSisuurendoutmttkngk());

                        }

                        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())
                            || C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(khTmttkingkYskSelBean.getTmttknhaibunjyoutai())) {

                            teirituTmttknysktaisyouKensuu++;
                            teiritukytmttkngk = teiritukytmttkngk.add(teiritutmttkngk);
                            teirituKisitmttkngk = teirituKisitmttkngk.add(khTmttkingkYskSelBean.getTeiritutmttkngk());

                            BizDate nextoutouYmd = setOutoubi.exec(
                                C_TykzentykgoKbn.TYKGO,
                                khTmttkingkYskSelBean.getKykymd(),
                                C_Hrkkaisuu.NEN,
                                BizDate.valueOf(khTmttkingkYskSelBean.getTmttkntaisyouym(),
                                    khTmttkingkYskSelBean.getKykymd().getDay()).getRekijyou());

                            keisanSisuuRendouNkTmttkn.exec(
                                khTmttkingkYskSelBean.getKykymd(),
                                khTmttkingkYskSelBean.getHknkkn(),
                                teikiShrkinUmu,
                                khTmttkingkYskSelBean.getKyktuukasyu(),
                                nextoutouYmd,
                                nextoutouYmd.getBizDateYM(),
                                khTmttkingkYskSelBean.getTmttkntaisyouym(),
                                khTmttkingkYskSelBean.getTumitateriritu(),
                                khTmttkingkYskSelBean.getTeiritutmttkngk(),
                                khTmttkingkYskSelBean.getSisuurendoutmttkngk());

                            teirituYsktmttkngk = teirituYsktmttkngk.add(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk());
                        }
                    }
                }
            }

            tourokuKensuu = tourokuKensuu + addSyuukeiKekkaRecord(syouhncdSyuukeiKey, kykymdSyuukeiKey, hknkknSyuukeiKey, sisuukbnSyuukeiKey,
                kyktuukasyu, teikiShrkinUmu, sisuuTmttknysktaisyouKensuu, sisuukytmttkngk, sisuuKisitmttkngk, sisuuYsktmttkngk,
                teirituTmttknysktaisyouKensuu, teiritukytmttkngk, teirituKisitmttkngk, teirituYsktmttkngk, tumitateYosokuTyLst);

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(tourokuKensuu)));
    }

    private C_KahiKbn syoriJyotaiChk(String pSyono) {

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(pSyono,
            C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        skKihonLst = JT_SkKihonDetacher.detachSibouKariuketsuketouched(skKihonLst);

        if (skKihonLst.size() > 0) {

            return C_KahiKbn.HUKA;
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        BzGetProcessSummaryComparatorWorkListHyoujijun korkListHyoujijun = SWAKInjector.getInstance(
            BzGetProcessSummaryComparatorWorkListHyoujijun.class);

        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(korkListHyoujijun);

        List<BzGetProcessSummaryOutBean> syoritaskLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean syoritask : syoritaskLst) {

            String jimutetuzukiCd = syoritask.getJimuTetuzukiCd();

            String syoritaskId = syoritask.getNowNodoId();

            String kensakuKey = jimutetuzukiCd + syoritaskId;

            if (kensakuKeySet.contains(kensakuKey)) {

                return C_KahiKbn.HUKA;
            }
        }

        return C_KahiKbn.KA;
    }

    private int addSyuukeiKekkaRecord(String pSyouhncdSyuukeiKey, BizDate pKykymdSyuukeiKey, Integer pHknkknSyuukeiKey,
        String pSisuukbnSyuukeiKey, C_Tuukasyu pKyktuukasyu, C_UmuKbn pTeikisiharaikinumu, Long pSisuuTmttknysktaisyouKensuu,
        BizCurrency pSisuukytmttkngk, BizCurrency pSisuuKisitmttkngk, BizCurrency pSisuuYsktmttkngk, Long pTeirituTmttknysktaisyouKensuu,
        BizCurrency pTeiritukytmttkngk, BizCurrency pTeirituKisitmttkngk, BizCurrency pTeirituYsktmttkngk , EntityInserter<ZT_TumitateYosokuTy> pTumitateYosokuTyLst) {

        int tuikaKensuu = 0;
        C_Tmttknsyuruikbn tmttknSyuruiKbn = C_Tmttknsyuruikbn.BLNK;

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhncdSyuukeiKey);

        if (pSisuuTmttknysktaisyouKensuu > 0) {

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                tmttknSyuruiKbn = C_Tmttknsyuruikbn.SISUU_RENDOU_NENKIN;
            }
            else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) {
                tmttknSyuruiKbn = C_Tmttknsyuruikbn.SISUU_RENDOU_NENKIN2;
            }

            ZT_TumitateYosokuTy tumitateYosokuTy = new ZT_TumitateYosokuTy();

            tumitateYosokuTy.setZtyhknsyukigou(pSyouhncdSyuukeiKey);
            tumitateYosokuTy.setZtykeiyakuymd(String.valueOf(pKykymdSyuukeiKey));
            tumitateYosokuTy.setZtytysytymd(String.valueOf(bzBatchParam.getSyoriYmd()));
            tumitateYosokuTy.setZtykyktuukasyu(pKyktuukasyu.getValue());
            tumitateYosokuTy.setZtyhknkkn(String.valueOf(pHknkknSyuukeiKey));
            tumitateYosokuTy.setZtytmttknsyuruikbn(tmttknSyuruiKbn.getValue());
            tumitateYosokuTy.setZtysisuukbn(pSisuukbnSyuukeiKey);
            tumitateYosokuTy.setZtytmttknysktaisyoukensuu(pSisuuTmttknysktaisyouKensuu.intValue());
            tumitateYosokuTy.setZtykyktuukakyktmttkngk(BizNumber.valueOf(
                new BigDecimal(pSisuukytmttkngk.toString())));
            tumitateYosokuTy.setZtykyktuukakisitmttkngk(BizNumber.valueOf(
                new BigDecimal(pSisuuKisitmttkngk.toString())));
            tumitateYosokuTy.setZtykyktuukaysktmttkngk(BizNumber.valueOf(
                new BigDecimal(pSisuuYsktmttkngk.toString())));

            BizPropertyInitializer.initialize(tumitateYosokuTy);

            pTumitateYosokuTyLst.add(tumitateYosokuTy);

            tuikaKensuu = tuikaKensuu + 1;

        }

        if (pTeirituTmttknysktaisyouKensuu > 0) {
            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                tmttknSyuruiKbn = C_Tmttknsyuruikbn.TEIRITU_TMTT_NENKIN;
            }
            else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                if (C_UmuKbn.ARI.equals(pTeikisiharaikinumu)) {
                    tmttknSyuruiKbn = C_Tmttknsyuruikbn.TEIRITU_TMTT_NENKIN2_TKSHR_ARI;
                }
                else {
                    tmttknSyuruiKbn = C_Tmttknsyuruikbn.TEIRITU_TMTT_NENKIN2_TKSHR_NONE;
                }
            }

            ZT_TumitateYosokuTy tumitateYosokuTy = new ZT_TumitateYosokuTy();

            tumitateYosokuTy.setZtyhknsyukigou(pSyouhncdSyuukeiKey);
            tumitateYosokuTy.setZtykeiyakuymd(String.valueOf(pKykymdSyuukeiKey));
            tumitateYosokuTy.setZtytysytymd(String.valueOf(bzBatchParam.getSyoriYmd()));
            tumitateYosokuTy.setZtykyktuukasyu(pKyktuukasyu.getValue());
            tumitateYosokuTy.setZtyhknkkn(String.valueOf(pHknkknSyuukeiKey));
            tumitateYosokuTy.setZtytmttknsyuruikbn(tmttknSyuruiKbn.getValue());
            tumitateYosokuTy.setZtysisuukbn(C_Sisuukbn.BLNK.getValue());
            tumitateYosokuTy.setZtytmttknysktaisyoukensuu(pTeirituTmttknysktaisyouKensuu.intValue());
            tumitateYosokuTy.setZtykyktuukakyktmttkngk(BizNumber.valueOf(
                new BigDecimal(pTeiritukytmttkngk.toString())));
            tumitateYosokuTy.setZtykyktuukakisitmttkngk(BizNumber.valueOf(
                new BigDecimal(pTeirituKisitmttkngk.toString())));
            tumitateYosokuTy.setZtykyktuukaysktmttkngk(BizNumber.valueOf(
                new BigDecimal(pTeirituYsktmttkngk.toString())));

            BizPropertyInitializer.initialize(tumitateYosokuTy);

            pTumitateYosokuTyLst.add(tumitateYosokuTy);

            tuikaKensuu = tuikaKensuu + 1;

        }

        return tuikaKensuu;

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
