package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 請求内容チェック 審査注意チェック
 */
public class ChkSubSinsaTyuui {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public ChkSubSinsaTyuui() {
        super();
    }

    public void exec(String pSyoNo, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 審査注意チェック 開始");

        JT_SinsaTyuui sinsaTyuui = siharaiDomManager.getSinsaTyuui(pSyoNo);

        if (sinsaTyuui != null) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SINSATYUUI_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 審査注意チェック 終了");
    }

}
