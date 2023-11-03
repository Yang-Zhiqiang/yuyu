package yuyu.def.sinkeiyaku.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ振分<br />
 * 申込基本テーブルエンティティをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLDetacherTest_detachMosKihontouched {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_01);

        hT_SyoriCTL.createMosKihon();

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
    public void testDetach1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_01);

        HT_SyoriCTL entity = HT_SyoriCTLDetacher.detachMosKihontouched(hT_SyoriCTL);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        HT_MosKihon hT_MosKihon = hT_SyoriCTL.getMosKihon();

        Assert.assertEquals(P_MOSNO_01, hT_MosKihon.getMosno());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        HT_SyoriCTL hT_SyoriCTL = null;

        Assert.assertNull(HT_SyoriCTLDetacher.detachMosKihontouched(hT_SyoriCTL));
    }
}
