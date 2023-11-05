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

import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HT_SyoriCTLDetacherクラスの、<br />
 * detachMosKihonMosDairitenNyuukinHenkintouched() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLDetacherTest_detachMosKihonMosDairitenNyuukinHenkintouched {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager .class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(01);

        HT_MosDairiten mosDairiten2 = syoriCTL1.createMosDairiten();
        mosDairiten2.setRenno(02);

        HT_MosDairiten mosDairiten3 = syoriCTL1.createMosDairiten();
        mosDairiten3.setRenno(03);

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(01);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(02);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(03);

        HT_Henkin henkin1 = syoriCTL1.createHenkin();
        henkin1.setRenno(01);

        HT_Henkin henkin2 = syoriCTL1.createHenkin();
        henkin2.setRenno(02);

        HT_Henkin henkin3 = syoriCTL1.createHenkin();
        henkin3.setRenno(03);

        sinkeiyakuDomManager.insert(syoriCTL1);

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

        HT_SyoriCTL entity = HT_SyoriCTLDetacher.detachMosKihonMosDairitenNyuukinHenkintouched(hT_SyoriCTL);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        HT_MosKihon hT_MosKihon = entity.getMosKihon();
        Assert.assertEquals("791112220", hT_MosKihon.getMosno());

        List<HT_MosDairiten> hT_MosDairitenLst = entity.getMosDairitens();

        Assert.assertEquals(3, hT_MosDairitenLst.size());

        HT_MosDairiten hT_MosDairiten1 = hT_MosDairitenLst.get(0);
        Assert.assertEquals("791112220", hT_MosDairiten1.getMosno());
        Assert.assertEquals(01, hT_MosDairiten1.getRenno().intValue());

        HT_MosDairiten hT_MosDairiten2 = hT_MosDairitenLst.get(1);
        Assert.assertEquals("791112220", hT_MosDairiten2.getMosno());
        Assert.assertEquals(02, hT_MosDairiten2.getRenno().intValue());

        HT_MosDairiten hT_MosDairiten3 = hT_MosDairitenLst.get(2);
        Assert.assertEquals("791112220", hT_MosDairiten3.getMosno());
        Assert.assertEquals(03, hT_MosDairiten3.getRenno().intValue());

        List<HT_Nyuukin> hT_NyuukinLst = entity.getNyuukins();

        Assert.assertEquals(3, hT_NyuukinLst.size());

        HT_Nyuukin hT_Nyuukin1 = hT_NyuukinLst.get(0);
        Assert.assertEquals("791112220", hT_Nyuukin1.getMosno());
        Assert.assertEquals(01, hT_Nyuukin1.getRenno().intValue());

        HT_Nyuukin hT_Nyuukin2 = hT_NyuukinLst.get(1);
        Assert.assertEquals("791112220", hT_Nyuukin2.getMosno());
        Assert.assertEquals(02, hT_Nyuukin2.getRenno().intValue());

        HT_Nyuukin hT_Nyuukin3 = hT_NyuukinLst.get(2);
        Assert.assertEquals("791112220", hT_Nyuukin3.getMosno());
        Assert.assertEquals(03, hT_Nyuukin3.getRenno().intValue());

        List<HT_Henkin> hT_HenkinLst = entity.getHenkins();

        Assert.assertEquals(3, hT_HenkinLst.size());

        HT_Henkin hT_Henkin1 = hT_HenkinLst.get(0);
        Assert.assertEquals("791112220", hT_Henkin1.getMosno());
        Assert.assertEquals(01, hT_Henkin1.getRenno().intValue());

        HT_Henkin hT_Henkin2 = hT_HenkinLst.get(1);
        Assert.assertEquals("791112220", hT_Henkin2.getMosno());
        Assert.assertEquals(02, hT_Henkin2.getRenno().intValue());

        HT_Henkin hT_Henkin3 = hT_HenkinLst.get(2);
        Assert.assertEquals("791112220", hT_Henkin3.getMosno());
        Assert.assertEquals(03, hT_Henkin3.getRenno().intValue());

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        HT_SyoriCTL hT_SyoriCTL = null;

        Assert.assertNull(HT_SyoriCTLDetacher.detachMosKihonMosDairitenNyuukinHenkintouched(hT_SyoriCTL));
    }
}

