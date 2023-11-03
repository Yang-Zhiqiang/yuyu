package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * 機能モード権限チェッククラスのメソッド {@link CheckKinouModeKengen#checkKengenByKinouModeIdByUserId(String, String)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckKinouModeKengenTest_checkKengenByKinouModeIdByUserId {

    @Inject
    AS_Kinou asKinou;

    @Inject
    BaseDomManager baseDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_機能モード権限チェック";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckKinouModeKengenTest_checkKengenByKinouModeIdByUserId.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector
            .getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllFileSyuruis());
    }

    @Test
    @TestOrder(10)
    public void testCheckKengenByKinouModeIdByUserId_A1() {


        String pUserId = "usery";
        String pKinouId = "skhubitouroku";
        String pKinouModeId = "input";
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean result = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(pUserId,pKinouId, pKinouModeId);
        exBooleanEquals(result, true, "権限有無");
    }

    @Test
    @TestOrder(20)
    public void testCheckKengenByKinouModeIdByUserId_A2() {

        String pUserId = "usery1";
        String pKinouId = "skhubitouroku";
        String pKinouModeId = "input";
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean result = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(pUserId,pKinouId, pKinouModeId);
        exBooleanEquals(result, false, "権限有無");
    }

    @Test
    @TestOrder(30)
    public void testCheckKengenByKinouModeIdByUserId_A3() {

        String pUserId = "usery";
        String pKinouId = "skhubitouroku1";
        String pKinouModeId = "input";
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean result = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(pUserId,pKinouId, pKinouModeId);
        exBooleanEquals(result, false, "権限有無");
    }

    @Test
    @TestOrder(40)
    public void testCheckKengenByKinouModeIdByUserId_A4() {

        String pUserId = "usery";
        String pKinouId = "skhubitouroku";
        String pKinouModeId = "input1";
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean result = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(pUserId,pKinouId, pKinouModeId);
        exBooleanEquals(result, false, "権限有無");
    }
}
