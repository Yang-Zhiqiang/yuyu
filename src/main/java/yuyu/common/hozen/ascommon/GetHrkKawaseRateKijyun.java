package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * 契約保全 案内収納共通 払込用為替レート基準日取得
 */
public class GetHrkKawaseRateKijyun {

    private BizDate kawaseRateKijyun;

    private List<String> errorCd;

    private String errorRiyuu;

    private String kawaseRateKijyunKbn;

    @Inject
    private static Logger logger;

    public BizDate getKawaseRateKijyun() {
        return kawaseRateKijyun;
    }

    public List<String> getErrorCd() {
        return errorCd;
    }

    public String getErrorRiyuu() {
        return errorRiyuu;
    }

    public String getKawaseRateKijyunKbn() {
        return kawaseRateKijyunKbn;
    }

    public C_ErrorKbn exec(C_NyknaiyouKbn pNyknaiyouKbn,
        C_Nykkeiro pNykkeiro,
        BizDate pRsymd,
        BizDateYM pJyutoustartym,
        Integer pJyuutounensuu,
        Integer pJyuutoutukisuu,
        C_Hrkkaisuu pHrkkaisuu) {

        logger.debug("▽ 払込用為替レート基準日取得 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pNyknaiyouKbn == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 払込用為替レート基準日取得 終了");
            return kekkaKbn;
        }

        if (pRsymd == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 払込用為替レート基準日取得 終了");
            return kekkaKbn;
        }

        if (C_NyknaiyouKbn.SYOKAIP.eq(pNyknaiyouKbn)) {

            if (!C_Nykkeiro.SKEI.eq(pNykkeiro)) {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_NYKKEIRO_CHKERROR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR);

                logger.debug("△ 払込用為替レート基準日取得 終了");
                return kekkaKbn;
            }

            kawaseRateKijyun = pRsymd.addBusinessDays(-1);

            kawaseRateKijyunKbn = KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_ZENEIGYOUBI;
        }
        else if (C_NyknaiyouKbn.ZENNOUP.eq(pNyknaiyouKbn)) {

            kawaseRateKijyun = pRsymd.getBusinessDay(CHolidayAdjustingMode.NEXT);

            kawaseRateKijyunKbn = KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD;
        }
        else if (C_NyknaiyouKbn.KEIZOKUP.eq(pNyknaiyouKbn) || C_NyknaiyouKbn.HARAIHENYOUP.eq(pNyknaiyouKbn)) {

            if (C_NyknaiyouKbn.KEIZOKUP.eq(pNyknaiyouKbn) &&
                (!C_Nykkeiro.CREDIT.eq(pNykkeiro) &&
                    !C_Nykkeiro.BANK.eq(pNykkeiro) &&
                    !C_Nykkeiro.OTHER.eq(pNykkeiro) &&
                    !C_Nykkeiro.KZHRK.eq(pNykkeiro))) {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_NYKKEIRO_CHKERROR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR);

                logger.debug("△ 払込用為替レート基準日取得 終了");

                return kekkaKbn;
            }
            else if (C_NyknaiyouKbn.HARAIHENYOUP.eq(pNyknaiyouKbn) && !C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_HRKKAISUU_CHKERROR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR);

                logger.debug("△ 払込用為替レート基準日取得 終了");

                return kekkaKbn;
            }

            BizDateYM rsyYm = pRsymd.getBizDateYM();

            kawaseRateKijyunKbn = KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY;

            kawaseRateKijyun = pRsymd.getBizDateYM().getPreviousMonth().getLastDay()
                .getBusinessDay(CHolidayAdjustingMode.PREVIOUS);

            if (C_NyknaiyouKbn.KEIZOKUP.eq(pNyknaiyouKbn) && C_Nykkeiro.KZHRK.eq(pNykkeiro)) {

                SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
                setHurikaebi.exec(pRsymd);

                if (BizDateUtil.compareYmd(setHurikaebi.getTyokuzenHurikaebi(), pRsymd) == BizDateUtil.COMPARE_EQUAL) {

                    kawaseRateKijyun = setHurikaebi.getTyokuzenAnnaibi().getBizDateYM().getPreviousMonth().getLastDay()
                        .getBusinessDay(CHolidayAdjustingMode.PREVIOUS);

                    rsyYm = setHurikaebi.getTyokuzenAnnaibi().getBizDateYM();
                }
            }

            if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu) || C_Hrkkaisuu.HALFY.eq(pHrkkaisuu)) {

                if (BizDateUtil.compareYm(pJyutoustartym, rsyYm) == BizDateUtil.COMPARE_GREATER) {

                    kawaseRateKijyun = pRsymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                    kawaseRateKijyunKbn = KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD;
                }
            }
            else if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {

                BizDateYM jyutouendYm = pJyutoustartym.addMonths(pJyuutoutukisuu - 1);

                if (BizDateUtil.compareYm(jyutouendYm, rsyYm) == BizDateUtil.COMPARE_GREATER) {

                    kawaseRateKijyun = pRsymd.getBusinessDay(CHolidayAdjustingMode.NEXT);

                    kawaseRateKijyunKbn = KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD;
                }
            }
            else {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_HRKKAISUU_CHKERROR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR);

                logger.debug("△ 払込用為替レート基準日取得 終了");

                return kekkaKbn;
            }
        }
        else {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_NYKNAIYOUKBN_CHKERROR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_NYKNAIYOUKBN_CHKERROR);
        }

        logger.debug("△ 払込用為替レート基準日取得 終了");

        return kekkaKbn;
    }
}
