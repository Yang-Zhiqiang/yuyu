package yuyu.common.biz.bzcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.dba4KeisanTienrisoku.KeisanTienrisokuDao;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KyjthsnnyKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_YmdkeisikiKbn;

/**
 * 業務共通 共通 遅延利息計算
 */
public class KeisanTienrisoku {

    @Inject
    private static Logger logger;

    @Inject
    private KeisanTienrisokuDao keisanTienrisokuDao;

    public KeisanTienrisokuBean exec(BizDate pSyoruiUkeYmd, BizDate pHubiKanryouYmd, BizDate pTyakkinYmd,
        BizCurrency pSshkkei,
        Integer pRikoukiTyuutuudanNissuu,
        C_SinsaGendoKknKbn pSinsagendoKknKbn
        ) {

        logger.debug("▽ 遅延利息計算 開始");
        KeisanTienrisokuBean keisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);
        Integer shry = 0;
        C_KyjthsnnyKbn kyjthsnnyKbn = null;
        BizDate risokuNasiYmd = null;
        BizDate risokuKeisanYmd = null;
        if (C_SinsaGendoKknKbn.BLNK.eq(pSinsagendoKknKbn) || C_SinsaGendoKknKbn.BD5.eq(pSinsagendoKknKbn)) {
            shry = 5;
            kyjthsnnyKbn = C_KyjthsnnyKbn.HUSANNYUU;
            BizDate syoruiUkeYmd = null;
            if (pHubiKanryouYmd != null) {
                if (BizDateUtil.compareYmd(pHubiKanryouYmd, pSyoruiUkeYmd) == BizDateUtil.COMPARE_GREATER) {
                    syoruiUkeYmd = pHubiKanryouYmd;
                }
                else {
                    syoruiUkeYmd = pSyoruiUkeYmd;
                }
            }
            else {
                syoruiUkeYmd = pSyoruiUkeYmd;
            }
            risokuNasiYmd = getUketukebiKijyun(syoruiUkeYmd, shry, kyjthsnnyKbn, pRikoukiTyuutuudanNissuu);
        }
        else {
            if (pHubiKanryouYmd == null) {
                if (C_SinsaGendoKknKbn.D45.eq(pSinsagendoKknKbn)) {
                    shry = 45;
                    kyjthsnnyKbn = C_KyjthsnnyKbn.NONE;
                }
                else if (C_SinsaGendoKknKbn.D180.eq(pSinsagendoKknKbn)) {
                    shry = 180;
                    kyjthsnnyKbn = C_KyjthsnnyKbn.NONE;
                }
                risokuNasiYmd = getUketukebiKijyun(pSyoruiUkeYmd, shry, kyjthsnnyKbn, pRikoukiTyuutuudanNissuu);
            }
            else {
                shry = 5;
                kyjthsnnyKbn = C_KyjthsnnyKbn.HUSANNYUU;
                BizDate risokuNasiYmdHubi = getUketukebiKijyun(pHubiKanryouYmd, shry, kyjthsnnyKbn,
                    pRikoukiTyuutuudanNissuu);
                if (C_SinsaGendoKknKbn.D45.eq(pSinsagendoKknKbn)) {
                    shry = 45;
                    kyjthsnnyKbn = C_KyjthsnnyKbn.NONE;
                }
                else if (C_SinsaGendoKknKbn.D180.eq(pSinsagendoKknKbn)) {
                    shry = 180;
                    kyjthsnnyKbn = C_KyjthsnnyKbn.NONE;
                }
                BizDate risokuNasiYmdKeiyaku = getUketukebiKijyun(pSyoruiUkeYmd, shry, kyjthsnnyKbn,
                    pRikoukiTyuutuudanNissuu);
                if (BizDateUtil.compareYmd(risokuNasiYmdKeiyaku, risokuNasiYmdHubi) == BizDateUtil.COMPARE_GREATER) {
                    risokuNasiYmd = risokuNasiYmdKeiyaku;
                }
                else {
                    risokuNasiYmd = risokuNasiYmdHubi;
                }
            }
        }
        risokuKeisanYmd = risokuNasiYmd.addDays(1);

        if (BizDateUtil.compareYmd(risokuKeisanYmd, pTyakkinYmd) == BizDateUtil.COMPARE_LESSER
            || BizDateUtil.compareYmd(risokuKeisanYmd, pTyakkinYmd) == BizDateUtil.COMPARE_EQUAL) {
            SiTienRisokuKikanKeisan siTienRisokuKikanKeisan = SWAKInjector.getInstance(SiTienRisokuKikanKeisan.class);
            SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean = SWAKInjector
                .getInstance(SiTienRisokuKikanKeisanBean.class);
            siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(C_YmdkeisikiKbn.YYYYMMDD);
            siTienRisokuKikanKeisanBean.setEndYmd(pTyakkinYmd.addDays(1).toString());
            siTienRisokuKikanKeisanBean.setStartYmd(risokuKeisanYmd.toString());
            siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

            keisanTienrisokuBean.setShrtienrsk(getTienrisoku(pSshkkei, siTienRisokuKikanKeisanBean.getKikan_yy(),
                siTienRisokuKikanKeisanBean.getKikan_ddd(), risokuKeisanYmd));
            keisanTienrisokuBean.setShrtienrskStartYmd(risokuKeisanYmd);
            keisanTienrisokuBean.setShrtienrskEndYmd(pTyakkinYmd);
            keisanTienrisokuBean.setShrtienNissuu(new Integer(siTienRisokuKikanKeisanBean.getKikan_ddddd().toString()));
        } else {
            keisanTienrisokuBean.setShrtienrsk(BizCurrency.valueOf(0,pSshkkei.getType()));
            keisanTienrisokuBean.setShrtienrskStartYmd(null);
            keisanTienrisokuBean.setShrtienrskEndYmd(null);
            keisanTienrisokuBean.setShrtienNissuu(0);
        }


