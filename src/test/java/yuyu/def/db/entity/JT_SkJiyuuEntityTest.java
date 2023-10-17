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

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 請求事由テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SkJiyuuEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSkno1 = "1111111111";
    private static final String pSyono1 = "SYONO000001";

    private static final Integer pSeikyuurirekino = 111;

    private static final Integer pUketukeno = 11;
    private static final Integer pUketukeno2 = 22;
    private static final Integer pUketukeno3 = 33;

    private static final Integer pRenno1 = 11;
    private static final Integer pRenno2 = 22;
    private static final Integer pRenno3 = 33;

    private static final C_KyuuhuKbn pKyuuhuKbn = C_KyuuhuKbn.NYUUIN;

    private static final C_SyutkKbn pSyutkKbn = C_SyutkKbn.SYU;
    private static final String pSyouhncd = "1111";
    private static final C_KyhgndkataKbn pKyhgndkataKbn = C_KyhgndkataKbn.TYPE60;
    private static final Integer pSyouhnsdno = 11;
    private static final Integer pKyksyouhnrenno = 11;
    private static final String pKyuuhucd1 = "1111";

    private static final Integer pRenno2keta2 = 11;



    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        JT_Sk jT_Sk1 = jT_SkKihon1.createSk();
        jT_Sk1.setSeikyuurirekino(pSeikyuurirekino);

        JT_SkJiyuu jT_SkJiyuu2 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu2.setUketukeno(pUketukeno2);

        JT_SkJiyuu jT_SkJiyuu3 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu3.setUketukeno(pUketukeno3);

        JT_SkJiyuu jT_SkJiyuu1 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu1.setUketukeno(pUketukeno);

        JT_SkByoumei JT_SkByoumei2 = jT_SkJiyuu1.createSkByoumei();
        JT_SkByoumei2.setRenno(pRenno2);

        JT_SkByoumei JT_SkByoumei3 = jT_SkJiyuu1.createSkByoumei();
        JT_SkByoumei3.setRenno(pRenno3);

        JT_SkByoumei JT_SkByoumei1 = jT_SkJiyuu1.createSkByoumei();
        JT_SkByoumei1.setRenno(pRenno1);

        JT_SkKkn JT_SkKkn2 = jT_SkJiyuu1.createSkKkn();
        JT_SkKkn2.setKyuuhukbn(pKyuuhuKbn);
        JT_SkKkn2.setRenno(pRenno2);

        JT_SkKkn JT_SkKkn3 = jT_SkJiyuu1.createSkKkn();
        JT_SkKkn3.setKyuuhukbn(pKyuuhuKbn);
        JT_SkKkn3.setRenno(pRenno3);

        JT_SkKkn JT_SkKkn1 = jT_SkJiyuu1.createSkKkn();
        JT_SkKkn1.setKyuuhukbn(pKyuuhuKbn);
        JT_SkKkn1.setRenno(pRenno1);

        JT_SiDetail JT_SiDetail2 = jT_SkJiyuu1.createSiDetail();
        JT_SiDetail2.setSyutkkbn(pSyutkKbn);
        JT_SiDetail2.setSyouhncd(pSyouhncd);
        JT_SiDetail2.setKyhgndkatakbn(pKyhgndkataKbn);
        JT_SiDetail2.setSyouhnsdno(pSyouhnsdno);
        JT_SiDetail2.setKyksyouhnrenno(pKyksyouhnrenno);
        JT_SiDetail2.setKyuuhucd(pKyuuhucd1);
        JT_SiDetail2.setRenno(pRenno2);

        JT_SiDetail JT_SiDetail3 = jT_SkJiyuu1.createSiDetail();
        JT_SiDetail3.setSyutkkbn(pSyutkKbn);
        JT_SiDetail3.setSyouhncd(pSyouhncd);
        JT_SiDetail3.setKyhgndkatakbn(pKyhgndkataKbn);
        JT_SiDetail3.setSyouhnsdno(pSyouhnsdno);
        JT_SiDetail3.setKyksyouhnrenno(pKyksyouhnrenno);
        JT_SiDetail3.setKyuuhucd(pKyuuhucd1);
        JT_SiDetail3.setRenno(pRenno3);

        JT_SiDetail JT_SiDetail1 = jT_SkJiyuu1.createSiDetail();
        JT_SiDetail1.setSyutkkbn(pSyutkKbn);
        JT_SiDetail1.setSyouhncd(pSyouhncd);
        JT_SiDetail1.setKyhgndkatakbn(pKyhgndkataKbn);
        JT_SiDetail1.setSyouhnsdno(pSyouhnsdno);
        JT_SiDetail1.setKyksyouhnrenno(pKyksyouhnrenno);
        JT_SiDetail1.setKyuuhucd(pKyuuhucd1);
        JT_SiDetail1.setRenno(pRenno1);

        JT_SiDetailKkn JT_SiDetailKkn2 = jT_SkJiyuu1.createSiDetailKkn();
        JT_SiDetailKkn2.setKyuuhucd(pKyuuhucd1);
        JT_SiDetailKkn2.setRenno(pRenno2);
        JT_SiDetailKkn2.setRenno2keta2(pRenno2keta2);

        JT_SiDetailKkn JT_SiDetailKkn3 = jT_SkJiyuu1.createSiDetailKkn();
        JT_SiDetailKkn3.setKyuuhucd(pKyuuhucd1);
        JT_SiDetailKkn3.setRenno(pRenno3);
        JT_SiDetailKkn3.setRenno2keta2(pRenno2keta2);

        JT_SiDetailKkn JT_SiDetailKkn1 = jT_SkJiyuu1.createSiDetailKkn();
        JT_SiDetailKkn1.setKyuuhucd(pKyuuhucd1);
        JT_SiDetailKkn1.setRenno(pRenno1);
        JT_SiDetailKkn1.setRenno2keta2(pRenno2keta2);

        siharaiDomManager.insert(jT_SkKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);

        siharaiDomManager.delete(jT_SkKihon1);
    }

    @Test
    @TestOrder(10)
    public void getSk() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        JT_Sk jT_Sk2 = JT_SkJiyuu1.getSk();

        Assert.assertEquals(pSyono1, jT_Sk2.getSyono());
        Assert.assertEquals(pSkno1, jT_Sk2.getSkno());
        Assert.assertEquals(pSeikyuurirekino, jT_Sk2.getSeikyuurirekino());
    }

    @Test
    @TestOrder(20)
    public void getSkByoumei() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SkByoumei> JT_SkByoumei1 = JT_SkJiyuu1.getSkByoumeis();

        Assert.assertEquals(3, JT_SkByoumei1.size());

        Assert.assertEquals(pSyono1, JT_SkByoumei1.get(0).getSyono());
        Assert.assertEquals(pSkno1, JT_SkByoumei1.get(0).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkByoumei1.get(0).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkByoumei1.get(0).getUketukeno());
        Assert.assertEquals(pRenno1, JT_SkByoumei1.get(0).getRenno());

        Assert.assertEquals(pSyono1, JT_SkByoumei1.get(1).getSyono());
        Assert.assertEquals(pSkno1, JT_SkByoumei1.get(1).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkByoumei1.get(1).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkByoumei1.get(1).getUketukeno());
        Assert.assertEquals(pRenno2, JT_SkByoumei1.get(1).getRenno());

        Assert.assertEquals(pSyono1, JT_SkByoumei1.get(2).getSyono());
        Assert.assertEquals(pSkno1, JT_SkByoumei1.get(2).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkByoumei1.get(2).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkByoumei1.get(2).getUketukeno());
        Assert.assertEquals(pRenno3, JT_SkByoumei1.get(2).getRenno());

        JT_SkJiyuu JT_SkJiyuu2 = JT_SkJiyuus.get(1);
        List<JT_SkByoumei> JT_SkByoumei2 = JT_SkJiyuu2.getSkByoumeis();

        Assert.assertEquals(0, JT_SkByoumei2.size());

        JT_SkJiyuu JT_SkJiyuu3 = JT_SkJiyuus.get(2);
        List<JT_SkByoumei> JT_SkByoumei3 = JT_SkJiyuu3.getSkByoumeis();

        Assert.assertEquals(0, JT_SkByoumei3.size());
    }

    @Test
    @TestOrder(30)
    public void getSkKkn() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SkKkn> JT_SkKkn1 = JT_SkJiyuu1.getSkKkns();

        Assert.assertEquals(3, JT_SkKkn1.size());

        Assert.assertEquals(pSyono1, JT_SkKkn1.get(0).getSyono());
        Assert.assertEquals(pSkno1, JT_SkKkn1.get(0).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkKkn1.get(0).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkKkn1.get(0).getUketukeno());
        Assert.assertEquals(pRenno1, JT_SkKkn1.get(0).getRenno());
        Assert.assertEquals(pKyuuhuKbn, JT_SkKkn1.get(0).getKyuuhukbn());

        Assert.assertEquals(pSyono1, JT_SkKkn1.get(1).getSyono());
        Assert.assertEquals(pSkno1, JT_SkKkn1.get(1).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkKkn1.get(1).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkKkn1.get(1).getUketukeno());
        Assert.assertEquals(pRenno2, JT_SkKkn1.get(1).getRenno());
        Assert.assertEquals(pKyuuhuKbn, JT_SkKkn1.get(1).getKyuuhukbn());

        Assert.assertEquals(pSyono1, JT_SkKkn1.get(2).getSyono());
        Assert.assertEquals(pSkno1, JT_SkKkn1.get(2).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkKkn1.get(2).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkKkn1.get(2).getUketukeno());
        Assert.assertEquals(pRenno3, JT_SkKkn1.get(2).getRenno());
        Assert.assertEquals(pKyuuhuKbn, JT_SkKkn1.get(2).getKyuuhukbn());

        JT_SkJiyuu JT_SkJiyuu2 = JT_SkJiyuus.get(1);
        List<JT_SkKkn> JT_SkKkn2 = JT_SkJiyuu2.getSkKkns();

        Assert.assertEquals(0, JT_SkKkn2.size());

        JT_SkJiyuu JT_SkJiyuu3 = JT_SkJiyuus.get(2);
        List<JT_SkKkn> JT_SkKkn3 = JT_SkJiyuu3.getSkKkns();

        Assert.assertEquals(0, JT_SkKkn3.size());
    }

    @Test
    @TestOrder(40)
    public void getSiDetail() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SiDetail> JT_SiDetail1 = JT_SkJiyuu1.getSiDetails();

        Assert.assertEquals(3, JT_SiDetail1.size());

        Assert.assertEquals(pSyono1, JT_SiDetail1.get(0).getSyono());
        Assert.assertEquals(pSkno1, JT_SiDetail1.get(0).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SiDetail1.get(0).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SiDetail1.get(0).getUketukeno());
        Assert.assertEquals(pRenno1, JT_SiDetail1.get(0).getRenno());
        Assert.assertEquals(pKyuuhucd1, JT_SiDetail1.get(0).getKyuuhucd());
        Assert.assertEquals(pSyutkKbn, JT_SiDetail1.get(0).getSyutkkbn());
        Assert.assertEquals(pSyouhncd, JT_SiDetail1.get(0).getSyouhncd());
        Assert.assertEquals(pKyhgndkataKbn, JT_SiDetail1.get(0).getKyhgndkatakbn());
        Assert.assertEquals(pSyouhnsdno, JT_SiDetail1.get(0).getSyouhnsdno());
        Assert.assertEquals(pKyksyouhnrenno, JT_SiDetail1.get(0).getKyksyouhnrenno());

        Assert.assertEquals(pSyono1, JT_SiDetail1.get(1).getSyono());
        Assert.assertEquals(pSkno1, JT_SiDetail1.get(1).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SiDetail1.get(1).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SiDetail1.get(1).getUketukeno());
        Assert.assertEquals(pRenno2, JT_SiDetail1.get(1).getRenno());
        Assert.assertEquals(pKyuuhucd1, JT_SiDetail1.get(1).getKyuuhucd());
        Assert.assertEquals(pSyutkKbn, JT_SiDetail1.get(1).getSyutkkbn());
        Assert.assertEquals(pSyouhncd, JT_SiDetail1.get(1).getSyouhncd());
        Assert.assertEquals(pKyhgndkataKbn, JT_SiDetail1.get(1).getKyhgndkatakbn());
        Assert.assertEquals(pSyouhnsdno, JT_SiDetail1.get(1).getSyouhnsdno());
        Assert.assertEquals(pKyksyouhnrenno, JT_SiDetail1.get(1).getKyksyouhnrenno());

        Assert.assertEquals(pSyono1, JT_SiDetail1.get(2).getSyono());
        Assert.assertEquals(pSkno1, JT_SiDetail1.get(2).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SiDetail1.get(2).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SiDetail1.get(2).getUketukeno());
        Assert.assertEquals(pRenno3, JT_SiDetail1.get(2).getRenno());
        Assert.assertEquals(pKyuuhucd1, JT_SiDetail1.get(2).getKyuuhucd());
        Assert.assertEquals(pSyutkKbn, JT_SiDetail1.get(2).getSyutkkbn());
        Assert.assertEquals(pSyouhncd, JT_SiDetail1.get(2).getSyouhncd());
        Assert.assertEquals(pKyhgndkataKbn, JT_SiDetail1.get(2).getKyhgndkatakbn());
        Assert.assertEquals(pSyouhnsdno, JT_SiDetail1.get(2).getSyouhnsdno());
        Assert.assertEquals(pKyksyouhnrenno, JT_SiDetail1.get(2).getKyksyouhnrenno());

        JT_SkJiyuu JT_SkJiyuu2 = JT_SkJiyuus.get(1);
        List<JT_SiDetail> JT_SiDetail2 = JT_SkJiyuu2.getSiDetails();

        Assert.assertEquals(0, JT_SiDetail2.size());

        JT_SkJiyuu JT_SkJiyuu3 = JT_SkJiyuus.get(2);
        List<JT_SiDetail> JT_SiDetail3 = JT_SkJiyuu3.getSiDetails();

        Assert.assertEquals(0, JT_SiDetail3.size());
    }

    @Test
    @TestOrder(50)
    public void getSiDetailKkn() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SiDetailKkn> JT_SiDetailKkn1 = JT_SkJiyuu1.getSiDetailKkns();

        Assert.assertEquals(3, JT_SiDetailKkn1.size());

        Assert.assertEquals(pSyono1, JT_SiDetailKkn1.get(0).getSyono());
        Assert.assertEquals(pSkno1, JT_SiDetailKkn1.get(0).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SiDetailKkn1.get(0).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SiDetailKkn1.get(0).getUketukeno());
        Assert.assertEquals(pRenno1, JT_SiDetailKkn1.get(0).getRenno());
        Assert.assertEquals(pRenno2keta2, JT_SiDetailKkn1.get(0).getRenno2keta2());

        Assert.assertEquals(pSyono1, JT_SiDetailKkn1.get(1).getSyono());
        Assert.assertEquals(pSkno1, JT_SiDetailKkn1.get(1).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SiDetailKkn1.get(1).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SiDetailKkn1.get(1).getUketukeno());
        Assert.assertEquals(pRenno2, JT_SiDetailKkn1.get(1).getRenno());
        Assert.assertEquals(pRenno2keta2, JT_SiDetailKkn1.get(1).getRenno2keta2());

        Assert.assertEquals(pSyono1, JT_SiDetailKkn1.get(2).getSyono());
        Assert.assertEquals(pSkno1, JT_SiDetailKkn1.get(2).getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SiDetailKkn1.get(2).getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SiDetailKkn1.get(2).getUketukeno());
        Assert.assertEquals(pRenno3, JT_SiDetailKkn1.get(2).getRenno());
        Assert.assertEquals(pRenno2keta2, JT_SiDetailKkn1.get(2).getRenno2keta2());

        JT_SkJiyuu JT_SkJiyuu2 = JT_SkJiyuus.get(1);
        List<JT_SiDetailKkn> JT_SiDetailKkn2 = JT_SkJiyuu2.getSiDetailKkns();

        Assert.assertEquals(0, JT_SiDetailKkn2.size());

        JT_SkJiyuu JT_SkJiyuu3 = JT_SkJiyuus.get(2);
        List<JT_SiDetailKkn> JT_SiDetailKkn3 = JT_SkJiyuu3.getSiDetailKkns();

        Assert.assertEquals(0, JT_SiDetailKkn3.size());
    }

}
