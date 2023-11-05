package yuyu.def.siharai.manager;

import static org.junit.Assert.*;

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
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiDetailsBySknoSyonoSeikyuurirekino() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiDetailsBySknoSyonoSeikyuurirekino {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "11807111129", 10);

        Assert.assertEquals(0,siDetailLst.size());


        JT_SkKihon skKihon1 = new JT_SkKihon("skno001", "11807111129");

        JT_Sk sk1 = skKihon1.createSk();
        sk1.setSeikyuurirekino(10);

        JT_SkJiyuu skJiyuu1 = sk1.createSkJiyuu();
        skJiyuu1.setUketukeno(2);

        JT_SiDetail siDetail1 = skJiyuu1.createSiDetail();
        siDetail1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail1.setSyouhncd("200");
        siDetail1.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail1.setSyouhnsdno(1);
        siDetail1.setKyksyouhnrenno(2);
        siDetail1.setKyuuhucd("100");
        siDetail1.setRenno(3);
        siDetail1.setKyhkg(BizCurrency.valueOf(1,BizCurrencyTypes.YEN));

        JT_SkJiyuu skJiyuu8 = sk1.createSkJiyuu();
        skJiyuu8.setUketukeno(3);

        JT_SiDetail siDetail5 = skJiyuu8.createSiDetail();
        siDetail5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail5.setSyouhncd("200");
        siDetail5.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail5.setSyouhnsdno(1);
        siDetail5.setKyksyouhnrenno(2);
        siDetail5.setKyuuhucd("100");
        siDetail5.setRenno(3);
        siDetail5.setKyhkg(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        JT_SkJiyuu skJiyuu9 = sk1.createSkJiyuu();
        skJiyuu9.setUketukeno(4);

        JT_SiDetail siDetail6 = skJiyuu9.createSiDetail();
        siDetail6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail6.setSyouhncd("200");
        siDetail6.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail6.setSyouhnsdno(1);
        siDetail6.setKyksyouhnrenno(2);
        siDetail6.setKyuuhucd("100");
        siDetail6.setRenno(3);
        siDetail6.setKyhkg(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));

        JT_Sk sk2 = skKihon1.createSk();
        sk2.setSeikyuurirekino(30);

        JT_SkJiyuu skJiyuu2 = sk2.createSkJiyuu();
        skJiyuu2.setUketukeno(2);

        JT_SiDetail siDetail2 = skJiyuu2.createSiDetail();
        siDetail2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail2.setSyouhncd("200");
        siDetail2.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail2.setSyouhnsdno(1);
        siDetail2.setKyksyouhnrenno(2);
        siDetail2.setKyuuhucd("100");
        siDetail2.setRenno(3);
        siDetail2.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("skno001", "11807111130");

        JT_Sk sk3 = skKihon2.createSk();
        sk3.setSeikyuurirekino(10);

        JT_SkJiyuu skJiyuu3 = sk3.createSkJiyuu();
        skJiyuu3.setUketukeno(2);

        JT_SiDetail siDetail3 = skJiyuu3.createSiDetail();
        siDetail3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail3.setSyouhncd("200");
        siDetail3.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail3.setSyouhnsdno(1);
        siDetail3.setKyksyouhnrenno(2);
        siDetail3.setKyuuhucd("100");
        siDetail3.setRenno(3);
        siDetail3.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("skno002", "11807111129");

        JT_Sk sk4 = skKihon3.createSk();
        sk4.setSeikyuurirekino(10);

        JT_SkJiyuu skJiyuu4 = sk4.createSkJiyuu();
        skJiyuu4.setUketukeno(2);

        JT_SiDetail siDetail4 = skJiyuu4.createSiDetail();
        siDetail4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail4.setSyouhncd("200");
        siDetail4.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail4.setSyouhnsdno(1);
        siDetail4.setKyksyouhnrenno(2);
        siDetail4.setKyuuhucd("100");
        siDetail4.setRenno(3);
        siDetail4.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("skno001", "11807111118");

        JT_Sk sk5 = skKihon4.createSk();
        sk5.setSeikyuurirekino(10);

        JT_SkJiyuu skJiyuu5 = sk5.createSkJiyuu();
        skJiyuu5.setUketukeno(6);

        JT_SiDetail siDetail7 = skJiyuu5.createSiDetail();
        siDetail7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail7.setSyouhncd("200");
        siDetail7.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail7.setSyouhnsdno(1);
        siDetail7.setKyksyouhnrenno(2);
        siDetail7.setKyuuhucd("100");
        siDetail7.setRenno(3);
        siDetail7.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        JT_SkJiyuu skJiyuu6 = sk5.createSkJiyuu();
        skJiyuu6.setUketukeno(5);

        JT_SiDetail siDetail8 = skJiyuu6.createSiDetail();
        siDetail8.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail8.setSyouhncd("200");
        siDetail8.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail8.setSyouhnsdno(1);
        siDetail8.setKyksyouhnrenno(2);
        siDetail8.setKyuuhucd("100");
        siDetail8.setRenno(1);
        siDetail8.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.MANYEN));

        JT_SkJiyuu skJiyuu7 = sk5.createSkJiyuu();
        skJiyuu7.setUketukeno(4);

        JT_SiDetail siDetail9 = skJiyuu7.createSiDetail();
        siDetail9.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail9.setSyouhncd("200");
        siDetail9.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail9.setSyouhnsdno(1);
        siDetail9.setKyksyouhnrenno(2);
        siDetail9.setKyuuhucd("100");
        siDetail9.setRenno(3);
        siDetail9.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        JT_SiDetail siDetail10 = skJiyuu7.createSiDetail();
        siDetail10.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail10.setSyouhncd("200");
        siDetail10.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail10.setSyouhnsdno(1);
        siDetail10.setKyksyouhnrenno(2);
        siDetail10.setKyuuhucd("100");
        siDetail10.setRenno(2);
        siDetail10.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));

        JT_SiDetail siDetail11 = skJiyuu7.createSiDetail();
        siDetail11.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        siDetail11.setSyouhncd("200");
        siDetail11.setKyhgndkatakbn(C_KyhgndkataKbn.valueOf("1"));
        siDetail11.setSyouhnsdno(1);
        siDetail11.setKyksyouhnrenno(2);
        siDetail11.setKyuuhucd("100");
        siDetail11.setRenno(1);
        siDetail11.setKyhkg(BizCurrency.valueOf(1, BizCurrencyTypes.EURO));

        siharaiDomManager.insert(skKihon4);



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

        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno100", "11807111129", 10);

        Assert.assertEquals(0,siDetailLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "11807111129", 10);

        Assert.assertEquals(1,siDetailLst.size());

        assertEquals("skno001", siDetailLst.get(0).getSkno());
        assertEquals("11807111129", siDetailLst.get(0).getSyono());
        assertEquals(Integer.valueOf(10), siDetailLst.get(0).getSeikyuurirekino());
        assertEquals(Integer.valueOf(2), siDetailLst.get(0).getUketukeno());
        assertEquals(C_SyutkKbn.valueOf("1"), siDetailLst.get(0).getSyutkkbn());
        assertEquals( "200", siDetailLst.get(0).getSyouhncd());
        assertEquals( C_KyhgndkataKbn.valueOf("1"), siDetailLst.get(0).getKyhgndkatakbn());
        assertEquals( Integer.valueOf(1), siDetailLst.get(0).getSyouhnsdno());
        assertEquals( Integer.valueOf(2), siDetailLst.get(0).getKyksyouhnrenno());
        assertEquals( "100", siDetailLst.get(0).getKyuuhucd());
        assertEquals( Integer.valueOf(3), siDetailLst.get(0).getRenno());

    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "11807111118", 10);

        Assert.assertEquals(5,siDetailLst.size());

        assertEquals("skno001", siDetailLst.get(0).getSkno());
        assertEquals("11807111118", siDetailLst.get(0).getSyono());
        assertEquals(Integer.valueOf(10), siDetailLst.get(0).getSeikyuurirekino());
        assertEquals(Integer.valueOf(4), siDetailLst.get(0).getUketukeno());
        assertEquals(C_SyutkKbn.valueOf("1"), siDetailLst.get(0).getSyutkkbn());
        assertEquals( "200", siDetailLst.get(0).getSyouhncd());
        assertEquals( C_KyhgndkataKbn.valueOf("1"), siDetailLst.get(0).getKyhgndkatakbn());
        assertEquals( Integer.valueOf(1), siDetailLst.get(0).getSyouhnsdno());
        assertEquals( Integer.valueOf(2), siDetailLst.get(0).getKyksyouhnrenno());
        assertEquals( "100", siDetailLst.get(0).getKyuuhucd());
        assertEquals( Integer.valueOf(1), siDetailLst.get(0).getRenno());

        assertEquals("skno001", siDetailLst.get(1).getSkno());
        assertEquals("11807111118", siDetailLst.get(1).getSyono());
        assertEquals(Integer.valueOf(10), siDetailLst.get(1).getSeikyuurirekino());
        assertEquals(Integer.valueOf(4), siDetailLst.get(1).getUketukeno());
        assertEquals(C_SyutkKbn.valueOf("1"), siDetailLst.get(1).getSyutkkbn());
        assertEquals( "200", siDetailLst.get(1).getSyouhncd());
        assertEquals( C_KyhgndkataKbn.valueOf("1"), siDetailLst.get(1).getKyhgndkatakbn());
        assertEquals( Integer.valueOf(1), siDetailLst.get(1).getSyouhnsdno());
        assertEquals( Integer.valueOf(2), siDetailLst.get(1).getKyksyouhnrenno());
        assertEquals( "100", siDetailLst.get(1).getKyuuhucd());
        assertEquals( Integer.valueOf(2), siDetailLst.get(1).getRenno());

        assertEquals("skno001", siDetailLst.get(2).getSkno());
        assertEquals("11807111118", siDetailLst.get(2).getSyono());
        assertEquals(Integer.valueOf(10), siDetailLst.get(2).getSeikyuurirekino());
        assertEquals(Integer.valueOf(4), siDetailLst.get(2).getUketukeno());
        assertEquals(C_SyutkKbn.valueOf("1"), siDetailLst.get(2).getSyutkkbn());
        assertEquals( "200", siDetailLst.get(2).getSyouhncd());
        assertEquals( C_KyhgndkataKbn.valueOf("1"), siDetailLst.get(2).getKyhgndkatakbn());
        assertEquals( Integer.valueOf(1), siDetailLst.get(2).getSyouhnsdno());
        assertEquals( Integer.valueOf(2), siDetailLst.get(2).getKyksyouhnrenno());
        assertEquals( "100", siDetailLst.get(2).getKyuuhucd());
        assertEquals( Integer.valueOf(3), siDetailLst.get(2).getRenno());

        assertEquals("skno001", siDetailLst.get(3).getSkno());
        assertEquals("11807111118", siDetailLst.get(3).getSyono());
        assertEquals(Integer.valueOf(10), siDetailLst.get(3).getSeikyuurirekino());
        assertEquals(Integer.valueOf(5), siDetailLst.get(3).getUketukeno());
        assertEquals(C_SyutkKbn.valueOf("1"), siDetailLst.get(3).getSyutkkbn());
        assertEquals( "200", siDetailLst.get(3).getSyouhncd());
        assertEquals( C_KyhgndkataKbn.valueOf("1"), siDetailLst.get(3).getKyhgndkatakbn());
        assertEquals( Integer.valueOf(1), siDetailLst.get(3).getSyouhnsdno());
        assertEquals( Integer.valueOf(2), siDetailLst.get(3).getKyksyouhnrenno());
        assertEquals( "100", siDetailLst.get(3).getKyuuhucd());
        assertEquals( Integer.valueOf(1), siDetailLst.get(3).getRenno());

        assertEquals("skno001", siDetailLst.get(4).getSkno());
        assertEquals("11807111118", siDetailLst.get(4).getSyono());
        assertEquals(Integer.valueOf(10), siDetailLst.get(4).getSeikyuurirekino());
        assertEquals(Integer.valueOf(6), siDetailLst.get(4).getUketukeno());
        assertEquals(C_SyutkKbn.valueOf("1"), siDetailLst.get(4).getSyutkkbn());
        assertEquals( "200", siDetailLst.get(4).getSyouhncd());
        assertEquals( C_KyhgndkataKbn.valueOf("1"), siDetailLst.get(4).getKyhgndkatakbn());
        assertEquals( Integer.valueOf(1), siDetailLst.get(4).getSyouhnsdno());
        assertEquals( Integer.valueOf(2), siDetailLst.get(4).getKyksyouhnrenno());
        assertEquals( "100", siDetailLst.get(4).getKyuuhucd());
        assertEquals( Integer.valueOf(3), siDetailLst.get(4).getRenno());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("", "11807111129", 10);

        Assert.assertEquals(0,siDetailLst.size());
    }
    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "", 10);

        Assert.assertEquals(0,siDetailLst.size());
    }
}


