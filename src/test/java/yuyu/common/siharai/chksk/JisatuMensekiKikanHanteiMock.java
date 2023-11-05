package yuyu.common.siharai.chksk;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.sicommon.JisatuMensekiKikanHantei;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * {@link JisatuMensekiKikanHantei}のモッククラスです。<br />
 */
public class JisatuMensekiKikanHanteiMock extends JisatuMensekiKikanHantei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean exec(BizDate pHanteiKijyunYmd, BizDate pHksknnkaisiymd, JT_SiKykSyouhn pSiKykSyouhn,
        JM_SiSyouhnZokusei pSiSyouhnZokusei) {

        if (ChkSubSgSbJisatuMensekiTest_exec.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;

            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }
        if (ChkSubJisatuMensekiTest_exec.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;

            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return false;
            }
        }

        return super.exec(pHanteiKijyunYmd, pHksknnkaisiymd, pSiKykSyouhn, pSiSyouhnZokusei);

    }

}
