package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

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
 * 割当不可情報テーブル のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("001", "007", "sk001", "005");

        Assert.assertEquals(0,wariateHukaInfoLst.size());

        BT_WariateHukaInfo bT_WariateHukaInfo6 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo6.setKouteikanriid("001");
        bT_WariateHukaInfo6.setSubSystemId("003");
        bT_WariateHukaInfo6.setJimutetuzukicd("sk001");
        bT_WariateHukaInfo6.setWrthukakaijyotskid("005");
        bT_WariateHukaInfo6.setWrthukatskid("2006");
        bT_WariateHukaInfo6.setUserId("1006");
        bizDomManager.insert(bT_WariateHukaInfo6);

        BT_WariateHukaInfo bT_WariateHukaInfo1 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo1.setKouteikanriid("001");
        bT_WariateHukaInfo1.setSubSystemId("007");
        bT_WariateHukaInfo1.setJimutetuzukicd("sk001");
        bT_WariateHukaInfo1.setWrthukakaijyotskid("005");
        bT_WariateHukaInfo1.setWrthukatskid("2001");
        bT_WariateHukaInfo1.setUserId("1001");
        bizDomManager.insert(bT_WariateHukaInfo1);

        BT_WariateHukaInfo bT_WariateHukaInfo8 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo8.setKouteikanriid("001");
        bT_WariateHukaInfo8.setSubSystemId("007");
        bT_WariateHukaInfo8.setJimutetuzukicd("sk001");
        bT_WariateHukaInfo8.setWrthukakaijyotskid("003");
        bT_WariateHukaInfo8.setWrthukatskid("2008");
        bT_WariateHukaInfo8.setUserId("1008");
        bizDomManager.insert(bT_WariateHukaInfo8);

        BT_WariateHukaInfo bT_WariateHukaInfo7 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo7.setKouteikanriid("001");
        bT_WariateHukaInfo7.setSubSystemId("007");
        bT_WariateHukaInfo7.setJimutetuzukicd("sk003");
        bT_WariateHukaInfo7.setWrthukakaijyotskid("005");
        bT_WariateHukaInfo7.setWrthukatskid("2007");
        bT_WariateHukaInfo7.setUserId("1007");
        bizDomManager.insert(bT_WariateHukaInfo7);


        BT_WariateHukaInfo bT_WariateHukaInfo2 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo2.setKouteikanriid("002");
        bT_WariateHukaInfo2.setSubSystemId("008");
        bT_WariateHukaInfo2.setJimutetuzukicd("sk002");
        bT_WariateHukaInfo2.setWrthukakaijyotskid("006");
        bT_WariateHukaInfo2.setWrthukatskid("2002");
        bT_WariateHukaInfo2.setUserId("1002");
        bizDomManager.insert(bT_WariateHukaInfo2);

        BT_WariateHukaInfo bT_WariateHukaInfo3 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo3.setKouteikanriid("002");
        bT_WariateHukaInfo3.setSubSystemId("008");
        bT_WariateHukaInfo3.setJimutetuzukicd("sk002");
        bT_WariateHukaInfo3.setWrthukakaijyotskid("006");
        bT_WariateHukaInfo3.setWrthukatskid("2003");
        bT_WariateHukaInfo3.setUserId("1003");
        bizDomManager.insert(bT_WariateHukaInfo3);

        BT_WariateHukaInfo bT_WariateHukaInfo4 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo4.setKouteikanriid("002");
        bT_WariateHukaInfo4.setSubSystemId("008");
        bT_WariateHukaInfo4.setJimutetuzukicd("sk002");
        bT_WariateHukaInfo4.setWrthukakaijyotskid("006");
        bT_WariateHukaInfo4.setWrthukatskid("2004");
        bT_WariateHukaInfo4.setUserId("1004");
        bizDomManager.insert(bT_WariateHukaInfo4);

        BT_WariateHukaInfo bT_WariateHukaInfo5 = new BT_WariateHukaInfo();
        bT_WariateHukaInfo5.setKouteikanriid("003");
        bT_WariateHukaInfo5.setSubSystemId("007");
        bT_WariateHukaInfo5.setJimutetuzukicd("sk001");
        bT_WariateHukaInfo5.setWrthukakaijyotskid("005");
        bT_WariateHukaInfo5.setWrthukatskid("2005");
        bT_WariateHukaInfo5.setUserId("1005");
        bizDomManager.insert(bT_WariateHukaInfo5);

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

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("004", "004", "sk004", "004");

        assertEquals(0, wariateHukaInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("001", "007", "sk001", "005");

        assertEquals(1, wariateHukaInfoLst.size());
        assertEquals("001", wariateHukaInfoLst.get(0).getKouteikanriid());
        assertEquals("007", wariateHukaInfoLst.get(0).getSubSystemId());
        assertEquals("sk001",wariateHukaInfoLst.get(0).getJimutetuzukicd());
        assertEquals("2001", wariateHukaInfoLst.get(0).getWrthukatskid());
        assertEquals("1001", wariateHukaInfoLst.get(0).getUserId());
    }

    @Test
    @TestOrder(30)
    public void normal3(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("002", "008", "sk002", "006");

        assertEquals(3, wariateHukaInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("002","008","sk002","2002","1002"), "1");
        map.put($("002","008","sk002","2003","1003"), "1");
        map.put($("002","008","sk002","2004","1004"), "1");
        for(BT_WariateHukaInfo wariateHukaInfo : wariateHukaInfoLst){
            map.remove($(wariateHukaInfo.getKouteikanriid(),wariateHukaInfo.getSubSystemId(),wariateHukaInfo.getJimutetuzukicd(),
                wariateHukaInfo.getWrthukatskid(),wariateHukaInfo.getUserId()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("", "007", "sk001", "005");

        assertEquals(0, wariateHukaInfoLst.size());

    }
    @Test
    @TestOrder(50)
    public void blank2() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("001", "", "sk001", "005");

        assertEquals(0, wariateHukaInfoLst.size());

    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("001", "007", "", "005");

        assertEquals(0, wariateHukaInfoLst.size());

    }
    @Test
    @TestOrder(70)
    public void blank4() {

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("001", "007", "sk001", "");

        assertEquals(0, wariateHukaInfoLst.size());

    }

    @Test
    @TestOrder(80)
    public void normal20(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("002", "008", "sk002", "006");

        assertEquals(3, wariateHukaInfoLst.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($("002","008","sk002","2002","1002"), "1");
        map.put($("002","008","sk002","2003","1003"), "1");
        map.put($("002","008","sk002","2004","1004"), "1");
        for(BT_WariateHukaInfo wariateHukaInfo : wariateHukaInfoLst){
            map.remove($(wariateHukaInfo.getKouteikanriid(),wariateHukaInfo.getSubSystemId(),wariateHukaInfo.getJimutetuzukicd(),
                wariateHukaInfo.getWrthukatskid(),wariateHukaInfo.getUserId()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(81)
    @Transactional
    public void normal21(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("002", "008", "sk002", "006");
        bizDomManager.delete(wariateHukaInfoLst);
    }

    @Test
    @TestOrder(90)
    public void noResult2(){

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid("002", "008", "sk002", "006");

        assertEquals(0, wariateHukaInfoLst.size());

    }

}
