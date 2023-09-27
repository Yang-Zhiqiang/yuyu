package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.dba4checkdskaiyaku.CheckDsKaiyakuDao;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_DsKaiyakuchkkekkaKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_AnsyuKihon;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ解約共通チェック
 */
public class CheckDsKaiyaku {

    private static final BizCurrency SOUKINJYGNGKYEN = BizCurrency.valueOf(30000000);

    @Inject
    private static Logger logger;

    @Inject
    private CheckDsKaiyakuDao checkDsKaiyakuDao;

    public CheckDsKaiyaku(){
        super();
    }

    public CheckDsKaiyakuResultBean kaiyakukytChk(String pSyoNo, BizDate pKaiyakuYmd, BizCurrency pShrgkkeiYen,
        C_DsSyouhnbunruiKbn pDsSyouhnBunruiKbn) {

        logger.debug("▽ ＤＳ解約共通チェック 開始");

        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = new CheckDsKaiyakuResultBean();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId(C_DsKinouidKbn.DSKAIYAKUUKETUKE.getValue());

        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        checkYuukouJyoutaiParam.setSyono(pSyoNo);

        C_YuukoujyotaichkKbn yuukouJyotaiChkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukouJyotaiChkKbn)) {

            checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HOZENJYOUTAI);
            checkDsKaiyakuResultBean.setMsgPam(checkYuukouJyoutai.getErrorMessage());

            logger.debug("△ ＤＳ解約共通チェック 終了");

            return checkDsKaiyakuResultBean;
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syoriKahiKbn = hanteiTetuduki.exec(khozenCommonParam, pSyoNo);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syoriKahiKbn)) {

            checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.TETUDUKITYUUI);
            checkDsKaiyakuResultBean.setMsgPam(hanteiTetuduki.getMessageParam());

            logger.debug("△ ＤＳ解約共通チェック 終了");

            return checkDsKaiyakuResultBean;
        }

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(pSyoNo);

        if (C_StknsetKbn.ARI.eq(kykKihon.getStknsetkbn())) {

            checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SITIKENSETTEI);
            checkDsKaiyakuResultBean.setMsgPam("");

            logger.debug("△ ＤＳ解約共通チェック 終了");

            return checkDsKaiyakuResultBean;
        }

        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(pSyoNo, C_SyutkKbn.SYU);

        IT_AnsyuKihon ansyuKihon = khozenCommonParam.getAnsyuuKihon(pSyoNo);

        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        CheckKaiyaku checkKaiyaku = SWAKInjector.getInstance(CheckKaiyaku.class);

        checkKaiyakuBean.setSyoruiukeYmd(pKaiyakuYmd);
        checkKaiyakuBean.setSyukykYmd(kykSyouhnLst.get(0).getKykymd());
        checkKaiyakuBean.setYendthnkYmd(kykSyouhnLst.get(0).getYendthnkymd());
        checkKaiyakuBean.setSyoriYmd(BizDate.getSysDate());
        checkKaiyakuBean.setKykKihon(kykKihon);
        checkKaiyakuBean.setAnsyuKihon(ansyuKihon);

        C_KaiyakuchkkekkaKbn kaiyakuChkKekkaKbn = checkKaiyaku.exec(
            CheckKaiyaku.KINOUBUNRUI_DRCTSERVICE, "", checkKaiyakuBean);

        if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuChkKekkaKbn)) {

            String kaiyakuChkKekkaCd = checkKaiyaku.getErrorMessageCode();

            if (CheckKaiyaku.ERRMESSAGECD_CHECKSAKIHIDUKEHENKOU.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SAKIYMDHENKOU);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_CHECKKEIYAKUBIMAE.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.KYKYMDMAE);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_CHECKYENDATEHENKOUGO.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.YENDATEHENKOUMAE);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_CHECKDSHR.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HAITOUKIN);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_CHECKMFHUSEIGOU.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MFHUSEIGOU);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_CHECKHANNEIHAITOUKIN.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MIHANEIHAITOUKIN);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_CHECKKOURYOKUHASSEIBIGOHAITOUKINSIHARAIBI.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HAITOUKINHANEIYMDSONZAI);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_CHECKMIHANEITUMITATEKIN.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MIHANEITUMITATEKIN);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else if (CheckKaiyaku.ERRMESSAGECD_ZENNOUMIJYUUTOU.equals(kaiyakuChkKekkaCd)) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.ZENNOUMIJYUUTOU);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
            else {

                throw new CommonBizAppException("解約共通チェック結果が想定外の値です。");

            }
        }

        if (SOUKINJYGNGKYEN.compareTo(pShrgkkeiYen) < 0) {

            checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SOUKINJYOUGEN);
            checkDsKaiyakuResultBean.setMsgPam("");

            logger.debug("△ ＤＳ解約共通チェック 終了");

            return checkDsKaiyakuResultBean;
        }

        if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

            CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

            boolean syorikekka = checkYuuyokkngai.exec(pSyoNo, pKaiyakuYmd);

            if (!syorikekka) {

                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HARAIKOMIYUYOKIKAN);
                checkDsKaiyakuResultBean.setMsgPam("");

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return checkDsKaiyakuResultBean;
            }
        }

        checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
        checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.BLNK);
        checkDsKaiyakuResultBean.setMsgPam("");

        logger.debug("△ ＤＳ解約共通チェック 終了");

        return checkDsKaiyakuResultBean;
    }

    public C_UmuKbn kaiyakuUkeUmuChk(String pSyoNo) {

        logger.debug("▽ ＤＳ解約共通チェック 開始");

        C_UmuKbn kaiyakuUkeUmu = null;

        Long khHenkouUktkKensuu = checkDsKaiyakuDao.getKhHenkouUktkCountBySyono(pSyoNo);
        Long khHenkouUktkYykKensuu = checkDsKaiyakuDao.getKhHenkouUktkYykCountBySyono(pSyoNo);

        if (khHenkouUktkKensuu == 0 && khHenkouUktkYykKensuu == 0) {

            kaiyakuUkeUmu = C_UmuKbn.NONE;
        }
        else {

            kaiyakuUkeUmu = C_UmuKbn.ARI;
        }

        logger.debug("△ ＤＳ解約共通チェック 終了");

        return kaiyakuUkeUmu;
    }
}
