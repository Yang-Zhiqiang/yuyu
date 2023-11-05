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
public class SiharaiDomManagerTest_getSiRirekiSkKihonSksBySyonoTorikesiflg {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private final static String syono1 = "11807111118";
    private final static String syono2 = "11807111129";
    private final static String syono3 = "11807111130";

    private final static String skno1 = "SK00000001";
    private final static String skno2 = "SK00000002";

    private final static BizDate shrsyoriymd1 = BizDate.valueOf("20150628");
    private final static BizDate shrsyoriymd2 = BizDate.valueOf("20150629");
    private final static BizDate shrsyoriymd3 = BizDate.valueOf("20150630");


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<Object[]> objectLst = siharaiDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg(syono1, C_UmuKbn.NONE);
        Assert.assertEquals(0, objectLst.size());
        JT_SkKihon skKihon1 = siharaiDomManager.getSkKihon(skno1, syono1);
        if (skKihon1 == null) {
            skKihon1 = new JT_SkKihon(skno1, syono1);
            JT_Sk sk1 = skKihon1.createSk();
            sk1.setSeikyuurirekino(10);

            JT_SiRireki siRireki1 = skKihon1.createSiRireki();
            siRireki1.setShrsikibetukey("11");
            siRireki1.setSeikyuurirekino(Integer.valueOf(11));
            siRireki1.setTorikesiflg(C_UmuKbn.NONE);
            siRireki1.setShrsyoriymd(shrsyoriymd1);

            JT_SiRireki siRireki2 = skKihon1.createSiRireki();
            siRireki2.setShrsikibetukey("12");
            siRireki2.setSeikyuurirekino(Integer.valueOf(10));
            siRireki2.setTorikesiflg(C_UmuKbn.NONE);
            siRireki2.setShrsyoriymd(shrsyoriymd2);

            JT_SiRireki siRireki3 = skKihon1.createSiRireki();
            siRireki3.setShrsikibetukey("13");
            siRireki3.setSeikyuurirekino(Integer.valueOf(10));
            siRireki3.setTorikesiflg(C_UmuKbn.NONE);
            siRireki3.setShrsyoriymd(shrsyoriymd1);

            JT_SiRireki siRireki4 = skKihon1.createSiRireki();
            siRireki4.setShrsikibetukey("14");
            siRireki4.setSeikyuurirekino(Integer.valueOf(10));
            siRireki4.setTorikesiflg(C_UmuKbn.NONE);
            siRireki4.setShrsyoriymd(shrsyoriymd3);

            JT_SiRireki siRireki5 = skKihon1.createSiRireki();
            siRireki5.setShrsikibetukey("15");
            siRireki5.setSeikyuurirekino(Integer.valueOf(10));
            siRireki5.setTorikesiflg(C_UmuKbn.ARI);
            siRireki5.setShrsyoriymd(shrsyoriymd1);


            siharaiDomManager.insert(skKihon1);
        }

        JT_SkKihon skKihon2 = siharaiDomManager.getSkKihon(skno1, syono2);
        if (skKihon2 == null) {
            skKihon2 = new JT_SkKihon(skno1, syono2);
            JT_Sk sk1 = skKihon2.createSk();
            sk1.setSeikyuurirekino(10);
            JT_SiRireki siRireki1 = skKihon2.createSiRireki();
            siRireki1.setShrsikibetukey("11");
            siRireki1.setSeikyuurirekino(10);
            siRireki1.setTorikesiflg(C_UmuKbn.NONE);
            siRireki1.setShrsyoriymd(shrsyoriymd1);
            siharaiDomManager.insert(skKihon2);
        }

        JT_SkKihon skKihon3 = siharaiDomManager.getSkKihon(skno2, syono1);
        if (skKihon3 == null) {
            skKihon3 = new JT_SkKihon(skno2, syono1);
            JT_SiRireki siRireki1 = skKihon3.createSiRireki();
            siRireki1.setShrsikibetukey("14");
            siRireki1.setSeikyuurirekino(10);
            siRireki1.setTorikesiflg(C_UmuKbn.ARI);
            siRireki1.setShrsyoriymd(shrsyoriymd1);
            siharaiDomManager.insert(skKihon3);
        }

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
        List<Object[]> objectLst = siharaiDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg(syono3, C_UmuKbn.NONE);

