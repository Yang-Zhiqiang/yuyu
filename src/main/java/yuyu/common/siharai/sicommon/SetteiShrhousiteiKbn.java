package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払方法指定区分設定
 */
public class SetteiShrhousiteiKbn {

    @Inject
    private static Logger logger;

    public SetteiShrhousiteiKbn() {
        super();
    }

    public C_ShrhousiteiKbn exec(C_InputShrhousiteiKbn pInputShrhousiteiKbn, C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 支払方法指定区分設定 開始");

        C_ShrhousiteiKbn shrhousiteiKbn;

        if (pTuukasyu == null || pInputShrhousiteiKbn == null || C_Tuukasyu.BLNK.eq(pTuukasyu) ||
                C_InputShrhousiteiKbn.BLNK.eq(pInputShrhousiteiKbn)) {
            shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

        } else if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pInputShrhousiteiKbn)) {

            shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI;

        } else if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pInputShrhousiteiKbn)) {

            shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI;

        } else if (C_InputShrhousiteiKbn.FBSOUKIN.eq(pInputShrhousiteiKbn)) {

            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
                shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;

            } else {
                shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;

            }
        } else {
            shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

        }

        logger.debug("△ 支払方法指定区分設定 終了");

        return shrhousiteiKbn;
    }
}
