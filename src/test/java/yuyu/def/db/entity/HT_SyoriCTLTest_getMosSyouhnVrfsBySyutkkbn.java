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

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルエンティティから、<br />
 * 主契約特約区分を指定して、<br />
 * 申込商品ベリファイテーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getMosSyouhnVrfsBySyutkkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_001 = "791112220";
    static String P_SYOUHNCD_001 = "SH01";
    static String P_SYOUHNCD_002 = "SH02";
    static String P_SYOUHNCD_003 = "SH03";
    static String P_SYOUHNCD_004 = "SH04";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL =  new HT_SyoriCTL(P_MOSNO_001);

        HT_MosSyouhnVrf hT_MosSyouhnVrf_01 = hT_SyoriCTL.createMosSyouhnVrf();
        hT_MosSyouhnVrf_01.setSyouhncd(P_SYOUHNCD_001);
        hT_MosSyouhnVrf_01.setSyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhnVrf hT_MosSyouhnVrf_02 = hT_SyoriCTL.createMosSyouhnVrf();
        hT_MosSyouhnVrf_02.setSyouhncd(P_SYOUHNCD_002);
        hT_MosSyouhnVrf_02.setSyutkkbn(C_SyutkKbn.TK);

        HT_MosSyouhnVrf hT_MosSyouhnVrf_03 = hT_SyoriCTL.createMosSyouhnVrf();
        hT_MosSyouhnVrf_03.setSyouhncd(P_SYOUHNCD_003);
        hT_MosSyouhnVrf_03.setSyutkkbn(C_SyutkKbn.TK);

        HT_MosSyouhnVrf hT_MosSyouhnVrf_04 = hT_SyoriCTL.createMosSyouhnVrf();
        hT_MosSyouhnVrf_04.setSyouhncd(P_SYOUHNCD_004);
        hT_MosSyouhnVrf_04.setSyutkkbn(C_SyutkKbn.TK);

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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs = hT_SyoriCTL.getMosSyouhnVrfsBySyutkkbn(C_SyutkKbn.NONE);

        Assert.assertEquals(0, hT_MosSyouhnVrfs.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs = hT_SyoriCTL.getMosSyouhnVrfsBySyutkkbn(C_SyutkKbn.SYU);

        Assert.assertEquals(1, hT_MosSyouhnVrfs.size());

        HT_MosSyouhnVrf hT_MosSyouhnVrf = hT_MosSyouhnVrfs.get(0);

        Assert.assertEquals(P_MOSNO_001, hT_MosSyouhnVrf.getMosno());
        Assert.assertEquals(P_SYOUHNCD_001, hT_MosSyouhnVrf.getSyouhncd());
        Assert.assertEquals(C_SyutkKbn.SYU, hT_MosSyouhnVrf.getSyutkkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs = hT_SyoriCTL.getMosSyouhnVrfsBySyutkkbn(C_SyutkKbn.TK);

        Assert.assertEquals(3, hT_MosSyouhnVrfs.size());

        HT_MosSyouhnVrf hT_MosSyouhnVrf_001 = hT_MosSyouhnVrfs.get(0);

        Assert.assertEquals(P_MOSNO_001, hT_MosSyouhnVrf_001.getMosno());
        Assert.assertEquals(P_SYOUHNCD_002, hT_MosSyouhnVrf_001.getSyouhncd());
        Assert.assertEquals(C_SyutkKbn.TK, hT_MosSyouhnVrf_001.getSyutkkbn());

        HT_MosSyouhnVrf hT_MosSyouhnVrf_002 = hT_MosSyouhnVrfs.get(1);

        Assert.assertEquals(P_MOSNO_001, hT_MosSyouhnVrf_002.getMosno());
        Assert.assertEquals(P_SYOUHNCD_003, hT_MosSyouhnVrf_002.getSyouhncd());
        Assert.assertEquals(C_SyutkKbn.TK, hT_MosSyouhnVrf_002.getSyutkkbn());

        HT_MosSyouhnVrf hT_MosSyouhnVrf_003 = hT_MosSyouhnVrfs.get(2);

        Assert.assertEquals(P_MOSNO_001, hT_MosSyouhnVrf_003.getMosno());
        Assert.assertEquals(P_SYOUHNCD_004, hT_MosSyouhnVrf_003.getSyouhncd());
        Assert.assertEquals(C_SyutkKbn.TK, hT_MosSyouhnVrf_003.getSyutkkbn());
    }
}
