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
 * 請求事由テーブルエンティティから、<br />
 * 請求事由テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkTest_getSkJiyuusBySibouymd {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SKNO_01 = "B001";
    static Integer P_SEIKYUURIREKINO_01 = 1;
    static BizDate P_SIBOUYMD_01 = BizDate.valueOf("20160407");
    static BizDate P_SIBOUYMD_02 = BizDate.valueOf("20160408");
    static BizDate P_SIBOUYMD_03 = BizDate.valueOf("20160409");
    static BizDate P_SIBOUYMD_04 = BizDate.valueOf("20160410");
    static BizDate P_SIBOUYMD_05 = BizDate.valueOf("20160411");
    static BizDate P_SIBOUYMD_06 = BizDate.valueOf("20160412");
    static BizDate P_SIBOUYMD_07 = BizDate.valueOf("20160413");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk sk1 = skKihon1.createSk();
        sk1.setSeikyuurirekino(P_SEIKYUURIREKINO_01);

        Assert.assertEquals(0, sk1.getSkJiyuusBySibouymd(P_SIBOUYMD_02).size());

        JT_SkJiyuu skJiyuu1 = sk1.createSkJiyuu();
        skJiyuu1.setUketukeno(1);
        skJiyuu1.setSibouymd(P_SIBOUYMD_01);

        JT_SkJiyuu skJiyuu2 = sk1.createSkJiyuu();
        skJiyuu2.setUketukeno(2);
        skJiyuu2.setSibouymd(P_SIBOUYMD_02);

        JT_SkJiyuu skJiyuu3 = sk1.createSkJiyuu();
        skJiyuu3.setUketukeno(3);
        skJiyuu3.setSibouymd(P_SIBOUYMD_03);

        JT_SkJiyuu skJiyuu4 = sk1.createSkJiyuu();
        skJiyuu4.setUketukeno(4);
        skJiyuu4.setSibouymd(P_SIBOUYMD_04);

        JT_SkJiyuu skJiyuu5 = sk1.createSkJiyuu();
        skJiyuu5.setUketukeno(5);
        skJiyuu5.setSibouymd(P_SIBOUYMD_05);

        JT_SkJiyuu skJiyuu6 = sk1.createSkJiyuu();
        skJiyuu6.setUketukeno(6);
        skJiyuu6.setSibouymd(P_SIBOUYMD_06);

        JT_SkJiyuu skJiyuu7 = sk1.createSkJiyuu();
        skJiyuu7.setUketukeno(7);

        siharaiDomManager.insert(skKihon1);
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

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);
        JT_Sk sk = skKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_01);

        List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuusBySibouymd(P_SIBOUYMD_07);

        Assert.assertEquals(0, skJiyuuLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);
        JT_Sk sk = skKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_01);

        List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuusBySibouymd(P_SIBOUYMD_06);

        Assert.assertEquals(1, skJiyuuLst.size());

        Assert.assertEquals(P_SKNO_01, skJiyuuLst.get(0).getSkno());
        Assert.assertEquals(P_SYONO_01, skJiyuuLst.get(0).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, skJiyuuLst.get(0).getSeikyuurirekino());
        Assert.assertEquals(new Integer(6), skJiyuuLst.get(0).getUketukeno());
        Assert.assertEquals(P_SIBOUYMD_06, skJiyuuLst.get(0).getSibouymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);
        JT_Sk sk = skKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_01);

        List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuusBySibouymd(P_SIBOUYMD_03);

        Assert.assertEquals(4, skJiyuuLst.size());

        Assert.assertEquals(P_SKNO_01, skJiyuuLst.get(0).getSkno());
        Assert.assertEquals(P_SYONO_01, skJiyuuLst.get(0).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, skJiyuuLst.get(0).getSeikyuurirekino());
        Assert.assertEquals(new Integer(3), skJiyuuLst.get(0).getUketukeno());
        Assert.assertEquals(P_SIBOUYMD_03, skJiyuuLst.get(0).getSibouymd());

        Assert.assertEquals(P_SKNO_01, skJiyuuLst.get(1).getSkno());
        Assert.assertEquals(P_SYONO_01, skJiyuuLst.get(1).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, skJiyuuLst.get(1).getSeikyuurirekino());
        Assert.assertEquals(new Integer(4), skJiyuuLst.get(1).getUketukeno());
        Assert.assertEquals(P_SIBOUYMD_04, skJiyuuLst.get(1).getSibouymd());

        Assert.assertEquals(P_SKNO_01, skJiyuuLst.get(2).getSkno());
        Assert.assertEquals(P_SYONO_01, skJiyuuLst.get(2).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, skJiyuuLst.get(2).getSeikyuurirekino());
        Assert.assertEquals(new Integer(5), skJiyuuLst.get(2).getUketukeno());
        Assert.assertEquals(P_SIBOUYMD_05, skJiyuuLst.get(2).getSibouymd());

        Assert.assertEquals(P_SKNO_01, skJiyuuLst.get(3).getSkno());
        Assert.assertEquals(P_SYONO_01, skJiyuuLst.get(3).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, skJiyuuLst.get(3).getSeikyuurirekino());
        Assert.assertEquals(new Integer(6), skJiyuuLst.get(3).getUketukeno());
        Assert.assertEquals(P_SIBOUYMD_06, skJiyuuLst.get(3).getSibouymd());
    }
}