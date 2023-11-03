package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込代理店ベリファイテーブルエンティティから、<br />
 * 連番を指定して、<br />
 * 申込代理店ベリファイテーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getMosDairitenVrfByRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_001 = "791112220";
    static Integer P_RENNO_1 = new Integer(1);
    static Integer P_RENNO_2 = new Integer(2);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_001);

        HT_MosDairitenVrf hT_MosDairitenVrf = hT_SyoriCTL.createMosDairitenVrf();
        hT_MosDairitenVrf.setRenno(P_RENNO_1);

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

        HT_MosDairitenVrf hT_MosDairitenVrf =
                hT_SyoriCTL.getMosDairitenVrfByRenno(P_RENNO_2);

        Assert.assertEquals(null, hT_MosDairitenVrf);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        HT_MosDairitenVrf hT_MosDairitenVrf =
                hT_SyoriCTL.getMosDairitenVrfByRenno(P_RENNO_1);

        Assert.assertEquals(P_MOSNO_001, hT_MosDairitenVrf.getMosno());
        Assert.assertEquals(P_RENNO_1, hT_MosDairitenVrf.getRenno());
    }
}
