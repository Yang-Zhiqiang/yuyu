package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.direct.dscommon.dba4dstumitatekinitencheck.DsTumitatekinItenCheckDao;
import yuyu.common.hozen.khcommon.CheckTmttkinIten;
import yuyu.common.hozen.khcommon.CheckTmttkinItenBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsTmttknitenchkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ積立金移転共通チェック
 */
public class DsTumitatekinItenCheck {

    @Inject
    private static Logger logger;

    @Inject
    private DsTumitatekinItenCheckDao dsTumitatekinItenCheckDao;

    public DsTumitatekinItenCheck() {
        super();
    }

    public DsTumitatekinItenCheckResultBean checkTumitatekinIten(String pSyono, BizDate pUktkymd,
        BizDate pTumitatekinitenyoteibi) {

        logger.debug("▽ ＤＳ積立金移転共通チェック 開始");

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector
            .getInstance(DsTumitatekinItenCheckResultBean.class);
        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(C_DsKinouidKbn.DSTUMITATEKINITENUKETUKE.getValue());

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(pSyono);

        checkTmttkinItenBean.setSyoruiukeymd(pUktkymd);
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(pTumitatekinitenyoteibi);
        checkTmttkinItenBean.setKykKihon(kykKihon);

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec(CheckTmttkinIten.KINOUBUNRUI_DRCTSERVICE,
            "", checkTmttkinItenBean);

        String errorMessageCode = checkTmttkinIten.getErrorMessageCode();

        if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

            if (CheckTmttkinIten.ERRMESSAGECD_CHECKTRATKITAISYOUSYOUHN.equals(errorMessageCode)) {

                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(
                    C_DsTmttknitenchkkekkaKbn.TRATKITISYSYOUHN);

                logger.debug("△ ＤＳ積立金移転共通チェック 終了");

                return dsTumitatekinItenCheckResultBean;
            }

            if (CheckTmttkinIten.ERRMESSAGECD_CHECKTMTTKINITENKYKJYOUTAI.equals(errorMessageCode)) {

                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(
                    C_DsTmttknitenchkkekkaKbn.TEIRITUTUMITATE);

                logger.debug("△ ＤＳ積立金移転共通チェック 終了");

                return dsTumitatekinItenCheckResultBean;
            }

            if (CheckTmttkinIten.ERRMESSAGECD_CHECKKEIYAKUBIMAE.equals(errorMessageCode)) {

                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.KYKYMDMITOURAI);

                logger.debug("△ ＤＳ積立金移転共通チェック 終了");

                return dsTumitatekinItenCheckResultBean;
            }

            if (CheckTmttkinIten.ERRMESSAGECD_CHECKLASTHKNNND.equals(errorMessageCode)) {

                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(
                    C_DsTmttknitenchkkekkaKbn.SAISYUUHOKENNENDO);

                logger.debug("△ ＤＳ積立金移転共通チェック 終了");

                return dsTumitatekinItenCheckResultBean;
            }

            if (CheckTmttkinIten.ERRMESSAGECD_CHECKUKETUKEKAISI.equals(errorMessageCode) ||
                CheckTmttkinIten.ERRMESSAGECD_CHECKUKETUKEKIGEN.equals(errorMessageCode)) {

                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.UKTKKKN);

                logger.debug("△ ＤＳ積立金移転共通チェック 終了");

                return dsTumitatekinItenCheckResultBean;
            }
        }

        C_UmuKbn tumitatekinUtSyoruiKbn = checkDsTumitatekinItenUketukeUmu(pSyono);

        if (C_UmuKbn.ARI.eq(tumitatekinUtSyoruiKbn)) {

            dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.TMTTKNITENUKTKUMU);

            logger.debug("△ ＤＳ積立金移転共通チェック 終了");

            return dsTumitatekinItenCheckResultBean;
        }

        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        checkYuukouJyoutaiParam.setSyono(pSyono);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

            dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.HOZENJYOUTAI);

            logger.debug("△ ＤＳ積立金移転共通チェック 終了");

            return dsTumitatekinItenCheckResultBean;
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, pSyono);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.TETUDUKITYUUI);

            logger.debug("△ ＤＳ積立金移転共通チェック 終了");

            return dsTumitatekinItenCheckResultBean;
        }

        dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.OK);
        dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.BLNK);

        logger.debug("△ ＤＳ積立金移転共通チェック 終了");

        return dsTumitatekinItenCheckResultBean;
    }

    public C_UmuKbn checkDsTumitatekinItenUketukeUmu(String pSyono) {

        long khHenkouUktkItem = dsTumitatekinItenCheckDao.getKhHenkouUktkCountBySyonoUktksyorikbnUktkjyoutaikbn(pSyono);

        long khHenkouUktkYykItem = dsTumitatekinItenCheckDao.
            getKhHenkouUktkYykCountBySyonoUktksyorikbnUktkjyoutaikbn(pSyono);

        C_UmuKbn tumitatekinUtSyoruiKbn;

        if (khHenkouUktkItem > 0 || khHenkouUktkYykItem > 0) {

            tumitatekinUtSyoruiKbn = C_UmuKbn.ARI;
        }

        else {
            tumitatekinUtSyoruiKbn = C_UmuKbn.NONE;
        }

        return tumitatekinUtSyoruiKbn;
    }
}
