package yuyu.common.workflow.wfcommon;

import yuyu.common.base.format.DefaultDateFormatter;

import com.google.common.base.Strings;


/***
 * 取込用表紙作成 機能の帳票編集クラスです。<br />
 */
public class EditTorikomiHyousiSakusei {

    public static final String NENKINSIHARAI = "年金支払";

    public static final String HOZEN = "契約保全";

    public static final String SIHARAI = "保険金給付金支払";

    public static final String GYOUMU_KEY_SINKEIYAKU = "申込番号";

    public static final String GYOUMU_KEY_HOZEN = "証券番号";

    public static final String GYOUMU_KEY_SIHARAI = "証券番号";

    public static final String GYOUMU_KEY_NENKIN = "年金証書番号";

    public static String editYMDhm(String pSysDateTime){

        return DefaultDateFormatter.formatYMDHMZeroFill(pSysDateTime);
    }

    public static String editGyoumuKey(String pSubSystemId) {
        if (pSubSystemId.equals(NENKINSIHARAI)) {
            return GYOUMU_KEY_NENKIN;
        }
        if (pSubSystemId.equals(HOZEN)) {
            return GYOUMU_KEY_HOZEN;
        }
        if (pSubSystemId.equals(SIHARAI)) {
            return GYOUMU_KEY_SIHARAI;
        }
        return GYOUMU_KEY_SINKEIYAKU;
    }

    public static String getGyoumukeyValue(String pMosno, String pSyono, String pNksysyno) {
        if (!Strings.isNullOrEmpty(pMosno)) {
            return pMosno;
        }
        if (!Strings.isNullOrEmpty(pSyono)) {
            return pSyono;
        }
        return pNksysyno;
    }

}
