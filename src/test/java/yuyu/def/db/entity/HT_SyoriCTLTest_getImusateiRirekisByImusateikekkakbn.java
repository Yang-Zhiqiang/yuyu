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

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医務査定履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getImusateiRirekisByImusateikekkakbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("791112220");
            List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTL1.getImusateiRirekisByImusateikekkakbn(C_SyorikekkaKbn.BLNK);
            Assert.assertEquals(0, imusateiRirekiLst.size());

            HT_ImusateiRireki imusateiRireki1 = syoriCTL1.createImusateiRireki();
            imusateiRireki1.setRenno(11);
            imusateiRireki1.setImusateikekkakbn(C_SyorikekkaKbn.valueOf("0"));

            HT_ImusateiRireki imusateiRireki2 = syoriCTL1.createImusateiRireki();
            imusateiRireki2.setRenno(15);
            imusateiRireki2.setImusateikekkakbn(C_SyorikekkaKbn.valueOf("110"));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_ImusateiRireki imusateiRireki3 = syoriCTL3.createImusateiRireki();
        imusateiRireki3.setRenno(12);
        imusateiRireki3.setImusateikekkakbn(C_SyorikekkaKbn.valueOf("121"));

        HT_ImusateiRireki imusateiRireki4 = syoriCTL3.createImusateiRireki();
        imusateiRireki4.setRenno(13);
        imusateiRireki4.setImusateikekkakbn(C_SyorikekkaKbn.valueOf("121"));

        HT_ImusateiRireki imusateiRireki5 = syoriCTL3.createImusateiRireki();
        imusateiRireki5.setRenno(14);
        imusateiRireki5.setImusateikekkakbn(C_SyorikekkaKbn.valueOf("121"));

        sinkeiyakuDomManager.insert(syoriCTL3);

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
        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCtl1.getImusateiRirekisByImusateikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        Assert.assertEquals(0, imusateiRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCtl1.getImusateiRirekisByImusateikekkakbn(C_SyorikekkaKbn.BLNK);

        Assert.assertEquals(1, imusateiRirekiLst.size());

        Assert.assertEquals("791112220", imusateiRirekiLst.get(0).getMosno());
        Assert.assertEquals(11, imusateiRirekiLst.get(0).getRenno().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCtl1.getImusateiRirekisByImusateikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        Assert.assertEquals(3, imusateiRirekiLst.size());

        Assert.assertEquals("791112246", imusateiRirekiLst.get(0).getMosno());
        Assert.assertEquals(12, imusateiRirekiLst.get(0).getRenno().intValue());

        Assert.assertEquals("791112246", imusateiRirekiLst.get(1).getMosno());
        Assert.assertEquals(13, imusateiRirekiLst.get(1).getRenno().intValue());

        Assert.assertEquals("791112246", imusateiRirekiLst.get(2).getMosno());
        Assert.assertEquals(14, imusateiRirekiLst.get(2).getRenno().intValue());

    }
}



