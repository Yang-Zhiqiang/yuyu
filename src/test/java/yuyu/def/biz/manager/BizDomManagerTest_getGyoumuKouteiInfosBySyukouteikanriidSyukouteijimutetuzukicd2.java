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

import yuyu.def.biz.result.bean.GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2 {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2("10000000001", "10000000060");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo1.setKouteikanriid("80000000001");
        gyoumuKouteiInfo1.setSyukouteikanriid("10000000001");
        gyoumuKouteiInfo1.setJimutetuzukicd("JIMU0000001");
        gyoumuKouteiInfo1.setSyukouteijimutetuzukicd("10000000060");
        bizDomManager.insert(gyoumuKouteiInfo1);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo2.setKouteikanriid("80000000002");
        gyoumuKouteiInfo2.setSyukouteikanriid("10000000002");
        gyoumuKouteiInfo2.setJimutetuzukicd("JIMU0000002");
        gyoumuKouteiInfo2.setSyukouteijimutetuzukicd("10000000060");
        bizDomManager.insert(gyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo3.setKouteikanriid("80000000003");
        gyoumuKouteiInfo3.setSyukouteikanriid("10000000001");
        gyoumuKouteiInfo3.setJimutetuzukicd("JIMU0000003");
        gyoumuKouteiInfo3.setSyukouteijimutetuzukicd("10000000061");
        bizDomManager.insert(gyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo4.setKouteikanriid("80000000004");
        gyoumuKouteiInfo4.setSyukouteikanriid("10000000003");
        gyoumuKouteiInfo4.setJimutetuzukicd("JIMU0000004");
        gyoumuKouteiInfo4.setSyukouteijimutetuzukicd("10000000062");
        bizDomManager.insert(gyoumuKouteiInfo4);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo5 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo5.setKouteikanriid("80000000005");
        gyoumuKouteiInfo5.setSyukouteikanriid("10000000003");
        gyoumuKouteiInfo5.setJimutetuzukicd("JIMU0000005");
        gyoumuKouteiInfo5.setSyukouteijimutetuzukicd("10000000062");
        bizDomManager.insert(gyoumuKouteiInfo5);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo6 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo6.setKouteikanriid("80000000006");
        gyoumuKouteiInfo6.setSyukouteikanriid("10000000003");
        gyoumuKouteiInfo6.setJimutetuzukicd("JIMU0000006");
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
        List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2("10000000003", "10000000060");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2("10000000001", "10000000060");

        Assert.assertEquals(1, gyoumuKouteiInfoLst.size());
        Assert.assertEquals("80000000001", gyoumuKouteiInfoLst.get(0).getKouteikanriid());
        Assert.assertEquals("JIMU0000001", gyoumuKouteiInfoLst.get(0).getJimutetuzukicd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2("10000000003", "10000000062");

        Assert.assertEquals(3, gyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("80000000004","JIMU0000004"),"1");
        map.put($("80000000005","JIMU0000005"),"1");
        map.put($("80000000006","JIMU0000006"),"1");

        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(0).getKouteikanriid(),gyoumuKouteiInfoLst.get(0).getJimutetuzukicd())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(1).getKouteikanriid(),gyoumuKouteiInfoLst.get(1).getJimutetuzukicd())));
        assertTrue(map.containsKey($(gyoumuKouteiInfoLst.get(2).getKouteikanriid(),gyoumuKouteiInfoLst.get(2).getJimutetuzukicd())));

        map.remove($(gyoumuKouteiInfoLst.get(0).getKouteikanriid(),gyoumuKouteiInfoLst.get(0).getJimutetuzukicd()));
        map.remove($(gyoumuKouteiInfoLst.get(1).getKouteikanriid(),gyoumuKouteiInfoLst.get(1).getJimutetuzukicd()));
        map.remove($(gyoumuKouteiInfoLst.get(2).getKouteikanriid(),gyoumuKouteiInfoLst.get(2).getJimutetuzukicd()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2("", "10000000060");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean>  gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2("10000000001", "");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }
}

