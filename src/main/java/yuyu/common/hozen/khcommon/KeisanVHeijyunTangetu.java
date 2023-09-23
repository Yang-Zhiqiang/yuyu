package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.MathUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * 契約保全 契約保全共通 単月平準払用保険料積立金計算
 */
public class KeisanVHeijyunTangetu {

    private BizDateYM tumitateYM;

    private BizCurrency tmttKngk;

    private BizCurrency vTyouseimae;

    private BizCurrency kiharaikomiPSoutougk;

    private BizNumber yoteiSinkeiyakuhiritu;

    private BizNumber yoteiIjihirituPhirei;

    private BizNumber yoteiIjihirituVhirei;

    private BizNumber yoteiSyuukinhiritu;

    private BizNumber kougakuWaribikiritu;

    @Inject
    private static Logger logger;

    public KeisanVHeijyunTangetu() {
        super();
    }

    public BizDateYM getTumitateYM() {
        return tumitateYM;
    }

    public BizCurrency getV() {
        return tmttKngk;
    }

    public BizCurrency getVTyouseimae() {
        return vTyouseimae;
    }

    public BizCurrency getKiharaikomiPSoutougk() {
        return kiharaikomiPSoutougk;
    }

    public BizNumber getYoteiSinkeiyakuhiritu() {
        return yoteiSinkeiyakuhiritu;
    }

    public BizNumber getYoteiIjihirituPhirei() {
        return yoteiIjihirituPhirei;
    }

    public BizNumber getYoteiIjihirituVhirei() {
        return yoteiIjihirituVhirei;
    }

    public BizNumber getYoteiSyuukinhiritu() {
        return yoteiSyuukinhiritu;
    }

    public BizNumber getKougakuWaribikiritu() {
        return kougakuWaribikiritu;
    }

    public C_ErrorKbn exec(BizDateYM pCalckijyunym,
        BizDate pKykymd,
        BizCurrency pPYen,
        BizCurrency pPkyktuuka,
        Integer pHhknnen,
        Integer pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        BizNumber pYoteiriritu,
        BizNumber pZeitaisibouritu,
        BizNumber pSoudaisibouritu,
        BizNumber pSoudaikaiyakuritu,
        BizCurrency pCalcKaisiymjitenPtumitatekin,
        BizCurrency pCalcKaisiymjitenKihrkPsoutougk) {

        logger.debug("▽ 単月平準払用保険料積立金計算 開始");

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;


        if (pCalckijyunym == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pKykymd == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pPYen == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pPkyktuuka == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pHrkkknsmnkbn == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pYoteiriritu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pZeitaisibouritu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pSoudaisibouritu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pSoudaikaiyakuritu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

            logger.debug("△ 単月平準払用保険料積立金計算 終了");

            return kekkakbn;
        }

        int hrkkkn = 0;
        if (C_HrkkknsmnKbn.SAIMANKI.eq(pHrkkknsmnkbn)) {

            hrkkkn = pHrkkkn - pHhknnen;
        }

        else if (C_HrkkknsmnKbn.NENMANKI.eq(pHrkkknsmnkbn)) {

            hrkkkn = pHrkkkn;
        }

        BizDateYM hrkmanryouym = pKykymd.getBizDateYM().addYears(hrkkkn);

        BizCurrency pTmttknJyuutoubun = BizCurrency.valueOf(0);
        BizCurrency kihrkPSoutougk = pCalcKaisiymjitenKihrkPsoutougk;

        KeisanPJyuutougk keisanPJyuutougk = SWAKInjector.getInstance(KeisanPJyuutougk.class);

        if (BizDateUtil.compareYm(hrkmanryouym, pCalckijyunym) == BizDateUtil.COMPARE_GREATER) {

            C_ErrorKbn errorKbn = keisanPJyuutougk.exec(pPkyktuuka, pPYen, pHhknnen, pHrkkkn,
                pHrkkknsmnkbn, pKykymd, pCalckijyunym);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                logger.debug("△ 単月平準払用保険料積立金計算 終了");

                return C_ErrorKbn.ERROR;
            }

            pTmttknJyuutoubun = keisanPJyuutougk.getPJyuutougk();

            kihrkPSoutougk = pCalcKaisiymjitenKihrkPsoutougk.add(pPkyktuuka);
        }

        int keikamon = BizDateUtil.calcDifferenceMonths(pCalckijyunym, pKykymd.getBizDateYM());
        int keikanensuu = keikamon / 12;

