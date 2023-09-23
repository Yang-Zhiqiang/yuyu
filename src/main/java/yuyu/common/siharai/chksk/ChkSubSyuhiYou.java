package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 請求内容チェック 守秘要チェック
 */
public class ChkSubSyuhiYou {

    @Inject
    private static Logger logger;

    public ChkSubSyuhiYou() {
        super();
    }

    public void exec(JT_SkKihon pSkKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {
        logger.debug("▽ 守秘要チェック 開始");
        if (pSkKihon.getMouside() != null) {
            if (C_SyuhiYouhi.YOU.eq(pSkKihon.getMouside().getSyuhiyouhi())) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SYUHIYOU_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }
        logger.debug("△ 守秘要チェック 終了");
    }
}
