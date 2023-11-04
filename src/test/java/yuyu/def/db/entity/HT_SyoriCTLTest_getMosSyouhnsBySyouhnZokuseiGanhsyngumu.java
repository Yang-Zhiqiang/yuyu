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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 申込商品テーブルエンティティリスト取得(がん保障日額有無)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getMosSyouhnsBySyouhnZokuseiGanhsyngumu {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_SYOUHNCD_01 = "SH01";
    static String P_SYOUHNCD_02 = "SH02";
    static String P_SYOUHNCD_03 = "SH03";
    static String P_SYOUHNCD_04 = "SH04";
    static String P_SYOUHNCD_05 = "SH05";
    static String P_SYOUHNCD_06 = "SH06";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);

        Assert.assertEquals(0, syoriCTL1.getMosSyouhnsBySyouhnZokuseiGanhsyngumu(C_UmuKbn.ARI).size());

        HT_MosSyouhn mosSyouhn1 = syoriCTL1.createMosSyouhn();
        mosSyouhn1.setSyouhncd(P_SYOUHNCD_01);
        mosSyouhn1.setSyouhnsdno(1);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_MosSyouhn mosSyouhn2 = syoriCTL2.createMosSyouhn();
        mosSyouhn2.setSyouhncd(P_SYOUHNCD_01);
        mosSyouhn2.setSyouhnsdno(1);

        HT_MosSyouhn mosSyouhn3 = syoriCTL2.createMosSyouhn();
        mosSyouhn3.setSyouhncd(P_SYOUHNCD_02);
        mosSyouhn3.setSyouhnsdno(1);

        HT_MosSyouhn mosSyouhn4 = syoriCTL2.createMosSyouhn();
        mosSyouhn4.setSyouhncd(P_SYOUHNCD_03);
        mosSyouhn4.setSyouhnsdno(1);

        HT_MosSyouhn mosSyouhn5 = syoriCTL2.createMosSyouhn();
        mosSyouhn5.setSyouhncd(P_SYOUHNCD_04);
        mosSyouhn5.setSyouhnsdno(1);

        HT_MosSyouhn mosSyouhn6 = syoriCTL2.createMosSyouhn();
        mosSyouhn6.setSyouhncd(P_SYOUHNCD_05);
        mosSyouhn6.setSyouhnsdno(1);

        HT_MosSyouhn mosSyouhn7 = syoriCTL2.createMosSyouhn();
        mosSyouhn7.setSyouhncd(P_SYOUHNCD_06);
        mosSyouhn7.setSyouhnsdno(1);

        sinkeiyakuDomManager.insert(syoriCTL2);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei(P_SYOUHNCD_01, 1);
        syouhnZokusei1.setGanhsyngumu(C_UmuKbn.ARI);

        sinkeiyakuDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei(P_SYOUHNCD_02, 1);
        syouhnZokusei2.setGanhsyngumu(C_UmuKbn.ARI);

        sinkeiyakuDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei(P_SYOUHNCD_03, 1);
        syouhnZokusei3.setGanhsyngumu(C_UmuKbn.ARI);

        sinkeiyakuDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei(P_SYOUHNCD_05, 2);
        syouhnZokusei4.setGanhsyngumu(C_UmuKbn.ARI);

        sinkeiyakuDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei(P_SYOUHNCD_06, 1);
        syouhnZokusei5.setGanhsyngumu(C_UmuKbn.NONE);

        sinkeiyakuDomManager.insert(syouhnZokusei5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_01);

        Assert.assertEquals(0, syoriCTL1.getMosSyouhnsBySyouhnZokuseiGanhsyngumu(C_UmuKbn.NONE).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_01);

        List<HT_MosSyouhn> mosSyouhns = syoriCTL1.getMosSyouhnsBySyouhnZokuseiGanhsyngumu(C_UmuKbn.ARI);

        Assert.assertEquals(1, mosSyouhns.size());

        Assert.assertEquals(P_MOSNO_01, mosSyouhns.get(0).getMosno());
        Assert.assertEquals(P_SYOUHNCD_01, mosSyouhns.get(0).getSyouhncd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_02);

        List<HT_MosSyouhn> mosSyouhns = syoriCTL1.getMosSyouhnsBySyouhnZokuseiGanhsyngumu(C_UmuKbn.ARI);

        Assert.assertEquals(3, mosSyouhns.size());

        Assert.assertEquals(P_MOSNO_02, mosSyouhns.get(0).getMosno());
        Assert.assertEquals(P_SYOUHNCD_01, mosSyouhns.get(0).getSyouhncd());

        Assert.assertEquals(P_MOSNO_02, mosSyouhns.get(1).getMosno());
        Assert.assertEquals(P_SYOUHNCD_02, mosSyouhns.get(1).getSyouhncd());

        Assert.assertEquals(P_MOSNO_02, mosSyouhns.get(2).getMosno());
        Assert.assertEquals(P_SYOUHNCD_03, mosSyouhns.get(2).getSyouhncd());
    }
}

