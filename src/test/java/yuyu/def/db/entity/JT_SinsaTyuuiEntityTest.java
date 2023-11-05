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
 * 審査注意テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SinsaTyuuiEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyono1 = "1111";
    private static final String pSyono2 = "2222";
    private static final String pSyono3 = "3333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SinsaTyuui JT_SinsaTyuui2 = new JT_SinsaTyuui(pSyono2);

        siharaiDomManager.insert(JT_SinsaTyuui2);

        JT_SinsaTyuui JT_SinsaTyuui3 = new JT_SinsaTyuui(pSyono3);

        siharaiDomManager.insert(JT_SinsaTyuui3);

        JT_SinsaTyuui JT_SinsaTyuui1 = new JT_SinsaTyuui(pSyono1);

        siharaiDomManager.insert(JT_SinsaTyuui1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSinsaTyuui());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SinsaTyuui> JT_SinsaTyuuis = siharaiDomManager.getAllSinsaTyuui();

        Assert.assertEquals(3, JT_SinsaTyuuis.size());

        Assert.assertEquals(JT_SinsaTyuuis.get(0), siharaiDomManager.getSinsaTyuui(pSyono1));
        Assert.assertEquals(JT_SinsaTyuuis.get(1), siharaiDomManager.getSinsaTyuui(pSyono2));
        Assert.assertEquals(JT_SinsaTyuuis.get(2), siharaiDomManager.getSinsaTyuui(pSyono3));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SinsaTyuui JT_SinsaTyuui1 = siharaiDomManager.getSinsaTyuui(pSyono1);

        Assert.assertEquals(pSyono1, JT_SinsaTyuui1.getSyono());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyono9 = "9999";

        JT_SinsaTyuui JT_SinsaTyuui1 = siharaiDomManager.getSinsaTyuui(pSyono9);


        Assert.assertNull(JT_SinsaTyuui1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyonoBlank = "";

        JT_SinsaTyuui JT_SinsaTyuui1 = siharaiDomManager.getSinsaTyuui(pSyonoBlank);

        Assert.assertNull(JT_SinsaTyuui1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
