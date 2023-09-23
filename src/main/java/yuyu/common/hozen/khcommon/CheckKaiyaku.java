package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.haitou.CheckDShrKaiyaku;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全共通 解約共通チェック
 */
public class CheckKaiyaku {

    public static final String KINOUBUNRUI_ONLINE = "online";

    public static final String KINOUBUNRUI_BATCH = "batch";

    public static final String KINOUBUNRUI_DRCTSERVICE = "drctservice";

    public static final String GAMENBUNRUI_STARTINPUTCONTENTS = "startinputcontents";

    public static final String GAMENBUNRUI_INPUTKEY = "inputkey";

    public static final String GAMENBUNRUI_INPUTCONTENTS = "inputcontents";

    public static final String GAMENBUNRUI_REFERENCE = "reference";

    public static final String ERRMESSAGECD_CHECKSAKIHIDUKEHENKOU = "3001";

    public static final String ERRMESSAGECD_CHECKKEIYAKUBIMAE = "3002";

    public static final String ERRMESSAGECD_CHECKYENDATEHENKOUGO = "3003";

    public static final String ERRMESSAGECD_CHECKMFHUSEIGOU = "5001";

    public static final String ERRMESSAGECD_CHECKHANNEIHAITOUKIN = "5002";

    public static final String ERRMESSAGECD_CHECKKOURYOKUHASSEIBIGOHAITOUKINSIHARAIBI = "5003";

    public static final String ERRMESSAGECD_CHECKDSHR = "5004";

    public static final String ERRMESSAGECD_CHECKMIHANEITUMITATEKIN = "5005";

    public static final String ERRMESSAGECD_ZENNOUMIJYUUTOU = "5006";

    private String errorMessage = "";

    private String errorMessageCode = "";

    @Inject
    private static Logger logger;

    public CheckKaiyaku() {
        super();
    }

    public C_KaiyakuchkkekkaKbn exec(String pKinouBunrui, String pGamenBunrui, CheckKaiyakuBean pCheckKaiyakuBean) {

        logger.debug("▽ 解約共通チェック 開始");

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkHistory(pKinouBunrui, pGamenBunrui, pCheckKaiyakuBean);

        if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {

            logger.debug("△ 解約共通チェック 終了");

            return kaiyakuchkkekkaKbn;

        }
        kaiyakuchkkekkaKbn = checkKeisanKahi(pKinouBunrui, pGamenBunrui, pCheckKaiyakuBean);

        if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {

            logger.debug("△ 解約共通チェック 終了");

            return kaiyakuchkkekkaKbn;
        }
        logger.debug("△ 解約共通チェック 終了");

        return kaiyakuchkkekkaKbn;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorMessageCode() {
        return errorMessageCode;
    }


    private C_KaiyakuchkkekkaKbn checkHistory(String pKinouBunrui, String pGamenBunrui,
        CheckKaiyakuBean pCheckKaiyakuBean) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_INPUTCONTENTS.equals(pGamenBunrui)) ||
            KINOUBUNRUI_BATCH.equals(pKinouBunrui) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            kaiyakuchkkekkaKbn = checkYendatehenkougo(pKinouBunrui, pCheckKaiyakuBean.getSyoruiukeYmd(),
                pCheckKaiyakuBean.getYendthnkYmd());

