package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 請求内容チェック 海外死亡チェック
 */
public class ChkSubKaigaiSb {

    @Inject
    private static Logger logger;

    public ChkSubKaigaiSb() {
        super();
    }

    public void exec(C_UmuKbn pSateikakkaigaisbKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 海外死亡チェック 開始");


        if (C_UmuKbn.ARI.eq(pSateikakkaigaisbKbn)) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_KAIGAISIBOU);
            pChkKekkaBeanLst.add(chkKekkaBean);

        }

        logger.debug("△ 海外死亡チェック 終了");
    }
}
