package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 前納精算額計算{@link KeisanZennouSeisanGk}のモッククラスです。<br />
 */
public class KeisanZennouSeisanGkMockForHozen extends KeisanZennouSeisanGk {

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
        if (caller.equals(KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class)) {
            return zennouSeisanGk;
        }
        return super.getZennouSeisanGk();
    }

    @Override
    public BizDateYM getLastPJyuutouYm() {

        if (caller.equals(KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class)) {
            return lastPJyuutouYm;
        }
        return super.getLastPJyuutouYm();
    }

    @Override
    public C_ErrorKbn exec(BizDate pZennouseisankijyunymd, String pSyono) {

        if (caller.equals(KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class)) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                zennouSeisanGk = BizCurrency.valueOf(1001);
                lastPJyuutouYm = BizDateYM.valueOf(201712);

                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                zennouSeisanGk = BizCurrency.valueOf(1002);
                lastPJyuutouYm = BizDateYM.valueOf(201812);

                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pZennouseisankijyunymd, pSyono);
    }

    @Override
    public String getZennouPSeisanKbn(BizDate pRyosyuymd, BizDate pDenYmd) {

        if (caller.equals(CommonSiwakeUtilTest_execPKanjokamokuHantei.class)) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return KeisanZennouSeisanGk.ZENNOUPSEISANKBN_SONOTA;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return KeisanZennouSeisanGk.ZENNOUPSEISANKBN_JINENDOP;
            }
        }
        if (caller.equals(CommonSiwakeUtilTest_execKihrkmPKanjokamokuHantei.class)) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return KeisanZennouSeisanGk.ZENNOUPSEISANKBN_SONOTA;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return KeisanZennouSeisanGk.ZENNOUPSEISANKBN_JINENDOP;
            }
        }

        return super.getZennouPSeisanKbn(pRyosyuymd, pDenYmd);
    }

    @Override
    public C_ErrorKbn exec(BizDate pZennouseisankijyunymd,
        BizDate pKykymd, BizCurrency pZennoujihrkp,
        BizDate pZennouStartYmd, BizDate pRyosyuymd,
        BizCurrency pZennounyuukinkgk) {

        if (caller == WSuiihyouNenkin2Test_exec.class) {

            kykOutoubiZennouZndkList = new ArrayList<>();

            KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean;

            if (TESTPATTERN1.equals(SYORIPTN)) {

                kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
                kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20190311));
                kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(99111111, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(88111111, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
                kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20190312));
                kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(99111111, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(88111111, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
                kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20200229));
                kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(99111111, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(88111111, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

                kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
                kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20210228));
                kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(99222222, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(88222222, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

                kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
                kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20220228));
                kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(99333333, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(88333333, BizCurrencyTypes.YEN));
                kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pZennouseisankijyunymd, pKykymd, pZennoujihrkp, pZennouStartYmd, pRyosyuymd,
            pZennounyuukinkgk);
    }

    @Override
    public List<KykOutoubiZennouZndkBean> getKykOutoubiZennouZndkList() {

        return kykOutoubiZennouZndkList;
    }

}
