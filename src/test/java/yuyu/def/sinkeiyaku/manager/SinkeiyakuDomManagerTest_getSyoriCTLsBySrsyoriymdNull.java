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
 * getSyoriCTLsBySrsyoriymdNull() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsBySrsyoriymdNull {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymdNull(BizDate.valueOf(20160513));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112238");
        syoriCTL1.setSrsyoriymd(BizDate.valueOf(20160513));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112246");
        syoriCTL2.setSrsyoriymd(BizDate.valueOf(20160512));

        sinkeiyakuDomManager.insert(syoriCTL2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void noResult1(){

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymdNull(BizDate.valueOf(20170513));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30(){
        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112220");

        sinkeiyakuDomManager.insert(syoriCTL3);
    }

    @Test
    @TestOrder(31)
    public void normal31(){

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymdNull(BizDate.valueOf(20160513));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
            if (1 == iCount) {
                Assert.assertEquals("791112220", syoriCTL.getMosno());
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal40(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112238"), "1");
        datamap.put($("791112246"), "1");
        datamap.put($("791112220"), "1");

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymdNull(BizDate.valueOf(20160511));

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