        BizNumber ytijihirituVhirei;
        if (keikanensuu < 10) {

            ytijihirituVhirei = BizNumber.valueOf(0.0005).add(BizNumber.valueOf(0.0001).multiply(hrkkkn - 10));

            if (ytijihirituVhirei.compareTo(BizNumber.valueOf(0.003)) > 0) {

                ytijihirituVhirei = BizNumber.valueOf(0.003);
            }
        }

        else {

            ytijihirituVhirei = BizNumber.valueOf(0.0035);
        }

        BizNumber bdBase = BizNumber.ONE.add(pYoteiriritu.subtract(ytijihirituVhirei));
        BizNumber bdExponentMonth = BizNumber.ONE.divide(12, 10, RoundingMode.HALF_UP);
        BizNumber bdExponentHalfMonth = BizNumber.ONE.divide(24, 10, RoundingMode.HALF_UP);
        BizNumber yoteirirituMonth = MathUtil.powDecimal(bdBase, bdExponentMonth, 10, 4);
        BizNumber yoteirirituHalfMonth = MathUtil.powDecimal(bdBase, bdExponentHalfMonth, 10, 4);

        BizCurrency korogasiV = BizCurrency.valueOf(0);
        if (BizDateUtil.compareYm(hrkmanryouym, pCalckijyunym) == BizDateUtil.COMPARE_GREATER) {

            korogasiV = pCalcKaisiymjitenPtumitatekin.add(pTmttknJyuutoubun).multiply(yoteirirituMonth, 10, RoundingMode.HALF_UP);
        }

        else {

            korogasiV = pCalcKaisiymjitenPtumitatekin.multiply(yoteirirituMonth, 10, RoundingMode.HALF_UP);
        }

        BizNumber yoteisTmp = yoteirirituHalfMonth.multiply(pZeitaisibouritu, 10, RoundingMode.HALF_UP);
        BizCurrency yoteiS = kihrkPSoutougk.multiply(yoteisTmp, 10, RoundingMode.HALF_UP);

        BizCurrency pTmttkngkTyouseimae = korogasiV.subtract(yoteiS)
            .divide(BizNumber.ONE.subtract(pZeitaisibouritu), 10, RoundingMode.DOWN).toValidValue(RoundingMode.DOWN);

        BizCurrency pTmttkngk = BizCurrency.valueOf(0);
        if (BizDateUtil.compareYm(hrkmanryouym, pCalckijyunym) == BizDateUtil.COMPARE_GREATER) {
            if (pTmttkngkTyouseimae.compareTo(kihrkPSoutougk) <= 0) {

                pTmttkngk = pTmttkngkTyouseimae;
            }

            else {

                yoteisTmp = pSoudaisibouritu.add(pSoudaikaiyakuritu).multiply(yoteirirituHalfMonth, 10, RoundingMode.HALF_UP);

                yoteiS = kihrkPSoutougk.multiply(yoteisTmp, 10, RoundingMode.HALF_UP);

                pTmttkngk = korogasiV.subtract(yoteiS).divide(
                    BizNumber.ONE.subtract(pSoudaisibouritu.add(pSoudaikaiyakuritu)), 10, RoundingMode.DOWN)
                    .toValidValue(RoundingMode.DOWN);
            }
        }

        else {
            if (pTmttkngkTyouseimae.compareTo(kihrkPSoutougk) <= 0) {

                pTmttkngk = pTmttkngkTyouseimae;
            }

            else {

                pTmttkngk = korogasiV.toValidValue(RoundingMode.DOWN);
            }
        }

        tumitateYM = pCalckijyunym.addMonths(1);
        tmttKngk = pTmttkngk;
        vTyouseimae = pTmttkngkTyouseimae;
        kiharaikomiPSoutougk = kihrkPSoutougk;
        yoteiSinkeiyakuhiritu = keisanPJyuutougk.getYoteiSinkeiyakuhiRitu();
        yoteiIjihirituPhirei = keisanPJyuutougk.getYoteiIjihiRitu();
        yoteiIjihirituVhirei = ytijihirituVhirei;
        yoteiSyuukinhiritu = keisanPJyuutougk.getYoteiSyuukinhiRitu();
        kougakuWaribikiritu = keisanPJyuutougk.getKougakuWaribikiRitu();

        logger.debug("△ 単月平準払用保険料積立金計算 終了");

        return kekkakbn;
    }

}
