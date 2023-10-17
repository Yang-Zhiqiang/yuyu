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
 * getGyoumuKouteiInfosByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosByMosno {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByMosno("10010");

        Assert.assertEquals(0,gyoumuKouteiInfoLst.size());

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setMosno("10010");
        bT_GyoumuKouteiInfo.setKouteikanriid("kk03");
        bT_GyoumuKouteiInfo.setSyukouteikanriid("sk01");
        bizDomManager.insert(bT_GyoumuKouteiInfo);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo2.setMosno("10010");
        bT_GyoumuKouteiInfo2.setKouteikanriid("kk02");
        bT_GyoumuKouteiInfo2.setSyukouteikanriid("sk02");
        bizDomManager.insert(bT_GyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo3.setMosno("10011");
        bT_GyoumuKouteiInfo3.setKouteikanriid("kk01");
        bT_GyoumuKouteiInfo3.setSyukouteikanriid("kk01");
        bizDomManager.insert(bT_GyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo4.setMosno("10011");
        bT_GyoumuKouteiInfo4.setKouteikanriid("kk04");
        bT_GyoumuKouteiInfo4.setSyukouteikanriid("sk04");
        bizDomManager.insert(bT_GyoumuKouteiInfo4);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo5 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo5.setMosno("10011");
        bT_GyoumuKouteiInfo5.setKouteikanriid("kk07");
        bT_GyoumuKouteiInfo5.setSyukouteikanriid("kk07");
        bizDomManager.insert(bT_GyoumuKouteiInfo5);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo6 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo6.setMosno("10011");
        bT_GyoumuKouteiInfo6.setKouteikanriid("kk08");
        bT_GyoumuKouteiInfo6.setSyukouteikanriid("kk08");
        bizDomManager.insert(bT_GyoumuKouteiInfo6);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo7 = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo7.setMosno("10012");
        bT_GyoumuKouteiInfo7.setKouteikanriid("kk09");
        bT_GyoumuKouteiInfo7.setSyukouteikanriid("kk09");
        bizDomManager.insert(bT_GyoumuKouteiInfo7);
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

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByMosno("10010");

        assertEquals(0, gyoumuKouteiInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByMosno("10012");

        assertEquals(1, gyoumuKouteiInfoLst.size());
        assertEquals("kk09",gyoumuKouteiInfoLst.get(0).getKouteikanriid());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByMosno("10011");

        assertEquals(3, gyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("kk01"),"1");
        map.put($("kk07"),"1");
        map.put($("kk08"),"1");

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
    public void blank1() {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByMosno("");
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());

    }
}
