package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 積立金移転共通チェック
 */
public class CheckTmttkinIten {

    public static final String KINOUBUNRUI_ONLINE = "online";

    public static final String KINOUBUNRUI_DRCTSERVICE = "drctservice";

    public static final String GAMENBUNRUI_INPUTKEY = "inputkey";

    public static final String GAMENBUNRUI_INPUTCONTENTS = "inputcontents";

    public static final String GAMENBUNRUI_REFERENCE = "reference";

    public static final String ERRMESSAGECD_CHECKTMTTKINITENKYKJYOUTAI = "4001";

    public static final String ERRMESSAGECD_GETTABLEINFO = "4002";

    public static final String ERRMESSAGECD_CHECKTRATKITAISYOUSYOUHN = "4003";

    public static final String ERRMESSAGECD_CHECKKEIYAKUBIMAE = "3001";

    public static final String ERRMESSAGECD_CHECKLASTHKNNND = "3002";

    public static final String ERRMESSAGECD_CHECKUKETUKEKAISI = "3003";

    public static final String ERRMESSAGECD_CHECKUKETUKEKIGEN = "3004";

    private String errorMessage = "";

    private String errorMessageCode = "";

    private BizDate kykymd = null;

    @Inject
    private static Logger logger;

    public C_ChkkekkaKbn exec(String pKinouBunrui, String pGamenBunrui, CheckTmttkinItenBean pCheckTmttkinItenBean) {

        logger.debug("▽ 積立金移転共通チェック 開始");

        C_ChkkekkaKbn chkkekkaKbn = checkKykjyoutai(pKinouBunrui, pGamenBunrui, pCheckTmttkinItenBean);

        if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

            logger.debug("△ 積立金移転共通チェック 終了");

            return chkkekkaKbn;

        }

        chkkekkaKbn = checkKikan(pKinouBunrui, pGamenBunrui, pCheckTmttkinItenBean);

        if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

            logger.debug("△ 積立金移転共通チェック 終了");

