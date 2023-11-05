package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

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

import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 不備帳票ＰＤＦ作成<br />
 * 新契約不備詳細情報Beanリスト取得（不備識別キー）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd("1");

        Assert.assertEquals(0, skHubiDetailList.size());


        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("1");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(200);
        skHubiDetail1.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail1.setSkhubikoumokucd("20");
        skHubiDetail1.setSkhubinaiyoucd("00020");
        skHubiDetail1.setSkseibisijinaiyoucd("20");
        skHubiDetail1.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail1.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubi skHubi2 = syoriCTL1.createSkHubi();
        skHubi2.setHubisikibetukey("3");

        HT_SkHubiDetail skHubiDetail2 = skHubi2.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(200);
        skHubiDetail2.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail2.setSkhubikoumokucd("20");
        skHubiDetail2.setSkhubinaiyoucd("00020");
        skHubiDetail2.setSkseibisijinaiyoucd("20");
        skHubiDetail2.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail2.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_SkHubi skHubi3 = syoriCTL2.createSkHubi();
        skHubi3.setHubisikibetukey("2");

        HT_SkHubiDetail skHubiDetail3 = skHubi3.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(210);
        skHubiDetail3.setSyoruiCd(C_SyoruiCdKbn.NK_SISAN_ITJ);
        skHubiDetail3.setSkhubikoumokucd("20");
        skHubiDetail3.setSkhubinaiyoucd("00020");
        skHubiDetail3.setSkseibisijinaiyoucd("20");
        skHubiDetail3.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail3.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail4 = skHubi3.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(220);
        skHubiDetail4.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail4.setSkhubikoumokucd("21");
        skHubiDetail4.setSkhubinaiyoucd("00020");
        skHubiDetail4.setSkseibisijinaiyoucd("20");
        skHubiDetail4.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail4.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail5 = skHubi3.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(230);
        skHubiDetail5.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail5.setSkhubikoumokucd("20");
        skHubiDetail5.setSkhubinaiyoucd("00021");
        skHubiDetail5.setSkseibisijinaiyoucd("20");
        skHubiDetail5.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail5.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail6 = skHubi3.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(240);
        skHubiDetail6.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail6.setSkhubikoumokucd("20");
        skHubiDetail6.setSkhubinaiyoucd("00020");
        skHubiDetail6.setSkseibisijinaiyoucd("21");
        skHubiDetail6.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail6.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail7 = skHubi3.createSkHubiDetail();
        skHubiDetail7.setRenno3keta(250);
        skHubiDetail7.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail7.setSkhubikoumokucd("20");
        skHubiDetail7.setSkhubinaiyoucd("00020");
        skHubiDetail7.setSkseibisijinaiyoucd("20");
        skHubiDetail7.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail7.setHasinymd(BizDate.valueOf(20160317));
        skHubiDetail7.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail8 = skHubi3.createSkHubiDetail();
        skHubiDetail8.setRenno3keta(260);
        skHubiDetail8.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail8.setSkhubikoumokucd("20");
        skHubiDetail8.setSkhubinaiyoucd("00020");
        skHubiDetail8.setSkseibisijinaiyoucd("20");
        skHubiDetail8.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail8.setHasinkyokakbn(C_HasinkyokaKbn.BLNK);

        HT_SkHubiDetail skHubiDetail10 = skHubi3.createSkHubiDetail();
        skHubiDetail10.setRenno3keta(530);
        skHubiDetail10.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);
        skHubiDetail10.setSkhubikoumokucd("38");
        skHubiDetail10.setSkhubinaiyoucd("00038");
        skHubiDetail10.setSkseibisijinaiyoucd("38");
        skHubiDetail10.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail10.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail11 = skHubi3.createSkHubiDetail();
        skHubiDetail11.setRenno3keta(520);
        skHubiDetail11.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
        skHubiDetail11.setSkhubikoumokucd("46");
        skHubiDetail11.setSkhubinaiyoucd("00046");
        skHubiDetail11.setSkseibisijinaiyoucd("46");
        skHubiDetail11.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail11.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail12 = skHubi3.createSkHubiDetail();
        skHubiDetail12.setRenno3keta(510);
        skHubiDetail12.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        skHubiDetail12.setSkhubikoumokucd("53");
        skHubiDetail12.setSkhubinaiyoucd("00053");
        skHubiDetail12.setSkseibisijinaiyoucd("53");
        skHubiDetail12.setTyoubunflg(C_UmuKbn.ARI);
        skHubiDetail12.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_SkHubi skHubi4 = syoriCTL3.createSkHubi();
        skHubi4.setHubisikibetukey("2");

        HT_SkHubiDetail skHubiDetail9 = skHubi4.createSkHubiDetail();
        skHubiDetail9.setRenno3keta(530);
        skHubiDetail9.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);
        skHubiDetail9.setSkhubikoumokucd("38");
        skHubiDetail9.setSkhubinaiyoucd("00038");
        skHubiDetail9.setSkseibisijinaiyoucd("38");
        skHubiDetail9.setTyoubunflg(C_UmuKbn.NONE);
        skHubiDetail9.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HM_SkHubiKoumoku skHubiKoumoku1 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.USERITIRANHYOU, "46");
        skHubiKoumoku1.setSkhubikoumoku("sinnkeiyakuhubikoumoku3");

        sinkeiyakuDomManager.insert(skHubiKoumoku1);

        HM_SkHubiKoumoku skHubiKoumoku2 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.HK_SHRMESS, "53");
        skHubiKoumoku2.setSkhubikoumoku("sinnkeiyakuhubikoumoku4");

        sinkeiyakuDomManager.insert(skHubiKoumoku2);

        HM_SkHubiKoumoku skHubiKoumoku3 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.WF_HYOUSI, "20");
        skHubiKoumoku3.setSkhubikoumoku("sinnkeiyakuhubikoumoku1");

        sinkeiyakuDomManager.insert(skHubiKoumoku3);

        HM_SkHubiKoumoku skHubiKoumoku4 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.WF_QRSEAL, "38");
        skHubiKoumoku4.setSkhubikoumoku("sinnkeiyakuhubikoumoku2");

        sinkeiyakuDomManager.insert(skHubiKoumoku4);

        HM_SkHubiNaiyou skHubiNaiyou1 = new HM_SkHubiNaiyou("20", "00020");
        skHubiNaiyou1.setSkhubinaiyou("sinnkeiyakuhubinaiyou1");

        sinkeiyakuDomManager.insert(skHubiNaiyou1);

        HM_SkHubiNaiyou skHubiNaiyou2 = new HM_SkHubiNaiyou("38", "00038");
        skHubiNaiyou2.setSkhubinaiyou("sinnkeiyakuhubinaiyou2");

        sinkeiyakuDomManager.insert(skHubiNaiyou2);

        HM_SkHubiNaiyou skHubiNaiyou3 = new HM_SkHubiNaiyou("46", "00046");
        skHubiNaiyou3.setSkhubinaiyou("sinnkeiyakuhubinaiyou3");

        sinkeiyakuDomManager.insert(skHubiNaiyou3);

        HM_SkHubiNaiyou skHubiNaiyou4 = new HM_SkHubiNaiyou("53", "00053");
        skHubiNaiyou4.setSkhubinaiyou("sinnkeiyakuhubinaiyou4");

        sinkeiyakuDomManager.insert(skHubiNaiyou4);

        HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou1 = new HM_SkSeibiSijiNaiyou("20");
        skSeibiSijiNaiyou1.setSkseibisijinaiyou("skseibisijinaiyou1");

        sinkeiyakuDomManager.insert(skSeibiSijiNaiyou1);

        HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou2 = new HM_SkSeibiSijiNaiyou("38");
        skSeibiSijiNaiyou2.setSkseibisijinaiyou("skseibisijinaiyou2");

        sinkeiyakuDomManager.insert(skSeibiSijiNaiyou2);

        HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou3 = new HM_SkSeibiSijiNaiyou("46");
        skSeibiSijiNaiyou3.setSkseibisijinaiyou("skseibisijinaiyou3");

        sinkeiyakuDomManager.insert(skSeibiSijiNaiyou3);

        HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou4 = new HM_SkSeibiSijiNaiyou("53");
        skSeibiSijiNaiyou4.setSkseibisijinaiyou("skseibisijinaiyou4");

        sinkeiyakuDomManager.insert(skSeibiSijiNaiyou4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiKoumoku());

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiNaiyou());

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkSeibiSijiNaiyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd("4");

        Assert.assertEquals(0, skHubiDetailList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd("1");

        Assert.assertEquals(1, skHubiDetailList.size());

        Assert.assertEquals("791112220", skHubiDetailList.get(0).getMosno());
        Assert.assertEquals("1", skHubiDetailList.get(0).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(200), skHubiDetailList.get(0).getRenno3keta());
        Assert.assertEquals(C_UmuKbn.ARI, skHubiDetailList.get(0).getTyoubunflg());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd("2");

        Assert.assertEquals(4, skHubiDetailList.size());

        Assert.assertEquals("791112238", skHubiDetailList.get(0).getMosno());
        Assert.assertEquals("2", skHubiDetailList.get(0).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(510), skHubiDetailList.get(0).getRenno3keta());
        Assert.assertEquals(C_UmuKbn.ARI, skHubiDetailList.get(0).getTyoubunflg());

        Assert.assertEquals("791112238", skHubiDetailList.get(1).getMosno());
        Assert.assertEquals("2", skHubiDetailList.get(1).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(520), skHubiDetailList.get(1).getRenno3keta());
        Assert.assertEquals(C_UmuKbn.ARI, skHubiDetailList.get(1).getTyoubunflg());

        Assert.assertEquals("791112238", skHubiDetailList.get(2).getMosno());
        Assert.assertEquals("2", skHubiDetailList.get(2).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(530), skHubiDetailList.get(2).getRenno3keta());
        Assert.assertEquals(C_UmuKbn.ARI, skHubiDetailList.get(2).getTyoubunflg());

        Assert.assertEquals("791112246", skHubiDetailList.get(3).getMosno());
        Assert.assertEquals("2", skHubiDetailList.get(3).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(530), skHubiDetailList.get(3).getRenno3keta());
        Assert.assertEquals(C_UmuKbn.NONE, skHubiDetailList.get(3).getTyoubunflg());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd("");

        assertEquals(0, skHubiDetailList.size());
    }
}
