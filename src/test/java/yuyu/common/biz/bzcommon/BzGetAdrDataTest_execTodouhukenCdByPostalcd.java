package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 住所情報取得クラスのメソッド {@link BzGetAdrData#execTodouhukenCdByPostalcd(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetAdrDataTest_execTodouhukenCdByPostalcd extends AbstractTest {

    @Inject
    private BzGetAdrData bzGetAdrData;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_住所情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BzGetAdrDataTest_execTodouhukenCdByPostalcd.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    public void testexecTodouhukenCdByPostalcd_A1() {

        String postalCd = null;

        bzGetAdrData.execTodouhukenCdByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(bzGetAdrData.getTodouhukenCd(), C_TodouhukenKbn.BLNK, "都道府県コード");
    }

    @Test
    @TestOrder(20)
    public void testexecTodouhukenCdByPostalcd_A2() {

        String postalCd = "";

        bzGetAdrData.execTodouhukenCdByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(bzGetAdrData.getTodouhukenCd(), C_TodouhukenKbn.BLNK, "都道府県コード");
    }

    @Test
    @TestOrder(30)
    public void testexecTodouhukenCdByPostalcd_A3() {

        String postalCd = "226023";

        bzGetAdrData.execTodouhukenCdByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(bzGetAdrData.getTodouhukenCd(), C_TodouhukenKbn.BLNK, "都道府県コード");
    }

    @Test
    @TestOrder(40)
    public void testexecTodouhukenCdByPostalcd_A4() {

        String postalCd = "22602344";

        bzGetAdrData.execTodouhukenCdByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(bzGetAdrData.getTodouhukenCd(), C_TodouhukenKbn.BLNK, "都道府県コード");
    }

    @Test
    @TestOrder(50)
    public void testexecTodouhukenCdByPostalcd_A5() {

        String postalCd = "2260235";

        bzGetAdrData.execTodouhukenCdByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(bzGetAdrData.getTodouhukenCd(), C_TodouhukenKbn.BLNK, "都道府県コード");
    }

    @Test
    @TestOrder(60)
    public void testexecTodouhukenCdByPostalcd_A6() {

        String postalCd = "2260236";

        bzGetAdrData.execTodouhukenCdByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(bzGetAdrData.getTodouhukenCd(), C_TodouhukenKbn.BLNK, "都道府県コード");
    }

    @Test
    @TestOrder(70)
    public void testexecTodouhukenCdByPostalcd_A7() {

        String postalCd = "2260237";

        bzGetAdrData.execTodouhukenCdByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(bzGetAdrData.getTodouhukenCd(), C_TodouhukenKbn.TIBA, "都道府県コード");
    }
}
