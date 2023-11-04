package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備未解消リストＰＤＦ作成のメソッド{@link EditPdfHubiMikai#exec(BizDate,String,String,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPdfHubiMikaiTest_exec {

    @Inject
    private EditPdfHubiMikai editPdfHubiMikai;

    private final static String fileName = "UT-SP_単体テスト仕様書_不備未解消リストPDF作成";
    private final static String sheetName = "テストデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ExDBEntityManager exDBEntityManager = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql = "delete from " + "AT_TyouhyouHozon";
        exDBEntityManager.createJPQL(jpql).executeUpdate();

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(EditPdfHubiMikaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        testDataAndTblMap = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSubSystems());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHubiMikaisyouList());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A1() {

        BizDate syoriYmd = BizDate.valueOf("20151115");
        String categoryId = "123";
        String kinouId = "456";
        String kakutyouJobCd = "101";
        exNumericEquals(editPdfHubiMikai.exec(syoriYmd, categoryId, kinouId, kakutyouJobCd), 0, "出力件数");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A2_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A2() {

        BizDate syoriYmd = BizDate.valueOf("20151231");
        String categoryId = "123";
        String kinouId = "456";
        String kakutyouJobCd = "101";
        exNumericEquals(editPdfHubiMikai.exec(syoriYmd, categoryId, kinouId, kakutyouJobCd), 1, "出力件数");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A3_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A3() {

        BizDate syoriYmd = BizDate.valueOf("20160301");
        String categoryId = "123";
        String kinouId = "456";
        String kakutyouJobCd = "101";
        exNumericEquals(editPdfHubiMikai.exec(syoriYmd, categoryId, kinouId, kakutyouJobCd), 26, "出力件数");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A4_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A4() {

        BizDate syoriYmd = BizDate.valueOf("20151115");
        String categoryId = "123";
        String kinouId = "456";
        String kakutyouJobCd = "101";
        exNumericEquals(editPdfHubiMikai.exec(syoriYmd, categoryId, kinouId, kakutyouJobCd), 0, "出力件数");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A5_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A5() {

        BizDate syoriYmd = BizDate.valueOf("20160301");
        String categoryId = "123";
        String kinouId = "456";
        String kakutyouJobCd = "101";
        exNumericEquals(editPdfHubiMikai.exec(syoriYmd, categoryId, kinouId, kakutyouJobCd), 1, "出力件数");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A6_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A6() {

        BizDate syoriYmd = BizDate.valueOf("20170301");
        String categoryId = "234";
        String kinouId = "567";
        String kakutyouJobCd = "202";
        exNumericEquals(editPdfHubiMikai.exec(syoriYmd, categoryId, kinouId, kakutyouJobCd), 1, "出力件数");
    }
}