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
 * 新契約<br />
 * 本社統計情報作成<br />
 * 環境査定履歴テーブルエンティティリスト取得　環境査定結果区分が固定値のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getKnksateiRirekisByKnksateikekkakbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_1 = "791112220";
    static String P_MOSNO_2 = "791112238";
    static String P_MOSNO_3 = "791112246";
    static String P_MOSNO_4 = "791112253";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_1);


        HT_KnksateiRireki knksateiRireki1 = syoriCTL1.createKnksateiRireki();
        knksateiRireki1.setRenno(new Integer(2));
        knksateiRireki1.setKnksateikekkakbn(C_SyorikekkaKbn.TENSOU);

        HT_KnksateiRireki knksateiRireki3 = syoriCTL1.createKnksateiRireki();
        knksateiRireki3.setRenno(new Integer(1));
        knksateiRireki3.setKnksateikekkakbn(C_SyorikekkaKbn.KANRYOU);

        HT_KnksateiRireki knksateiRireki4 = syoriCTL1.createKnksateiRireki();
        knksateiRireki4.setRenno(new Integer(3));
        knksateiRireki4.setKnksateikekkakbn(C_SyorikekkaKbn.KANRYOU);

        HT_KnksateiRireki knksateiRireki5 = syoriCTL1.createKnksateiRireki();
        knksateiRireki5.setRenno(new Integer(4));
        knksateiRireki5.setKnksateikekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_2);

        HT_KnksateiRireki knksateiRireki21 = syoriCTL2.createKnksateiRireki();
        knksateiRireki21.setRenno(new Integer(1));
        knksateiRireki21.setKnksateikekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL(P_MOSNO_3);

        HT_KnksateiRireki knksateiRireki31 = syoriCTL3.createKnksateiRireki();
        knksateiRireki31.setRenno(new Integer(1));
        knksateiRireki31.setKnksateikekkakbn(C_SyorikekkaKbn.HORYUU);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL(P_MOSNO_4);

        Assert.assertEquals(0, syoriCTL4.getKnksateiRirekisByKnksateikekkakbn().size());

        HT_KnksateiRireki knksateiRireki41 = syoriCTL4.createKnksateiRireki();
        knksateiRireki41.setRenno(new Integer(5));
        knksateiRireki41.setKnksateikekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager SinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        SinkeiyakuDomManager.delete(SinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_3);
        List<HT_KnksateiRireki> hT_KnksateiRirekiLst = hT_SyoriCTL.getKnksateiRirekisByKnksateikekkakbn();

        Assert.assertEquals(0, hT_KnksateiRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_4);
        List<HT_KnksateiRireki> hT_KnksateiRirekiLst = hT_SyoriCTL.getKnksateiRirekisByKnksateikekkakbn();

        Assert.assertEquals(1, hT_KnksateiRirekiLst.size());

        Assert.assertEquals(P_MOSNO_4, hT_KnksateiRirekiLst.get(0).getMosno());
        Assert.assertEquals(new Integer(5), hT_KnksateiRirekiLst.get(0).getRenno());
        Assert.assertEquals(C_SyorikekkaKbn.KANRYOU, hT_KnksateiRirekiLst.get(0).getKnksateikekkakbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);
        List<HT_KnksateiRireki> hT_KnksateiRirekiLst = hT_SyoriCTL.getKnksateiRirekisByKnksateikekkakbn();

        Assert.assertEquals(3, hT_KnksateiRirekiLst.size());

        Assert.assertEquals(P_MOSNO_1, hT_KnksateiRirekiLst.get(0).getMosno());
        Assert.assertEquals(new Integer(1), hT_KnksateiRirekiLst.get(0).getRenno());
        Assert.assertEquals(C_SyorikekkaKbn.KANRYOU, hT_KnksateiRirekiLst.get(0).getKnksateikekkakbn());

        Assert.assertEquals(P_MOSNO_1, hT_KnksateiRirekiLst.get(1).getMosno());
        Assert.assertEquals(new Integer(3), hT_KnksateiRirekiLst.get(1).getRenno());
        Assert.assertEquals(C_SyorikekkaKbn.KANRYOU, hT_KnksateiRirekiLst.get(1).getKnksateikekkakbn());

        Assert.assertEquals(P_MOSNO_1, hT_KnksateiRirekiLst.get(2).getMosno());
        Assert.assertEquals(new Integer(4), hT_KnksateiRirekiLst.get(2).getRenno());
        Assert.assertEquals(C_SyorikekkaKbn.KANRYOU, hT_KnksateiRirekiLst.get(2).getKnksateikekkakbn());
    }
}
