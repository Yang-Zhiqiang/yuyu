package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

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
 * getHenkinCountByMosnoHnknsyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenkinCountByMosnoHnknsyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getHenkinCountByMosnoHnknsyoriymd("791112220");
        Assert.assertEquals(new Long(0),count);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if( null == syoriCTL ) {

            HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

            HT_Henkin henkin1 = syoriCTL1.createHenkin();
            henkin1.setRenno(10);


            HT_Henkin henkin2 = syoriCTL1.createHenkin();
            henkin2.setRenno(11);


            HT_Henkin henkin3 = syoriCTL1.createHenkin();
            henkin3.setRenno(12);


            HT_Henkin henkin4 = syoriCTL1.createHenkin();
            henkin4.setRenno(13);
            henkin4.setHnknsyoriymd(BizDate.valueOf(20160503));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Henkin henkin5 = syoriCTL2.createHenkin();
        henkin5.setRenno(14);

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

        Long count = sinkeiyakuDomManager.getHenkinCountByMosnoHnknsyoriymd("791112246");
        Assert.assertEquals(new Long(0),count);

    }

    @Test
    @TestOrder(20)
    public void blank() {

        Long count = sinkeiyakuDomManager.getHenkinCountByMosnoHnknsyoriymd("");
        Assert.assertEquals(new Long(0),count);

    }

    @Test
    @TestOrder(30)
    public void normal1() {

        Long count = sinkeiyakuDomManager.getHenkinCountByMosnoHnknsyoriymd("791112220");
        Assert.assertEquals(new Long(3),count);
    }
}

