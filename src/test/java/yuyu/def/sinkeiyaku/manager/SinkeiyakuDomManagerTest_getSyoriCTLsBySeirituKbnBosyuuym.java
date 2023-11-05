package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsBySeirituKbnBosyuuym() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsBySeirituKbnBosyuuym {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SyoriCTL> beans =
                sinkeiyakuDomManager.getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM.valueOf(201611))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSyono("11807111118");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setBosyuuym(BizDateYM.valueOf(201611));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSyono("11807111118");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setBosyuuym(BizDateYM.valueOf(201610));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSyono("11807111130");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.HUSEIRITU);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setBosyuuym(BizDateYM.valueOf(201611));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSyono("11807111163");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setBosyuuym(BizDateYM.valueOf(201612));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSyono("11807111152");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setBosyuuym(BizDateYM.valueOf(201612));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSyono("11807111141");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setBosyuuym(BizDateYM.valueOf(201612));

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setSyono("11807111118");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.SEIRITU);

        sinkeiyakuDomManager.insert(syoriCTL7);


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

        try (ExDBResults<HT_SyoriCTL> beans =
                sinkeiyakuDomManager.getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM.valueOf(201609))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<HT_SyoriCTL> beans =
                sinkeiyakuDomManager.getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM.valueOf(201611));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112220", syoriCTL.getMosno());
                Assert.assertEquals("11807111118", syoriCTL.getSyono());
                Assert.assertEquals(C_SeirituKbn.SEIRITU, syoriCTL.getSeiritukbn());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<HT_SyoriCTL> beans =
                sinkeiyakuDomManager.getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM.valueOf(201612));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112279", syoriCTL.getMosno());
                Assert.assertEquals("11807111141", syoriCTL.getSyono());
                Assert.assertEquals(C_SeirituKbn.SEIRITU, syoriCTL.getSeiritukbn());
            }

            if (2 == iCount) {
                Assert.assertEquals("791112261", syoriCTL.getMosno());
                Assert.assertEquals("11807111152", syoriCTL.getSyono());
                Assert.assertEquals(C_SeirituKbn.SEIRITU, syoriCTL.getSeiritukbn());
            }

            if (3 == iCount) {
                Assert.assertEquals("791112253", syoriCTL.getMosno());
                Assert.assertEquals("11807111163", syoriCTL.getSyono());
                Assert.assertEquals(C_SeirituKbn.SEIRITU, syoriCTL.getSeiritukbn());
            }
        }
        Assert.assertEquals(3, iCount);
    }
}