        logger.debug("△ 遅延利息計算 終了");
        return keisanTienrisokuBean;
    }

    public KeisanTienrisokuBean execHaitouKin(BizDate pSyoumetuYmd, BizDate pTyakkinYmd,
        BizCurrency pSshkkei
        ) {

        logger.debug("▽ 遅延利息計算（配当金追払） 開始");
        KeisanTienrisokuBean keisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);


        if (BizDateUtil.compareYmd(pSyoumetuYmd, pTyakkinYmd) == BizDateUtil.COMPARE_LESSER
            || BizDateUtil.compareYmd(pSyoumetuYmd, pTyakkinYmd) == BizDateUtil.COMPARE_EQUAL) {
            SiTienRisokuKikanKeisan siTienRisokuKikanKeisan = SWAKInjector.getInstance(SiTienRisokuKikanKeisan.class);
            SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean = SWAKInjector
                .getInstance(SiTienRisokuKikanKeisanBean.class);
            siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(C_YmdkeisikiKbn.YYYYMMDD);
            siTienRisokuKikanKeisanBean.setEndYmd(pTyakkinYmd.addDays(1).toString());
            siTienRisokuKikanKeisanBean.setStartYmd(pSyoumetuYmd.toString());
            siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

            keisanTienrisokuBean.setShrtienrsk(getTienrisoku(pSshkkei, siTienRisokuKikanKeisanBean.getKikan_yy(),
                siTienRisokuKikanKeisanBean.getKikan_ddd(),pSyoumetuYmd));
            keisanTienrisokuBean.setShrtienrskStartYmd(pSyoumetuYmd);
            keisanTienrisokuBean.setShrtienrskEndYmd(pTyakkinYmd);
            keisanTienrisokuBean.setShrtienNissuu(new Integer(siTienRisokuKikanKeisanBean.getKikan_ddddd().toString()));
        } else {
            keisanTienrisokuBean.setShrtienrsk(BizCurrency.valueOf(0,pSshkkei.getType()));
            keisanTienrisokuBean.setShrtienrskStartYmd(null);
            keisanTienrisokuBean.setShrtienrskEndYmd(null);
            keisanTienrisokuBean.setShrtienNissuu(0);
        }

        logger.debug("△ 遅延利息計算（配当金追払） 終了");
        return keisanTienrisokuBean;
    }

    private BizDate getUketukebiKijyun(BizDate pSyoruiukeYmd, Integer pSiharaiKikan, C_KyjthsnnyKbn pKyjthsnnyKbn,
        Integer pRikouKityuuTuudanNissuu) {
        BizDate uketukeKijyun = null;
        if (C_KyjthsnnyKbn.HUSANNYUU.eq(pKyjthsnnyKbn)) {
            uketukeKijyun = pSyoruiukeYmd.addBusinessDays(pSiharaiKikan);
        }
        else {
            uketukeKijyun = pSyoruiukeYmd.addDays(pSiharaiKikan + pRikouKityuuTuudanNissuu);
            if (uketukeKijyun.isHoliday()) {
                uketukeKijyun = uketukeKijyun.getBusinessDay(CHolidayAdjustingMode.NEXT);
            }
        }
        return uketukeKijyun;
    }

    private BizCurrency getTienrisoku(BizCurrency pSshkkeim, BizNumber pYears, BizNumber pDays, BizDate pRisokuKeisanYmd) {
        BizCurrency tienRisoku = BizCurrency.valueOf(0);
        BizNumber tienRiritu = BizNumber.valueOf(0);
        if (pYears.compareTo(BizNumber.ZERO) == 0 && pDays.compareTo(BizNumber.ZERO) == 0) {
            return tienRisoku;
        }
        BizNumber tienRirituNenri = keisanTienrisokuDao.getTienrisokuRiritu(pRisokuKeisanYmd);
        BizNumber tienRirituResult = tienRirituNenri.multiply(pDays)
            .divide(365, 10, RoundingMode.DOWN);
        if (tienRirituNenri.compareTo(tienRirituResult) > 0) {
            tienRiritu = tienRirituResult;
        }
        else {
            tienRiritu = tienRirituNenri;
        }
        BizCurrency tienRisokuYear = pSshkkeim.multiply(tienRirituNenri).multiply(pYears,
            2, RoundingMode.DOWN);
        BizCurrency tienRisokuDay = pSshkkeim.multiply(tienRiritu, 10, RoundingMode.DOWN);
        tienRisoku = tienRisokuYear.add(tienRisokuDay);
        RoundingMode roundingMode = null;
        if (C_HasuusyoriKbn.AGE.getValue().equals(YuyuBizConfig.getInstance().getTienRskHasuusyori().getValue())) {
            roundingMode = RoundingMode.UP;
        }
        else if (C_HasuusyoriKbn.SUTE.getValue().equals(
            YuyuBizConfig.getInstance().getTienRskHasuusyori().getValue())) {
            roundingMode = RoundingMode.DOWN;
        }
        else if (C_HasuusyoriKbn.SSYGNY.getValue().equals(
            YuyuBizConfig.getInstance().getTienRskHasuusyori().getValue())) {
            roundingMode = RoundingMode.HALF_UP;
        }
        return tienRisoku.toValidValue(roundingMode);
    }
}