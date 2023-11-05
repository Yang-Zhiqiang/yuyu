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

import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 支払保険金備金調査F作成<br />
 * デタッチ取得[請求事由テーブル](請求基本テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonDetacherTest_detachSkJiyuutouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SKNO01";
    static String P_SYONO_01 = "11807111118";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk jT_Sk1 = jT_SkKihon.createSk();
        jT_Sk1.setSeikyuurirekino(new Integer(1));

        JT_SkJiyuu jT_SkJiyuu1 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu1.setUketukeno(new Integer(1));

        JT_SkJiyuu jT_SkJiyuu2 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu2.setUketukeno(new Integer(2));

        JT_Sk jT_Sk2 = jT_SkKihon.createSk();
        jT_Sk2.setSeikyuurirekino(new Integer(2));

        JT_SkJiyuu jT_SkJiyuu3 = jT_Sk2.createSkJiyuu();
        jT_SkJiyuu3.setUketukeno(new Integer(1));

        JT_SkJiyuu jT_SkJiyuu4 = jT_Sk2.createSkJiyuu();
        jT_SkJiyuu4.setUketukeno(new Integer(2));

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

        JT_SkKihon entity = JT_SkKihonDetacher.detachSkJiyuutouched(jT_SkKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<JT_Sk> sKs = entity.getSks();
        Assert.assertEquals(2, sKs.size());

        Assert.assertEquals(2, sKs.get(0).getSkJiyuus().size());
        Assert.assertEquals(2, sKs.get(1).getSkJiyuus().size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JT_SkKihon jT_SkKihon = null;

        Assert.assertNull(JT_SkKihonDetacher.detachSkJiyuutouched(jT_SkKihon));
    }
}
