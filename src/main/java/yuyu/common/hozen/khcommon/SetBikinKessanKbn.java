package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import org.slf4j.Logger;

import yuyu.def.classification.C_Bknkessankbn;

/**
 * 契約保全 契約保全共通 備金決算区分設定
 */
public class SetBikinKessanKbn {

    @Inject
    private static Logger logger;

    public SetBikinKessanKbn() {
        super();
    }

    public C_Bknkessankbn exec(BizDate pKessankijyunYmd) {

        logger.debug("▽ 備金決算区分設定 開始");

        C_Bknkessankbn bknkessankbn;
        if (pKessankijyunYmd.getMonth() == 3) {
            bknkessankbn = C_Bknkessankbn.KESSAN;
        }
        else if (pKessankijyunYmd.getMonth() == 6) {
            bknkessankbn = C_Bknkessankbn.SHNK;
        }
        else if (pKessankijyunYmd.getMonth() == 9) {
            bknkessankbn = C_Bknkessankbn.HNK;
        }
        else if (pKessankijyunYmd.getMonth() == 12) {
            bknkessankbn = C_Bknkessankbn.SHNK;
        }
        else {
            bknkessankbn = C_Bknkessankbn.BLNK;
        }

        logger.debug("△ 備金決算区分設定 終了");

        return bknkessankbn;
    }
}
