package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 返金テーブルのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SyoriCTLTest_getHenkinsByHnknsyoriymd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000060");
            Assert.assertEquals(0, syoriCtl1.getHenkinsByHnknsyoriymd(BizDate.valueOf(20151231)).size());

            HT_Henkin henkin1 = syoriCtl1.createHenkin();
            henkin1.setRenno(1);
            henkin1.setHnknsyoriymd(BizDate.valueOf(20151231));

            HT_Henkin henkin2 = syoriCtl1.createHenkin();
            henkin2.setRenno(2);
            henkin2.setHnknsyoriymd(BizDate.valueOf(20151231));

            HT_Henkin henkin3 = syoriCtl1.createHenkin();
            henkin3.setRenno(3);
            henkin3.setHnknsyoriymd(BizDate.valueOf(20151231));

            HT_Henkin henkin4 = syoriCtl1.createHenkin();
            henkin4.setRenno(4);
            henkin4.setHnknsyoriymd(BizDate.valueOf(20151226));

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000070");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000070");

            HT_Henkin henkin5 = syoriCtl2.createHenkin();
            henkin5.setRenno(1);
            henkin5.setHnknsyoriymd(BizDate.valueOf(20151230));

            sinkeiyakuDomManager.insert(syoriCtl2);
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
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnknsyoriymd(BizDate.valueOf(20151228));

        Assert.assertEquals(0, henkinList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000070");
        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnknsyoriymd(BizDate.valueOf(20151230));

        Assert.assertEquals(1, henkinList.size());

        Assert.assertEquals("10000000070", henkinList.get(0).getMosno());
        Assert.assertEquals(1, henkinList.get(0).getRenno().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnknsyoriymd(BizDate.valueOf(20151231));

        Assert.assertEquals(3, henkinList.size());

        Assert.assertEquals("10000000060", henkinList.get(0).getMosno());
        Assert.assertEquals(1, henkinList.get(0).getRenno().intValue());

        Assert.assertEquals("10000000060", henkinList.get(1).getMosno());
        Assert.assertEquals(2, henkinList.get(1).getRenno().intValue());

        Assert.assertEquals("10000000060", henkinList.get(2).getMosno());
        Assert.assertEquals(3, henkinList.get(2).getRenno().intValue());

    }
}
