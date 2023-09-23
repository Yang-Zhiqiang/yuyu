package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 捜査照会チェック
 */
public class ChkSubSousasyoukai {

    @Inject
    private static Logger logger;

    public ChkSubSousasyoukai() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 捜査照会チェック 開始");

        if (C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn1())
                || C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn1())
                || C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn2())
                || C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn2())
                || C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn3())
                || C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn3())
                || C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn4())
                || C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn4())
                || C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn5())
                || C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI.eq(pSiKykKihon.getTtdktyuuikbn5())
                ) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI);

            pChkKekkaBeanList.add(chkKekkaBean);
        }

        logger.debug("△ 捜査照会チェック 終了");
    }
}