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
import yuyu.common.biz.bzcommon.BzGetVrate2;
import yuyu.common.biz.bzcommon.BzGetVrateBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_VRateGetKbn;

/**
 * 契約保全 契約保全共通 保険料積立金計算
 */
public class KeisanV {

    private BizCurrency tumitateKin = null;

    @Inject
    private static Logger logger;

    public KeisanV() {
        super();
    }

    public BizCurrency getV() {
        return tumitateKin;
    }

    public C_ErrorKbn exec(
        BizDate pCalckijyunYmd,
        BizDateYM pCalckijyunYm,
        BizDate pKykymd,
        String pSyouhnCd,
        int pSyouhnsdNo,
        String pRyouritusdNo,
        BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHaraikomiKaisuu,
        C_Hhknsei pHhknSei,
        int pHhknNen,
        C_HknkknsmnKbn pHknKknSmnKbn,
        int pHknkkn,
        C_HrkkknsmnKbn pHrkkknsmnKbn,
        int pHrkkkn,
        BizCurrency pKihonS,
        int pKeikaNensuu,
        int pKkeikaMon,
        C_Tuukasyu pKeiyakuTuukasyu,
        BizCurrency pHokenryou,
        C_TyksenhokanhouKbn pTyksenhokanhouKbn,
        C_Kykjyoutai pKykjyoutai,
        int pDai1hknkkn) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 保険料積立金計算 開始");
        }

        BizDateYM hrkManryouym = null;
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        int dai1hknkkn = 0;

        if (!C_Kykjyoutai.ITIJIBARAI.eq(pKykjyoutai)) {
            if (C_HrkkknsmnKbn.NENMANKI.eq(pHrkkknsmnKbn)) {

                hrkManryouym = pKykymd.getBizDateYM().addYears(pHrkkkn);
            }
            else {

                int hrkkkn = pHrkkkn - pHhknNen;
                hrkManryouym = pKykymd.getBizDateYM().addYears(hrkkkn);
            }

            if (BizDateUtil.compareYm(pCalckijyunYm, hrkManryouym) == BizDateUtil.COMPARE_LESSER) {

                kykJyoutai = C_Kykjyoutai.HRKMTYUU;
            }
            else {

                kykJyoutai = C_Kykjyoutai.HARAIMAN;
            }
        }

        if (!C_Hrkkaisuu.ITIJI.eq(pHaraikomiKaisuu)) {

            dai1hknkkn = pDai1hknkkn;
        }

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
            pSyouhnCd,
            pRyouritusdNo,
            pYoteiRiritu,
            pHaraikomiKaisuu,
            pHhknSei,
            pHhknNen,
            pHknKknSmnKbn,
            pHknkkn,
            pHrkkkn,
            kykJyoutai,
            pKeiyakuTuukasyu,
            dai1hknkkn,
            C_VRateGetKbn.TWOYEARS,
            pKeikaNensuu);

        C_ErrorKbn resultKbn = C_ErrorKbn.OK;

        if (C_ErrorKbn.ERROR.eq(bzGetVrateBean.getErrorKbn())) {

            resultKbn = C_ErrorKbn.ERROR;

            if (logger.isDebugEnabled()) {
                logger.debug("△ 保険料積立金計算 終了");
            }

            return resultKbn;
        }

        BizNumber keikaNensuuVrate = bzGetVrateBean.getVrate().get(0);

        BizNumber keikaNensuuAddVrate = bzGetVrateBean.getVrate().get(1);

        BizCurrency tumitateKinWk = null;
        BizCurrency tumitateKinWk1 = null;

        if (C_TyksenhokanhouKbn.RATE.eq(pTyksenhokanhouKbn)) {

            BizNumber vRate = keikaNensuuVrate.add(keikaNensuuAddVrate.subtract(keikaNensuuVrate).multiply(pKkeikaMon)
                .divide(12, 4, RoundingMode.HALF_UP));

            tumitateKinWk = pKihonS.multiply(vRate).toValidValue();

        }
        else if (C_TyksenhokanhouKbn.JITUGAKU.eq(pTyksenhokanhouKbn)) {

            BizCurrency keikaNensuuV;

            if (pKeikaNensuu == 0) {

                keikaNensuuV = pHokenryou;
            }
            else {

                keikaNensuuV = pKihonS.multiply(keikaNensuuVrate).toValidValue();
            }

            BizCurrency keikaNensuuAddV = pKihonS.multiply(keikaNensuuAddVrate).toValidValue();

            tumitateKinWk1 = (keikaNensuuAddV.subtract(keikaNensuuV).multiply(pKkeikaMon)
                .divide(12, 4, RoundingMode.DOWN)).toValidValue(RoundingMode.HALF_UP);

            tumitateKinWk = keikaNensuuV.add(tumitateKinWk1);
        }

        tumitateKin = tumitateKinWk;

        if (logger.isDebugEnabled()) {
            logger.debug("△ 保険料積立金計算 終了");
        }

        return resultKbn;
    }
}
