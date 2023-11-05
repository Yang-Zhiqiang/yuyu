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
 * 資金移動用履歴テーブル削除クラスのメソッド {@link BzSikinIdouRirekiTblSakujyo#trksHkkData(String, String, Integer)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouRirekiTblSakujyoTest_trksHkkData extends AbstractTest {

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
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksHkkData("17806000035", "001", 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testTrksKhData_A2() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksHkkData("17806000068", "102", 20);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testTrksKhData_A3() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksHkkData("17806000079", "003", 31);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testTrksKhData_A4() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksHkkData("17806000080", "004", 40);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BT_SikinIdouRireki sikinIdouRireki = bizDomManager.getSikinIdouRireki(BizDate.valueOf("20201009"), "2");
        exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.SAKUJYO, "削除フラグ");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testTrksKhData_A5() {
        C_ErrorKbn errorKbn = bzSikinIdouRirekiTblSakujyo.trksHkkData("99806039992", "005", 50);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    	for (int i = 1; i < 3; i++) {
           BT_SikinIdouRireki sikinIdouRireki = bizDomManager.getSikinIdouRireki(BizDate.valueOf("20201011"), String.valueOf(i));
           exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.SAKUJYO, "削除フラグ");
        }
    }
}
