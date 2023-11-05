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
 * 支払明細期間テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiDetailKknEntityTest {

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

        Integer pRenno2keta2 = 11;
        String pKyuuhucd1 = "1111";
        Integer pRenno1 = 11;

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
        List<JT_SiDetailKkn> JT_SiDetailKkns = JT_SkJiyuu1.getSiDetailKkns();
        JT_SiDetailKkn JT_SiDetailKkn1 = JT_SiDetailKkns.get(0);
        JT_SkJiyuu JT_SkJiyuu2 = JT_SiDetailKkn1.getSkJiyuu();

        Assert.assertEquals(pSyono1, JT_SkJiyuu2.getSyono());
        Assert.assertEquals(pSkno1, JT_SkJiyuu2.getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkJiyuu2.getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkJiyuu2.getUketukeno());
    }
}
