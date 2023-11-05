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
 * 特定給付判定マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JM_TokusyuKyuHanteiEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pByoumeitourokuno = "1111";

    private static final String pSyouhncd1 = "1111";
    private static final Integer pSyouhnsdno1 = 11;
    private static final String pTekiyoukknfrom = "11111111";
    private static final String pTekiyoukknkto = "11111111";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        //        JM_Byoumei JM_Byoumei2 = new JM_Byoumei(pByoumeitourokuno2);
        //
        //        JM_TokusyuKyuHantei JM_TokusyuKyuHantei2 = JM_Byoumei2.createTokusyuKyuHantei();
        //        JM_TokusyuKyuHantei2.setSyouhncd(pSyouhncd2);
        //        JM_TokusyuKyuHantei2.setSyouhnsdno(pSyouhnsdno2);
        //        JM_TokusyuKyuHantei2.setTekiyoukknfrom(pTekiyoukknfrom2);
        //        JM_TokusyuKyuHantei2.setTekiyoukknkto(pTekiyoukknkto2);
        //
        //        siharaiDomManager.insert(JM_Byoumei2);
        //
        //        JM_Byoumei JM_Byoumei3 = new JM_Byoumei(pByoumeitourokuno2);
        //
        //        JM_TokusyuKyuHantei JM_TokusyuKyuHantei3 = JM_Byoumei3.createTokusyuKyuHantei();
        //        JM_TokusyuKyuHantei3.setSyouhncd(pSyouhncd1);
        //        JM_TokusyuKyuHantei3.setSyouhnsdno(pSyouhnsdno1);
        //        JM_TokusyuKyuHantei3.setTekiyoukknfrom(pTekiyoukknfrom);
        //        JM_TokusyuKyuHantei3.setTekiyoukknkto(pTekiyoukknkto);
        //
        //        siharaiDomManager.insert(JM_Byoumei3);

        JM_Byoumei JM_Byoumei1 = new JM_Byoumei(pByoumeitourokuno);

        JM_TokusyuKyuHantei JM_TokusyuKyuHantei1 = JM_Byoumei1.createTokusyuKyuHantei();
        JM_TokusyuKyuHantei1.setSyouhncd(pSyouhncd1);
        JM_TokusyuKyuHantei1.setSyouhnsdno(pSyouhnsdno1);
        JM_TokusyuKyuHantei1.setTekiyoukknfrom(pTekiyoukknfrom);
        JM_TokusyuKyuHantei1.setTekiyoukknkto(pTekiyoukknkto);

        siharaiDomManager.insert(JM_Byoumei1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllByoumei());
    }

    @Test
    @TestOrder(10)
    public void getByoumei() {

        JM_Byoumei JM_Byoumei1 = siharaiDomManager.getByoumei(pByoumeitourokuno);
        List<JM_TokusyuKyuHantei> JM_TokusyuKyuHanteis = JM_Byoumei1.getTokusyuKyuHanteis();
        JM_TokusyuKyuHantei JM_TokusyuKyuHantei1 = JM_TokusyuKyuHanteis.get(0);
        JM_Byoumei JM_Byoumei2 = JM_TokusyuKyuHantei1.getByoumei();

        Assert.assertEquals(pByoumeitourokuno, JM_Byoumei2.getByoumeitourokuno());
    }
}
