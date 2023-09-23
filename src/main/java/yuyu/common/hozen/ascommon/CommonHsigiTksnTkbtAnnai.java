package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_BnktAnnaiHouhouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * 契約保全 案内収納共通 被災害特伸特別案内共通処理
 */
public class CommonHsigiTksnTkbtAnnai {

    private Integer jyuutouTukisuu;

    private Integer jyuutouNensuu;

    private Integer annaiRecordCount;

    @Inject
    private static Logger logger;

    public List<HsigiTksnTkbtAnnaiBean> exec(BizDateYM pSyoriYm, BizDateYM pSyuHaraimanYm, BizDateYM pJkipjytYm,
        C_Hrkkaisuu pHrkkaisuu, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn, C_HsigiTkbtTaiouSyuruiKbn pHsigiTkbtTaiouSyuruiKbn,
        C_BnktAnnaiHouhouKbn pBnktAnnaiHouhouKbn, BizDateYM pBnktAnnaiendYm) {

        logger.debug("▽ 被災害特伸特別案内共通処理 開始");

        BizDateYM annaiKinjinYm;

        if (BizDateUtil.compareYm(pSyoriYm, pSyuHaraimanYm) == BizDateUtil.COMPARE_GREATER) {
            annaiKinjinYm = pSyuHaraimanYm;
        }
        else {
            annaiKinjinYm = pSyoriYm;
        }

        int annaiTaisyoukkn = annaiKinjinYm.subtractMonths(pJkipjytYm);
        annaiRecordCount = 0;
        jyuutouTukisuu = 0;
        jyuutouNensuu = 0;
        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = new ArrayList<>();
        HsigiTksnTkbtAnnaiBean hsigiTksnTkbtAnnaiBean = null;

        if (C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1.eq(pHsigiTkbtTaiouSyuruiKbn)) {

            if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {

                if (C_TkiktbrisyuruiKbn.BLNK.eq(pTkiktbrisyuruiKbn) ||
                    C_TkiktbrisyuruiKbn.NONE.eq(pTkiktbrisyuruiKbn)) {

                    execByBnktAnnai(
                        pBnktAnnaiHouhouKbn,
                        pBnktAnnaiendYm,
                        pSyoriYm,
                        pSyuHaraimanYm,
                        pJkipjytYm,
                        annaiTaisyoukkn);
                }
                else {
                    jyuutouTukisuu = Integer.valueOf(pTkiktbrisyuruiKbn.getValue());
                    annaiRecordCount = 1;
                }
            }
            else if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {
                jyuutouNensuu = 1;
                annaiRecordCount = 1;
            }
            else if (C_Hrkkaisuu.HALFY.eq(pHrkkaisuu)) {
                jyuutouTukisuu = Integer.valueOf(pHrkkaisuu.getValue());
                annaiRecordCount = 1;
            }
        }

        for (int i = 0; i < annaiRecordCount; i++) {

            hsigiTksnTkbtAnnaiBean = SWAKInjector.getInstance(HsigiTksnTkbtAnnaiBean.class);

            hsigiTksnTkbtAnnaiBean.setJyuutoutukisuu(jyuutouTukisuu);
            hsigiTksnTkbtAnnaiBean.setJyuutounensuu(jyuutouNensuu);

            hsigiTksnTkbtAnnaiBeanLst.add(hsigiTksnTkbtAnnaiBean);
        }

        logger.debug("△ 被災害特伸特別案内共通処理 終了");

        return hsigiTksnTkbtAnnaiBeanLst;
    }

    private void execByBnktAnnai(C_BnktAnnaiHouhouKbn pBnktAnnaiHouhouKbn, BizDateYM pBnktAnnaiendYm,
        BizDateYM pSyoriYm, BizDateYM pSyuHaraimanYm, BizDateYM pJkipjytYm, Integer pAnnaiTaisyoukkn ) {

        if (C_BnktAnnaiHouhouKbn.IKKATU.eq(pBnktAnnaiHouhouKbn)) {

            if (pAnnaiTaisyoukkn == 0) {
                jyuutouTukisuu = 1;
                annaiRecordCount = 1;
            }
            else {
                jyuutouTukisuu = pAnnaiTaisyoukkn;
                annaiRecordCount = 1;
            }
        }
        else if (C_BnktAnnaiHouhouKbn.BUNKATU1P.eq(pBnktAnnaiHouhouKbn)) {

            if (BizDateUtil.compareYm(pBnktAnnaiendYm, pSyoriYm) == BizDateUtil.COMPARE_EQUAL) {
                if (pAnnaiTaisyoukkn == 0) {
                    jyuutouTukisuu = 1;
                    annaiRecordCount = 1;
                }
                else {
                    jyuutouTukisuu = pAnnaiTaisyoukkn;
                    annaiRecordCount = 1;
                }
            }
            else {
                jyuutouTukisuu = 1;
                annaiRecordCount = 1;
            }
        }
        else if (C_BnktAnnaiHouhouKbn.BUNKATU2P.eq(pBnktAnnaiHouhouKbn)) {

            if (BizDateUtil.compareYm(pJkipjytYm, pSyuHaraimanYm.getPreviousMonth()) == BizDateUtil.COMPARE_EQUAL) {
                jyuutouTukisuu = 1;
                annaiRecordCount = 1;
            }
            else if (BizDateUtil.compareYm(pBnktAnnaiendYm, pSyoriYm) == BizDateUtil.COMPARE_EQUAL) {

                if (pAnnaiTaisyoukkn == 0) {
                    jyuutouTukisuu = 1;
                    annaiRecordCount = 1;
                }
                else if (pAnnaiTaisyoukkn <= 2) {
                    jyuutouTukisuu = 1;
                    annaiRecordCount = 2;
                }
                else {
                    jyuutouTukisuu = pAnnaiTaisyoukkn;
                    annaiRecordCount = 1;
                }
            }
            else {
                if (pAnnaiTaisyoukkn == 0) {
                    jyuutouTukisuu = 1;
                    annaiRecordCount = 1;
                }
                else {
                    jyuutouTukisuu = 1;
                    annaiRecordCount = 2;
                }
            }
        }
    }
}
