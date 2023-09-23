package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 質権設定チェック
 */
public class ChkSubStknset {

    @Inject
    private static Logger logger;

    public ChkSubStknset() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 質権設定チェック 開始");

        if (C_StknsetKbn.ARI.eq(pSiKykKihon.getStknsetkbn())) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_STKNSET_UMU);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 質権設定チェック 終了");
    }

}