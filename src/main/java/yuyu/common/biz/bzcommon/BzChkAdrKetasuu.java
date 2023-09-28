package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;

/**
 * 業務共通 業務共通 住所桁数チェッククラス
 */
public class BzChkAdrKetasuu {

    @Inject
    private static Logger logger;

    public BzChkAdrKetasuu() {
        super();
    }

    public BzChkAdrKetasuuOutBean exec(String pJyuusyo1, String pJyuusyo2, String pJyuusyo3) {

        logger.debug("▽ 住所桁数チェック 開始");

        int inKetasuu = pJyuusyo1.length() + pJyuusyo2.length() + pJyuusyo3.length();

        int inJyougenKetasuu = YuyuBizConfig.getInstance().getJyuusyoNyuuryokuJyougenCnt();

        C_JyougenketasuutyoukaKbn jyougenKetasuuTyoukaKbn = null;

        if (inKetasuu <= inJyougenKetasuu) {

            jyougenKetasuuTyoukaKbn = C_JyougenketasuutyoukaKbn.JYOUGENNAI;
        }
        else {

            jyougenKetasuuTyoukaKbn = C_JyougenketasuutyoukaKbn.CYOUKA;
        }

        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = SWAKInjector.getInstance(BzChkAdrKetasuuOutBean.class);

        bzChkAdrKetasuuOutBean.setJyougenKetasuuTyoukaKbn(jyougenKetasuuTyoukaKbn);
        bzChkAdrKetasuuOutBean.setInKetasuu(inKetasuu);
        bzChkAdrKetasuuOutBean.setInJyougenKetasuu(inJyougenKetasuu);

        logger.debug("△ 住所桁数チェック 終了");

        return bzChkAdrKetasuuOutBean;
    }
}
