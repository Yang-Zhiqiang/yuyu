package yuyu.def.db.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約ＬＩＮＣ他社照会結果テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getSkLincSyoukaikekkaByLincjyusintrrennoRenno {

    private final static String fileName = "UT-SP_単体テスト仕様書（Entity）_getSkLincSyoukaikekkaByLincjyusintrrennoRenno";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        if (syoriCTL == null) {

            syoriCTL = new HT_SyoriCTL("860000017");

            HT_SkLincSyoukaikekka skLincSyoukaikekka = syoriCTL.getSkLincSyoukaikekkaByLincjyusintrrennoRenno("0000000020", 10);

            Assert.assertNull(skLincSyoukaikekka);
        }

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HT_SyoriCTLTest_getSkLincSyoukaikekkaByLincjyusintrrennoRenno.class,
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

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        HT_SkLincSyoukaikekka skLincSyoukaikekka = syoriCTL.getSkLincSyoukaikekkaByLincjyusintrrennoRenno("0000000010", 1);

        Assert.assertNull(skLincSyoukaikekka);
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        HT_SkLincSyoukaikekka skLincSyoukaikekka = syoriCTL.getSkLincSyoukaikekkaByLincjyusintrrennoRenno("0000000020", 0);

        Assert.assertEquals("860000017", skLincSyoukaikekka.getMosno());
        Assert.assertEquals("0000000020", skLincSyoukaikekka.getLincjyusintrrenno());
        Assert.assertEquals(0, skLincSyoukaikekka.getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        HT_SkLincSyoukaikekka skLincSyoukaikekka = syoriCTL.getSkLincSyoukaikekkaByLincjyusintrrennoRenno("", 2);

        Assert.assertNull(skLincSyoukaikekka);

    }
}
