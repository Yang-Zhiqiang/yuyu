package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 差押チェック
 */
public class ChkSubSasiosae {

    @Inject
    private static Logger logger;

    public ChkSubSasiosae() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 差押チェック 開始");


        if (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn5())) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SASIOSAE);
            pChkKekkaBeanLst.add(chkKekkaBean);

        }

        logger.debug("△ 差押チェック 終了");
    }
}
