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

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 本社統計情報作成<br />
 * 申込点検履歴テーブルの最小処理年月日取得　申込番号かつ申込点検結果区分固定値のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        BizDate syoriYmd = sinkeiyakuDomManager.getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(P_MOSNO_01);

        Assert.assertNull(syoriYmd);

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);

        HT_MostenkenRireki hT_MostenkenRireki11 = hT_SyoriCTL1.createMostenkenRireki();
        hT_MostenkenRireki11.setRenno(new Integer(11));
        hT_MostenkenRireki11.setSyoriYmd(BizDate.valueOf(20160303));
        hT_MostenkenRireki11.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        HT_MostenkenRireki hT_MostenkenRireki12 = hT_SyoriCTL1.createMostenkenRireki();
        hT_MostenkenRireki12.setRenno(new Integer(12));
        hT_MostenkenRireki12.setSyoriYmd(BizDate.valueOf(20160304));
        hT_MostenkenRireki12.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        HT_MostenkenRireki hT_MostenkenRireki13 = hT_SyoriCTL1.createMostenkenRireki();
        hT_MostenkenRireki13.setRenno(new Integer(13));
        hT_MostenkenRireki13.setSyoriYmd(BizDate.valueOf(20160305));
        hT_MostenkenRireki13.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        HT_MostenkenRireki hT_MostenkenRireki14 = hT_SyoriCTL1.createMostenkenRireki();
        hT_MostenkenRireki14.setRenno(new Integer(14));
        hT_MostenkenRireki14.setSyoriYmd(BizDate.valueOf(20160302));
        hT_MostenkenRireki14.setMostenkenkekkakbn(C_SyorikekkaKbn.HORYUU);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_MostenkenRireki hT_MostenkenRireki21 = hT_SyoriCTL2.createMostenkenRireki();
        hT_MostenkenRireki21.setRenno(new Integer(11));
        hT_MostenkenRireki21.setSyoriYmd(BizDate.valueOf(20160301));
        hT_MostenkenRireki21.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        BizDate syoriYmd = sinkeiyakuDomManager.getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(P_MOSNO_03);

        Assert.assertNull(syoriYmd);
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        BizDate syoriYmd = sinkeiyakuDomManager.getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(P_MOSNO_01);

        Assert.assertEquals(BizDate.valueOf(20160303), syoriYmd);
    }

    @Test
    @TestOrder(30)
    public void BlankCondition1(){

        BizDate syoriYmd = sinkeiyakuDomManager.getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn("");

        Assert.assertNull(syoriYmd);
    }
}
