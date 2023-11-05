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

import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 新契約決算ベース月次成立情報作成<br />
 * 申込商品テーブルエンティティリストをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLDetacherTest_detachMosSyouhntouched {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_SYOUHNCD_01 = "SH01";
    static String P_SYOUHNCD_02 = "SH02";
    static String P_SYOUHNCD_03 = "SH03";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_01);

        HT_MosSyouhn hT_MosSyouhn1 = hT_SyoriCTL.createMosSyouhn();
        hT_MosSyouhn1.setMosno(P_MOSNO_01);
        hT_MosSyouhn1.setSyouhncd(P_SYOUHNCD_01);

        HT_MosSyouhn hT_MosSyouhn2 = hT_SyoriCTL.createMosSyouhn();
        hT_MosSyouhn2.setMosno(P_MOSNO_01);
        hT_MosSyouhn2.setSyouhncd(P_SYOUHNCD_02);

        HT_MosSyouhn hT_MosSyouhn3 = hT_SyoriCTL.createMosSyouhn();
        hT_MosSyouhn3.setMosno(P_MOSNO_01);
        hT_MosSyouhn3.setSyouhncd(P_SYOUHNCD_03);

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

        HT_SyoriCTL entity = HT_SyoriCTLDetacher.detachMosSyouhntouched(hT_SyoriCTL);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<HT_MosSyouhn> mosSyouhnLst = entity.getMosSyouhns();

        Assert.assertEquals(3, mosSyouhnLst.size());

        HT_MosSyouhn hT_MosSyouhn1 = mosSyouhnLst.get(0);
        Assert.assertEquals(P_MOSNO_01, hT_MosSyouhn1.getMosno());
        Assert.assertEquals(P_SYOUHNCD_01, hT_MosSyouhn1.getSyouhncd());

        HT_MosSyouhn hT_MosSyouhn2 = mosSyouhnLst.get(1);
        Assert.assertEquals(P_MOSNO_01, hT_MosSyouhn2.getMosno());
        Assert.assertEquals(P_SYOUHNCD_02, hT_MosSyouhn2.getSyouhncd());

        HT_MosSyouhn hT_MosSyouhn3 = mosSyouhnLst.get(2);
        Assert.assertEquals(P_MOSNO_01, hT_MosSyouhn3.getMosno());
        Assert.assertEquals(P_SYOUHNCD_03, hT_MosSyouhn3.getSyouhncd());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        HT_SyoriCTL hT_SyoriCTL = null;

        Assert.assertNull(HT_SyoriCTLDetacher.detachMosSyouhntouched(hT_SyoriCTL));
    }
}
