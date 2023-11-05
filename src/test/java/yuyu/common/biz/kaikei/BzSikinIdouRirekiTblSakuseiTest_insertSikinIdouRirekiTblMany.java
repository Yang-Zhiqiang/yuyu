package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
 * 資金移動用履歴テーブル作成クラスのメソッド {@link BzSikinIdouRirekiTblSakusei#insertSikinIdouRirekiTblMany(List<BT_SikinIdouRireki>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouRirekiTblSakuseiTest_insertSikinIdouRirekiTblMany extends AbstractTest {

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
            testDataAndTblMap = testDataMaker.getInData(BzSikinIdouRirekiTblSakuseiTest_insertSikinIdouRirekiTblMany.class,
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

    @Test
    @TestOrder(10)
    @Transactional
    public void testinsertSikinIdouRirekiTblMany_A1() {

        List<BT_SikinIdouRireki> sikinIdouRirekiLst = new ArrayList<BT_SikinIdouRireki>();

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblMany(sikinIdouRirekiLst);

        List<BT_SikinIdouRireki> sikinIdouRirekiLstRst = bizDomManager.getAllSikinIdouRireki();

        exNumericEquals(sikinIdouRirekiLstRst.size(), 0, "資金移動用履歴TBLリストの件数");
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void testinsertSikinIdouRirekiTblMany_A2() {

        List<BT_SikinIdouRireki> sikinIdouRirekiLst = new ArrayList<BT_SikinIdouRireki>();

        BT_SikinIdouRireki sikinIdouRireki = new BT_SikinIdouRireki();
        sikinIdouRireki.setSyoriYmd(BizDate.valueOf("20201101"));
        sikinIdouRireki.setSyono("17806000013");
        sikinIdouRireki.setKykymd(BizDate.valueOf("20201028"));

        BizPropertyInitializer.initialize(sikinIdouRireki);
        sikinIdouRirekiLst.add(sikinIdouRireki);

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblMany(sikinIdouRirekiLst);

        List<BT_SikinIdouRireki> sikinIdouRirekiLstRst = bizDomManager.getAllSikinIdouRireki();

        exStringEquals(sikinIdouRirekiLstRst.get(0).getKeirisyorirenno(), "1", "経理用処理連番");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testinsertSikinIdouRirekiTblMany_A3() {

        List<BT_SikinIdouRireki> sikinIdouRirekiLst = new ArrayList<BT_SikinIdouRireki>();

        BT_SikinIdouRireki sikinIdouRireki1 = new BT_SikinIdouRireki();
        sikinIdouRireki1.setSyoriYmd(BizDate.valueOf("20201104"));
        sikinIdouRireki1.setSyono("17806000013");
        sikinIdouRireki1.setKykymd(BizDate.valueOf("20201028"));

        BizPropertyInitializer.initialize(sikinIdouRireki1);
        sikinIdouRirekiLst.add(sikinIdouRireki1);


        BT_SikinIdouRireki sikinIdouRireki2 = new BT_SikinIdouRireki();
        sikinIdouRireki2.setSyoriYmd(BizDate.valueOf("20201104"));
        sikinIdouRireki2.setSyono("17806000024");
        sikinIdouRireki2.setKykymd(BizDate.valueOf("20201028"));

        BizPropertyInitializer.initialize(sikinIdouRireki2);
        sikinIdouRirekiLst.add(sikinIdouRireki2);


        BT_SikinIdouRireki sikinIdouRireki3 = new BT_SikinIdouRireki();
        sikinIdouRireki3.setSyoriYmd(BizDate.valueOf("20201104"));
        sikinIdouRireki3.setSyono("17806000035");
        sikinIdouRireki3.setKykymd(BizDate.valueOf("20201028"));

        BizPropertyInitializer.initialize(sikinIdouRireki3);
        sikinIdouRirekiLst.add(sikinIdouRireki3);

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblMany(sikinIdouRirekiLst);

        List<BT_SikinIdouRireki> sikinIdouRirekiLstRst = bizDomManager.getAllSikinIdouRireki();

        exStringEquals(sikinIdouRirekiLstRst.get(0).getKeirisyorirenno(), "1", "経理用処理連番");
        exStringEquals(sikinIdouRirekiLstRst.get(1).getKeirisyorirenno(), "2", "経理用処理連番");
        exStringEquals(sikinIdouRirekiLstRst.get(2).getKeirisyorirenno(), "3", "経理用処理連番");
    }
}
