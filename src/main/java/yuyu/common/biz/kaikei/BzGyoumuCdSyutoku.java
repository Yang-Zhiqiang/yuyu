package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 業務コード取得
 */
public class BzGyoumuCdSyutoku {

    public final String HENKIN_NYUURYOKU = "RA43";

    public final String KAIYAKU = "RB30";

    public final String GENGAKU = "RB10";

    public final String KEIYAKU_TORIKESI = "RB31";

    public final String SINDANSYORYOU_SIHARAI = "RC06";

    public final String SATEI_SIBOU = "RC05";

    public final String ENDATE_HENKOUJI_HENKANKIN_SIHARAI = "RB75";

    public final String HAITOUKIN_SHR = "RB76";

    public final String KRKTEISEI = "RD36";

    public final String BATCH_KAIYAKU = "RBA2";

    public final String NYKNSYORI = "RDHU";

    public final String PMINYU_SYOUMETU_SYORI = "RDMU";

    public final String D_SEISAN_TUIBARAI = "RBD4";

	/** 被保険者生年月日・性訂正 */
    public final String HHHKNSEIYMD_SEITEISEI = "RB32";

    public final String SYOKITI = "00000";

    @Inject
    private static Logger logger;

    public BzGyoumuCdSyutoku() {
        super();
    }

    public String getDenGyoumuCd(C_ShrhousiteiKbn pShrhousiteiKbn, String pSyoricd, String pSyouhncd,
        Integer pSyouhnsdno, C_Tuukasyu pTuukasyu, C_TantouCdKbn pTantouCd) {

        logger.debug("▽ 伝票用業務コード取得 開始");

        String denGyoumuCd = SYOKITI;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(pShrhousiteiKbn)) {

                if (HENKIN_NYUURYOKU.equals(pSyoricd)) {

                    denGyoumuCd = C_Gyoumucd.GK_YENSOUKIN_SK.getValue();
                }
                else if (KAIYAKU.equals(pSyoricd) || GENGAKU.equals(pSyoricd) || KEIYAKU_TORIKESI.equals(pSyoricd) ||
                    SINDANSYORYOU_SIHARAI.equals(pSyoricd) || SATEI_SIBOU.equals(pSyoricd) ||
                    ENDATE_HENKOUJI_HENKANKIN_SIHARAI.equals(pSyoricd) ||
                    HAITOUKIN_SHR.equals(pSyoricd) || KRKTEISEI.equals(pSyoricd) ||
                    HHHKNSEIYMD_SEITEISEI.equals(pSyoricd)) {

                    denGyoumuCd = C_Gyoumucd.GK_YENSOUKIN_KH_SI.getValue();
                }
            }
            else if (C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(pShrhousiteiKbn)) {

                if (BATCH_KAIYAKU.equals(pSyoricd)) {

                    denGyoumuCd = C_Gyoumucd.GK_YENSOUKIN_DS.getValue();
                }
                else if (NYKNSYORI.equals(pSyoricd)) {

                    denGyoumuCd = C_Gyoumucd.GK_YENSOUKIN_YHRSYMTGNYKN.getValue();
                }
                else if (PMINYU_SYOUMETU_SYORI.equals(pSyoricd)) {

                    denGyoumuCd = C_Gyoumucd.GK_YENSOUKIN_NK_SHR.getValue();
                }
            }
            else if (C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(pShrhousiteiKbn)) {

                if (D_SEISAN_TUIBARAI.equals(pSyoricd)) {

                    if (C_TantouCdKbn.KAIYAKU.eq(pTantouCd)) {

                        denGyoumuCd = C_Gyoumucd.GK_YENSOUKIN_HAITOU_TUIBARAI_KH.getValue();
                    }
                    else if (C_TantouCdKbn.SIBOUTETUZUKI.eq(pTantouCd)) {

                        denGyoumuCd = C_Gyoumucd.GK_YENSOUKIN_HAITOU_TUIBARAI_SI.getValue();
                    }
                }
            }
        }
        else if (C_Tuukasyu.USD.eq(pTuukasyu) || C_Tuukasyu.AUD.eq(pTuukasyu)) {

            if (C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(pShrhousiteiKbn)) {

                if (HENKIN_NYUURYOKU.equals(pSyoricd)) {

                    denGyoumuCd = C_Gkgyoumucd.GK_GKSOUKIN_SK.getValue();
                }
                else if (KAIYAKU.equals(pSyoricd) || GENGAKU.equals(pSyoricd) || KEIYAKU_TORIKESI.equals(pSyoricd) ||
                    SINDANSYORYOU_SIHARAI.equals(pSyoricd) || SATEI_SIBOU.equals(pSyoricd) ||
                    HHHKNSEIYMD_SEITEISEI.equals(pSyoricd)) {

                    denGyoumuCd = C_Gkgyoumucd.GK_GKSOUKIN_KH_SI.getValue();
                }
            }
            else if (C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(pShrhousiteiKbn)) {

                if (D_SEISAN_TUIBARAI.equals(pSyoricd)) {

                    if (C_TantouCdKbn.KAIYAKU.eq(pTantouCd)) {

                        denGyoumuCd = C_Gkgyoumucd.GK_GKSOUKIN_HAITOU_TUIBARAI_KH.getValue();
                    }
                    else if (C_TantouCdKbn.SIBOUTETUZUKI.eq(pTantouCd)) {

                        denGyoumuCd = C_Gkgyoumucd.GK_GKSOUKIN_HAITOU_TUIBARAI_SI.getValue();
                    }
                }
            }
        }

        logger.debug("△ 伝票用業務コード取得 終了");
        return denGyoumuCd;
    }

    public C_Gyoumucd changeYkGyoumuCd(String pDengyoumucd) {

        logger.debug("▽ 円貨業務コード変換 開始");

        C_Gyoumucd gyoumucd = C_Gyoumucd.SETTEI_HUKA;
        if (C_Gyoumucd.BLNK.getValue().equals(pDengyoumucd)) {
            gyoumucd = C_Gyoumucd.BLNK;
        }
        else {
            if (!BizUtil.isBlank(C_Gyoumucd.getContentByValue(pDengyoumucd))) {
                gyoumucd = C_Gyoumucd.valueOf(pDengyoumucd);
            }
        }

        logger.debug("△ 円貨業務コード変換 終了");

        return gyoumucd;
    }

    public C_Gkgyoumucd changeGkGyoumuCd(String pDengyoumucd) {

        logger.debug("▽ 外貨業務コード変換 開始");

        C_Gkgyoumucd gkgyoumucd = C_Gkgyoumucd.SETTEI_HUKA;
        if (C_Gkgyoumucd.BLNK.getValue().equals(pDengyoumucd)) {
            gkgyoumucd = C_Gkgyoumucd.BLNK;
        }
        else {
            if (!BizUtil.isBlank(C_Gkgyoumucd.getContentByValue(pDengyoumucd))) {
                gkgyoumucd = C_Gkgyoumucd.valueOf(pDengyoumucd);
            }
        }

        logger.debug("△ 外貨業務コード変換 終了");

        return gkgyoumucd;
    }

}