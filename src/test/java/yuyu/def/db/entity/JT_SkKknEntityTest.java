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

import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 請求期間テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SkKknEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final C_KyuuhuKbn pKyuuhuKbn = C_KyuuhuKbn.NYUUIN;
    private static final Integer pRenno1 = 11;
    private static final String pSyujyututourokuno = "111111111";
    private static final Integer pRenno2 = 22;
    private static final String pSyujyututourokuno2 = "222222222";
    private static final Integer pRenno3 = 33;

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

        JT_SkKkn JT_SkKkn2 = jT_SkJiyuu1.createSkKkn();
        JT_SkKkn2.setKyuuhukbn(pKyuuhuKbn);
        JT_SkKkn2.setRenno(pRenno2);
        JT_SkKkn2.setSyujyututourokuno(pSyujyututourokuno2);

        JT_SkKkn JT_SkKkn3 = jT_SkJiyuu1.createSkKkn();
        JT_SkKkn3.setKyuuhukbn(pKyuuhuKbn);
        JT_SkKkn3.setRenno(pRenno3);

        JT_SkKkn JT_SkKkn1 = jT_SkJiyuu1.createSkKkn();
        JT_SkKkn1.setKyuuhukbn(pKyuuhuKbn);
        JT_SkKkn1.setRenno(pRenno1);
        JT_SkKkn1.setSyujyututourokuno(pSyujyututourokuno);

        JM_Syujyutu JM_Syujyutu1 = new JM_Syujyutu(pSyujyututourokuno);
        siharaiDomManager.insert(JM_Syujyutu1);

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
        List<JT_SkKkn> JT_SkKkns = JT_SkJiyuu1.getSkKkns();
        JT_SkKkn JT_SkKkn1 = JT_SkKkns.get(0);
        JT_SkJiyuu JT_SkJiyuu2 = JT_SkKkn1.getSkJiyuu();

        Assert.assertEquals(pSyono1, JT_SkJiyuu2.getSyono());
        Assert.assertEquals(pSkno1, JT_SkJiyuu2.getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkJiyuu2.getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkJiyuu2.getUketukeno());
    }

    @Test
    @TestOrder(20)
    public void geSyujyutu() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SkKkn> JT_SkKkns = JT_SkJiyuu1.getSkKkns();
        JT_SkKkn JT_SkKkn1 = JT_SkKkns.get(0);
        JM_Syujyutu JM_Syujyutu1 = JT_SkKkn1.getSyujyutu();

        Assert.assertEquals(pSyujyututourokuno, JM_Syujyutu1.getSyujyututourokuno());

        JT_SkKkn JT_SkKkn2 = JT_SkKkns.get(1);
        JM_Syujyutu JM_Syujyutu2 = JT_SkKkn2.getSyujyutu();
        Assert.assertNull(JM_Syujyutu2);

        JT_SkKkn JT_SkKkn3 = JT_SkKkns.get(2);
        JM_Syujyutu JM_Syujyutu3 = JT_SkKkn3.getSyujyutu();
        Assert.assertNull(JM_Syujyutu3);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void getSyujyutuNull01() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SkKkn> JT_SkKkns = JT_SkJiyuu1.getSkKkns();
        JT_SkKkn JT_SkKkn1 = JT_SkKkns.get(0);
        JM_Syujyutu JM_Syujyutu1 = JT_SkKkn1.getSyujyutu();

        if(JM_Syujyutu1 != null) {
            siharaiDomManager.delete(JM_Syujyutu1);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void getSyujyutuNull02() {


        JM_Syujyutu JM_Syujyutu1 = siharaiDomManager.getSyujyutu(pSyujyututourokuno);

        Assert.assertNull(JM_Syujyutu1);
    }

}
