package yuyu.common.siharai.sicommon;

import java.util.List;

import yuyu.common.siharai.siview.SiSetUiBeanSetSkKihonKanriUiBeanParam;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;

/**
 * {@link SiSetUiBean}のモッククラスです。<br />
 */
public class SiSetUiBeanMock extends SiSetUiBean {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public boolean setSkKihonKanri(SiSetUiBeanSetSkKihonKanriUiBeanParam pUiBean,
        List<DoujiSeikyuuInfosBySknoSyonoNeBean> pDoujiSeikyuuInfosBySknoSyonoNeBeanLst) {
        if (caller == SetteiDoujiSkInfoTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return false;
        }
        if (caller == SetteiDoujiSkInfoTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return true;
        }
        return super.setSkKihonKanri(pUiBean, pDoujiSeikyuuInfosBySknoSyonoNeBeanLst);
    }
}
