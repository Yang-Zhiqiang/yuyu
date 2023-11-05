package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.result.bean.SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 死亡仮受付情報作成<br />
 * 死亡仮受付情報Beanリスト(大量)取得(対象期間（自）、対象期間（至）)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SK111";
    static String P_SKNO_02 = "SK222";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111141";
    static String P_SYONO_05 = "11807111152";
    static String P_SYONO_06 = "11807111163";
    static String P_SYONO_07 = "11807111174";
    static BizDate P_TAISYOUKKNFROM_01 = BizDate.valueOf(20160303);
    static BizDate P_TAISYOUKKNFROM_02 = BizDate.valueOf(20160306);
    static BizDate P_TAISYOUKKNFROM_03 = BizDate.valueOf(20160313);
    static BizDate P_TAISYOUKKNTO_01 = BizDate.valueOf(20160303);
    static BizDate P_TAISYOUKKNTO_02 = BizDate.valueOf(20160309);
    static BizDate P_TAISYOUKKNTO_03 = BizDate.valueOf(20160313);
    static BizDate P_SIBOUKARITRKYMD_01 = BizDate.valueOf(20160303);
    static BizDate P_SIBOUKARITRKYMD_02 = BizDate.valueOf(20160306);
    static BizDate P_SIBOUKARITRKYMD_03 = BizDate.valueOf(20160307);
    static BizDate P_SIBOUKARITRKYMD_04 = BizDate.valueOf(20160308);
    static BizDate P_SIBOUKARITRKYMD_05 = BizDate.valueOf(20160302);
    static BizDate P_SIBOUKARITRKYMD_06 = BizDate.valueOf(20160304);
    static BizDate P_SIBOUKARITRKYMD_07 = BizDate.valueOf(20160309);
    static BizDate P_SIBOUKARITRKYMD_08 = BizDate.valueOf(20160305);
    static BizDate P_SIBOUKARITRKYMD_09 = BizDate.valueOf(20160310);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> exDBRsBeans =
            siharaiDomManager.getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(P_TAISYOUKKNFROM_01, P_TAISYOUKKNTO_01)) {

            Assert.assertFalse(exDBRsBeans.iterator().hasNext());
        }

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);
        jT_SkKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon1.setSiboukaritrkymd(P_SIBOUKARITRKYMD_01);

        JT_SibouKariuketsuke jT_SibouKariuketsuke1 = jT_SkKihon1.createSibouKariuketsuke();
        jT_SibouKariuketsuke1.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon1);

        JT_SkKihon jT_SkKihon2 = new JT_SkKihon(P_SKNO_02, P_SYONO_03);
        jT_SkKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon2.setSiboukaritrkymd(P_SIBOUKARITRKYMD_07);

        JT_SibouKariuketsuke jT_SibouKariuketsuke2 = jT_SkKihon2.createSibouKariuketsuke();
        jT_SibouKariuketsuke2.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon2);

        JT_SkKihon jT_SkKihon3 = new JT_SkKihon(P_SKNO_02, P_SYONO_01);
        jT_SkKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon3.setSiboukaritrkymd(P_SIBOUKARITRKYMD_04);

        JT_SibouKariuketsuke jT_SibouKariuketsuke3 = jT_SkKihon3.createSibouKariuketsuke();
        jT_SibouKariuketsuke3.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon3);

        JT_SkKihon jT_SkKihon4 = new JT_SkKihon(P_SKNO_01, P_SYONO_03);
        jT_SkKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon4.setSiboukaritrkymd(P_SIBOUKARITRKYMD_03);

        JT_SibouKariuketsuke jT_SibouKariuketsuke4 = jT_SkKihon4.createSibouKariuketsuke();
        jT_SibouKariuketsuke4.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon4);

        JT_SkKihon jT_SkKihon5 = new JT_SkKihon(P_SKNO_01, P_SYONO_02);
        jT_SkKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon5.setSiboukaritrkymd(P_SIBOUKARITRKYMD_02);

        JT_SibouKariuketsuke jT_SibouKariuketsuke5 = jT_SkKihon5.createSibouKariuketsuke();
        jT_SibouKariuketsuke5.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon5);

        JT_SkKihon jT_SkKihon6 = new JT_SkKihon(P_SKNO_01, P_SYONO_04);
        jT_SkKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        jT_SkKihon6.setSiboukaritrkymd(P_SIBOUKARITRKYMD_01);

        JT_SibouKariuketsuke jT_SibouKariuketsuke6 = jT_SkKihon6.createSibouKariuketsuke();
        jT_SibouKariuketsuke6.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon6);

        JT_SkKihon jT_SkKihon7 = new JT_SkKihon(P_SKNO_01, P_SYONO_05);
        jT_SkKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon7.setSiboukaritrkymd(P_SIBOUKARITRKYMD_08);

        JT_SibouKariuketsuke jT_SibouKariuketsuke7 = jT_SkKihon7.createSibouKariuketsuke();
        jT_SibouKariuketsuke7.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon7);

        JT_SkKihon jT_SkKihon8 = new JT_SkKihon(P_SKNO_01, P_SYONO_06);
        jT_SkKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon8.setSiboukaritrkymd(P_SIBOUKARITRKYMD_09);

        JT_SibouKariuketsuke jT_SibouKariuketsuke8 = jT_SkKihon8.createSibouKariuketsuke();
        jT_SibouKariuketsuke8.setTorikesiflg(C_UmuKbn.NONE);
        siharaiDomManager.insert(jT_SkKihon8);

        JT_SkKihon jT_SkKihon9 = new JT_SkKihon(P_SKNO_01, P_SYONO_07);
        jT_SkKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon9.setSiboukaritrkymd(P_SIBOUKARITRKYMD_01);

        JT_SibouKariuketsuke jT_SibouKariuketsuke9 = jT_SkKihon9.createSibouKariuketsuke();
        jT_SibouKariuketsuke9.setTorikesiflg(C_UmuKbn.ARI);
        siharaiDomManager.insert(jT_SkKihon9);

        JT_SkKihon jT_SkKihon10 = new JT_SkKihon(P_SKNO_02, P_SYONO_02);
        jT_SkKihon10.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
        jT_SkKihon10.setSiboukaritrkymd(P_SIBOUKARITRKYMD_03);
        siharaiDomManager.insert(jT_SkKihon10);
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

        try (ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> exDBRsBeans =
            siharaiDomManager.getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(P_TAISYOUKKNFROM_03, P_TAISYOUKKNTO_03)) {

            Assert.assertFalse(exDBRsBeans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> exDBRsBeans =
            siharaiDomManager.getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(P_TAISYOUKKNFROM_01, P_TAISYOUKKNTO_01)) {

            int iCount = 0;
            Iterator<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> iter = exDBRsBeans.iterator();
            SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                Assert.assertEquals(P_SKNO_01, bean.getJT_SkKihon().getSkno());
                Assert.assertEquals(P_SYONO_01, bean.getJT_SkKihon().getSyono());
                Assert.assertEquals(P_SIBOUKARITRKYMD_01, bean.getJT_SkKihon().getSiboukaritrkymd());
                Assert.assertEquals(P_SKNO_01, bean.getJT_SibouKariuketsuke().getSkno());
                Assert.assertEquals(P_SYONO_01, bean.getJT_SibouKariuketsuke().getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($(P_SKNO_02,P_SYONO_03,P_SIBOUKARITRKYMD_07,P_SKNO_02,P_SYONO_03),"1");
        map.put($(P_SKNO_01,P_SYONO_03,P_SIBOUKARITRKYMD_03,P_SKNO_01,P_SYONO_03),"1");

        try (ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> exDBRsBeans =
            siharaiDomManager.getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(P_TAISYOUKKNFROM_02, P_TAISYOUKKNTO_02)) {

            int iCount = 0;
            Iterator<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> iter = exDBRsBeans.iterator();
            SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_SKNO_02, bean.getJT_SkKihon().getSkno());
                    Assert.assertEquals(P_SYONO_01, bean.getJT_SkKihon().getSyono());
                    Assert.assertEquals(P_SIBOUKARITRKYMD_04, bean.getJT_SkKihon().getSiboukaritrkymd());
                    Assert.assertEquals(P_SKNO_02, bean.getJT_SibouKariuketsuke().getSkno());
                    Assert.assertEquals(P_SYONO_01, bean.getJT_SibouKariuketsuke().getSyono());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SKNO_01, bean.getJT_SkKihon().getSkno());
                    Assert.assertEquals(P_SYONO_02, bean.getJT_SkKihon().getSyono());
                    Assert.assertEquals(P_SIBOUKARITRKYMD_02, bean.getJT_SkKihon().getSiboukaritrkymd());
                    Assert.assertEquals(P_SKNO_01, bean.getJT_SibouKariuketsuke().getSkno());
                    Assert.assertEquals(P_SYONO_02, bean.getJT_SibouKariuketsuke().getSyono());

                    continue;
                }

                if (3 == iCount) {

                    assertTrue(map.containsKey($(bean.getJT_SkKihon().getSkno(), bean.getJT_SkKihon().getSyono(), bean.getJT_SkKihon().getSiboukaritrkymd(), bean.getJT_SibouKariuketsuke().getSkno(), bean.getJT_SibouKariuketsuke().getSyono())));

                    continue;
                }

                if (4 == iCount) {

                    assertTrue(map.containsKey($(bean.getJT_SkKihon().getSkno(), bean.getJT_SkKihon().getSyono(), bean.getJT_SkKihon().getSiboukaritrkymd(), bean.getJT_SibouKariuketsuke().getSkno(), bean.getJT_SibouKariuketsuke().getSyono())));

                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
        }
    }
}
