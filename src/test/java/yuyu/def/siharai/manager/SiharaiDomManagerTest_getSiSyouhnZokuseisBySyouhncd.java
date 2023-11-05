package yuyu.def.siharai.manager;

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
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerImplクラスの、<br />
 * getSiSyouhnZokuseisBySyouhncd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiSyouhnZokuseisBySyouhncd {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSiSyouhnZokuseisBySyouhncd";

    private final static String sheetName = "INデータ";

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        JM_SiSyouhnZokusei jmSiSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd("ﾕﾌ");

        Assert.assertEquals(null, jmSiSyouhnZokusei);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiharaiDomManagerTest_getSiSyouhnZokuseisBySyouhncd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        JM_SiSyouhnZokusei jmSiSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd("ﾕｴ");
        Assert.assertEquals(null, jmSiSyouhnZokusei);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JM_SiSyouhnZokusei jmSiSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd("ﾕﾌ");
        Assert.assertEquals("ﾕﾌ", jmSiSyouhnZokusei.getSyouhncd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        JM_SiSyouhnZokusei jmSiSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd("ﾕｱ");
        Assert.assertEquals("ﾕｱ", jmSiSyouhnZokusei.getSyouhncd());
        Assert.assertEquals(1, (int)jmSiSyouhnZokusei.getSyouhnsdno());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        JM_SiSyouhnZokusei jmSiSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd("");
        Assert.assertEquals(null, jmSiSyouhnZokusei);
    }
}
