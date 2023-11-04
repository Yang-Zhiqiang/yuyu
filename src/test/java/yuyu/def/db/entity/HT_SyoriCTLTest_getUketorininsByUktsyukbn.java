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

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 受取人テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getUketorininsByUktsyukbn {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("791112220");
            Assert.assertEquals(0, syoriCTL1.getUketorininsByUktsyukbn(C_UktsyuKbn.BLNK).size());

            HT_Uketorinin uketorinin1 = syoriCTL1.createUketorinin();
            uketorinin1.setUktsyurenno(1);
            uketorinin1.setUktsyukbn(C_UktsyuKbn.BLNK);

            HT_Uketorinin uketorinin2 = syoriCTL1.createUketorinin();
            uketorinin2.setUktsyurenno(2);
            uketorinin2.setUktsyukbn(C_UktsyuKbn.SBUKT);

            HT_Uketorinin uketorinin3 = syoriCTL1.createUketorinin();
            uketorinin3.setUktsyurenno(3);
            uketorinin3.setUktsyukbn(C_UktsyuKbn.STDRSK);

            HT_Uketorinin uketorinin4 = syoriCTL1.createUketorinin();
            uketorinin4.setUktsyurenno(4);
            uketorinin4.setUktsyukbn(C_UktsyuKbn.STDRSK);

            HT_Uketorinin uketorinin5 = syoriCTL1.createUketorinin();
            uketorinin5.setUktsyurenno(5);
            uketorinin5.setUktsyukbn(C_UktsyuKbn.STDRSK);
            sinkeiyakuDomManager.insert(syoriCTL1);
        }
        HT_SyoriCTL syoriCTL2 =  sinkeiyakuDomManager.getSyoriCTL("791112238");
        if (syoriCTL2 == null) {
            syoriCTL2 = new HT_SyoriCTL("791112238");

            HT_Uketorinin uketorinin6 = syoriCTL2.createUketorinin();
            uketorinin6.setUktsyurenno(5);
            uketorinin6.setUktsyukbn(C_UktsyuKbn.KEIZKNKUKT);
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.KEIZKNKUKT);

        Assert.assertEquals(0, uketorininLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.BLNK);

        Assert.assertEquals(1, uketorininLst.size());
        Assert.assertEquals("791112220", uketorininLst.get(0).getMosno());
        Assert.assertEquals(1, uketorininLst.get(0).getUktsyurenno().intValue());
        Assert.assertEquals(C_UktsyuKbn.BLNK, uketorininLst.get(0).getUktsyukbn());
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK);

        Assert.assertEquals(3, uketorininLst.size());

        Assert.assertEquals("791112220", uketorininLst.get(0).getMosno());
        Assert.assertEquals("791112220", uketorininLst.get(1).getMosno());
        Assert.assertEquals("791112220", uketorininLst.get(2).getMosno());

        Assert.assertEquals(3, uketorininLst.get(0).getUktsyurenno().intValue());
        Assert.assertEquals(4, uketorininLst.get(1).getUktsyurenno().intValue());
        Assert.assertEquals(5, uketorininLst.get(2).getUktsyurenno().intValue());

        Assert.assertEquals(C_UktsyuKbn.STDRSK, uketorininLst.get(0).getUktsyukbn());
        Assert.assertEquals(C_UktsyuKbn.STDRSK, uketorininLst.get(1).getUktsyukbn());
        Assert.assertEquals(C_UktsyuKbn.STDRSK, uketorininLst.get(2).getUktsyukbn());

    }
}
