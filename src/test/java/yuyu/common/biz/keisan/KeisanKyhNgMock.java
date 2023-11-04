package yuyu.common.biz.keisan;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.classification.C_KataKbn;

/**
 * {@link KeisanKyhNg}のモッククラスです。<br />
 */
public class KeisanKyhNgMock extends KeisanKyhNg {

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizCurrency exec(String pSyouhncd, int pSyouhnsdno, C_KataKbn pKatakbn, BizCurrency pKihons) {
        if(caller == SetHosyouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(500);
        }

        return super.exec(pSyouhncd,pSyouhnsdno,pKatakbn,pKihons);
    }

}
