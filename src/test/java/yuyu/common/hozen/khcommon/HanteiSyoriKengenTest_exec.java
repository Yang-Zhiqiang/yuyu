package yuyu.common.hozen.khcommon;

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
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理権限判定のメソッド {@link HanteiSyoriKengen#exec()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiSyoriKengenTest_exec {

    @Inject
    private HanteiSyoriKengen hanteiSyoriKengen;

    @Inject
    private KinouMode kinouMode;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    AS_Kinou asKinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_処理権限判定";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiSyoriKengenTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BaseDomManager baseDomManager = SWAKInjector
            .getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getUser("administrator1"));
        baseDomManager.delete(baseDomManager.getUser("administrator2"));
        baseDomManager.delete(baseDomManager.getUser("administrator4"));
        baseDomManager.delete(baseDomManager.getKinou("kinouId1"));
        baseDomManager.delete(baseDomManager.getKinou("kinouId2"));
        baseDomManager.delete(baseDomManager.getKinou("kinouId4"));
        baseDomManager.delete(baseDomManager.getRole("administrator1"));
        baseDomManager.delete(baseDomManager.getRole("administrator2"));
        baseDomManager.delete(baseDomManager.getRole("administrator4"));
        baseDomManager.delete(baseDomManager.getAllCategories());
        baseDomManager.delete(baseDomManager.getAllSubSystems());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        asKinou.setKinouId("kinouId1");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator1"));
        hanteiSyoriKengen.exec();

        exStringEquals(kinouMode.getKinouMode(), "inputkey", "機能モード");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        asKinou.setKinouId("kinouId2");
        kinouMode.setKinouMode("default");
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator2"));
        hanteiSyoriKengen.exec();

        exStringEquals(kinouMode.getKinouMode(), "syoukai", "機能モード");
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        try {
            asKinou.setKinouId("kinouId4");
            kinouMode.setKinouMode("default");
            changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator4"));
            hanteiSyoriKengen.exec();

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "この機能を使用する権限がありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        kinouMode.setKinouMode("input");
        hanteiSyoriKengen.exec();

        exStringEquals(kinouMode.getKinouMode(), "input", "機能モード");
    }
}
