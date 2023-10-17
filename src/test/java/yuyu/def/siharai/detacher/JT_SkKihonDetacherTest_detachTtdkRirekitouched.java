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

import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 保険金給付金備金情報抽出<br />
 * デタッチ取得[請求基本テーブル](手続履歴テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonDetacherTest_detachTtdkRirekitouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SKNO01";
    static String P_SYONO_01 = "11807111118";
    static String P_TTDKRRKSKBTKEY_01 = "TDK01";
    static String P_TTDKRRKSKBTKEY_02 = "TDK02";
    static String P_TTDKRRKSKBTKEY_03 = "TDK03";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_TtdkRireki jT_TtdkRireki1 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki1.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_01);

        JT_TtdkRireki jT_TtdkRireki2 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki2.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_02);

        JT_TtdkRireki jT_TtdkRireki3 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki3.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_03);

        siharaiDomManager.insert(jT_SkKihon);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);

        JT_SkKihon entity = JT_SkKihonDetacher.detachTtdkRirekitouched(jT_SkKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<JT_TtdkRireki> ttdkRirekis = entity.getTtdkRirekis();

        Assert.assertEquals(3, ttdkRirekis.size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JT_SkKihon jT_SkKihon = null;

        Assert.assertNull(JT_SkKihonDetacher.detachTtdkRirekitouched(jT_SkKihon));
    }
}
