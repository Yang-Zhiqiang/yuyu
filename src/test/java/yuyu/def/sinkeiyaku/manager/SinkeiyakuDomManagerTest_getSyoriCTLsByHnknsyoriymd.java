package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsByHnknsyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByHnknsyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
                getSyoriCTLsByHnknsyoriymd(BizDate.valueOf(20160215));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Henkin henkin1 = syoriCTL1.createHenkin();
        henkin1.setRenno(11);
        henkin1.setHnknsyoriymd(BizDate.valueOf(20160215));
        henkin1.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin2 = syoriCTL1.createHenkin();
        henkin2.setRenno(12);
        henkin2.setHnknsyoriymd(BizDate.valueOf(20160214));
        henkin2.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin3 = syoriCTL1.createHenkin();
        henkin3.setRenno(13);
        henkin3.setHnknsyoriymd(BizDate.valueOf(20160215));
        henkin3.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin4 = syoriCTL3.createHenkin();
        henkin4.setRenno(11);
        henkin4.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin4.setHnknhoukbn(C_HnknhouKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112261");

        HT_Henkin henkin5 = syoriCTL4.createHenkin();
        henkin5.setRenno(11);
        henkin5.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin5.setHnknhoukbn(C_HnknhouKbn.valueOf("2"));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112253");

        HT_Henkin henkin6 = syoriCTL5.createHenkin();
        henkin6.setRenno(11);
        henkin6.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin6.setHnknhoukbn(C_HnknhouKbn.valueOf("3"));

        sinkeiyakuDomManager.insert(syoriCTL5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
                getSyoriCTLsByHnknsyoriymd(BizDate.valueOf(20160216));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
                getSyoriCTLsByHnknsyoriymd(BizDate.valueOf(20160215));

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
    @TestOrder(30)
    public void normal2() {
        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
                getSyoriCTLsByHnknsyoriymd(BizDate.valueOf(20160315));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112246", syoriCTL.getMosno());
                continue;

            }
            if (2 == iCount) {
                Assert.assertEquals("791112253", syoriCTL.getMosno());
                continue;

            }
            if (3 == iCount) {
                Assert.assertEquals("791112261", syoriCTL.getMosno());
                continue;
            }
        }
        Assert.assertEquals(3, iCount);
    }
}

