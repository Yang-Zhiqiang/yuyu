package yuyu.def.db.entity;

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
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金テーブルエンティティから、<br />
 * 申込番号、全額返金区分を指定して<br />
 * 入金テーブルエンティティ最小領収日を取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNyuukinMinRyosyuymdByZenhnknkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112253";
    static Integer P_RENNO_001 = new Integer(1);
    static Integer P_RENNO_002 = new Integer(2);
    static Integer P_RENNO_003 = new Integer(3);
    static Integer P_RENNO_004 = new Integer(4);
    static Integer P_RENNO_005 = new Integer(5);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_02);

        BizDate minRyosyuymd = syoriCTL1.getNyuukinMinRyosyuymdByZenhnknkbn(C_ZenhnknKbn.SUMI);
        Assert.assertNull(minRyosyuymd);

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(P_RENNO_001);
        nyuukin1.setRyosyuymd(BizDate.valueOf("20160321"));
        nyuukin1.setZenhnknkbn(C_ZenhnknKbn.SUMI);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(P_RENNO_002);
        nyuukin2.setRyosyuymd(BizDate.valueOf("20160318"));
        nyuukin2.setZenhnknkbn(C_ZenhnknKbn.SUMI);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(P_RENNO_003);
        nyuukin3.setRyosyuymd(BizDate.valueOf("20160311"));
        nyuukin3.setZenhnknkbn(C_ZenhnknKbn.SUMI);

        HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
        nyuukin4.setRenno(P_RENNO_004);
        nyuukin4.setZenhnknkbn(C_ZenhnknKbn.SUMI);

        HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
        nyuukin5.setRenno(P_RENNO_005);
        nyuukin5.setRyosyuymd(BizDate.valueOf("20160301"));
        nyuukin5.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_01);

        HT_Nyuukin nyuukin6 = syoriCTL2.createNyuukin();
        nyuukin6.setRenno(P_RENNO_001);
        nyuukin6.setRyosyuymd(BizDate.valueOf("20160301"));
        nyuukin6.setZenhnknkbn(C_ZenhnknKbn.SUMI);

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_01);

        BizDate minRyosyuymd = syoriCTL.getNyuukinMinRyosyuymdByZenhnknkbn(C_ZenhnknKbn.BLNK);
        Assert.assertNull(minRyosyuymd);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_02);

        BizDate minRyosyuymd = syoriCTL.getNyuukinMinRyosyuymdByZenhnknkbn(C_ZenhnknKbn.SUMI);
        Assert.assertEquals(BizDate.valueOf("20160311"), minRyosyuymd);
    }
}