            return chkkekkaKbn;

        }

        logger.debug("△ 積立金移転共通チェック 終了");

        return chkkekkaKbn;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorMessageCode() {
        return errorMessageCode;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    private C_ChkkekkaKbn checkKykjyoutai(String pKinouBunrui, String pGamenBunrui,
        CheckTmttkinItenBean pCheckTmttkinItenBean) {

        C_ChkkekkaKbn chkkekkaKbn = C_ChkkekkaKbn.SEIJYOU;

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_INPUTKEY.equals(pGamenBunrui)) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            chkkekkaKbn = checkTmttkinItenKykjyoutai(pKinouBunrui, pCheckTmttkinItenBean.getKykKihon());

            if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

                return chkkekkaKbn;
            }
        }

        return chkkekkaKbn;
    }

    private C_ChkkekkaKbn checkKikan(String pKinouBunrui, String pGamenBunrui,
        CheckTmttkinItenBean pCheckTmttkinItenBean) {

        C_ChkkekkaKbn chkkekkaKbn = C_ChkkekkaKbn.SEIJYOU;

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_INPUTCONTENTS.equals(pGamenBunrui)) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            chkkekkaKbn = checkKeiyakubimae(pKinouBunrui, pCheckTmttkinItenBean.getSyoruiukeymd(),
                pCheckTmttkinItenBean.getKykKihon());

            if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

                return chkkekkaKbn;
            }
        }

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_INPUTCONTENTS.equals(pGamenBunrui)) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            chkkekkaKbn = checkLasthknnnd(pKinouBunrui, pCheckTmttkinItenBean.getTmttknitenkbn(),
                pCheckTmttkinItenBean.getTmttknitenymd(),
                pCheckTmttkinItenBean.getKykKihon());

            if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

                return chkkekkaKbn;
            }
        }

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_REFERENCE.equals(pGamenBunrui)) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            chkkekkaKbn = checkUketukekaisi(pKinouBunrui, pCheckTmttkinItenBean.getSyoruiukeymd(),
                pCheckTmttkinItenBean.getTmttknitenymd());

            if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

                return chkkekkaKbn;
            }
        }

        if ((KINOUBUNRUI_ONLINE.equals(pKinouBunrui) && GAMENBUNRUI_REFERENCE.equals(pGamenBunrui)) ||
            KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

            chkkekkaKbn = checkUketukekigen(pKinouBunrui, pCheckTmttkinItenBean.getSyoruiukeymd(),
                pCheckTmttkinItenBean.getTmttknitenymd());

            if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

                return chkkekkaKbn;
            }
        }

        return chkkekkaKbn;
    }

    private C_ChkkekkaKbn checkTmttkinItenKykjyoutai(String pKinouBunrui, IT_KykKihon pKykKihon) {

        C_ChkkekkaKbn chkkekkaKbn = null;

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = null;

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList.size() > 0) {

            kykSyouhn = kykSyouhnList.get(0);

            syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        }

        if (syouhnZokusei == null) {

            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                throw new BizAppException(MessageId.EBS0004, IT_KykSyouhn.TABLE_NAME, IT_KykSyouhn.SYONO,
                    pKykKihon.getSyono());
            }
            else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                errorMessage = MessageUtil.getMessage(MessageId.EBS0004, IT_KykSyouhn.TABLE_NAME, IT_KykSyouhn.SYONO,
                    pKykKihon.getSyono());

                chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                errorMessageCode = ERRMESSAGECD_GETTABLEINFO;

                return chkkekkaKbn;
            }
        }
        else {
            if (C_UmuKbn.NONE.eq(syouhnZokusei.getTmttknhaibunwarisiteiumu())) {

                if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                    throw new BizLogicException(MessageId.EIA1015, "取扱対象外の保険種類");
                }
                else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                    errorMessage = MessageUtil.getMessage(MessageId.EIA1015, "取扱対象外の保険種類");

                    chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                    errorMessageCode = ERRMESSAGECD_CHECKTRATKITAISYOUSYOUHN;

                    return chkkekkaKbn;
                }
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                    throw new BizLogicException(MessageId.EIF1080);
                }
                else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                    errorMessage = MessageUtil.getMessage(MessageId.EIF1080);

                    chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                    errorMessageCode = ERRMESSAGECD_CHECKTMTTKINITENKYKJYOUTAI;

                    return chkkekkaKbn;
                }
            }
            else {

                chkkekkaKbn = C_ChkkekkaKbn.SEIJYOU;

                kykymd = kykSyouhn.getKykymd();
            }
        }

        return chkkekkaKbn;
    }

    private C_ChkkekkaKbn checkKeiyakubimae(String pKinouBunrui, BizDate pSyoruiukeYmd, IT_KykKihon pKykKihon) {

        C_ChkkekkaKbn chkkekkaKbn = null;

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = null;

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList.size() > 0) {

            kykSyouhn = kykSyouhnList.get(0);

            syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        }

        if (syouhnZokusei == null) {

            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                throw new BizAppException(MessageId.EBS0004, IT_KykSyouhn.TABLE_NAME, IT_KykSyouhn.SYONO,
                    pKykKihon.getSyono());
            }
            else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                errorMessage = MessageUtil.getMessage(MessageId.EBS0004, IT_KykSyouhn.TABLE_NAME, IT_KykSyouhn.SYONO,
                    pKykKihon.getSyono());

                chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                errorMessageCode = ERRMESSAGECD_GETTABLEINFO;

                return chkkekkaKbn;
            }
        }
        else {

            if (BizDateUtil.compareYmd(pSyoruiukeYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                    throw new BizLogicException(MessageId.EIA0070, "書類受付日");
                }
                else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                    errorMessage = MessageUtil.getMessage(MessageId.EIA0070, "積立金移転受付日");

                    chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                    errorMessageCode = ERRMESSAGECD_CHECKKEIYAKUBIMAE;

                    return chkkekkaKbn;
                }
            }
            else {

                chkkekkaKbn = C_ChkkekkaKbn.SEIJYOU;
            }
        }

        return chkkekkaKbn;
    }

    private C_ChkkekkaKbn checkLasthknnnd(String pKinouBunrui, C_Tmttknitenkbn pTmttknitenkbn, BizDate pTmttknitenymd,
        IT_KykKihon pKykKihon) {

        C_ChkkekkaKbn chkkekkaKbn = null;

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = null;

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList.size() > 0) {

            kykSyouhn = kykSyouhnList.get(0);

            syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        }

        if (syouhnZokusei == null) {

            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                throw new BizAppException(MessageId.EBS0004, IT_KykSyouhn.TABLE_NAME, IT_KykSyouhn.SYONO,
                    pKykKihon.getSyono());
            }
            else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                errorMessage = MessageUtil.getMessage(MessageId.EBS0004, IT_KykSyouhn.TABLE_NAME, IT_KykSyouhn.SYONO,
                    pKykKihon.getSyono());

                chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                errorMessageCode = ERRMESSAGECD_GETTABLEINFO;

                return chkkekkaKbn;
            }
        }
        else {

            if (C_Tmttknitenkbn.ITEN.eq(pTmttknitenkbn) &&
                BizDateUtil.compareYmd(pTmttknitenymd, kykSyouhn.getHknkknmanryouymd()) == BizDateUtil.COMPARE_EQUAL) {

                if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                    throw new BizLogicException(MessageId.EIA1026, "積立金移転日", "年金開始");
                }
                else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                    errorMessage = MessageUtil.getMessage(MessageId.EIA1026, "積立金移転日", "年金開始");

                    chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                    errorMessageCode = ERRMESSAGECD_CHECKLASTHKNNND;

                    return chkkekkaKbn;
                }
            }
            else {

                chkkekkaKbn = C_ChkkekkaKbn.SEIJYOU;
            }
        }
        return chkkekkaKbn;
    }

    private C_ChkkekkaKbn checkUketukekaisi(String pKinouBunrui, BizDate pSyoruiukeYmd, BizDate pTmttknitenymd) {

        C_ChkkekkaKbn chkkekkaKbn = null;

        BizDate tmttknitenuktkstartYmd = pTmttknitenymd
            .addMonths(YuyuHozenConfig.getInstance().getTmttknItenUkeKaisiTukisuu() * -1).getRekijyou();

        if (BizDateUtil.compareYmd(pSyoruiukeYmd, tmttknitenuktkstartYmd) == BizDateUtil.COMPARE_LESSER) {

            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                throw new BizLogicException(MessageId.EIA1015, "積立金移転の受付可能期間外");
            }
            else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                errorMessage = MessageUtil.getMessage(MessageId.EIA1015, "積立金移転の受付可能期間外");

                chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                errorMessageCode = ERRMESSAGECD_CHECKUKETUKEKAISI;

                return chkkekkaKbn;
            }
        }
        else {

            chkkekkaKbn = C_ChkkekkaKbn.SEIJYOU;
        }

        return chkkekkaKbn;
    }

    private C_ChkkekkaKbn checkUketukekigen(String pKinouBunrui, BizDate pSyoruiukeYmd, BizDate pTmttknitenymd) {

        C_ChkkekkaKbn chkkekkaKbn = null;

        BizDate syoruiuktkkigenYmd = pTmttknitenymd
            .addDays(YuyuHozenConfig.getInstance().getTmttknItenUkeKigenNissuu() * -1);

        if (!syoruiuktkkigenYmd.isBusinessDay()) {

            syoruiuktkkigenYmd = syoruiuktkkigenYmd.addBusinessDays(1);
        }

        if (BizDateUtil.compareYmd(syoruiuktkkigenYmd, pSyoruiukeYmd) == BizDateUtil.COMPARE_LESSER) {

            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {

                throw new BizLogicException(MessageId.EIA1015, "積立金移転の受付可能期間外");
            }
            else if (KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui)) {

                errorMessage = MessageUtil.getMessage(MessageId.EIA1015, "積立金移転の受付可能期間外");

                chkkekkaKbn = C_ChkkekkaKbn.ERROR;

                errorMessageCode = ERRMESSAGECD_CHECKUKETUKEKIGEN;

                return chkkekkaKbn;
            }
        }
        else {

            chkkekkaKbn = C_ChkkekkaKbn.SEIJYOU;
        }

        return chkkekkaKbn;
    }
}
