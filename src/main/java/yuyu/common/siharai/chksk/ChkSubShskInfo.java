package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckTelNo;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 送付先情報チェック
 */
public class ChkSubShskInfo {

    @Inject
    private static Logger logger;

    public ChkSubShskInfo() {
        super();
    }


    public void exec(C_SouhusakiKbn pSouhusakiKbn, String pTsinyNo, String pTsinadr1kj, String pTsinadr2kj, String
            pTsinadr3kj, String pTsintelNo, JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 送付先情報チェック 開始");

        if (C_SouhusakiKbn.TDADD.eq(pSouhusakiKbn)) {
            chkKeiyakuInfoUmu(pSiKykKihon, pChkKekkaBeanLst);
        }
        else {
            chkPostalCd(pTsinyNo, pChkKekkaBeanLst);

            chkAdrKj(pTsinadr1kj, pChkKekkaBeanLst);

            chkTelNo(pTsintelNo, pChkKekkaBeanLst);

            chkAdrKjGoukeiketasuu(pTsinadr1kj, pTsinadr2kj, pTsinadr3kj, pChkKekkaBeanLst);

            chkTelNoYuukou(pTsintelNo, pChkKekkaBeanLst);
        }

        logger.debug("△ 送付先情報チェック 終了");
    }

    private void chkKeiyakuInfoUmu(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pSiKykKihon.getTsinyno())) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TDKDADR_UMUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

    }

    private void chkPostalCd(String pTsinyNo, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pTsinyNo)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.POSTALCD_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

    }

    private void chkAdrKj(String pTsinadr1kj, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pTsinadr1kj)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.ADRKJ_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

    }

    private void chkTelNo(String pTsintelNo, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pTsintelNo)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TELNO_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

    }

    private void chkAdrKjGoukeiketasuu(String pTsinadr1kj, String pTsinadr2kj, String pTsinadr3kj,
            List<ChkKekkaBean> pChkKekkaBeanLst) {

        BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(pTsinadr1kj, pTsinadr2kj, pTsinadr3kj);

        C_JyougenketasuutyoukaKbn jyougenKetasuuTyoukaKbn = bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn();

        if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(jyougenKetasuuTyoukaKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.ADRKJ_KETACHK);
            chkKekkaBean.setMsgHikisuu2(String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()));
            chkKekkaBean.setMsgHikisuu3(String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

    }

    private void chkTelNoYuukou(String pTsintelNo, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (!BizUtil.isBlank(pTsintelNo)) {
            if (!CheckTelNo.isCheckOK(pTsintelNo)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TELNO_YUUKOUCHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

    }
}
