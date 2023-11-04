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
 * 請求履歴番号を指定して、<br />
 * 請求テーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getSkBySeikyuurirekino {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "ASD120";
    static String P_SYONO_001 = "11807111118";
    static int P_SEIKYUURIREKINO_001 = 123;
    static int P_SEIKYUURIREKINO_002 = 124;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertEquals(null, jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_001));

        JT_Sk jT_Sk1 = jT_SkKihon.createSk();
        jT_Sk1.setSeikyuurirekino(P_SEIKYUURIREKINO_001);

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

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertEquals(null, jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_002));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        JT_Sk jT_Sk = jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_001);

        Assert.assertEquals(P_SKNO_001, jT_Sk.getSkno());
        Assert.assertEquals(P_SYONO_001, jT_Sk.getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_001, jT_Sk.getSeikyuurirekino().intValue());
    }
}
