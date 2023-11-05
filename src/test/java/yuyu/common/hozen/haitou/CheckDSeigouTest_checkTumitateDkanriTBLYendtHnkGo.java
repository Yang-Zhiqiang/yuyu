package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当整合チェッククラスのメソッド {@link CheckDSeigou#checkTumitateDkanriTBLYendtHnkGo(IT_KhTumitateDKanri)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkGo {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当整合チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkGo.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(310)
    public void testCheckTumitateDkanriTBLYendtHnkGo_A1() {

        IT_KhTumitateDKanri khTumitateDKanri = null;

        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkGo(khTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "処理結果");
    }

    @Test
    @TestOrder(320)
    public void testCheckTumitateDkanriTBLYendtHnkGo_A2() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        khTumitateDKanri.setKbnkey("02");
        khTumitateDKanri.setSyono("60806000022");
        khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180609));
        khTumitateDKanri.setRenno(1);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkGo(khTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "処理結果");
    }
}
