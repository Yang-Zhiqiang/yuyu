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
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払明細テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiDetailEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        Integer pSeikyuurirekino = 111;

        JT_Sk jT_Sk1 = jT_SkKihon1.createSk();
        jT_Sk1.setSeikyuurirekino(pSeikyuurirekino);

        Integer pUketukeno = 11;

        JT_SkJiyuu jT_SkJiyuu1 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu1.setUketukeno(pUketukeno);

        C_SyutkKbn pSyutkKbn = C_SyutkKbn.SYU;
        String pSyouhncd = "1111";
        C_KyhgndkataKbn pKyhgndkataKbn = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno = 11;
        Integer pKyksyouhnrenno = 11;
        String pKyuuhucd1 = "1111";
        Integer pRenno1 = 11;

        JT_SiDetail JT_SiDetail1 = jT_SkJiyuu1.createSiDetail();
        JT_SiDetail1.setSyutkkbn(pSyutkKbn);
        JT_SiDetail1.setSyouhncd(pSyouhncd);
        JT_SiDetail1.setKyhgndkatakbn(pKyhgndkataKbn);
        JT_SiDetail1.setSyouhnsdno(pSyouhnsdno);
        JT_SiDetail1.setKyksyouhnrenno(pKyksyouhnrenno);
        JT_SiDetail1.setKyuuhucd(pKyuuhucd1);
        JT_SiDetail1.setRenno(pRenno1);

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
    public void getSkJiyuu() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        Integer pSeikyuurirekino = 111;
        Integer pUketukeno = 11;

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SiDetail> JT_SiDetails = JT_SkJiyuu1.getSiDetails();
        JT_SiDetail JT_SiDetail1 = JT_SiDetails.get(0);
        JT_SkJiyuu JT_SkJiyuu2 = JT_SiDetail1.getSkJiyuu();

        Assert.assertEquals(pSyono1, JT_SkJiyuu2.getSyono());
        Assert.assertEquals(pSkno1, JT_SkJiyuu2.getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkJiyuu2.getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkJiyuu2.getUketukeno());
    }
}
