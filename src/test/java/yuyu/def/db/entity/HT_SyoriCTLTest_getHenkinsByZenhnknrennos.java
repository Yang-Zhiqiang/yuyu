package yuyu.def.db.entity;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinsByZenhnknrennos {

    private final static Integer[] ZENHNKNRENNO1 = { 1, 2 };
    private final static Integer[] ZENHNKNRENNO2 = { 8, 9 };
    private final static Integer[] ZENHNKNRENNO3 = { 4, 5, 6 };

    private final static String fileName = "UT-SP_単体テスト仕様書（Entity）_getHenkinsByZenhnknrennos";

    private final static String sheetName = "INデータ";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        if (syoriCTL == null) {
            syoriCTL = new HT_SyoriCTL("860000017");
            List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByZenhnknrennos(ZENHNKNRENNO1);

            Assert.assertEquals(0, henkinLst.size());

            insertTestData();
        }
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HT_SyoriCTLTest_getHenkinsByZenhnknrennos.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByZenhnknrennos(ZENHNKNRENNO2);

        Assert.assertEquals(0, henkinLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByZenhnknrennos(ZENHNKNRENNO1);

        Assert.assertEquals(1, henkinLst.size());

        Assert.assertEquals("860000017", henkinLst.get(0).getMosno());
        Assert.assertEquals(1, henkinLst.get(0).getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByZenhnknrennos(ZENHNKNRENNO3);

        Assert.assertEquals(3, henkinLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("860000017", 2), "1");
        map.put($("860000017", 3), "1");
        map.put($("860000017", 4), "1");

        for (HT_Henkin henkin : henkinLst) {
            map.remove($(henkin.getMosno(), henkin.getRenno()));
        }
        assertTrue(map.isEmpty());
    }
}
