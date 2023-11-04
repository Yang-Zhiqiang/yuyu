package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getNyuukinByMosnoMaxRenno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinByMosnoMaxRenno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMaxRenno("800000001");
        Assert.assertEquals(null, nyuukin);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("800000001");

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(1);

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(4);

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(5);

            HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
            nyuukin4.setRenno(2);

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 =  new HT_SyoriCTL("800000003");

        HT_Nyuukin nyuukin5 = syoriCTL2.createNyuukin();
        nyuukin5.setRenno(5);
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
    public void noResult() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMaxRenno("800000004");
        Assert.assertEquals(null, nyuukin);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMaxRenno("800000001");
        Assert.assertEquals(Integer.valueOf(5), nyuukin.getRenno());
        Assert.assertEquals("800000001", nyuukin.getMosno());
    }

    @Test
    @TestOrder(30)
    public void blankCondition() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMaxRenno("");
        Assert.assertEquals(null, nyuukin);

    }

}
