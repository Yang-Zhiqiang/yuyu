package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 債権者解約申出チェック
 */
public class ChkSubSaikenKaiykMouside {

    @Inject
    private static Logger logger;

    public ChkSubSaikenKaiykMouside() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 債権者解約申出チェック 開始");

        if (C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn5())) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SAIKENKAIYAKU);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 債権者解約申出チェック 終了");
    }

}