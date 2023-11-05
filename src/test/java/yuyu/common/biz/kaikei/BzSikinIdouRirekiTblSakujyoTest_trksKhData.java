package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.AbstractTest;

/**
 * 資金移動用履歴テーブル削除のメソッド {@link BzSikinIdouRirekiTblSakujyo#trksKhData(String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouRirekiTblSakujyoTest_trksKhData extends AbstractTest {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzSikinIdouRirekiTblSakujyo bzSikinIdouRirekiTblSakujyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_資金移動用履歴テーブル削除";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzFurikaeDenpyouJouhouTest_furikaeDenPageList.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());
    }

    @Test
    @TestOrder(10)
    public void testTrksKhData_A1() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksKhData("17806000013", "101");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testTrksKhData_A2() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksKhData("17806000035", "120");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testTrksKhData_A3() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksKhData("99806039693", "130");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_SikinIdouRireki sikinIdouRireki = bizDomManager.getSikinIdouRireki(BizDate.valueOf("20201005"), "1");
        exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.SAKUJYO, "削除フラグ");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testTrksKhData_A4() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksKhData("99806039176", "140");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        for (int i = 1; i < 3; i++) {
           BT_SikinIdouRireki sikinIdouRireki = bizDomManager.getSikinIdouRireki(BizDate.valueOf("20201010"), String.valueOf(i));
           exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.SAKUJYO, "削除フラグ");
        }
    }
}
