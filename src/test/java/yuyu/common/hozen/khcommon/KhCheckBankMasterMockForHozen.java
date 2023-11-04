package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 銀行マスタチェック<br />
 * {@link KhCheckBankMaster}のモッククラスです。<br />
 */
public class KhCheckBankMasterMockForHozen extends KhCheckBankMaster {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int checkBankMaster(C_Tuukasyu shrtuukasyu, String bankCd, String sitenCd) {

        if (caller == KhCheckKouzaTest_chkSoukinsakiKouza.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 1;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 2;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 3;
            } else if (TESTPATTERN4.equals(SYORIPTN)) {
                return 4;
            } else if (TESTPATTERN5.equals(SYORIPTN)) {
                return 0;
            }
        }
        return super.checkBankMaster(shrtuukasyu, bankCd, sitenCd);

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
