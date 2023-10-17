package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinsByHnkninputrenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("791112220");
            List<HT_Henkin> henkinList = syoriCTL1.getHenkinsByHnkninputrenno("10012002");
            Assert.assertEquals(0, henkinList.size());

            HT_Henkin henkin1 = syoriCTL1.createHenkin();
            henkin1.setRenno(10);
            henkin1.setHnkninputrenno("10012002");

            HT_Henkin henkin2 = syoriCTL1.createHenkin();
            henkin2.setRenno(15);
            henkin2.setHnkninputrenno("11112002");

            sinkeiyakuDomManager.insert(syoriCTL1);

        }

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin3 = syoriCTL2.createHenkin();
        henkin3.setRenno(11);
        henkin3.setHnkninputrenno("20021101");

        HT_Henkin henkin4 = syoriCTL2.createHenkin();
        henkin4.setRenno(12);
        henkin4.setHnkninputrenno("20021101");

        HT_Henkin henkin5 = syoriCTL2.createHenkin();
        henkin5.setRenno(13);
        henkin5.setHnkninputrenno("20021101");

        sinkeiyakuDomManager.insert(syoriCTL2);

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
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_Henkin> henkinList = syoriCTL1.getHenkinsByHnkninputrenno("30012002");

        Assert.assertEquals(0, henkinList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_Henkin> henkinList = syoriCTL1.getHenkinsByHnkninputrenno("10012002");

        Assert.assertEquals(1, henkinList.size());

        Assert.assertEquals("791112220", henkinList.get(0).getMosno());
        Assert.assertEquals(10, henkinList.get(0).getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_Henkin> henkinList = syoriCTL1.getHenkinsByHnkninputrenno("20021101");

        Assert.assertEquals(3, henkinList.size());

        Assert.assertEquals("791112246", henkinList.get(0).getMosno());
        Assert.assertEquals(11, henkinList.get(0).getRenno().intValue());

        Assert.assertEquals("791112246", henkinList.get(1).getMosno());
        Assert.assertEquals(12, henkinList.get(1).getRenno().intValue());

        Assert.assertEquals("791112246", henkinList.get(2).getMosno());
        Assert.assertEquals(13, henkinList.get(2).getRenno().intValue());

    }

    @Test
    @TestOrder(10)
    public void blankCondition1() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_Henkin> henkinList = syoriCTL1.getHenkinsByHnkninputrenno("");

        Assert.assertEquals(0, henkinList.size());
    }
}
