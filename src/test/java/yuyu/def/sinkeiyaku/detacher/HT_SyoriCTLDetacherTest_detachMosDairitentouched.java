package yuyu.def.sinkeiyaku.detacher;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 新契約決算ベース月次成立情報作成<br />
 * 申込代理店テーブルエンティティリストをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLDetacherTest_detachMosDairitentouched {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static Integer P_RENNO_01 = new Integer(0);
    static Integer P_RENNO_02 = new Integer(1);
    static Integer P_RENNO_03 = new Integer(2);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager .class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_01);

        HT_MosDairiten hT_MosDairiten1 = hT_SyoriCTL.createMosDairiten();
        hT_MosDairiten1.setMosno(P_MOSNO_01);
        hT_MosDairiten1.setRenno(P_RENNO_01);

        HT_MosDairiten hT_MosDairiten2 = hT_SyoriCTL.createMosDairiten();
        hT_MosDairiten2.setMosno(P_MOSNO_01);
        hT_MosDairiten2.setRenno(P_RENNO_02);

        HT_MosDairiten hT_MosDairiten3 = hT_SyoriCTL.createMosDairiten();
        hT_MosDairiten3.setMosno(P_MOSNO_01);
        hT_MosDairiten3.setRenno(P_RENNO_03);

        sinkeiyakuDomManager.insert(hT_SyoriCTL);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager .class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        HT_SyoriCTL entity = HT_SyoriCTLDetacher.detachMosDairitentouched(hT_SyoriCTL);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<HT_MosDairiten> mosDairitenLst = entity.getMosDairitens();

        Assert.assertEquals(3, mosDairitenLst.size());

        HT_MosDairiten hT_MosDairiten1 = mosDairitenLst.get(0);
        Assert.assertEquals(P_MOSNO_01, hT_MosDairiten1.getMosno());
        Assert.assertEquals(P_RENNO_01, hT_MosDairiten1.getRenno());

        HT_MosDairiten hT_MosDairiten2 = mosDairitenLst.get(1);
        Assert.assertEquals(P_MOSNO_01, hT_MosDairiten2.getMosno());
        Assert.assertEquals(P_RENNO_02, hT_MosDairiten2.getRenno());

        HT_MosDairiten hT_MosDairiten3 = mosDairitenLst.get(2);
        Assert.assertEquals(P_MOSNO_01, hT_MosDairiten3.getMosno());
        Assert.assertEquals(P_RENNO_03, hT_MosDairiten3.getRenno());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        HT_SyoriCTL hT_SyoriCTL = null;

        Assert.assertNull(HT_SyoriCTLDetacher.detachMosDairitentouched(hT_SyoriCTL));
    }
}
