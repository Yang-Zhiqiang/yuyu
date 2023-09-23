package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.util.string.StringUtil;

import org.slf4j.Logger;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号表示編集
 */
public class CreditKessaiyouNoHensyuu {

    private static final String HAIFUN = "-";

    @Inject
    private static Logger logger;

    public CreditKessaiyouNoHensyuu() {
        super();
    }

    public String exec(String pCreditcardKessaiyouNo) {

        logger.debug("▽ クレジットカード決済用番号表示編集 開始");

        String dispCreditcardKessaiyouNo = "";

        if(!StringUtil.isNullOrBlank(pCreditcardKessaiyouNo)) {
            dispCreditcardKessaiyouNo = pCreditcardKessaiyouNo.substring(0, 2) + HAIFUN
                + pCreditcardKessaiyouNo.substring(2, 4) + HAIFUN + pCreditcardKessaiyouNo.substring(4, 13) + HAIFUN
                + pCreditcardKessaiyouNo.substring(13, 19) + HAIFUN + pCreditcardKessaiyouNo.substring(19, 25) + HAIFUN
                + pCreditcardKessaiyouNo.substring(25);
        }

        logger.debug("△ クレジットカード決済用番号表示編集 終了");

        return dispCreditcardKessaiyouNo;
    }
}
