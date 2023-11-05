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
 * 支払帳票メッセージマスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JM_SiTyouhyoumsgEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pBunrui11 = "1111";
    private static final String pBunrui21 = "1111";
    private static final Integer pTyouhyoulineno1 = 111;
    private static final String pBunrui12 = "2222";
    private static final String pBunrui22 = "2222";
    private static final Integer pTyouhyoulineno2 = 222;
    //    private static final String pBunrui13 = "3333";
    //    private static final String pBunrui23 = "3333";
    //    private static final Integer pTyouhyoulineno3 = 333;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg2 = new JM_SiTyouhyoumsg(pBunrui12, pBunrui22, pTyouhyoulineno2);

        siharaiDomManager.insert(JM_SiTyouhyoumsg2);

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg3 = new JM_SiTyouhyoumsg(pBunrui12, pBunrui21, pTyouhyoulineno1);

        siharaiDomManager.insert(JM_SiTyouhyoumsg3);

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg1 = new JM_SiTyouhyoumsg(pBunrui11, pBunrui21, pTyouhyoulineno1);

        siharaiDomManager.insert(JM_SiTyouhyoumsg1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg1 = siharaiDomManager.getSiTyouhyoumsg(pBunrui11, pBunrui21, pTyouhyoulineno1);

        siharaiDomManager.delete(JM_SiTyouhyoumsg1);

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg2 = siharaiDomManager.getSiTyouhyoumsg(pBunrui12, pBunrui22, pTyouhyoulineno2);

        siharaiDomManager.delete(JM_SiTyouhyoumsg2);

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg3 = siharaiDomManager.getSiTyouhyoumsg(pBunrui12, pBunrui21, pTyouhyoulineno1);

        siharaiDomManager.delete(JM_SiTyouhyoumsg3);
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JM_SiTyouhyoumsg> JM_SiTyouhyoumsgs = siharaiDomManager.getAllSiTyouhyoumsg();

        Assert.assertEquals(3, JM_SiTyouhyoumsgs.size());

        Assert.assertEquals(JM_SiTyouhyoumsgs.get(0), siharaiDomManager.getSiTyouhyoumsg(pBunrui11, pBunrui21, pTyouhyoulineno1));
        Assert.assertEquals(JM_SiTyouhyoumsgs.get(1), siharaiDomManager.getSiTyouhyoumsg(pBunrui12, pBunrui21, pTyouhyoulineno1));
        Assert.assertEquals(JM_SiTyouhyoumsgs.get(2), siharaiDomManager.getSiTyouhyoumsg(pBunrui12, pBunrui22, pTyouhyoulineno2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg1 = siharaiDomManager.getSiTyouhyoumsg(pBunrui11, pBunrui21, pTyouhyoulineno1);

        Assert.assertEquals(pBunrui11, JM_SiTyouhyoumsg1.getBunrui1());
        Assert.assertEquals(pBunrui21, JM_SiTyouhyoumsg1.getBunrui2());
        Assert.assertEquals(pTyouhyoulineno1, JM_SiTyouhyoumsg1.getTyouhyoulineno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pBunrui19 = "999";
        String pBunrui29 = "999";
        Integer pTyouhyoulineno9 = 999;

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg1 = siharaiDomManager.getSiTyouhyoumsg(pBunrui19, pBunrui29, pTyouhyoulineno9);

        Assert.assertNull(JM_SiTyouhyoumsg1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pBunrui1Blank = "";
        String pBunrui2Blank = "";

        JM_SiTyouhyoumsg JM_SiTyouhyoumsg1 = siharaiDomManager.getSiTyouhyoumsg(pBunrui1Blank, pBunrui2Blank, pTyouhyoulineno1);

        Assert.assertNull(JM_SiTyouhyoumsg1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
