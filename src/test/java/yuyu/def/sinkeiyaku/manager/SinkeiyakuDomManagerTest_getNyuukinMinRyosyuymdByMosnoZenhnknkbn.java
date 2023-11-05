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
public class SinkeiyakuDomManagerTest_getNyuukinMinRyosyuymdByMosnoZenhnknkbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosnoZenhnknkbn("800000001", C_ZenhnknKbn.SUMI);
        Assert.assertEquals(null, minRyosyuymdByMosno);

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("800000001");

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(1);
            nyuukin1.setZenhnknkbn(C_ZenhnknKbn.SUMI);
            nyuukin1.setRyosyuymd(BizDate.valueOf("20160103"));

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(4);
            nyuukin2.setZenhnknkbn(C_ZenhnknKbn.SUMI);
            nyuukin2.setRyosyuymd(BizDate.valueOf("20160104"));

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(5);
            nyuukin3.setZenhnknkbn(C_ZenhnknKbn.SUMI);
            nyuukin3.setRyosyuymd(BizDate.valueOf("20160105"));

            HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
            nyuukin4.setRenno(2);
            nyuukin4.setZenhnknkbn(C_ZenhnknKbn.BLNK);
            nyuukin4.setRyosyuymd(BizDate.valueOf("20160102"));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL3 =  sinkeiyakuDomManager.getSyoriCTL("800000003");
        if(syoriCTL3 == null) {

            syoriCTL3 = new HT_SyoriCTL("800000003");

            HT_Nyuukin nyuukin3 = syoriCTL3.createNyuukin();
            nyuukin3.setRenno(3);
            nyuukin3.setZenhnknkbn(C_ZenhnknKbn.SUMI);
            nyuukin3.setRyosyuymd(BizDate.valueOf("20160101"));

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

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosnoZenhnknkbn("800000003", C_ZenhnknKbn.BLNK);
        Assert.assertEquals(null, minRyosyuymdByMosno);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosnoZenhnknkbn("800000001", C_ZenhnknKbn.SUMI);
        Assert.assertEquals(BizDate.valueOf("20160103"), minRyosyuymdByMosno);
    }

    @Test
    @TestOrder(30)
    public void blankCondition() {

        BizDate minRyosyuymdByMosno = sinkeiyakuDomManager.getNyuukinMinRyosyuymdByMosnoZenhnknkbn("", C_ZenhnknKbn.SUMI);
        Assert.assertEquals(null, minRyosyuymdByMosno);

    }

}
