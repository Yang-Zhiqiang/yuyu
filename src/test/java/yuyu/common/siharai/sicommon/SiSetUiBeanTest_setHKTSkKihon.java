package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiInfoSkukeUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setHKTSkKihon(CommonViewUiBeanParam, JT_SkKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setHKTSkKihon {

    @Test
    @TestOrder(10)
    public void testSetHKTSkKihon_A1() {

        JT_SkKihon skKihon = new JT_SkKihon();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setHKTSkKihon(commonViewUiBeanParam, skKihon);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetHKTSkKihon_A2() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSyono("1001");

        SiSetUiBean.setHKTSkKihon(viewSkKihonUiBeanParamImpl, null);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1001", "証券番号");

    }

    @Test
    @TestOrder(30)
    public void testSetHKTSkKihon_A3() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSyono("1001");

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("1002");

        SiSetUiBean.setHKTSkKihon(viewSkKihonUiBeanParamImpl, skKihon);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1002", "証券番号");

    }

    @Test
    @TestOrder(40)
    public void testSetHKTSkKihon_A4() {

        ViewSiharaiInfoSkukeUiBeanParamImpl viewSiharaiInfoSkukeUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoSkukeUiBeanParamImpl.class);
        viewSiharaiInfoSkukeUiBeanParamImpl.setSyoruiukeymd(BizDate.valueOf(20160311));

        JT_SkKihon skKihon = new JT_SkKihon();

        SiSetUiBean.setHKTSkKihon(viewSiharaiInfoSkukeUiBeanParamImpl, skKihon);

        exDateEquals(viewSiharaiInfoSkukeUiBeanParamImpl.getSyoruiukeymd(), BizDate.valueOf(20160311), "書類受付日");

    }

}
