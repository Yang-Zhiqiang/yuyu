package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金支払共通ＤＢアクセス<br />
 * 手続履歴テーブルエンティティ最大手続履歴識別キー取得(請求番号、証券番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SKNO_01 = "KN11111";
    static String P_SKNO_02 = "KN22222";
    static String P_TTDKRRKSKBTKEY_01 = "TT11111";
    static String P_TTDKRRKSKBTKEY_02 = "TT22222";
    static String P_TTDKRRKSKBTKEY_03 = "TT33333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String maxTtdkrrkskbtkey = siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(P_SKNO_01, P_SYONO_01);
        Assert.assertNull(maxTtdkrrkskbtkey);

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_TtdkRireki jT_TtdkRireki1 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki1.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_01);

        JT_TtdkRireki jT_TtdkRireki2 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki2.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_02);

        JT_TtdkRireki jT_TtdkRireki3 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki3.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_03);

        siharaiDomManager.insert(jT_SkKihon1);
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

        String maxTtdkrrkskbtkey = siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(P_SKNO_02, P_SYONO_02);
        Assert.assertNull(maxTtdkrrkskbtkey);
    }

    @Test
    @TestOrder(20)
    public void blankCondition1() {

        String maxTtdkrrkskbtkey = siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono("", P_SYONO_01);
        Assert.assertNull(maxTtdkrrkskbtkey);
    }

    @Test
    @TestOrder(30)
    public void blankCondition2() {

        String maxTtdkrrkskbtkey = siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(P_SKNO_01, "");
        Assert.assertNull(maxTtdkrrkskbtkey);
    }

    @Test
    @TestOrder(40)
    public void normal1() {

        String maxTtdkrrkskbtkey = siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(P_SKNO_01, P_SYONO_01);
        Assert.assertEquals(P_TTDKRRKSKBTKEY_03, maxTtdkrrkskbtkey);
    }
}
