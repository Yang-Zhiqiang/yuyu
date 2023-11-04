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
 * getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_GyoumuKouteiInfo>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd("10000000001", "10000000060");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo1.setKouteikanriid("80000000001");
        gyoumuKouteiInfo1.setSyukouteikanriid("10000000001");
        gyoumuKouteiInfo1.setSyukouteijimutetuzukicd("10000000060");
        bizDomManager.insert(gyoumuKouteiInfo1);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo2.setKouteikanriid("80000000002");
        gyoumuKouteiInfo2.setSyukouteikanriid("10000000002");
        gyoumuKouteiInfo2.setSyukouteijimutetuzukicd("10000000060");
        bizDomManager.insert(gyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo3.setKouteikanriid("80000000003");
        gyoumuKouteiInfo3.setSyukouteikanriid("10000000001");
        gyoumuKouteiInfo3.setSyukouteijimutetuzukicd("10000000061");
        bizDomManager.insert(gyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo4.setKouteikanriid("80000000004");
        gyoumuKouteiInfo4.setSyukouteikanriid("10000000003");
        gyoumuKouteiInfo4.setSyukouteijimutetuzukicd("10000000062");
        bizDomManager.insert(gyoumuKouteiInfo4);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo5 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo5.setKouteikanriid("80000000005");
        gyoumuKouteiInfo5.setSyukouteikanriid("10000000003");
        gyoumuKouteiInfo5.setSyukouteijimutetuzukicd("10000000062");
        bizDomManager.insert(gyoumuKouteiInfo5);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo6 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo6.setKouteikanriid("80000000006");
        gyoumuKouteiInfo6.setSyukouteikanriid("10000000003");
        gyoumuKouteiInfo6.setSyukouteijimutetuzukicd("10000000062");
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
    public void noResult1() {
        List<BT_GyoumuKouteiInfo>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd("10000000003", "10000000060");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<BT_GyoumuKouteiInfo>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd("10000000001", "10000000060");

        Assert.assertEquals(1, gyoumuKouteiInfoLst.size());
        Assert.assertEquals("80000000001", gyoumuKouteiInfoLst.get(0).getKouteikanriid());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<BT_GyoumuKouteiInfo>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd("10000000003", "10000000062");

        Assert.assertEquals(3, gyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("80000000004"),"1");
        map.put($("80000000005"),"1");
        map.put($("80000000006"),"1");

        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(0).getKouteikanriid())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(1).getKouteikanriid())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(2).getKouteikanriid())));

        map.remove($(gyoumuKouteiInfoLst.get(0).getKouteikanriid()));
        map.remove($(gyoumuKouteiInfoLst.get(1).getKouteikanriid()));
        map.remove($(gyoumuKouteiInfoLst.get(2).getKouteikanriid()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<BT_GyoumuKouteiInfo>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd("", "10000000060");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        List<BT_GyoumuKouteiInfo>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd("10000000001", "");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }
}

