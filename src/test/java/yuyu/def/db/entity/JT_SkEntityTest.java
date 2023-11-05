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

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 請求テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SkEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final Integer pSeikyuurirekino = 111;
    private static final Integer pSeikyuurirekino2 = 222;
    private static final Integer pSeikyuurirekino3 = 333;

    private static final Integer pUketukeno = 11;
    private static final Integer pUketukeno2 = 22;
    private static final Integer pUketukeno3 = 33;

    private static final Integer pRenno3keta1 = 111;
    private static final Integer pRenno3keta2 = 222;
    private static final Integer pRenno3keta3 = 333;

    private static final Integer pDatarenno = 11111;
    private static final Integer pDatarenno2 = 22222;
    private static final Integer pDatarenno3 = 33333;

    private static final String pKyuuhucd = "1111";
    private static final String pKyuuhucd2 = "2222";
    private static final String pKyuuhucd3 = "3333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        JT_Sk jT_Sk2 = jT_SkKihon1.createSk();
        jT_Sk2.setSeikyuurirekino(pSeikyuurirekino2);

        JT_Sk jT_Sk3 = jT_SkKihon1.createSk();
        jT_Sk3.setSeikyuurirekino(pSeikyuurirekino3);

        JT_Sk jT_Sk1 = jT_SkKihon1.createSk();
        jT_Sk1.setSeikyuurirekino(pSeikyuurirekino);

        JT_SkJiyuu jT_SkJiyuu2 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu2.setUketukeno(pUketukeno2);

        JT_SkJiyuu jT_SkJiyuu3 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu3.setUketukeno(pUketukeno3);

        JT_SkJiyuu jT_SkJiyuu1 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu1.setUketukeno(pUketukeno);

        JT_SkHubiMsg jT_SkHubiMsg2 = jT_Sk1.createSkHubiMsg();
        jT_SkHubiMsg2.setRenno3keta(pRenno3keta2);

        JT_SkHubiMsg jT_SkHubiMsg3 = jT_Sk1.createSkHubiMsg();
        jT_SkHubiMsg3.setRenno3keta(pRenno3keta3);

        JT_SkHubiMsg jT_SkHubiMsg1 = jT_Sk1.createSkHubiMsg();
        jT_SkHubiMsg1.setRenno3keta(pRenno3keta1);

        JT_MisyuupMkkpDetail jT_MisyuupMkkpDetail2 = jT_Sk1.createMisyuupMkkpDetail();
        jT_MisyuupMkkpDetail2.setDatarenno(pDatarenno2);

        JT_MisyuupMkkpDetail jT_MisyuupMkkpDetail3 = jT_Sk1.createMisyuupMkkpDetail();
        jT_MisyuupMkkpDetail3.setDatarenno(pDatarenno3);

        JT_MisyuupMkkpDetail jT_MisyuupMkkpDetail1 = jT_Sk1.createMisyuupMkkpDetail();
        jT_MisyuupMkkpDetail1.setDatarenno(pDatarenno);

        JT_TuusanToutatu jT_TuusanToutatu2 = jT_Sk1.createTuusanToutatu();
        jT_TuusanToutatu2.setKyuuhucd(pKyuuhucd2);

        JT_TuusanToutatu jT_TuusanToutatu3 = jT_Sk1.createTuusanToutatu();
        jT_TuusanToutatu3.setKyuuhucd(pKyuuhucd3);

        JT_TuusanToutatu jT_TuusanToutatu1 = jT_Sk1.createTuusanToutatu();
        jT_TuusanToutatu1.setKyuuhucd(pKyuuhucd);

        jT_Sk1.createNenkinInfo();

        jT_Sk1.createSateiIppanHanteiInfo();

        jT_Sk1.createSateiKokuhanInfo();

        jT_Sk1.createSibouSateiChkInfo();


        jT_Sk1.createToriatukaifuryouinfo();


        jT_Sk1.createSateiKaijyoInfo();


        jT_Sk1.createSateiMeigihenkouInfo();


        jT_Sk1.createKoudosgSateiChkInfo();


        jT_Sk1.createBetukutiSateiInfo();


        jT_Sk1.createSdsGizouKaizanInfo();


        jT_Sk1.createKoudosgJytGtKahi();


        siharaiDomManager.insert(jT_SkKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);

        siharaiDomManager.delete(jT_SkKihon1);
    }

    @Test
    @TestOrder(10)
    public void getSkKihon() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_SkKihon jT_SkKihon2 = jT_Sk1.getSkKihon();
        Assert.assertEquals(pSyono1, jT_SkKihon2.getSyono());
        Assert.assertEquals(pSkno1, jT_SkKihon2.getSkno());
    }

    @Test
    @TestOrder(20)
    public void getSkJiyuus() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();

        Assert.assertEquals(3, JT_SkJiyuus.size());

        Assert.assertEquals(pSkno1, JT_SkJiyuus.get(0).getSkno());
        Assert.assertEquals(pSyono1, JT_SkJiyuus.get(0).getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SkJiyuus.get(0).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkJiyuus.get(0).getUketukeno());
        Assert.assertEquals(pSkno1, JT_SkJiyuus.get(1).getSkno());
        Assert.assertEquals(pSyono1, JT_SkJiyuus.get(1).getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SkJiyuus.get(1).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno2, JT_SkJiyuus.get(1).getUketukeno());
        Assert.assertEquals(pSkno1, JT_SkJiyuus.get(2).getSkno());
        Assert.assertEquals(pSyono1, JT_SkJiyuus.get(2).getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SkJiyuus.get(2).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno3, JT_SkJiyuus.get(2).getUketukeno());

        JT_Sk jT_Sk2 = jT_Sks.get(1);
        List<JT_SkJiyuu> JT_SkJiyuus2 = jT_Sk2.getSkJiyuus();
        Assert.assertEquals(0, JT_SkJiyuus2.size());

        JT_Sk jT_Sk3 = jT_Sks.get(2);
        List<JT_SkJiyuu> JT_SkJiyuus3 = jT_Sk3.getSkJiyuus();
        Assert.assertEquals(0, JT_SkJiyuus3.size());
    }

    @Test
    @TestOrder(30)
    public void getSkHubiMsgs() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkHubiMsg> jT_SkHubiMsgs = jT_Sk1.getSkHubiMsgs();

        Assert.assertEquals(3, jT_SkHubiMsgs.size());

        Assert.assertEquals(pSkno1, jT_SkHubiMsgs.get(0).getSkno());
        Assert.assertEquals(pSyono1, jT_SkHubiMsgs.get(0).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_SkHubiMsgs.get(0).getSeikyuurirekino());
        Assert.assertEquals(pRenno3keta1, jT_SkHubiMsgs.get(0).getRenno3keta());
        Assert.assertEquals(pSkno1, jT_SkHubiMsgs.get(1).getSkno());
        Assert.assertEquals(pSyono1, jT_SkHubiMsgs.get(1).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_SkHubiMsgs.get(1).getSeikyuurirekino());
        Assert.assertEquals(pRenno3keta2, jT_SkHubiMsgs.get(1).getRenno3keta());
        Assert.assertEquals(pSkno1, jT_SkHubiMsgs.get(2).getSkno());
        Assert.assertEquals(pSyono1, jT_SkHubiMsgs.get(2).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_SkHubiMsgs.get(2).getSeikyuurirekino());
        Assert.assertEquals(pRenno3keta3, jT_SkHubiMsgs.get(2).getRenno3keta());

        JT_Sk jT_Sk2 = jT_Sks.get(1);
        List<JT_SkHubiMsg> jT_SkHubiMsgs2 = jT_Sk2.getSkHubiMsgs();
        Assert.assertEquals(0, jT_SkHubiMsgs2.size());

        JT_Sk jT_Sk3 = jT_Sks.get(2);
        List<JT_SkHubiMsg> jT_SkHubiMsgs3 = jT_Sk3.getSkHubiMsgs();
        Assert.assertEquals(0, jT_SkHubiMsgs3.size());
    }

    @Test
    @TestOrder(40)
    public void getMisyuupMkkpDetails() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_MisyuupMkkpDetail> jT_MisyuupMkkpDetail1 = jT_Sk1.getMisyuupMkkpDetails();

        Assert.assertEquals(3, jT_MisyuupMkkpDetail1.size());

        Assert.assertEquals(pSkno1, jT_MisyuupMkkpDetail1.get(0).getSkno());
        Assert.assertEquals(pSyono1, jT_MisyuupMkkpDetail1.get(0).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_MisyuupMkkpDetail1.get(0).getSeikyuurirekino());
        Assert.assertEquals(pDatarenno, jT_MisyuupMkkpDetail1.get(0).getDatarenno());
        Assert.assertEquals(pSkno1, jT_MisyuupMkkpDetail1.get(1).getSkno());
        Assert.assertEquals(pSyono1, jT_MisyuupMkkpDetail1.get(1).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_MisyuupMkkpDetail1.get(1).getSeikyuurirekino());
        Assert.assertEquals(pDatarenno2, jT_MisyuupMkkpDetail1.get(1).getDatarenno());
        Assert.assertEquals(pSkno1, jT_MisyuupMkkpDetail1.get(2).getSkno());
        Assert.assertEquals(pSyono1, jT_MisyuupMkkpDetail1.get(2).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_MisyuupMkkpDetail1.get(2).getSeikyuurirekino());
        Assert.assertEquals(pDatarenno3, jT_MisyuupMkkpDetail1.get(2).getDatarenno());

        JT_Sk jT_Sk2 = jT_Sks.get(1);
        List<JT_MisyuupMkkpDetail> jT_MisyuupMkkpDetail2 = jT_Sk2.getMisyuupMkkpDetails();
        Assert.assertEquals(0, jT_MisyuupMkkpDetail2.size());

        JT_Sk jT_Sk3 = jT_Sks.get(2);
        List<JT_MisyuupMkkpDetail> jT_MisyuupMkkpDetail3 = jT_Sk3.getMisyuupMkkpDetails();
        Assert.assertEquals(0, jT_MisyuupMkkpDetail3.size());
    }

    @Test
    @TestOrder(50)
    public void getTuusanToutatus() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_TuusanToutatu> jT_TuusanToutatu1 = jT_Sk1.getTuusanToutatus();

        Assert.assertEquals(3, jT_TuusanToutatu1.size());

        Assert.assertEquals(pSkno1, jT_TuusanToutatu1.get(0).getSkno());
        Assert.assertEquals(pSyono1, jT_TuusanToutatu1.get(0).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_TuusanToutatu1.get(0).getSeikyuurirekino());
        Assert.assertEquals(pKyuuhucd, jT_TuusanToutatu1.get(0).getKyuuhucd());
        Assert.assertEquals(pSkno1, jT_TuusanToutatu1.get(1).getSkno());
        Assert.assertEquals(pSyono1, jT_TuusanToutatu1.get(1).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_TuusanToutatu1.get(1).getSeikyuurirekino());
        Assert.assertEquals(pKyuuhucd2, jT_TuusanToutatu1.get(1).getKyuuhucd());
        Assert.assertEquals(pSkno1, jT_TuusanToutatu1.get(2).getSkno());
        Assert.assertEquals(pSyono1, jT_TuusanToutatu1.get(2).getSyono());
        Assert.assertEquals(pSeikyuurirekino, jT_TuusanToutatu1.get(2).getSeikyuurirekino());
        Assert.assertEquals(pKyuuhucd3, jT_TuusanToutatu1.get(2).getKyuuhucd());

        JT_Sk jT_Sk2 = jT_Sks.get(1);
        List<JT_TuusanToutatu> JT_TuusanToutatu2 = jT_Sk2.getTuusanToutatus();
        Assert.assertEquals(0, JT_TuusanToutatu2.size());

        JT_Sk jT_Sk3 = jT_Sks.get(2);
        List<JT_TuusanToutatu> JT_TuusanToutatu3 = jT_Sk3.getTuusanToutatus();
        Assert.assertEquals(0, JT_TuusanToutatu3.size());
    }

    @Test
    @TestOrder(60)
    public void getNenkinInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_NenkinInfo JT_NenkinInfo1 = jT_Sk1.getNenkinInfo();

        Assert.assertEquals(pSkno1, JT_NenkinInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_NenkinInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_NenkinInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(70)
    public void getSateiIppanHanteiInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_SateiIppanHanteiInfo JT_SateiIppanHanteiInfo1 = jT_Sk1.getSateiIppanHanteiInfo();

        Assert.assertEquals(pSkno1, JT_SateiIppanHanteiInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_SateiIppanHanteiInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SateiIppanHanteiInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(80)
    public void getSateiKokuhanInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_SateiKokuhanInfo JT_SateiKokuhanInfo1 = jT_Sk1.getSateiKokuhanInfo();

        Assert.assertEquals(pSkno1, JT_SateiKokuhanInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_SateiKokuhanInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SateiKokuhanInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(90)
    public void getSibouSateiChkInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_SibouSateiChkInfo JT_SibouSateiChkInfo1 = jT_Sk1.getSibouSateiChkInfo();

        Assert.assertEquals(pSkno1, JT_SibouSateiChkInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_SibouSateiChkInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SibouSateiChkInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(100)
    public void getToriatukaifuryouinfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_Toriatukaifuryouinfo JT_Toriatukaifuryouinfo1 = jT_Sk1.getToriatukaifuryouinfo();

        Assert.assertEquals(pSkno1, JT_Toriatukaifuryouinfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_Toriatukaifuryouinfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_Toriatukaifuryouinfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(110)
    public void getSateiKaijyoInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_SateiKaijyoInfo JT_SateiKaijyoInfo1 = jT_Sk1.getSateiKaijyoInfo();

        Assert.assertEquals(pSkno1, JT_SateiKaijyoInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_SateiKaijyoInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SateiKaijyoInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(120)
    public void getSateiMeigihenkouInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_SateiMeigihenkouInfo JT_SateiMeigihenkouInfo1 = jT_Sk1.getSateiMeigihenkouInfo();

        Assert.assertEquals(pSkno1, JT_SateiMeigihenkouInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_SateiMeigihenkouInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SateiMeigihenkouInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(130)
    public void getKoudosgSateiChkInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_KoudosgSateiChkInfo JT_KoudosgSateiChkInfo1 = jT_Sk1.getKoudosgSateiChkInfo();

        Assert.assertEquals(pSkno1, JT_KoudosgSateiChkInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_KoudosgSateiChkInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_KoudosgSateiChkInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(140)
    public void getBetukutiSateiInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_BetukutiSateiInfo JT_BetukutiSateiInfo1 = jT_Sk1.getBetukutiSateiInfo();

        Assert.assertEquals(pSkno1, JT_BetukutiSateiInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_BetukutiSateiInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_BetukutiSateiInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(150)
    public void getSdsGizouKaizanInfo() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_SdsGizouKaizanInfo JT_SdsGizouKaizanInfo1 = jT_Sk1.getSdsGizouKaizanInfo();

        Assert.assertEquals(pSkno1, JT_SdsGizouKaizanInfo1.getSkno());
        Assert.assertEquals(pSyono1, JT_SdsGizouKaizanInfo1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_SdsGizouKaizanInfo1.getSeikyuurirekino());
    }

    @Test
    @TestOrder(160)
    public void getKoudosgJytGtKahi() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_KoudosgJytGtKahi JT_KoudosgJytGtKahi1 = jT_Sk1.getKoudosgJytGtKahi();

        Assert.assertEquals(pSkno1, JT_KoudosgJytGtKahi1.getSkno());
        Assert.assertEquals(pSyono1, JT_KoudosgJytGtKahi1.getSyono());
        Assert.assertEquals(pSeikyuurirekino, JT_KoudosgJytGtKahi1.getSeikyuurirekino());
    }

}
