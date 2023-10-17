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

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinMinRyosyuymdByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("791112279");

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosno("791112279");
        Assert.assertEquals(null, minRyosyuymdByMosno);

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("791112279");

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(11);
            nyuukin1.setRyosyuymd(BizDate.valueOf(20150101));
            nyuukin1.setZenhnknkbn(C_ZenhnknKbn.valueOf("0"));

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(12);
            nyuukin2.setRyosyuymd(BizDate.valueOf(20150101));
            nyuukin2.setZenhnknkbn(C_ZenhnknKbn.valueOf("1"));

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(13);
            nyuukin3.setRyosyuymd(BizDate.valueOf(20160202));
            nyuukin3.setZenhnknkbn(C_ZenhnknKbn.valueOf("0"));

            HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
            nyuukin4.setRenno(14);
            nyuukin4.setRyosyuymd(BizDate.valueOf(20140202));
            nyuukin4.setZenhnknkbn(C_ZenhnknKbn.valueOf("0"));

            HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
            nyuukin5.setRenno(15);
            nyuukin5.setRyosyuymd(BizDate.valueOf(20160505));
            nyuukin5.setZenhnknkbn(C_ZenhnknKbn.valueOf("0"));

            sinkeiyakuDomManager.insert(syoriCTL1);

            HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112261");

            sinkeiyakuDomManager.insert(syoriCTL2);

            HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112220");

            HT_Nyuukin nyuukin6 = syoriCTL3.createNyuukin();
            nyuukin6.setRenno(15);
            nyuukin6.setRyosyuymd(BizDate.valueOf(20130505));
            nyuukin6.setZenhnknkbn(C_ZenhnknKbn.valueOf("0"));

            sinkeiyakuDomManager.insert(syoriCTL3);

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
    public void noResult() {

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosno("791112303");
        Assert.assertEquals(null, minRyosyuymdByMosno);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosno("791112279");

        Assert.assertEquals(BizDate.valueOf("20140202"), minRyosyuymdByMosno);
    }

    @Test
    @TestOrder(30)
    public void blankCondition() {

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosno("");
        Assert.assertEquals(null, minRyosyuymdByMosno);

    }

}
