package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 請求内容チェック 海外チェック
 */
public class ChkSubKaigai {

    @Inject
    private static Logger logger;

    public ChkSubKaigai() {
        super();
    }

    public void exec(C_UmuKbn pSateiKakKaigaiKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 海外チェック 開始");

        if (C_UmuKbn.ARI.eq(pSateiKakKaigaiKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_KAIGAI);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 海外チェック 終了");
    }
}