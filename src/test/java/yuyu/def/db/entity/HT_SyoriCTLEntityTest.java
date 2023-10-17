package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


/**
 * 処理コントロールテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SyoriCTLEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SyoriCTL> hT_SyoriCTLs = sinkeiyakuDomManager.getAllSyoriCTL();
        Assert.assertEquals(0, hT_SyoriCTLs.size());

        sinkeiyakuDomManager.insert(new HT_JigyouIkkatu ("1001"));
        sinkeiyakuDomManager.insert(new HT_JigyouIkkatu ("2001"));

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL("MOSNOD00001");



        hT_SyoriCTL.createMosKihon();

        hT_SyoriCTL.createKouzaJyouhou();

        hT_SyoriCTL.createCreditCardJyouhou();

        hT_SyoriCTL.createSkTtdkTyuuiKanri();

        HT_SkTtdkTyuui hT_SkTtdkTyuui = hT_SyoriCTL.createSkTtdkTyuui();
        hT_SkTtdkTyuui.setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO);
        hT_SkTtdkTyuui.setDatarenno(2);
        HT_SkTtdkTyuui hT_SkTtdkTyuui2 = hT_SyoriCTL.createSkTtdkTyuui();
        hT_SkTtdkTyuui2.setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);
        hT_SkTtdkTyuui2.setDatarenno(2);
        HT_SkTtdkTyuui hT_SkTtdkTyuui3 = hT_SyoriCTL.createSkTtdkTyuui();
        hT_SkTtdkTyuui3.setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO);
        hT_SkTtdkTyuui3.setDatarenno(1);

        HT_HubiMsg hT_HubiMsg = hT_SyoriCTL.createHubiMsg();
        hT_HubiMsg.setRenno(2);
        HT_HubiMsg hT_HubiMsg2 = hT_SyoriCTL.createHubiMsg();
        hT_HubiMsg2.setRenno(1);

        HT_HenteiRireki hT_HenteiRireki = hT_SyoriCTL.createHenteiRireki();
        hT_HenteiRireki.setRenno(2);
        HT_HenteiRireki hT_HenteiRireki2 = hT_SyoriCTL.createHenteiRireki();
        hT_HenteiRireki2.setRenno(1);

        HT_KmTsRireki hT_KmTsRireki = hT_SyoriCTL.createKmTsRireki();
        hT_KmTsRireki.setSyoriTime("20");
        hT_KmTsRireki.setRenno3keta(100);
        HT_KmTsRireki hT_KmTsRireki2 = hT_SyoriCTL.createKmTsRireki();
        hT_KmTsRireki2.setSyoriTime("10");
        hT_KmTsRireki2.setRenno3keta(200);
        HT_KmTsRireki hT_KmTsRireki3 = hT_SyoriCTL.createKmTsRireki();
        hT_KmTsRireki3.setSyoriTime("10");
        hT_KmTsRireki3.setRenno3keta(100);

        hT_SyoriCTL.createSkLincTourokuInfo();

        HT_UketoriKouzaJyouhou hT_UketoriKouzaJyouhou = hT_SyoriCTL.createUketoriKouzaJyouhou();
        hT_UketoriKouzaJyouhou.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
        HT_UketoriKouzaJyouhou hT_UketoriKouzaJyouhou2 = hT_SyoriCTL.createUketoriKouzaJyouhou();
        hT_UketoriKouzaJyouhou2.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.BLNK);

        HT_MosDairiten hT_MosDairiten = hT_SyoriCTL.createMosDairiten();
        hT_MosDairiten.setRenno(2);
        HT_MosDairiten hT_MosDairiten2 = hT_SyoriCTL.createMosDairiten();
        hT_MosDairiten2.setRenno(1);

        HT_Uketorinin hT_Uketorinin = hT_SyoriCTL.createUketorinin();
        hT_Uketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
        hT_Uketorinin.setUktsyurenno(2);
        HT_Uketorinin hT_Uketorinin2 = hT_SyoriCTL.createUketorinin();
        hT_Uketorinin2.setUktsyukbn(C_UktsyuKbn.BLNK);
        hT_Uketorinin2.setUktsyurenno(1);
        HT_Uketorinin hT_Uketorinin3 = hT_SyoriCTL.createUketorinin();
        hT_Uketorinin3.setUktsyukbn(C_UktsyuKbn.BLNK);
        hT_Uketorinin3.setUktsyurenno(2);

        HT_MosSyouhn hT_MosSyouhn = hT_SyoriCTL.createMosSyouhn();
        hT_MosSyouhn.setSyouhncd("C002");
        HT_MosSyouhn hT_MosSyouhn2 = hT_SyoriCTL.createMosSyouhn();
        hT_MosSyouhn2.setSyouhncd("C001");


        HT_Houjyou hT_Houjyou = hT_SyoriCTL.createHoujyou();
        hT_Houjyou.setSyosaikbn(C_SyosaiKbn.SAISIN);
        HT_Houjyou hT_Houjyou2 = hT_SyoriCTL.createHoujyou();
        hT_Houjyou2.setSyosaikbn(C_SyosaiKbn.SOYSIN);

        hT_SyoriCTL.createKokutisyo();

        hT_SyoriCTL.createTokujyou();

        HT_ImusateiTokujyou hT_ImusateiTkjy = hT_SyoriCTL.createImusateiTokujyou();
        hT_ImusateiTkjy.setRenno(2);
        HT_ImusateiTokujyou hT_ImusateiTkjy2 = hT_SyoriCTL.createImusateiTokujyou();
        hT_ImusateiTkjy2.setRenno(1);

        HT_SyouhnTokujyou hT_SyouhinTokujyou = hT_SyoriCTL.createSyouhnTokujyou();
        hT_SyouhinTokujyou.setSyouhncd("C002");
        HT_SyouhnTokujyou hT_SyouhinTokujyou2 = hT_SyoriCTL.createSyouhnTokujyou();
        hT_SyouhinTokujyou2.setSyouhncd("C001");

        HT_ImusateiSyouhnTokujyou hT_ImusateiSyhnTkj = hT_SyoriCTL.createImusateiSyouhnTokujyou();
        hT_ImusateiSyhnTkj.setRenno(2);
        hT_ImusateiSyhnTkj.setSyouhncd("C001");
        HT_ImusateiSyouhnTokujyou hT_ImusateiSyhnTkj2 = hT_SyoriCTL.createImusateiSyouhnTokujyou();
        hT_ImusateiSyhnTkj2.setRenno(2);
        hT_ImusateiSyhnTkj2.setSyouhncd("C002");
        HT_ImusateiSyouhnTokujyou hT_ImusateiSyhnTkj3 = hT_SyoriCTL.createImusateiSyouhnTokujyou();
        hT_ImusateiSyhnTkj3.setRenno(1);
        hT_ImusateiSyhnTkj3.setSyouhncd("C001");

        HT_DakuhiKettei hT_DakuhiKettei = hT_SyoriCTL.createDakuhiKettei();
        hT_DakuhiKettei.setDakuhiktrenno(4);
        HT_DakuhiKettei hT_DakuhiKettei2 = hT_SyoriCTL.createDakuhiKettei();
        hT_DakuhiKettei2.setDakuhiktrenno(3);

        HT_ImusateiRireki hT_ImusateiRireki = hT_SyoriCTL.createImusateiRireki();
        hT_ImusateiRireki.setRenno(2);
        HT_ImusateiRireki hT_ImusateiRrk2 = hT_SyoriCTL.createImusateiRireki();
        hT_ImusateiRrk2.setRenno(1);

        HT_KnksateiRireki hT_KnksateiRireki = hT_SyoriCTL.createKnksateiRireki();
        hT_KnksateiRireki.setRenno(2);
        HT_KnksateiRireki hT_KnksateiRrk2 = hT_SyoriCTL.createKnksateiRireki();
        hT_KnksateiRrk2.setRenno(1);

        HT_MostenkenRireki hT_MostenkenRireki = hT_SyoriCTL.createMostenkenRireki();
        hT_MostenkenRireki.setRenno(2);
        HT_MostenkenRireki hT_MostenkenRireki2 = hT_SyoriCTL.createMostenkenRireki();
        hT_MostenkenRireki2.setRenno(1);

        hT_SyoriCTL.createTokunin();

        HT_SonotaTkykJktk hT_SonotaTkykJktk = hT_SyoriCTL.createSonotaTkykJktk();
        hT_SonotaTkykJktk.setPmnjtkkbn(C_PmnjtkKbn.SANDAISIPPMNJTOK);
        HT_SonotaTkykJktk hT_SonotaTkykJktk2 = hT_SyoriCTL.createSonotaTkykJktk();
        hT_SonotaTkykJktk2.setPmnjtkkbn(C_PmnjtkKbn.NONE);

        HT_ImuSonotaTkykJktk hT_ImuSonotaTkykJktk = hT_SyoriCTL.createImuSonotaTkykJktk();
        hT_ImuSonotaTkykJktk.setRenno(2);
        hT_ImuSonotaTkykJktk.setPmnjtkkbn(C_PmnjtkKbn.NONE);
        HT_ImuSonotaTkykJktk hT_ImuSonotaTkykJktk2 = hT_SyoriCTL.createImuSonotaTkykJktk();
        hT_ImuSonotaTkykJktk2.setRenno(2);
        hT_ImuSonotaTkykJktk2.setPmnjtkkbn(C_PmnjtkKbn.SANDAISIPPMNJTOK);
        HT_ImuSonotaTkykJktk hT_ImuSonotaTkykJktk3 = hT_SyoriCTL.createImuSonotaTkykJktk();
        hT_ImuSonotaTkykJktk3.setRenno(1);
        hT_ImuSonotaTkykJktk3.setPmnjtkkbn(C_PmnjtkKbn.NONE);

        HT_KykKak hT_KykKak = hT_SyoriCTL.createKykKak();
        hT_KykKak.setRenno(2);
        HT_KykKak hT_KykKak2 = hT_SyoriCTL.createKykKak();
        hT_KykKak2.setRenno(1);

        HT_RuleHanteiMsg hT_RuleHanteiMsg = hT_SyoriCTL.createRuleHanteiMsg();
        hT_RuleHanteiMsg.setRulehanteimsg(C_Rulehanteimsg.IMUSATEI);
        hT_RuleHanteiMsg.setRenno(2);
        HT_RuleHanteiMsg hT_RuleHanteiMsg2 = hT_SyoriCTL.createRuleHanteiMsg();
        hT_RuleHanteiMsg2.setRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
        hT_RuleHanteiMsg2.setRenno(2);
        HT_RuleHanteiMsg hT_RuleHanteiMsg3 = hT_SyoriCTL.createRuleHanteiMsg();
        hT_RuleHanteiMsg3.setRulehanteimsg(C_Rulehanteimsg.IMUSATEI);
        hT_RuleHanteiMsg3.setRenno(1);


        HT_NayoseKekka hT_NayoseKekka = hT_SyoriCTL.createNayoseKekka();
        hT_NayoseKekka.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_NayoseKekka.setEdano(2);
        HT_NayoseKekka hT_NayoseKekka2 = hT_SyoriCTL.createNayoseKekka();
        hT_NayoseKekka2.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        hT_NayoseKekka2.setEdano(1);
        HT_NayoseKekka hT_NayoseKekka3 = hT_SyoriCTL.createNayoseKekka();
        hT_NayoseKekka3.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_NayoseKekka3.setEdano(1);

        hT_SyoriCTL.createTuusan();


        HT_SentakuJyouhou hT_SentakuJyouhou = hT_SyoriCTL.createSentakuJyouhou();
        hT_SentakuJyouhou.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_SentakuJyouhou.setEdano(2);
        hT_SentakuJyouhou.setSntkinfono("3");
        HT_SentakuJyouhou hT_SentakuJyouhou2 = hT_SyoriCTL.createSentakuJyouhou();
        hT_SentakuJyouhou2.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        hT_SentakuJyouhou2.setEdano(1);
        hT_SentakuJyouhou2.setSntkinfono("1");
        HT_SentakuJyouhou hT_SentakuJyouhou3 = hT_SyoriCTL.createSentakuJyouhou();
        hT_SentakuJyouhou3.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_SentakuJyouhou3.setEdano(1);
        hT_SentakuJyouhou3.setSntkinfono("2");


        HT_Nyuukin hT_Nyuukin = hT_SyoriCTL.createNyuukin();
        hT_Nyuukin.setRenno(2);
        HT_Nyuukin hT_Nyuukin2 = hT_SyoriCTL.createNyuukin();
        hT_Nyuukin2.setRenno(1);

        HT_Henkin hT_Henkin = hT_SyoriCTL.createHenkin();
        hT_Henkin.setRenno(2);
        HT_Henkin hT_Henkin1 = hT_SyoriCTL.createHenkin();
        hT_Henkin1.setRenno(1);


        hT_SyoriCTL.createMosKihonVrf();

        HT_NrkDif hT_NrkDif = hT_SyoriCTL.createNrkDif();
        hT_NrkDif.setVrfkinouid("321");
        hT_NrkDif.setRenno3keta(100);
        HT_NrkDif hT_NrkDif2 = hT_SyoriCTL.createNrkDif();
        hT_NrkDif2.setVrfkinouid("321");
        hT_NrkDif2.setRenno3keta(200);
        HT_NrkDif hT_NrkDif3 = hT_SyoriCTL.createNrkDif();
        hT_NrkDif3.setVrfkinouid("123");
        hT_NrkDif3.setRenno3keta(100);

        HT_UketorininVrf hT_UketorininVrf = hT_SyoriCTL.createUketorininVrf();
        hT_UketorininVrf.setUktsyukbn(C_UktsyuKbn.BLNK);
        hT_UketorininVrf.setUktsyurenno(2);
        HT_UketorininVrf hT_UketorininVrf2 = hT_SyoriCTL.createUketorininVrf();
        hT_UketorininVrf2.setUktsyukbn(C_UktsyuKbn.SBUKT);
        hT_UketorininVrf2.setUktsyurenno(2);
        HT_UketorininVrf hT_UketorininVrf3 = hT_SyoriCTL.createUketorininVrf();
        hT_UketorininVrf3.setUktsyukbn(C_UktsyuKbn.BLNK);
        hT_UketorininVrf3.setUktsyurenno(1);

        HT_MosDairitenVrf hT_MosDairitenVrf = hT_SyoriCTL.createMosDairitenVrf();
        hT_MosDairitenVrf.setRenno(2);
        HT_MosDairitenVrf hT_MosDairitenVrf2 = hT_SyoriCTL.createMosDairitenVrf();
        hT_MosDairitenVrf2.setRenno(1);

        HT_MosSyouhnVrf hT_MosSyouhnVrf = hT_SyoriCTL.createMosSyouhnVrf();
        hT_MosSyouhnVrf.setSyouhncd("1002");
        HT_MosSyouhnVrf hT_MosSyouhnVrf2 = hT_SyoriCTL.createMosSyouhnVrf();
        hT_MosSyouhnVrf2.setSyouhncd("1001");

        hT_SyoriCTL.createKouzaJyouhouVrf();

        HT_UketoriKouzaJyouhouVrf hT_UketoriKouzaJyouhouVrf = hT_SyoriCTL.createUketoriKouzaJyouhouVrf();
        hT_UketoriKouzaJyouhouVrf.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
        HT_UketoriKouzaJyouhouVrf hT_UketoriKouzaJyouhouVrf1 = hT_SyoriCTL.createUketoriKouzaJyouhouVrf();
        hT_UketoriKouzaJyouhouVrf1.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.BLNK);

        hT_SyoriCTL.createKokutisyoVrf();

        hT_SyoriCTL.setDaimosno("1001");

        sinkeiyakuDomManager.insert(hT_SyoriCTL);


        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL("MOSNOD00003");
        hT_SyoriCTL2.setDaimosno("2001");

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);


        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL("MOSNOD00002");
        hT_SyoriCTL3.setDaimosno("3001");

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);


        String pMosno = "MOSNO000101";
        String pHubisikibetukey1 = "HBKEY000101";
        String pHubisikibetukey2 = "HBKEY000102";
        String pHubisikibetukey3 = "HBKEY000103";

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno);
        HT_SkHubi hT_SkHubi1 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi1.setHubisikibetukey(pHubisikibetukey2);
        HT_SkHubi hT_SkHubi2 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi2.setHubisikibetukey(pHubisikibetukey1);
        HT_SkHubi hT_SkHubi3 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi3.setHubisikibetukey(pHubisikibetukey3);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJigyouIkkatu());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJigyouIkkatu());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_SyoriCTL> hT_SyoriCTLs = sinkeiyakuDomManager.getAllSyoriCTL();
        Assert.assertEquals("MOSNO000101", hT_SyoriCTLs.get(0).getMosno());
        Assert.assertEquals("MOSNOD00001", hT_SyoriCTLs.get(1).getMosno());
        Assert.assertEquals("MOSNOD00002", hT_SyoriCTLs.get(2).getMosno());
        Assert.assertEquals("MOSNOD00003", hT_SyoriCTLs.get(3).getMosno());

        Assert.assertEquals(4, hT_SyoriCTLs.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pMosno = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        Assert.assertEquals(pMosno, hT_SyoriCTL.getMosno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {
        String pMosno = "12345678999";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        Assert.assertNull(hT_SyoriCTL);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {
        String pMosno = "";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        Assert.assertNull(hT_SyoriCTL);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getMosKihon() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        Assert.assertEquals(pMosno1, hT_SyoriCTL1.getMosKihon().getMosno());

        Assert.assertNull(hT_SyoriCTL2.getMosKihon());
        Assert.assertNull(hT_SyoriCTL3.getMosKihon());

    }

    @Test
    @TestOrder(70)
    public void getKouzaJyouhou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        Assert.assertEquals(pMosno1, hT_SyoriCTL1.getKouzaJyouhou().getMosno());

        Assert.assertNull(hT_SyoriCTL2.getKouzaJyouhou());
        Assert.assertNull(hT_SyoriCTL3.getKouzaJyouhou());

    }

    @Test
    @TestOrder(80)
    public void getCreditCardJyouhou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        Assert.assertEquals(pMosno1, hT_SyoriCTL1.getCreditCardJyouhou().getMosno());

        Assert.assertNull(hT_SyoriCTL2.getCreditCardJyouhou());
        Assert.assertNull(hT_SyoriCTL3.getCreditCardJyouhou());

    }

    @Test
    @TestOrder(90)
    public void getSkTtdkTyuuiKanri() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        Assert.assertEquals(pMosno1, hT_SyoriCTL1.getSkTtdkTyuuiKanri().getMosno());

        Assert.assertNull(hT_SyoriCTL2.getSkTtdkTyuuiKanri());
        Assert.assertNull(hT_SyoriCTL3.getSkTtdkTyuuiKanri());

    }

    @Test
    @TestOrder(100)
    public void getSkTtdkTyuui() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_SkTtdkTyuui> hT_SkTtdkTyuuis = hT_SyoriCTL1.getSkTtdkTyuuis();
        Assert.assertEquals(3, hT_SkTtdkTyuuis.size());

        Assert.assertEquals(pMosno1, hT_SkTtdkTyuuis.get(0).getMosno());
        Assert.assertEquals(C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO, hT_SkTtdkTyuuis.get(0).getSkeittdkrenrakukbn());
        Assert.assertEquals(2, hT_SkTtdkTyuuis.get(0).getDatarenno().intValue());
        Assert.assertEquals(pMosno1, hT_SkTtdkTyuuis.get(1).getMosno());
        Assert.assertEquals(C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO, hT_SkTtdkTyuuis.get(1).getSkeittdkrenrakukbn());
        Assert.assertEquals(1, hT_SkTtdkTyuuis.get(1).getDatarenno().intValue());
        Assert.assertEquals(pMosno1, hT_SkTtdkTyuuis.get(2).getMosno());
        Assert.assertEquals(C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO, hT_SkTtdkTyuuis.get(2).getSkeittdkrenrakukbn());
        Assert.assertEquals(2, hT_SkTtdkTyuuis.get(2).getDatarenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getSkTtdkTyuuis().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getSkTtdkTyuuis().size());

    }

    @Test
    @TestOrder(110)
    public void getHubiMsg() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_HubiMsg> hT_HubiMsgs = hT_SyoriCTL1.getHubiMsgs();
        Assert.assertEquals(2, hT_HubiMsgs.size());

        Assert.assertEquals(pMosno1, hT_HubiMsgs.get(0).getMosno());
        Assert.assertEquals(1, hT_HubiMsgs.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_HubiMsgs.get(1).getMosno());
        Assert.assertEquals(2, hT_HubiMsgs.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getHubiMsgs().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getHubiMsgs().size());


    }

    @Test
    @TestOrder(120)
    public void getHenteiRireki() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_HenteiRireki> hT_HenteiRirekis = hT_SyoriCTL1.getHenteiRirekis();
        Assert.assertEquals(2, hT_HenteiRirekis.size());

        Assert.assertEquals(pMosno1, hT_HenteiRirekis.get(0).getMosno());
        Assert.assertEquals(1, hT_HenteiRirekis.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_HenteiRirekis.get(1).getMosno());
        Assert.assertEquals(2, hT_HenteiRirekis.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getHenteiRirekis().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getHenteiRirekis().size());

    }

    @Test
    @TestOrder(130)
    public void getKmTsRireki() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_KmTsRireki> hT_KmTsRirekis = hT_SyoriCTL1.getKmTsRirekis();
        Assert.assertEquals(3, hT_KmTsRirekis.size());

        Assert.assertEquals(pMosno1, hT_KmTsRirekis.get(0).getMosno());
        Assert.assertEquals("10", hT_KmTsRirekis.get(0).getSyoriTime());
        Assert.assertEquals(100, hT_KmTsRirekis.get(0).getRenno3keta().intValue());
        Assert.assertEquals(pMosno1, hT_KmTsRirekis.get(1).getMosno());
        Assert.assertEquals("10", hT_KmTsRirekis.get(1).getSyoriTime());
        Assert.assertEquals(200, hT_KmTsRirekis.get(1).getRenno3keta().intValue());
        Assert.assertEquals(pMosno1, hT_KmTsRirekis.get(2).getMosno());
        Assert.assertEquals("20", hT_KmTsRirekis.get(2).getSyoriTime());
        Assert.assertEquals(100, hT_KmTsRirekis.get(2).getRenno3keta().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getKmTsRirekis().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getKmTsRirekis().size());

    }

    @Test
    @TestOrder(140)
    public void getSkLincTourokuInfo() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        Assert.assertEquals(pMosno1, hT_SyoriCTL1.getSkLincTourokuInfo().getMosno());

        Assert.assertNull(hT_SyoriCTL2.getSkLincTourokuInfo());
        Assert.assertNull(hT_SyoriCTL3.getSkLincTourokuInfo());

    }

    @Test
    @TestOrder(150)
    public void getUketoriKouzaJyouhou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_UketoriKouzaJyouhou> hT_UketoriKouzaJyouhous = hT_SyoriCTL1.getUketoriKouzaJyouhous();
        Assert.assertEquals(2, hT_UketoriKouzaJyouhous.size());

        Assert.assertEquals(pMosno1, hT_UketoriKouzaJyouhous.get(0).getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.BLNK, hT_UketoriKouzaJyouhous.get(0).getUktkzsyubetukbn());
        Assert.assertEquals(pMosno1, hT_UketoriKouzaJyouhous.get(1).getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN, hT_UketoriKouzaJyouhous.get(1).getUktkzsyubetukbn());

        Assert.assertEquals(0,hT_SyoriCTL2.getUketoriKouzaJyouhous().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getUketoriKouzaJyouhous().size());

    }

    @Test
    @TestOrder(160)
    public void getMosDairiten() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_MosDairiten> hT_MosDairitens = hT_SyoriCTL1.getMosDairitens();
        Assert.assertEquals(2, hT_MosDairitens.size());

        Assert.assertEquals(pMosno1, hT_MosDairitens.get(0).getMosno());
        Assert.assertEquals(1, hT_MosDairitens.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_MosDairitens.get(1).getMosno());
        Assert.assertEquals(2, hT_MosDairitens.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getMosDairitens().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getMosDairitens().size());

    }

    @Test
    @TestOrder(170)
    public void getUketorinin() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_Uketorinin> hT_Uketorinins = hT_SyoriCTL1.getUketorinins();
        Assert.assertEquals(3, hT_Uketorinins.size());

        Assert.assertEquals(pMosno1, hT_Uketorinins.get(0).getMosno());
        Assert.assertEquals(C_UktsyuKbn.BLNK, hT_Uketorinins.get(0).getUktsyukbn());
        Assert.assertEquals(1, hT_Uketorinins.get(0).getUktsyurenno().intValue());
        Assert.assertEquals(pMosno1, hT_Uketorinins.get(1).getMosno());
        Assert.assertEquals(C_UktsyuKbn.BLNK, hT_Uketorinins.get(1).getUktsyukbn());
        Assert.assertEquals(2, hT_Uketorinins.get(1).getUktsyurenno().intValue());
        Assert.assertEquals(pMosno1, hT_Uketorinins.get(2).getMosno());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, hT_Uketorinins.get(2).getUktsyukbn());
        Assert.assertEquals(2, hT_Uketorinins.get(2).getUktsyurenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getUketorinins().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getUketorinins().size());

    }

    @Test
    @TestOrder(180)
    public void getMosSyouhn() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_MosSyouhn> hT_MosSyouhns = hT_SyoriCTL1.getMosSyouhns();
        Assert.assertEquals(2, hT_MosSyouhns.size());

        Assert.assertEquals(pMosno1, hT_MosSyouhns.get(0).getMosno());
        Assert.assertEquals("C001", hT_MosSyouhns.get(0).getSyouhncd());
        Assert.assertEquals(pMosno1, hT_MosSyouhns.get(1).getMosno());
        Assert.assertEquals("C002", hT_MosSyouhns.get(1).getSyouhncd());

        Assert.assertEquals(0,hT_SyoriCTL2.getMosSyouhns().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getMosSyouhns().size());

    }

    @Test
    @TestOrder(190)
    public void getHoujyou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_Houjyou> hT_Houjyous = hT_SyoriCTL1.getHoujyous();
        Assert.assertEquals(2, hT_Houjyous.size());

        Assert.assertEquals(pMosno1, hT_Houjyous.get(0).getMosno());
        Assert.assertEquals(C_SyosaiKbn.SOYSIN, hT_Houjyous.get(0).getSyosaikbn());
        Assert.assertEquals(pMosno1, hT_Houjyous.get(1).getMosno());
        Assert.assertEquals(C_SyosaiKbn.SAISIN, hT_Houjyous.get(1).getSyosaikbn());

        Assert.assertEquals(0,hT_SyoriCTL2.getHoujyous().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getHoujyous().size());

    }

    @Test
    @TestOrder(200)
    public void getKokutisyo() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_Kokutisyo hT_Kokutisyo = hT_SyoriCTL1.getKokutisyo();
        Assert.assertEquals(pMosno1, hT_Kokutisyo.getMosno());
        Assert.assertNull(hT_SyoriCTL2.getKokutisyo());
        Assert.assertNull(hT_SyoriCTL3.getKokutisyo());
    }

    @Test
    @TestOrder(220)
    public void getTokujyou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_Tokujyou hT_Tokujyou = hT_SyoriCTL1.getTokujyou();

        Assert.assertEquals(pMosno1, hT_Tokujyou.getMosno());

        Assert.assertNull(hT_SyoriCTL2.getTokujyou());
        Assert.assertNull(hT_SyoriCTL3.getTokujyou());
    }

    @Test
    @TestOrder(230)
    public void getImusateiTokujyou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_ImusateiTokujyou> hT_ImusateiTokujyous = hT_SyoriCTL1.getImusateiTokujyous();
        Assert.assertEquals(2, hT_ImusateiTokujyous.size());

        Assert.assertEquals(pMosno1, hT_ImusateiTokujyous.get(0).getMosno());
        Assert.assertEquals(1, hT_ImusateiTokujyous.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_ImusateiTokujyous.get(1).getMosno());
        Assert.assertEquals(2, hT_ImusateiTokujyous.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getImusateiTokujyous().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getImusateiTokujyous().size());
    }

    @Test
    @TestOrder(240)
    public void getSyouhnTokujyou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_SyouhnTokujyou> hT_SyouhnTokujyous = hT_SyoriCTL1.getSyouhnTokujyous();
        Assert.assertEquals(2, hT_SyouhnTokujyous.size());

        Assert.assertEquals(pMosno1, hT_SyouhnTokujyous.get(0).getMosno());
        Assert.assertEquals("C001", hT_SyouhnTokujyous.get(0).getSyouhncd());
        Assert.assertEquals(pMosno1, hT_SyouhnTokujyous.get(1).getMosno());
        Assert.assertEquals("C002", hT_SyouhnTokujyous.get(1).getSyouhncd());

        Assert.assertEquals(0,hT_SyoriCTL2.getSyouhnTokujyous().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getSyouhnTokujyous().size());
    }

    @Test
    @TestOrder(250)
    public void getImusateiSyouhnTokujyou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_ImusateiSyouhnTokujyou> hT_ImusateiSyouhnTokujyous = hT_SyoriCTL1.getImusateiSyouhnTokujyous();
        Assert.assertEquals(3, hT_ImusateiSyouhnTokujyous.size());

        Assert.assertEquals(pMosno1, hT_ImusateiSyouhnTokujyous.get(0).getMosno());
        Assert.assertEquals(1, hT_ImusateiSyouhnTokujyous.get(0).getRenno().intValue());
        Assert.assertEquals("C001", hT_ImusateiSyouhnTokujyous.get(0).getSyouhncd());
        Assert.assertEquals(pMosno1, hT_ImusateiSyouhnTokujyous.get(1).getMosno());
        Assert.assertEquals(2, hT_ImusateiSyouhnTokujyous.get(1).getRenno().intValue());
        Assert.assertEquals("C001", hT_ImusateiSyouhnTokujyous.get(1).getSyouhncd());
        Assert.assertEquals(pMosno1, hT_ImusateiSyouhnTokujyous.get(2).getMosno());
        Assert.assertEquals(2, hT_ImusateiSyouhnTokujyous.get(2).getRenno().intValue());
        Assert.assertEquals("C002", hT_ImusateiSyouhnTokujyous.get(2).getSyouhncd());

        Assert.assertEquals(0,hT_SyoriCTL2.getImusateiSyouhnTokujyous().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getImusateiSyouhnTokujyous().size());
    }

    @Test
    @TestOrder(260)
    public void getDakuhiKettei() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_DakuhiKettei> hT_DakuhiKetteis = hT_SyoriCTL1.getDakuhiKetteis();
        Assert.assertEquals(2, hT_DakuhiKetteis.size());

        Assert.assertEquals(pMosno1, hT_DakuhiKetteis.get(0).getMosno());
        Assert.assertEquals(3, hT_DakuhiKetteis.get(0).getDakuhiktrenno().intValue());
        Assert.assertEquals(pMosno1, hT_DakuhiKetteis.get(1).getMosno());
        Assert.assertEquals(4, hT_DakuhiKetteis.get(1).getDakuhiktrenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getDakuhiKetteis().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getDakuhiKetteis().size());
    }

    @Test
    @TestOrder(270)
    public void getImusateiRireki() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_ImusateiRireki> hT_ImusateiRirekis = hT_SyoriCTL1.getImusateiRirekis();
        Assert.assertEquals(2, hT_ImusateiRirekis.size());

        Assert.assertEquals(pMosno1, hT_ImusateiRirekis.get(0).getMosno());
        Assert.assertEquals(1, hT_ImusateiRirekis.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_ImusateiRirekis.get(1).getMosno());
        Assert.assertEquals(2, hT_ImusateiRirekis.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getImusateiRirekis().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getImusateiRirekis().size());
    }

    @Test
    @TestOrder(280)
    public void getKnksateiRireki() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_KnksateiRireki> hT_KnksateiRirekis = hT_SyoriCTL1.getKnksateiRirekis();
        Assert.assertEquals(2, hT_KnksateiRirekis.size());

        Assert.assertEquals(pMosno1, hT_KnksateiRirekis.get(0).getMosno());
        Assert.assertEquals(1, hT_KnksateiRirekis.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_KnksateiRirekis.get(1).getMosno());
        Assert.assertEquals(2, hT_KnksateiRirekis.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getKnksateiRirekis().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getKnksateiRirekis().size());
    }

    @Test
    @TestOrder(290)
    public void getMostenkenRireki() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_MostenkenRireki> hT_MostenkenRirekis = hT_SyoriCTL1.getMostenkenRirekis();
        Assert.assertEquals(2, hT_MostenkenRirekis.size());

        Assert.assertEquals(pMosno1, hT_MostenkenRirekis.get(0).getMosno());
        Assert.assertEquals(1, hT_MostenkenRirekis.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_MostenkenRirekis.get(1).getMosno());
        Assert.assertEquals(2, hT_MostenkenRirekis.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getMostenkenRirekis().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getMostenkenRirekis().size());
    }

    @Test
    @TestOrder(300)
    public void getTokunin() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_Tokunin hT_Tokunin = hT_SyoriCTL1.getTokunin();

        Assert.assertEquals(pMosno1, hT_Tokunin.getMosno());
        Assert.assertNull(hT_SyoriCTL2.getTokunin());
        Assert.assertNull(hT_SyoriCTL3.getTokunin());
    }

    @Test
    @TestOrder(310)
    public void getSonotaTkykJktk() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_SonotaTkykJktk> hT_SonotaTkykJktks = hT_SyoriCTL1.getSonotaTkykJktks();
        Assert.assertEquals(2, hT_SonotaTkykJktks.size());

        Assert.assertEquals(pMosno1, hT_SonotaTkykJktks.get(0).getMosno());
        Assert.assertEquals(C_PmnjtkKbn.NONE, hT_SonotaTkykJktks.get(0).getPmnjtkkbn());
        Assert.assertEquals(pMosno1, hT_SonotaTkykJktks.get(1).getMosno());
        Assert.assertEquals(C_PmnjtkKbn.SANDAISIPPMNJTOK, hT_SonotaTkykJktks.get(1).getPmnjtkkbn());

        Assert.assertEquals(0,hT_SyoriCTL2.getSonotaTkykJktks().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getSonotaTkykJktks().size());
    }

    @Test
    @TestOrder(320)
    public void getImuSonotaTkykJktk() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_ImuSonotaTkykJktk> hT_ImuSonotaTkykJktks = hT_SyoriCTL1.getImuSonotaTkykJktks();
        Assert.assertEquals(3, hT_ImuSonotaTkykJktks.size());

        Assert.assertEquals(pMosno1, hT_ImuSonotaTkykJktks.get(0).getMosno());
        Assert.assertEquals(1, hT_ImuSonotaTkykJktks.get(0).getRenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.NONE, hT_ImuSonotaTkykJktks.get(0).getPmnjtkkbn());
        Assert.assertEquals(pMosno1, hT_ImuSonotaTkykJktks.get(1).getMosno());
        Assert.assertEquals(2, hT_ImuSonotaTkykJktks.get(1).getRenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.NONE, hT_ImuSonotaTkykJktks.get(1).getPmnjtkkbn());
        Assert.assertEquals(pMosno1, hT_ImuSonotaTkykJktks.get(2).getMosno());
        Assert.assertEquals(2, hT_ImuSonotaTkykJktks.get(2).getRenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.SANDAISIPPMNJTOK, hT_ImuSonotaTkykJktks.get(2).getPmnjtkkbn());

        Assert.assertEquals(0,hT_SyoriCTL2.getImuSonotaTkykJktks().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getImuSonotaTkykJktks().size());
    }

    @Test
    @TestOrder(330)
    public void getKykKak() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_KykKak> hT_KykKaks = hT_SyoriCTL1.getKykKaks();
        Assert.assertEquals(2, hT_KykKaks.size());

        Assert.assertEquals(pMosno1, hT_KykKaks.get(0).getMosno());
        Assert.assertEquals(1, hT_KykKaks.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_KykKaks.get(1).getMosno());
        Assert.assertEquals(2, hT_KykKaks.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getKykKaks().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getKykKaks().size());
    }

    @Test
    @TestOrder(340)
    public void getRuleHanteiMsg() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_RuleHanteiMsg> hT_RuleHanteiMsgs = hT_SyoriCTL1.getRuleHanteiMsgs();
        Assert.assertEquals(3, hT_RuleHanteiMsgs.size());

        Assert.assertEquals(pMosno1, hT_RuleHanteiMsgs.get(0).getMosno());
        Assert.assertEquals(1, hT_RuleHanteiMsgs.get(0).getRenno().intValue());
        Assert.assertEquals(C_Rulehanteimsg.IMUSATEI, hT_RuleHanteiMsgs.get(0).getRulehanteimsg());
        Assert.assertEquals(pMosno1, hT_RuleHanteiMsgs.get(1).getMosno());
        Assert.assertEquals(2, hT_RuleHanteiMsgs.get(1).getRenno().intValue());
        Assert.assertEquals(C_Rulehanteimsg.IMUSATEI, hT_RuleHanteiMsgs.get(1).getRulehanteimsg());
        Assert.assertEquals(pMosno1, hT_RuleHanteiMsgs.get(2).getMosno());
        Assert.assertEquals(2, hT_RuleHanteiMsgs.get(2).getRenno().intValue());
        Assert.assertEquals(C_Rulehanteimsg.MOSTENKEN, hT_RuleHanteiMsgs.get(2).getRulehanteimsg());

        Assert.assertEquals(0,hT_SyoriCTL2.getRuleHanteiMsgs().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getRuleHanteiMsgs().size());
    }

    @Test
    @TestOrder(350)
    public void getNayoseKekka() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_NayoseKekka> hT_NayoseKekkas = hT_SyoriCTL1.getNayoseKekkas();
        Assert.assertEquals(3, hT_NayoseKekkas.size());

        Assert.assertEquals(pMosno1, hT_NayoseKekkas.get(0).getMosno());
        Assert.assertEquals(1, hT_NayoseKekkas.get(0).getEdano().intValue());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, hT_NayoseKekkas.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals(pMosno1, hT_NayoseKekkas.get(1).getMosno());
        Assert.assertEquals(2, hT_NayoseKekkas.get(1).getEdano().intValue());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, hT_NayoseKekkas.get(1).getSntkinfotaisyousyakbn());
        Assert.assertEquals(pMosno1, hT_NayoseKekkas.get(2).getMosno());
        Assert.assertEquals(1, hT_NayoseKekkas.get(2).getEdano().intValue());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.HIHOKENSYA, hT_NayoseKekkas.get(2).getSntkinfotaisyousyakbn());

        Assert.assertEquals(0,hT_SyoriCTL2.getNayoseKekkas().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getNayoseKekkas().size());
    }

    @Test
    @TestOrder(350)
    public void getSentakuJyouhou() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_SentakuJyouhou> hT_SentakuJyouhous = hT_SyoriCTL1.getSentakuJyouhous();
        Assert.assertEquals(3, hT_SentakuJyouhous.size());

        Assert.assertEquals(pMosno1, hT_SentakuJyouhous.get(0).getMosno());
        Assert.assertEquals(1, hT_SentakuJyouhous.get(0).getEdano().intValue());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, hT_SentakuJyouhous.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals("2", hT_SentakuJyouhous.get(0).getSntkinfono());
        Assert.assertEquals(pMosno1, hT_SentakuJyouhous.get(1).getMosno());
        Assert.assertEquals(2, hT_SentakuJyouhous.get(1).getEdano().intValue());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, hT_SentakuJyouhous.get(1).getSntkinfotaisyousyakbn());
        Assert.assertEquals("3", hT_SentakuJyouhous.get(1).getSntkinfono());
        Assert.assertEquals(pMosno1, hT_SentakuJyouhous.get(2).getMosno());
        Assert.assertEquals(1, hT_SentakuJyouhous.get(2).getEdano().intValue());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.HIHOKENSYA, hT_SentakuJyouhous.get(2).getSntkinfotaisyousyakbn());
        Assert.assertEquals("1", hT_SentakuJyouhous.get(2).getSntkinfono());

        Assert.assertEquals(0,hT_SyoriCTL2.getNayoseKekkas().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getNayoseKekkas().size());
    }

    @Test
    @TestOrder(360)
    public void getTuusan() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_Tuusan hT_Tuusan = hT_SyoriCTL1.getTuusan();

        Assert.assertEquals(pMosno1, hT_Tuusan.getMosno());
        Assert.assertNull(hT_SyoriCTL2.getTuusan());
        Assert.assertNull(hT_SyoriCTL3.getTuusan());


    }

    @Test
    @TestOrder(370)
    public void getNyuukin() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_Nyuukin> hT_Nyuukins = hT_SyoriCTL1.getNyuukins();
        Assert.assertEquals(2, hT_Nyuukins.size());

        Assert.assertEquals(pMosno1, hT_Nyuukins.get(0).getMosno());
        Assert.assertEquals(1, hT_Nyuukins.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_Nyuukins.get(1).getMosno());
        Assert.assertEquals(2, hT_Nyuukins.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getNyuukins().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getNyuukins().size());
    }

    @Test
    @TestOrder(420)
    public void getHenkin() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_Henkin> hT_Henkins = hT_SyoriCTL1.getHenkins();
        Assert.assertEquals(2, hT_Henkins.size());

        Assert.assertEquals(pMosno1, hT_Henkins.get(0).getMosno());
        Assert.assertEquals(1, hT_Henkins.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_Henkins.get(1).getMosno());
        Assert.assertEquals(2, hT_Henkins.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getHenkins().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getHenkins().size());
    }

    @Test
    @TestOrder(460)
    public void getMosKihonVrf() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_MosKihonVrf hT_MosKihonVrf = hT_SyoriCTL1.getMosKihonVrf();

        Assert.assertEquals(pMosno1, hT_MosKihonVrf.getMosno());
        Assert.assertNull(hT_SyoriCTL2.getMosKihonVrf());
        Assert.assertNull(hT_SyoriCTL3.getMosKihonVrf());
    }

    @Test
    @TestOrder(470)
    public void getNrkDif() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_NrkDif> hT_NrkDifs = hT_SyoriCTL1.getNrkDifs();
        Assert.assertEquals(3, hT_NrkDifs.size());

        Assert.assertEquals(pMosno1, hT_NrkDifs.get(0).getMosno());
        Assert.assertEquals("123", hT_NrkDifs.get(0).getVrfkinouid());
        Assert.assertEquals(100, hT_NrkDifs.get(0).getRenno3keta().intValue());
        Assert.assertEquals(pMosno1, hT_NrkDifs.get(1).getMosno());
        Assert.assertEquals(100, hT_NrkDifs.get(1).getRenno3keta().intValue());
        Assert.assertEquals("321", hT_NrkDifs.get(1).getVrfkinouid());
        Assert.assertEquals(pMosno1, hT_NrkDifs.get(2).getMosno());
        Assert.assertEquals(200, hT_NrkDifs.get(2).getRenno3keta().intValue());
        Assert.assertEquals("321", hT_NrkDifs.get(2).getVrfkinouid());

        Assert.assertEquals(0,hT_SyoriCTL2.getNrkDifs().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getNrkDifs().size());
    }

    @Test
    @TestOrder(480)
    public void getUketorininVrf() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_UketorininVrf> hT_UketorininVrfs = hT_SyoriCTL1.getUketorininVrfs();
        Assert.assertEquals(3, hT_UketorininVrfs.size());

        Assert.assertEquals(pMosno1, hT_UketorininVrfs.get(0).getMosno());
        Assert.assertEquals(C_UktsyuKbn.BLNK, hT_UketorininVrfs.get(0).getUktsyukbn());
        Assert.assertEquals(1, hT_UketorininVrfs.get(0).getUktsyurenno().intValue());
        Assert.assertEquals(pMosno1, hT_UketorininVrfs.get(1).getMosno());
        Assert.assertEquals(2, hT_UketorininVrfs.get(1).getUktsyurenno().intValue());
        Assert.assertEquals(C_UktsyuKbn.BLNK, hT_UketorininVrfs.get(1).getUktsyukbn());
        Assert.assertEquals(pMosno1, hT_UketorininVrfs.get(2).getMosno());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, hT_UketorininVrfs.get(2).getUktsyukbn());
        Assert.assertEquals(2, hT_UketorininVrfs.get(2).getUktsyurenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getUketorininVrfs().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getUketorininVrfs().size());
    }

    @Test
    @TestOrder(490)
    public void getMosDairitenVrf() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_MosDairitenVrf> hT_MosDairitenVrfs = hT_SyoriCTL1.getMosDairitenVrfs();
        Assert.assertEquals(2, hT_MosDairitenVrfs.size());

        Assert.assertEquals(pMosno1, hT_MosDairitenVrfs.get(0).getMosno());
        Assert.assertEquals(1, hT_MosDairitenVrfs.get(0).getRenno().intValue());
        Assert.assertEquals(pMosno1, hT_MosDairitenVrfs.get(1).getMosno());
        Assert.assertEquals(2, hT_MosDairitenVrfs.get(1).getRenno().intValue());

        Assert.assertEquals(0,hT_SyoriCTL2.getMosDairitenVrfs().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getMosDairitenVrfs().size());
    }

    @Test
    @TestOrder(510)
    public void getMosSyouhnVrf() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs = hT_SyoriCTL1.getMosSyouhnVrfs();
        Assert.assertEquals(2, hT_MosSyouhnVrfs.size());

        Assert.assertEquals(pMosno1, hT_MosSyouhnVrfs.get(0).getMosno());
        Assert.assertEquals("1001", hT_MosSyouhnVrfs.get(0).getSyouhncd());
        Assert.assertEquals(pMosno1, hT_MosSyouhnVrfs.get(1).getMosno());
        Assert.assertEquals("1002", hT_MosSyouhnVrfs.get(1).getSyouhncd());

        Assert.assertEquals(0,hT_SyoriCTL2.getMosSyouhnVrfs().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getMosSyouhnVrfs().size());
    }

    @Test
    @TestOrder(530)
    public void getKouzaJyouhouVrf() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf = hT_SyoriCTL1.getKouzaJyouhouVrf();

        Assert.assertEquals(pMosno1, hT_KouzaJyouhouVrf.getMosno());
        Assert.assertNull(hT_SyoriCTL2.getKouzaJyouhouVrf());
        Assert.assertNull(hT_SyoriCTL3.getKouzaJyouhouVrf());
    }

    @Test
    @TestOrder(540)
    public void getUketoriKouzaJyouhouVrf() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);

        List<HT_UketoriKouzaJyouhouVrf> hT_UketoriKouzaJyouhouVrfs = hT_SyoriCTL1.getUketoriKouzaJyouhouVrfs();
        Assert.assertEquals(2, hT_UketoriKouzaJyouhouVrfs.size());

        Assert.assertEquals(pMosno1, hT_UketoriKouzaJyouhouVrfs.get(0).getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.BLNK, hT_UketoriKouzaJyouhouVrfs.get(0).getUktkzsyubetukbn());
        Assert.assertEquals(pMosno1, hT_UketoriKouzaJyouhouVrfs.get(1).getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN, hT_UketoriKouzaJyouhouVrfs.get(1).getUktkzsyubetukbn());

        Assert.assertEquals(0,hT_SyoriCTL2.getUketoriKouzaJyouhouVrfs().size());
        Assert.assertEquals(0,hT_SyoriCTL3.getUketoriKouzaJyouhouVrfs().size());
    }

    @Test
    @TestOrder(550)
    public void getKokutisyoVrf() {
        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_KokutisyoVrf hT_KokutisyoVrf = hT_SyoriCTL1.getKokutisyoVrf();

        Assert.assertEquals(pMosno1, hT_KokutisyoVrf.getMosno());
        Assert.assertNull(hT_SyoriCTL2.getKokutisyoVrf());
        Assert.assertNull(hT_SyoriCTL3.getKokutisyoVrf());
    }

    @Test
    @TestOrder(560)
    public void getSkHubi() {
        String pMosno = "MOSNO000101";
        String pHubisikibetukey1 = "HBKEY000101";
        String pHubisikibetukey2 = "HBKEY000102";
        String pHubisikibetukey3 = "HBKEY000103";

        List<HT_SkHubi> hT_SkHubis = sinkeiyakuDomManager.getSyoriCTL(pMosno).getSkHubis();
        Assert.assertEquals(pHubisikibetukey1, hT_SkHubis.get(0).getHubisikibetukey());
        Assert.assertEquals(pHubisikibetukey2, hT_SkHubis.get(1).getHubisikibetukey());
        Assert.assertEquals(pHubisikibetukey3, hT_SkHubis.get(2).getHubisikibetukey());
    }
}