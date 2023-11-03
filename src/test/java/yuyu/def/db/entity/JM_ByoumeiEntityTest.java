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
 * 病名マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JM_ByoumeiEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyouhncd2 = "2222";
    private static final Integer pSyouhnsdno2 = 22;
    private static final String pTekiyoukknfrom2 = "22222222";
    private static final String pTekiyoukknkto2 = "22222222";

    //    private static final String pSyouhncd3 = "3333";
    //    private static final Integer pSyouhnsdno3 = 33;
    //    private static final String pTekiyoukknfrom3 = "33333333";
    //    private static final String pTekiyoukknkto3 = "33333333";

    private static final String pSyouhncd = "1111";
    private static final Integer pSyouhnsdno = 11;
    private static final String pTekiyoukknfrom = "11111111";
    private static final String pTekiyoukknkto = "11111111";


    private static final String pByoumeitourokuno2 = "2222";
    private static final String pByoumeitourokuno3 = "3333";
    private static final String pByoumeitourokuno = "1111";
    private static final String pByoumeitourokunoBlank = "";
    private static final String pByoumeitourokuno99 = "9999";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JM_Byoumei> JM_Byoumeis = siharaiDomManager.getAllByoumei();
        Assert.assertEquals(0, JM_Byoumeis.size());

        JM_Byoumei JM_Byoumei2 = new JM_Byoumei(pByoumeitourokuno2);
        siharaiDomManager.insert(JM_Byoumei2);

        JM_Byoumei JM_Byoumei3 = new JM_Byoumei(pByoumeitourokuno3);
        siharaiDomManager.insert(JM_Byoumei3);

        JM_Byoumei JM_Byoumei1 = new JM_Byoumei(pByoumeitourokuno);

        JM_TokusyuKyuHantei JM_TokusyuKyuHantei2 = JM_Byoumei1.createTokusyuKyuHantei();
        JM_TokusyuKyuHantei2.setSyouhncd(pSyouhncd2);
        JM_TokusyuKyuHantei2.setSyouhnsdno(pSyouhnsdno2);
        JM_TokusyuKyuHantei2.setTekiyoukknfrom(pTekiyoukknfrom2);
        JM_TokusyuKyuHantei2.setTekiyoukknkto(pTekiyoukknkto2);

        JM_TokusyuKyuHantei JM_TokusyuKyuHantei3 = JM_Byoumei1.createTokusyuKyuHantei();
        JM_TokusyuKyuHantei3.setSyouhncd(pSyouhncd);
        JM_TokusyuKyuHantei3.setSyouhnsdno(pSyouhnsdno2);
        JM_TokusyuKyuHantei3.setTekiyoukknfrom(pTekiyoukknfrom2);
        JM_TokusyuKyuHantei3.setTekiyoukknkto(pTekiyoukknkto);

        JM_TokusyuKyuHantei JM_TokusyuKyuHantei1 = JM_Byoumei1.createTokusyuKyuHantei();
        JM_TokusyuKyuHantei1.setSyouhncd(pSyouhncd);
        JM_TokusyuKyuHantei1.setSyouhnsdno(pSyouhnsdno);
        JM_TokusyuKyuHantei1.setTekiyoukknfrom(pTekiyoukknfrom);
        JM_TokusyuKyuHantei1.setTekiyoukknkto(pTekiyoukknkto);

        siharaiDomManager.insert(JM_Byoumei1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        JM_Byoumei JM_Byoumei1 = siharaiDomManager.getByoumei(pByoumeitourokuno);

        siharaiDomManager.delete(JM_Byoumei1);


        JM_Byoumei JM_Byoumei2 = siharaiDomManager.getByoumei(pByoumeitourokuno2);

        siharaiDomManager.delete(JM_Byoumei2);


        JM_Byoumei JM_Byoumei3 = siharaiDomManager.getByoumei(pByoumeitourokuno3);

        siharaiDomManager.delete(JM_Byoumei3);
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JM_Byoumei> JM_Byoumeis = siharaiDomManager.getAllByoumei();

        Assert.assertEquals(3, JM_Byoumeis.size());

        Assert.assertEquals(JM_Byoumeis.get(0), siharaiDomManager.getByoumei(pByoumeitourokuno));
        Assert.assertEquals(JM_Byoumeis.get(1), siharaiDomManager.getByoumei(pByoumeitourokuno2));
        Assert.assertEquals(JM_Byoumeis.get(2), siharaiDomManager.getByoumei(pByoumeitourokuno3));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JM_Byoumei JM_Byoumei1 = siharaiDomManager.getByoumei(pByoumeitourokuno);

        Assert.assertEquals(pByoumeitourokuno, JM_Byoumei1.getByoumeitourokuno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        JM_Byoumei JM_Byoumei1 = siharaiDomManager.getByoumei(pByoumeitourokuno99);

        Assert.assertNull(JM_Byoumei1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        JM_Byoumei JM_Byoumei1 = siharaiDomManager.getByoumei(pByoumeitourokunoBlank);

        Assert.assertNull(JM_Byoumei1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getTokusyuKyuHantei() {


        JM_Byoumei JM_Byoumei1 = siharaiDomManager.getByoumei(pByoumeitourokuno);
        List<JM_TokusyuKyuHantei> JM_TokusyuKyuHanteis = JM_Byoumei1.getTokusyuKyuHanteis();
        JM_Byoumei JM_Byoumei2 = siharaiDomManager.getByoumei(pByoumeitourokuno2);
        List<JM_TokusyuKyuHantei> JM_TokusyuKyuHanteis2 = JM_Byoumei2.getTokusyuKyuHanteis();
        JM_Byoumei JM_Byoumei3 = siharaiDomManager.getByoumei(pByoumeitourokuno3);
        List<JM_TokusyuKyuHantei> JM_TokusyuKyuHanteis3 = JM_Byoumei3.getTokusyuKyuHanteis();

        Assert.assertEquals(3, JM_TokusyuKyuHanteis.size());


        Assert.assertEquals(pByoumeitourokuno, JM_TokusyuKyuHanteis.get(0).getByoumeitourokuno());
        Assert.assertEquals(pSyouhncd, JM_TokusyuKyuHanteis.get(0).getSyouhncd());
        Assert.assertEquals(pSyouhnsdno, JM_TokusyuKyuHanteis.get(0).getSyouhnsdno());
        Assert.assertEquals(pTekiyoukknfrom, JM_TokusyuKyuHanteis.get(0).getTekiyoukknfrom());
        Assert.assertEquals(pTekiyoukknkto, JM_TokusyuKyuHanteis.get(0).getTekiyoukknkto());

        Assert.assertEquals(pByoumeitourokuno, JM_TokusyuKyuHanteis.get(1).getByoumeitourokuno());
        Assert.assertEquals(pSyouhncd, JM_TokusyuKyuHanteis.get(1).getSyouhncd());
        Assert.assertEquals(pSyouhnsdno2, JM_TokusyuKyuHanteis.get(1).getSyouhnsdno());
        Assert.assertEquals(pTekiyoukknfrom2, JM_TokusyuKyuHanteis.get(1).getTekiyoukknfrom());
        Assert.assertEquals(pTekiyoukknkto, JM_TokusyuKyuHanteis.get(1).getTekiyoukknkto());

        Assert.assertEquals(pByoumeitourokuno, JM_TokusyuKyuHanteis.get(2).getByoumeitourokuno());
        Assert.assertEquals(pSyouhncd2, JM_TokusyuKyuHanteis.get(2).getSyouhncd());
        Assert.assertEquals(pSyouhnsdno2, JM_TokusyuKyuHanteis.get(2).getSyouhnsdno());
        Assert.assertEquals(pTekiyoukknfrom2, JM_TokusyuKyuHanteis.get(2).getTekiyoukknfrom());
        Assert.assertEquals(pTekiyoukknkto2, JM_TokusyuKyuHanteis.get(2).getTekiyoukknkto());



        Assert.assertEquals(0, JM_TokusyuKyuHanteis2.size());
        Assert.assertEquals(0, JM_TokusyuKyuHanteis3.size());
    }

}
