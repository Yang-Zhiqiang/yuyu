package yuyu.def.sinkeiyaku.manager;

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
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkDairitenKobetuJyouhou> skDairitenKobetuJyouhouLst = sinkeiyakuDomManager.getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn.FAX);

        Assert.assertEquals(0, skDairitenKobetuJyouhouLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDairitenKobetuJyouhou());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HM_SkDairitenKobetuJyouhou> skDairitenKobetuJyouhouLst = sinkeiyakuDomManager.getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn.JIMURNRK);

        Assert.assertEquals(0, skDairitenKobetuJyouhouLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_SkDairitenKobetuJyouhou> skDairitenKobetuJyouhouLst = sinkeiyakuDomManager.getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn.FAX);

        Assert.assertEquals(1, skDairitenKobetuJyouhouLst.size());

        Assert.assertEquals("1100181", skDairitenKobetuJyouhouLst.get(0).getOyadrtencd());
        Assert.assertEquals(C_DrtenRnrkhouKbn.FAX, skDairitenKobetuJyouhouLst.get(0).getDrtenRnrkhouKbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HM_SkDairitenKobetuJyouhou> skDairitenKobetuJyouhouLst = sinkeiyakuDomManager.getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn.NIT);

        Assert.assertEquals(3, skDairitenKobetuJyouhouLst.size());

        Assert.assertEquals("1200399", skDairitenKobetuJyouhouLst.get(0).getOyadrtencd());
        Assert.assertEquals(C_DrtenRnrkhouKbn.NIT, skDairitenKobetuJyouhouLst.get(0).getDrtenRnrkhouKbn());

        Assert.assertEquals("2100134", skDairitenKobetuJyouhouLst.get(1).getOyadrtencd());
        Assert.assertEquals(C_DrtenRnrkhouKbn.NIT, skDairitenKobetuJyouhouLst.get(1).getDrtenRnrkhouKbn());

        Assert.assertEquals("2100172", skDairitenKobetuJyouhouLst.get(2).getOyadrtencd());
        Assert.assertEquals(C_DrtenRnrkhouKbn.NIT, skDairitenKobetuJyouhouLst.get(2).getDrtenRnrkhouKbn());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HM_SkDairitenKobetuJyouhou> skDairitenKobetuJyouhouLst = sinkeiyakuDomManager.getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(null);

        Assert.assertEquals(0, skDairitenKobetuJyouhouLst.size());

    }
}
