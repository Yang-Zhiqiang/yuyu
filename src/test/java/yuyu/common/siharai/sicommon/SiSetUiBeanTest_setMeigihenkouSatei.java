package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewmeigihenkousatei.ViewMeigihenkouSateiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setMeigihenkouSatei(CommonViewUiBeanParam, JT_SateiMeigihenkouInfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setMeigihenkouSatei {

    @Test
    @TestOrder(10)
    public void testSetMeigihenkouSatei_A1() {

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = new JT_SateiMeigihenkouInfo();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setMeigihenkouSatei(commonViewUiBeanParam, sateiMeigihenkouInfo);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetMeigihenkouSatei_A2() {

        ViewMeigihenkouSateiUiBeanParamImpl viewMeigihenkouSateiUiBeanParamImpl = SWAKInjector
                .getInstance(ViewMeigihenkouSateiUiBeanParamImpl.class);
        viewMeigihenkouSateiUiBeanParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = null;

        SiSetUiBean.setMeigihenkouSatei(viewMeigihenkouSateiUiBeanParamImpl, sateiMeigihenkouInfo);

        exClassificationEquals(viewMeigihenkouSateiUiBeanParamImpl.getMeihenyuukoumukoukbn(),
                C_MeihenYuukouMukouKbn.BLNK, "名義変更有効無効区分");

    }

    @Test
    @TestOrder(30)
    public void testSetMeigihenkouSatei_A3() {

        ViewMeigihenkouSateiUiBeanParamImpl viewMeigihenkouSateiUiBeanParamImpl = SWAKInjector
                .getInstance(ViewMeigihenkouSateiUiBeanParamImpl.class);
        viewMeigihenkouSateiUiBeanParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);
        viewMeigihenkouSateiUiBeanParamImpl.setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        viewMeigihenkouSateiUiBeanParamImpl.setMeihenuktnm("AAA");

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = new JT_SateiMeigihenkouInfo();
        sateiMeigihenkouInfo.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        sateiMeigihenkouInfo.setMeihenuktkbn(C_MeihenUktKbn.SOUI);
        sateiMeigihenkouInfo.setMeihenuktnm("BBB");

        SiSetUiBean.setMeigihenkouSatei(viewMeigihenkouSateiUiBeanParamImpl, sateiMeigihenkouInfo);

        exClassificationEquals(viewMeigihenkouSateiUiBeanParamImpl.getMeihenyuukoumukoukbn(),
                C_MeihenYuukouMukouKbn.ENABLE, "名義変更有効無効区分");
        exClassificationEquals(viewMeigihenkouSateiUiBeanParamImpl.getMeihenuktkbn(), C_MeihenUktKbn.SOUI, "名義変更受取人区分");
        exStringEquals(viewMeigihenkouSateiUiBeanParamImpl.getMeihenuktnm(), "BBB", "名義変更受取人名");

    }

    @Test
    @TestOrder(40)
    public void testSetMeigihenkouSatei_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = new JT_SateiMeigihenkouInfo();
        sateiMeigihenkouInfo.setSkno("2002");

        SiSetUiBean.setMeigihenkouSatei(viewSkKihonUiBeanParamImpl, sateiMeigihenkouInfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
