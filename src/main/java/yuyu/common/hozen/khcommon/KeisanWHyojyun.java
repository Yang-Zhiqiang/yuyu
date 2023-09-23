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
import yuyu.common.biz.bzcommon.BzGetWrate;
import yuyu.common.biz.bzcommon.BzGetWrateBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_WRateGetKbn;

/**
 * 契約保全 契約保全共通 標準解約返戻金計算
 */
public class KeisanWHyojyun {

    private BizCurrency kaiyakuhr = null;

    private int keikanensuu = 0;

    private int keikatukisuu = 0;

    @Inject
    private static Logger logger;

    public KeisanWHyojyun() {
        super();
    }

    public C_ErrorKbn exec(BizDate pCalckijyunYmd, BizDateYM pCalckijyunYm, KeisanWExtBean pKeisanWExtBean) {

        if (logger.isDebugEnabled()) {

            logger.debug("▽ 標準解約返戻金 開始");
        }


        C_Kykjyoutai kykJyoutai = ｋykJyotaiHantei(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean.getKykymd(),
            pKeisanWExtBean.getHhknnen(), pKeisanWExtBean.getHrkkknsmnkbn(), pKeisanWExtBean.getHrkkkn());

        int keikaNensuuTukikansan = BizDateUtil.calcDifferenceMonths(pCalckijyunYm, pKeisanWExtBean.getKykymd().getBizDateYM());

        int keikaNensuu = keikaNensuuTukikansan / 12;

        int keikaTukisuu = 0;

        if (keikaNensuu > 0) {

            keikaTukisuu = keikaNensuuTukikansan % 12;
        }
        else {

            keikaTukisuu = keikaNensuuTukikansan;
        }

        BizCurrency kaiyakuHr = null;

        if (C_Kykjyoutai.HRKMTYUU.eq(kykJyoutai)) {

            BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

            BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
                pKeisanWExtBean.getSyouhncd(),
                pKeisanWExtBean.getRyouritusdno(),
                pKeisanWExtBean.getYoteiriritu(),
                pKeisanWExtBean.getHrkkaisuu(),
                pKeisanWExtBean.getHhknsei(),
                pKeisanWExtBean.getHhknnen(),
                pKeisanWExtBean.getHknkknsmnkbn(),
                pKeisanWExtBean.getHknkkn(),
                pKeisanWExtBean.getHrkkkn(),
                kykJyoutai,
                pKeisanWExtBean.getTuukasyu(),
                pKeisanWExtBean.getDai1hknkkn(),
                C_WRateGetKbn.TWOYEARS,
                keikaNensuu);

            if (C_ErrorKbn.ERROR.eq(bzGetWrateBean.getErrorKbn())) {

                if (logger.isDebugEnabled()) {

                    logger.debug("△ 標準解約返戻金 終了");
                }

                return C_ErrorKbn.ERROR;
            }

            BizNumber keikaNensuuWrate = bzGetWrateBean.getWrate().get(0);

            BizNumber keikaNensuuAdd1Wrate = bzGetWrateBean.getWrate().get(1);

            BizNumber wrate = keikaNensuuWrate.add(keikaNensuuAdd1Wrate.subtract(keikaNensuuWrate).multiply(keikaTukisuu).divide(12, 4, RoundingMode.HALF_UP));

            kaiyakuHr = pKeisanWExtBean.getKihons().multiply(wrate).toValidValue();

        }
        else {

            KeisanV keisanV = SWAKInjector.getInstance(KeisanV.class);

            C_ErrorKbn keisanVResultKbn = keisanV.exec(
                pCalckijyunYmd,
                pCalckijyunYm,
                pKeisanWExtBean.getKykymd(),
                pKeisanWExtBean.getSyouhncd(),
                pKeisanWExtBean.getSyouhnsdno(),
                pKeisanWExtBean.getRyouritusdno(),
                pKeisanWExtBean.getYoteiriritu(),
                pKeisanWExtBean.getHrkkaisuu(),
                pKeisanWExtBean.getHhknsei(),
                pKeisanWExtBean.getHhknnen(),
                pKeisanWExtBean.getHknkknsmnkbn(),
                pKeisanWExtBean.getHknkkn(),
                pKeisanWExtBean.getHrkkknsmnkbn(),
                pKeisanWExtBean.getHrkkkn(),
                pKeisanWExtBean.getKihons(),
                keikaNensuu,
                keikaTukisuu,
                pKeisanWExtBean.getTuukasyu(),
                pKeisanWExtBean.getHokenryou(),
                C_TyksenhokanhouKbn.RATE,
                kykJyoutai,
                pKeisanWExtBean.getDai1hknkkn());

            if (C_ErrorKbn.ERROR.eq(keisanVResultKbn)) {

                if (logger.isDebugEnabled()) {

                    logger.debug("△ 標準解約返戻金 終了");
                }

                return C_ErrorKbn.ERROR;
            }

            kaiyakuHr = keisanV.getV();
        }

        kaiyakuhr = kaiyakuHr;

        keikanensuu = keikaNensuu;

        keikatukisuu = keikaTukisuu;

        if (logger.isDebugEnabled()) {

            logger.debug("△ 標準解約返戻金 終了");
        }

        return C_ErrorKbn.OK;

    }

    private C_Kykjyoutai ｋykJyotaiHantei(BizDate pCalckijyunYmd, BizDateYM pCalckijyunYm, BizDate pKykymd,
        Integer pHhknnen, C_HrkkknsmnKbn pHknkknsmnkbn, Integer pHrkkkn) {

        Integer hrkkknY = null;

        BizDateYM hrkManryouYm = null;

        BizDate hrkManryouYmd = null;

        if (C_HrkkknsmnKbn.NENMANKI.eq(pHknkknsmnkbn)) {

            hrkkknY = pHrkkkn;
        }
        else {

            hrkkknY = pHrkkkn - pHhknnen;
        }

        hrkManryouYm = pKykymd.getBizDateYM().addYears(hrkkknY);

        hrkManryouYmd = pKykymd.addYears(hrkkknY).getRekijyou();

        if (BizDateUtil.compareYm(pCalckijyunYm, hrkManryouYm) == BizDateUtil.COMPARE_LESSER) {

            return C_Kykjyoutai.HRKMTYUU;
        }
        else if (BizDateUtil.compareYm(pCalckijyunYm, hrkManryouYm) == BizDateUtil.COMPARE_EQUAL &&
            BizDateUtil.compareYmd(pCalckijyunYmd, hrkManryouYmd) == BizDateUtil.COMPARE_LESSER) {

            return C_Kykjyoutai.HRKMTYUU;
        }
        else {

            return C_Kykjyoutai.HARAIMAN;
        }
    }

    public BizCurrency getW() {
        return kaiyakuhr;
    }

    public int getKeikanensuu() {
        return keikanensuu;
    }

    public int getKeikatukisuu() {
        return keikatukisuu;
    }

}
