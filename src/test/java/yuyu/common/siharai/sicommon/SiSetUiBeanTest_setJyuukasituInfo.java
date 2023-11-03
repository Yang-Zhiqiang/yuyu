package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setJyuukasituInfo(CommonViewUiBeanParam, JT_SateiJyuukasituChkInfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setJyuukasituInfo {

    @Test
    @TestOrder(10)
    public void testSetJyuukasituInfo_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = new JT_SateiJyuukasituChkInfo();
        SiSetUiBean.setJyuukasituInfo(commonViewUiBeanParam, sateiJyuukasituChkInfo);

        assertNull("呼出元UiBean", commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetJyuukasituInfo_A2() {

        ViewJyuukasituInfoUiBeanParamImpl viewJyuukasituInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewJyuukasituInfoUiBeanParamImpl.class);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck1(true);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn1(C_UmuKbn.ARI);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment1("重過失チェックコメント１");
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck2(true);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn2(C_UmuKbn.ARI);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment2("重過失チェックコメント２");
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck3(true);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn3(C_UmuKbn.ARI);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment3("重過失チェックコメント３");
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck4(true);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn4(C_UmuKbn.ARI);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment4("重過失チェックコメント４");

        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = new JT_SateiJyuukasituChkInfo();
        sateiJyuukasituChkInfo = null;

        SiSetUiBean.setJyuukasituInfo(viewJyuukasituInfoUiBeanParamImpl, sateiJyuukasituChkInfo);

        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck1(), false, "重過失チェック１");
        assertNull("重過失チェック区分１",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn1());
        assertNull("重過失チェックコメント１",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment1());
        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck2(), false, "重過失チェック２");
        assertNull("重過失チェック区分２",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn2());
        assertNull("重過失チェックコメント２",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment2());
        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck3(), false, "重過失チェック３");
        assertNull("重過失チェック区分３",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn3());
        assertNull("重過失チェックコメント３",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment3());
        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck4(), false, "重過失チェック４");
        assertNull("重過失チェック区分４",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn4());
        assertNull("重過失チェックコメント４",viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment4());

    }

    @Test
    @TestOrder(30)
    public void testSetJyuukasituInfo_A3() {

        ViewJyuukasituInfoUiBeanParamImpl viewJyuukasituInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewJyuukasituInfoUiBeanParamImpl.class);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck1(true);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment1("重過失チェックコメント１");
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck2(false);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn2(C_UmuKbn.ARI);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment2("重過失チェックコメント２");
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck3(true);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment3("重過失チェックコメント３");
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheck4(false);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckkbn4(C_UmuKbn.ARI);
        viewJyuukasituInfoUiBeanParamImpl.setJuukasitucheckcomment4("重過失チェックコメント４");

        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = new JT_SateiJyuukasituChkInfo();
        sateiJyuukasituChkInfo.setJuukasitucheckkbn1(C_UmuKbn.ARI);
        sateiJyuukasituChkInfo.setJuukasitucheckcomment1("重過失チェックコメント１チェック有り");
        sateiJyuukasituChkInfo.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        sateiJyuukasituChkInfo.setJuukasitucheckcomment2("重過失チェックコメント２チェック無し");
        sateiJyuukasituChkInfo.setJuukasitucheckkbn3(C_UmuKbn.ARI);
        sateiJyuukasituChkInfo.setJuukasitucheckcomment3("重過失チェックコメント３チェック有り");
        sateiJyuukasituChkInfo.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        sateiJyuukasituChkInfo.setJuukasitucheckcomment4("重過失チェックコメント４チェック無し");

        SiSetUiBean.setJyuukasituInfo(viewJyuukasituInfoUiBeanParamImpl, sateiJyuukasituChkInfo);

        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck1(), true, "重過失チェック１");
        exClassificationEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn1(), C_UmuKbn.ARI, "重過失チェック区分１");
        exStringEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment1(), "重過失チェックコメント１チェック有り",
            "重過失チェックコメント１");
        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck2(), false, "重過失チェック２");
        exClassificationEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn2(), C_UmuKbn.NONE, "重過失チェック区分２");
        exStringEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment2(), "重過失チェックコメント２チェック無し",
            "重過失チェックコメント２");
        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck3(), true, "重過失チェック３");
        exClassificationEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn3(), C_UmuKbn.ARI, "重過失チェック区分３");
        exStringEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment3(), "重過失チェックコメント３チェック有り",
            "重過失チェックコメント３");
        exBooleanEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheck4(), false, "重過失チェック４");
        exClassificationEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckkbn4(), C_UmuKbn.NONE, "重過失チェック区分４");
        exStringEquals(viewJyuukasituInfoUiBeanParamImpl.getJuukasitucheckcomment4(), "重過失チェックコメント４チェック無し",
            "重過失チェックコメント４");

    }

    @Test
    @TestOrder(40)
    public void testSetJyuukasituInfo_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSyono("1002");

        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = new JT_SateiJyuukasituChkInfo();
        sateiJyuukasituChkInfo.setSyono("2001");

        SiSetUiBean.setJyuukasituInfo(viewSkKihonUiBeanParamImpl, sateiJyuukasituChkInfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1002", "証券番号");

    }

}
