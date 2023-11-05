package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinsByHnknsyoriymdHnknhoukbns {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("791112220");
            List<HT_Henkin> henkinList = syoriCtl1.getHenkinsByHnknsyoriymdHnknhoukbns(BizDate.valueOf(20160405), C_HnknhouKbn.KOUZASITEI);
            Assert.assertEquals(0, henkinList.size());

            HT_Henkin henkin1 = syoriCtl1.createHenkin();
            henkin1.setRenno(1);
            henkin1.setHnknsyoriymd(BizDate.valueOf(20160405));
            henkin1.setHnknhoukbn(C_HnknhouKbn.KOUZASITEI);

            HT_Henkin henkin2 = syoriCtl1.createHenkin();
            henkin2.setRenno(2);
            henkin2.setHnknsyoriymd(BizDate.valueOf(20160404));
            henkin2.setHnknhoukbn(C_HnknhouKbn.KOUZASITEI);

            HT_Henkin henkin3 = syoriCtl1.createHenkin();
            henkin3.setRenno(3);
            henkin3.setHnknsyoriymd(BizDate.valueOf(20160405));
            henkin3.setHnknhoukbn(C_HnknhouKbn.BLNK);

            sinkeiyakuDomManager.insert(syoriCtl1);

        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("791112238");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("791112238");

            HT_Henkin henkin4 = syoriCtl2.createHenkin();
            henkin4.setRenno(1);

            sinkeiyakuDomManager.insert(syoriCtl2);
        }

        HT_SyoriCTL syoriCtl3 = sinkeiyakuDomManager.getSyoriCTL("791112246");
        if (syoriCtl3 == null) {
            syoriCtl3 = new HT_SyoriCTL("791112246");
            HT_Henkin henkin5 = syoriCtl3.createHenkin();
            henkin5.setRenno(1);
            henkin5.setHnknsyoriymd(BizDate.valueOf(20160403));
            henkin5.setHnknhoukbn(C_HnknhouKbn.KOUZASITEI);

            HT_Henkin henkin6 = syoriCtl3.createHenkin();
            henkin6.setRenno(2);
            henkin6.setHnknsyoriymd(BizDate.valueOf(20160403));
            henkin6.setHnknhoukbn(C_HnknhouKbn.PHURIKZ);

            HT_Henkin henkin7 = syoriCtl3.createHenkin();
            henkin7.setRenno(3);
            henkin7.setHnknsyoriymd(BizDate.valueOf(20160403));
            henkin7.setHnknhoukbn(C_HnknhouKbn.PHURIKZ);

            sinkeiyakuDomManager.insert(syoriCtl3);
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
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnknsyoriymdHnknhoukbns(BizDate.valueOf(20160405), C_HnknhouKbn.KOUZASITEI);

        Assert.assertEquals(0, henkinList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnknsyoriymdHnknhoukbns(BizDate.valueOf(20160405), C_HnknhouKbn.KOUZASITEI);

        Assert.assertEquals(1, henkinList.size());

        Assert.assertEquals("791112220", henkinList.get(0).getMosno());
        Assert.assertEquals(1, henkinList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160405), henkinList.get(0).getHnknsyoriymd());
        Assert.assertEquals(C_HnknhouKbn.KOUZASITEI, henkinList.get(0).getHnknhoukbn());
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112246");

        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnknsyoriymdHnknhoukbns(BizDate.valueOf(20160403), C_HnknhouKbn.KOUZASITEI, C_HnknhouKbn.PHURIKZ);

        Assert.assertEquals(3, henkinList.size());

        Assert.assertEquals("791112246", henkinList.get(0).getMosno());
        Assert.assertEquals(1, henkinList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160403), henkinList.get(0).getHnknsyoriymd());
        Assert.assertEquals(C_HnknhouKbn.KOUZASITEI, henkinList.get(0).getHnknhoukbn());

        Assert.assertEquals("791112246", henkinList.get(1).getMosno());
        Assert.assertEquals(2, henkinList.get(1).getRenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160403), henkinList.get(1).getHnknsyoriymd());
        Assert.assertEquals(C_HnknhouKbn.PHURIKZ, henkinList.get(1).getHnknhoukbn());

        Assert.assertEquals("791112246", henkinList.get(2).getMosno());
        Assert.assertEquals(3, henkinList.get(2).getRenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160403), henkinList.get(2).getHnknsyoriymd());
        Assert.assertEquals(C_HnknhouKbn.PHURIKZ, henkinList.get(2).getHnknhoukbn());

    }
}
