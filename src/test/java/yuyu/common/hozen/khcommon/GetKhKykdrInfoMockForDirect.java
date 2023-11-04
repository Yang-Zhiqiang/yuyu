package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.dsweb.dwhozeninfo.dwgethozentrkkzkinfo.DwGetHozenTrkkzkInfoTest_execPostForm;
import yuyu.common.direct.dscommon.DsGetKeiyakuCommonTest_getKykUkt;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約者代理人情報取得{@link GetKhKykdrInfo}のモッククラスです。<br />
 */
public class GetKhKykdrInfoMockForDirect extends GetKhKykdrInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public GetKhKykdrInfoBean exec(IT_KykKihon pKykkihon) {

        if (caller == DsGetKeiyakuCommonTest_getKykUkt.class) {

            GetKhKykdrInfoBean getKhKykdrInfoBean = SWAKInjector.getInstance(GetKhKykdrInfoBean.class);

            if (TESTPATTERN1.equals(SYORIPTN)) {

                getKhKykdrInfoBean.setKkdairinmKn("ケイヤクダイリニン");

                return getKhKykdrInfoBean;
            }
        }

        if (caller == DwGetHozenTrkkzkInfoTest_execPostForm.class) {

            GetKhKykdrInfoBean getKhKykdrInfoBean = SWAKInjector.getInstance(GetKhKykdrInfoBean.class);

            if (TESTPATTERN1.equals(SYORIPTN)) {

                getKhKykdrInfoBean.setKkdairinmKn("ユウケメイ　イチア");

                getKhKykdrInfoBean.setKkdairinmKj("ユ受名　一あ");
                getKhKykdrInfoBean.setKkdairinmKjkhukaKbn(C_KjkhukaKbn.KJKHUKA);
                getKhKykdrInfoBean.setKykdryNo("4354001");
                getKhKykdrInfoBean.setKykdradr1("住所１");
                getKhKykdrInfoBean.setKykdradr2("住所２");
                getKhKykdrInfoBean.setKykdradr3("住所３");
                getKhKykdrInfoBean.setKykdrtelno("023-5677-7999");

                return getKhKykdrInfoBean;
            }
        }
        return super.exec(pKykkihon);
    }
}
