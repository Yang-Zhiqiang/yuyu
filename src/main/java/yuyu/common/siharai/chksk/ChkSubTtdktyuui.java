package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 手続注意チェック
 */
public class ChkSubTtdktyuui {

    @Inject
    private static Logger logger;

    public ChkSubTtdktyuui() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekaBeanList) {

        logger.debug("▽ 手続注意チェック 開始");


        if (!C_TtdktyuuiKbn.BLNK.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
                !C_TtdktyuuiKbn.BLNK.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
                !C_TtdktyuuiKbn.BLNK.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
                !C_TtdktyuuiKbn.BLNK.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
                !C_TtdktyuuiKbn.BLNK.eq(pSiKykKihon.getTtdktyuuikbn5())) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TTDKTYUUI_CHK);

            pChkKekaBeanList.add(chkKekkaBean);
        }

        logger.debug("△ 手続注意チェック 終了");

    }
}