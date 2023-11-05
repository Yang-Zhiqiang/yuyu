package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getImusateiRirekiMaxRennoByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getImusateiRirekiMaxRennoByMosno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        Integer maxMosno = sinkeiyakuDomManager.getImusateiRirekiMaxRennoByMosno("10000000001");

        Assert.assertEquals(null,maxMosno);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("10000000001");

            HT_ImusateiRireki hT_ImusateiRireki1 = syoriCTL1.createImusateiRireki();
            hT_ImusateiRireki1.setRenno(1);

            HT_ImusateiRireki hT_ImusateiRireki3 = syoriCTL1.createImusateiRireki();
            hT_ImusateiRireki3.setRenno(2);

            HT_ImusateiRireki hT_ImusateiRireki4 = syoriCTL1.createImusateiRireki();
            hT_ImusateiRireki4.setRenno(3);

            HT_ImusateiRireki hT_ImusateiRireki5 = syoriCTL1.createImusateiRireki();
            hT_ImusateiRireki5.setRenno(4);

            sinkeiyakuDomManager.insert(syoriCTL1);
        }
        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        if (syoriCTL2 == null) {
            syoriCTL2 = new HT_SyoriCTL("10000000002");
            HT_ImusateiRireki hT_ImusateiRireki2 = syoriCTL2.createImusateiRireki();
            hT_ImusateiRireki2.setRenno(5);
            sinkeiyakuDomManager.insert(syoriCTL2);
        }
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
        Integer maxMosno = sinkeiyakuDomManager.getImusateiRirekiMaxRennoByMosno("10000000003");
        Assert.assertEquals(null, maxMosno);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        Integer maxMosno = sinkeiyakuDomManager.getImusateiRirekiMaxRennoByMosno("10000000001");
        Assert.assertEquals(4, maxMosno.intValue());
    }

    @Test
    @TestOrder(30)
    public void noResult2() {
        Integer maxMosno = sinkeiyakuDomManager.getImusateiRirekiMaxRennoByMosno("");
        Assert.assertEquals(null, maxMosno);
    }

}
