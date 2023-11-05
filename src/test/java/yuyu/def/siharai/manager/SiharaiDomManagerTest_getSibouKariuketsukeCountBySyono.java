package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 死亡仮受付テーブルエンティティ件数取得（証券番号）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSibouKariuketsukeCountBySyono {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "001";
    static String P_SKNO_02 = "002";
    static String P_SKNO_03 = "003";
    static String P_SKNO_04 = "004";
    static String P_SKNO_05 = "005";
    static String P_SKNO_06 = "006";
    static String P_SKNO_07 = "007";
    static String P_SYONO_01 = "99806001021";
    static String P_SYONO_02 = "99806001032";
    static String P_SYONO_03 = "99806001043";
    static String P_SYONO_04 = "99806001043";
    static String P_SYONO_05 = "99806001054";
    static String P_SYONO_06 = "99806001054";
    static String P_SYONO_07 = "99806001054";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        Long count = siharaiDomManager.getSibouKariuketsukeCountBySyono("99806001010");
        Assert.assertEquals(new Long(0), count);


        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_SibouKariuketsuke jT_SibouKariuketsuke1 = jT_SkKihon1.createSibouKariuketsuke();
        jT_SibouKariuketsuke1.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon1);

        JT_SkKihon jT_SkKihon2 = new JT_SkKihon(P_SKNO_02, P_SYONO_02);

        JT_SibouKariuketsuke jT_SibouKariuketsuke2 = jT_SkKihon2.createSibouKariuketsuke();
        jT_SibouKariuketsuke2.setTorikesiflg(C_UmuKbn.ARI);
        siharaiDomManager.insert(jT_SkKihon2);

        JT_SkKihon jT_SkKihon3 = new JT_SkKihon(P_SKNO_03, P_SYONO_03);

        JT_SibouKariuketsuke jT_SibouKariuketsuke3 = jT_SkKihon3.createSibouKariuketsuke();
        jT_SibouKariuketsuke3.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon3);

        JT_SkKihon jT_SkKihon4 = new JT_SkKihon(P_SKNO_04, P_SYONO_04);

        JT_SibouKariuketsuke jT_SibouKariuketsuke4 = jT_SkKihon4.createSibouKariuketsuke();
        jT_SibouKariuketsuke4.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon4);

        JT_SkKihon jT_SkKihon5 = new JT_SkKihon(P_SKNO_05, P_SYONO_05);

        JT_SibouKariuketsuke jT_SibouKariuketsuke5 = jT_SkKihon5.createSibouKariuketsuke();
        jT_SibouKariuketsuke5.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon5);

        JT_SkKihon jT_SkKihon6 = new JT_SkKihon(P_SKNO_06, P_SYONO_06);

        JT_SibouKariuketsuke jT_SibouKariuketsuke6 = jT_SkKihon6.createSibouKariuketsuke();
        jT_SibouKariuketsuke6.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon6);

        JT_SkKihon jT_SkKihon7 = new JT_SkKihon(P_SKNO_07, P_SYONO_07);

        JT_SibouKariuketsuke jT_SibouKariuketsuke7 = jT_SkKihon7.createSibouKariuketsuke();
        jT_SibouKariuketsuke7.setTorikesiflg(C_UmuKbn.ARI);
        siharaiDomManager.insert(jT_SkKihon7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Long count = siharaiDomManager.getSibouKariuketsukeCountBySyono("99806001010");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = siharaiDomManager.getSibouKariuketsukeCountBySyono("99806001021");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long count = siharaiDomManager.getSibouKariuketsukeCountBySyono("99806001032");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(40)
    public void normal3() {

        Long count = siharaiDomManager.getSibouKariuketsukeCountBySyono("99806001043");
        Assert.assertEquals(new Long(2), count);

    }


    @Test
    @TestOrder(50)
    public void normal4() {

        Long count = siharaiDomManager.getSibouKariuketsukeCountBySyono("99806001054");
        Assert.assertEquals(new Long(2), count);

    }

    @Test
    @TestOrder(60)
    public void blankCondition1() {

        Long count = siharaiDomManager.getSibouKariuketsukeCountBySyono("");
        Assert.assertEquals(new Long(0), count);

    }
}
