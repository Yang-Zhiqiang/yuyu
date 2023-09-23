package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.MathUtil;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 契約保全 共通 円建変更後積立金計算クラス
 */
public class KeisanSisuuRendouNkTmttknYendtHnk {

    public static final int HKNKKN_SYUUSIN = 99;

    @Inject
    private static Logger logger;

    private int keikanensu;

    private int keikatukisu;

    private BizCurrency tumitategk;

    public KeisanSisuuRendouNkTmttknYendtHnk() {
        super();
    }

    public C_ErrorKbn exec(
        BizDate      pCalckijyunYmd,
        BizDateYM    pCalcKijyunYm,
        BizDate      pYendthnkYmd,
        BizDateYM    pYendthnkYm,
        BizDate      pKykYmd,
        Integer      pHknkkn,
        BizCurrency  pKihons,
        BizNumber    pTumitateRiritu) {

        logger.debug("▽ 円建変更後積立金計算 開始");
        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        if (BizDateUtil.compareYmd(pCalckijyunYmd, pYendthnkYmd) == BizDateUtil.COMPARE_LESSER) {

            kekkaKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 円建変更後積立金計算 終了");

            return kekkaKbn;
        }

        BizDate nenkinStartYmdPreday = null;

        if (pHknkkn.compareTo(HKNKKN_SYUUSIN) != 0) {

            BizDate nenkinStartYmd = pKykYmd.addYears(pHknkkn).getRekijyou();

            if (BizDateUtil.compareYmd(pCalckijyunYmd, nenkinStartYmd) == BizDateUtil.COMPARE_GREATER) {

                kekkaKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 円建変更後積立金計算 終了");

                return kekkaKbn;
            }

            nenkinStartYmdPreday = nenkinStartYmd.addDays(-1);
        }

        int keikanensuWk = 0;
        int keikatukisuWk = 0;
        int keikatukisuYendthnkMae = 0;
        int keikatukisuNenkinMae = 0;
        int keikatukisuTukikansan = 0;

        if (pHknkkn.compareTo(HKNKKN_SYUUSIN) != 0) {

            if (BizDateUtil.compareYmd(pCalckijyunYmd, nenkinStartYmdPreday) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pCalckijyunYmd, nenkinStartYmdPreday) == BizDateUtil.COMPARE_GREATER) {

                keikatukisuYendthnkMae = BizDateUtil.calcDifferenceMonths(pYendthnkYm, pKykYmd.getBizDateYM());
                keikatukisuNenkinMae = pHknkkn * 12;
                keikatukisuTukikansan = keikatukisuNenkinMae - keikatukisuYendthnkMae;
            }

            else {

                keikatukisuTukikansan = BizDateUtil.calcDifferenceMonths(pCalcKijyunYm, pYendthnkYmd.getBizDateYM());
            }
        }

        else {

            keikatukisuTukikansan = BizDateUtil.calcDifferenceMonths(pCalcKijyunYm, pYendthnkYmd.getBizDateYM());
        }

        keikanensuWk = keikatukisuTukikansan / 12;

        if (keikanensuWk > 0) {
            keikatukisuWk = keikatukisuTukikansan % 12;
        }
        else {
            keikatukisuWk = keikatukisuTukikansan;
        }

        BizCurrency keisantutakngk = pKihons;

        for (int i = 0; i < keikanensuWk; i++) {
            keisantutakngk = keisantutakngk.multiply(BizNumber.ONE.add(pTumitateRiritu)).toValidValue(RoundingMode.UP);
        }

        BizCurrency tumitategkWk = BizCurrency.valueOf(0);

        if (keikatukisuWk > 0) {
            BizNumber rirituBase = BizNumber.ONE.add(pTumitateRiritu);
            BizNumber exponent = BizNumber.valueOf(keikatukisuWk).divide(12, 10, RoundingMode.HALF_UP);

            tumitategkWk = keisantutakngk.multiply(
                MathUtil.powDecimal(rirituBase, exponent, 10, 4),
                0,
                RoundingMode.UP);
        }
        else {
            tumitategkWk = keisantutakngk;
        }

        keikanensu = keikanensuWk;
        keikatukisu = keikatukisuWk;
        tumitategk = tumitategkWk;

        logger.debug("△ 円建変更後積立金計算 終了");

        return kekkaKbn;
    }

    public int getKeikanensu() {
        return keikanensu;
    }

    public int getKeikatukisu() {
        return keikatukisu;
    }

    public BizCurrency getTumitategk() {
        return tumitategk;
    }
}
