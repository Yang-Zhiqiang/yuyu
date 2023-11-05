package yuyu.def.db.entity;

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
 * 処理コントロールテーブルエンティティから、<br />
 * 受取人種類区分、受取人種類別連番を指定して、<br />
 * 受取人テーブルエンティティ取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getUketorininByUktsyukbnUktsyurenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static Integer P_UKTSYURENNO_01 = new Integer(11);
    static Integer P_UKTSYURENNO_02 = new Integer(22);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_01);

        HT_Uketorinin hT_Uketorinin = hT_SyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.BLNK, P_UKTSYURENNO_01);

        Assert.assertEquals(null, hT_Uketorinin);

        HT_Uketorinin hT_Uketorinin1 = hT_SyoriCTL.createUketorinin();
        hT_Uketorinin1.setUktsyukbn(C_UktsyuKbn.BLNK);
        hT_Uketorinin1.setUktsyurenno(P_UKTSYURENNO_01);

        HT_Uketorinin hT_Uketorinin2 = hT_SyoriCTL.createUketorinin();
        hT_Uketorinin2.setUktsyukbn(C_UktsyuKbn.BLNK);
        hT_Uketorinin2.setUktsyurenno(P_UKTSYURENNO_02);

        HT_Uketorinin hT_Uketorinin3 = hT_SyoriCTL.createUketorinin();
        hT_Uketorinin3.setUktsyukbn(C_UktsyuKbn.SBUKT);
        hT_Uketorinin3.setUktsyurenno(P_UKTSYURENNO_01);

        sinkeiyakuDomManager.insert(hT_SyoriCTL);
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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_01);

        HT_Uketorinin hT_Uketorinin = hT_SyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, P_UKTSYURENNO_01);

        Assert.assertNull(hT_Uketorinin);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_01);

        HT_Uketorinin hT_Uketorinin = hT_SyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.BLNK, P_UKTSYURENNO_01);

        Assert.assertEquals(P_MOSNO_01, hT_Uketorinin.getMosno());
        Assert.assertEquals(C_UktsyuKbn.BLNK, hT_Uketorinin.getUktsyukbn());
        Assert.assertEquals(P_UKTSYURENNO_01, hT_Uketorinin.getUktsyurenno());
    }
}
