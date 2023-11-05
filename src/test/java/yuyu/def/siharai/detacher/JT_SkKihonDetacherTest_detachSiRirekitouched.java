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

import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 支払保険金備金調査F作成<br />
 * デタッチ取得[支払履歴テーブル](請求基本テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonDetacherTest_detachSiRirekitouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SKNO01";
    static String P_SYONO_01 = "11807111118";
    static String P_SHRSIKIBETUKEY_01 = "SHSBKEY01";
    static String P_SHRSIKIBETUKEY_02 = "SHSBKEY02";
    static String P_SHRSIKIBETUKEY_03 = "SHSBKEY03";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_SiRireki jT_SiRireki1 = jT_SkKihon.createSiRireki();
        jT_SiRireki1.setShrsikibetukey(P_SHRSIKIBETUKEY_01);

        JT_SiRireki jT_SiRireki2 = jT_SkKihon.createSiRireki();
        jT_SiRireki2.setShrsikibetukey(P_SHRSIKIBETUKEY_02);

        JT_SiRireki jT_SiRireki3 = jT_SkKihon.createSiRireki();
        jT_SiRireki3.setShrsikibetukey(P_SHRSIKIBETUKEY_03);

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

        JT_SkKihon entity = JT_SkKihonDetacher.detachSiRirekitouched(jT_SkKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<JT_SiRireki> siRirekis = entity.getSiRirekis();
        Assert.assertEquals(3, siRirekis.size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JT_SkKihon jT_SkKihon = null;

        Assert.assertNull(JT_SkKihonDetacher.detachSiRirekitouched(jT_SkKihon));
    }
}
