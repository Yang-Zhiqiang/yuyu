package yuyu.common.workflowcore;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import yuyu.common.base.BaseUserInfo;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.auth.RayHttpHeaderBeanMock;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー権限判定サービス {@link WorkflowAuthInfo#init()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class WorkflowAuthInfoTest {

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    WorkflowAuthInfo workflowAuthInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ワークフロー権限判定サービス";
    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            testDataAndTblMap = testDataMaker.getInData(WorkflowAuthInfoTest.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap, true);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);

        WT_KengenKoutei data = iwfCoreDomManager.getKengenKoutei("2090", "skinputmos", "mousikomisyo_1ji");

        WT_KengenSyorui data1 = iwfCoreDomManager.getKengenSyorui("2090", "kk051");
        WT_KengenSyorui data2 = iwfCoreDomManager.getKengenSyorui("2090", "TRKMSRCD0001@t2");

        iwfCoreDomManager.delete(data);
        iwfCoreDomManager.delete(data1);
        iwfCoreDomManager.delete(data2);
    }

    @BeforeClass
    public static void testInit() {
        RayHttpHeaderBeanMock.caller = WorkflowAuthInfoTest.class;
        RayHttpHeaderBeanMock.SYORIPTN = RayHttpHeaderBeanMock.TESTPATTERN1;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        RayHttpHeaderBeanMock.caller = null;
        RayHttpHeaderBeanMock.SYORIPTN = null;
        testDataAndTblMap = null;
    }

    @Test
    @TestOrder(10)
    public void testGetProcessAuth_OK() {
        try {
            Set<List<String>> roleCds = workflowAuthInfo.getProcessAuth();
            boolean result = (!roleCds.isEmpty()) ? true : false;
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(20)
    public void testGetImageAuth_OK() {
        try {
            Set<String> torikomiSyoruiCds = workflowAuthInfo.getImageAuth();
            boolean result = (!torikomiSyoruiCds.isEmpty()) ? true : false;
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(30)
    public void testGetProcessAuthByUserId_OK() {
        try {
            Set<List<String>> flowNodeIds = workflowAuthInfo.getProcessAuthByUserId("JUnit");
            boolean result = (!flowNodeIds.isEmpty()) ? true : false;
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(40)
    public void testGetProcessAuthByUserId_NG() {
        try {
            Set<List<String>> flowNodeIds = workflowAuthInfo.getProcessAuthByUserId("no_User");
            boolean result = (flowNodeIds.isEmpty()) ? true : false;
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(50)
    public void testgetImageAuthByUserId_OK() {
        try {
            Set<String> authsSyorui = workflowAuthInfo.getImageAuthByUserId("JUnit");
            boolean result = (!authsSyorui.isEmpty()) ? true : false;
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(60)
    public void testgetImageAuthByUserId_NG() {
        try {
            Set<String> authsSyorui = workflowAuthInfo.getImageAuthByUserId("no_User");
            boolean result = (authsSyorui.isEmpty()) ? true : false;
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(70)
    public void testHasProcessAuth_OK() {
        try {
            boolean result = workflowAuthInfo.hasProcessAuth("skinputmos", "mousikomisyo_1ji");
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(80)
    public void testHasProcessAuth_NG() {
        try {
            boolean result = workflowAuthInfo.hasProcessAuth("tt4", "data-check999");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(90)
    public void testHasImageAuth_OK() {
        try {
            boolean result = workflowAuthInfo.hasImageAuth("TRKMSRCD0001@t2");
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(100)
    public void testHasImageAuth_NG() {
        try {
            boolean result = workflowAuthInfo.hasImageAuth("syorui000001");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(109)
    @Transactional
    public void insertTestData1() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap, true);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(110)
    public void testGetProcessAuth_OK_Empty() {

        WorkflowAuthInfoImpl workflowAuthInfoImpl = SWAKInjector.getInstance(WorkflowAuthInfoImpl.class);
        try {
            boolean result = workflowAuthInfoImpl.hasProcessAuth("skinputmos", "mousikomisyo_1ji");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

}
