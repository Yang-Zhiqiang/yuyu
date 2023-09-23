package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 請求内容チェック 非該当チェック
 */
public class ChkSubHigaitou {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private static Logger logger;

    public ChkSubHigaitou() {
        super();
    }

    public void exec(JT_SkKihon pSkKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 非該当チェック 開始");

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.
                getSiRirekisBySyonoShrkekkakbnTorikesiflg(pSkKihon.getSyono(), C_ShrKekkaKbn.HSHR, C_UmuKbn.NONE);

        if (siRirekiLst.size() > 0) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HIGAITOU);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 非該当チェック 終了");
    }
}