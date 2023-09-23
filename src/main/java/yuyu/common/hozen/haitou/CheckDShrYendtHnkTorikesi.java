package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 配当 配当支払チェック（円建変更取消）
 */
public class CheckDShrYendtHnkTorikesi extends CheckDShr{

    private C_SyorikahiKbn syorikahiKbn;

    private C_UmuKbn dHuseigouUmu;

    private HozenDomManager hozenDomManager;

    @Inject
    private static Logger logger;

    public CheckDShrYendtHnkTorikesi() {
        super();
    }

    public C_ErrorKbn checkDShr(String pSyono, BizDate pMkhgktttYmd, BizDate pSyoriYmd) {

        logger.debug("▽ 配当支払チェック 開始");

        init();
        C_ErrorKbn errorKbn = null;

        if (BizUtil.isBlank(pSyono) || pMkhgktttYmd == null || pSyoriYmd == null) {

            errorKbn =  C_ErrorKbn.ERROR;

            setErrorInfo("001");

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }

        hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

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

        if (C_ErrorKbn.ERROR.eq(checkExistsDHaneiYmd(pSyono, kykSyouhn.getYendthnkymd()))) {

            errorKbn =  C_ErrorKbn.ERROR;

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }

        if (C_ErrorKbn.ERROR.eq(checkExistsDShrYmd(pSyono, pMkhgktttYmd))) {

            errorKbn =  C_ErrorKbn.ERROR;

            logger.debug("△ 配当支払チェック 終了");

            return errorKbn;
        }
        dHuseigouUmu = checkDSeigou.getDHuseigouUmu();

        if (C_UmuKbn.ARI.eq(dHuseigouUmu) || C_UmuKbn.ARI.eq(getDHaneiYmdUmu()) || C_UmuKbn.ARI.eq(getDShrYmdUmu())) {

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
    }

    public C_SyorikahiKbn getSyorikahiKbn() {

        return syorikahiKbn;
    }

    public C_UmuKbn getDHuseigouUmu() {

        return dHuseigouUmu;
    }
}
