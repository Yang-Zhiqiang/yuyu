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

import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getWariateHukaInfosByPKWithoutUserId() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getWariateHukaInfosByPKWithoutUserId {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("A100", "B100", "C100", "D100");

        Assert.assertEquals(0,wariateHukaInfoLst.size());

        BT_WariateHukaInfo bT_WariateHukaInfo = new BT_WariateHukaInfo();
        bT_WariateHukaInfo.setKouteikanriid("A100");
        bT_WariateHukaInfo.setSubSystemId("B100");
        bT_WariateHukaInfo.setJimutetuzukicd("C100");
        bT_WariateHukaInfo.setWrthukatskid("D100");
        bT_WariateHukaInfo.setUserId("User001");
        bizDomManager.insert(bT_WariateHukaInfo);

        BT_WariateHukaInfo bT_WariateHukaInfo2 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo2.setKouteikanriid("A100");
        bT_WariateHukaInfo2.setSubSystemId("B110");
        bT_WariateHukaInfo2.setJimutetuzukicd("C100");
        bT_WariateHukaInfo2.setWrthukatskid("D100");
        bT_WariateHukaInfo2.setUserId("User001");
        bizDomManager.insert(bT_WariateHukaInfo2);

        BT_WariateHukaInfo bT_WariateHukaInfo3 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo3.setKouteikanriid("A100");
        bT_WariateHukaInfo3.setSubSystemId("B100");
        bT_WariateHukaInfo3.setJimutetuzukicd("C110");
        bT_WariateHukaInfo3.setWrthukatskid("D100");
        bT_WariateHukaInfo3.setUserId("User001");
        bizDomManager.insert(bT_WariateHukaInfo3);

        BT_WariateHukaInfo bT_WariateHukaInfo4 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo4.setKouteikanriid("A100");
        bT_WariateHukaInfo4.setSubSystemId("B100");
        bT_WariateHukaInfo4.setJimutetuzukicd("C100");
        bT_WariateHukaInfo4.setWrthukatskid("D110");
        bT_WariateHukaInfo4.setUserId("User001");
        bizDomManager.insert(bT_WariateHukaInfo4);

        BT_WariateHukaInfo bT_WariateHukaInfo5 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo5.setKouteikanriid("A110");
        bT_WariateHukaInfo5.setSubSystemId("B100");
        bT_WariateHukaInfo5.setJimutetuzukicd("C100");
        bT_WariateHukaInfo5.setWrthukatskid("D100");
        bT_WariateHukaInfo5.setUserId("User002");
        bizDomManager.insert(bT_WariateHukaInfo5);

        BT_WariateHukaInfo bT_WariateHukaInfo6 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo6.setKouteikanriid("A110");
        bT_WariateHukaInfo6.setSubSystemId("B100");
        bT_WariateHukaInfo6.setJimutetuzukicd("C100");
        bT_WariateHukaInfo6.setWrthukatskid("D100");
        bT_WariateHukaInfo6.setUserId("User003");
        bizDomManager.insert(bT_WariateHukaInfo6);

        BT_WariateHukaInfo bT_WariateHukaInfo7 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo7.setKouteikanriid("A110");
        bT_WariateHukaInfo7.setSubSystemId("B100");
        bT_WariateHukaInfo7.setJimutetuzukicd("C100");
        bT_WariateHukaInfo7.setWrthukatskid("D100");
        bT_WariateHukaInfo7.setUserId("User004");
        bizDomManager.insert(bT_WariateHukaInfo7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllWariateHukaInfo());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("A200", "B100", "C100", "D100");

        assertEquals(0, wariateHukaInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("A100", "B100", "C100", "D100");

        assertEquals(1, wariateHukaInfoLst.size());
        assertEquals("A100", wariateHukaInfoLst.get(0).getKouteikanriid());
        assertEquals("B100", wariateHukaInfoLst.get(0).getSubSystemId());
        assertEquals("C100", wariateHukaInfoLst.get(0).getJimutetuzukicd());
        assertEquals("D100", wariateHukaInfoLst.get(0).getWrthukatskid());
        assertEquals("User001", wariateHukaInfoLst.get(0).getUserId());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("A110", "B100", "C100", "D100");

        assertEquals(3, wariateHukaInfoLst.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($("A110","B100","C100","D100","User002"), "1");
        map.put($("A110","B100","C100","D100","User003"), "1");
        map.put($("A110","B100","C100","D100","User004"), "1");

        for(BT_WariateHukaInfo wariateHukaInfo : wariateHukaInfoLst){
            map.remove($(wariateHukaInfo.getKouteikanriid(),wariateHukaInfo.getSubSystemId(),wariateHukaInfo.getJimutetuzukicd(),wariateHukaInfo.getWrthukatskid(),wariateHukaInfo.getUserId()));
        }
        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("", "B100", "C100", "D100");
        Assert.assertEquals(0, wariateHukaInfoLst.size());

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("A100", "", "C100", "D100");
        Assert.assertEquals(0, wariateHukaInfoLst.size());

    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("A100", "B100", "", "D100");
        Assert.assertEquals(0, wariateHukaInfoLst.size());

    }

    @Test
    @TestOrder(70)
    public void blank4() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId("A100", "B100", "C100", "");
        Assert.assertEquals(0, wariateHukaInfoLst.size());

    }
}
