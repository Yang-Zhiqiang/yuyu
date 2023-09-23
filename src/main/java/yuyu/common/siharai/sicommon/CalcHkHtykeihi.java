package yuyu.common.siharai.sicommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金必要経費計算
 */
public class CalcHkHtykeihi {

    @Inject
    private static Logger logger;

    public CalcHkHtykeihi() {
        super();
    }

    public CalcHkHtykeihiBean exec(String pSyono, C_Tuukasyu pKykTuukasyu, C_SUketoriHouhouKbn pSuketorihouhoukbn,
        BizCurrency pHokenkg, BizCurrency pYenhokenkngk, BizCurrency pNkkknjyutougk, BizCurrency pYennkkknjyutougk,
        BizNumber pMisyuuptekikawaserate, BizCurrency pMisyuup) {

        logger.debug("▽ 保険金必要経費計算 開始");

        CalcHkHtykeihiBean calcHkHtykeihiBean = SWAKInjector.getInstance(CalcHkHtykeihiBean.class);

        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);

        errorKbn = keisanHtyKeihi.exec(pSyono, pKykTuukasyu);

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            BizCurrency htyKeihi = keisanHtyKeihi.getHtyKeihi();

            BizCurrency yenHtyKeihi = keisanHtyKeihi.getYenHtyKeihi();

            BizCurrency yenGenKykSyaHtyKeihi = keisanHtyKeihi.getYenGenKykSyaHtyKeihi();

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType type = henkanTuuka.henkanTuukaKbnToType(pKykTuukasyu);

            BizCurrency misyuupKasangk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency yenhtykeihi  = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency genKykSyaHtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            if (pMisyuup.compareTo(BizCurrency.valueOf(0, pMisyuup.getType())) > 0) {
                if (C_Tuukasyu.JPY.eq(pKykTuukasyu)) {
                    misyuupKasangk = pMisyuup;
                } else {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    misyuupKasangk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMisyuup, pMisyuuptekikawaserate,
                        C_HasuusyoriKbn.AGE);
                }
            }

            yenhtykeihi = yenHtyKeihi.add(misyuupKasangk);
            genKykSyaHtyKeihi = yenGenKykSyaHtyKeihi.add(misyuupKasangk);

            if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSuketorihouhoukbn)) {
                calcHkHtykeihiBean.setHtykeihi(htyKeihi);
                calcHkHtykeihiBean.setYenhtykeihi(yenhtykeihi);
                calcHkHtykeihiBean.setItjknhtykeihi(htyKeihi);
                calcHkHtykeihiBean.setYenitjknhtykeihi(yenhtykeihi);
                calcHkHtykeihiBean.setNkhtykeihi(BizCurrency.valueOf(0, type));
                calcHkHtykeihiBean.setYennkhtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                calcHkHtykeihiBean.setShrkykhtykeihi(genKykSyaHtyKeihi);
            }

            else if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(pSuketorihouhoukbn)) {
                calcHkHtykeihiBean.setHtykeihi(htyKeihi);
                calcHkHtykeihiBean.setYenhtykeihi(yenHtyKeihi);
                calcHkHtykeihiBean.setItjknhtykeihi(BizCurrency.valueOf(0, type));
                calcHkHtykeihiBean.setYenitjknhtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                calcHkHtykeihiBean.setNkhtykeihi(htyKeihi);
                calcHkHtykeihiBean.setYennkhtykeihi(yenHtyKeihi);
            }

            else if (C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(pSuketorihouhoukbn)) {
                BizCurrency itjknhtykeihi = BizCurrency.valueOf(0, type);
                BizCurrency yenitjknhtykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (pHokenkg.compareTo(BizCurrency.valueOf(0, type)) > 0) {
                    itjknhtykeihi = pHokenkg.subtract(pNkkknjyutougk).multiplyCurrency(htyKeihi).divideCurrency(pHokenkg,type.getShiftDigits(), RoundingMode.HALF_UP).toValidValue(RoundingMode.HALF_UP);
                }

                if (pYenhokenkngk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
                    yenitjknhtykeihi = pYenhokenkngk.subtract(pYennkkknjyutougk).multiplyCurrency(yenHtyKeihi).divideCurrency(pYenhokenkngk,BizCurrencyTypes.YEN.getShiftDigits(), RoundingMode.HALF_UP).toValidValue(RoundingMode.HALF_UP);
                }

                calcHkHtykeihiBean.setHtykeihi(htyKeihi);
                calcHkHtykeihiBean.setYenhtykeihi(yenHtyKeihi);
                calcHkHtykeihiBean.setItjknhtykeihi(itjknhtykeihi);
                calcHkHtykeihiBean.setYenitjknhtykeihi(yenitjknhtykeihi);
                calcHkHtykeihiBean.setNkhtykeihi(htyKeihi.subtract(itjknhtykeihi));
                calcHkHtykeihiBean.setYennkhtykeihi(yenHtyKeihi.subtract(yenitjknhtykeihi));
            }
        }

        logger.debug("△ 保険金必要経費計算 終了");

        return calcHkHtykeihiBean;
    }
}