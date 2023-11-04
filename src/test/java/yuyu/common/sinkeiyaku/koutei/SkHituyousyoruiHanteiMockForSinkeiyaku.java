package yuyu.common.sinkeiyaku.koutei;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.sinkeiyaku.moschk.HanteiHituyouSyoruiTest_exec;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;

/**
 * {@link SkHituyousyoruiHantei}のモッククラスです。<br />
 */
public class SkHituyousyoruiHanteiMockForSinkeiyaku extends SkHituyousyoruiHantei{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp) {
        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return;
        }

        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return;
        }

        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return;
        }

        super.exec(pMp);
    }

    @Override
    public List<String> getHuyousyoruiValueList () {

        if (caller == HanteiHituyouSyoruiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)){
                List<String> huyousyoruiValueList = new ArrayList<>();

                return huyousyoruiValueList;
            }

            if (TESTPATTERN2.equals(SYORIPTN)){
                List<String> huyousyoruiValueList = new ArrayList<>();
                huyousyoruiValueList.add("sk001");

                return huyousyoruiValueList;
            }

            if (TESTPATTERN3.equals(SYORIPTN)){
                List<String> huyousyoruiValueList = new ArrayList<>();
                huyousyoruiValueList.add("sk016");

                return huyousyoruiValueList;
            }

            if (TESTPATTERN4.equals(SYORIPTN)){
                List<String> huyousyoruiValueList = new ArrayList<>();
                huyousyoruiValueList.add("sk012");
                huyousyoruiValueList.add("sk002");
                huyousyoruiValueList.add("sk011");
                huyousyoruiValueList.add("sk008");

                return huyousyoruiValueList;
            }

        }
        return super.getHuyousyoruiValueList();

    }




}
