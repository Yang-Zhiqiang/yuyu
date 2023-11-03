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
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険種類名取得クラスのメソッド {@link GetHknsyuruinm#getHknsyuruinm} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetHknsyuruinmTest_getHknsyuruinm  extends AbstractTest {

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

            testDataAndTblMap = testDataMaker.getInData(GetHknsyuruinmTest_getHknsyuruinm.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        SinkeiyakuDomManager manager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        manager.delete(manager.getAllSkHokenSyuruiNo());
    }

    @Test
    @TestOrder(10)
    public void testGetHknsyuruinm_A1() {

        try {
            getHknsyuruinm.getHknsyuruinm(null, 101, C_AisyoumeiKbn.SOKUJIHSY_MDHN);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testGetHknsyuruinm_A2() {

        try {
            getHknsyuruinm.getHknsyuruinm(C_HknsyuruiNo.BLNK, 101, C_AisyoumeiKbn.SOKUJIHSY_MDHN);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testGetHknsyuruinm_A3() {

        try {
            getHknsyuruinm.getHknsyuruinm(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 101, null);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testGetHknsyuruinm_A4() {

        try {
            getHknsyuruinm.getHknsyuruinm(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 101, C_AisyoumeiKbn.BLNK);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testGetHknsyuruinm_A5() {

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean =  getHknsyuruinm.getHknsyuruinm(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, null, C_AisyoumeiKbn.SOKUJIHSY_MDHN);

        exStringEquals(hknsyuruinmBean.getHknsyuruinm(), "保険種類名３３３", "保険種類名");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "ふるはーと外貨（即時保障型）", "愛称名");
        exStringEquals(hknsyuruinmBean.getAisyoumeikakko(), "「ふるはーと外貨（即時保障型）」", "愛称名（括弧）");
        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.SOKUJIHSY_MDHN, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getKokyakuhknnsyuruinm(),"保険種類名３３３ 「ふるはーと外貨（即時保障型）」"," 顧客用保険種類名");
        exStringEquals(hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou1(),"保険種類名３３３","顧客用保険種類名1（２行表示）");
        exStringEquals(hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou2(),"「ふるはーと外貨（即時保障型）」","顧客用保険種類名2（２行表示）");
    }

    @Test
    @TestOrder(60)
    public void testGetHknsyuruinm_A6() {

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);
        try {
            getHknsyuruinm.getHknsyuruinm(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, 0, C_AisyoumeiKbn.SOKUJIHSY_MDHN);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。保険種類番号=443　保険種類番号世代=0", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testGetHknsyuruinm_A7() {

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        hknsyuruinmBean =  getHknsyuruinm.getHknsyuruinm(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 102, C_AisyoumeiKbn.SOKUJIHSY_MDHN);

        exStringEquals(hknsyuruinmBean.getHknsyuruinm(), "保険種類名２２２", "保険種類名");
        exStringEquals(hknsyuruinmBean.getAisyoumei(), "ふるはーと外貨（即時保障型）", "愛称名");
        exStringEquals(hknsyuruinmBean.getAisyoumeikakko(), "「ふるはーと外貨（即時保障型）」", "愛称名（括弧）");
        exClassificationEquals(hknsyuruinmBean.getAisyoumeikbn(),  C_AisyoumeiKbn.SOKUJIHSY_MDHN, "愛称名区分");
        exStringEquals(hknsyuruinmBean.getKokyakuhknnsyuruinm(),"保険種類名２２２ 「ふるはーと外貨（即時保障型）」"," 顧客用保険種類名");
        exStringEquals(hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou1(),"保険種類名２２２","顧客用保険種類名1（２行表示）");
        exStringEquals(hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou2(),"「ふるはーと外貨（即時保障型）」","顧客用保険種類名2（２行表示）");

    }

}
