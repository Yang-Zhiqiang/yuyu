package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutokuTest_getInfos;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * {@link GetKhKykdrInfo}のモッククラスです。<br />
 */
public class GetKhKykdrInfoMockForSiharai extends GetKhKykdrInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public GetKhKykdrInfoBean exec(IT_KykKihon pKykkihon) {

        if (caller == KeiyakuInfoSyutokuTest_getInfos.class) {
            GetKhKykdrInfoBean getKhKykdrInfoBean = SWAKInjector.getInstance(GetKhKykdrInfoBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return getKhKykdrInfoBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                getKhKykdrInfoBean.setKkdairinmKn("ケイダイメイ　イチア");
                getKhKykdrInfoBean.setKkdairinmKj("契代名　一あ");
                getKhKykdrInfoBean.setKkdairinmKjkhukaKbn(C_KjkhukaKbn.KJKHUKA);
                getKhKykdrInfoBean.setKykdryNo("0001111");
                getKhKykdrInfoBean.setKykdradr1("住所１");
                getKhKykdrInfoBean.setKykdradr2("住所２");
                getKhKykdrInfoBean.setKykdradr3("住所３");
                getKhKykdrInfoBean.setKykdrseiymd(BizDate.valueOf("19800101"));
                getKhKykdrInfoBean.setKykdrtelno("080-1111-1111");

                return getKhKykdrInfoBean;
            }
        }
        return super.exec(pKykkihon);

    }
}
