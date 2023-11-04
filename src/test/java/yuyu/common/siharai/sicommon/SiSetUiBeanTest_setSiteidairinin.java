package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewSiteidrUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSiteidairinin(CommonViewUiBeanParam, JT_SiKykKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSiteidairinin {

    @Test
    @TestOrder(10)
    public void testSetSiteidairinin_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        SiSetUiBean.setSiteidairinin(commonViewUiBeanParam, siKykKihon);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSiteidairinin_A2() {

        ViewSiteidrUiBeanParamImpl viewSiteidrUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiteidrUiBeanParamImpl.class);
        viewSiteidrUiBeanParamImpl.setSiteidruktnmkn("AAA");

        JT_SiKykKihon siKykKihon = null;

        SiSetUiBean.setSiteidairinin(viewSiteidrUiBeanParamImpl, siKykKihon);

        exStringEquals(viewSiteidrUiBeanParamImpl.getSiteidruktnmkn(), "AAA", "指定代理受取人名（カナ）");

    }

    @Test
    @TestOrder(30)
    public void testSetSiteidairinin_A3() {

        ViewSiteidrUiBeanParamImpl viewSiteidrUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiteidrUiBeanParamImpl.class);
        viewSiteidrUiBeanParamImpl.setSiteidruktnmkn("AAA");
        viewSiteidrUiBeanParamImpl.setSiteidruktnmkj("BBB");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSiteidruktnmkn("CCC");
        siKykKihon.setSiteidruktnmkj("DDD");

        SiSetUiBean.setSiteidairinin(viewSiteidrUiBeanParamImpl, siKykKihon);

        exStringEquals(viewSiteidrUiBeanParamImpl.getSiteidruktnmkn(), "CCC", "指定代理受取人名（カナ）");
        exStringEquals(viewSiteidrUiBeanParamImpl.getSiteidruktnmkj(), "DDD", "指定代理受取人名（漢字）");

    }


    @Test
    @TestOrder(40)
    public void testSetSiteidairinin_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSyono("1002");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("2001");

        SiSetUiBean.setSiteidairinin(viewSkKihonUiBeanParamImpl, siKykKihon);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1002", "証券番号");

    }

}
