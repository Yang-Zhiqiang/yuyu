package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求基本テーブルエンティティから、<br />
 * 手続履歴識別キーを指定して、<br />
 * 手続履歴テーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getTtdkRirekiByTtdkrrkskbtkey {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "ASD120";
    static String P_SYONO_001 = "11807111118";
    static String P_TTDKRRKSKBTKEY_001 = "TKS123";
    static String P_TTDKRRKSKBTKEY_002 = "TKS124";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertNull(jT_SkKihon.getTtdkRirekiByTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_001));

        JT_TtdkRireki jT_TtdkRireki1 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki1.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_001);

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
    public void noResult1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertNull(skKihon.getTtdkRirekiByTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_002));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        JT_TtdkRireki jT_TtdkRireki = skKihon.getTtdkRirekiByTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_001);

        Assert.assertEquals(P_SKNO_001, jT_TtdkRireki.getSkno());
        Assert.assertEquals(P_SYONO_001, jT_TtdkRireki.getSyono());
        Assert.assertEquals(P_TTDKRRKSKBTKEY_001, jT_TtdkRireki.getTtdkrrkskbtkey());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertNull(skKihon.getTtdkRirekiByTtdkrrkskbtkey(""));
    }
}
