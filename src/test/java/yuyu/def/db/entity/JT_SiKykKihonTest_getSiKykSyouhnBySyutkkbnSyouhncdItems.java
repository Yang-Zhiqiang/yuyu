package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 支払契約商品テーブルエンティティ取得　主キー範囲指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SiKykKihonTest_getSiKykSyouhnBySyutkkbnSyouhncdItems {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYOUHNCD_01 = "SH01";
    static Integer P_SYOUHNSDNO_1 = new Integer(10);
    static Integer P_KYKSYOUHNRENNO_1 = new Integer(1);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiKykKihon jT_SiKykKihon = new JT_SiKykKihon(P_SYONO_01);

        Assert.assertEquals(null, jT_SiKykKihon.getSiKykSyouhnBySyutkkbnSyouhncdItems(C_SyutkKbn.SYU, P_SYOUHNCD_01,
                C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_1, P_KYKSYOUHNRENNO_1));

        JT_SiKykSyouhn jT_SiKykSyouhn1 = jT_SiKykKihon.createSiKykSyouhn();
        jT_SiKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiKykSyouhn1.setSyouhncd(P_SYOUHNCD_01);
        jT_SiKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiKykSyouhn1.setSyouhnsdno(P_SYOUHNSDNO_1);
        jT_SiKykSyouhn1.setKyksyouhnrenno(P_KYKSYOUHNRENNO_1);

        JT_SiKykSyouhn jT_SiKykSyouhn2 = jT_SiKykKihon.createSiKykSyouhn();
        jT_SiKykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        jT_SiKykSyouhn2.setSyouhncd(P_SYOUHNCD_01);
        jT_SiKykSyouhn2.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiKykSyouhn2.setSyouhnsdno(P_SYOUHNSDNO_1);
        jT_SiKykSyouhn2.setKyksyouhnrenno(P_KYKSYOUHNRENNO_1);

        JT_SiKykSyouhn jT_SiKykSyouhn3 = jT_SiKykKihon.createSiKykSyouhn();
        jT_SiKykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiKykSyouhn3.setSyouhncd("SH02");
        jT_SiKykSyouhn3.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiKykSyouhn3.setSyouhnsdno(P_SYOUHNSDNO_1);
        jT_SiKykSyouhn3.setKyksyouhnrenno(P_KYKSYOUHNRENNO_1);

        JT_SiKykSyouhn jT_SiKykSyouhn4 = jT_SiKykKihon.createSiKykSyouhn();
        jT_SiKykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiKykSyouhn4.setSyouhncd(P_SYOUHNCD_01);
        jT_SiKykSyouhn4.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE120);
        jT_SiKykSyouhn4.setSyouhnsdno(P_SYOUHNSDNO_1);
        jT_SiKykSyouhn4.setKyksyouhnrenno(P_KYKSYOUHNRENNO_1);

        JT_SiKykSyouhn jT_SiKykSyouhn5 = jT_SiKykKihon.createSiKykSyouhn();
        jT_SiKykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiKykSyouhn5.setSyouhncd(P_SYOUHNCD_01);
        jT_SiKykSyouhn5.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiKykSyouhn5.setSyouhnsdno(11);
        jT_SiKykSyouhn5.setKyksyouhnrenno(P_KYKSYOUHNRENNO_1);

        JT_SiKykSyouhn jT_SiKykSyouhn6 = jT_SiKykKihon.createSiKykSyouhn();
        jT_SiKykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiKykSyouhn6.setSyouhncd(P_SYOUHNCD_01);
        jT_SiKykSyouhn6.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiKykSyouhn6.setSyouhnsdno(P_SYOUHNSDNO_1);
        jT_SiKykSyouhn6.setKyksyouhnrenno(2);


        siharaiDomManager.insert(jT_SiKykKihon);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        JT_SiKykKihon jT_SiKykKihon = siharaiDomManager.getSiKykKihon(P_SYONO_01);

        JT_SiKykSyouhn jT_SiKykSyouhn = jT_SiKykKihon.getSiKykSyouhnBySyutkkbnSyouhncdItems(C_SyutkKbn.NONE, P_SYOUHNCD_01,
                C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_1, P_KYKSYOUHNRENNO_1);

        Assert.assertEquals(null, jT_SiKykSyouhn);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SiKykKihon jT_SiKykKihon = siharaiDomManager.getSiKykKihon(P_SYONO_01);

        JT_SiKykSyouhn jT_SiKykSyouhn = jT_SiKykKihon.getSiKykSyouhnBySyutkkbnSyouhncdItems(C_SyutkKbn.SYU, P_SYOUHNCD_01,
                C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_1, P_KYKSYOUHNRENNO_1);

        Assert.assertEquals(P_SYONO_01, jT_SiKykSyouhn.getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, jT_SiKykSyouhn.getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_01, jT_SiKykSyouhn.getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, jT_SiKykSyouhn.getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO_1, jT_SiKykSyouhn.getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_1, jT_SiKykSyouhn.getKyksyouhnrenno());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        JT_SiKykKihon jT_SiKykKihon = siharaiDomManager.getSiKykKihon(P_SYONO_01);

        JT_SiKykSyouhn jT_SiKykSyouhn = jT_SiKykKihon.getSiKykSyouhnBySyutkkbnSyouhncdItems(C_SyutkKbn.SYU, "",
                C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_1, P_KYKSYOUHNRENNO_1);

        Assert.assertEquals(null, jT_SiKykSyouhn);
    }
}
