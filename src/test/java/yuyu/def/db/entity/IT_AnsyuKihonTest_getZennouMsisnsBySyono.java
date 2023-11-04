package yuyu.def.db.entity;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納基本テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_AnsyuKihonTest_getZennouMsisnsBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（Entity）_getZennouMsisnsBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("11807111118");

        if (ansyuKihon == null) {
            ansyuKihon = new IT_AnsyuKihon("11807111118");
            List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();

            Assert.assertEquals(0, zennouLst.size());

            insertTestData();
        }
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(IT_AnsyuKihonTest_getZennouMsisnsBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("11807111118");
        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();

        Assert.assertEquals(0, zennouLst.size());

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(IT_AnsyuKihonTest_getZennouMsisnsBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("11807111118");
        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();

        Assert.assertEquals(1, zennouLst.size());

        Assert.assertEquals("01", zennouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", zennouLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20181123), zennouLst.get(0).getZennoukaisiymd());
        Assert.assertEquals(1, zennouLst.get(0).getRenno().intValue());

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(IT_AnsyuKihonTest_getZennouMsisnsBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("11807111118");
        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();

        Assert.assertEquals(3, zennouLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("01", "11807111118",BizDate.valueOf(20181123), 1), "1");
        map.put($("01", "11807111118",BizDate.valueOf(20181123), 2), "1");
        map.put($("01", "11807111118",BizDate.valueOf(20181123), 3), "1");

        for (IT_Zennou zennou : zennouLst) {
            map.remove($(zennou.getKbnkey(), zennou.getSyono(), zennou.getZennoukaisiymd(), zennou.getRenno()));
        }
        assertTrue(map.isEmpty());
    }
}
