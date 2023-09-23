package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 配当 配当支払チェック（死亡）
 */
public class CheckDShrSibou extends CheckDShr{

    private C_SyorikahiKbn syorikahiKbn;

    private C_UmuKbn dHuseigouUmu;

    private C_UmuKbn mihaneiDUmu;

    private HozenDomManager hozenDomManager;

    @Inject
    private static Logger logger;

    public CheckDShrSibou() {
        super();
    }

    public C_ErrorKbn checkDShr(String pSyono, BizDate pCalcKijyunYmd, BizDate pSyoriYmd) {

        logger.debug("▽ 配当支払チェック 開始");

        init();
        C_ErrorKbn errorKbn = null;

        if (BizUtil.isBlank(pSyono) || pCalcKijyunYmd == null || pSyoriYmd == null) {

            errorKbn =  C_ErrorKbn.ERROR;

            setErrorInfo("001");

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }

        hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (BizDateUtil.compareYmd(pCalcKijyunYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            syorikahiKbn = C_SyorikahiKbn.SYORIKANOU;

            errorKbn =  C_ErrorKbn.OK;

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
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
            pCalcKijyunYmd,
            kykSyouhn.getKykymd(),
            kykSyouhn.getYendthnkymd(),
            kykKihon.getHaitounendo());

        if (umuKbn == null) {

            errorKbn =  C_ErrorKbn.ERROR;

            super.setErrorLink(checkDJyoutai);

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

        if (C_UmuKbn.ARI.eq(dHuseigouUmu) || C_UmuKbn.ARI.eq(mihaneiDUmu) || C_UmuKbn.ARI.eq(getDShrYmdUmu())) {

            syorikahiKbn = C_SyorikahiKbn.SYORIHUKA;
        }
        else {
            syorikahiKbn = C_SyorikahiKbn.SYORIKANOU;
        }

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 配当支払チェック 終了");

        return errorKbn;
    }

    private void init() {

        clear();
        super.initCheckDShr();
        syorikahiKbn = null;
        dHuseigouUmu = null;
        mihaneiDUmu = null;
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
}
