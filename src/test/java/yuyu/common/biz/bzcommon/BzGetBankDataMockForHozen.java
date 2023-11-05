package yuyu.common.biz.bzcommon;

import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;
import jp.co.slcs.swak.date.BizDate;

/**
 * {@link BzGetBankData}のモッククラスです。<br />
 */
public class BzGetBankDataMockForHozen extends BzGetBankData {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public BzGetBankDataBean exec(String pBankCd, String pSitenCd, BizDate pKijyunYmd) {

        if (caller == SetHaraikomiInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetBankDataBean getBankDataBean = new BzGetBankDataBean();

                getBankDataBean.setBankNmKj("");
                getBankDataBean.setSitenNmKj("");

                return getBankDataBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetBankDataBean getBankDataBean = new BzGetBankDataBean();

                getBankDataBean.setBankNmKj("ゆうちょ銀行");
                getBankDataBean.setSitenNmKj("東京支店");

                return getBankDataBean;
            }
        }

        return super.exec(pBankCd, pSitenCd, pKijyunYmd);
    }
}
