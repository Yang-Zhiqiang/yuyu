package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyouhnZokuseisByHknsyuruinoItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseisByHknsyuruinoItems {

    @Inject
    BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSyouhnZokuseisByHknsyuruinoItems";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(BizDate.valueOf(20160811), C_SyutkKbn.TK,
            C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, 11, 11,C_Tuukasyu.AUD,C_UmuKbn.ARI, C_Sknenkinsyu.KKTI5, C_UmuKbn.ARI);

        Assert.assertEquals(0, syouhnZokuseiLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getSyouhnZokuseisByHknsyuruinoItems.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(BizDate.valueOf(20160817), C_SyutkKbn.SYU,
            C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, 11, 11,C_Tuukasyu.AUD,C_UmuKbn.ARI, C_Sknenkinsyu.KKTI5, C_UmuKbn.ARI);

        assertEquals(0, syouhnZokuseiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){


        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(BizDate.valueOf(20160811), C_SyutkKbn.TK,
            C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, 11, 11,C_Tuukasyu.AUD,C_UmuKbn.ARI, C_Sknenkinsyu.KKTI5, C_UmuKbn.ARI);

        assertEquals(1, syouhnZokuseiLst.size());
        assertEquals("M101", syouhnZokuseiLst.get(0).getSyouhncd());
        assertEquals(4, syouhnZokuseiLst.get(0).getSyouhnsdno().intValue());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(BizDate.valueOf(20160810), C_SyutkKbn.SYU,
            C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, 11, 11,C_Tuukasyu.AUD,C_UmuKbn.ARI, C_Sknenkinsyu.KKTI5, C_UmuKbn.ARI);

        assertEquals(3, syouhnZokuseiLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("M101",1), "1");
        map.put($("M101",2), "1");
        map.put($("M101",3), "1");

        assertTrue(map.containsKey($(syouhnZokuseiLst.get(0).getSyouhncd(),syouhnZokuseiLst.get(0).getSyouhnsdno().intValue())));
        assertTrue(map.containsKey($(syouhnZokuseiLst.get(1).getSyouhncd(),syouhnZokuseiLst.get(1).getSyouhnsdno().intValue())));
        assertTrue(map.containsKey($(syouhnZokuseiLst.get(2).getSyouhncd(),syouhnZokuseiLst.get(2).getSyouhnsdno().intValue())));

        map.remove($(syouhnZokuseiLst.get(0).getSyouhncd(),syouhnZokuseiLst.get(0).getSyouhnsdno().intValue()));
        map.remove($(syouhnZokuseiLst.get(1).getSyouhncd(),syouhnZokuseiLst.get(1).getSyouhnsdno().intValue()));
        map.remove($(syouhnZokuseiLst.get(2).getSyouhncd(),syouhnZokuseiLst.get(2).getSyouhnsdno().intValue()));

        assertTrue(map.isEmpty());

    }
}
