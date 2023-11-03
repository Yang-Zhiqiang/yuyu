package yuyu.def.biz.manager;

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
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;
/**
 * 割当不可情報テーブル のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getWariateHukaInfosBySubSystemIdUserId {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_WariateHukaInfo> wariateHukaInfo = bizDomManager.getWariateHukaInfosBySubSystemIdUserId("sub01", "user01");
        Assert.assertEquals(0, wariateHukaInfo.size());

        BT_WariateHukaInfo wariateHukaInfo1 = new BT_WariateHukaInfo();
        wariateHukaInfo1.setKouteikanriid("kk01");
        wariateHukaInfo1.setSubSystemId("sub01");
        wariateHukaInfo1.setJimutetuzukicd("jk01");
        wariateHukaInfo1.setWrthukatskid("wk01");
        wariateHukaInfo1.setUserId("user01");
        bizDomManager.insert(wariateHukaInfo1);

        BT_WariateHukaInfo wariateHukaInfo2 = new BT_WariateHukaInfo();
        wariateHukaInfo2.setKouteikanriid("kk02");
        wariateHukaInfo2.setSubSystemId("sub01");
        wariateHukaInfo2.setJimutetuzukicd("jk01");
        wariateHukaInfo2.setWrthukatskid("wk01");
        wariateHukaInfo2.setUserId("user01");
        bizDomManager.insert(wariateHukaInfo2);

        BT_WariateHukaInfo wariateHukaInfo3 = new BT_WariateHukaInfo();
        wariateHukaInfo3.setKouteikanriid("kk03");
        wariateHukaInfo3.setSubSystemId("sub01");
        wariateHukaInfo3.setJimutetuzukicd("jk01");
        wariateHukaInfo3.setWrthukatskid("wk01");
        wariateHukaInfo3.setUserId("user01");
        bizDomManager.insert(wariateHukaInfo3);

        BT_WariateHukaInfo wariateHukaInfo4 = new BT_WariateHukaInfo();
        wariateHukaInfo4.setKouteikanriid("kk04");
        wariateHukaInfo4.setSubSystemId("sub02");
        wariateHukaInfo4.setJimutetuzukicd("jk01");
        wariateHukaInfo4.setWrthukatskid("wk01");
        wariateHukaInfo4.setUserId("user01");
        bizDomManager.insert(wariateHukaInfo4);

        BT_WariateHukaInfo wariateHukaInfo5 = new BT_WariateHukaInfo();
        wariateHukaInfo5.setKouteikanriid("kk05");
        wariateHukaInfo5.setSubSystemId("sub01");
        wariateHukaInfo5.setJimutetuzukicd("jk01");
        wariateHukaInfo5.setWrthukatskid("wk01");
        wariateHukaInfo5.setUserId("user02");
        bizDomManager.insert(wariateHukaInfo5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllWariateHukaInfo());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_WariateHukaInfo> wariateHukaInfo = bizDomManager.getWariateHukaInfosBySubSystemIdUserId("sub03", "user01");
        Assert.assertEquals(0, wariateHukaInfo.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_WariateHukaInfo> wariateHukaInfo = bizDomManager.getWariateHukaInfosBySubSystemIdUserId("sub02", "user01");
        Assert.assertEquals(1, wariateHukaInfo.size());

        Assert.assertEquals("kk04", wariateHukaInfo.get(0).getKouteikanriid());
        Assert.assertEquals("sub02", wariateHukaInfo.get(0).getSubSystemId());
        Assert.assertEquals("jk01", wariateHukaInfo.get(0).getJimutetuzukicd());
        Assert.assertEquals("wk01", wariateHukaInfo.get(0).getWrthukatskid());
        Assert.assertEquals("user01", wariateHukaInfo.get(0).getUserId());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_WariateHukaInfo> wariateHukaInfo = bizDomManager.getWariateHukaInfosBySubSystemIdUserId("sub01", "user01");
        Assert.assertEquals(3, wariateHukaInfo.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("kk01","sub01","jk01","wk01","user01"), "1");
        map.put($("kk02","sub01","jk01","wk01","user01"), "1");
        map.put($("kk03","sub01","jk01","wk01","user01"), "1");

        for(BT_WariateHukaInfo bT_WariateHukaInfo : wariateHukaInfo){
            map.remove($(bT_WariateHukaInfo.getKouteikanriid(),bT_WariateHukaInfo.getSubSystemId(),bT_WariateHukaInfo.getJimutetuzukicd(),bT_WariateHukaInfo.getWrthukatskid(),bT_WariateHukaInfo.getUserId()));
        }
        assertTrue(map.isEmpty());
    }


    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_WariateHukaInfo> wariateHukaInfo = bizDomManager.getWariateHukaInfosBySubSystemIdUserId("", "user01");
        Assert.assertEquals(0, wariateHukaInfo.size());

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<BT_WariateHukaInfo> wariateHukaInfo = bizDomManager.getWariateHukaInfosBySubSystemIdUserId("sub01", "");
        Assert.assertEquals(0, wariateHukaInfo.size());

    }
}
