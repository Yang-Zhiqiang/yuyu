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
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 資金移動用履歴テーブル作成クラスのメソッド {@link BzSikinIdouRirekiTblSakusei#insertSikinIdouRirekiTblOne(BT_SikinIdouRireki)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouRirekiTblSakuseiTest_insertSikinIdouRirekiTblOne extends AbstractTest {

    @Inject
    private BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_資金移動用履歴テーブル作成";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzSikinIdouRirekiTblSakuseiTest_insertSikinIdouRirekiTblOne.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSikinIdouRireki());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());

    }

    @Transactional
    @Test
    @TestOrder(10)
    public void testinsertSikinIdouRirekiTblOne_A1() {

        BT_SikinIdouRireki sikinIdouRireki = new BT_SikinIdouRireki();
        sikinIdouRireki.setSyoriYmd(BizDate.valueOf("20201103"));
        sikinIdouRireki.setSyono("17806000013");
        sikinIdouRireki.setKykymd(BizDate.valueOf("20201028"));

        BizPropertyInitializer.initialize(sikinIdouRireki);

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);

        List<BT_SikinIdouRireki> sikinIdouRirekiLst = bizDomManager.getAllSikinIdouRireki();

        exStringEquals(sikinIdouRirekiLst.get(0).getKeirisyorirenno(), "1", "経理用処理連番");
    }
}
