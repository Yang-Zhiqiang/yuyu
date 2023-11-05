package yuyu.def.siharai.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsByHhknnmknTorikesiflg {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SkKihon> skKihon = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg("ナナ");
        Assert.assertEquals(0, skKihon.size());

        JT_SkKihon skKihon1 = new JT_SkKihon("1000000001", "11807111118");
        skKihon1.setHhknnmkn("リナリ");

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("201520161001");
        siRireki1.setSeikyuurirekino(111);
        siRireki1.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk1 = skKihon1.createSk();
        sk1.setSeikyuurirekino(111);

        JT_Sk sk11 = skKihon1.createSk();
        sk11.setSeikyuurirekino(118);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("1000000001", "11807111129");
        skKihon2.setHhknnmkn("ナリナ");

        JT_SiRireki siRireki2 = skKihon2.createSiRireki();
        siRireki2.setShrsikibetukey("201520161001");
        siRireki2.setSeikyuurirekino(112);
        siRireki2.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk2 = skKihon2.createSk();
        sk2.setSeikyuurirekino(112);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("1000000001", "11807111130");
        skKihon3.setHhknnmkn("ナ");

        JT_SiRireki siRireki3 = skKihon3.createSiRireki();
        siRireki3.setShrsikibetukey("201520161001");
        siRireki3.setSeikyuurirekino(113);
        siRireki3.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk3 = skKihon3.createSk();
        sk3.setSeikyuurirekino(113);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("1000000001", "11807111141");
        skKihon4.setHhknnmkn("リ");

        JT_SiRireki siRireki4 = skKihon4.createSiRireki();
        siRireki4.setShrsikibetukey("201520161001");
        siRireki4.setSeikyuurirekino(114);
        siRireki4.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk4 = skKihon4.createSk();
        sk4.setSeikyuurirekino(114);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("1000000001", "11807111152");
        skKihon5.setHhknnmkn("ナナナ");

        JT_SiRireki siRireki5 = skKihon5.createSiRireki();
        siRireki5.setShrsikibetukey("201520161001");
        siRireki5.setSeikyuurirekino(115);
        siRireki5.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk5 = skKihon5.createSk();
        sk5.setSeikyuurirekino(115);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("1000000001", "11807111163");
        skKihon6.setHhknnmkn("リリリ");

        JT_SiRireki siRireki6 = skKihon6.createSiRireki();
        siRireki6.setShrsikibetukey("201520161001");
        siRireki6.setSeikyuurirekino(116);
        siRireki6.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk6 = skKihon6.createSk();
        sk6.setSeikyuurirekino(116);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("1000000001", "11807111174");
        skKihon7.setHhknnmkn("タマコ");

        JT_SiRireki siRireki7 = skKihon7.createSiRireki();
        siRireki7.setShrsikibetukey("201520161001");
        siRireki7.setSeikyuurirekino(117);
        siRireki7.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk7 = skKihon7.createSk();
        sk7.setSeikyuurirekino(117);

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("1000000002", "11807111152");
        skKihon8.setHhknnmkn("ナナナ");

        JT_SiRireki siRireki8 = skKihon8.createSiRireki();
        siRireki8.setShrsikibetukey("201520161001");
        siRireki8.setSeikyuurirekino(111);
        siRireki8.setTorikesiflg(C_UmuKbn.ARI);

        JT_Sk sk8 = skKihon8.createSk();
        sk8.setSeikyuurirekino(111);

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("1000000001", "11807111185");
        skKihon9.setHhknnmkn("ナナナ");

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("1000000003", "11807111152");
        skKihon10.setHhknnmkn("ナナナ");

        siharaiDomManager.insert(skKihon10);

        JT_SkKihon skKihon11 = new JT_SkKihon("1000000001", "11807111196");
        skKihon11.setHhknnmkn("ナナナ");

        JT_SiRireki siRireki9 = skKihon11.createSiRireki();
        siRireki9.setShrsikibetukey("201520161001");
        siRireki9.setSeikyuurirekino(111);
        siRireki9.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon11);

        JT_SkKihon skKihon12 = new JT_SkKihon("1000000003", "11807111196");
        skKihon12.setHhknnmkn("ナナナ");

        JT_Sk sk9 = skKihon12.createSk();
        sk9.setSeikyuurirekino(111);

        siharaiDomManager.insert(skKihon12);

        JT_SkKihon skKihon13 = new JT_SkKihon("1000000001", "11807111200");
        skKihon13.setHhknnmkn("ナナナ");

        JT_Sk sk10 = skKihon13.createSk();
        sk10.setSeikyuurirekino(111);

        siharaiDomManager.insert(skKihon13);

        JT_SkKihon skKihon14 = new JT_SkKihon("1000000001", "11807111392");
        skKihon14.setHhknnmkn("申込書");

        JT_SiRireki siRireki10 = skKihon14.createSiRireki();
        siRireki10.setShrsikibetukey("201520161001");
        siRireki10.setSeikyuurirekino(111);
        siRireki10.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk12 = skKihon14.createSk();
        sk12.setSeikyuurirekino(111);

        siharaiDomManager.insert(skKihon14);

        JT_SkKihon skKihon15 = new JT_SkKihon("1000000001", "10807111117");
        skKihon15.setHhknnmkn("");

        JT_SiRireki siRireki11 = skKihon15.createSiRireki();
        siRireki11.setShrsikibetukey("201520161001");
        siRireki11.setSeikyuurirekino(111);
        siRireki11.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk13 = skKihon15.createSk();
        sk13.setSeikyuurirekino(111);

        siharaiDomManager.insert(skKihon15);

        JT_SkKihon skKihon16 = new JT_SkKihon("1000000001", "10807111128");
        skKihon16.setHhknnmkn(null);

        JT_SiRireki siRireki12 = skKihon16.createSiRireki();
        siRireki12.setShrsikibetukey("201520161001");
        siRireki12.setSeikyuurirekino(111);
        siRireki12.setTorikesiflg(C_UmuKbn.NONE);

        JT_Sk sk14 = skKihon16.createSk();
        sk14.setSeikyuurirekino(111);

        siharaiDomManager.insert(skKihon16);
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
        List<JT_SkKihon> skKihon = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg("ア");
        Assert.assertEquals(0, skKihon.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<JT_SkKihon> skKihon = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg("ナナ");
        Assert.assertEquals(1, skKihon.size());
        Assert.assertEquals("1000000001", skKihon.get(0).getSkno());
        Assert.assertEquals("11807111152", skKihon.get(0).getSyono());

        List<JT_SkKihon> skKihon1 = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg("マ");
        Assert.assertEquals(1, skKihon1.size());
        Assert.assertEquals("1000000001", skKihon1.get(0).getSkno());
        Assert.assertEquals("11807111174", skKihon1.get(0).getSyono());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<JT_SkKihon> skKihon = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg("ナ");
        Assert.assertEquals(4, skKihon.size());
        Assert.assertEquals("1000000001", skKihon.get(0).getSkno());
        Assert.assertEquals("11807111130", skKihon.get(0).getSyono());

        Assert.assertEquals("1000000001", skKihon.get(1).getSkno());
        Assert.assertEquals("11807111152", skKihon.get(1).getSyono());

        Assert.assertEquals("1000000001", skKihon.get(2).getSkno());
        Assert.assertEquals("11807111129", skKihon.get(2).getSyono());

        Assert.assertEquals("1000000001", skKihon.get(3).getSkno());
        Assert.assertEquals("11807111118", skKihon.get(3).getSyono());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<JT_SkKihon> skKihon = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg("");
        Assert.assertEquals(10, skKihon.size());

        Assert.assertEquals("1000000001", skKihon.get(0).getSkno());
        Assert.assertEquals("10807111117", skKihon.get(0).getSyono());
        Assert.assertEquals("", skKihon.get(0).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(1).getSkno());
        Assert.assertEquals("11807111174", skKihon.get(1).getSyono());
        Assert.assertEquals("タマコ", skKihon.get(1).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(2).getSkno());
        Assert.assertEquals("11807111130", skKihon.get(2).getSyono());
        Assert.assertEquals("ナ", skKihon.get(2).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(3).getSkno());
        Assert.assertEquals("11807111152", skKihon.get(3).getSyono());
        Assert.assertEquals("ナナナ", skKihon.get(3).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(4).getSkno());
        Assert.assertEquals("11807111129", skKihon.get(4).getSyono());
        Assert.assertEquals("ナリナ", skKihon.get(4).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(5).getSkno());
        Assert.assertEquals("11807111141", skKihon.get(5).getSyono());
        Assert.assertEquals("リ", skKihon.get(5).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(6).getSkno());
        Assert.assertEquals("11807111118", skKihon.get(6).getSyono());
        Assert.assertEquals("リナリ", skKihon.get(6).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(7).getSkno());
        Assert.assertEquals("11807111163", skKihon.get(7).getSyono());
        Assert.assertEquals("リリリ", skKihon.get(7).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(8).getSkno());
        Assert.assertEquals("11807111392", skKihon.get(8).getSyono());
        Assert.assertEquals("申込書", skKihon.get(8).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(9).getSkno());
        Assert.assertEquals("10807111128", skKihon.get(9).getSyono());
        Assert.assertEquals(null, skKihon.get(9).getHhknnmkn());
    }

    @Test
    @TestOrder(50)
    public void nullCondition1() {
        List<JT_SkKihon> skKihon = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg(null);
        Assert.assertEquals(10, skKihon.size());

        Assert.assertEquals("1000000001", skKihon.get(0).getSkno());
        Assert.assertEquals("10807111117", skKihon.get(0).getSyono());
        Assert.assertEquals("", skKihon.get(0).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(1).getSkno());
        Assert.assertEquals("11807111174", skKihon.get(1).getSyono());
        Assert.assertEquals("タマコ", skKihon.get(1).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(2).getSkno());
        Assert.assertEquals("11807111130", skKihon.get(2).getSyono());
        Assert.assertEquals("ナ", skKihon.get(2).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(3).getSkno());
        Assert.assertEquals("11807111152", skKihon.get(3).getSyono());
        Assert.assertEquals("ナナナ", skKihon.get(3).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(4).getSkno());
        Assert.assertEquals("11807111129", skKihon.get(4).getSyono());
        Assert.assertEquals("ナリナ", skKihon.get(4).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(5).getSkno());
        Assert.assertEquals("11807111141", skKihon.get(5).getSyono());
        Assert.assertEquals("リ", skKihon.get(5).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(6).getSkno());
        Assert.assertEquals("11807111118", skKihon.get(6).getSyono());
        Assert.assertEquals("リナリ", skKihon.get(6).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(7).getSkno());
        Assert.assertEquals("11807111163", skKihon.get(7).getSyono());
        Assert.assertEquals("リリリ", skKihon.get(7).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(8).getSkno());
        Assert.assertEquals("11807111392", skKihon.get(8).getSyono());
        Assert.assertEquals("申込書", skKihon.get(8).getHhknnmkn());

        Assert.assertEquals("1000000001", skKihon.get(9).getSkno());
        Assert.assertEquals("10807111128", skKihon.get(9).getSyono());
        Assert.assertEquals(null, skKihon.get(9).getHhknnmkn());
    }
}