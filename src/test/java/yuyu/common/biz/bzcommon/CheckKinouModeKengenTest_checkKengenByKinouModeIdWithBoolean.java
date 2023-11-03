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
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 機能モード権限チェッククラスのメソッド {@link CheckKinouModeKengen#checkKengenByKinouModeIdWithBoolean(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKinouModeKengenTest_checkKengenByKinouModeIdWithBoolean {

    @Inject
    private KinouMode kinouMode;

    @Inject
    AS_Kinou asKinou;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou as_kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_機能モード権限チェック_000_03";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckKinouModeKengenTest_checkKengenByKinouModeIdWithBoolean.class, fileName, sheetName);
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
        baseDomManager.delete(baseDomManager.getUser("UI00000001"));
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        kinouMode.setKinouMode("default");
        as_kinou.setKinouId("skhubitouroku");
        AM_User user = new AM_User();
        user.setUserId("UI00000001");

        changeCurrentUser(baseUserInfo, user);
        String pKinouModeId = "B1000000001";
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean result = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(pKinouModeId);
        exStringEquals(kinouMode.getKinouMode(), "B1000000001", "機能モードID");
        exBooleanEquals(result, true, "権限有無");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        kinouMode.setKinouMode("default");
        as_kinou.setKinouId("skhubitouroku");
        AM_User user = new AM_User();
        user.setUserId("UI00000001");

        changeCurrentUser(baseUserInfo, user);
        String pKinouModeId = "inputfalse";
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean result = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(pKinouModeId);
        exStringEquals(kinouMode.getKinouMode(), "default", "機能モードID");
        exBooleanEquals(result, false, "権限有無");
    }
}
