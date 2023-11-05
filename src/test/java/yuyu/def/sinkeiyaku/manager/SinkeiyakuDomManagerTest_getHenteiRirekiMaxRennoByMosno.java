package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_HenteiRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 変更訂正履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenteiRirekiMaxRennoByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("800000001");

            Integer maxRennoByMosno = sinkeiyakuDomManager.getHenteiRirekiMaxRennoByMosno("800000001");
            Assert.assertEquals(null, maxRennoByMosno);

            HT_HenteiRireki henteiRireki1 = syoriCTL1.createHenteiRireki();
            henteiRireki1.setRenno(1);

            HT_HenteiRireki henteiRireki2 = syoriCTL1.createHenteiRireki();
            henteiRireki2.setRenno(2);

            HT_HenteiRireki henteiRireki3 = syoriCTL1.createHenteiRireki();
            henteiRireki3.setRenno(3);

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 =  sinkeiyakuDomManager.getSyoriCTL("800000002");
        if(syoriCTL2 == null) {

            syoriCTL2 = new HT_SyoriCTL("800000002");

            HT_HenteiRireki henteiRireki4 = syoriCTL2.createHenteiRireki();
            henteiRireki4.setRenno(4);

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

        Integer maxRennoByMosno = sinkeiyakuDomManager.getHenteiRirekiMaxRennoByMosno("800000003");
        Assert.assertEquals(null, maxRennoByMosno);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Integer maxRennoByMosno = sinkeiyakuDomManager.getHenteiRirekiMaxRennoByMosno("800000001");
        Assert.assertEquals(Integer.valueOf(3), maxRennoByMosno);
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Integer maxRennoByMosno = sinkeiyakuDomManager.getHenteiRirekiMaxRennoByMosno("");
        Assert.assertEquals(null, maxRennoByMosno);

    }

}
