package yuyu.def.db.entity;

import java.util.List;

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
 * 手続履歴テーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getTtdkRirekisByShrsikibetukey {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "ASD120";
    static String P_SYONO_001 = "11807111118";
    static String P_TTDKRRKSKBTKEY_001 = "TKS122";
    static String P_TTDKRRKSKBTKEY_002 = "TKS123";
    static String P_TTDKRRKSKBTKEY_003 = "TKS124";
    static String P_TTDKRRKSKBTKEY_004 = "TKS125";
    static String P_SHRSIKIBETUKEY_001 = "SHR122";
    static String P_SHRSIKIBETUKEY_002 = "SHR123";
    static String P_SHRSIKIBETUKEY_003 = "SHR124";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertEquals(0, jT_SkKihon.getTtdkRirekisByShrsikibetukey(P_SHRSIKIBETUKEY_002).size());

        JT_TtdkRireki jT_TtdkRireki1 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki1.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_001);
        jT_TtdkRireki1.setShrsikibetukey(P_SHRSIKIBETUKEY_001);

        JT_TtdkRireki jT_TtdkRireki2 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki2.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_002);
        jT_TtdkRireki2.setShrsikibetukey(P_SHRSIKIBETUKEY_002);

        JT_TtdkRireki jT_TtdkRireki3 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki3.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_003);
        jT_TtdkRireki3.setShrsikibetukey(P_SHRSIKIBETUKEY_002);

        JT_TtdkRireki jT_TtdkRireki4 = jT_SkKihon.createTtdkRireki();
        jT_TtdkRireki4.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_004);
        jT_TtdkRireki4.setShrsikibetukey(P_SHRSIKIBETUKEY_002);

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
        List<JT_TtdkRireki> jT_TtdkRirekis = skKihon.getTtdkRirekisByShrsikibetukey(P_SHRSIKIBETUKEY_003);

        Assert.assertEquals(0, jT_TtdkRirekis.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        List<JT_TtdkRireki> jT_TtdkRirekis = skKihon.getTtdkRirekisByShrsikibetukey(P_SHRSIKIBETUKEY_001);
        Assert.assertEquals(1, jT_TtdkRirekis.size());

        Assert.assertEquals(P_SKNO_001, jT_TtdkRirekis.get(0).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_TtdkRirekis.get(0).getSyono());
        Assert.assertEquals(P_TTDKRRKSKBTKEY_001, jT_TtdkRirekis.get(0).getTtdkrrkskbtkey());
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        List<JT_TtdkRireki> jT_TtdkRirekis = skKihon.getTtdkRirekisByShrsikibetukey(P_SHRSIKIBETUKEY_002);
        Assert.assertEquals(3, jT_TtdkRirekis.size());

        Assert.assertEquals(P_SKNO_001, jT_TtdkRirekis.get(0).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_TtdkRirekis.get(0).getSyono());
        Assert.assertEquals(P_TTDKRRKSKBTKEY_002, jT_TtdkRirekis.get(0).getTtdkrrkskbtkey());
        Assert.assertEquals(P_SKNO_001, jT_TtdkRirekis.get(1).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_TtdkRirekis.get(1).getSyono());
        Assert.assertEquals(P_TTDKRRKSKBTKEY_003, jT_TtdkRirekis.get(1).getTtdkrrkskbtkey());
        Assert.assertEquals(P_SKNO_001, jT_TtdkRirekis.get(2).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_TtdkRirekis.get(2).getSyono());
        Assert.assertEquals(P_TTDKRRKSKBTKEY_004, jT_TtdkRirekis.get(2).getTtdkrrkskbtkey());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertEquals(0, skKihon.getTtdkRirekisByShrsikibetukey("").size());
    }
}
