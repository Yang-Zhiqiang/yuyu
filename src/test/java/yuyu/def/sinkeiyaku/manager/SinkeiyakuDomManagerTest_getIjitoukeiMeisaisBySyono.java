package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getIjitoukeiMeisaisBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getIjitoukeiMeisaisBySyono {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst = sinkeiyakuDomManager.getIjitoukeiMeisaisBySyono("11807111118");

        Assert.assertEquals(0,ijitoukeiMeisaiLst.size());

        HT_IjitoukeiMeisai ijitoukeiMeisai1 = new HT_IjitoukeiMeisai();
        ijitoukeiMeisai1.setSyono("11807111118");
        ijitoukeiMeisai1.setRenno8keta(10000001);
        sinkeiyakuDomManager.insert(ijitoukeiMeisai1);

        HT_IjitoukeiMeisai ijitoukeiMeisai2 = new HT_IjitoukeiMeisai();
        ijitoukeiMeisai2.setSyono("11807111129");
        ijitoukeiMeisai2.setRenno8keta(10000001);
        sinkeiyakuDomManager.insert(ijitoukeiMeisai2);

        HT_IjitoukeiMeisai ijitoukeiMeisai3 = new HT_IjitoukeiMeisai();
        ijitoukeiMeisai3.setSyono("11807111130");
        ijitoukeiMeisai3.setRenno8keta(10000001);
        sinkeiyakuDomManager.insert(ijitoukeiMeisai3);

        HT_IjitoukeiMeisai ijitoukeiMeisai4 = new HT_IjitoukeiMeisai();
        ijitoukeiMeisai4.setSyono("11807111130");
        ijitoukeiMeisai4.setRenno8keta(10000002);
        sinkeiyakuDomManager.insert(ijitoukeiMeisai4);

        HT_IjitoukeiMeisai ijitoukeiMeisai5 = new HT_IjitoukeiMeisai();
        ijitoukeiMeisai5.setSyono("11807111130");
        ijitoukeiMeisai5.setRenno8keta(10000003);
        sinkeiyakuDomManager.insert(ijitoukeiMeisai5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllIjitoukeiMeisai());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst = sinkeiyakuDomManager.getIjitoukeiMeisaisBySyono("11807111141");

        assertEquals(0, ijitoukeiMeisaiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst = sinkeiyakuDomManager.getIjitoukeiMeisaisBySyono("11807111118");

        assertEquals(1, ijitoukeiMeisaiLst.size());
        assertEquals("11807111118", ijitoukeiMeisaiLst.get(0).getSyono());
        assertEquals(10000001,ijitoukeiMeisaiLst.get(0).getRenno8keta().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111130",10000001), "1");
        datamap.put($("11807111130",10000002), "1");
        datamap.put($("11807111130",10000003), "1");

        List<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst = sinkeiyakuDomManager.getIjitoukeiMeisaisBySyono("11807111130");

        for(HT_IjitoukeiMeisai ijitoukeiMeisai:ijitoukeiMeisaiLst){
            datamap.remove($(
                ijitoukeiMeisai.getSyono(),
                ijitoukeiMeisai.getRenno8keta().intValue()));
        }

        assertEquals(3, ijitoukeiMeisaiLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst = sinkeiyakuDomManager.getIjitoukeiMeisaisBySyono("");

        assertEquals(0, ijitoukeiMeisaiLst.size());

    }
}

