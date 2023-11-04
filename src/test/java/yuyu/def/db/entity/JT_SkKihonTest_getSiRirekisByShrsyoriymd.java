package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 決算基準日、処理年月日を指定して、<br />
 * 支払履歴テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getSiRirekisByShrsyoriymd {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "ASD120";
    static String P_SYONO_001 = "11807111118";
    static String P_SHRSIKIBETUKEY_001 = "SHSBKEY01";
    static String P_SHRSIKIBETUKEY_002 = "SHSBKEY02";
    static String P_SHRSIKIBETUKEY_003 = "SHSBKEY03";
    static String P_SHRSIKIBETUKEY_004 = "SHSBKEY04";
    static String P_SHRSIKIBETUKEY_005 = "SHSBKEY05";
    static String P_SHRSIKIBETUKEY_006 = "SHSBKEY06";
    static BizDate P_SHRSYORIYMD_01 = BizDate.valueOf(20160330);
    static BizDate P_SHRSYORIYMD_02 = BizDate.valueOf(20160331);
    static BizDate P_SHRSYORIYMD_03 = BizDate.valueOf(20160401);
    static BizDate P_SHRSYORIYMD_04 = BizDate.valueOf(20160403);
    static BizDate P_SHRSYORIYMD_05 = BizDate.valueOf(20160404);
    static BizDate P_SHRSYORIYMD_06 = BizDate.valueOf(20160405);
    static BizDate P_TYAKKINYMD_01 = BizDate.valueOf(20160331);
    static BizDate P_TYAKKINYMD_02 = BizDate.valueOf(20160401);
    static BizDate P_TYAKKINYMD_03 = BizDate.valueOf(20160402);
    static BizDate P_TYAKKINYMD_04 = BizDate.valueOf(20160404);
    static BizDate P_TYAKKINYMD_05 = BizDate.valueOf(20160405);
    static BizDate P_TYAKKINYMD_06 = BizDate.valueOf(20160406);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        Assert.assertEquals(0, jT_SkKihon.getSiRirekisByShrsyoriymd(BizDate.valueOf(20160405)).size());

        JT_SiRireki jT_SiRireki1 = jT_SkKihon.createSiRireki();
        jT_SiRireki1.setShrsikibetukey(P_SHRSIKIBETUKEY_001);
        jT_SiRireki1.setShrsyoriymd(P_SHRSYORIYMD_01);
        jT_SiRireki1.setTyakkinymd(P_TYAKKINYMD_01);

        JT_SiRireki jT_SiRireki2 = jT_SkKihon.createSiRireki();
        jT_SiRireki2.setShrsikibetukey(P_SHRSIKIBETUKEY_002);
        jT_SiRireki2.setShrsyoriymd(P_SHRSYORIYMD_02);
        jT_SiRireki2.setTyakkinymd(P_TYAKKINYMD_02);

        JT_SiRireki jT_SiRireki3 = jT_SkKihon.createSiRireki();
        jT_SiRireki3.setShrsikibetukey(P_SHRSIKIBETUKEY_003);
        jT_SiRireki3.setShrsyoriymd(P_SHRSYORIYMD_03);
        jT_SiRireki3.setTyakkinymd(P_TYAKKINYMD_03);

        JT_SiRireki jT_SiRireki4 = jT_SkKihon.createSiRireki();
        jT_SiRireki4.setShrsikibetukey(P_SHRSIKIBETUKEY_004);
        jT_SiRireki4.setShrsyoriymd(P_SHRSYORIYMD_04);
        jT_SiRireki4.setTyakkinymd(P_TYAKKINYMD_04);

        JT_SiRireki jT_SiRireki5 = jT_SkKihon.createSiRireki();
        jT_SiRireki5.setShrsikibetukey(P_SHRSIKIBETUKEY_005);
        jT_SiRireki5.setShrsyoriymd(P_SHRSYORIYMD_05);
        jT_SiRireki5.setTyakkinymd(P_TYAKKINYMD_05);

        JT_SiRireki jT_SiRireki6 = jT_SkKihon.createSiRireki();
        jT_SiRireki6.setShrsikibetukey(P_SHRSIKIBETUKEY_006);
        jT_SiRireki6.setShrsyoriymd(P_SHRSYORIYMD_06);
        jT_SiRireki6.setTyakkinymd(P_TYAKKINYMD_06);

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

        Assert.assertEquals(0, jT_SkKihon.getSiRirekisByShrsyoriymd(BizDate.valueOf(20160405)).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        List<JT_SiRireki> jT_SiRirekis = jT_SkKihon.getSiRirekisByShrsyoriymd(BizDate.valueOf(20160404));

        Assert.assertEquals(1, jT_SiRirekis.size());

        Assert.assertEquals(P_SKNO_001, jT_SiRirekis.get(0).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_SiRirekis.get(0).getSyono());
        Assert.assertEquals(P_SHRSIKIBETUKEY_006, jT_SiRirekis.get(0).getShrsikibetukey());
        Assert.assertEquals(P_TYAKKINYMD_06, jT_SiRirekis.get(0).getTyakkinymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);

        List<JT_SiRireki> jT_SiRirekis = jT_SkKihon.getSiRirekisByShrsyoriymd(BizDate.valueOf(20160401));

        Assert.assertEquals(3, jT_SiRirekis.size());

        Assert.assertEquals(P_SKNO_001, jT_SiRirekis.get(0).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_SiRirekis.get(0).getSyono());
        Assert.assertEquals(P_SHRSIKIBETUKEY_004, jT_SiRirekis.get(0).getShrsikibetukey());
        Assert.assertEquals(P_TYAKKINYMD_04, jT_SiRirekis.get(0).getTyakkinymd());

        Assert.assertEquals(P_SKNO_001, jT_SiRirekis.get(1).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_SiRirekis.get(1).getSyono());
        Assert.assertEquals(P_SHRSIKIBETUKEY_005, jT_SiRirekis.get(1).getShrsikibetukey());
        Assert.assertEquals(P_TYAKKINYMD_05, jT_SiRirekis.get(1).getTyakkinymd());

        Assert.assertEquals(P_SKNO_001, jT_SiRirekis.get(2).getSkno());
        Assert.assertEquals(P_SYONO_001, jT_SiRirekis.get(2).getSyono());
        Assert.assertEquals(P_SHRSIKIBETUKEY_006, jT_SiRirekis.get(2).getShrsikibetukey());
        Assert.assertEquals(P_TYAKKINYMD_06, jT_SiRirekis.get(2).getTyakkinymd());
    }
}
