package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 支払不支払<br />
 * 支払明細テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkJiyuuTest_getSiDetailsByKyhkg {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "11111";
    static String P_SYONO_01 = "11807111118";
    static Integer P_SEIKYUURIREKINO_01 = 123;
    static Integer P_UKETUKENO_01 = 14;
    static Integer P_UKETUKENO_02 = 15;
    static Integer P_UKETUKENO_03 = 16;
    static String P_SYOUHNCD_01 = "SH01";
    static String P_SYOUHNCD_02 = "SH02";
    static String P_SYOUHNCD_03 = "SH03";
    static String P_SYOUHNCD_04 = "SH04";
    static String P_SYOUHNCD_05 = "SH05";
    static String P_SYOUHNCD_06 = "SH06";
    static String P_SYOUHNCD_07 = "SH07";
    static Integer P_SYOUHNSDNO_01 = 11;
    static Integer P_KYKSYOUHNRENNO_01 = 40;
    static String P_KYUUHUCD_01 = "KH01";
    static Integer P_RENNO_01 = 20;
    static BizCurrency P_KYHKG_0_JPY = BizCurrency.valueOf(0);
    static BizCurrency P_KYHKG_1_JPY = BizCurrency.valueOf(100000);
    static BizCurrency P_KYHKG_1_DOLLAR = BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR);
    static BizCurrency P_KYHKG_1_MANYEN = BizCurrency.valueOf(100000, BizCurrencyTypes.MANYEN);
    static BizCurrency P_KYHKG_1_AU_DOLLAR = BizCurrency.valueOf(100000, BizCurrencyTypes.AU_DOLLAR);
    static BizCurrency P_KYHKG_1_EURO = BizCurrency.valueOf(100000, BizCurrencyTypes.EURO);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk jT_Sk1 = jT_SkKihon1.createSk();
        jT_Sk1.setSeikyuurirekino(P_SEIKYUURIREKINO_01);

        JT_SkJiyuu jT_SkJiyuu1 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu1.setUketukeno(P_UKETUKENO_01);

        JT_SiDetail jT_SiDetail11 = jT_SkJiyuu1.createSiDetail();
        jT_SiDetail11.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail11.setSyouhncd(P_SYOUHNCD_01);
        jT_SiDetail11.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail11.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail11.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail11.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail11.setRenno(P_RENNO_01);
        jT_SiDetail11.setKyhkg(P_KYHKG_0_JPY);

        JT_SkJiyuu jT_SkJiyuu2 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu2.setUketukeno(P_UKETUKENO_02);

        List<JT_SiDetail> jT_SiDetails = jT_SkJiyuu2.getSiDetailsByKyhkg();
        Assert.assertEquals(0, jT_SiDetails.size());

        JT_SiDetail jT_SiDetail21 = jT_SkJiyuu2.createSiDetail();
        jT_SiDetail21.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail21.setSyouhncd(P_SYOUHNCD_01);
        jT_SiDetail21.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail21.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail21.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail21.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail21.setRenno(P_RENNO_01);
        jT_SiDetail21.setKyhkg(P_KYHKG_1_JPY);

        JT_SkJiyuu jT_SkJiyuu3 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu3.setUketukeno(P_UKETUKENO_03);

        JT_SiDetail jT_SiDetail32 = jT_SkJiyuu3.createSiDetail();
        jT_SiDetail32.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail32.setSyouhncd(P_SYOUHNCD_02);
        jT_SiDetail32.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail32.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail32.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail32.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail32.setRenno(P_RENNO_01);
        jT_SiDetail32.setKyhkg(P_KYHKG_1_DOLLAR);

        JT_SiDetail jT_SiDetail33 = jT_SkJiyuu3.createSiDetail();
        jT_SiDetail33.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail33.setSyouhncd(P_SYOUHNCD_03);
        jT_SiDetail33.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail33.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail33.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail33.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail33.setRenno(P_RENNO_01);
        jT_SiDetail33.setKyhkg(P_KYHKG_1_JPY);

        JT_SiDetail jT_SiDetail34 = jT_SkJiyuu3.createSiDetail();
        jT_SiDetail34.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail34.setSyouhncd(P_SYOUHNCD_04);
        jT_SiDetail34.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail34.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail34.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail34.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail34.setRenno(P_RENNO_01);

        JT_SiDetail jT_SiDetail35 = jT_SkJiyuu3.createSiDetail();
        jT_SiDetail35.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail35.setSyouhncd(P_SYOUHNCD_05);
        jT_SiDetail35.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail35.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail35.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail35.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail35.setRenno(P_RENNO_01);
        jT_SiDetail35.setKyhkg(P_KYHKG_1_MANYEN);

        JT_SiDetail jT_SiDetail36 = jT_SkJiyuu3.createSiDetail();
        jT_SiDetail36.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail36.setSyouhncd(P_SYOUHNCD_06);
        jT_SiDetail36.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail36.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail36.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail36.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail36.setRenno(P_RENNO_01);
        jT_SiDetail36.setKyhkg(P_KYHKG_1_AU_DOLLAR);

        JT_SiDetail jT_SiDetail37 = jT_SkJiyuu3.createSiDetail();
        jT_SiDetail37.setSyutkkbn(C_SyutkKbn.SYU);
        jT_SiDetail37.setSyouhncd(P_SYOUHNCD_07);
        jT_SiDetail37.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        jT_SiDetail37.setSyouhnsdno(P_SYOUHNSDNO_01);
        jT_SiDetail37.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        jT_SiDetail37.setKyuuhucd(P_KYUUHUCD_01);
        jT_SiDetail37.setRenno(P_RENNO_01);
        jT_SiDetail37.setKyhkg(P_KYHKG_1_EURO);

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

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);
        JT_Sk jT_Sk = jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_01);
        JT_SkJiyuu jT_SkJiyuu = jT_Sk.getSkJiyuus().get(0);

        List<JT_SiDetail> jT_SiDetails = jT_SkJiyuu.getSiDetailsByKyhkg();

        Assert.assertEquals(0, jT_SiDetails.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);
        JT_Sk jT_Sk = jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_01);
        JT_SkJiyuu jT_SkJiyuu = jT_Sk.getSkJiyuus().get(1);

        List<JT_SiDetail> jT_SiDetails = jT_SkJiyuu.getSiDetailsByKyhkg();

        Assert.assertEquals(1, jT_SiDetails.size());

        Assert.assertEquals(P_SKNO_01, jT_SiDetails.get(0).getSkno());
        Assert.assertEquals(P_SYONO_01, jT_SiDetails.get(0).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, jT_SiDetails.get(0).getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_02, jT_SiDetails.get(0).getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, jT_SiDetails.get(0).getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_01, jT_SiDetails.get(0).getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, jT_SiDetails.get(0).getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO_01, jT_SiDetails.get(0).getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_01, jT_SiDetails.get(0).getKyksyouhnrenno());
        Assert.assertEquals(P_KYUUHUCD_01, jT_SiDetails.get(0).getKyuuhucd());
        Assert.assertEquals(P_RENNO_01, jT_SiDetails.get(0).getRenno());
        Assert.assertEquals(P_KYHKG_1_JPY, jT_SiDetails.get(0).getKyhkg());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);
        JT_Sk jT_Sk = jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_01);
        JT_SkJiyuu jT_SkJiyuu = jT_Sk.getSkJiyuus().get(2);

        List<JT_SiDetail> jT_SiDetailLst = jT_SkJiyuu.getSiDetailsByKyhkg();

        Assert.assertEquals(5, jT_SiDetailLst.size());

        Assert.assertEquals(P_SKNO_01, jT_SiDetailLst.get(0).getSkno());
        Assert.assertEquals(P_SYONO_01, jT_SiDetailLst.get(0).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, jT_SiDetailLst.get(0).getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_03, jT_SiDetailLst.get(0).getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, jT_SiDetailLst.get(0).getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_02, jT_SiDetailLst.get(0).getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, jT_SiDetailLst.get(0).getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO_01, jT_SiDetailLst.get(0).getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_01, jT_SiDetailLst.get(0).getKyksyouhnrenno());
        Assert.assertEquals(P_KYUUHUCD_01, jT_SiDetailLst.get(0).getKyuuhucd());
        Assert.assertEquals(P_RENNO_01, jT_SiDetailLst.get(0).getRenno());
        Assert.assertEquals(P_KYHKG_1_DOLLAR, jT_SiDetailLst.get(0).getKyhkg());

        Assert.assertEquals(P_SKNO_01, jT_SiDetailLst.get(1).getSkno());
        Assert.assertEquals(P_SYONO_01, jT_SiDetailLst.get(1).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, jT_SiDetailLst.get(1).getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_03, jT_SiDetailLst.get(1).getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, jT_SiDetailLst.get(1).getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_03, jT_SiDetailLst.get(1).getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, jT_SiDetailLst.get(1).getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO_01, jT_SiDetailLst.get(1).getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_01, jT_SiDetailLst.get(1).getKyksyouhnrenno());
        Assert.assertEquals(P_KYUUHUCD_01, jT_SiDetailLst.get(1).getKyuuhucd());
        Assert.assertEquals(P_RENNO_01, jT_SiDetailLst.get(1).getRenno());
        Assert.assertEquals(P_KYHKG_1_JPY, jT_SiDetailLst.get(1).getKyhkg());

        Assert.assertEquals(P_SKNO_01, jT_SiDetailLst.get(2).getSkno());
        Assert.assertEquals(P_SYONO_01, jT_SiDetailLst.get(2).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, jT_SiDetailLst.get(2).getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_03, jT_SiDetailLst.get(2).getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, jT_SiDetailLst.get(2).getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_05, jT_SiDetailLst.get(2).getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, jT_SiDetailLst.get(2).getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO_01, jT_SiDetailLst.get(2).getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_01, jT_SiDetailLst.get(2).getKyksyouhnrenno());
        Assert.assertEquals(P_KYUUHUCD_01, jT_SiDetailLst.get(2).getKyuuhucd());
        Assert.assertEquals(P_RENNO_01, jT_SiDetailLst.get(2).getRenno());
        Assert.assertEquals(P_KYHKG_1_MANYEN, jT_SiDetailLst.get(2).getKyhkg());

        Assert.assertEquals(P_SKNO_01, jT_SiDetailLst.get(3).getSkno());
        Assert.assertEquals(P_SYONO_01, jT_SiDetailLst.get(3).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, jT_SiDetailLst.get(3).getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_03, jT_SiDetailLst.get(3).getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, jT_SiDetailLst.get(3).getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_06, jT_SiDetailLst.get(3).getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, jT_SiDetailLst.get(3).getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO_01, jT_SiDetailLst.get(3).getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_01, jT_SiDetailLst.get(3).getKyksyouhnrenno());
        Assert.assertEquals(P_KYUUHUCD_01, jT_SiDetailLst.get(3).getKyuuhucd());
        Assert.assertEquals(P_RENNO_01, jT_SiDetailLst.get(3).getRenno());
        Assert.assertEquals(P_KYHKG_1_AU_DOLLAR, jT_SiDetailLst.get(3).getKyhkg());

        Assert.assertEquals(P_SKNO_01, jT_SiDetailLst.get(4).getSkno());
        Assert.assertEquals(P_SYONO_01, jT_SiDetailLst.get(4).getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_01, jT_SiDetailLst.get(4).getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_03, jT_SiDetailLst.get(4).getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, jT_SiDetailLst.get(4).getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_07, jT_SiDetailLst.get(4).getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, jT_SiDetailLst.get(4).getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO_01, jT_SiDetailLst.get(4).getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_01, jT_SiDetailLst.get(4).getKyksyouhnrenno());
        Assert.assertEquals(P_KYUUHUCD_01, jT_SiDetailLst.get(4).getKyuuhucd());
        Assert.assertEquals(P_RENNO_01, jT_SiDetailLst.get(4).getRenno());
        Assert.assertEquals(P_KYHKG_1_EURO, jT_SiDetailLst.get(4).getKyhkg());
    }
}
