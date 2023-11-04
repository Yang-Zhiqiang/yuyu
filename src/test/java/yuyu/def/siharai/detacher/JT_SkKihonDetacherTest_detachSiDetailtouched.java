package yuyu.def.siharai.detacher;

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

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 支払保険金備金調査F作成<br />
 * デタッチ取得[支払明細テーブル](請求基本テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonDetacherTest_detachSiDetailtouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SK001";
    static String P_SYONO_01 = "11807111118";
    static Integer P_SEIKYUURIREKINO_01 = new Integer(111);
    static Integer P_SEIKYUURIREKINO_02 = new Integer(222);
    static Integer P_UKETUKENO_01 = new Integer(11);
    static Integer P_UKETUKENO_02 = new Integer(22);
    static Integer P_RENNO_01 = new Integer(11);
    static Integer P_RENNO_02 = new Integer(22);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk jT_Sk1 = jT_SkKihon.createSk();
        jT_Sk1.setSeikyuurirekino(P_SEIKYUURIREKINO_01);

        JT_SkJiyuu jT_SkJiyuu11 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu11.setUketukeno(P_UKETUKENO_01);

        JT_SiDetail jT_SiDetail111 = jT_SkJiyuu11.createSiDetail();
        jT_SiDetail111.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail111.setSyouhncd("SY01");
        jT_SiDetail111.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail111.setSyouhnsdno(new Integer(11));
        jT_SiDetail111.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail111.setKyuuhucd("KY01");
        jT_SiDetail111.setRenno(P_RENNO_01);

        JT_SiDetail jT_SiDetail112 = jT_SkJiyuu11.createSiDetail();
        jT_SiDetail112.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail112.setSyouhncd("SY01");
        jT_SiDetail112.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail112.setSyouhnsdno(new Integer(11));
        jT_SiDetail112.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail112.setKyuuhucd("KY01");
        jT_SiDetail112.setRenno(P_RENNO_02);

        JT_SkJiyuu jT_SkJiyuu12 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu12.setUketukeno(P_UKETUKENO_02);

        JT_SiDetail jT_SiDetail121 = jT_SkJiyuu12.createSiDetail();
        jT_SiDetail121.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail121.setSyouhncd("SY01");
        jT_SiDetail121.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail121.setSyouhnsdno(new Integer(11));
        jT_SiDetail121.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail121.setKyuuhucd("KY01");
        jT_SiDetail121.setRenno(P_RENNO_01);

        JT_SiDetail jT_SiDetail122 = jT_SkJiyuu12.createSiDetail();
        jT_SiDetail122.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail122.setSyouhncd("SY01");
        jT_SiDetail122.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail122.setSyouhnsdno(new Integer(11));
        jT_SiDetail122.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail122.setKyuuhucd("KY01");
        jT_SiDetail122.setRenno(P_RENNO_02);

        JT_Sk jT_Sk2 = jT_SkKihon.createSk();
        jT_Sk2.setSeikyuurirekino(P_SEIKYUURIREKINO_02);

        JT_SkJiyuu jT_SkJiyuu21 = jT_Sk2.createSkJiyuu();
        jT_SkJiyuu21.setUketukeno(P_UKETUKENO_01);

        JT_SiDetail jT_SiDetail211 = jT_SkJiyuu21.createSiDetail();
        jT_SiDetail211.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail211.setSyouhncd("SY01");
        jT_SiDetail211.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail211.setSyouhnsdno(new Integer(11));
        jT_SiDetail211.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail211.setKyuuhucd("KY01");
        jT_SiDetail211.setRenno(P_RENNO_01);

        JT_SiDetail jT_SiDetail212 = jT_SkJiyuu21.createSiDetail();
        jT_SiDetail212.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail212.setSyouhncd("SY01");
        jT_SiDetail212.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail212.setSyouhnsdno(new Integer(11));
        jT_SiDetail212.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail212.setKyuuhucd("KY01");
        jT_SiDetail212.setRenno(P_RENNO_02);

        JT_SkJiyuu jT_SkJiyuu22 = jT_Sk2.createSkJiyuu();
        jT_SkJiyuu22.setUketukeno(P_UKETUKENO_02);

        JT_SiDetail jT_SiDetail221 = jT_SkJiyuu22.createSiDetail();
        jT_SiDetail221.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail221.setSyouhncd("SY01");
        jT_SiDetail221.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail221.setSyouhnsdno(new Integer(11));
        jT_SiDetail221.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail221.setKyuuhucd("KY01");
        jT_SiDetail221.setRenno(P_RENNO_01);

        JT_SiDetail jT_SiDetail222 = jT_SkJiyuu22.createSiDetail();
        jT_SiDetail222.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail222.setSyouhncd("SY01");
        jT_SiDetail222.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail222.setSyouhnsdno(new Integer(11));
        jT_SiDetail222.setKyksyouhnrenno(new Integer(11));
        jT_SiDetail222.setKyuuhucd("KY01");
        jT_SiDetail222.setRenno(P_RENNO_02);

        siharaiDomManager.insert(jT_SkKihon);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);

        JT_SkKihon entity = JT_SkKihonDetacher.detachSiDetailtouched(jT_SkKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<JT_Sk> sKLst = entity.getSks();
        Assert.assertEquals(2, sKLst.size());

        Assert.assertEquals(2, sKLst.get(0).getSkJiyuus().size());
        Assert.assertEquals(2, sKLst.get(1).getSkJiyuus().size());

        Assert.assertEquals(2, sKLst.get(0).getSkJiyuus().get(0).getSiDetails().size());
        Assert.assertEquals(2, sKLst.get(0).getSkJiyuus().get(1).getSiDetails().size());
        Assert.assertEquals(2, sKLst.get(1).getSkJiyuus().get(0).getSiDetails().size());
        Assert.assertEquals(2, sKLst.get(1).getSkJiyuus().get(1).getSiDetails().size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JT_SkKihon jT_SkKihon = null;

        Assert.assertNull(JT_SkKihonDetacher.detachSiDetailtouched(jT_SkKihon));
    }
}
