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
import yuyu.common.biz.exception.KinouModeKengenException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * 機能モード権限チェッククラスのメソッド {@link CheckKinouModeKengen#checkKengenByKinouModeId(String)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckKinouModeKengenTest_checkKengenByKinouModeId {

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

    private final static String fileName = "UT_SP_単体テスト仕様書_機能モード権限チェック";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckKinouModeKengenTest_checkKengenByKinouModeId.class, fileName, sheetName);
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
        baseDomManager.delete(baseDomManager.getUser("usery"));
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testCheckKengenByKinouModeId_A1() {

        kinouMode.setKinouMode("default");
        as_kinou.setKinouId("skhubitouroku");
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("usery"));
        String pKinouModeId = "input";
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkKengenByKinouModeId(pKinouModeId);
        exStringEquals(kinouMode.getKinouMode(), "input", "機能モードID");
    }

    @Test(expected = KinouModeKengenException.class)
    @TestOrder(20)
    @Transactional
    public void testCheckKengenByKinouModeId_A2() {
        kinouMode.setKinouMode("default");
        as_kinou.setKinouId("skhubitouroku");
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("usery"));
        String pKinouModeId = "mousikomisyo_1ji";
        try
        {
            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
            checkKinouModeKengen.checkKengenByKinouModeId(pKinouModeId);
        } catch (KinouModeKengenException e) {
            exStringEquals(e.getMessage(), "この機能へのアクセス権限がありません。", "エラーメッセージ");
            throw e;
        }

    }

}
