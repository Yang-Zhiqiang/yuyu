package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.EditHrhnKanryoTuutiTest_editTBL;

/**
 * {@link BzGetBankData}のモッククラスです。<br />
 */
public class BzGetBankDataMockForKhansyuu extends BzGetBankData {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public BzGetBankDataBean exec(String pBankCd, String pSitenCd, BizDate pKijyunYmd) {

        if (EditHrhnKanryoTuutiTest_editTBL.class == caller) {

            BzGetBankDataBean bzGetBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);

            if ("1001".equals(pBankCd)) {

                bzGetBankDataBean.setBankNmKj("みずほ銀行");
                bzGetBankDataBean.setReportSitenNm("東京支店");

                return bzGetBankDataBean;
            }
        }

        return super.exec(pBankCd, pSitenCd, pKijyunYmd);
    }
}
