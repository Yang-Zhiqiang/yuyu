package yuyu.def.siharai.manager;

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

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.result.bean.SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","イイ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(0,BeanLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon("ASD121", "11807111141");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon1.setHhknnmkn("エイイエ");

        JT_Sk sk1 = skKihon1.createSk();
        sk1.setSeikyuurirekino(5);
        sk1.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("ASD121", "11807111118");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon2.setHhknnmkn("エイイエ");

        JT_Sk sk2 = skKihon2.createSk();
        sk2.setSeikyuurirekino(5);
        sk2.setSyoruiukeymd(BizDate.valueOf(20160219));

        JT_Sk sk3 = skKihon2.createSk();
        sk3.setSeikyuurirekino(9);
        sk3.setSyoruiukeymd(BizDate.valueOf(20160219));

        JT_Sk sk4 = skKihon2.createSk();
        sk4.setSeikyuurirekino(1);
        sk4.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("ASD125", "11807111118");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon3.setHhknnmkn("イエエイ");

        JT_Sk sk5 = skKihon3.createSk();
        sk5.setSeikyuurirekino(1);
        sk5.setSyoruiukeymd(BizDate.valueOf(20160218));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("ASD127", "11807111118");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon4.setHhknnmkn("イ");

        JT_Sk sk6 = skKihon4.createSk();
        sk6.setSeikyuurirekino(1);
        sk6.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("ASD128", "11807111118");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon5.setHhknnmkn("エ");

        JT_Sk sk7 = skKihon5.createSk();
        sk7.setSeikyuurirekino(1);
        sk7.setSyoruiukeymd(BizDate.valueOf(20160220));

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("ASD123", "11807111118");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon6.setHhknnmkn("イイイイ");

        JT_Sk sk8 = skKihon6.createSk();
        sk8.setSeikyuurirekino(1);
        sk8.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("ASD130", "11807111118");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon7.setHhknnmkn("イイイイ");

        JT_Sk sk9 = skKihon7.createSk();
        sk9.setSeikyuurirekino(1);
        sk9.setSyoruiukeymd(BizDate.valueOf(20160217));

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("ASD131", "11807111118");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon8.setHhknnmkn("イイイイ");

        JT_Sk sk10 = skKihon8.createSk();
        sk10.setSeikyuurirekino(1);
        sk10.setSyoruiukeymd(BizDate.valueOf(20160221));

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("ASD120", "11807111118");
        skKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon9.setHhknnmkn("エエエエ");

        JT_Sk sk11 = skKihon9.createSk();
        sk11.setSeikyuurirekino(1);
        sk11.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("ASD126", "11807111118");
        skKihon10.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon10.setHhknnmkn("オレラロ");

        JT_Sk sk12 = skKihon10.createSk();
        sk12.setSeikyuurirekino(1);
        sk12.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon10);

        JT_SkKihon skKihon11 = new JT_SkKihon("ASD124", "11807111118");
        skKihon11.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon11.setHhknnmkn("ハヘフホ");

        siharaiDomManager.insert(skKihon11);

        JT_SkKihon skKihon12 = new JT_SkKihon("ASD122", "11807111118");
        skKihon12.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("2"));
        skKihon12.setHhknnmkn("オレラロ");

        JT_Sk sk13 = skKihon12.createSk();
        sk13.setSeikyuurirekino(1);
        sk13.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon12);

        JT_SkKihon skKihon13 = new JT_SkKihon("ASD129", "11807111129");
        skKihon13.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon13.setHhknnmkn("オレラロ");

        JT_Sk sk14 = skKihon13.createSk();
        sk14.setSeikyuurirekino(1);
        sk14.setSyoruiukeymd(BizDate.valueOf(20160219));

        siharaiDomManager.insert(skKihon13);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111130","イイ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(0,BeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","レラ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(1,BeanLst.size());
        Assert.assertEquals("ASD126", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD126", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","イイ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(2,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(40)
    public void normal3(){

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","イ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(4,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());

        Assert.assertEquals("ASD125", BeanLst.get(2).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(2).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160218), BeanLst.get(2).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD125", BeanLst.get(2).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSkKihon().getSyono());

        Assert.assertEquals("ASD127", BeanLst.get(3).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(3).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(3).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(3).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD127", BeanLst.get(3).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(3).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(50)
    public void blank1() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "","イイ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(3,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());

        Assert.assertEquals("ASD121", BeanLst.get(2).getSk().getSkno());
        Assert.assertEquals("11807111141", BeanLst.get(2).getSk().getSyono());
        Assert.assertEquals(5, BeanLst.get(2).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(2).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(2).getSkKihon().getSkno());
        Assert.assertEquals("11807111141", BeanLst.get(2).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(60)
    public void blank2() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        null,"イイ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(3,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());

        Assert.assertEquals("ASD121", BeanLst.get(2).getSk().getSkno());
        Assert.assertEquals("11807111141", BeanLst.get(2).getSk().getSyono());
        Assert.assertEquals(5, BeanLst.get(2).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(2).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(2).getSkKihon().getSkno());
        Assert.assertEquals("11807111141", BeanLst.get(2).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(70)
    public void blank3() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(7,BeanLst.size());
        Assert.assertEquals("ASD120", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD120", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD121", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(2).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(2).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(2).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(2).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSkKihon().getSyono());

        Assert.assertEquals("ASD125", BeanLst.get(3).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(3).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(3).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160218), BeanLst.get(3).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD125", BeanLst.get(3).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(3).getSkKihon().getSyono());

        Assert.assertEquals("ASD126", BeanLst.get(4).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(4).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(4).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(4).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD126", BeanLst.get(4).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(4).getSkKihon().getSyono());

        Assert.assertEquals("ASD127", BeanLst.get(5).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(5).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(5).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(5).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD127", BeanLst.get(5).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(5).getSkKihon().getSyono());

        Assert.assertEquals("ASD128", BeanLst.get(6).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(6).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(6).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160220), BeanLst.get(6).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD128", BeanLst.get(6).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(6).getSkKihon().getSyono());
    }
    @Test
    @TestOrder(80)
    public void blank4() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118",null,C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(7,BeanLst.size());
        Assert.assertEquals("ASD120", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD120", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD121", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(2).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(2).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(2).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(2).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSkKihon().getSyono());

        Assert.assertEquals("ASD125", BeanLst.get(3).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(3).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(3).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160218), BeanLst.get(3).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD125", BeanLst.get(3).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(3).getSkKihon().getSyono());

        Assert.assertEquals("ASD126", BeanLst.get(4).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(4).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(4).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(4).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD126", BeanLst.get(4).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(4).getSkKihon().getSyono());

        Assert.assertEquals("ASD127", BeanLst.get(5).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(5).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(5).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(5).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD127", BeanLst.get(5).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(5).getSkKihon().getSyono());

        Assert.assertEquals("ASD128", BeanLst.get(6).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(6).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(6).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160220), BeanLst.get(6).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD128", BeanLst.get(6).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(6).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(90)
    public void blank5() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","イイ",null,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(2,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(100)
    public void blank6() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","イイ",C_SeikyuuSyubetu.BLNK,BizDate.valueOf(20160218),BizDate.valueOf(20160220));

        Assert.assertEquals(2,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(110)
    public void blank7() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","イイ",C_SeikyuuSyubetu.KYH,null,BizDate.valueOf(20160220));

        Assert.assertEquals(3,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());

        Assert.assertEquals("ASD130", BeanLst.get(2).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(2).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160217), BeanLst.get(2).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD130", BeanLst.get(2).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(120)
    public void blank8() {

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","イイ",C_SeikyuuSyubetu.KYH,BizDate.valueOf(20160218),null);

        Assert.assertEquals(3,BeanLst.size());
        Assert.assertEquals("ASD121", BeanLst.get(0).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSk().getSyono());
        Assert.assertEquals(9, BeanLst.get(0).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(0).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD121", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(1).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160219), BeanLst.get(1).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD123", BeanLst.get(1).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(1).getSkKihon().getSyono());

        Assert.assertEquals("ASD131", BeanLst.get(2).getSk().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSk().getSyono());
        Assert.assertEquals(1, BeanLst.get(2).getSk().getSeikyuurirekino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160221), BeanLst.get(2).getSk().getSyoruiukeymd());

        Assert.assertEquals("ASD131", BeanLst.get(2).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(2).getSkKihon().getSyono());
    }

    @Test
    @TestOrder(130)
    public void normal4(){

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> BeanLst =
                siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
                        "11807111118","ヘフ",C_SeikyuuSyubetu.KYH,null,null);

        Assert.assertEquals(1,BeanLst.size());

        Assert.assertEquals(null, BeanLst.get(0).getSk());

        Assert.assertEquals("ASD124", BeanLst.get(0).getSkKihon().getSkno());
        Assert.assertEquals("11807111118", BeanLst.get(0).getSkKihon().getSyono());
    }
}
