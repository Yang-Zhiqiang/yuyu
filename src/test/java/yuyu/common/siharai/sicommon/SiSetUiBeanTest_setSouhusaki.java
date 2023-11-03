package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewKeiyakusyaSouhusakiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSouhusaki(CommonViewUiBeanParam, JT_SiKykKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSouhusaki {

    @Test
    @TestOrder(10)
    public void testSetSouhusaki_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        SiSetUiBean.setSouhusaki(commonViewUiBeanParam, siKykKihon);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSouhusaki_A2() {

        ViewKeiyakusyaSouhusakiUiBeanParamImpl viewKeiyakusyaSouhusakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKeiyakusyaSouhusakiUiBeanParamImpl.class);
        viewKeiyakusyaSouhusakiUiBeanParamImpl.setTdkdtsinyno("1001");

        JT_SiKykKihon siKykKihon = null;

        SiSetUiBean.setSouhusaki(viewKeiyakusyaSouhusakiUiBeanParamImpl, siKykKihon);

        exStringEquals(viewKeiyakusyaSouhusakiUiBeanParamImpl.getTdkdtsinyno(), "1001", "（届出）通信先郵便番号");

    }

    @Test
    @TestOrder(30)
    public void testSetSouhusaki_A3() {

        ViewKeiyakusyaSouhusakiUiBeanParamImpl viewKeiyakusyaSouhusakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKeiyakusyaSouhusakiUiBeanParamImpl.class);
        viewKeiyakusyaSouhusakiUiBeanParamImpl.setTdkdtsinyno("1001");
        viewKeiyakusyaSouhusakiUiBeanParamImpl.setTdkdtsinadr1kj("AAA");
        viewKeiyakusyaSouhusakiUiBeanParamImpl.setTdkdtsinadr2kj("BBB");
        viewKeiyakusyaSouhusakiUiBeanParamImpl.setTdkdtsinadr3kj("CCC");
        viewKeiyakusyaSouhusakiUiBeanParamImpl.setTdkdtsintelno1("1002");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTsinyno("2001");
        siKykKihon.setTsinadr1kj("DDD");
        siKykKihon.setTsinadr2kj("EEE");
        siKykKihon.setTsinadr3kj("FFF");
        siKykKihon.setTsintelno("2002");

        SiSetUiBean.setSouhusaki(viewKeiyakusyaSouhusakiUiBeanParamImpl, siKykKihon);

        exStringEquals(viewKeiyakusyaSouhusakiUiBeanParamImpl.getTdkdtsinyno(), "2001", "（届出）通信先郵便番号");
        exStringEquals(viewKeiyakusyaSouhusakiUiBeanParamImpl.getTdkdtsinadr1kj(), "DDD", "（届出）通信先住所（漢字）１");
        exStringEquals(viewKeiyakusyaSouhusakiUiBeanParamImpl.getTdkdtsinadr2kj(), "EEE", "（届出）通信先住所（漢字）２");
        exStringEquals(viewKeiyakusyaSouhusakiUiBeanParamImpl.getTdkdtsinadr3kj(), "FFF", "（届出）通信先住所（漢字）３");
        exStringEquals(viewKeiyakusyaSouhusakiUiBeanParamImpl.getTdkdtsintelno1(), "2002", "（届出）通信先電話番号１");

    }

    @Test
    @TestOrder(40)
    public void testSetSouhusaki_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSyono("1002");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("2001");

        SiSetUiBean.setSouhusaki(viewSkKihonUiBeanParamImpl, siKykKihon);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1002", "証券番号");

    }

}
