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
 * 支払識別キーを指定して、<br />
 * 支払履歴テーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getSiRirekiByShrsikibetukey {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "SK01";
    static String P_SYONO_001 = "11807111118";
    static String P_SHRSIKIBETUKEY_001 = "SKBT001";
    static String P_SHRSIKIBETUKEY_002 = "SKBT002";
    static String P_SHRSIKIBETUKEY_003 = "SKBT003";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertEquals(null, jT_SkKihon.getSiRirekiByShrsikibetukey(P_SHRSIKIBETUKEY_001));

        JT_SiRireki jT_SiRireki1 = jT_SkKihon.createSiRireki();
        jT_SiRireki1.setShrsikibetukey(P_SHRSIKIBETUKEY_001);

        JT_SiRireki jT_SiRireki2 = jT_SkKihon.createSiRireki();
        jT_SiRireki2.setShrsikibetukey(P_SHRSIKIBETUKEY_002);

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

        Assert.assertEquals(null, skKihon.getSiRirekiByShrsikibetukey(P_SHRSIKIBETUKEY_003));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        JT_SiRireki jT_SiRireki = skKihon.getSiRirekiByShrsikibetukey(P_SHRSIKIBETUKEY_001);

        Assert.assertEquals(P_SKNO_001, jT_SiRireki.getSkno());
        Assert.assertEquals(P_SYONO_001, jT_SiRireki.getSyono());
        Assert.assertEquals(P_SHRSIKIBETUKEY_001, jT_SiRireki.getShrsikibetukey());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertEquals(null, skKihon.getTtdkRirekByTtdkrrkskbtkey(""));
    }
}
