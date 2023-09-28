package yuyu.common.biz.bzcommon;

import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.dba4keisanazukariganrikin.KeisanAzukariGanrikinDao;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.db.entity.BM_AzukariRiritu;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 業務共通 共通 預り元利金計算
 */
public class KeisanAzukariGanrikin {

    private BizCurrency azukariGanrikin;

    private BizCurrency azukariGanrikinYen;

    private BizDate tyokuzenAzukariOutouYmd;

    private BizCurrency tyokuzenAzukarikin;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KeisanAzukariGanrikinDao keisanAzukariGanrikinDao;

    public KeisanAzukariGanrikin() {
        super();
    }

    public BizCurrency getAzukariGanrikinKyktuuka() {
        return azukariGanrikin;
    }

    public BizCurrency getAzukariGanrikinYen() {
        return azukariGanrikinYen;
    }

    public BizDate getTyokuzenAzukariOutouYmd() {
        return tyokuzenAzukariOutouYmd;
    }

    public BizCurrency getTyokuzenAzukarikin() {
        return tyokuzenAzukarikin;
    }

    public C_ErrorKbn exec(BizDate pCalcStartYmd,
        BizDate pCalcKijyunYmd,
        BizCurrency pAzukariKg,
        C_Tuukasyu pTuukasyu) {

        if (pAzukariKg == null || pAzukariKg.isOptional() ||
            pCalcStartYmd == null || pCalcKijyunYmd == null ||
            pTuukasyu == null || C_Tuukasyu.BLNK.eq(pTuukasyu)) {
            return C_ErrorKbn.ERROR;
        }

        BizCurrency azukariGanrikinWk = pAzukariKg;
        BizCurrency azukarikin = pAzukariKg;
        BizDate tykzenAzukariOutouYmd = pCalcStartYmd;
        int calcKkn = BizDateUtil.calcDifference(pCalcKijyunYmd, pCalcStartYmd).getYears();
        BizDate calcStartYmd = pCalcStartYmd;

        if (pAzukariKg.compareTo(BizCurrency.valueOf(0, pAzukariKg.getType())) > 0) {

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
            tykzenAzukariOutouYmd = setOutoubi.exec(
                C_TykzentykgoKbn.TYKZEN,
                pCalcStartYmd,
                C_Hrkkaisuu.NEN,
                pCalcKijyunYmd);

            for (int index = 0; index <= calcKkn; index++) {

                BizDate calcKijyunYmd = setOutoubi.exec(
                    C_TykzentykgoKbn.TYKGO,
                    pCalcStartYmd,
                    C_Hrkkaisuu.NEN,
                    calcStartYmd);

                if (BizDateUtil.compareYmd(calcKijyunYmd, pCalcKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                    calcKijyunYmd = pCalcKijyunYmd;
                }

                azukarikin = azukariGanrikinWk;

                BizNumber azukaririritu = getAzukariRiritu(calcStartYmd, calcKijyunYmd, pTuukasyu);

                if (azukaririritu == null) {
                    return C_ErrorKbn.ERROR;
                }
                azukariGanrikinWk =
                    azukariGanrikinWk.multiply(
                        BizNumber.ONE.add(azukaririritu)).toValidValue(RoundingMode.DOWN);

                calcStartYmd = calcKijyunYmd;

            }
        }

        tyokuzenAzukariOutouYmd = tykzenAzukariOutouYmd;

        tyokuzenAzukarikin = azukarikin;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
            azukariGanrikinYen = azukariGanrikinWk;
        }
        else {
            azukariGanrikin = azukariGanrikinWk;
        }

        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn exec(String pSyono,
        BizDate pCalcKijyunYmd,
        C_Tuukasyu pKyktuukasyu) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKyktuukasyu);

        List<IT_Azukarikin> azukariRirituList =
            hozenDomManager.getAzukarikinsBySyono(pSyono);

        if (azukariRirituList.size() == 0) {
            azukariGanrikin = BizCurrency.valueOf(0, currencyType);
            azukariGanrikinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            return C_ErrorKbn.OK;
        }