            if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {
                return kaiyakuchkkekkaKbn;
            }
        }

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_INPUTCONTENTS.equals(pGamenBunrui)) ||
            KINOUBUNRUI_BATCH.equals(pKinouBunrui) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            kaiyakuchkkekkaKbn = checkSakihidukehenkou(pKinouBunrui, pCheckKaiyakuBean.getSyoruiukeYmd(),
                pCheckKaiyakuBean.getSyukykYmd(), pCheckKaiyakuBean.getKykKihon());

            if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {
                return kaiyakuchkkekkaKbn;
            }
        }

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_INPUTCONTENTS.equals(pGamenBunrui)) ||
            KINOUBUNRUI_BATCH.equals(pKinouBunrui) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            kaiyakuchkkekkaKbn = checkKeiyakubimae(pKinouBunrui, pCheckKaiyakuBean.getSyoruiukeYmd(),
                pCheckKaiyakuBean.getSyukykYmd());

            if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {
                return kaiyakuchkkekkaKbn;
            }
        }
        return kaiyakuchkkekkaKbn;
    }

    private C_KaiyakuchkkekkaKbn checkYendatehenkougo(String pKinouBunrui, BizDate pSyoruiukeYmd,
        BizDate pYendthnkYmd) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = null;

        if (pYendthnkYmd != null &&
            BizDateUtil.compareYmd(pYendthnkYmd, pSyoruiukeYmd) == BizDateUtil.COMPARE_GREATER) {
            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                throw new BizLogicException(MessageId.EIA1022);
            }
            else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {
                errorMessage = MessageUtil.getMessage(MessageId.EIA1022);
                kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                errorMessageCode = ERRMESSAGECD_CHECKYENDATEHENKOUGO;

                return kaiyakuchkkekkaKbn;
            }
        }
        else {
            kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;
        }

        return kaiyakuchkkekkaKbn;
    }

    private C_KaiyakuchkkekkaKbn checkSakihidukehenkou(String pKinouBunrui, BizDate pSyoruiukeYmd,
        BizDate pSyukykYmd, IT_KykKihon pKykKihon) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = null;

        if (BizDateUtil.compareYmd(pSyoruiukeYmd, pSyukykYmd) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pSyoruiukeYmd, pSyukykYmd) == BizDateUtil.COMPARE_EQUAL) {

            List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsByKouryokuhasseiymdGt(pSyoruiukeYmd);

            if (kykSyouhnList.size() > 0) {
                if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                    throw new BizLogicException(MessageId.EIA0106);
                }
                else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {
                    errorMessage = MessageUtil.getMessage(MessageId.EIA0106);
                    kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                    errorMessageCode = ERRMESSAGECD_CHECKSAKIHIDUKEHENKOU;

                    return kaiyakuchkkekkaKbn;
                }
            }
            else {
                kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;
            }
        }
        else {
            kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;
        }

        return kaiyakuchkkekkaKbn;
    }

    private C_KaiyakuchkkekkaKbn checkKeiyakubimae(String pKinouBunrui, BizDate pSyoruiukeYmd,
        BizDate pSyukykYmd) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = null;

        if (BizDateUtil.compareYmd(pSyoruiukeYmd, pSyukykYmd) == BizDateUtil.COMPARE_LESSER) {
            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                throw new BizLogicException(MessageId.EIA0070, "書類受付日");
            }
            else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {
                errorMessage = MessageUtil.getMessage(MessageId.EIA0070, "解約受付日");
                kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                errorMessageCode = ERRMESSAGECD_CHECKKEIYAKUBIMAE;

                return kaiyakuchkkekkaKbn;
            }
        }
        else {
            kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;
        }

        return kaiyakuchkkekkaKbn;
    }

    private C_KaiyakuchkkekkaKbn checkKeisanKahi(String pKinouBunrui, String pGamenBunrui,
        CheckKaiyakuBean pCheckKaiyakuBean) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_INPUTCONTENTS.equals(pGamenBunrui)) ||
            KINOUBUNRUI_BATCH.equals(pKinouBunrui) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            kaiyakuchkkekkaKbn = checkDShr(pKinouBunrui, pCheckKaiyakuBean.getSyoruiukeYmd(),
                pCheckKaiyakuBean.getKykKihon(),pCheckKaiyakuBean.getAnsyuKihon(), pCheckKaiyakuBean.getSyoriYmd());

            if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {
                return kaiyakuchkkekkaKbn;
            }

            kaiyakuchkkekkaKbn = checkTmttkn(pKinouBunrui,
                pCheckKaiyakuBean.getKykKihon(),
                pCheckKaiyakuBean.getSyoruiukeYmd(),
                pCheckKaiyakuBean.getSyukykYmd());

            if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {
                return kaiyakuchkkekkaKbn;
            }

            if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                kaiyakuchkkekkaKbn = checkZennoujyuuto(pKinouBunrui, pCheckKaiyakuBean.getKykKihon(),
                    pCheckKaiyakuBean.getAnsyuKihon(), pCheckKaiyakuBean.getSyoruiukeYmd());

                if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {

                    return kaiyakuchkkekkaKbn;
                }
            }
        }
        return kaiyakuchkkekkaKbn;
    }

    private C_KaiyakuchkkekkaKbn checkDShr(String pKinouBunrui, BizDate pSyoruiukeYmd,
        IT_KykKihon pKykKihon, IT_AnsyuKihon pAnsyuKihon, BizDate pSyoriYmd) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;

        CheckDShrKaiyaku checkDShrKaiyaku = SWAKInjector.getInstance(CheckDShrKaiyaku.class);

        C_YouhiKbn pMinyuuCheckYouhi = null;

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList.size() > 0) {

            IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

            if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                pMinyuuCheckYouhi = C_YouhiKbn.HUYOU;
            }

            else if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhn.getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(kykSyouhn.getKykjyoutai()) ||
                C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

                pMinyuuCheckYouhi = C_YouhiKbn.YOU;
            }
        }

        C_ErrorKbn errorKbn = checkDShrKaiyaku.checkDShr(pKykKihon.getSyono(), pSyoruiukeYmd,
            pAnsyuKihon.getJkipjytym(), pMinyuuCheckYouhi, pSyoriYmd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }
            else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                errorMessage = MessageUtil.getMessage(MessageId.EIF1107);
                kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                errorMessageCode = ERRMESSAGECD_CHECKDSHR;

                return kaiyakuchkkekkaKbn;
            }
        }

        if (C_UmuKbn.ARI.eq(checkDShrKaiyaku.getDHuseigouUmu())) {
            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                throw new BizLogicException(MessageId.EBS1012);
            }
            else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {
                errorMessage = MessageUtil.getMessage(MessageId.EBS1012);
                kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                errorMessageCode = ERRMESSAGECD_CHECKMFHUSEIGOU;

                return kaiyakuchkkekkaKbn;
            }
        }

        if (C_UmuKbn.ARI.eq(checkDShrKaiyaku.getMihaneiDUmu())) {
            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                throw new BizLogicException(MessageId.EBA1048);
            }
            else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {
                errorMessage = MessageUtil.getMessage(MessageId.EBA1048);
                kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                errorMessageCode = ERRMESSAGECD_CHECKHANNEIHAITOUKIN;

                return kaiyakuchkkekkaKbn;
            }
        }

        if (C_UmuKbn.ARI.eq(checkDShrKaiyaku.getDShrYmdUmu())) {
            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                throw new BizLogicException(MessageId.EBA1050, "消滅日");
            }
            else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {
                errorMessage = MessageUtil.getMessage(MessageId.EBA1050, "消滅日");
                kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                errorMessageCode = ERRMESSAGECD_CHECKKOURYOKUHASSEIBIGOHAITOUKINSIHARAIBI;

                return kaiyakuchkkekkaKbn;
            }
        }
        return kaiyakuchkkekkaKbn;
    }

    private C_KaiyakuchkkekkaKbn checkTmttkn(String pKinouBunrui, IT_KykKihon pKykKihon,
        BizDate pHanteiKijyunYmd, BizDate pKykYmd) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

        hanteiTmttknJyoutaiBean.setSyono(pKykKihon.getSyono());
        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(pHanteiKijyunYmd);
        hanteiTmttknJyoutaiBean.setKykymd(pKykYmd);

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {
            if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                    SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
                boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);
                if (!result) {
                    if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                        throw new BizLogicException(MessageId.EBA1052);
                    }
                    else if (KINOUBUNRUI_BATCH.equals(pKinouBunrui) || KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {
                        errorMessage = MessageUtil.getMessage(MessageId.EBA1052);
                        kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;
                        errorMessageCode = ERRMESSAGECD_CHECKMIHANEITUMITATEKIN;

                        return kaiyakuchkkekkaKbn;
                    }
                }
            }
        }
        return kaiyakuchkkekkaKbn;
    }

    private C_KaiyakuchkkekkaKbn checkZennoujyuuto(String pKinouBunrui, IT_KykKihon pKykKihon,
        IT_AnsyuKihon pAnsyuKihon, BizDate pHanteiKijyunYmd) {

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.SEIJYOU;

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BizDate jkiPJytYmd = BizDate.valueOf(pAnsyuKihon.getJkipjytym(), kykSyouhn.getKykymd().getDay()).getRekijyou();

        if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())
            && (BizDateUtil.compareYmd(pHanteiKijyunYmd, jkiPJytYmd) == BizDateUtil.COMPARE_GREATER
            || BizDateUtil.compareYmd(pHanteiKijyunYmd, jkiPJytYmd) == BizDateUtil.COMPARE_EQUAL)) {

            errorMessage = MessageUtil.getMessage(MessageId.EIF1125);

            kaiyakuchkkekkaKbn = C_KaiyakuchkkekkaKbn.ERROR;

            errorMessageCode = ERRMESSAGECD_ZENNOUMIJYUUTOU;

            return kaiyakuchkkekkaKbn;
        }
        return kaiyakuchkkekkaKbn;
    }
}
