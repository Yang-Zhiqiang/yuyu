package yuyu.common.hozen.khcommon;

import yuyu.common.direct.dscommon.CheckDsTorihikiServiceTest_checkSoukinyoukz;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 銀行マスタチェック<br />
 * {@link KhCheckBankMaster}のモッククラスです。<br />
 */
public class KhCheckBankMasterMockForDirect extends KhCheckBankMaster {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int checkBankMaster(C_Tuukasyu shrtuukasyu, String bankCd, String sitenCd) {
        if(caller == CheckDsTorihikiServiceTest_checkSoukinyoukz.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return KhCheckBankMaster.BANK_SONZAI_ERR;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return KhCheckBankMaster.BANK_YUUKOU_HANTEI_ERR;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return KhCheckBankMaster.BANK_YTGINKOU_SOUKIN_ERR;
            } else if (TESTPATTERN4.equals(SYORIPTN)) {
                return KhCheckBankMaster.GAIKAKOUZA_SOUKIN_ERR;
            } else if (TESTPATTERN5.equals(SYORIPTN)) {
                return KhCheckBankMaster.SYORI_OK;
            } else if (TESTPATTERN6.equals(SYORIPTN)) {
            	return 9;
                //KhCheckBankMaster.SYORI_OK;
            }
        }
        return super.checkBankMaster(shrtuukasyu, bankCd, sitenCd);
    }
}
