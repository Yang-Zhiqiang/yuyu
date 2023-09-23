package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 保険金給付金支払共通 債権者情報入力要否判定
 */
public class HanteiSaikenInfoNyuuryoku {

    @Inject
    private static Logger logger;

    public HanteiSaikenInfoNyuuryoku() {
        super();
    }

    public boolean exec(JT_SiKykKihon pSiKykKihon) {

        logger.debug("▽ 債権者情報入力要否判定 開始");

        boolean isSaikenInfoNyuuryoku = false;

        if (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(pSiKykKihon.getTtdktyuuikbn5()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(pSiKykKihon.getTtdktyuuikbn5()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(pSiKykKihon.getTtdktyuuikbn5()) ||
            C_StknsetKbn.ARI.eq(pSiKykKihon.getStknsetkbn())) {

            isSaikenInfoNyuuryoku = true;
        }

        logger.debug("△ 債権者情報入力要否判定 終了");

        return isSaikenInfoNyuuryoku;
    }
}
