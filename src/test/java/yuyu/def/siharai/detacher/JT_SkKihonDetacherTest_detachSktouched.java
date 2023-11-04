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
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 支払保険金備金調査F作成<br />
 * デタッチ取得[請求テーブル](請求基本テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonDetacherTest_detachSktouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SKNO001";
    static String P_SYONO_01 = "11807111118";
    static Integer P_SEIKYUURIREKINO_01 = 1;
    static Integer P_SEIKYUURIREKINO_02 = 2;
    static Integer P_SEIKYUURIREKINO_03 = 3;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk jT_Sk1 = jT_SkKihon.createSk();
        jT_Sk1.setSeikyuurirekino(P_SEIKYUURIREKINO_01);

        JT_Sk jT_Sk2 = jT_SkKihon.createSk();
        jT_Sk2.setSeikyuurirekino(P_SEIKYUURIREKINO_02);

        JT_Sk jT_Sk3 = jT_SkKihon.createSk();
        jT_Sk3.setSeikyuurirekino(P_SEIKYUURIREKINO_03);

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

        JT_SkKihon entity = JT_SkKihonDetacher.detachSktouched(jT_SkKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<JT_Sk> sks = entity.getSks();
        Assert.assertEquals(3, sks.size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JT_SkKihon jT_SkKihon = null;

        Assert.assertNull(JT_SkKihonDetacher.detachSktouched(jT_SkKihon));
    }
}
