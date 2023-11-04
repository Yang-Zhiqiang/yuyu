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

import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 業務用工程情報テーブルエンティティリスト取得　事務手続コード、証券番号、請求番号のテストクラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno("A01", "11807111118", "1118120710");

        Assert.assertEquals(0,bT_GyoumuKouteiInfoLst.size());

        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = new BT_GyoumuKouteiInfo("1111111");
        gyoumuKouteiInfo1.setJimutetuzukicd("A01");
        gyoumuKouteiInfo1.setSyono("11807111118");
        gyoumuKouteiInfo1.setSkno("1118120710");

        bizDomManager.insert(gyoumuKouteiInfo1);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo("1111112");
        gyoumuKouteiInfo2.setJimutetuzukicd("A02");
        gyoumuKouteiInfo2.setSyono("11807111118");
        gyoumuKouteiInfo2.setSkno("1118120710");

        bizDomManager.insert(gyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo("1111113");
        gyoumuKouteiInfo3.setJimutetuzukicd("A03");
        gyoumuKouteiInfo3.setSyono("11807111129");
        gyoumuKouteiInfo3.setSkno("1118120710");

        bizDomManager.insert(gyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo("1111114");
        gyoumuKouteiInfo4.setJimutetuzukicd("A03");
        gyoumuKouteiInfo4.setSyono("11807111118");
        gyoumuKouteiInfo4.setSkno("1118120711");

        bizDomManager.insert(gyoumuKouteiInfo4);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo5 = new BT_GyoumuKouteiInfo("1111115");
        gyoumuKouteiInfo5.setJimutetuzukicd("A03");
        gyoumuKouteiInfo5.setSyono("11807111118");
        gyoumuKouteiInfo5.setSkno("1118120710");

        bizDomManager.insert(gyoumuKouteiInfo5);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo6 = new BT_GyoumuKouteiInfo("1111116");
        gyoumuKouteiInfo6.setJimutetuzukicd("A03");
        gyoumuKouteiInfo6.setSyono("11807111118");
        gyoumuKouteiInfo6.setSkno("1118120710");

        bizDomManager.insert(gyoumuKouteiInfo6);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo7 = new BT_GyoumuKouteiInfo("1111117");
        gyoumuKouteiInfo7.setJimutetuzukicd("A03");
        gyoumuKouteiInfo7.setSyono("11807111118");
        gyoumuKouteiInfo7.setSkno("1118120710");

        bizDomManager.insert(gyoumuKouteiInfo7);
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

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno("A04", "11807111118", "1118120710");

        Assert.assertEquals(0,bT_GyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno("A01", "11807111118", "1118120710");

        Assert.assertEquals(1,bT_GyoumuKouteiInfoLst.size());

        assertEquals("1111111",bT_GyoumuKouteiInfoLst.get(0).getKouteikanriid());
        assertEquals("A01",bT_GyoumuKouteiInfoLst.get(0).getJimutetuzukicd());
        assertEquals("11807111118",bT_GyoumuKouteiInfoLst.get(0).getSyono());
        assertEquals("1118120710",bT_GyoumuKouteiInfoLst.get(0).getSkno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno("A03", "11807111118", "1118120710");

        Assert.assertEquals(3,bT_GyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("1111115","A03","11807111118","1118120710"),"1");
        map.put($("1111116","A03","11807111118","1118120710"),"1");
        map.put($("1111117","A03","11807111118","1118120710"),"1");

        assertTrue(map.containsKey($(bT_GyoumuKouteiInfoLst.get(0).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(0).getJimutetuzukicd()
            ,bT_GyoumuKouteiInfoLst.get(0).getSyono(),bT_GyoumuKouteiInfoLst.get(0).getSkno())));
        assertTrue(map.containsKey($(bT_GyoumuKouteiInfoLst.get(1).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(1).getJimutetuzukicd()
            ,bT_GyoumuKouteiInfoLst.get(1).getSyono(),bT_GyoumuKouteiInfoLst.get(1).getSkno())));
        assertTrue(map.containsKey($(bT_GyoumuKouteiInfoLst.get(2).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(2).getJimutetuzukicd()
            ,bT_GyoumuKouteiInfoLst.get(2).getSyono(),bT_GyoumuKouteiInfoLst.get(2).getSkno())));

        map.remove($(bT_GyoumuKouteiInfoLst.get(0).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(0).getJimutetuzukicd()
            ,bT_GyoumuKouteiInfoLst.get(0).getSyono(),bT_GyoumuKouteiInfoLst.get(0).getSkno()));
        map.remove($(bT_GyoumuKouteiInfoLst.get(1).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(1).getJimutetuzukicd()
            ,bT_GyoumuKouteiInfoLst.get(1).getSyono(),bT_GyoumuKouteiInfoLst.get(1).getSkno()));
        map.remove($(bT_GyoumuKouteiInfoLst.get(2).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(2).getJimutetuzukicd()
            ,bT_GyoumuKouteiInfoLst.get(2).getSyono(),bT_GyoumuKouteiInfoLst.get(2).getSkno()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno("", "11807111118", "1118120710");
        Assert.assertEquals(0, bT_GyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno("A03", "", "1118120710");
        Assert.assertEquals(0, bT_GyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno("A03", "11807111118", "");
        Assert.assertEquals(0, bT_GyoumuKouteiInfoLst.size());
    }
}
