package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;

import com.google.common.collect.Ordering;

/**
 * 契約保全 契約保全共通 前納控除証明額計算
 */
public class KeisanZennouKoujyogaku {

    private BizNumber kjsmyouYenKawaserate;

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public KeisanZennouKoujyogaku() {
        super();
    }

    public void setKjsmyouYenKawaserate(BizNumber pKjsmyouYenKawaserate) {

        kjsmyouYenKawaserate = pKjsmyouYenKawaserate;
    }

    public BizCurrency getZennouKoujyogaku(BizCurrency pKjsmyouZennounyuuKinkGk, String pKjsmyouzennouKikanm,
        BizDate pKjsmyouzennoukaisiYmd, BizCurrency pHrkp, C_Hrkkaisuu pHrkkaisuu, BizDateYM pSyoumeistartYm,
        int pSyomeiKaisuuY, int pSyomeiKaisuuM) {

        logger.debug("▽ 前納控除証明額計算 前納控除証明総額取得 開始");

        if (pSyomeiKaisuuY == 0 && pSyomeiKaisuuM == 0) {
            logger.debug("△ 前納控除証明額計算 前納控除証明総額取得 終了");
            return BizCurrency.valueOf(0);
        }

        JtKaisukeisan jtKaisuKeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

        jtKaisuKeisan.exec(pSyomeiKaisuuY, pSyomeiKaisuuM, pHrkkaisuu);
        int jyutoukikanKaisuu = jtKaisuKeisan.getJyutoukaisuu();
        jtKaisuKeisan.exec(0, Integer.valueOf(pKjsmyouzennouKikanm), pHrkkaisuu);
        int zennoukikanKaisu = jtKaisuKeisan.getJyutoukaisuu();

        BizCurrency kikanZennouhkp = BizCurrency.valueOf(0);
        int kikannKaisuu = 0;

        if (BizDateUtil.compareYm(pSyoumeistartYm, pKjsmyouzennoukaisiYmd.getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            C_Tuukasyu hrkpTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pHrkp.getType());

            if (!C_Tuukasyu.JPY.eq(hrkpTuukasyu) && kjsmyouYenKawaserate == null) {

                throw new CommonBizAppException("控除証明用前納情報設定　与件エラー　控除証明用円換算為替レート＝" + kjsmyouYenKawaserate);
            }

            if (C_Tuukasyu.JPY.eq(hrkpTuukasyu)) {

                kikanZennouhkp = pHrkp;
            }
            else {

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                kikanZennouhkp = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pHrkp, kjsmyouYenKawaserate, C_HasuusyoriKbn.SUTE);
            }

            kikannKaisuu = jyutoukikanKaisuu - 1;
        }
        else {
            kikannKaisuu = jyutoukikanKaisuu;
        }

        BizCurrency zennouKoujyogaku = pKjsmyouZennounyuuKinkGk.multiply(kikannKaisuu).divide(
            zennoukikanKaisu, 0, RoundingMode.DOWN).add(kikanZennouhkp);

