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
 * getGyoumuKouteiInfosBySyukouteikanriids() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosBySyukouteikanriids {

    @Inject
    BizDomManager bizDomManager;

    private final static String[] dSyukouteikanriid1 = {"sk01","sk02","sk03"};
    private final static String[] dSyukouteikanriid2 = {"sk05","sk06"};
    private final static String[] dSyukouteikanriid3 = {"sk04","sk06"};
    private final static String[] dSyukouteikanriid4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriids(dSyukouteikanriid1);
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());

        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo1.setKouteikanriid("kk03");
        gyoumuKouteiInfo1.setSyukouteikanriid("sk01");
        bizDomManager.insert(gyoumuKouteiInfo1);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo2.setKouteikanriid("kk02");
        gyoumuKouteiInfo2.setSyukouteikanriid("sk02");
        bizDomManager.insert(gyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo3.setKouteikanriid("kk01");
        gyoumuKouteiInfo3.setSyukouteikanriid("sk03");
        bizDomManager.insert(gyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo4.setKouteikanriid("kk04");
        gyoumuKouteiInfo4.setSyukouteikanriid("sk04");
        bizDomManager.insert(gyoumuKouteiInfo4);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo5 = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo5.setKouteikanriid("kk07");
        gyoumuKouteiInfo5.setSyukouteikanriid("sk07");
        bizDomManager.insert(gyoumuKouteiInfo5);

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

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriids(dSyukouteikanriid2);
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriids(dSyukouteikanriid3);
        Assert.assertEquals(1, gyoumuKouteiInfoLst.size());

        Assert.assertEquals("kk04", gyoumuKouteiInfoLst.get(0).getKouteikanriid());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriids(dSyukouteikanriid1);
        Assert.assertEquals(3, gyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("kk01"),"1");
        map.put($("kk02"),"1");
        map.put($("kk03"),"1");

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

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriids(dSyukouteikanriid4);
        Assert.assertEquals(0, gyoumuKouteiInfoLst.size());
    }

}