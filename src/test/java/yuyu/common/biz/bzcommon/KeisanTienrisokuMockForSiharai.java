package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_SinsaGendoKknKbn;

/**
 * {@link KeisanTienrisoku}のモッククラスです<br />
 */
public class KeisanTienrisokuMockForSiharai extends KeisanTienrisoku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public KeisanTienrisokuBean exec(BizDate pSyoruiUkeYmd, BizDate pHubiKanryouYmd, BizDate pTyakkinYmd,
        BizCurrency pSshkkei,
        Integer pRikoukiTyuutuudanNissuu,
        C_SinsaGendoKknKbn pSinsagendoKknKbn) {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                KeisanTienrisokuBean keisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);
                keisanTienrisokuBean.setShrtienrsk(BizCurrency.valueOf(0, pSshkkei.getType()));
                keisanTienrisokuBean.setShrtienrskStartYmd(null);
                keisanTienrisokuBean.setShrtienrskEndYmd(null);
                keisanTienrisokuBean.setShrtienNissuu(0);
                return keisanTienrisokuBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                KeisanTienrisokuBean keisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);
                if (BizCurrencyTypes.YEN.equals(pSshkkei.getType())) {
                    keisanTienrisokuBean.setShrtienrsk(BizCurrency.valueOf(3000, pSshkkei.getType()));
                } else {
                    keisanTienrisokuBean.setShrtienrsk(BizCurrency.valueOf(300, pSshkkei.getType()));
                }
                keisanTienrisokuBean.setShrtienrskStartYmd(BizDate.valueOf(20170618));
                keisanTienrisokuBean.setShrtienrskEndYmd(BizDate.valueOf(20190617));
                keisanTienrisokuBean.setShrtienNissuu(3);
                return keisanTienrisokuBean;
            }
        }
        return super.exec(pSyoruiUkeYmd, pHubiKanryouYmd, pTyakkinYmd, pSshkkei, pRikoukiTyuutuudanNissuu,
            pSinsagendoKknKbn);
    }
}
