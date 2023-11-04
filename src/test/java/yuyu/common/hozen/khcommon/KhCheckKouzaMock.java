package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 口座情報入力チェック<br />
 * {@link KhCheckBankMaster}のモッククラスです。<br />
 */
public class KhCheckKouzaMock extends KhCheckBankMaster{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "0";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int checkBankMaster(C_Tuukasyu shrtuukasyu, String bankCd, String sitenCd) {

        if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class && TESTPATTERN1.equals(SYORIPTN)) {
            return 1;
        } else if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class && TESTPATTERN2.equals(SYORIPTN)) {
            return 2;
        } else if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class && TESTPATTERN3.equals(SYORIPTN)) {
            return 3;
        } else if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class && TESTPATTERN4.equals(SYORIPTN)) {
            return 4;
        } else if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class && TESTPATTERN5.equals(SYORIPTN)) {
            return 0;
        } else {
            return super.checkBankMaster(shrtuukasyu, bankCd, sitenCd);
        }
    }

    @Override
    public String getGinkouName() {

        if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class && TESTPATTERN5.equals(SYORIPTN)) {

            return "銀行名テスト";
        }
        return super.getGinkouName();
    }

    @Override
    public String getShitenName() {

        if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class && TESTPATTERN5.equals(SYORIPTN)) {
            return "支店名テスト";
        }
        return super.getShitenName();
    }

}
