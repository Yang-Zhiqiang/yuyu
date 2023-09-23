package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号ユーティリティ
 */
public class CreditKessaiyouNoUtil {

    @Inject
    private static Logger logger;

    public CreditKessaiyouNoUtil() {
        super();
    }

    public String getKessaiSyuruiKbn(String pCreditcardKessaiyouNo) {

        logger.debug("▽ 決済種類区分取得 開始");

        String kessaiSyuruiKbn = pCreditcardKessaiyouNo.substring(0, 1);

        logger.debug("△ 決済種類区分取得 終了");

        return kessaiSyuruiKbn;
    }

    public String getKeySyuruiKbn(String pCreditcardKessaiyouNo) {

        logger.debug("▽ キー種類区分取得 開始");

        String keySyuruiKbn = pCreditcardKessaiyouNo.substring(1, 2);

        logger.debug("△ キー種類区分取得 終了");

        return keySyuruiKbn;
    }

    public String getMosNo(String pCreditcardKessaiyouNo) {

        logger.debug("▽ 申込番号取得 開始");

        String keySyuruiKbn = getKeySyuruiKbn(pCreditcardKessaiyouNo);

        String mosNo = "";

        if ("2".equals(keySyuruiKbn)) {

            mosNo = pCreditcardKessaiyouNo.substring(4, 13);
        }

        logger.debug("△ 申込番号取得 終了");

        return mosNo;
    }

    public String getSyoNo(String pCreditcardKessaiyouNo) {

        logger.debug("▽ 証券番号取得 開始");

        String keySyuruiKbn = getKeySyuruiKbn(pCreditcardKessaiyouNo);

        String syoNo = "";

        if ("3".equals(keySyuruiKbn)) {

            syoNo = pCreditcardKessaiyouNo.substring(2, 13);
        }

        logger.debug("△ 証券番号取得 終了");

        return syoNo;
    }
}
