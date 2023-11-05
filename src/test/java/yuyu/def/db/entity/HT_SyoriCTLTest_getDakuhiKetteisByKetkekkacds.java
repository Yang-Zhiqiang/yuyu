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
 * SMBC進捗管理データ編集<br />
 * 諾否決定テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getDakuhiKetteisByKetkekkacds {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_1 = "791112220";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL(P_MOSNO_1);

        Assert.assertEquals(0, syoriCTL.getDakuhiKetteisByKetkekkacds().size());

        HT_DakuhiKettei dakuhiKettei1 = syoriCTL.createDakuhiKettei();
        dakuhiKettei1.setDakuhiktrenno(1);
        dakuhiKettei1.setKetkekkacd(C_Ketkekkacd.HAND_KETTEI);

        sinkeiyakuDomManager.insert(syoriCTL);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager SinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        SinkeiyakuDomManager.delete(SinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);
        List<HT_DakuhiKettei> dakuhiketteiLst = syoriCTL.getDakuhiKetteisByKetkekkacds();

        Assert.assertEquals(0, dakuhiketteiLst.size());

        HT_DakuhiKettei dakuhiKettei2 = syoriCTL.createDakuhiKettei();
        dakuhiKettei2.setDakuhiktrenno(2);
        dakuhiKettei2.setKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

        sinkeiyakuDomManager.update(syoriCTL);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);
        List<HT_DakuhiKettei> dakuhiketteiLst = syoriCTL.getDakuhiKetteisByKetkekkacds();

        Assert.assertEquals(1, dakuhiketteiLst.size());

        Assert.assertEquals(2, dakuhiketteiLst.get(0).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.MUJYOUKEN, dakuhiketteiLst.get(0).getKetkekkacd());

        HT_DakuhiKettei dakuhiKettei3 = syoriCTL.createDakuhiKettei();
        dakuhiKettei3.setDakuhiktrenno(3);
        dakuhiKettei3.setKetkekkacd(C_Ketkekkacd.GENKAITAI_SYOUDAKU);

        HT_DakuhiKettei dakuhiKettei4 = syoriCTL.createDakuhiKettei();
        dakuhiKettei4.setDakuhiktrenno(4);
        dakuhiKettei4.setKetkekkacd(C_Ketkekkacd.ENKI_SIJINASI);

        HT_DakuhiKettei dakuhiKettei5 = syoriCTL.createDakuhiKettei();
        dakuhiKettei5.setDakuhiktrenno(5);
        dakuhiKettei5.setKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        HT_DakuhiKettei dakuhiKettei6 = syoriCTL.createDakuhiKettei();
        dakuhiKettei6.setDakuhiktrenno(6);
        dakuhiKettei6.setKetkekkacd(C_Ketkekkacd.MIAWASE);

        HT_DakuhiKettei dakuhiKettei7 = syoriCTL.createDakuhiKettei();
        dakuhiKettei7.setDakuhiktrenno(7);
        dakuhiKettei7.setKetkekkacd(C_Ketkekkacd.COOLINGOFF);

        HT_DakuhiKettei dakuhiKettei8 = syoriCTL.createDakuhiKettei();
        dakuhiKettei8.setDakuhiktrenno(8);
        dakuhiKettei8.setKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);

        HT_DakuhiKettei dakuhiKettei9 = syoriCTL.createDakuhiKettei();
        dakuhiKettei9.setDakuhiktrenno(9);
        dakuhiKettei9.setKetkekkacd(C_Ketkekkacd.YUUKOUKKNKKA);

        sinkeiyakuDomManager.update(syoriCTL);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);
        List<HT_DakuhiKettei> dakuhiketteiLst = syoriCTL.getDakuhiKetteisByKetkekkacds();

        Assert.assertEquals(8, dakuhiketteiLst.size());

        Assert.assertEquals(2, dakuhiketteiLst.get(0).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.MUJYOUKEN, dakuhiketteiLst.get(0).getKetkekkacd());

        Assert.assertEquals(3, dakuhiketteiLst.get(1).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.GENKAITAI_SYOUDAKU, dakuhiketteiLst.get(1).getKetkekkacd());

        Assert.assertEquals(4, dakuhiketteiLst.get(2).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.ENKI_SIJINASI, dakuhiketteiLst.get(2).getKetkekkacd());

        Assert.assertEquals(5, dakuhiketteiLst.get(3).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.ENKI_SUUNENGOSAISIN, dakuhiketteiLst.get(3).getKetkekkacd());

        Assert.assertEquals(6, dakuhiketteiLst.get(4).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.MIAWASE, dakuhiketteiLst.get(4).getKetkekkacd());

        Assert.assertEquals(7, dakuhiketteiLst.get(5).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.COOLINGOFF, dakuhiketteiLst.get(5).getKetkekkacd());

        Assert.assertEquals(8, dakuhiketteiLst.get(6).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.MOS_TORIKESI, dakuhiketteiLst.get(6).getKetkekkacd());

        Assert.assertEquals(9, dakuhiketteiLst.get(7).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_Ketkekkacd.YUUKOUKKNKKA, dakuhiketteiLst.get(7).getKetkekkacd());
    }
}
