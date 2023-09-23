package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.siharai.sicommon.SaigaiGaitouHantei;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 請求内容チェック 災害該当可能性チェック
 */
public class ChkSubSaigaiGaitou {

    @Inject
    private static Logger logger;

    public ChkSubSaigaiGaitou() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, List<String> pByoumeiTourokuNoLst, C_GeninKbn pGeninKbn,
        C_UmuKbn pSateiKakSaigaiKanouseiKbn, BM_SyouhnZokusei pSyouhnZokusei, JT_SiKykSyouhn pSiKykSyouhn,
        JT_SkKihon pSkKihon, Boolean pSateiChkFlg, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 災害該当可能性チェック 開始");

        BizDate calckijyunYmd;
        if (BizDateUtil.compareYmd(pHanteiKijyunYmd, pSiKykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            calckijyunYmd = pSiKykSyouhn.getKykymd();
        }
        else {
            calckijyunYmd = pHanteiKijyunYmd;
        }

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(pSiKykSyouhn.getKykymd());
        hanteiHokenKikanBean.setCalcKijyunYmd(calckijyunYmd);
        hanteiHokenKikanBean.setSyouhnZokusei(pSyouhnZokusei);
        hanteiHokenKikanBean.setDai1hknkkn(pSiKykSyouhn.getDai1hknkkn());

        C_HknKknKbn hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        if(C_HknKknKbn.DAI1HKNKKN.eq(hknKknKbn)) {

            SaigaiGaitouHantei saigaiGaitouHantei = SWAKInjector.getInstance(SaigaiGaitouHantei.class);

            if (saigaiGaitouHantei.chkGeninkbn(pGeninKbn)) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                if (pSateiChkFlg == true) {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SAIGAI_GENINKBN);
                }
                else {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK);
                }
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 災害該当可能性チェック 終了");
                return;
            }

            if (saigaiGaitouHantei.chkByoumei(pByoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                if (pSateiChkFlg == true) {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);
                }
                else {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK);
                }
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 災害該当可能性チェック 終了");
                return;

            }

            if (saigaiGaitouHantei.chkSateikaisou(pSateiKakSaigaiKanouseiKbn)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                if (pSateiChkFlg == true) {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SAIGAI_KSYOUHI);
                }
                else {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK);
                }
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 災害該当可能性チェック 終了");
                return;
            }

            if (saigaiGaitouHantei.chkKyuusyorui(pSkKihon)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                if (pSateiChkFlg == true) {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SAIGAI_SKSYORUI);
                }
                else {
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK);
                }
                pChkKekkaBeanLst.add(chkKekkaBean);
            }

        }

        logger.debug("△ 災害該当可能性チェック 終了");
    }
}