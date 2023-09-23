package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 仕訳共通ユーティリティ
 */
public class CommonSiwakeUtil {

    private BizCurrency taisyouGkSyonendoSyokaip;

    private BizCurrency taisyouGkSyonendo2kaimeikoup;

    private BizCurrency taisyouGkJinendoikoup;

    private BizCurrency taisyouGkSonotahenreikin;

    @Inject
    private static Logger logger;

    public CommonSiwakeUtil() {
        super();
    }

    public BizCurrency getTaisyouGkSyonendoSyokaip() {
        return taisyouGkSyonendoSyokaip;
    }

    public BizCurrency getTaisyouGkSyonendo2kaimeikoup() {
        return taisyouGkSyonendo2kaimeikoup;
    }

    public BizCurrency getTaisyouGkJinendoikoup() {
        return taisyouGkJinendoikoup;
    }

    public BizCurrency getTaisyouGkSonotahenreikin() {
        return taisyouGkSonotahenreikin;
    }

    public void execPKanjokamokuHantei(
        BizDate pDenYmd,
        BizDate pKykYmd,
        BizCurrency pZennouSeisankin,
        BizDate pRyosyuYmd,
        BizDateYM pJkipjytYm,
        BizCurrency pMkkp,
        BizDateYM pMikeikapjyutouYm,
        MiKeikaPBean[] pMiKeikaPBeans,
        String pKinouId,
        C_SyoriKbn pSyoriKbn,
        C_Hrkkaisuu pHrkkaisuu,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {

        logger.debug("▽ 保険料勘定科目判定 開始");

        CurrencyType type = pMkkp.getType();
        BizCurrency taisyouGkSyonendo2kaimeikouP = BizCurrency.valueOf(0, type);
        BizCurrency taisyouGkJinendoikouP = BizCurrency.valueOf(0, type);
        BizCurrency taisyouGkSonotaHenreikin = BizCurrency.valueOf(0, type);
        taisyouGkSyonendoSyokaip = BizCurrency.valueOf(0, type);
        taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(0, type);
        taisyouGkJinendoikoup = BizCurrency.valueOf(0, type);
        taisyouGkSonotahenreikin = BizCurrency.valueOf(0, type);
        C_UmuKbn kaiyakuFlg = C_UmuKbn.NONE;

        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pKinouId) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pKinouId) ||
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(pKinouId) ||
            (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(pKinouId) && C_SyoriKbn.KAIJO.eq(pSyoriKbn))) {
            kaiyakuFlg = C_UmuKbn.ARI;
        }

        if (pRyosyuYmd != null) {
            KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);
            String zennouPSeisanKbn = keisanZennouSeisanGk2.getZennouPSeisanKbn(pRyosyuYmd, pDenYmd);
            if (zennouPSeisanKbn.equals(KeisanZennouSeisanGk2.ZENNOUPSEISANKBN_SONOTA)) {
                taisyouGkSonotahenreikin = pZennouSeisankin.add(pMkkp);
            }
            else if (zennouPSeisanKbn.equals(KeisanZennouSeisanGk2.ZENNOUPSEISANKBN_JINENDOP)) {
                if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {
                    taisyouGkJinendoikoup = pZennouSeisankin;
                    taisyouGkSyonendo2kaimeikoup = pMkkp;
                }
                if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {
                    taisyouGkJinendoikoup = pZennouSeisankin;
                    taisyouGkSyonendoSyokaip = pMkkp;
                }
            }
            logger.debug("△ 保険料勘定科目判定 終了");
            return;
        }
        if (pMkkp.compareTo(BizCurrency.valueOf(0, type)) > 0) {
            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            BizDate kessanNensibi = setKessanNensibi.exec(pDenYmd);
            BizDateY tyakkinJigyounendo = kessanNensibi.getBizDateY();
            BizDateYM seisanJigyouYm = BizDateYM.valueOf(tyakkinJigyounendo, 4);
            BizDateYM seisanStartYm = pMiKeikaPBeans[0].getMkeiPJytYm();
            BizDateYM seisanEndYm = pJkipjytYm;
            BizDateYM yokukykYm = pKykYmd.addYears(1).getBizDateYM();
            int jyuutoutuKisuu = Integer.parseInt(pHrkkaisuu.getValue());
            BizDateYM hanteiym = pKykYmd.addMonths(jyuutoutuKisuu).getBizDateYM();

            if (BizDateUtil.compareYm(seisanJigyouYm, seisanEndYm) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYm(seisanJigyouYm, seisanEndYm) == BizDateUtil.COMPARE_EQUAL) {
                taisyouGkSonotahenreikin = pMkkp;
                logger.debug("△ 保険料勘定科目判定 終了");
                return;
            }
            if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu) &&
                (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pTikiktbrisyuruikbn) ||
                    C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pTikiktbrisyuruikbn))) {

                if (BizDateUtil.compareYm(seisanStartYm, seisanJigyouYm) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYm(seisanStartYm, seisanJigyouYm) == BizDateUtil.COMPARE_EQUAL) {

                    for (MiKeikaPBean miKeikaPBean : pMiKeikaPBeans) {
                        if (BizDateUtil.compareYm(miKeikaPBean.getMkeiPJytYm(), yokukykYm) == BizDateUtil.COMPARE_LESSER) {
                            taisyouGkSyonendo2kaimeikouP = taisyouGkSyonendo2kaimeikouP.add(miKeikaPBean.getMiKeikaP());
                        }
                    }
                    taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikouP;
                    taisyouGkJinendoikoup = pMkkp.subtract(taisyouGkSyonendo2kaimeikoup);
                    logger.debug("△ 保険料勘定科目判定 終了");
                    return;
                }

                if (C_UmuKbn.ARI.eq(kaiyakuFlg)) {
                    taisyouGkSonotahenreikin = pMkkp;
                    logger.debug("△ 保険料勘定科目判定 終了");
                    return;
                }

                if (BizDateUtil.compareYm(yokukykYm, seisanJigyouYm) == BizDateUtil.COMPARE_GREATER) {
                    if (BizDateUtil.compareYm(yokukykYm, seisanEndYm) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYm(yokukykYm, seisanEndYm) == BizDateUtil.COMPARE_EQUAL) {
                        for (MiKeikaPBean miKeikaPBean : pMiKeikaPBeans) {
                            BizCurrency irMkkp1kagetu = miKeikaPBean.getMiKeikaP().divide(
                                miKeikaPBean.getMkeiPJytKaisuuM(), 0, RoundingMode.DOWN);
                            BizDateYM mikeikapjyutouYmKeikaksn = miKeikaPBean.getMkeiPJytYm();
                            BizDateYM mikeikapjyutouYm = miKeikaPBean.getMkeiPJytYm().addMonths(Integer.valueOf(miKeikaPBean.getMkeiPJytKaisuuM()) - 1);
                            int kaisuuSonotahenreikin = 0;
                            int kaisuuSyonendo2kaimeikou = 0;
                            BizCurrency mstaisyouGkSonotahenreikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            BizCurrency mstaisyouGkSyonendo2kaimeikouP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            if (BizDateUtil.compareYm(mikeikapjyutouYm, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                mstaisyouGkSonotahenreikin = miKeikaPBean.getMiKeikaP();
                            }
                            else {
                                for (int i = miKeikaPBean.getMkeiPJytKaisuuM(); i > 0 ; i--) {
                                    if (BizDateUtil.compareYm(mikeikapjyutouYmKeikaksn, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                        mikeikapjyutouYmKeikaksn = mikeikapjyutouYmKeikaksn.addMonths(1);
                                        kaisuuSonotahenreikin = kaisuuSonotahenreikin + 1;
                                    }
                                    else {
                                        kaisuuSyonendo2kaimeikou = kaisuuSyonendo2kaimeikou + 1;
                                        break;
                                    }
                                }
                                if (kaisuuSonotahenreikin > 0) {
                                    mstaisyouGkSonotahenreikin = irMkkp1kagetu.multiply(kaisuuSonotahenreikin);
                                }
                                if (kaisuuSyonendo2kaimeikou > 0) {
                                    mstaisyouGkSyonendo2kaimeikouP = miKeikaPBean.getMiKeikaP().subtract(mstaisyouGkSonotahenreikin);
                                }
                            }
                            taisyouGkSonotaHenreikin = taisyouGkSonotaHenreikin.add(mstaisyouGkSonotahenreikin);
                            taisyouGkSyonendo2kaimeikouP = taisyouGkSyonendo2kaimeikouP.add(mstaisyouGkSyonendo2kaimeikouP);
                        }
                        taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikouP;
                        taisyouGkSonotahenreikin = taisyouGkSonotaHenreikin;
                        logger.debug("△ 保険料勘定科目判定 終了");
                        return;
                    }
                    for (MiKeikaPBean miKeikaPBean : pMiKeikaPBeans) {
                        BizCurrency irMkkp1kagetu = miKeikaPBean.getMiKeikaP().divide(
                            miKeikaPBean.getMkeiPJytKaisuuM(), 0, RoundingMode.DOWN);
                        BizDateYM mikeikapjyutouYmKeikaksn = miKeikaPBean.getMkeiPJytYm();
                        BizDateYM mikeikapjyutouYm = miKeikaPBean.getMkeiPJytYm().addMonths(Integer.valueOf(miKeikaPBean.getMkeiPJytKaisuuM()) - 1);
                        int kaisuuSonotahenreikin = 0;
                        int kaisuuSyonendo2kaimeikou = 0;
                        BizCurrency mstaisyouGkSonotahenreikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                        BizCurrency mstaisyouGkSyonendo2kaimeikouP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                        BizCurrency mstaisyouGkJinendoikouP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                        if (BizDateUtil.compareYm(mikeikapjyutouYm, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                            mstaisyouGkSonotahenreikin = miKeikaPBean.getMiKeikaP();
                        }
                        else {
                            for (int i = miKeikaPBean.getMkeiPJytKaisuuM(); i > 0 ; i--) {
                                if (BizDateUtil.compareYm(mikeikapjyutouYmKeikaksn, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                    mikeikapjyutouYmKeikaksn = mikeikapjyutouYmKeikaksn.addMonths(1);
                                    kaisuuSonotahenreikin = kaisuuSonotahenreikin + 1;
                                }
                                else {
                                    if (BizDateUtil.compareYm(mikeikapjyutouYmKeikaksn, yokukykYm) == BizDateUtil.COMPARE_LESSER) {
                                        kaisuuSyonendo2kaimeikou = kaisuuSyonendo2kaimeikou + 1;
                                        break;
                                    }
                                    mstaisyouGkJinendoikouP = miKeikaPBean.getMiKeikaP();
                                    break;
                                }
                            }
                            if (kaisuuSonotahenreikin > 0) {
                                mstaisyouGkSonotahenreikin = irMkkp1kagetu.multiply(kaisuuSonotahenreikin);
                            }
                            if (kaisuuSyonendo2kaimeikou > 0) {
                                mstaisyouGkSyonendo2kaimeikouP = miKeikaPBean.getMiKeikaP().subtract(mstaisyouGkSonotahenreikin);
                            }
                        }
                        taisyouGkSonotaHenreikin = taisyouGkSonotaHenreikin.add(mstaisyouGkSonotahenreikin);
                        taisyouGkSyonendo2kaimeikouP = taisyouGkSyonendo2kaimeikouP.add(mstaisyouGkSyonendo2kaimeikouP);
                        taisyouGkJinendoikouP = taisyouGkJinendoikouP.add(mstaisyouGkJinendoikouP);
                    }
                    taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikouP;
                    taisyouGkJinendoikoup = taisyouGkJinendoikouP;
                    taisyouGkSonotahenreikin = taisyouGkSonotaHenreikin;
                    logger.debug("△ 保険料勘定科目判定 終了");
                    return;
                }

                for (MiKeikaPBean miKeikaPBean : pMiKeikaPBeans) {
                    BizCurrency irMkkp1kagetu = miKeikaPBean.getMiKeikaP().divide(
                        miKeikaPBean.getMkeiPJytKaisuuM(), 0, RoundingMode.DOWN);
                    BizDateYM mikeikapjyutouYmKeikaksn = miKeikaPBean.getMkeiPJytYm();
                    BizDateYM mikeikapjyutouYm = miKeikaPBean.getMkeiPJytYm().addMonths(Integer.valueOf(miKeikaPBean.getMkeiPJytKaisuuM()) - 1);
                    int kaisuuSonotahenreikin = 0;
                    int kaisuuJinendoikou = 0;
                    BizCurrency mstaisyouGkSonotahenreikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency mstaisyouGkJinendoikou = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    if (BizDateUtil.compareYm(mikeikapjyutouYm, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                        mstaisyouGkSonotahenreikin = miKeikaPBean.getMiKeikaP();
                    }
                    else {
                        for (int i = miKeikaPBean.getMkeiPJytKaisuuM(); i > 0 ; i--) {
                            if (BizDateUtil.compareYm(mikeikapjyutouYmKeikaksn, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                mikeikapjyutouYmKeikaksn = mikeikapjyutouYmKeikaksn.addMonths(1);
                                kaisuuSonotahenreikin = kaisuuSonotahenreikin + 1;
                            }
                            else {
                                kaisuuJinendoikou = kaisuuJinendoikou + 1;
                                break;
                            }
                        }
                        if (kaisuuSonotahenreikin > 0) {
                            mstaisyouGkSonotahenreikin = irMkkp1kagetu.multiply(kaisuuSonotahenreikin);
                        }
                        if (kaisuuJinendoikou > 0) {
                            mstaisyouGkJinendoikou = miKeikaPBean.getMiKeikaP().subtract(mstaisyouGkSonotahenreikin);
                        }
                    }
                    taisyouGkSonotaHenreikin = taisyouGkSonotaHenreikin.add(mstaisyouGkSonotahenreikin);
                    taisyouGkJinendoikouP = taisyouGkJinendoikouP.add(mstaisyouGkJinendoikou);
                }
                taisyouGkJinendoikoup = taisyouGkJinendoikouP;
                taisyouGkSonotahenreikin = taisyouGkSonotaHenreikin;

                logger.debug("△ 保険料勘定科目判定 終了");
                return;
            }
            else {
                if (BizDateUtil.compareYm(seisanStartYm, seisanJigyouYm) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYm(seisanStartYm, seisanJigyouYm) == BizDateUtil.COMPARE_EQUAL) {
                    execPKanjokamokuHanteiNasi(pMiKeikaPBeans,seisanJigyouYm,hanteiym,yokukykYm);

                    logger.debug("△ 保険料勘定科目判定 終了");
                    return;
                }
                if (C_UmuKbn.ARI.eq(kaiyakuFlg)) {
                    taisyouGkSonotahenreikin = pMkkp;

                    logger.debug("△ 保険料勘定科目判定 終了");
                    return;
                }
                execPKanjokamokuHanteiNasi(pMiKeikaPBeans,seisanJigyouYm,hanteiym,yokukykYm);

                logger.debug("△ 保険料勘定科目判定 終了");
                return;
            }
        }
    }

    public List<BzSiwakeMeisaiBean> execTaisyakuTyousei(C_Tuukasyu pTuukasyu, List<BzSiwakeMeisaiBean> pBzSiwakeMeisaiBeanLst) {

        logger.debug("▽ 貸借調整処理 開始");

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        HashMap<String, BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanMap = new HashMap<>();
        BizCurrency karigoukeigkDengk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency kasigoukeigkDengk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        String tyouseiMapKey = "";
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : pBzSiwakeMeisaiBeanLst) {
            String mapKey = bzSiwakeMeisaiBean.getIbTaisyakukbn().getValue() + bzSiwakeMeisaiBean.getIbKanjyoukmkcd().getValue();
            if (bzSiwakeMeisaiBeanMap.containsKey(mapKey)) {
                bzSiwakeMeisaiBeanMap.get(mapKey).setIbDengaikagk(
                    bzSiwakeMeisaiBeanMap.get(mapKey).getIbDengaikagk().add(bzSiwakeMeisaiBean.getIbDengaikagk()));
                bzSiwakeMeisaiBeanMap.get(mapKey).setIbDenyenkagk(
                    bzSiwakeMeisaiBeanMap.get(mapKey).getIbDenyenkagk().add(bzSiwakeMeisaiBean.getIbDenyenkagk()));
                bzSiwakeMeisaiBeanMap.get(mapKey).setIbKeiyakutuukagk(
                    bzSiwakeMeisaiBeanMap.get(mapKey).getIbKeiyakutuukagk().add(bzSiwakeMeisaiBean.getIbKeiyakutuukagk()));
                if (bzSiwakeMeisaiBean.getIbTaisyakutyouseiflg()) {
                    bzSiwakeMeisaiBeanMap.get(mapKey).setIbTaisyakutyouseiflg(true);
                }
            }
            else {
                bzSiwakeMeisaiBeanMap.put(mapKey, bzSiwakeMeisaiBean);
            }
            if (C_TaisyakuKbn.KARIKATA.eq(bzSiwakeMeisaiBean.getIbTaisyakukbn())) {
                karigoukeigkDengk = karigoukeigkDengk.add(bzSiwakeMeisaiBean.getIbDenyenkagk());
                if (bzSiwakeMeisaiBean.getIbTaisyakutyouseiflg()) {
                    tyouseiMapKey =  mapKey;
                }
            }
            else if (C_TaisyakuKbn.KASIKATA.eq(bzSiwakeMeisaiBean.getIbTaisyakukbn())) {
                kasigoukeigkDengk = kasigoukeigkDengk.add(bzSiwakeMeisaiBean.getIbDenyenkagk());
            }
        }

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
            if (!BizUtil.isBlank(tyouseiMapKey)) {

                if (karigoukeigkDengk.compareTo(kasigoukeigkDengk) > 0) {
                    BizCurrency kariTyouseikingk = karigoukeigkDengk.subtract(kasigoukeigkDengk);
                    if (kariTyouseikingk.compareTo(BizCurrency.valueOf(10, kariTyouseikingk.getType())) < 0) {
                        bzSiwakeMeisaiBeanMap.get(tyouseiMapKey).setIbDenyenkagk(
                            bzSiwakeMeisaiBeanMap.get(tyouseiMapKey).getIbDenyenkagk().subtract(kariTyouseikingk));
                    }
                }
                else if (karigoukeigkDengk.compareTo(kasigoukeigkDengk) < 0) {
                    BizCurrency kariTyouseikingk = kasigoukeigkDengk.subtract(karigoukeigkDengk);
                    if (kariTyouseikingk.compareTo(BizCurrency.valueOf(10, kariTyouseikingk.getType())) < 0) {
                        bzSiwakeMeisaiBeanMap.get(tyouseiMapKey).setIbDenyenkagk(
                            bzSiwakeMeisaiBeanMap.get(tyouseiMapKey).getIbDenyenkagk().add(kariTyouseikingk));
                    }
                }
            }
        }

        for (String mapKey : bzSiwakeMeisaiBeanMap.keySet()) {
            bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanMap.get(mapKey));
        }

        logger.debug("△ 貸借調整処理 終了");

        return bzSiwakeMeisaiBeanLst;
    }

    public void execKihrkmPKanjokamokuHantei(
        BizDate pDenYmd,
        BizDate pKykYmd,
        BizCurrency pZennouNyuukinkgk,
        BizDate pRyosyuYmd,
        BizDateYM pJkipjytYm,
        BizCurrency pKihrkmp,
        SiwakeHanteiNyknJissekiRirekiBean[] pSiwakeHanteiNyknJissekiRirekiBeans,
        C_Hrkkaisuu pHrkkaisuu,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        logger.debug("▽ 既払込保険料勘定科目判定 開始");
        CurrencyType type = pKihrkmp.getType();
        BizCurrency taisyouGkSyonendo2kaimeikouP = BizCurrency.valueOf(0, type);
        BizCurrency taisyouGkJinendoikouP = BizCurrency.valueOf(0, type);
        BizCurrency taisyouGkSonotaHenreikin = BizCurrency.valueOf(0, type);
        taisyouGkSyonendoSyokaip = BizCurrency.valueOf(0, type);
        taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(0, type);
        taisyouGkJinendoikoup = BizCurrency.valueOf(0, type);
        taisyouGkSonotahenreikin = BizCurrency.valueOf(0, type);
        if (pKihrkmp.compareTo(BizCurrency.valueOf(0, type)) > 0) {
            if (pRyosyuYmd != null) {
                KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);
                String zennouPSeisanKbn = keisanZennouSeisanGk2.getZennouPSeisanKbn(pRyosyuYmd, pDenYmd);
                if (zennouPSeisanKbn.equals(KeisanZennouSeisanGk2.ZENNOUPSEISANKBN_SONOTA)) {
                    taisyouGkSonotahenreikin = pZennouNyuukinkgk.add(pSiwakeHanteiNyknJissekiRirekiBeans[0].getRsgaku());
                }
                else if (zennouPSeisanKbn.equals(KeisanZennouSeisanGk2.ZENNOUPSEISANKBN_JINENDOP)) {
                    if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {
                        taisyouGkJinendoikoup = pZennouNyuukinkgk;
                        taisyouGkSyonendo2kaimeikoup = pSiwakeHanteiNyknJissekiRirekiBeans[0].getRsgaku().subtract(
                            pSiwakeHanteiNyknJissekiRirekiBeans[0].getHrkp());
                        taisyouGkSyonendoSyokaip = pSiwakeHanteiNyknJissekiRirekiBeans[0].getHrkp();
                    }
                    if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {
                        taisyouGkJinendoikoup = pZennouNyuukinkgk;
                        taisyouGkSyonendoSyokaip = pSiwakeHanteiNyknJissekiRirekiBeans[0].getRsgaku();
                    }

                }
                logger.debug("△ 既払込保険料勘定科目判定 終了");
                return;
            }
            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            BizDate kessanNensibi = setKessanNensibi.exec(pDenYmd);
            BizDateY tyakkinJigyounendo = kessanNensibi.getBizDateY();
            BizDateYM seisanJigyouYm = BizDateYM.valueOf(tyakkinJigyounendo, 4);
            BizDateYM seisanStartYm = pKykYmd.getBizDateYM();
            BizDateYM seisanEndYm = pJkipjytYm;
            BizDateYM yokukykYm = pKykYmd.addYears(1).getBizDateYM();
            int jyuutoutuKisuu = Integer.parseInt(pHrkkaisuu.getValue());
            BizDateYM hanteiym = pKykYmd.addMonths(jyuutoutuKisuu).getBizDateYM();

            if (BizDateUtil.compareYm(seisanJigyouYm, seisanEndYm) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYm(seisanJigyouYm, seisanEndYm) == BizDateUtil.COMPARE_EQUAL) {
                taisyouGkSonotahenreikin = pKihrkmp;
                logger.debug("△ 既払込保険料勘定科目判定 終了");
                return;
            }
            if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu) &&
                (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pTikiktbrisyuruikbn)
                    || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.equals(pTikiktbrisyuruikbn))) {
                if (BizDateUtil.compareYm(seisanStartYm, seisanJigyouYm) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYm(seisanStartYm, seisanJigyouYm) == BizDateUtil.COMPARE_EQUAL) {
                    for (SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean : pSiwakeHanteiNyknJissekiRirekiBeans) {
                        if (BizDateUtil.compareYm(siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym(),
                            yokukykYm) == BizDateUtil.COMPARE_LESSER) {
                            if (BizDateUtil.compareYm(seisanStartYm,
                                siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym()) == BizDateUtil.COMPARE_EQUAL) {
                                taisyouGkSyonendoSyokaip = siwakeHanteiNyknJissekiRirekiBean.getHrkp();
                                taisyouGkSyonendo2kaimeikoup = siwakeHanteiNyknJissekiRirekiBean.getRsgaku().subtract(
                                    siwakeHanteiNyknJissekiRirekiBean.getHrkp());
                            }
                            else {
                                taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikoup.add(
                                    siwakeHanteiNyknJissekiRirekiBean.getRsgaku());
                            }
                        }
                        else {
                            taisyouGkJinendoikoup = taisyouGkJinendoikoup.add(siwakeHanteiNyknJissekiRirekiBean.getRsgaku());
                        }
                    }
                    logger.debug("△ 既払込保険料勘定科目判定 終了");
                    return;
                }
                if (BizDateUtil.compareYm(yokukykYm, seisanJigyouYm) == BizDateUtil.COMPARE_GREATER) {
                    if (BizDateUtil.compareYm(yokukykYm, seisanEndYm) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYm(yokukykYm, seisanEndYm) == BizDateUtil.COMPARE_EQUAL) {
                        for (SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean : pSiwakeHanteiNyknJissekiRirekiBeans) {
                            BizDateYM jyuutouYmKeikaksn = siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym();
                            int kaisuuSonotahenreikin = 0;
                            int kaisuuSyonendo2kaimeikou = 0;
                            BizCurrency mstaisyouGkSonotahenreikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            BizCurrency mstaisyouGkSyonendo2kaimeikouP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            if (BizDateUtil.compareYm(siwakeHanteiNyknJissekiRirekiBean.getJyutouendym(),
                                seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                mstaisyouGkSonotahenreikin = siwakeHanteiNyknJissekiRirekiBean.getRsgaku();
                            }
                            else {
                                for (int i = siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum(); i > 0 ; i--) {
                                    if (BizDateUtil.compareYm(jyuutouYmKeikaksn, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                        jyuutouYmKeikaksn = jyuutouYmKeikaksn.addMonths(1);
                                        kaisuuSonotahenreikin = kaisuuSonotahenreikin + 1;
                                    }
                                    else {
                                        kaisuuSyonendo2kaimeikou = kaisuuSyonendo2kaimeikou + 1;
                                        break;
                                    }
                                }
                                if (BizDateUtil.compareYm(seisanStartYm,
                                    siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym()) == BizDateUtil.COMPARE_EQUAL) {
                                    BizCurrency kihrkmp1getuUnit = (siwakeHanteiNyknJissekiRirekiBean.getRsgaku().subtract(
                                        siwakeHanteiNyknJissekiRirekiBean.getHrkp())).divide(
                                            siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum() - 1, 0, RoundingMode.DOWN);
                                    mstaisyouGkSonotahenreikin = siwakeHanteiNyknJissekiRirekiBean.getHrkp().add(
                                        kihrkmp1getuUnit.multiply(kaisuuSonotahenreikin -1));
                                }
                                else {
                                    BizCurrency kihrkmp1getuUnit = siwakeHanteiNyknJissekiRirekiBean.getRsgaku().divide(
                                        siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum(), 0, RoundingMode.DOWN);
                                    mstaisyouGkSonotahenreikin = kihrkmp1getuUnit.multiply(kaisuuSonotahenreikin);

                                }
                                if (kaisuuSyonendo2kaimeikou > 0) {
                                    mstaisyouGkSyonendo2kaimeikouP = siwakeHanteiNyknJissekiRirekiBean.getRsgaku().subtract(mstaisyouGkSonotahenreikin);
                                }
                            }
                            taisyouGkSonotaHenreikin = taisyouGkSonotaHenreikin.add(mstaisyouGkSonotahenreikin);
                            taisyouGkSyonendo2kaimeikouP = taisyouGkSyonendo2kaimeikouP.add(mstaisyouGkSyonendo2kaimeikouP);
                        }
                        taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikouP;
                        taisyouGkSonotahenreikin = taisyouGkSonotaHenreikin;
                        logger.debug("△ 既払込保険料勘定科目判定 終了");
                        return;
                    }

                    for (SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean : pSiwakeHanteiNyknJissekiRirekiBeans) {
                        BizDateYM jyuutouYmKeikaksn = siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym();
                        int kaisuuSonotahenreikin = 0;
                        int kaisuuSyonendo2kaimeikou = 0;
                        BizCurrency mstaisyouGkSonotahenreikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                        BizCurrency mstaisyouGkSyonendo2kaimeikouP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                        BizCurrency mstaisyouGkJinendoikouP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                        if (BizDateUtil.compareYm(siwakeHanteiNyknJissekiRirekiBean.getJyutouendym(),
                            seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                            mstaisyouGkSonotahenreikin = siwakeHanteiNyknJissekiRirekiBean.getRsgaku();
                        }
                        else {
                            for (int i = siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum(); i > 0 ; i--) {
                                if (BizDateUtil.compareYm(jyuutouYmKeikaksn, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                    jyuutouYmKeikaksn = jyuutouYmKeikaksn.addMonths(1);
                                    kaisuuSonotahenreikin = kaisuuSonotahenreikin + 1;
                                }
                                else {
                                    if (BizDateUtil.compareYm(jyuutouYmKeikaksn, yokukykYm) == BizDateUtil.COMPARE_LESSER) {
                                        kaisuuSyonendo2kaimeikou = kaisuuSyonendo2kaimeikou + 1;
                                        break;
                                    }
                                    mstaisyouGkJinendoikouP = siwakeHanteiNyknJissekiRirekiBean.getRsgaku();
                                    break;
                                }
                            }
                            if (BizDateUtil.compareYm(seisanStartYm,
                                siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym()) == BizDateUtil.COMPARE_EQUAL) {
                                BizCurrency kihrkmp1getuUnit = (siwakeHanteiNyknJissekiRirekiBean.getRsgaku().subtract(
                                    siwakeHanteiNyknJissekiRirekiBean.getHrkp())).divide(
                                        siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum() - 1, 0, RoundingMode.DOWN);
                                mstaisyouGkSonotahenreikin = siwakeHanteiNyknJissekiRirekiBean.getHrkp().add(
                                    kihrkmp1getuUnit.multiply(kaisuuSonotahenreikin -1));
                            }
                            else {
                                BizCurrency kihrkmp1getuUnit = siwakeHanteiNyknJissekiRirekiBean.getRsgaku().divide(
                                    siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum(), 0, RoundingMode.DOWN);
                                mstaisyouGkSonotahenreikin = kihrkmp1getuUnit.multiply(kaisuuSonotahenreikin);
                            }
                            if (kaisuuSyonendo2kaimeikou > 0) {
                                mstaisyouGkSyonendo2kaimeikouP = siwakeHanteiNyknJissekiRirekiBean.getRsgaku().subtract(mstaisyouGkSonotahenreikin);
                            }
                        }
                        taisyouGkSonotaHenreikin = taisyouGkSonotaHenreikin.add(mstaisyouGkSonotahenreikin);
                        taisyouGkSyonendo2kaimeikouP = taisyouGkSyonendo2kaimeikouP.add(mstaisyouGkSyonendo2kaimeikouP);
                        taisyouGkJinendoikouP = taisyouGkJinendoikouP.add(mstaisyouGkJinendoikouP);

                    }
                    taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikouP;
                    taisyouGkJinendoikoup = taisyouGkJinendoikouP;
                    taisyouGkSonotahenreikin = taisyouGkSonotaHenreikin;
                    logger.debug("△ 既払込保険料勘定科目判定 終了");
                    return;
                }
                for (SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean : pSiwakeHanteiNyknJissekiRirekiBeans) {
                    BizDateYM jyuutouYmKeikaksn = siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym();
                    int kaisuuSonotahenreikin = 0;
                    int kaisuuJinendoikou = 0;
                    BizCurrency mstaisyouGkSonotahenreikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency mstaisyouGkJinendoIkou = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    if (BizDateUtil.compareYm(siwakeHanteiNyknJissekiRirekiBean.getJyutouendym(),
                        seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                        mstaisyouGkSonotahenreikin = siwakeHanteiNyknJissekiRirekiBean.getRsgaku();
                    }
                    else {
                        for (int i = siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum(); i > 0 ; i--) {
                            if (BizDateUtil.compareYm(jyuutouYmKeikaksn, seisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                                jyuutouYmKeikaksn = jyuutouYmKeikaksn.addMonths(1);
                                kaisuuSonotahenreikin = kaisuuSonotahenreikin + 1;
                            }
                            else {
                                kaisuuJinendoikou = kaisuuJinendoikou + 1;
                                break;
                            }
                        }
                        BizCurrency kihrkmp1getuUnit = siwakeHanteiNyknJissekiRirekiBean.getRsgaku().divide(
                            siwakeHanteiNyknJissekiRirekiBean.getJyutoukaisuum(), 0, RoundingMode.DOWN);
                        mstaisyouGkSonotahenreikin = kihrkmp1getuUnit.multiply(kaisuuSonotahenreikin);
                        if (kaisuuJinendoikou > 0) {
                            mstaisyouGkJinendoIkou = siwakeHanteiNyknJissekiRirekiBean.getRsgaku().subtract(mstaisyouGkSonotahenreikin);
                        }
                    }
                    taisyouGkSonotaHenreikin = taisyouGkSonotaHenreikin.add(mstaisyouGkSonotahenreikin);
                    taisyouGkJinendoikouP = taisyouGkJinendoikouP.add(mstaisyouGkJinendoIkou);
                }

                taisyouGkJinendoikoup = taisyouGkJinendoikouP;
                taisyouGkSonotahenreikin = taisyouGkSonotaHenreikin;

                logger.debug("△ 既払込保険料勘定科目判定 終了");
                return;
            }
            else {
                execKihrkmPKanjokamokuHanteiNasi(pSiwakeHanteiNyknJissekiRirekiBeans,seisanJigyouYm,hanteiym,yokukykYm);

                logger.debug("△ 既払込保険料勘定科目判定 終了");
                return;
            }
        }
    }

    private void execPKanjokamokuHanteiNasi(
        MiKeikaPBean[] pMiKeikaPBeans,
        BizDateYM pSeisanJigyouYm,
        BizDateYM pHanteiym,
        BizDateYM pYokukykYm
        ){
        for (MiKeikaPBean miKeikaPBean : pMiKeikaPBeans) {

            BizDateYM mkeiPJytYm = miKeikaPBean.getMkeiPJytYm();
            BizCurrency miKeikaP = miKeikaPBean.getMiKeikaP();

            if (BizDateUtil.compareYm(mkeiPJytYm,pSeisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                taisyouGkSonotahenreikin = taisyouGkSonotahenreikin.add(miKeikaP);
            }
            else {
                if (BizDateUtil.compareYm(mkeiPJytYm,pHanteiym) == BizDateUtil.COMPARE_LESSER) {
                    taisyouGkSyonendoSyokaip = miKeikaP;
                }
                else {
                    if (BizDateUtil.compareYm(mkeiPJytYm,pYokukykYm) == BizDateUtil.COMPARE_LESSER) {
                        taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikoup.add(miKeikaP);
                    }
                    else {
                        taisyouGkJinendoikoup = taisyouGkJinendoikoup.add(miKeikaP);
                    }
                }
            }
        }
    }

    private void execKihrkmPKanjokamokuHanteiNasi(
        SiwakeHanteiNyknJissekiRirekiBean[] pSiwakeHanteiNyknJissekiRirekiBeans,
        BizDateYM pSeisanJigyouYm,
        BizDateYM pHanteiym,
        BizDateYM pYokukykYm
        ){
        for(SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean : pSiwakeHanteiNyknJissekiRirekiBeans) {

            BizDateYM jyutoustartym = siwakeHanteiNyknJissekiRirekiBean.getJyutoustartym();
            BizCurrency rsgaku = siwakeHanteiNyknJissekiRirekiBean.getRsgaku();

            if (BizDateUtil.compareYm(jyutoustartym, pSeisanJigyouYm) == BizDateUtil.COMPARE_LESSER) {
                taisyouGkSonotahenreikin = taisyouGkSonotahenreikin.add(rsgaku);
            }
            else {
                if (BizDateUtil.compareYm(jyutoustartym, pHanteiym) == BizDateUtil.COMPARE_LESSER) {
                    taisyouGkSyonendoSyokaip = rsgaku;
                }
                else {
                    if (BizDateUtil.compareYm(jyutoustartym, pYokukykYm) == BizDateUtil.COMPARE_LESSER) {
                        taisyouGkSyonendo2kaimeikoup = taisyouGkSyonendo2kaimeikoup.add(rsgaku);
                    }
                    else {
                        taisyouGkJinendoikoup = taisyouGkJinendoikoup.add(rsgaku);
                    }
                }
            }
        }
    }
}