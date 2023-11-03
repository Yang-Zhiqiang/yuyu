package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 保険種類名取得クラスのメソッド {@link GetHknsyuruinm#getAisyoumeiMosnrk} テスト用クラスです。<br />
 */
public class GetHknsyuruinmTest_getAisyoumeiMosnrk extends AbstractTest {

    @Inject
    private GetHknsyuruinm getHknsyuruinm;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険種類名取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData1() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(GetHknsyuruinmTest_getAisyoumeiMosnrk.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        SinkeiyakuDomManager manager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        manager.delete(manager.getAllSkHokenSyuruiNoAisyou());
    }

    @Test
    @TestOrder(10)
    public void testGetAisyoumeiMosnrk_A1() {

        try {
            getHknsyuruinm.getAisyoumeiMosnrk(null, 101, C_SkeijimuKbn.TIGINSINKIN, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testGetAisyoumeiMosnrk_A2() {

        try {
            getHknsyuruinm.getAisyoumeiMosnrk("", 101, C_SkeijimuKbn.TIGINSINKIN, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testGetAisyoumeiMosnrk_A3() {

        try {
            getHknsyuruinm.getAisyoumeiMosnrk("411", null, C_SkeijimuKbn.TIGINSINKIN, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testGetAisyoumeiMosnrk_A4() {
        MockObjectManager.initialize();
        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk("441", 103, C_SkeijimuKbn.SMBC, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名２２２", "愛称名");
    }

    @Test
    @TestOrder(50)
    public void testGetAisyoumeiMosnrk_A5() {
        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk("442", 108, C_SkeijimuKbn.MIZUHO, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.SOKUJIHSY_MDHN, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名４４４", "愛称名");
    }

    @Test
    @TestOrder(60)
    public void testGetAisyoumeiMosnrk_A6() {
        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk("442", 115, C_SkeijimuKbn.SHOP, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.GAIKASYUUSIN_K2_SINKIN, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名５５５", "愛称名");
    }
    @Test
    @TestOrder(70)
    public void testGetAisyoumeiMosnrk_A7() {
        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk("441", 101, C_SkeijimuKbn.TIGINSINKIN, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名１１１", "愛称名");
    }

    @Test
    @TestOrder(80)
    public void testGetAisyoumeiMosnrk_A8() {
        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk("322", 1, C_SkeijimuKbn.YUUTYO, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.GAIKAINDEXNK_YUUSEI, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名６６６", "愛称名");
    }

    @Test
    @TestOrder(90)
    public void testGetAisyoumeiMosnrk_A9() {
        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk("322", 1, C_SkeijimuKbn.NIHONYUUBIN, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.GAIKAINDEXNK_YUUSEI, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名６６６", "愛称名");
    }

    @Test
    @TestOrder(100)
    public void testGetAisyoumeiMosnrk_A10() {
        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk("322", 1, C_SkeijimuKbn.KANPOSEIMEI, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.GAIKAINDEXNK_YUUSEI, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名６６６", "愛称名");
    }

    @Test
    @TestOrder(110)
    public void testGetAisyoumeiMosnrk_A11() {

        try {
            getHknsyuruinm.getAisyoumeiMosnrk("441", 103, C_SkeijimuKbn.SMBC, null);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }
}
