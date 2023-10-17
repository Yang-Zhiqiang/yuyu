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
 * getBAKSyoriCTLsBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getBAKSyoriCTLsBySyonoTrkssikibetukey {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLList = sinkeiyakuDomManager.getBAKSyoriCTLsBySyonoTrkssikibetukey("11807111118","0001");

        Assert.assertEquals(0, bAK_SyoriCTLList.size());

        HT_BAK_SyoriCTL bAK_SyoriCTL1 = new HT_BAK_SyoriCTL("791112220", "0001");
        bAK_SyoriCTL1.setSyono("11807111118");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL1);

        HT_BAK_SyoriCTL bAK_SyoriCTL2 = new HT_BAK_SyoriCTL("791112238", "0002");
        bAK_SyoriCTL2.setSyono("11807111129");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL2);

        HT_BAK_SyoriCTL bAK_SyoriCTL3 = new HT_BAK_SyoriCTL("791112246", "0002");
        bAK_SyoriCTL3.setSyono("11807111129");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL3);

        HT_BAK_SyoriCTL bAK_SyoriCTL4 = new HT_BAK_SyoriCTL("791112253", "0002");
        bAK_SyoriCTL4.setSyono("11807111129");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL4);

        HT_BAK_SyoriCTL bAK_SyoriCTL5 = new HT_BAK_SyoriCTL("791112261", "0002");
        bAK_SyoriCTL5.setSyono("11807111152");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL5);

        HT_BAK_SyoriCTL bAK_SyoriCTL6 = new HT_BAK_SyoriCTL("791112279", "0003");
        bAK_SyoriCTL6.setSyono("11807111129");

        sinkeiyakuDomManager.insert(bAK_SyoriCTL6);

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

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLList = sinkeiyakuDomManager.getBAKSyoriCTLsBySyonoTrkssikibetukey("11807111163","0004");

        Assert.assertEquals(0, bAK_SyoriCTLList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLList = sinkeiyakuDomManager.getBAKSyoriCTLsBySyonoTrkssikibetukey("11807111118","0001");

        Assert.assertEquals(1, bAK_SyoriCTLList.size());

        assertEquals("791112220", bAK_SyoriCTLList.get(0).getMosno());
        assertEquals("0001", bAK_SyoriCTLList.get(0).getTrkssikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112238","0002"), "1");
        datamap.put($("791112246","0002"), "1");
        datamap.put($("791112253","0002"), "1");

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLList = sinkeiyakuDomManager.getBAKSyoriCTLsBySyonoTrkssikibetukey("11807111129","0002");

        for(HT_BAK_SyoriCTL baksyoriCTL:bAK_SyoriCTLList){
            datamap.remove($(
                baksyoriCTL.getMosno(),
                baksyoriCTL.getTrkssikibetukey()));
        }

        Assert.assertEquals(3, bAK_SyoriCTLList.size());

        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLList = sinkeiyakuDomManager.getBAKSyoriCTLsBySyonoTrkssikibetukey("","0002");

        Assert.assertEquals(0, bAK_SyoriCTLList.size());

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<HT_BAK_SyoriCTL> bAK_SyoriCTLList = sinkeiyakuDomManager.getBAKSyoriCTLsBySyonoTrkssikibetukey("11807111129","");

        Assert.assertEquals(0, bAK_SyoriCTLList.size());

    }
}
