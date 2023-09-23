package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 配当 配当支払チェック（配当金支払）
 */
public class CheckDShrDShr extends CheckDShr{

    private C_SyorikahiKbn syorikahiKbn;

    private C_UmuKbn dHuseigouUmu;

    private C_UmuKbn mihaneiDUmu;

    private C_UmuKbn dShrTaisyouUmu;

    private C_UmuKbn sakihidukeTumitateDKanriUmu;

    private C_TumitateDSakuseiKbn tumitatedSksKbn;

    private C_UmuKbn tounendoDUmu;

    private HozenDomManager hozenDomManager;

    @Inject
    private static Logger logger;

    public CheckDShrDShr() {
        super();
    }

    public C_ErrorKbn checkDShr(String pSyono, BizDate pCalcKijyunYmd, BizDateYM pJkipjytYm,
        C_YouhiKbn pPMinyuuCheckYouhi, BizDate pSyoriYmd) {

        logger.debug("▽ 配当支払チェック 開始");

        init();
        C_ErrorKbn errorKbn = null;

        if (BizUtil.isBlank(pSyono) || pCalcKijyunYmd == null || pPMinyuuCheckYouhi == null ||
            pSyoriYmd == null || (C_YouhiKbn.YOU.eq(pPMinyuuCheckYouhi) && pJkipjytYm == null)) {

            errorKbn =  C_ErrorKbn.ERROR;

            setErrorInfo("001");

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }

        hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BizDate calcKijyunYmdHoseigo = null;
        if (C_YouhiKbn.YOU.eq(pPMinyuuCheckYouhi)) {
            if (BizDateUtil.compareYmd(pCalcKijyunYmd, BizDate.valueOf(pJkipjytYm, kykSyouhn.getKykymd().getDay())
                .getRekijyou()) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYmd(pCalcKijyunYmd, BizDate.valueOf(pJkipjytYm, kykSyouhn.getKykymd().getDay())
                    .getRekijyou()) == BizDateUtil.COMPARE_EQUAL) {
                calcKijyunYmdHoseigo = pCalcKijyunYmd;
            }
            else {
                calcKijyunYmdHoseigo = BizDate.valueOf(pJkipjytYm, kykSyouhn.getKykymd().getDay()).getRekijyou();

            }
        }
        else {
            calcKijyunYmdHoseigo = pCalcKijyunYmd;
        }

        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);

        C_ErrorKbn dSeigouErrorKbn = checkDSeigou.exec(
            pSyono,
            kykKihon.getHaitounendo(),
            kykSyouhn.getKykymd(),
            kykSyouhn.getYendthnkymd(),
            pSyoriYmd);

        if (C_ErrorKbn.ERROR.eq(dSeigouErrorKbn)) {

            errorKbn =  C_ErrorKbn.ERROR;

            super.setErrorLink(checkDSeigou);

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }

        CheckDJyoutai checkDJyoutai = SWAKInjector.getInstance(CheckDJyoutai.class);

        C_UmuKbn umuKbn = checkDJyoutai.execForMibaraiHaitouHantei(
            calcKijyunYmdHoseigo,
            kykSyouhn.getKykymd(),
            kykSyouhn.getYendthnkymd(),
            kykKihon.getHaitounendo());

        if (umuKbn == null) {

            errorKbn =  C_ErrorKbn.ERROR;

            super.setErrorLink(checkDJyoutai);

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }

        if (C_ErrorKbn.ERROR.eq(checkExistsDHaneiYmd(pSyono, calcKijyunYmdHoseigo))) {

            errorKbn =  C_ErrorKbn.ERROR;

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }

        if (C_ErrorKbn.ERROR.eq(checkExistsDShrYmd(pSyono, pCalcKijyunYmd))) {

            errorKbn =  C_ErrorKbn.ERROR;

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }
        dHuseigouUmu = checkDSeigou.getDHuseigouUmu();
        mihaneiDUmu = umuKbn;

        if (C_UmuKbn.ARI.eq(dHuseigouUmu) || C_UmuKbn.ARI.eq(mihaneiDUmu) || C_UmuKbn.ARI.eq(getDHaneiYmdUmu()) ||
            C_UmuKbn.ARI.eq(getDShrYmdUmu())) {

            syorikahiKbn = C_SyorikahiKbn.SYORIHUKA;
        }
        else {
            syorikahiKbn = C_SyorikahiKbn.SYORIKANOU;
        }

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 配当支払チェック 終了");

