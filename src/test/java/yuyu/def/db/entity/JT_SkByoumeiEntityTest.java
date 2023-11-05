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
 * 請求病名テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SkByoumeiEntityTest {

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

        Integer pRenno1 = 11;
        String pByoumeitourokuno = "1111";
        Integer pRenno2 = 22;
        String pByoumeitourokuno2 = "2222";
        Integer pRenno3 = 33;

        JT_SkByoumei JT_SkByoumei2 = jT_SkJiyuu1.createSkByoumei();
        JT_SkByoumei2.setRenno(pRenno2);
        JT_SkByoumei2.setByoumeitourokuno(pByoumeitourokuno2);

        JT_SkByoumei JT_SkByoumei3 = jT_SkJiyuu1.createSkByoumei();
        JT_SkByoumei3.setRenno(pRenno3);

        JT_SkByoumei JT_SkByoumei1 = jT_SkJiyuu1.createSkByoumei();
        JT_SkByoumei1.setRenno(pRenno1);
        JT_SkByoumei1.setByoumeitourokuno(pByoumeitourokuno);

        JM_Byoumei JM_Byoumei1 = new JM_Byoumei(pByoumeitourokuno);
        siharaiDomManager.insert(JM_Byoumei1);

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
        List<JT_SkByoumei> JT_SkByoumeis = JT_SkJiyuu1.getSkByoumeis();
        JT_SkByoumei JT_SkByoumei1 = JT_SkByoumeis.get(0);
        JT_SkJiyuu JT_SkJiyuu2 = JT_SkByoumei1.getSkJiyuu();

        Assert.assertEquals(pSyono1, JT_SkJiyuu2.getSyono());
        Assert.assertEquals(pSkno1, JT_SkJiyuu2.getSkno());
        Assert.assertEquals(pSeikyuurirekino, JT_SkJiyuu2.getSeikyuurirekino());
        Assert.assertEquals(pUketukeno, JT_SkJiyuu2.getUketukeno());
    }

    @Test
    @TestOrder(20)
    public void geByoumei() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        String pByoumeitourokuno = "1111";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SkByoumei> JT_SkByoumeis = JT_SkJiyuu1.getSkByoumeis();
        JT_SkByoumei JT_SkByoumei1 = JT_SkByoumeis.get(0);
        JM_Byoumei JM_Byoumei1 = JT_SkByoumei1.getByoumei();

        Assert.assertEquals(pByoumeitourokuno, JM_Byoumei1.getByoumeitourokuno());

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void getByoumeiNull01() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        List<JT_SkJiyuu> JT_SkJiyuus = jT_Sk1.getSkJiyuus();
        JT_SkJiyuu JT_SkJiyuu1 = JT_SkJiyuus.get(0);
        List<JT_SkByoumei> JT_SkByoumeis = JT_SkJiyuu1.getSkByoumeis();
        JT_SkByoumei JT_SkByoumei1 = JT_SkByoumeis.get(0);
        JM_Byoumei JM_Byoumei1 = JT_SkByoumei1.getByoumei();

        if(JM_Byoumei1 != null) {
            siharaiDomManager.delete(JM_Byoumei1);
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getByoumeiNull02() {

        String pByoumeitourokuno = "1111";

        JM_Byoumei JM_Byoumei1 = siharaiDomManager.getByoumei(pByoumeitourokuno);

        Assert.assertNull(JM_Byoumei1);

        String pByoumeitourokuno2 = "2222";

        JM_Byoumei JM_Byoumei2 = siharaiDomManager.getByoumei(pByoumeitourokuno2);

        Assert.assertNull(JM_Byoumei2);

        String pByoumeitourokuno3 = "3333";

        JM_Byoumei JM_Byoumei3 = siharaiDomManager.getByoumei(pByoumeitourokuno3);

        Assert.assertNull(JM_Byoumei3);
    }

}
