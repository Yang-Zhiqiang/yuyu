package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 債権者情報チェック
 */
public class ChkSubSaikenInfo {

    @Inject
    private static Logger logger;

    public ChkSubSaikenInfo() {
        super();
    }

    public void exec(String pSaikennmKj, String pSaikennYno,String pSaikenAdr1Kj,String pSaikenAdr2Kj,
        String pSaikenAdr3Kj,JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 債権者情報チェック 開始");

        if (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn5()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn5()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn5()) ||
            C_StknsetKbn.ARI.eq(pSiKykKihon.getStknsetkbn())) {

            if (BizUtil.isBlank(pSaikennmKj)
                && BizUtil.isBlank(pSaikennYno)
                && BizUtil.isBlank(pSaikenAdr1Kj)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIKEN_ZENBU_MINYUCHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 債権者情報チェック 終了");
                return;
            }

            if (BizUtil.isBlank(pSaikennmKj)
                || BizUtil.isBlank(pSaikennYno)
                || BizUtil.isBlank(pSaikenAdr1Kj)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIKEN_ITIBU_MINYUCHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }

            BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

            BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(pSaikenAdr1Kj, pSaikenAdr2Kj, pSaikenAdr3Kj);

            C_JyougenketasuutyoukaKbn jyougenKetasuuTyoukaKbn = bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn();

            if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(jyougenKetasuuTyoukaKbn)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIKEN_ADRKJ_KETACHK);
                chkKekkaBean.setMsgHikisuu2(String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()));
                chkKekkaBean.setMsgHikisuu3(String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
                pChkKekkaBeanLst.add(chkKekkaBean);
            }

        }

        logger.debug("△ 債権者情報チェック 終了");
    }

}