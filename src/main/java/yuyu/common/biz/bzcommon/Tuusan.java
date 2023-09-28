package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SkeikikeiyakuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_TkthknsyruitsnKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 共通 通算処理クラス
 */
public class Tuusan {

    private static final int KOKUTITAISYOUKIKAN = 5;

    private static final int TUUSANTAISYOUKIKAN = 2;

    private static final int MSNNENNREI = 15;

    private C_UmuKbn tsnSouSbsUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnNinenMikeikaSouSbsUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnNinenKeikaSouSbsUmu = C_UmuKbn.NONE;

    private C_UmuKbn tuusanKetteiSouSibouSUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnSouKktJituhsgkUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnKktJituhsgk1Umu = C_UmuKbn.NONE;

    private C_UmuKbn tsnKktJituhsgk2Umu = C_UmuKbn.NONE;

    private C_UmuKbn tsnKktItijibrSysntjsUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnNkgnsUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnMsnynenbtSouSbusUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnNenbtSouSbsUmu = C_UmuKbn.NONE;

    private C_UmuKbn tsnNenbtItijibrSouSbsUmu = C_UmuKbn.NONE;

    private C_UmuKbn itijibrPTsnUmu = C_UmuKbn.NONE;

    private C_UmuKbn kykdrtenTsnsUmu = C_UmuKbn.NONE;

    private C_TkthknsyruitsnKbn tktHknsyruiTsnKbn = C_TkthknsyruitsnKbn.BLNK;

    private BizCurrency tsnSouSbs = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnNinenMikeikaSouSbs = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnNinenKeikaSouSbs = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tuusanKetteiSouSouSibouS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnSouKktJituhsgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnKktJituhsgk1 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnKktJituhsgk2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnKktItijibrSysntjs = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnNkgns = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnMsnynenbtSouSbus = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnNenbtItijibrSouSbs = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnItijibrSysnP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency kykdrtenTsns = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency tsnSntktuukaHijynSysnS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    @Inject
    private static Logger logger;

    public Tuusan() {
        super();
    }

    public C_UmuKbn getTuusanSouSibouSUmu() {
        return tsnSouSbsUmu;
    }

    public C_UmuKbn getTuusan2NenMikeikaSouSibouSUmu() {
        return tsnNinenMikeikaSouSbsUmu;
    }

    public C_UmuKbn getTuusan2NenKeikaSouSibouSUmu() {
        return tsnNinenKeikaSouSbsUmu;
    }

    public C_UmuKbn getTuusanKetteiSouSibouSUmu() {
        return tuusanKetteiSouSibouSUmu;
    }

    public C_UmuKbn getTuusanSouKokurtisyoJituHosyougakuUmu() {
        return tsnSouKktJituhsgkUmu;
    }

    public C_UmuKbn getTuusanKokurtisyoJituHosyougaku1Umu() {
        return tsnKktJituhsgk1Umu;
    }

    public C_UmuKbn getTuusanKokurtisyoJituHosyougaku2Umu() {
        return tsnKktJituhsgk2Umu;
    }

    public C_UmuKbn getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu() {
        return tsnKktItijibrSysntjsUmu;
    }

    public C_UmuKbn getTuusanNenkinGensiUmu() {
        return tsnNkgnsUmu;
    }

    public C_UmuKbn getTuusanMiseinenyouNenreibetuSouSibouSUmu() {
        return tsnMsnynenbtSouSbusUmu;
    }

    public C_UmuKbn getTuusanNenreibetuSouSibouSUmu() {
        return tsnNenbtSouSbsUmu;
    }

    public C_UmuKbn getTuusanNenreibetuItijibaraiSouSibouSUmu() {
        return tsnNenbtItijibrSouSbsUmu;
    }

    public C_UmuKbn getItijibrpTsnUmu() {
        return itijibrPTsnUmu;
    }

    public C_UmuKbn getKeiyakusyaDouituDairitenTuusanSUmu() {
        return kykdrtenTsnsUmu;
    }

    public C_TkthknsyruitsnKbn getTktHknsyruiTsnKbn() {
        return tktHknsyruiTsnKbn;
    }