        return errorKbn;
    }

    public C_ErrorKbn checkExistsDShrTaisyou(String pSyono) {

        logger.debug("▽ 配当支払対象存在チェック 開始");
        init();
        C_ErrorKbn errorKbn = null;

        if (BizUtil.isBlank(pSyono)) {

            errorKbn =  C_ErrorKbn.ERROR;

            setErrorInfo("001");

            logger.debug("△ 配当支払対象存在チェック 終了");

            return errorKbn;
        }

        DBAccessDCommon dBAccessDCommon =  SWAKInjector.getInstance(DBAccessDCommon.class);

        if (C_ErrorKbn.ERROR.eq(dBAccessDCommon.getSaisinTumitateDKanri(pSyono))) {

            errorKbn =  C_ErrorKbn.ERROR;

            super.setErrorLink(dBAccessDCommon);

            logger.debug("△ 配当支払対象存在チェック 終了");

            return errorKbn;
        }

        if (dBAccessDCommon.getKhTumitateDKanri() == null) {

            dShrTaisyouUmu = C_UmuKbn.NONE;
        }
        else {
            if (dBAccessDCommon.getKhTumitateDKanri().getTumitated().compareTo(
                BizCurrency.valueOf(0, dBAccessDCommon.getKhTumitateDKanri().getTumitated().getType())) <= 0) {

                dShrTaisyouUmu = C_UmuKbn.NONE;
            }
            else {
                dShrTaisyouUmu = C_UmuKbn.ARI;
            }
        }

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 配当支払対象存在チェック 終了");
        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn checkSakihidukeTumitateDKanriUmu(String pSyono, BizDate pCalcKijyunYmd) {

        logger.debug("▽ 先日付積立Ｄ管理情報有無チェック 開始");

        init();
        C_ErrorKbn errorKbn = null;

        if (BizUtil.isBlank(pSyono) || pCalcKijyunYmd == null) {

            errorKbn =  C_ErrorKbn.ERROR;

            setErrorInfo("001");

            logger.debug("△ 先日付積立Ｄ管理情報有無チェック 終了");

            return errorKbn;
        }

        DBAccessDCommon dBAccessDCommon =  SWAKInjector.getInstance(DBAccessDCommon.class);

        if (C_ErrorKbn.ERROR.eq(dBAccessDCommon.getSaisinTumitateDKanri(pSyono))) {

            errorKbn =  C_ErrorKbn.ERROR;

            super.setErrorLink(dBAccessDCommon);

            logger.debug("△ 先日付積立Ｄ管理情報有無チェック 終了");

            return errorKbn;
        }

        if (dBAccessDCommon.getKhTumitateDKanri() != null &&
            BizDateUtil.compareYmd(dBAccessDCommon.getKhTumitateDKanri().getTumitatedtumitateymd(), pCalcKijyunYmd) == BizDateUtil.COMPARE_GREATER) {

            sakihidukeTumitateDKanriUmu = C_UmuKbn.ARI;
            tumitatedSksKbn = dBAccessDCommon.getKhTumitateDKanri().getTumitatedskskbn();
        }
        else {
            sakihidukeTumitateDKanriUmu = C_UmuKbn.NONE;
        }
        errorKbn = C_ErrorKbn.OK;
        logger.debug("△ 先日付積立Ｄ管理情報有無チェック 終了");
        return errorKbn;
    }

    public C_ErrorKbn checkTounendoDUmu(String pSyono, BizDate pCalcKijyunYmd) {

        logger.debug("▽ 当年度配当有無チェック 開始");

        init();
        C_ErrorKbn errorKbn = null;

        if (BizUtil.isBlank(pSyono) || pCalcKijyunYmd == null) {

            errorKbn =  C_ErrorKbn.ERROR;

            setErrorInfo("001");

            logger.debug("△ 当年度配当有無チェック 終了");

            return errorKbn;
        }

        DBAccessDCommon dBAccessDCommon =  SWAKInjector.getInstance(DBAccessDCommon.class);
        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbns = {C_TumitateDSakuseiKbn.SEISIKI, C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            C_TumitateDSakuseiKbn.RISOKUKURIIRE};

        C_ErrorKbn errKbn = dBAccessDCommon.getTumitateDKanriListTumitatedskskbn(pSyono, tumitateDSakuseiKbns);

        if (C_ErrorKbn.ERROR.eq(errKbn)) {

            errorKbn =  C_ErrorKbn.ERROR;

            super.setErrorLink(dBAccessDCommon);

            logger.debug("△ 当年度配当有無チェック 終了");

            return errorKbn;
        }
        if (dBAccessDCommon.getKhTumitateDKanriList().size() == 0) {

            tounendoDUmu = C_UmuKbn.NONE;
        }
        else {
            BizDate tumitatedtumitateymd = dBAccessDCommon.getKhTumitateDKanriList().get(0).getTumitatedtumitateymd().addYears(1);
            if (BizDateUtil.compareYmd(tumitatedtumitateymd, pCalcKijyunYmd) == BizDateUtil.COMPARE_LESSER) {

                tounendoDUmu = C_UmuKbn.NONE;
            }
            else {
                tounendoDUmu = C_UmuKbn.ARI;
            }
        }
        errorKbn = C_ErrorKbn.OK;
        logger.debug("△ 当年度配当有無チェック 終了");
        return errorKbn;
    }

    private void init() {

        clear();
        super.initCheckDShr();
        syorikahiKbn = null;
        dHuseigouUmu = null;
        mihaneiDUmu = null;
        dShrTaisyouUmu = null;
        sakihidukeTumitateDKanriUmu = null;
        tumitatedSksKbn = null;
        tounendoDUmu = null;
    }

    public C_SyorikahiKbn getSyorikahiKbn() {

        return syorikahiKbn;
    }

    public C_UmuKbn getDHuseigouUmu() {

        return dHuseigouUmu;
    }

    public C_UmuKbn getMihaneiDUmu() {

        return mihaneiDUmu;
    }

    public C_UmuKbn getDShrTaisyouUmu() {

        return dShrTaisyouUmu;
    }

    public C_UmuKbn getSakihidukeTumitateDKanriUmu() {

        return sakihidukeTumitateDKanriUmu;
    }
    public C_TumitateDSakuseiKbn getTumitatedSksKbn() {

        return tumitatedSksKbn;
    }

    public C_UmuKbn getTounendoDUmu() {

        return tounendoDUmu;
    }
}
