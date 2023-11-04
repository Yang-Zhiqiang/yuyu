package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 支払履歴テーブルの最大支払識別キー取得　請求番号かつ証券番号のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiRirekiMaxShrsikibetukeyBySknoSyono {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SKNO01";
    static String P_SKNO_02 = "SKNO02";
    static String P_SKNO_03 = "SKNO03";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SHRSIKIBETUKEY_01 = "SHRS001";
    static String P_SHRSIKIBETUKEY_02 = "SHRS002";
    static String P_SHRSIKIBETUKEY_03 = "SHRS003";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String shrsikibetukey = siharaiDomManager.getSiRirekiMaxShrsikibetukeyBySknoSyono(P_SKNO_01, P_SYONO_01);

        Assert.assertNull(shrsikibetukey);

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_SiRireki JT_SiRireki1 = jT_SkKihon1.createSiRireki();
        JT_SiRireki1.setShrsikibetukey(P_SHRSIKIBETUKEY_01);

        JT_SiRireki JT_SiRireki2 = jT_SkKihon1.createSiRireki();
        JT_SiRireki2.setShrsikibetukey(P_SHRSIKIBETUKEY_03);

        JT_SiRireki JT_SiRireki3 = jT_SkKihon1.createSiRireki();
        JT_SiRireki3.setShrsikibetukey(P_SHRSIKIBETUKEY_02);

        JT_SkKihon jT_SkKihon2 = new JT_SkKihon(P_SKNO_01, P_SYONO_02);

        JT_SiRireki JT_SiRireki4 = jT_SkKihon2.createSiRireki();
        JT_SiRireki4.setShrsikibetukey(P_SHRSIKIBETUKEY_01);

        JT_SkKihon jT_SkKihon3 = new JT_SkKihon(P_SKNO_02, P_SYONO_01);

        JT_SiRireki JT_SiRireki5 = jT_SkKihon3.createSiRireki();
        JT_SiRireki5.setShrsikibetukey(P_SHRSIKIBETUKEY_01);

        siharaiDomManager.insert(jT_SkKihon1);
        siharaiDomManager.insert(jT_SkKihon2);
        siharaiDomManager.insert(jT_SkKihon3);
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

        String shrsikibetukey = siharaiDomManager.getSiRirekiMaxShrsikibetukeyBySknoSyono(P_SKNO_03, P_SYONO_01);

        Assert.assertNull(shrsikibetukey);
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        String shrsikibetukey = siharaiDomManager.getSiRirekiMaxShrsikibetukeyBySknoSyono(P_SKNO_01, P_SYONO_01);

        Assert.assertEquals(P_SHRSIKIBETUKEY_03, shrsikibetukey);
    }

    @Test
    @TestOrder(30)
    public void BlankCondition1() {

        String shrsikibetukey = siharaiDomManager.getSiRirekiMaxShrsikibetukeyBySknoSyono("", P_SYONO_01);

        Assert.assertNull(shrsikibetukey);
    }

    @Test
    @TestOrder(40)
    public void BlankCondition2() {

        String shrsikibetukey = siharaiDomManager.getSiRirekiMaxShrsikibetukeyBySknoSyono(P_SKNO_01, "");

        Assert.assertNull(shrsikibetukey);
    }
}
