package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsBySrsyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsBySrsyoriymd {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymd(BizDate.valueOf(20160111));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("10000000060");
        syoriCTL.setSrsyoriymd(BizDate.valueOf(20160111));
        sinkeiyakuDomManager.insert(syoriCTL);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL();
        syoriCTL2.setMosno("10000000070");
        syoriCTL2.setSrsyoriymd(BizDate.valueOf(20160112));
        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL();
        syoriCTL3.setMosno("10000000080");
        syoriCTL3.setSrsyoriymd(BizDate.valueOf(20160112));
        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL();
        syoriCTL4.setMosno("10000000090");
        syoriCTL4.setSrsyoriymd(BizDate.valueOf(20160112));
        sinkeiyakuDomManager.insert(syoriCTL4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymd(BizDate.valueOf(20160110));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymd(BizDate.valueOf(20160111));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
            if (1 == iCount) {
                Assert.assertEquals("10000000060", syoriCTL.getMosno());
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000070"), "1");
        datamap.put($("10000000080"), "1");
        datamap.put($("10000000090"), "1");

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymd(BizDate.valueOf(20160112));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
            datamap.remove($(
                syoriCTL.getMosno()));
        }
        Assert.assertEquals(3, iCount);
        Assert.assertTrue(datamap.isEmpty());
    }
}
