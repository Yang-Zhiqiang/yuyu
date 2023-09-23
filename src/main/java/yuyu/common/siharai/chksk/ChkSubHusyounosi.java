package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 請求内容チェック 不詳の死チェック
 */
public class ChkSubHusyounosi {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public ChkSubHusyounosi() {
        super();
    }

    public void exec(List<String> pByoumeiTourokuNoLst, C_GeninKbn pGeninKbn, C_UmuKbn pSateiKakHusyouSiKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 不詳の死チェック 開始");

        for (String byoumeiTourokuNo : pByoumeiTourokuNoLst) {
            JM_Byoumei byoumei = siharaiDomManager.getByoumei(byoumeiTourokuNo);
            if (C_ByoumeiGaitouKbn2.HUSYOU.eq(byoumei.getGaitoukbn2())) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HUSYOU_BYOUMEI);
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 不詳の死チェック 終了");
                return;
            }
        }

        if (C_GeninKbn.TST.eq(pGeninKbn) ||
            C_GeninKbn.SONOTAFS.eq(pGeninKbn) ||
            C_GeninKbn.FSS.eq(pGeninKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HUSYOU_GENINKBN);
            pChkKekkaBeanLst.add(chkKekkaBean);
            logger.debug("△ 不詳の死チェック 終了");
            return;
        }

        if (C_UmuKbn.ARI.eq(pSateiKakHusyouSiKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HUSYOU_KSYOUHI);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 不詳の死チェック 終了");
    }
}