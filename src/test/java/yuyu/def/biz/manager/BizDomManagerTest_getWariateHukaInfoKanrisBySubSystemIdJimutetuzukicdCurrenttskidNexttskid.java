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

import yuyu.def.db.entity.BM_WariateHukaInfoKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 割当不可情報管理マスタ のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("001", "sk001", "007", "002");

        Assert.assertEquals(0,wariateHukaInfoKanriLst.size());

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri1 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri1.setSubSystemId("001");
        bM_WariateHukaInfoKanri1.setJimutetuzukicd("sk001");
        bM_WariateHukaInfoKanri1.setCurrenttskid("007");
        bM_WariateHukaInfoKanri1.setNexttskid("002");
        bM_WariateHukaInfoKanri1.setRenno(1);
        bizDomManager.insert(bM_WariateHukaInfoKanri1);

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri8 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri8.setSubSystemId("001");
        bM_WariateHukaInfoKanri8.setJimutetuzukicd("sk001");
        bM_WariateHukaInfoKanri8.setCurrenttskid("007");
        bM_WariateHukaInfoKanri8.setNexttskid("004");
        bM_WariateHukaInfoKanri8.setRenno(8);
        bizDomManager.insert(bM_WariateHukaInfoKanri8);

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri7 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri7.setSubSystemId("001");
        bM_WariateHukaInfoKanri7.setJimutetuzukicd("sk001");
        bM_WariateHukaInfoKanri7.setCurrenttskid("003");
        bM_WariateHukaInfoKanri7.setNexttskid("002");
        bM_WariateHukaInfoKanri7.setRenno(7);
        bizDomManager.insert(bM_WariateHukaInfoKanri7);

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri6 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri6.setSubSystemId("001");
        bM_WariateHukaInfoKanri6.setJimutetuzukicd("sk003");
        bM_WariateHukaInfoKanri6.setCurrenttskid("007");
        bM_WariateHukaInfoKanri6.setNexttskid("002");
        bM_WariateHukaInfoKanri6.setRenno(6);
        bizDomManager.insert(bM_WariateHukaInfoKanri6);

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri2 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri2.setSubSystemId("002");
        bM_WariateHukaInfoKanri2.setJimutetuzukicd("sk002");
        bM_WariateHukaInfoKanri2.setCurrenttskid("008");
        bM_WariateHukaInfoKanri2.setNexttskid("003");
        bM_WariateHukaInfoKanri2.setRenno(2);
        bizDomManager.insert(bM_WariateHukaInfoKanri2);

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri3 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri3.setSubSystemId("002");
        bM_WariateHukaInfoKanri3.setJimutetuzukicd("sk002");
        bM_WariateHukaInfoKanri3.setCurrenttskid("008");
        bM_WariateHukaInfoKanri3.setNexttskid("003");
        bM_WariateHukaInfoKanri3.setRenno(3);
        bizDomManager.insert(bM_WariateHukaInfoKanri3);

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri4 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri4.setSubSystemId("002");
        bM_WariateHukaInfoKanri4.setJimutetuzukicd("sk002");
        bM_WariateHukaInfoKanri4.setCurrenttskid("008");
        bM_WariateHukaInfoKanri4.setNexttskid("003");
        bM_WariateHukaInfoKanri4.setRenno(4);
        bizDomManager.insert(bM_WariateHukaInfoKanri4);

        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri5 = new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri5.setSubSystemId("003");
        bM_WariateHukaInfoKanri5.setJimutetuzukicd("sk001");
        bM_WariateHukaInfoKanri5.setCurrenttskid("007");
        bM_WariateHukaInfoKanri5.setNexttskid("002");
        bM_WariateHukaInfoKanri5.setRenno(5);
        bizDomManager.insert(bM_WariateHukaInfoKanri5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllWariateHukaInfoKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("004", "sk004", "004", "005");

        assertEquals(0, wariateHukaInfoKanriLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("001", "sk001", "007", "002");

        assertEquals(1, wariateHukaInfoKanriLst.size());
        assertEquals("001", wariateHukaInfoKanriLst.get(0).getSubSystemId());
        assertEquals("sk001",wariateHukaInfoKanriLst.get(0).getJimutetuzukicd());
        assertEquals("007",wariateHukaInfoKanriLst.get(0).getCurrenttskid());
        assertEquals("002",wariateHukaInfoKanriLst.get(0).getNexttskid());
        assertEquals(Integer.valueOf(1),wariateHukaInfoKanriLst.get(0).getRenno());
    }
    @Test
    @TestOrder(30)
    public void normal3(){

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("002", "sk002", "008", "003");

        assertEquals(3, wariateHukaInfoKanriLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("002","sk002","008","003",Integer.valueOf(2)),"1");
        map.put($("002","sk002","008","003",Integer.valueOf(3)),"1");
        map.put($("002","sk002","008","003",Integer.valueOf(4)),"1");

        for(BM_WariateHukaInfoKanri wariateHukaInfoKanri : wariateHukaInfoKanriLst){
            map.remove($(wariateHukaInfoKanri.getSubSystemId(),wariateHukaInfoKanri.getJimutetuzukicd(),wariateHukaInfoKanri.getCurrenttskid(),
                wariateHukaInfoKanri.getNexttskid(),wariateHukaInfoKanri.getRenno()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("", "sk001", "007", "002");

        assertEquals(0, wariateHukaInfoKanriLst.size());

    }
    @Test
    @TestOrder(50)
    public void blank2() {

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("001", "", "007", "002");

        assertEquals(0, wariateHukaInfoKanriLst.size());

    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("001", "sk001", "", "002");

        assertEquals(0, wariateHukaInfoKanriLst.size());

    }
    @Test
    @TestOrder(70)
    public void blank4() {

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid("001", "sk001", "007", "");

        assertEquals(0, wariateHukaInfoKanriLst.size());

    }

}
