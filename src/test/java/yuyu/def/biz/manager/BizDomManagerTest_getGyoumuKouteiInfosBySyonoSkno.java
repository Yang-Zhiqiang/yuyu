package yuyu.def.biz.manager;

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

import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getGyoumuKouteiInfosBySyonoSkno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosBySyonoSkno {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyonoSkno("10000000025", "10010");

        Assert.assertEquals(0,gyoumuKouteiInfoLst.size());

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setSyono("10000000025");
        bT_GyoumuKouteiInfo.setSkno("10010");
        bT_GyoumuKouteiInfo.setKouteikanriid("A123");
        bizDomManager.insert(bT_GyoumuKouteiInfo);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo2.setSyono("10000000047");
        bT_GyoumuKouteiInfo2.setSkno("10086");
        bT_GyoumuKouteiInfo2.setKouteikanriid("B123");
        bizDomManager.insert(bT_GyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo3.setSyono("10000000047");
        bT_GyoumuKouteiInfo3.setSkno("10086");
        bT_GyoumuKouteiInfo3.setKouteikanriid("B345");
        bizDomManager.insert(bT_GyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo4.setSyono("10000000047");
        bT_GyoumuKouteiInfo4.setSkno("10086");
        bT_GyoumuKouteiInfo4.setKouteikanriid("B567");
        bizDomManager.insert(bT_GyoumuKouteiInfo4);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo5 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo5.setSyono("10000000014");
        bT_GyoumuKouteiInfo5.setSkno("10086");
        bT_GyoumuKouteiInfo5.setKouteikanriid("C123");
        bizDomManager.insert(bT_GyoumuKouteiInfo5);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo6 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo6.setSyono("10000000047");
        bT_GyoumuKouteiInfo6.setSkno("10085");
        bT_GyoumuKouteiInfo6.setKouteikanriid("C345");
        bizDomManager.insert(bT_GyoumuKouteiInfo6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyonoSkno("10000000014", "10010");

        assertEquals(0, gyoumuKouteiInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyonoSkno("10000000025", "10010");

        assertEquals(1, gyoumuKouteiInfoLst.size());
        assertEquals("10000000025", gyoumuKouteiInfoLst.get(0).getSyono());
        assertEquals("10010",gyoumuKouteiInfoLst.get(0).getSkno());
        assertEquals("A123",gyoumuKouteiInfoLst.get(0).getKouteikanriid());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyonoSkno("10000000047", "10086");

        assertEquals(3, gyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("10000000047","10086","B123"),"1");
        map.put($("10000000047","10086","B345"),"1");
        map.put($("10000000047","10086","B567"),"1");

        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(0).getSyono(),gyoumuKouteiInfoLst.get(0).getSkno(),gyoumuKouteiInfoLst.get(0).getKouteikanriid())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(1).getSyono(),gyoumuKouteiInfoLst.get(1).getSkno(),gyoumuKouteiInfoLst.get(1).getKouteikanriid())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(2).getSyono(),gyoumuKouteiInfoLst.get(2).getSkno(),gyoumuKouteiInfoLst.get(2).getKouteikanriid())));

        map.remove($(gyoumuKouteiInfoLst.get(0).getSyono(),gyoumuKouteiInfoLst.get(0).getSkno(),gyoumuKouteiInfoLst.get(0).getKouteikanriid()));
        map.remove($(gyoumuKouteiInfoLst.get(1).getSyono(),gyoumuKouteiInfoLst.get(1).getSkno(),gyoumuKouteiInfoLst.get(1).getKouteikanriid()));
        map.remove($(gyoumuKouteiInfoLst.get(2).getSyono(),gyoumuKouteiInfoLst.get(2).getSkno(),gyoumuKouteiInfoLst.get(2).getKouteikanriid()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyonoSkno("", "10010");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyonoSkno("10000000025", "");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());

    }
}