    public BizCurrency getTuusanSouSibouS() {
        return tsnSouSbs;
    }

    public BizCurrency getTuusan2NenMikeikaSouSibouS() {
        return tsnNinenMikeikaSouSbs;
    }

    public BizCurrency getTuusan2NenKeikaSouSibouS() {
        return tsnNinenKeikaSouSbs;
    }

    public BizCurrency getTuusanKetteiSouSouSibouS() {
        return tuusanKetteiSouSouSibouS;
    }

    public BizCurrency getTuusanSouKokurtisyoJituHosyougaku() {
        return tsnSouKktJituhsgk;
    }

    public BizCurrency getTuusanKokurtisyoJituHosyougaku1() {
        return tsnKktJituhsgk1;
    }

    public BizCurrency getTuusanKokurtisyoJituHosyougaku2() {
        return tsnKktJituhsgk2;
    }

    public BizCurrency getTuusanKokurtisyoItijibaraiSyuusintoujoS() {
        return tsnKktItijibrSysntjs;
    }

    public BizCurrency getTuusanNenkinGensi() {
        return tsnNkgns;
    }

    public BizCurrency getTuusanMiseinenyouNenreibetuSouSibouS() {
        return tsnMsnynenbtSouSbus;
    }

    public BizCurrency getTuusanNenreibetuItijibaraiSouSibouS() {
        return tsnNenbtItijibrSouSbs;
    }

    public BizCurrency getTsnItijibrSysnP() {
        return tsnItijibrSysnP;
    }

    public BizCurrency getKeiyakusyaDouituDairitenTuusanS() {
        return kykdrtenTsns;
    }

    public BizCurrency getTsnSntktuukaHijynSysnS() {
        return tsnSntktuukaHijynSysnS;
    }

    public void exec(List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst,
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam) {

        execTuusan(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);
    }

    private void execTuusan(List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst,
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 通算処理 開始");
        }

        if (pTakeiyakuTuusanInfoParam != null) {
            tsnSouSbs = pTakeiyakuTuusanInfoParam.getTsnSibouS();
            tsnNinenMikeikaSouSbs = pTakeiyakuTuusanInfoParam.getTsnNinenMikeikaS();
            tsnNinenMikeikaSouSbs = tsnNinenMikeikaSouSbs.subtract(pTakeiyakuTuusanInfoParam.getTsnNinenMikeikaHtnknS());
            tsnNinenMikeikaSouSbs = tsnNinenMikeikaSouSbs.add(pTakeiyakuTuusanInfoParam.getTsnNinenKeikaDfp());
            tsnNinenKeikaSouSbs = pTakeiyakuTuusanInfoParam.getTsnNinenKeikaS();
            tuusanKetteiSouSouSibouS = pTakeiyakuTuusanInfoParam.getTsnKetSibouS();
            tsnSouKktJituhsgk = pTakeiyakuTuusanInfoParam.getTsnSouKktJituHsgk();
            tsnKktJituhsgk1 = pTakeiyakuTuusanInfoParam.getTsnKktJituHsgk1();
            tsnKktJituhsgk2 = pTakeiyakuTuusanInfoParam.getTsnKktJituHsgk2();
            tsnKktItijibrSysntjs = pTakeiyakuTuusanInfoParam.getTsnKktItijibrSysnJs();
            tsnNkgns = pTakeiyakuTuusanInfoParam.getTsnNkgns();
            tsnMsnynenbtSouSbus = pTakeiyakuTuusanInfoParam.getTsnMsnyNenbtSousbus();
            tsnNenbtItijibrSouSbs = pTakeiyakuTuusanInfoParam.getTsnNenbtItijibrSsbs();
            tsnItijibrSysnP = pTakeiyakuTuusanInfoParam.getTsnItijibrSysnp();
            kykdrtenTsns = pTakeiyakuTuusanInfoParam.getKykDrtenTsns();
            tsnSntktuukaHijynSysnS = pTakeiyakuTuusanInfoParam.getTsnSntktuukaHijynSysns();
        }