        logger.debug("△ 前納控除証明額計算 前納控除証明総額取得 終了");
        return zennouKoujyogaku;
    }

    public KhZennouKoujyogakuBean doHaibunZennouKoujyogaku(BizCurrency pZennouKoujsymgaku,
        C_KoujyosyoumeipKbn pSyuKoujyosyoumeipKbn,
        List<KykSyouhnCommonParam> pKykSyouhnCommonParamLst) {

        logger.debug("▽ 前納控除証明額計算 前納控除証明額配分 開始");

        List<KykSyouhnCommonParam> sortedKykSyouhnCommonParamList = new ArrayList<>();

        Ordering<KykSyouhnCommonParam> ordering = Ordering.natural().nullsLast()
            .onResultOf(new SearchKykSyouhnCommonParamSortFunction());
        sortedKykSyouhnCommonParamList = ordering.sortedCopy(pKykSyouhnCommonParamLst);

        CurrencyType hokenryouType = sortedKykSyouhnCommonParamList.get(0).getHokenryou().getType();
        BizCurrency haraikomiP = BizCurrency.valueOf(0, hokenryouType);
        Map<C_KoujyosyoumeipKbn, BizCurrency> kojyowakuHaraikomipMap = new HashMap<C_KoujyosyoumeipKbn, BizCurrency>();
        kojyowakuHaraikomipMap.put(C_KoujyosyoumeipKbn.IPPAN, BizCurrency.valueOf(0, hokenryouType));
        kojyowakuHaraikomipMap.put(C_KoujyosyoumeipKbn.KAIGOIRYOU, BizCurrency.valueOf(0, hokenryouType));
        kojyowakuHaraikomipMap.put(C_KoujyosyoumeipKbn.NENKIN, BizCurrency.valueOf(0, hokenryouType));

        C_KoujyosyoumeipKbn syukoujyowakuKbn = C_KoujyosyoumeipKbn.BLNK;

        for (KykSyouhnCommonParam kykSyouhnCommonParam :sortedKykSyouhnCommonParamList) {
            haraikomiP = haraikomiP.add(kykSyouhnCommonParam.getHokenryou());
            C_KoujyosyoumeipKbn koujyosyoumeipKbn = C_KoujyosyoumeipKbn.BLNK;
            if (C_SyutkKbn.SYU.eq(kykSyouhnCommonParam.getSyutkkbn())) {
                koujyosyoumeipKbn = pSyuKoujyosyoumeipKbn;
            }
            else {
                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhnCommonParam.getSyouhncd(),
                    kykSyouhnCommonParam.getSyouhnsdno());
                koujyosyoumeipKbn = syouhnZokusei.getKoujyosyoumeipkbn();
            }

            if (C_SyutkKbn.SYU.eq(kykSyouhnCommonParam.getSyutkkbn())) {
                syukoujyowakuKbn = koujyosyoumeipKbn;
            }

            kojyowakuHaraikomipMap.put(
                koujyosyoumeipKbn,
                kojyowakuHaraikomipMap.get(koujyosyoumeipKbn).add(kykSyouhnCommonParam.getHokenryou()));
        }

        Map<C_KoujyosyoumeipKbn, BizCurrency> koujyowakukjgkMap = new HashMap<C_KoujyosyoumeipKbn, BizCurrency>();
        koujyowakukjgkMap.put(C_KoujyosyoumeipKbn.IPPAN, BizCurrency.valueOf(0));
        koujyowakukjgkMap.put(C_KoujyosyoumeipKbn.KAIGOIRYOU, BizCurrency.valueOf(0));
        koujyowakukjgkMap.put(C_KoujyosyoumeipKbn.NENKIN, BizCurrency.valueOf(0));

        for (C_KoujyosyoumeipKbn koujyosyoumeipKbn : kojyowakuHaraikomipMap.keySet()) {

            BizNumber koujyowakukjgk =  BizNumber.valueOf(kojyowakuHaraikomipMap.get(koujyosyoumeipKbn)).divide(
                BizNumber.valueOf(haraikomiP), 10, RoundingMode.DOWN);

            koujyowakukjgkMap.put(
                koujyosyoumeipKbn,
                pZennouKoujsymgaku.multiply(koujyowakukjgk, 0, RoundingMode.HALF_UP));
        }

        Map<C_KoujyosyoumeipKbn, BizCurrency> hasuuMap = new HashMap<C_KoujyosyoumeipKbn, BizCurrency>();
        hasuuMap.put(C_KoujyosyoumeipKbn.IPPAN, koujyowakukjgkMap.get(C_KoujyosyoumeipKbn.IPPAN));
        hasuuMap.put(C_KoujyosyoumeipKbn.KAIGOIRYOU, koujyowakukjgkMap.get(C_KoujyosyoumeipKbn.KAIGOIRYOU));
        hasuuMap.put(C_KoujyosyoumeipKbn.NENKIN, koujyowakukjgkMap.get(C_KoujyosyoumeipKbn.NENKIN));
        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = new ArrayList<KhShgtZennouKoujyogakuBean>();
        for (KykSyouhnCommonParam kykSyouhnCommonParam :sortedKykSyouhnCommonParamList) {

            KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = SWAKInjector.getInstance(KhShgtZennouKoujyogakuBean.class);
            C_KoujyosyoumeipKbn koujyosyoumeipKbn = C_KoujyosyoumeipKbn.BLNK;

            if (C_SyutkKbn.SYU.eq(kykSyouhnCommonParam.getSyutkkbn())) {
                koujyosyoumeipKbn = pSyuKoujyosyoumeipKbn;
            }
            else {
                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhnCommonParam.getSyouhncd(),
                    kykSyouhnCommonParam.getSyouhnsdno());

                koujyosyoumeipKbn = syouhnZokusei.getKoujyosyoumeipkbn();
            }

            BizNumber syouhnmip = BizNumber.valueOf(kykSyouhnCommonParam.getHokenryou()).divide(BizNumber.valueOf(
                kojyowakuHaraikomipMap.get(koujyosyoumeipKbn)), 10, RoundingMode.DOWN);


            BizCurrency koujyoSyoumeiGk = koujyowakukjgkMap.get(koujyosyoumeipKbn).multiply(syouhnmip, 0, RoundingMode.DOWN);

            khShgtZennouKoujyogakuBean.setSyouhncd(kykSyouhnCommonParam.getSyouhncd());
            khShgtZennouKoujyogakuBean.setSyouhnsdno(String.valueOf(kykSyouhnCommonParam.getSyouhnsdno()));
            khShgtZennouKoujyogakuBean.setSyutkkbn(kykSyouhnCommonParam.getSyutkkbn());
            khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(koujyosyoumeipKbn);
            khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(koujyoSyoumeiGk);
            khShgtZennouKoujyogakuBeanList.add(khShgtZennouKoujyogakuBean);

            hasuuMap.put(
                koujyosyoumeipKbn,
                hasuuMap.get(koujyosyoumeipKbn).subtract(koujyoSyoumeiGk));
        }

        for (KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean: khShgtZennouKoujyogakuBeanList) {
            C_KoujyosyoumeipKbn koujyosyoumeipKbn = khShgtZennouKoujyogakuBean.getKoujyosyoumeipkbn();

            if (syukoujyowakuKbn.eq(koujyosyoumeipKbn) && !C_SyutkKbn.SYU.eq(khShgtZennouKoujyogakuBean.getSyutkkbn())) {
                continue;
            }

            if (BizCurrency.valueOf(0, hasuuMap.get(koujyosyoumeipKbn).getType()).compareTo(hasuuMap.get(koujyosyoumeipKbn)) != 0) {

                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(khShgtZennouKoujyogakuBean.getKhShgtZennouKoujyogaku().
                    add(hasuuMap.get(koujyosyoumeipKbn)));

                hasuuMap.put(koujyosyoumeipKbn, BizCurrency.valueOf(0));
            }
        }

        List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = new ArrayList<KhWkgtZennouKoujyogakuBean>();
        for (C_KoujyosyoumeipKbn koujyosyoumeipKbn : koujyowakukjgkMap.keySet()) {
            KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean = SWAKInjector.getInstance(KhWkgtZennouKoujyogakuBean.class);
            khWkgtZennouKoujyogakuBean.setKoujyosyoumeipKbn(koujyosyoumeipKbn);
            khWkgtZennouKoujyogakuBean.setKhWkgtZennouKoujyogaku(koujyowakukjgkMap.get(koujyosyoumeipKbn));
            khWkgtZennouKoujyogakuBeanList.add(khWkgtZennouKoujyogakuBean);
        }

        KhZennouKoujyogakuBean khZennouKoujyogakuBean = SWAKInjector.getInstance(KhZennouKoujyogakuBean.class);

        khZennouKoujyogakuBean.setKhShgtZennouKoujyogakuBeanList(khShgtZennouKoujyogakuBeanList);
        khZennouKoujyogakuBean.setKhWkgtZennouKoujyogakuBeanList(khWkgtZennouKoujyogakuBeanList);

        logger.debug("△ 前納控除証明額計算 前納控除証明額配分 終了");
        return khZennouKoujyogakuBean;
    }

    public KhShgtZennouKoujyogakuBean getKhShgtZennouKoujyogakuBean(String pSyouhncd, String pSyouhnsdno,
        List<KhShgtZennouKoujyogakuBean> pKhShgtZennouKoujyogakuBeanLst) {

        logger.debug("▽ 前納控除証明額計算 商品単位控除証明情報取得 開始");

        for (KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean: pKhShgtZennouKoujyogakuBeanLst) {
            if (pSyouhncd.equals(khShgtZennouKoujyogakuBean.getSyouhncd()) &&
                pSyouhnsdno.equals(khShgtZennouKoujyogakuBean.getSyouhnsdno())) {

                logger.debug("△ 前納控除証明額計算 商品単位控除証明情報取得 終了");
                return khShgtZennouKoujyogakuBean;
            }
        }

        logger.debug("△ 前納控除証明額計算 商品単位控除証明情報取得 終了");

        return null;
    }


    public BizCurrency keisanTukiZennouGngk(BizCurrency pKjsmyouzennounyuukinkgk, BizCurrency pHenKjsmyouzennounyuukinkgk,
        BizCurrency pHrkp, BizCurrency pHenHrkp, BizDate pKjsmyouzennoukaisiymd, String pKjsmyouzennoukikanm,
        BizDateYM pSymKaisiYm, BizDateYM pSymEndYm, BizDateYM pSeisanKaisiYm) {

        logger.debug("▽ 前納控除証明額計算 月払前納減額時精算額計算 開始");

        BizDateSpan gngkSyomeiSpan = BizDateUtil.calcDifference(BizDate.valueOf(String.valueOf(pSymEndYm) + "01") ,
            BizDate.valueOf(String.valueOf(pSymKaisiYm) + "01"));

        int gngkSyomeiKikan = gngkSyomeiSpan.getYears() * 12 + gngkSyomeiSpan.getMonths() + 1;

        BizCurrency gngkSyomeiGk = BizCurrency.valueOf(0);
        gngkSyomeiGk = getZennouKoujyogaku(pKjsmyouzennounyuukinkgk, pKjsmyouzennoukikanm, pKjsmyouzennoukaisiymd,
            pHrkp, C_Hrkkaisuu.TUKI, pSymKaisiYm, 0, gngkSyomeiKikan);

        BizDateSpan kaikaSyomeiSpan = BizDateUtil.calcDifference(BizDate.valueOf(String.valueOf(pSeisanKaisiYm) + "01") ,
            BizDate.valueOf(String.valueOf(pSymKaisiYm) + "01"));

        int kaikaSyomeiKikan = kaikaSyomeiSpan.getYears() * 12 + kaikaSyomeiSpan.getMonths();

        BizCurrency kaikaSyomeiGk = BizCurrency.valueOf(0);
        kaikaSyomeiGk = getZennouKoujyogaku(pKjsmyouzennounyuukinkgk, pKjsmyouzennoukikanm, pKjsmyouzennoukaisiymd,
            pHrkp, C_Hrkkaisuu.TUKI, pSymKaisiYm, 0, kaikaSyomeiKikan);

        BizDateSpan mikaikaSyomeiSpan = BizDateUtil.calcDifference(BizDate.valueOf(String.valueOf(pSymEndYm) + "01") ,
            BizDate.valueOf(String.valueOf(pSeisanKaisiYm) + "01"));

        int mikaikaSyomeiKikan = mikaikaSyomeiSpan.getYears() * 12 + mikaikaSyomeiSpan.getMonths() + 1;

        BizCurrency mikaikaSyomeiGk = BizCurrency.valueOf(0);
        mikaikaSyomeiGk = getZennouKoujyogaku(pHenKjsmyouzennounyuukinkgk, pKjsmyouzennoukikanm, pKjsmyouzennoukaisiymd,
            pHenHrkp, C_Hrkkaisuu.TUKI, pSeisanKaisiYm, 0, mikaikaSyomeiKikan);

        BizCurrency keisanTukiZennouGngk = BizCurrency.valueOf(0);

        keisanTukiZennouGngk = gngkSyomeiGk.subtract(kaikaSyomeiGk).subtract(mikaikaSyomeiGk);

        logger.debug("△ 前納控除証明額計算 月払前納減額時精算額計算 終了");
        return keisanTukiZennouGngk;
    }

    public BizCurrency keisanTukiZennouSymt(BizCurrency pKjsmyouzennounyuukinkgk,
        BizCurrency pHrkp, BizDate pKjsmyouzennoukaisiymd, String pKjsmyouzennoukikanm,
        BizDateYM pSymKaisiYm, BizDateYM pSymEndYm, BizDateYM pSeisanKaisiYm) {

        logger.debug("▽ 前納控除証明額計算 月払前納消滅時精算額計算 開始");

        BizDateSpan symtSyomeiSpan = BizDateUtil.calcDifference(BizDate.valueOf(String.valueOf(pSymEndYm) + "01") ,
            BizDate.valueOf(String.valueOf(pSymKaisiYm) + "01"));

        int symtSyomeiKikan = symtSyomeiSpan.getYears() * 12 + symtSyomeiSpan.getMonths() + 1;

        BizCurrency symtSyomeiGk = BizCurrency.valueOf(0);
        symtSyomeiGk = getZennouKoujyogaku(pKjsmyouzennounyuukinkgk, pKjsmyouzennoukikanm, pKjsmyouzennoukaisiymd,
            pHrkp, C_Hrkkaisuu.TUKI, pSymKaisiYm, 0, symtSyomeiKikan);

        BizDateSpan kaikaSyomeiSpan = BizDateUtil.calcDifference(BizDate.valueOf(String.valueOf(pSeisanKaisiYm) + "01") ,
            BizDate.valueOf(String.valueOf(pSymKaisiYm) + "01"));

        int kaikaSyomeiKikan = kaikaSyomeiSpan.getYears() * 12 + kaikaSyomeiSpan.getMonths();

        BizCurrency kaikaSyomeiGk = BizCurrency.valueOf(0);
        kaikaSyomeiGk = getZennouKoujyogaku(pKjsmyouzennounyuukinkgk, pKjsmyouzennoukikanm, pKjsmyouzennoukaisiymd,
            pHrkp, C_Hrkkaisuu.TUKI, pSymKaisiYm, 0, kaikaSyomeiKikan);

        BizCurrency keisanTukiZennouSymt = BizCurrency.valueOf(0);

        keisanTukiZennouSymt = symtSyomeiGk.subtract(kaikaSyomeiGk);

        logger.debug("△ 前納控除証明額計算 月払前納消滅時精算額計算 終了");
        return keisanTukiZennouSymt;
    }
}