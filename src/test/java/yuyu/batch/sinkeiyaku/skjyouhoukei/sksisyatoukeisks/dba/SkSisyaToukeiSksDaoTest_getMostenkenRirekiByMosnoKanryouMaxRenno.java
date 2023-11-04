package yuyu.batch.sinkeiyaku.skjyouhoukei.sksisyatoukeisks.dba;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込点検履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkSisyaToukeiSksDaoTest_getMostenkenRirekiByMosnoKanryouMaxRenno{

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getMostenkenRirekiByMosnoKanryouMaxRenno(SkSisyaToukeiSks)";

    private final static String sheetName = "テストデータ";

    @Inject
    private SkSisyaToukeiSksDao skSisyaToukeiSksDao;

    @BeforeClass
    public static void testInit(){
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        HT_MostenkenRireki mostenkenRireki = SWAKInjector.getInstance(SkSisyaToukeiSksDao.class).getMostenkenRirekiByMosnoKanryouMaxRenno("860000017");
        Assert.assertEquals(null, mostenkenRireki);

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkSisyaToukeiSksDaoTest_getMostenkenRirekiByMosnoKanryouMaxRenno.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {
        HT_MostenkenRireki mostenkenRireki = skSisyaToukeiSksDao.getMostenkenRirekiByMosnoKanryouMaxRenno("860000025");
        Assert.assertEquals(null, mostenkenRireki);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {
        HT_MostenkenRireki mostenkenRireki = skSisyaToukeiSksDao.getMostenkenRirekiByMosnoKanryouMaxRenno("860000017");
        Assert.assertEquals("860000017", mostenkenRireki.getMosno());
        Assert.assertEquals(Integer.valueOf(2), mostenkenRireki.getRenno());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void blank1() {
        HT_MostenkenRireki mostenkenRireki = skSisyaToukeiSksDao.getMostenkenRirekiByMosnoKanryouMaxRenno("");
        Assert.assertEquals(null, mostenkenRireki);
    }

}
