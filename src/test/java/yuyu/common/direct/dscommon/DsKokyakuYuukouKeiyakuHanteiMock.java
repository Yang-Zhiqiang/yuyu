package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link DsKokyakuYuukouKeiyakuHantei}のモッククラスです。<br />
 */
public class DsKokyakuYuukouKeiyakuHanteiMock extends DsKokyakuYuukouKeiyakuHantei {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public DsKokyakuYuukouKeiyakuHanteiBean exec(String pDsKokNo) {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = SWAKInjector.getInstance(DsKokyakuYuukouKeiyakuHanteiBean.class);

        if (caller == DsKokyakuYuukouKeiyakuHanteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            dsKokyakuYuukouKeiyakuHanteiBean.setYuukouKeiyakuUmuKbn(C_UmuKbn.ARI);
        }
        else if (caller == DsKokyakuYuukouKeiyakuHanteiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            dsKokyakuYuukouKeiyakuHanteiBean.setYuukouKeiyakuUmuKbn(C_UmuKbn.NONE);
        }
        else {
            dsKokyakuYuukouKeiyakuHanteiBean = super.exec(pDsKokNo);
        }
        return dsKokyakuYuukouKeiyakuHanteiBean;
    }
}
