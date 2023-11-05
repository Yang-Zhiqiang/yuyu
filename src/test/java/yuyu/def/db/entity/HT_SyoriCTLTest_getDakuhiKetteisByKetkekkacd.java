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

import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 諾否決定テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getDakuhiKetteisByKetkekkacd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_1 = "791112220";
    static String P_MOSNO_2 = "791112238";
    static Integer P_DAKUHIKTRENNO_1 = new Integer(1);
    static Integer P_DAKUHIKTRENNO_2 = new Integer(2);
    static Integer P_DAKUHIKTRENNO_3 = new Integer(3);
    static Integer P_DAKUHIKTRENNO_4 = new Integer(4);
    static Integer P_DAKUHIKTRENNO_6 = new Integer(6);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_1);

        Assert.assertEquals(0,syoriCTL1.getDakuhiKetteisByKetkekkacd(C_Ketkekkacd.MUJYOUKEN).size());

        HT_DakuhiKettei hT_DakuhiKettei1 = syoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei1.setDakuhiktrenno(P_DAKUHIKTRENNO_1);
        hT_DakuhiKettei1.setKetkekkacd(C_Ketkekkacd.BLNK);

        HT_DakuhiKettei hT_DakuhiKettei2 = syoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei2.setDakuhiktrenno(P_DAKUHIKTRENNO_2);
        hT_DakuhiKettei2.setKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

        HT_DakuhiKettei hT_DakuhiKettei3 = syoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei3.setDakuhiktrenno(P_DAKUHIKTRENNO_3);
        hT_DakuhiKettei3.setKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

        HT_DakuhiKettei hT_DakuhiKettei4 = syoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei4.setDakuhiktrenno(P_DAKUHIKTRENNO_4);
        hT_DakuhiKettei4.setKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

        HT_DakuhiKettei hT_DakuhiKettei6 = syoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei6.setDakuhiktrenno(P_DAKUHIKTRENNO_6);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_2);

        HT_DakuhiKettei hT_DakuhiKettei5 = syoriCTL2.createDakuhiKettei();
        hT_DakuhiKettei5.setDakuhiktrenno(P_DAKUHIKTRENNO_1);
        hT_DakuhiKettei5.setKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_2);

        Assert.assertEquals(0, hT_SyoriCTL.getDakuhiKetteisByKetkekkacd(C_Ketkekkacd.MUJYOUKEN).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_MosDairiten = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);

        List<HT_DakuhiKettei> hT_DakuhiKetteiLst = hT_MosDairiten.getDakuhiKetteisByKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

        Assert.assertEquals(1, hT_DakuhiKetteiLst.size());
        Assert.assertEquals(P_MOSNO_1, hT_DakuhiKetteiLst.get(0).getMosno());
        Assert.assertEquals(C_Ketkekkacd.BLNK, hT_DakuhiKetteiLst.get(0).getKetkekkacd());
        Assert.assertEquals(P_DAKUHIKTRENNO_1, hT_DakuhiKetteiLst.get(0).getDakuhiktrenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_MosDairiten = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);

        List<HT_DakuhiKettei> hT_DakuhiKetteiLst = hT_MosDairiten.getDakuhiKetteisByKetkekkacd(C_Ketkekkacd.BLNK);

        Assert.assertEquals(3, hT_DakuhiKetteiLst.size());

        Assert.assertEquals(P_MOSNO_1, hT_DakuhiKetteiLst.get(0).getMosno());
        Assert.assertEquals(C_Ketkekkacd.MUJYOUKEN, hT_DakuhiKetteiLst.get(0).getKetkekkacd());
        Assert.assertEquals(P_DAKUHIKTRENNO_2, hT_DakuhiKetteiLst.get(0).getDakuhiktrenno());

        Assert.assertEquals(P_MOSNO_1, hT_DakuhiKetteiLst.get(1).getMosno());
        Assert.assertEquals(C_Ketkekkacd.MUJYOUKEN, hT_DakuhiKetteiLst.get(1).getKetkekkacd());
        Assert.assertEquals(P_DAKUHIKTRENNO_3, hT_DakuhiKetteiLst.get(1).getDakuhiktrenno());

        Assert.assertEquals(P_MOSNO_1, hT_DakuhiKetteiLst.get(2).getMosno());
        Assert.assertEquals(C_Ketkekkacd.MUJYOUKEN, hT_DakuhiKetteiLst.get(2).getKetkekkacd());
        Assert.assertEquals(P_DAKUHIKTRENNO_4, hT_DakuhiKetteiLst.get(2).getDakuhiktrenno());
    }
}