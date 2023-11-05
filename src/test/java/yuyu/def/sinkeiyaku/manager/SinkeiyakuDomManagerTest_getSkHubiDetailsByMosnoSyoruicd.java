package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHubiDetailsByMosnoSyoruicd メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailsByMosnoSyoruicd {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSkHubiDetailsByMosnoSyoruicd";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_SkHubiDetail> htSkHubiDetailLst =
            sinkeiyakuDomManager.getSkHubiDetailsByMosnoSyoruicd("860000010", C_SyoruiCdKbn.BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1);

        Assert.assertEquals(0, htSkHubiDetailLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getSkHubiDetailsByMosnoSyoruicd.class,
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


        List<HT_SkHubiDetail> htSkHubiDetailLst =
            sinkeiyakuDomManager.getSkHubiDetailsByMosnoSyoruicd("860000016", C_SyoruiCdKbn.KK_DSEISAN_MISSLIST);

        Assert.assertEquals(0, htSkHubiDetailLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        List<HT_SkHubiDetail> htSkHubiDetailLst =
            sinkeiyakuDomManager.getSkHubiDetailsByMosnoSyoruicd("860000017", C_SyoruiCdKbn.NK_SIBOUSINDAN);

        Assert.assertEquals(1, htSkHubiDetailLst.size());
        Assert.assertEquals("860000017", htSkHubiDetailLst.get(0).getMosno());
        Assert.assertEquals("1001000101", htSkHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals("1", htSkHubiDetailLst.get(0).getRenno3keta().toString());
    }

    @Test
    @TestOrder(30)
    public void normal2() {


        List<HT_SkHubiDetail> htSkHubiDetailLst =
            sinkeiyakuDomManager.getSkHubiDetailsByMosnoSyoruicd("860000025", C_SyoruiCdKbn.KK_GENSENLIST);

        Assert.assertEquals(3, htSkHubiDetailLst.size());

        Map<String, String> map = new HashMap<String, String>();
        map.put($("860000025", "1001000102", 2), "1");
        map.put($("860000025", "1001000103", 3), "1");
        map.put($("860000025", "1001000104", 4), "1");

        for (HT_SkHubiDetail bakSkHubiDetail : htSkHubiDetailLst) {
            map.remove($(bakSkHubiDetail.getMosno(), bakSkHubiDetail.getHubisikibetukey(),
                bakSkHubiDetail.getRenno3keta()));
        }
        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SkHubiDetail> htSkHubiDetailLst =
            sinkeiyakuDomManager.getSkHubiDetailsByMosnoSyoruicd("", C_SyoruiCdKbn.NK_SIBOUSINDAN);

        Assert.assertEquals(0, htSkHubiDetailLst.size());
    }

}
