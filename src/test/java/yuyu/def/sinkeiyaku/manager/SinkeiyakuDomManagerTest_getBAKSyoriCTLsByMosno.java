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

import yuyu.def.db.entity.HT_BAK_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getBAKSyoriCTLsByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getBAKSyoriCTLsByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLLst = sinkeiyakuDomManager.getBAKSyoriCTLsByMosno("791112220");

        Assert.assertEquals(0, bAK_SyoriCTLLst.size());

        HT_BAK_SyoriCTL bAK_SyoriCTL1 = new HT_BAK_SyoriCTL("791112220", "1001");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL1);

        HT_BAK_SyoriCTL bAK_SyoriCTL2 = new HT_BAK_SyoriCTL("791112238", "1001");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL2);

        HT_BAK_SyoriCTL bAK_SyoriCTL3 = new HT_BAK_SyoriCTL("791112246", "1002");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL3);

        HT_BAK_SyoriCTL bAK_SyoriCTL4 = new HT_BAK_SyoriCTL("791112246", "1003");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL4);

        HT_BAK_SyoriCTL bAK_SyoriCTL5 = new HT_BAK_SyoriCTL("791112246", "1004");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBAKSyoriCTL());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLLst = sinkeiyakuDomManager.getBAKSyoriCTLsByMosno(
            "791112253");

        assertEquals(0, bAK_SyoriCTLLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLLst = sinkeiyakuDomManager.getBAKSyoriCTLsByMosno(
            "791112220");

        assertEquals(1, bAK_SyoriCTLLst.size());

        assertEquals("791112220", bAK_SyoriCTLLst.get(0).getMosno());
        assertEquals("1001", bAK_SyoriCTLLst.get(0).getTrkssikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112246","1002"), "1");
        datamap.put($("791112246","1003"), "1");
        datamap.put($("791112246","1004"), "1");

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLLst = sinkeiyakuDomManager.getBAKSyoriCTLsByMosno(
            "791112246");

        for(HT_BAK_SyoriCTL baksyoriCTL:bAK_SyoriCTLLst){
            datamap.remove($(
                baksyoriCTL.getMosno(),
                baksyoriCTL.getTrkssikibetukey()));
        }

        assertEquals(3, bAK_SyoriCTLLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLLst = sinkeiyakuDomManager.getBAKSyoriCTLsByMosno(
            "");
        Assert.assertEquals(0, bAK_SyoriCTLLst.size());

    }
}
