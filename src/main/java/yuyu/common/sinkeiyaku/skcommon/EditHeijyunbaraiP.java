package yuyu.common.sinkeiyaku.skcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * 新契約 新契約共通 平準払Ｐ編集
 */
public class EditHeijyunbaraiP {

    @Inject
    private static Logger logger;

    private BizCurrency heijyunbaraiP;

    public EditHeijyunbaraiP() {
        super();
    }

    public BizCurrency getHeijyunbaraiP() {
        return heijyunbaraiP;
    }

    public C_ErrorKbn editSouharaiPToHeijyunbaraiP(
        BizCurrency pSouHaraikomiP,
        C_Hrkkaisuu pHrkkaisuu,
        Integer pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        Integer pHhknnen,
        C_HasuusyoriKbn pHasuusyoriKbn) {

        logger.debug("▽ 平準払Ｐ編集 開始");

        if (pSouHaraikomiP == null || pHrkkaisuu == null ||
            pHrkkkn == null || pHrkkknsmnkbn == null ||
            pHhknnen == null || pHasuusyoriKbn == null) {

            logger.debug("△ 平準払Ｐ編集 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_Hrkkaisuu.BLNK.eq(pHrkkaisuu) || C_HrkkknsmnKbn.BLNK.eq(pHrkkknsmnkbn) ||
            C_HasuusyoriKbn.BLNK.eq(pHasuusyoriKbn)) {

            logger.debug("△ 平準払Ｐ編集 終了");

            return C_ErrorKbn.ERROR;
        }
        Integer hrkkknNen = 0;

        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

        C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknNen(pHrkkkn, pHrkkknsmnkbn, pHhknnen);

        if (C_ErrorKbn.OK.eq(errorKbn)) {

            hrkkknNen = convNenSaiManki.getHrkkknNen();

            if ((!C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) && hrkkknNen == 0) {

                logger.debug("△ 平準払Ｐ編集 終了");

                return C_ErrorKbn.ERROR;
            }
        }
        else {
            logger.debug("△ 平準払Ｐ編集 終了");

            return C_ErrorKbn.ERROR;
        }

        RoundingMode roundingMode = RoundingMode.UNNECESSARY;

        if (C_HasuusyoriKbn.AGE.eq(pHasuusyoriKbn)) {
            roundingMode = RoundingMode.UP;
        }
        else if (C_HasuusyoriKbn.SUTE.eq(pHasuusyoriKbn)) {
            roundingMode = RoundingMode.DOWN;
        }
        else if (C_HasuusyoriKbn.SSYGNY.eq(pHasuusyoriKbn)) {
            roundingMode = RoundingMode.HALF_UP;
        }

        int scaleNumber = pSouHaraikomiP.getType().getShiftDigits();

        if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {

            heijyunbaraiP = pSouHaraikomiP.divide(hrkkknNen, scaleNumber, roundingMode).divide(12, scaleNumber, roundingMode);
        }
        else if (C_Hrkkaisuu.HALFY.eq(pHrkkaisuu)) {

            heijyunbaraiP = pSouHaraikomiP.divide(hrkkknNen, scaleNumber, roundingMode).divide(2, scaleNumber, roundingMode);
        }
        else if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {

            heijyunbaraiP = pSouHaraikomiP.divide(hrkkknNen, scaleNumber, roundingMode);
        }
        else {
            heijyunbaraiP = pSouHaraikomiP.toValidValue(roundingMode);
        }

        logger.debug("△ 平準払Ｐ編集 終了");

        return C_ErrorKbn.OK;
    }
}