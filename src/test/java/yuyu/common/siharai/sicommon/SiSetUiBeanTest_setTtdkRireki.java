package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewTetudukiInputUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setTtdkRireki(CommonViewUiBeanParam, JT_TtdkRireki)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setTtdkRireki {

    @Test
    @TestOrder(10)
    public void testSetTtdkRireki_A1() {

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setTtdkRireki(commonViewUiBeanParam, ttdkRireki);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetTtdkRireki_A2() {

        ViewTetudukiInputUiBeanParamImpl viewTetudukiInputUiBeanParamImpl = SWAKInjector
            .getInstance(ViewTetudukiInputUiBeanParamImpl.class);
        viewTetudukiInputUiBeanParamImpl.setSyanaicomment("AAA");

        JT_TtdkRireki ttdkRireki = null;

        SiSetUiBean.setTtdkRireki(viewTetudukiInputUiBeanParamImpl, ttdkRireki);

        exStringEquals(viewTetudukiInputUiBeanParamImpl.getSyanaicomment(), "AAA", "社内用コメント");

    }

    @Test
    @TestOrder(30)
    public void testSetTtdkRireki_A3() {

        ViewTetudukiInputUiBeanParamImpl viewTetudukiInputUiBeanParamImpl = SWAKInjector
            .getInstance(ViewTetudukiInputUiBeanParamImpl.class);
        viewTetudukiInputUiBeanParamImpl.setSyanaicomment("AAA");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSyanaicomment("BBB");

        SiSetUiBean.setTtdkRireki(viewTetudukiInputUiBeanParamImpl, ttdkRireki);

        exStringEquals(viewTetudukiInputUiBeanParamImpl.getSyanaicomment(), "BBB", "社内用コメント");

    }

    @Test
    @TestOrder(40)
    public void testSetTtdkRireki_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSkno("2002");

        SiSetUiBean.setTtdkRireki(viewSkKihonUiBeanParamImpl, ttdkRireki);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