        if (pTuusanKeiyakuInfoParamLst != null) {
            TuusanKeiyakuInfoParam tsnKykInfo = null;
            int nensuu = 0;
            BizDate kijyunYmd = null;
            BizDate kykYmd = null;

            for (TuusanKeiyakuInfoParam tuusanKeiyakuInfo : pTuusanKeiyakuInfoParamLst) {

                tsnKykInfo = tuusanKeiyakuInfo;

                nensuu = 0;

                if (C_SkeikikeiyakuKbn.KIKEIYAKU.eq(tsnKykInfo.getSkeiKikeiyakuKbn())) {

                    if (tsnKykInfo.getKijyunYmd() != null && tsnKykInfo.getKykYmd() != null) {

                        kijyunYmd = tsnKykInfo.getKijyunYmd();
                        kykYmd = tsnKykInfo.getKykYmd();

                        if (BizDateUtil.compareYmd(kykYmd, kijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(kykYmd, kijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                            nensuu = BizDateUtil.calcDifference(kijyunYmd, kykYmd).getYears();
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getStsnUmu())) {

                    tsnSouSbs = tsnSouSbs.add(tsnKykInfo.getKihonS());

                    if (tsnSouSbs.compareTo(BizCurrency.valueOf(0)) > 0) {

                        tsnSouSbsUmu = C_UmuKbn.ARI;
                    }

                    tuusanKetteiSouSouSibouS = tuusanKetteiSouSouSibouS.add(tsnKykInfo.getKihonS());

                    if (tuusanKetteiSouSouSibouS.compareTo(BizCurrency.valueOf(0)) > 0) {

                        tuusanKetteiSouSibouSUmu = C_UmuKbn.ARI;
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getStsnUmu()) && nensuu < TUUSANTAISYOUKIKAN) {

                    tsnNinenMikeikaSouSbs = tsnNinenMikeikaSouSbs.add(tsnKykInfo.getKihonS());

                    if (tsnNinenMikeikaSouSbs.compareTo(BizCurrency.valueOf(0)) > 0) {

                        tsnNinenMikeikaSouSbsUmu = C_UmuKbn.ARI;
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getStsnUmu()) && nensuu >= TUUSANTAISYOUKIKAN) {

                    tsnNinenKeikaSouSbs = tsnNinenKeikaSouSbs.add(tsnKykInfo.getKihonS());

                    if (tsnNinenKeikaSouSbs.compareTo(BizCurrency.valueOf(0)) > 0) {

                        tsnNinenKeikaSouSbsUmu = C_UmuKbn.ARI;
                    }
                }
                if ((C_SntkhouKbn.KKT.eq(tsnKykInfo.getSntkhouKbn()) ||
                    C_SntkhouKbn.SYOKUGYOU.eq(tsnKykInfo.getSntkhouKbn())) &&
                    nensuu < KOKUTITAISYOUKIKAN) {

                    if (C_UmuKbn.ARI.eq(tsnKykInfo.getSouKktJituHsgkTuusanUmu()) &&
                        tsnKykInfo.getJituHsgk().compareTo(BizCurrency.valueOf(0)) > 0) {

                        tsnSouKktJituhsgk = tsnSouKktJituhsgk.add(tsnKykInfo.getJituHsgk());

                        if (tsnSouKktJituhsgk.compareTo(BizCurrency.valueOf(0)) > 0) {

                            tsnSouKktJituhsgkUmu = C_UmuKbn.ARI;
                        }
                    }

                    if (C_UmuKbn.ARI.eq(tsnKykInfo.getKktJituHsgk1TuusanUmu()) &&
                        tsnKykInfo.getJituHsgk().compareTo(BizCurrency.valueOf(0)) > 0) {

                        tsnKktJituhsgk1 = tsnKktJituhsgk1.add(tsnKykInfo.getJituHsgk());

                        if (tsnKktJituhsgk1.compareTo(BizCurrency.valueOf(0)) > 0) {

                            tsnKktJituhsgk1Umu = C_UmuKbn.ARI;
                        }
                    }

                    if (C_UmuKbn.ARI.eq(tsnKykInfo.getKktJituHsgk2TuusanUmu()) &&
                        tsnKykInfo.getJituHsgk().compareTo(BizCurrency.valueOf(0)) > 0) {

                        tsnKktJituhsgk2 = tsnKktJituhsgk2.add(tsnKykInfo.getJituHsgk());

                        if (tsnKktJituhsgk2.compareTo(BizCurrency.valueOf(0)) > 0) {

                            tsnKktJituhsgk2Umu = C_UmuKbn.ARI;
                        }
                    }

                    if (!C_Hrkkaisuu.ITIJI.eq(tsnKykInfo.getHrkKaisuu())) {

                        tsnKktItijibrSysntjs = tsnKktItijibrSysntjs.add(tsnKykInfo.getKihonS());

                        if (tsnKktItijibrSysntjs.compareTo(BizCurrency.valueOf(0)) > 0) {

                            tsnKktItijibrSysntjsUmu = C_UmuKbn.ARI;
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getNkgnsTuusanUmu())) {

                    tsnNkgns = tsnNkgns.add(tsnKykInfo.getNkgnsgk());

                    if (tsnNkgns.compareTo(BizCurrency.valueOf(0)) > 0) {

                        tsnNkgnsUmu = C_UmuKbn.ARI;
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getMsnyNenbtSbusTuusanUmu())) {

                    if (!C_Hrkkaisuu.ITIJI.eq(tsnKykInfo.getHrkKaisuu()) ||
                        !C_UmuKbn.ARI.eq(tsnKykInfo.getSyuusinhknUmu())) {

                        if (tsnKykInfo.getHhknNen() < MSNNENNREI) {

                            tsnMsnynenbtSouSbus = tsnMsnynenbtSouSbus.add(tsnKykInfo.getKihonS());

                            if (tsnMsnynenbtSouSbus.compareTo(BizCurrency.valueOf(0)) > 0) {

                                tsnMsnynenbtSouSbusUmu = C_UmuKbn.ARI;
                            }
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getNenbtSouSbusTuusanUmu()) &&
                    !C_Hrkkaisuu.ITIJI.eq(tsnKykInfo.getHrkKaisuu())) {

                    tsnNenbtSouSbsUmu = C_UmuKbn.ARI;

                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getNenbtSouSbusTuusanUmu()) &&
                    C_Hrkkaisuu.ITIJI.eq(tsnKykInfo.getHrkKaisuu())) {

                    tsnNenbtItijibrSouSbs = tsnNenbtItijibrSouSbs.add(tsnKykInfo.getKihonS());

                    if (tsnNenbtItijibrSouSbs.compareTo(BizCurrency.valueOf(0)) > 0) {
                        tsnNenbtItijibrSouSbsUmu = C_UmuKbn.ARI;
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getItijibrpTsnUmu())) {

                    tsnItijibrSysnP = tsnItijibrSysnP.add(tsnKykInfo.getItijibrp());

                    if (tsnItijibrSysnP.compareTo(BizCurrency.valueOf(0)) > 0) {
                        itijibrPTsnUmu = C_UmuKbn.ARI;
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getKykDrtenTuusanUmuKbn())) {

                    kykdrtenTsns = kykdrtenTsns.add(tsnKykInfo.getTkhKihonS());

                    if (kykdrtenTsns.compareTo(BizCurrency.valueOf(0)) > 0) {

                        kykdrtenTsnsUmu = C_UmuKbn.ARI;
                    }
                }

                if (C_UmuKbn.ARI.eq(tsnKykInfo.getStsnUmu()) &&
                    C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN.eq(tsnKykInfo.getTktHknsyruiTsnKbn())) {

                    tsnSntktuukaHijynSysnS = tsnSntktuukaHijynSysnS.add(tsnKykInfo.getKihonS());

                    if (tsnSntktuukaHijynSysnS.compareTo(BizCurrency.valueOf(0)) > 0) {
                        tktHknsyruiTsnKbn = C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN;
                    }
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 通算処理 終了");
        }
    }
}