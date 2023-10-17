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
 * getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid("A1100","1100");

        Assert.assertEquals(0,gyoumuKouteiInfoLst.size());


        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = new BT_GyoumuKouteiInfo("110056");
        gyoumuKouteiInfo1.setJimutetuzukicd("A1100");
        gyoumuKouteiInfo1.setSyukouteikanriid("1100");

        bizDomManager.insert(gyoumuKouteiInfo1);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo("110057");
        gyoumuKouteiInfo2.setJimutetuzukicd("A1000");
        gyoumuKouteiInfo2.setSyukouteikanriid("1100");

        bizDomManager.insert(gyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo("110058");
        gyoumuKouteiInfo3.setJimutetuzukicd("A1100");
        gyoumuKouteiInfo3.setSyukouteikanriid("1200");

        bizDomManager.insert(gyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo("110059");
        gyoumuKouteiInfo4.setJimutetuzukicd("A1111");
        gyoumuKouteiInfo4.setSyukouteikanriid("1100");

        bizDomManager.insert(gyoumuKouteiInfo4);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo5 = new BT_GyoumuKouteiInfo("110060");
        gyoumuKouteiInfo5.setJimutetuzukicd("A1111");
        gyoumuKouteiInfo5.setSyukouteikanriid("1100");

        bizDomManager.insert(gyoumuKouteiInfo5);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo6 = new BT_GyoumuKouteiInfo("110061");
        gyoumuKouteiInfo6.setJimutetuzukicd("A1111");
        gyoumuKouteiInfo6.setSyukouteikanriid("1100");

        bizDomManager.insert(gyoumuKouteiInfo6);


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

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid("A2000","1100");

        Assert.assertEquals(0,gyoumuKouteiInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid("A1100","1100");

        Assert.assertEquals(1,gyoumuKouteiInfoLst.size());

        assertEquals("110056",gyoumuKouteiInfoLst.get(0).getKouteikanriid());
        assertEquals("A1100",gyoumuKouteiInfoLst.get(0).getJimutetuzukicd());
        assertEquals("1100",gyoumuKouteiInfoLst.get(0).getSyukouteikanriid());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid("A1111","1100");

        Assert.assertEquals(3,gyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("110059","A1111","1100"),"1");
        map.put($("110060","A1111","1100"),"1");
        map.put($("110061","A1111","1100"),"1");

        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(0).getKouteikanriid(),gyoumuKouteiInfoLst.get(0).getJimutetuzukicd(),gyoumuKouteiInfoLst.get(0).getSyukouteikanriid())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(1).getKouteikanriid(),gyoumuKouteiInfoLst.get(1).getJimutetuzukicd(),gyoumuKouteiInfoLst.get(1).getSyukouteikanriid())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(2).getKouteikanriid(),gyoumuKouteiInfoLst.get(2).getJimutetuzukicd(),gyoumuKouteiInfoLst.get(2).getSyukouteikanriid())));

        map.remove($(gyoumuKouteiInfoLst.get(0).getKouteikanriid(),gyoumuKouteiInfoLst.get(0).getJimutetuzukicd(),gyoumuKouteiInfoLst.get(0).getSyukouteikanriid()));
        map.remove($(gyoumuKouteiInfoLst.get(1).getKouteikanriid(),gyoumuKouteiInfoLst.get(1).getJimutetuzukicd(),gyoumuKouteiInfoLst.get(1).getSyukouteikanriid()));
        map.remove($(gyoumuKouteiInfoLst.get(2).getKouteikanriid(),gyoumuKouteiInfoLst.get(2).getJimutetuzukicd(),gyoumuKouteiInfoLst.get(2).getSyukouteikanriid()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid("","1100");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid("A1100","");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());

    }
}
