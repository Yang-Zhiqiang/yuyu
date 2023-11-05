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
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 支払商品属性マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JM_SiShouhnZokuseiEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSyouhncd1 = "1111";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno1 = 11;
        String pKyuuhucd1 = "1111";
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = new JM_SiSyouhnZokusei();
        jM_SiSyouhnZokusei1.setSyouhncd(pSyouhncd1);
        jM_SiSyouhnZokusei1.setKyhgndkatakbn(pKyhgndkatakbn1);
        jM_SiSyouhnZokusei1.setSyouhnsdno(pSyouhnsdno1);
        jM_SiSyouhnZokusei1.setKyuuhucd(pKyuuhucd1);

        siharaiDomManager.insert(jM_SiSyouhnZokusei1);

        JM_Kyuuhu jM_Kyuuhu1 = new JM_Kyuuhu(pKyuuhucd1);
        siharaiDomManager.insert(jM_Kyuuhu1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSyouhncd1 = "1111";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno1 = 11;
        String pKyuuhucd1 = "1111";
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = siharaiDomManager.getSiSyouhnZokusei(pSyouhncd1, pKyhgndkatakbn1, pSyouhnsdno1, pKyuuhucd1);

        siharaiDomManager.delete(jM_SiSyouhnZokusei1);
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JM_SiSyouhnZokusei> jM_SiSyouhnZokuseis = siharaiDomManager.getAllSiSyouhnZokusei();

        Assert.assertEquals(1, jM_SiSyouhnZokuseis.size());

        String pSyouhncd1 = "1111";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno1 = 11;
        String pKyuuhucd1 = "1111";
        Assert.assertEquals(jM_SiSyouhnZokuseis.get(0), siharaiDomManager.getSiSyouhnZokusei(pSyouhncd1, pKyhgndkatakbn1, pSyouhnsdno1, pKyuuhucd1));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pSyouhncd1 = "1111";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno1 = 11;
        String pKyuuhucd1 = "1111";
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = siharaiDomManager.getSiSyouhnZokusei(pSyouhncd1, pKyhgndkatakbn1, pSyouhnsdno1, pKyuuhucd1);

        Assert.assertEquals(pSyouhncd1, jM_SiSyouhnZokusei1.getSyouhncd());
        Assert.assertEquals(pKyhgndkatakbn1, jM_SiSyouhnZokusei1.getKyhgndkatakbn());
        Assert.assertEquals(pSyouhnsdno1, jM_SiSyouhnZokusei1.getSyouhnsdno());
        Assert.assertEquals(pKyuuhucd1, jM_SiSyouhnZokusei1.getKyuuhucd());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyouhncd1 = "2222";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno1 = 11;
        String pKyuuhucd1 = "1111";
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = siharaiDomManager.getSiSyouhnZokusei(pSyouhncd1, pKyhgndkatakbn1, pSyouhnsdno1, pKyuuhucd1);

        Assert.assertNull(jM_SiSyouhnZokusei1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyouhncd1 = "";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.BLNK;
        Integer pSyouhnsdno1 = 0;
        String pKyuuhucd1 = "";
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = siharaiDomManager.getSiSyouhnZokusei(pSyouhncd1, pKyhgndkatakbn1, pSyouhnsdno1, pKyuuhucd1);

        Assert.assertNull(jM_SiSyouhnZokusei1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getKyuuhu() {

        String pSyouhncd1 = "1111";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno1 = 11;
        String pKyuuhucd1 = "1111";
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = siharaiDomManager.getSiSyouhnZokusei(pSyouhncd1, pKyhgndkatakbn1, pSyouhnsdno1, pKyuuhucd1);
        JM_Kyuuhu jM_Kyuuhu1 = jM_SiSyouhnZokusei1.getKyuuhu();

        Assert.assertEquals(pKyuuhucd1, jM_Kyuuhu1.getKyuuhucd());
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getKyuuhuNull01() {

        String pKyuuhucd1 = "1111";

        JM_Kyuuhu jM_Kyuuhu1 = siharaiDomManager.getKyuuhu(pKyuuhucd1);

        if(jM_Kyuuhu1 != null) {
            siharaiDomManager.delete(jM_Kyuuhu1);
        }
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getKyuuhuNull02() {

        String pSyouhncd1 = "1111";
        C_KyhgndkataKbn pKyhgndkatakbn1 = C_KyhgndkataKbn.TYPE60;
        Integer pSyouhnsdno1 = 11;
        String pKyuuhucd1 = "1111";
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = siharaiDomManager.getSiSyouhnZokusei(pSyouhncd1, pKyhgndkatakbn1, pSyouhnsdno1, pKyuuhucd1);
        JM_Kyuuhu jM_Kyuuhu1 = jM_SiSyouhnZokusei1.getKyuuhu();

        Assert.assertNull(jM_Kyuuhu1);
    }
}
