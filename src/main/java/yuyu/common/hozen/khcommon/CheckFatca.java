package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FatcatghtkekKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 FATCA対象チェック
 */
public class CheckFatca {

    private List<String> msgIdLst = new ArrayList<>();

    private List<String> msgLst = new ArrayList<>();

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public CheckFatca() {
        super();
    }

    public List<String> getMsgIdList() {
        return msgIdLst;
    }

    public List<String> getMsgList() {
        return msgLst;
    }

    public C_FatcatghtkekKbn exec(C_FatcatgKbn pFatcatgkbn, String pNmkn, BizDate pSeiymd,
            Classification<?> pSeibetu) {

        msgIdLst = new ArrayList<>();
        msgLst   = new ArrayList<>();

        String seionNmkn = BizUtil.editKana(pNmkn);
        C_Seibetu seibetu = getCheckMrInfoSeibetu(pSeibetu);

        List<IT_FatcaInfo> fatcaInfoLst = hozenDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(
                C_FatcakekKbn.TAISYOUGAIHUYOU, seionNmkn, pSeiymd, seibetu);

        C_FatcatghtkekKbn fatcaTghtkekKbn = C_FatcatghtkekKbn.TAISYOUGAI;

        if (fatcaInfoLst != null && fatcaInfoLst.size() > 0) {

            fatcaTghtkekKbn = C_FatcatghtkekKbn.TAISYOU;

            msgIdLst.add(MessageId.WIC0034);

            if (fatcaInfoLst.size() > 1) {
                msgLst.add(MessageUtil.getMessage(MessageId.WIC0034, pFatcatgkbn.getContent(),
                        fatcaInfoLst.get(0).getSyono() + "　他"));
            }
            else {
                msgLst.add(MessageUtil.getMessage(MessageId.WIC0034, pFatcatgkbn.getContent(),
                        fatcaInfoLst.get(0).getSyono()));
            }
        }
        else {
            fatcaTghtkekKbn = C_FatcatghtkekKbn.TAISYOUGAI;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("▽ ＦＡＴＣＡ対象者チェック");
            logger.debug("｜   ＦＡＴＣＡ対象者区分＝" + pFatcatgkbn);
            logger.debug("｜   氏名（カナ）            ＝" + pNmkn);
            logger.debug("｜   生年月日               ＝" + pSeiymd);
            logger.debug("｜   性別                      ＝" + seibetu);
            logger.debug("△ ＦＡＴＣＡ対象者チェック");
        }

        return fatcaTghtkekKbn;
    }

    private C_Seibetu getCheckMrInfoSeibetu(Classification<?> pHnknMaeSeiKbn) {

        C_Seibetu seibetu = C_Seibetu.BLNK;

        if (pHnknMaeSeiKbn instanceof C_Kyksei) {
            if (C_Kyksei.MALE.eq((C_Kyksei) pHnknMaeSeiKbn)) {
                seibetu = C_Seibetu.MALE;
            }
            else if (C_Kyksei.FEMALE.eq((C_Kyksei) pHnknMaeSeiKbn)) {
                seibetu = C_Seibetu.FEMALE;
            }
            else if (C_Kyksei.HJNKYK.eq((C_Kyksei) pHnknMaeSeiKbn)) {
                seibetu = C_Seibetu.HJN;
            }
        }

        if (pHnknMaeSeiKbn instanceof C_Hhknsei) {
            if (C_Hhknsei.MALE.eq((C_Hhknsei) pHnknMaeSeiKbn)) {
                seibetu = C_Seibetu.MALE;
            }
            else if (C_Hhknsei.FEMALE.eq((C_Hhknsei) pHnknMaeSeiKbn)) {
                seibetu = C_Seibetu.FEMALE;
            }
        }
        return seibetu;
    }
}
