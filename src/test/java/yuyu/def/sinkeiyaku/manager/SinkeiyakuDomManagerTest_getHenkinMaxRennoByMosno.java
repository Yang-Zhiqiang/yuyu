package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHenkinMaxRennoByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenkinMaxRennoByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Integer maxRenno = sinkeiyakuDomManager.getHenkinMaxRennoByMosno("10000000060");
        Assert.assertEquals(null,maxRenno);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if( null == syoriCTL ) {
            syoriCTL = new HT_SyoriCTL("10000000060");

            HT_Henkin henkin = syoriCTL.createHenkin();
            henkin.setRenno(10);

            HT_Henkin henkin1 = syoriCTL.createHenkin();
            henkin1.setRenno(11);

            HT_Henkin henkin2 = syoriCTL.createHenkin();
            henkin2.setRenno(12);
            sinkeiyakuDomManager.insert(syoriCTL);

        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("10000000070");
        HT_Henkin henkin4 = syoriCTL1.createHenkin();
        henkin4.setRenno(13);
        sinkeiyakuDomManager.insert(syoriCTL1);

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

        Integer maxRenno = sinkeiyakuDomManager.getHenkinMaxRennoByMosno("10000000080");
        Assert.assertEquals(null,maxRenno);

    }

    @Test
    @TestOrder(20)
    public void blank() {

        Integer maxRenno = sinkeiyakuDomManager.getHenkinMaxRennoByMosno("");
        Assert.assertEquals(null,maxRenno);

    }
    @Test
    @TestOrder(30)
    public void normal1() {

        Integer maxRenno = sinkeiyakuDomManager.getHenkinMaxRennoByMosno("10000000060");
        Assert.assertEquals(Integer.valueOf(12),maxRenno);
    }
}
