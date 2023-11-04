package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.common.suuri.srcommon.SrSuuriKeisanVHeijyunTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;

/**
 * {@link KeisanVHeijyun}のモッククラスです<br />
 */
public class KeisanVHeijyunMockForSuuri extends KeisanVHeijyun {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(KeisanVHeijyunBean pKeisanVHeijyunBean) {
        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (C_KhSisanSyuruiKbn.SISAN .eq(pKeisanVHeijyunBean.getSisansyuruikbn())) {
                    return C_ErrorKbn.ERROR;
                }
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pKeisanVHeijyunBean);
    }

    @Override
    public BizCurrency getV() {
        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1100);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1200);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1300);
            }
        }
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }
        }
        return super.getV();
    }

    @Override
    public BizNumber getYoteiIjihirituVhirei() {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(60);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(60);
            }
        }
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(60);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(60);
            }
        }
        return super.getYoteiIjihirituVhirei();
    }

    @Override
    public BizCurrency getKiharaikomiP() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(200);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(200);
            }
        }
        return super.getKiharaikomiP();
    }

    @Override
    public BizDateYM getTumitateYM() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDateYM.valueOf(201601);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDateYM.valueOf(201602);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDateYM.valueOf(201604);
            }
        }
        return super.getTumitateYM();
    }

    @Override
    public BizCurrency getVTyouseimae() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(90);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(90);
            }
        }
        return super.getVTyouseimae();
    }

    @Override
    public BizNumber getYoteiSinkeiyakuhiritu() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(40);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(40);
            }
        }
        return super.getYoteiSinkeiyakuhiritu();
    }

    @Override
    public BizNumber getYoteiIjihirituPhirei() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(50);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(50);
            }
        }
        return super.getYoteiIjihirituPhirei();
    }

    @Override
    public BizNumber getYoteiSyuukinhiritu() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(30);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(30);
            }
        }
        return super.getYoteiSyuukinhiritu();
    }

    @Override
    public BizNumber getKogakuWaribikiritu() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(10);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(10);
            }
        }
        return super.getKogakuWaribikiritu();
    }

    @Override
    public BizNumber getZettaiSibouritu() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(20);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(20);
            }
        }
        return super.getZettaiSibouritu();
    }

    @Override
    public BizNumber getSoutaiSibouritu() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(70);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(70);
            }
        }
        return super.getSoutaiSibouritu();
    }

    @Override
    public BizNumber getSoutaiKaiyakuritu() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(75);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(75);
            }
        }
        return super.getSoutaiKaiyakuritu();
    }

    @Override
    public BizNumber getYoteiriritu() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(80);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(80);
            }
        }
        return super.getYoteiriritu();
    }

    @Override
    public BizNumber getKawaserate() {
        if (caller == SrSuuriKeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(25);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(25);
            }
        }
        return super.getKawaserate();
    }
}
