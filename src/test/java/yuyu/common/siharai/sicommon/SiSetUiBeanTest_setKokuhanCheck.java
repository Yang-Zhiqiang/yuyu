package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewkokuhancheck.ViewKokuhanCheckUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setKokuhanCheck(CommonViewUiBeanParam, JT_SateiKokuhanInfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setKokuhanCheck {

    @Test
    @TestOrder(10)
    public void testSetKokuhanCheck_A1() {

        JT_SateiKokuhanInfo sateiKokuhanInfo = new JT_SateiKokuhanInfo();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setKokuhanCheck(commonViewUiBeanParam, sateiKokuhanInfo);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetKokuhanCheck_A2() {

        ViewKokuhanCheckUiBeanParamImpl viewKokuhanCheckUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKokuhanCheckUiBeanParamImpl.class);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);

        JT_SateiKokuhanInfo sateiKokuhanInfo = null;

        SiSetUiBean.setKokuhanCheck(viewKokuhanCheckUiBeanParamImpl, sateiKokuhanInfo);

        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn1(), null, "告反チェック区分１");

    }

    @Test
    @TestOrder(30)
    public void testSetKokuhanCheck_A3() {

        ViewKokuhanCheckUiBeanParamImpl viewKokuhanCheckUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKokuhanCheckUiBeanParamImpl.class);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck1(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment1("11");
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck2(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment2("12");
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck3(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment3("13");
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck4(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment4("14");
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck5(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment5("15");
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck6(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment6("16");
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck7(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment7("17");
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        viewKokuhanCheckUiBeanParamImpl.setKokuhancheck8(true);
        viewKokuhanCheckUiBeanParamImpl.setKokuhanchecomment8("18");

        JT_SateiKokuhanInfo sateiKokuhanInfo = new JT_SateiKokuhanInfo();
        sateiKokuhanInfo.setKokuhancheckkbn1(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment1("21");
        sateiKokuhanInfo.setKokuhancheckkbn2(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment2("22");
        sateiKokuhanInfo.setKokuhancheckkbn3(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment3("23");
        sateiKokuhanInfo.setKokuhancheckkbn4(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment4("24");
        sateiKokuhanInfo.setKokuhancheckkbn5(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment5("25");
        sateiKokuhanInfo.setKokuhancheckkbn6(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment6("26");
        sateiKokuhanInfo.setKokuhancheckkbn7(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment7("27");
        sateiKokuhanInfo.setKokuhancheckkbn8(C_UmuKbn.ARI);
        sateiKokuhanInfo.setKokuhanchecomment8("28");

        SiSetUiBean.setKokuhanCheck(viewKokuhanCheckUiBeanParamImpl, sateiKokuhanInfo);

        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn1(), C_UmuKbn.ARI, "告反チェック区分１");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck1(), true, "告反チェック１");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment1(), "21", "告反チェックコメント１");
        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn2(), C_UmuKbn.ARI, "告反チェック区分２");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck2(), true, "告反チェック２");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment2(), "22", "告反チェックコメント２");
        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn3(), C_UmuKbn.ARI, "告反チェック区分３");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck3(), true, "告反チェック３");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment3(), "23", "告反チェックコメント３");
        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn4(), C_UmuKbn.ARI, "告反チェック区分４");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck4(), true, "告反チェック４");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment4(), "24", "告反チェックコメント４");
        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn5(), C_UmuKbn.ARI, "告反チェック区分５");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck5(), true, "告反チェック５");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment5(), "25", "告反チェックコメント５");
        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn6(), C_UmuKbn.ARI, "告反チェック区分６");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck6(), true, "告反チェック６");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment6(), "26", "告反チェックコメント６");
        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn7(), C_UmuKbn.ARI, "告反チェック区分７");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck7(), true, "告反チェック７");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment7(), "27", "告反チェックコメント７");
        exClassificationEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheckkbn8(), C_UmuKbn.ARI, "告反チェック区分８");
        exBooleanEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhancheck8(), true, "告反チェック８");
        exStringEquals(viewKokuhanCheckUiBeanParamImpl.getKokuhanchecomment8(), "28", "告反チェックコメント８");

    }

    @Test
    @TestOrder(40)
    public void testSetKokuhanCheck_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SateiKokuhanInfo sateiKokuhanInfo = new JT_SateiKokuhanInfo();
        sateiKokuhanInfo.setSkno("2002");

        SiSetUiBean.setKokuhanCheck(viewSkKihonUiBeanParamImpl, sateiKokuhanInfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
