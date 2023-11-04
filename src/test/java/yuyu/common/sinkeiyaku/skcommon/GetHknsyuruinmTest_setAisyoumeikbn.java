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
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 保険種類名取得クラスのメソッド {@link GetHknsyuruinm#setAisyoumeikbn} テスト用クラスです。<br />
 */
public class GetHknsyuruinmTest_setAisyoumeikbn extends AbstractTest {

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

            testDataAndTblMap = testDataMaker.getInData(GetHknsyuruinmTest_setAisyoumeikbn.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

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
    public void testSetAisyoumeikbn_A1() {

        try {
            getHknsyuruinm.setAisyoumeikbn(null, 101, C_AisyoumeiChannelKbn.MADOHAN, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testSetAisyoumeikbn_A2() {

        try {
            getHknsyuruinm.setAisyoumeikbn("", 101, C_AisyoumeiChannelKbn.MADOHAN, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testSetAisyoumeikbn_A3() {

        try {
            getHknsyuruinm.setAisyoumeikbn("111", null, C_AisyoumeiChannelKbn.MADOHAN, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testSetAisyoumeikbn_A4() {

        try {
            getHknsyuruinm.setAisyoumeikbn("111", 101, null, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testSetAisyoumeikbn_A5() {

        try {
            getHknsyuruinm.setAisyoumeikbn("111", 101, C_AisyoumeiChannelKbn.BLNK, "ﾕﾁ");

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testSetAisyoumeikbn_A6() {

        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.setAisyoumeikbn("443", 102, C_AisyoumeiChannelKbn.SMBC, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.BLNK, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "", "愛称名");

    }

    @Test
    @TestOrder(70)
    public void testSetAisyoumeikbn_A7() {
        MockObjectManager.initialize();

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean = getHknsyuruinm.setAisyoumeikbn("442", 115, C_AisyoumeiChannelKbn.SHOP, "ﾕﾁ");

        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.SOKUJIHSY_SMBC, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "愛称名５５５", "愛称名");
    }
}