        BizCurrency wkAzukariGanrikinKyktuuka = BizCurrency.valueOf(0, currencyType);
        BizCurrency wkAzukariGanrikinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        for (IT_Azukarikin azukariRiritu : azukariRirituList) {
            azukariGanrikin = BizCurrency.valueOf(0, currencyType);
            azukariGanrikinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            C_ErrorKbn errorKbn =
                exec(azukariRiritu.getAzukarikinhsiymd(), pCalcKijyunYmd,
                    azukariRiritu.getAzukarikingk(), azukariRiritu.getTuukasyu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                return C_ErrorKbn.ERROR;
            }

            if (C_Tuukasyu.JPY.eq(azukariRiritu.getTuukasyu())){
                wkAzukariGanrikinYen = wkAzukariGanrikinYen.add(azukariGanrikinYen);
            }
            else {
                wkAzukariGanrikinKyktuuka = wkAzukariGanrikinKyktuuka.add(azukariGanrikin);
            }
        }

        azukariGanrikin = wkAzukariGanrikinKyktuuka;
        azukariGanrikinYen = wkAzukariGanrikinYen;

        return C_ErrorKbn.OK;

    }

    private BizNumber getAzukariRiritu(
        BizDate pCalcStartYmd,
        BizDate pCalcKijyunYmd,
        C_Tuukasyu pTuukasyu) {
        BizNumber azukaririritu = BizNumber.ZERO;

        if (BizDateUtil.compareYmd(pCalcStartYmd, pCalcKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {
            return azukaririritu;
        }

        if (BizDateUtil.compareYmd(pCalcStartYmd, pCalcKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
            return null;
        }

        BizDate calcKijyunYmd = pCalcKijyunYmd.addDays(-1);

        List<BM_AzukariRiritu> azukariRirituList =
            keisanAzukariGanrikinDao.getAzukariRirituByPK(pTuukasyu, pCalcStartYmd, calcKijyunYmd);

        if (azukariRirituList.size() == 0) {
            return null;
        }

        if (BizDateUtil.compareYmd(pCalcStartYmd,
            azukariRirituList.get(0).getTkyfromymd()) == BizDateUtil.COMPARE_LESSER) {
            return null;
        }

        BizNumber hiwarimotorrt = BizNumber.ZERO;
        BizNumber kknmaxrrt = BizNumber.ZERO;
        int keikanisuu = 0;
        BizDate tkyfromymd = pCalcStartYmd;
        BizDate tkytoymd = calcKijyunYmd;

        for (BM_AzukariRiritu azukariRiritu : azukariRirituList) {

            if (kknmaxrrt.compareTo(azukariRiritu.getAzukaririritu()) < 0) {
                kknmaxrrt = azukariRiritu.getAzukaririritu();
            }

            keikanisuu = 0;

            tkyfromymd = azukariRiritu.getTkyfromymd();

            if (BizDateUtil.compareYmd(pCalcStartYmd, tkyfromymd) == BizDateUtil.COMPARE_GREATER) {
                tkyfromymd = pCalcStartYmd;
            }

            tkytoymd = azukariRiritu.getTkytoymd();

            if (BizDateUtil.compareYmd(calcKijyunYmd, tkytoymd) == BizDateUtil.COMPARE_LESSER) {
                tkytoymd = calcKijyunYmd;
            }

            keikanisuu = BizDateUtil.calcDifferenceDays(tkytoymd, tkyfromymd) + 1;

            hiwarimotorrt = azukariRiritu.getAzukaririritu().multiply(keikanisuu).add(hiwarimotorrt);

            logger.debug("預り利率 　　: " + azukariRiritu.getAzukaririritu());
            logger.debug("適用日（自） : " + azukariRiritu.getTkyfromymd());
            logger.debug("適用日（至） : " + azukariRiritu.getTkytoymd());
            logger.debug("経過日数 　　: " + keikanisuu);
        }

        azukaririritu = hiwarimotorrt.divide(365, 10, RoundingMode.DOWN);

        if (kknmaxrrt.compareTo(azukaririritu) < 0) {
            azukaririritu = kknmaxrrt;
        }

        return azukaririritu;
    }
}