package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_KawaseRate;

/**
 * 業務共通 共通 為替レート取得
 */
public class GetKawaseRate {

    private BizDate kwsrateKjYmd;

    private BizNumber kawaserate;

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public GetKawaseRate() {
        super();
    }

    public BizDate getKwsrateKjYmd() {
        return kwsrateKjYmd;
    }

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    public C_ErrorKbn exec(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn, C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn, C_KawasetsryKbn pKawasetsryKbn,
        C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {

        logger.debug("▽ 為替レート取得 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pKwsrateKjYmd == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (pKawaserateSyuruiKbn == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (pMototuuka == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (pKanzantuuka == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (pKawaseteKiyoKbn == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (pKawasetsryKbn == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (pEigyoubiHoseiKbn == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if (pZenEigyoubiKsSyutokuYouhi == null) {
            errorKbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            logger.debug("△ 為替レート取得 終了");
            return errorKbn;
        }

        BizDate kwsrateKjymd = null;
        if (pKwsrateKjYmd.isHoliday()) {
            if (C_EigyoubiHoseiKbn.YOKUEIGYOUBI.eq(pEigyoubiHoseiKbn)) {
                kwsrateKjymd = pKwsrateKjYmd.getBusinessDay(CHolidayAdjustingMode.NEXT);
            }
            else if (C_EigyoubiHoseiKbn.ZENEIGYOUBI.eq(pEigyoubiHoseiKbn)) {
                kwsrateKjymd = pKwsrateKjYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
            }
            else if (C_EigyoubiHoseiKbn.BLNK.eq(pEigyoubiHoseiKbn)) {
                kwsrateKjymd = pKwsrateKjYmd;
            }
        } else {
            kwsrateKjymd = pKwsrateKjYmd;
        }

        C_KwsrendouKbn kwsrendouKbn;
        if (C_KawaserateSyuruiKbn.PM17JIKAWASERATE.eq(pKawaserateSyuruiKbn)) {
            kwsrendouKbn = C_KwsrendouKbn.PM17JIKAWASERATE;
        } else {
            if (C_Tuukasyu.USD.eq(pMototuuka)) {
                if (C_Tuukasyu.JPY.eq(pKanzantuuka)) {
                    kwsrendouKbn = C_KwsrendouKbn.KOUJIKAWASERATE1;
                } else {
                    kwsrendouKbn = C_KwsrendouKbn.KOUJIKAWASERATE2;
                }
            } else {
                kwsrendouKbn = C_KwsrendouKbn.KOUJIKAWASERATE2;
            }
        }

        BM_KawaseRate kawaseRate = bizDomManager.getKawaseRate(kwsrateKjymd, kwsrendouKbn, pMototuuka, pKanzantuuka,
            pKawaseteKiyoKbn, pKawasetsryKbn);

        if (kawaseRate != null) {
            kwsrateKjYmd = kwsrateKjymd;
            kawaserate = kawaseRate.getKawaserate();
        } else {
            if (C_YouhiKbn.YOU.eq(pZenEigyoubiKsSyutokuYouhi)) {
                kwsrateKjymd = pKwsrateKjYmd.getPreviousDay().getBusinessDay(CHolidayAdjustingMode.PREVIOUS);

                kawaseRate = bizDomManager.getKawaseRate(kwsrateKjymd, kwsrendouKbn, pMototuuka, pKanzantuuka,
                    pKawaseteKiyoKbn, pKawasetsryKbn);

                if (kawaseRate != null) {
                    kwsrateKjYmd = kwsrateKjymd;
                    kawaserate = kawaseRate.getKawaserate();
                } else {
                    errorKbn = C_ErrorKbn.ERROR;
                }
            } else {
                errorKbn = C_ErrorKbn.ERROR;
            }
        }

        logger.debug("△ 為替レート取得 終了");

        return errorKbn;
    }

    public C_ErrorKbn execFstPNyuukin(BizDate pRyosyuymd, C_Tuukasyu pKyktuuka, C_Tuukasyu pHrktuuka,
        C_YouhiKbn pZenEigyoubiKsSyutokuYouhi, C_Hrkkaisuu pHrkkaisuu, C_SysKbn pSysKbn,
        C_UmuKbn pZennouMousideumu,  C_IkkatubaraiKbn pIkkatubaraiKbn ) {

        BizDate knsnKijyunYmd = null;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = null;

        if (C_Hrkkaisuu.BLNK.eq(pHrkkaisuu)) {
            return C_ErrorKbn.ERROR;
        }
        else if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {
            knsnKijyunYmd = pRyosyuymd;
            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        }

        else {

            if (C_UmuKbn.ARI.eq(pZennouMousideumu)) {

                if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pIkkatubaraiKbn)) {

                    knsnKijyunYmd = pRyosyuymd.getPreviousDay();
                    eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                }

                else {
                    knsnKijyunYmd = pRyosyuymd;
                    eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                }

            }

            else {

                knsnKijyunYmd = pRyosyuymd.getPreviousDay();
                eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
            }

        }

        if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
        }

        return exec(knsnKijyunYmd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE, pKyktuuka, pHrktuuka,
            C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE, eigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);

    }

    public C_ErrorKbn execHyoukagk(BizDate pRyosyuymd, C_Tuukasyu pMototuuka, C_Tuukasyu pKanzantuuka,
        C_YouhiKbn pZenEigyoubiKsSyutokuYouhi, C_Hrkkaisuu pHrkkaisuu,
        C_UmuKbn pZennouMousideumu,  C_IkkatubaraiKbn pIkkatubaraiKbn ) {

        BizDate knsnKijyunYmd = null;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = null;

        if (C_Hrkkaisuu.BLNK.eq(pHrkkaisuu)) {
            return C_ErrorKbn.ERROR;
        }
        else if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {
            knsnKijyunYmd = pRyosyuymd;
            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        }
        else {

            if (C_UmuKbn.ARI.eq(pZennouMousideumu)) {

                if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pIkkatubaraiKbn)) {

                    knsnKijyunYmd = pRyosyuymd.getPreviousDay();
                    eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                }

                else {
                    knsnKijyunYmd = pRyosyuymd;
                    eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                }

            }

            else {

                knsnKijyunYmd = pRyosyuymd.getPreviousDay();
                eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
            }

        }

        return exec(knsnKijyunYmd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE, pMototuuka, pKanzantuuka,
            C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE, eigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);

    }

}
