package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

@RunWith(OrderedRunner.class)
public class HT_SkHubiDetailEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);


        String pMosno1 = "MOSNO000001";
        String pMosno2 = "MOSNO000002";
        String pMosno3 = "MOSNO000003";
        String pHubisikibetukey1 = "HBKEY000001";
        String pHubisikibetukey2 = "HBKEY000002";

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);
        HT_SkHubi hT_SkHubi1 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi1.setHubisikibetukey(pHubisikibetukey2);
        HT_SkHubiDetail hT_SkHubiDetail1 = hT_SkHubi1.createSkHubiDetail();
        hT_SkHubiDetail1.setRenno3keta(2);
        HT_SkHubiDetail hT_SkHubiDetail2 = hT_SkHubi1.createSkHubiDetail();
        hT_SkHubiDetail2.setRenno3keta(1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(pMosno2);
        HT_SkHubi hT_SkHubi2 = hT_SyoriCTL2.createSkHubi();
        hT_SkHubi2.setHubisikibetukey(pHubisikibetukey1);
        HT_SkHubiDetail hT_SkHubiDetail3 = hT_SkHubi2.createSkHubiDetail();
        hT_SkHubiDetail3.setRenno3keta(3);
        HT_SkHubiDetail hT_SkHubiDetail4 = hT_SkHubi2.createSkHubiDetail();
        hT_SkHubiDetail4.setRenno3keta(4);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(pMosno3);
        HT_SkHubi hT_SkHubi3 = hT_SyoriCTL3.createSkHubi();
        hT_SkHubi3.setHubisikibetukey(pHubisikibetukey1);
        HT_SkHubiDetail hT_SkHubiDetail5 = hT_SkHubi3.createSkHubiDetail();
        hT_SkHubiDetail5.setRenno3keta(3);
        hT_SkHubiDetail5.setGyoumuKousinsyaId("01");
        HT_SkHubiDetail hT_SkHubiDetail6 = hT_SkHubi3.createSkHubiDetail();
        hT_SkHubiDetail6.setRenno3keta(4);
        hT_SkHubiDetail6.setGyoumuKousinsyaId("02");
        HT_SkHubiDetail hT_SkHubiDetail7 = hT_SkHubi3.createSkHubiDetail();
        hT_SkHubiDetail7.setRenno3keta(1);
        hT_SkHubiDetail7.setGyoumuKousinsyaId("03");
        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

        //        String pSkhubikoumokucd1 = "01";
        //        String pSkhubinaiyoucd1 = "11";
        //        HM_SkHubiNaiyou hM_SkHubiNaiyou1 = sinkeiyakuDomManager.getSkHubiNaiyou(pSkhubikoumokucd1, pSkhubinaiyoucd1);
        //        sinkeiyakuDomManager.insert(hM_SkHubiNaiyou1);
        //
        //        String pSkhubikoumokucd2 = "02";
        //        String pSkhubinaiyoucd2 = "22";
        //        HM_SkHubiNaiyou hM_SkHubiNaiyou2 = sinkeiyakuDomManager.getSkHubiNaiyou(pSkhubikoumokucd2, pSkhubinaiyoucd2);
        //        sinkeiyakuDomManager.insert(hM_SkHubiNaiyou2);
        //
        //        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.USERITIRANHYOU;
        //        HM_SkHubiKoumoku hM_SkHubiKoumoku1 = sinkeiyakuDomManager.getSkHubiKoumoku(pSyoruiCd1, pSkhubikoumokucd1);
        //        sinkeiyakuDomManager.insert(hM_SkHubiKoumoku1);
        //
        //        C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.HK_KYH_SKS ;
        //        HM_SkHubiKoumoku hM_SkHubiKoumoku2 = sinkeiyakuDomManager.getSkHubiKoumoku(pSyoruiCd2, pSkhubikoumokucd2);
        //        sinkeiyakuDomManager.insert(hM_SkHubiKoumoku2);
        //
        //        String pSkseibisijinaiyoucd1 = "01";
        //        HM_SkSeibiSijiNaiyou hM_SkSeibiSijiNaiyou1 = sinkeiyakuDomManager.getSkSeibiSijiNaiyou(pSkseibisijinaiyoucd1);
        //
        //        sinkeiyakuDomManager.insert(hM_SkSeibiSijiNaiyou1);
        //
        //        String pSkseibisijinaiyoucd2 = "02";
        //        HM_SkSeibiSijiNaiyou hM_SkSeibiSijiNaiyou2 = sinkeiyakuDomManager.getSkSeibiSijiNaiyou(pSkseibisijinaiyoucd2);
        //
        //        sinkeiyakuDomManager.insert(hM_SkSeibiSijiNaiyou2);

        String pUserId1 = "01";
        String pUserNm1 = "ユーザー１";
        String pPassword1 = "psw001";
        AM_User aM_User1 = new AM_User();
        aM_User1.setUserId(pUserId1);
        aM_User1.setUserNm(pUserNm1);
        aM_User1.setPassword(pPassword1);
        baseDomManager.insert(aM_User1);

        String pUserId2 = "02";
        String pUserNm2 = "ユーザー２";
        String pPassword2 = "psw002";
        AM_User aM_User2 = new AM_User();
        aM_User2.setUserId(pUserId2);
        aM_User2.setUserNm(pUserNm2);
        aM_User2.setPassword(pPassword2);
        baseDomManager.insert(aM_User2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiNaiyou());
        //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiKoumoku());
        //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkSeibiSijiNaiyou());
        baseDomManager.delete(baseDomManager.getAllUsers());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getSkHubi() {

        String pMosno1 = "MOSNO000001";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_SkHubi> hT_SkHubis1 = hT_SyoriCTL.getSkHubis();
        List<HT_SkHubiDetail> hT_SkHubiDetails1 = hT_SkHubis1.get(0).getSkHubiDetails();

        HT_SkHubiDetail hT_SkHubiDetail1 = hT_SkHubiDetails1.get(0);

        Assert.assertEquals(hT_SkHubis1.get(0), hT_SkHubiDetail1.getSkHubi());
    }

    @Test
    @TestOrder(70)
    public void getSkHubiNaiyou() {

        //        String pHubisikibetukey1 = "HBKEY000001";
        //        HT_SkHubi hT_SkHubi1 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey1);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails1 = hT_SkHubi1.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail1 = hT_SkHubiDetails1.get(0);
        //
        //        HM_SkHubiNaiyou hM_SkHubiNaiyou1 = hT_SkHubiDetail1.getSkHubiNaiyou();
        //
        //        String pSkhubikoumokucd1 = "01";
        //        String pSkhubinaiyoucd1 = "00001";
        //
        //        Assert.assertEquals(pSkhubikoumokucd1, hM_SkHubiNaiyou1.getSkhubikoumokucd());
        //        Assert.assertEquals(pSkhubinaiyoucd1, hM_SkHubiNaiyou1.getSkhubinaiyoucd());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getSkHubiNaiyouNull01() {

        //        String pSkhubikoumokucd2 = "02";
        //        String pSkhubinaiyoucd2 = "00002";
        //
        //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getSkHubiNaiyou(pSkhubikoumokucd2, pSkhubinaiyoucd2));
    }

    @Test
    @TestOrder(90)
    public void getSkHubiNaiyouNull02() {

        //        String pHubisikibetukey2 = "HBKEY000002";
        //        HT_SkHubi hT_SkHubi2 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey2);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails2 = hT_SkHubi2.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail2 = hT_SkHubiDetails2.get(0);
        //
        //        HM_SkHubiNaiyou hM_SkHubiNaiyou2 = hT_SkHubiDetail2.getSkHubiNaiyou();
        //
        //        Assert.assertNull(hM_SkHubiNaiyou2);
    }

    @Test
    @TestOrder(100)
    public void getSkHubiNaiyouNull() {

        //        String pHubisikibetukey3 = "HBKEY000003";
        //        HT_SkHubi hT_SkHubi3 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey3);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails3 = hT_SkHubi3.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail3 = hT_SkHubiDetails3.get(0);
        //
        //        HM_SkHubiNaiyou hM_SkHubiNaiyou3 = hT_SkHubiDetail3.getSkHubiNaiyou();
        //
        //        Assert.assertNull(hM_SkHubiNaiyou3);
    }

    @Test
    @TestOrder(110)
    public void getSkHubiKoumoku() {

        //        String pHubisikibetukey1 = "HBKEY000001";
        //        HT_SkHubi hT_SkHubi1 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey1);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails1 = hT_SkHubi1.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail1 = hT_SkHubiDetails1.get(0);
        //
        //        HM_SkHubiKoumoku hM_SkHubiKoumoku1 = hT_SkHubiDetail1.getSkHubiKoumoku();
        //
        //        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.USERITIRANHYOU;
        //        String pSkhubikoumokucd1 = "01";
        //
        //        Assert.assertEquals(pSyoruiCd1, hM_SkHubiKoumoku1.getSyoruiCd());
        //        Assert.assertEquals(pSkhubikoumokucd1, hM_SkHubiKoumoku1.getSkhubikoumokucd());
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void getSkHubiKoumokuNull01() {

        //        C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.HK_KYH_SKS;
        //        String pSkhubikoumokucd2 = "02";
        //
        //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getSkHubiKoumoku(pSyoruiCd2, pSkhubikoumokucd2));
    }

    @Test
    @TestOrder(130)
    public void getSkHubiKoumokuNull02() {

        //        String pHubisikibetukey2 = "HBKEY000002";
        //        HT_SkHubi hT_SkHubi2 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey2);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails2 = hT_SkHubi2.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail2 = hT_SkHubiDetails2.get(0);
        //
        //        HM_SkHubiKoumoku hM_SkHubiKoumoku2 = hT_SkHubiDetail2.getSkHubiKoumoku();
        //
        //        Assert.assertNull(hM_SkHubiKoumoku2);
    }

    @Test
    @TestOrder(140)
    public void getSkHubiKoumokuNull() {

        //        String pHubisikibetukey3 = "HBKEY000003";
        //        HT_SkHubi hT_SkHubi3 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey3);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails3 = hT_SkHubi3.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail3 = hT_SkHubiDetails3.get(0);
        //
        //        HM_SkHubiKoumoku hM_SkHubiKoumoku3 = hT_SkHubiDetail3.getSkHubiKoumoku();
        //
        //        Assert.assertNull(hM_SkHubiKoumoku3);
    }

    @Test
    @TestOrder(150)
    public void getSkSeibiSijiNaiyou() {

        //        String pHubisikibetukey1 = "HBKEY000001";
        //        HT_SkHubi hT_SkHubi1 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey1);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails1 = hT_SkHubi1.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail1 = hT_SkHubiDetails1.get(0);
        //        HM_SkSeibiSijiNaiyou hM_SkSeibiSijiNaiyou1 = hT_SkHubiDetail1.getSkSeibiSijiNaiyou();
        //
        //        String pSkseibisijinaiyoucd1 = "01";
        //
        //        Assert.assertEquals(pSkseibisijinaiyoucd1, hM_SkSeibiSijiNaiyou1.getSkseibisijinaiyoucd());

    }

    @Test
    @TestOrder(160)
    @Transactional
    public void getSkSeibiSijiNaiyouNull01() {

        //        String pSkseibisijinaiyoucd1 = "01";
        //
        //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getSkSeibiSijiNaiyou(pSkseibisijinaiyoucd1));
    }

    @Test
    @TestOrder(170)
    public void getSkSeibiSijiNaiyouNull02() {

        //        String pHubisikibetukey2 = "HBKEY000002";
        //        HT_SkHubi hT_SkHubi2 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey2);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails2 = hT_SkHubi2.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail2 = hT_SkHubiDetails2.get(0);
        //
        //        HM_SkSeibiSijiNaiyou hM_SkSeibiSijiNaiyou2 = hT_SkHubiDetail2.getSkSeibiSijiNaiyou();
        //
        //        Assert.assertNull(hM_SkSeibiSijiNaiyou2);
    }

    @Test
    @TestOrder(180)
    public void getSkSeibiSijiNaiyouNull() {

        //        String pHubisikibetukey3 = "HBKEY000003";
        //        HT_SkHubi hT_SkHubi3 = sinkeiyakuDomManager.getSkHubi(pHubisikibetukey3);
        //        List<HT_SkHubiDetail> hT_SkHubiDetails3 = hT_SkHubi3.getSkHubiDetails();
        //        HT_SkHubiDetail hT_SkHubiDetail3 = hT_SkHubiDetails3.get(0);
        //
        //        HM_SkSeibiSijiNaiyou hM_SkSeibiSijiNaiyou3 = hT_SkHubiDetail3.getSkSeibiSijiNaiyou();
        //
        //        Assert.assertNull(hM_SkSeibiSijiNaiyou3);
    }

    @Test
    @TestOrder(190)
    public void getUser() {

        String pUserId1 = "01";
        String pUserId2 = "02";
        String pMosno3 = "MOSNO000003";

        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_SkHubi> hT_SkHubis1 = hT_SyoriCTL1.getSkHubis();
        List<HT_SkHubiDetail> hT_SkHubiDetails1 = hT_SkHubis1.get(0).getSkHubiDetails();
        Assert.assertEquals(baseDomManager.getUser(pUserId1), hT_SkHubiDetails1.get(1).getUser());
        Assert.assertEquals(baseDomManager.getUser(pUserId2), hT_SkHubiDetails1.get(2).getUser());
        Assert.assertEquals(null, hT_SkHubiDetails1.get(0).getUser());

    }

    @Test
    @TestOrder(200)
    @Transactional
    public void getUserNull01() {

        String pUserId2 = "02";

        baseDomManager.delete(baseDomManager.getUser(pUserId2));
    }

    @Test
    @TestOrder(210)
    public void getUserNull02() {

        String pUserId1 = "01";
        String pMosno3 = "MOSNO000003";

        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_SkHubi> hT_SkHubis1 = hT_SyoriCTL1.getSkHubis();
        List<HT_SkHubiDetail> hT_SkHubiDetails1 = hT_SkHubis1.get(0).getSkHubiDetails();
        Assert.assertEquals(baseDomManager.getUser(pUserId1), hT_SkHubiDetails1.get(1).getUser());
        Assert.assertEquals(null, hT_SkHubiDetails1.get(0).getUser());
        Assert.assertEquals(null, hT_SkHubiDetails1.get(2).getUser());
    }
}
