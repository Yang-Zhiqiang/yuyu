package yuyu.def.sinkeiyaku.manager;

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
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHenkinMaxZenhnknrenno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenkinMaxZenhnknrenno {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getHenkinMaxZenhnknrenno";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        Integer zenhnknRenno = sinkeiyakuDomManager.getHenkinMaxZenhnknrenno("860000017");

        Assert.assertNull(zenhnknRenno);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getHenkinMaxZenhnknrenno.class,
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

        Integer zenhnknRenno = sinkeiyakuDomManager.getHenkinMaxZenhnknrenno("860000025");
        Assert.assertNull(zenhnknRenno);
    }
    @Test
    @TestOrder(20)
    public void normal1() {

        Integer zenhnknRenno = sinkeiyakuDomManager.getHenkinMaxZenhnknrenno("860000017");
        Assert.assertEquals(Integer.valueOf(3),zenhnknRenno);
    }
    @Test
    @TestOrder(30)
    public void blankCondition1() {

        Integer zenhnknRenno = sinkeiyakuDomManager.getHenkinMaxZenhnknrenno("");
        Assert.assertNull(zenhnknRenno);
    }
}
