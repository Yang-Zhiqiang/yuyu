package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanW}のモッククラスです。<br />
 */
public class KeisanZennouSeisanGkMockForSiharai extends KeisanZennouSeisanGk {

    private BizCurrency zennouSeisanGk;

    private BizDateYM lastPJyuutouYm;

    private List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizCurrency getZennouSeisanGk() {

        if (caller.equals(SiSiharaiKingakuKeisanTest_exec.class)) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            return zennouSeisanGk;
        }
        return super.getZennouSeisanGk();
    }

    @Override
    public BizDateYM getLastPJyuutouYm() {

        if (caller.equals(SiSiharaiKingakuKeisanTest_exec.class)) {
            return lastPJyuutouYm;
        }
        return super.getLastPJyuutouYm();
    }

    @Override
    public C_ErrorKbn exec(BizDate pZennouseisankijyunymd, String pSyono) {

        if (caller.equals(SiSiharaiKingakuKeisanTest_exec.class)) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                zennouSeisanGk = BizCurrency.valueOf(3000000, BizCurrencyTypes.YEN);
                lastPJyuutouYm = BizDateYM.valueOf(201712);

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                zennouSeisanGk = BizCurrency.valueOf(32045, BizCurrencyTypes.YEN);
                lastPJyuutouYm = BizDateYM.valueOf(201812);

                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pZennouseisankijyunymd, pSyono);
    }

    @Override
    public String getZennouPSeisanKbn(BizDate pRyosyuymd, BizDate pDenYmd) {

        return super.getZennouPSeisanKbn(pRyosyuymd, pDenYmd);
    }

    @Override
    public C_ErrorKbn exec(BizDate pZennouseisankijyunymd,
        BizDate pKykymd, BizCurrency pZennoujihrkp,
        BizDate pZennouStartYmd, BizDate pRyosyuymd,
        BizCurrency pZennounyuukinkgk) {

        return super.exec(pZennouseisankijyunymd, pKykymd, pZennoujihrkp, pZennouStartYmd, pRyosyuymd,
            pZennounyuukinkgk);
    }

    @Override
    public List<KykOutoubiZennouZndkBean> getKykOutoubiZennouZndkList() {

        return kykOutoubiZennouZndkList;
    }
}
