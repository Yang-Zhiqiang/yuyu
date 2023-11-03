package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanKihrkP}のモッククラスです。<br />
 */
public class KeisanKihrkPMock extends KeisanKihrkP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency kihrkP;

    private BizCurrency yenKihrkP;

    @Override
    public BizCurrency getKihrkP() {
        return kihrkP;
    }

    public void setKihrkP(BizCurrency kihrkP) {
        this.kihrkP = kihrkP;
    }

    @Override
    public BizCurrency getYenKihrkP() {
        return yenKihrkP;
    }

    public void setYenKihrkP(BizCurrency yenKihrkP) {
        this.yenKihrkP = yenKihrkP;
    }

    @Override
    public C_ErrorKbn exec(String pSyono, C_Tuukasyu pKykTuukasyu) {
        if (caller == SetHaraikomiInfoTest_exec.class) {
            setKihrkP(BizCurrency.valueOf(4));
            setYenKihrkP(BizCurrency.valueOf(4));
            return super.exec(pSyono, pKykTuukasyu);
        }
        else if(caller == KeisanHtyKeihiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)){
            setKihrkP(BizCurrency.valueOf(0));
            setYenKihrkP(BizCurrency.valueOf(0));
            return C_ErrorKbn.OK;
        }
        else if(caller == KeisanHtyKeihiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)){
            setKihrkP(BizCurrency.valueOf(500));
            setYenKihrkP(BizCurrency.valueOf(500));
            return C_ErrorKbn.OK;
        }
        else if(caller == KeisanHtyKeihiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)){
            setKihrkP(BizCurrency.valueOf(200));
            setYenKihrkP(BizCurrency.valueOf(200));
            return C_ErrorKbn.OK;
        }
        else if(caller == KeisanHtyKeihiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)){
            setKihrkP(BizCurrency.valueOf(456));
            setYenKihrkP(BizCurrency.valueOf(456));
            return C_ErrorKbn.OK;
        }
        else if(caller == KeisanHtyKeihiTest_exec.class && TESTPATTERN5.equals(SYORIPTN)){
            setKihrkP(BizCurrency.valueOf(123, BizCurrencyTypes.EURO));
            setYenKihrkP(BizCurrency.valueOf(456));
            return C_ErrorKbn.OK;
        }
        else if(caller == KeisanHrrtksnHrkPGkgkTest_exec.class ){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                setYenKihrkP(BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN));
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        C_ErrorKbn errorKbn = super.exec(pSyono, pKykTuukasyu);

        this.yenKihrkP = super.getYenKihrkP();

        this.kihrkP = super.getKihrkP();

        return errorKbn;
    }
}
