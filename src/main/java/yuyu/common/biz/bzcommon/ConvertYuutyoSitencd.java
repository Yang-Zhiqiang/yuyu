package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * 業務共通 共通 ゆうちょ銀行支店コード変換
 */
public class ConvertYuutyoSitencd {

    @Inject
    private static Logger logger;

    public ConvertYuutyoSitencd() {
        super();
    }

    public String exec(String pSitencd)  {

        logger.debug("▽ ゆうちょ銀行支店コード変換 開始");

        String hrkmSitencd = "";

        if (pSitencd.length() != 3) {
            hrkmSitencd = pSitencd;

        }
        else {
            hrkmSitencd = pSitencd.substring(0, 2).concat("8");

        }

        logger.debug("△ ゆうちょ銀行支店コード変換 終了");

        return hrkmSitencd;
    }
}