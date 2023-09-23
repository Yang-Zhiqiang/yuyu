package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 破産および倒産チェック
 */
public class ChkSubHasanTousan {

    @Inject
    private static Logger logger;

    public ChkSubHasanTousan() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 破産および倒産チェック 開始");

        if (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn5())) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN);

            pChkKekkaBeanList.add(chkKekkaBean);
        }

        logger.debug("△ 破産および倒産チェック 終了");
    }

}