        Assert.assertEquals(0, objectLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<Object[]> objectLst = siharaiDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg(syono1, C_UmuKbn.ARI);
        Assert.assertEquals(1, objectLst.size());

        JT_SiRireki siRireki  = (JT_SiRireki)objectLst.get(0)[0];
        Assert.assertEquals(skno1, siRireki.getSkno());
        Assert.assertEquals(syono1, siRireki.getSyono());
        Assert.assertEquals("15", siRireki.getShrsikibetukey());
        Assert.assertEquals(C_UmuKbn.ARI, siRireki.getTorikesiflg());

        JT_SkKihon skKihon  = (JT_SkKihon)objectLst.get(0)[1];
        Assert.assertEquals(skno1, skKihon.getSkno());
        Assert.assertEquals(syono1, skKihon.getSyono());

        JT_Sk sk  = (JT_Sk)objectLst.get(0)[2];
        Assert.assertEquals(skno1, sk.getSkno());
        Assert.assertEquals(syono1, sk.getSyono());
        Assert.assertEquals(Integer.valueOf(10), sk.getSeikyuurirekino());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<Object[]> objectLst = siharaiDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg(syono1, C_UmuKbn.NONE);
        Assert.assertEquals(3, objectLst.size());

        JT_SiRireki siRireki  = (JT_SiRireki)objectLst.get(0)[0];
        Assert.assertEquals(skno1, siRireki.getSkno());
        Assert.assertEquals(syono1, siRireki.getSyono());
        Assert.assertEquals("13", siRireki.getShrsikibetukey());
        Assert.assertEquals(C_UmuKbn.NONE, siRireki.getTorikesiflg());
        Assert.assertEquals(shrsyoriymd1, siRireki.getShrsyoriymd());

        JT_SiRireki siRireki1  = (JT_SiRireki)objectLst.get(1)[0];
        Assert.assertEquals(skno1, siRireki1.getSkno());
        Assert.assertEquals(syono1, siRireki1.getSyono());
        Assert.assertEquals("12", siRireki1.getShrsikibetukey());
        Assert.assertEquals(C_UmuKbn.NONE, siRireki1.getTorikesiflg());
        Assert.assertEquals(shrsyoriymd2, siRireki1.getShrsyoriymd());

        JT_SiRireki siRireki2  = (JT_SiRireki)objectLst.get(2)[0];
        Assert.assertEquals(skno1, siRireki2.getSkno());
        Assert.assertEquals(syono1, siRireki2.getSyono());
        Assert.assertEquals("14", siRireki2.getShrsikibetukey());
        Assert.assertEquals(C_UmuKbn.NONE, siRireki2.getTorikesiflg());
        Assert.assertEquals(shrsyoriymd3, siRireki2.getShrsyoriymd());

        JT_SkKihon skKihon  = (JT_SkKihon)objectLst.get(0)[1];
        Assert.assertEquals(skno1, skKihon.getSkno());
        Assert.assertEquals(syono1, skKihon.getSyono());

        JT_SkKihon skKihon1  = (JT_SkKihon)objectLst.get(1)[1];
        Assert.assertEquals(skno1, skKihon1.getSkno());
        Assert.assertEquals(syono1, skKihon1.getSyono());

        JT_SkKihon skKihon2  = (JT_SkKihon)objectLst.get(2)[1];
        Assert.assertEquals(skno1, skKihon2.getSkno());
        Assert.assertEquals(syono1, skKihon2.getSyono());

        JT_Sk sk  = (JT_Sk)objectLst.get(0)[2];
        Assert.assertEquals(skno1, sk.getSkno());
        Assert.assertEquals(syono1, sk.getSyono());
        Assert.assertEquals(Integer.valueOf(10), sk.getSeikyuurirekino());

        JT_Sk sk1  = (JT_Sk)objectLst.get(1)[2];
        Assert.assertEquals(skno1, sk1.getSkno());
        Assert.assertEquals(syono1, sk1.getSyono());
        Assert.assertEquals(Integer.valueOf(10), sk1.getSeikyuurirekino());

        JT_Sk sk2  = (JT_Sk)objectLst.get(2)[2];
        Assert.assertEquals(skno1, sk2.getSkno());
        Assert.assertEquals(syono1, sk2.getSyono());
        Assert.assertEquals(Integer.valueOf(10), sk2.getSeikyuurirekino());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<Object[]> objectLst = siharaiDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg("", C_UmuKbn.NONE);
        Assert.assertEquals(0, objectLst.size());
    }
}