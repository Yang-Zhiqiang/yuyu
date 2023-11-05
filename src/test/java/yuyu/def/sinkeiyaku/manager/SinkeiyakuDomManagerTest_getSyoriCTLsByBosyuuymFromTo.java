package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;

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

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsByBosyuuymFromTo() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByBosyuuymFromTo {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByBosyuuymFromTo(BizDateYM.valueOf(201609), BizDateYM.valueOf(201611))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setBosyuuym(BizDateYM.valueOf(201610));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setMosnrkumu(C_UmuKbn.NONE);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setBosyuuym(BizDateYM.valueOf(201610));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setBosyuuym(BizDateYM.valueOf(201608));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setBosyuuym(BizDateYM.valueOf(201612));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setBosyuuym(BizDateYM.valueOf(201708));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setBosyuuym(BizDateYM.valueOf(201709));

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setBosyuuym(BizDateYM.valueOf(201710));

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112519");
        syoriCTL8.setMosnrkumu(C_UmuKbn.ARI);

        sinkeiyakuDomManager.insert(syoriCTL8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByBosyuuymFromTo(BizDateYM.valueOf(201606), BizDateYM.valueOf(201607))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        ExDBResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByBosyuuymFromTo(BizDateYM.valueOf(201609), BizDateYM.valueOf(201611));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112220", syoriCTL.getMosno());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112261"), "1");
        datamap.put($("791112279"), "1");
        datamap.put($("791112287"), "1");

        ExDBResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByBosyuuymFromTo(BizDateYM.valueOf(201708), BizDateYM.valueOf(201710));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {

            datamap.remove($(
                syoriCTL.getMosno()));

            iCount++;
        }
        Assert.assertEquals(3, iCount);
        Assert.assertTrue(datamap.isEmpty());
    }
}
