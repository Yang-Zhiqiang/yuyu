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
 * 未収P連動テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_MisyuupRendoEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyono1 = "SYONO000001";
    private static final Integer pRenno = 11;

    private static final String pSyono2 = "SYONO000002";
    private static final Integer pRenno2 = 22;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_MisyuupRendo JT_MisyuupRendo2 = new JT_MisyuupRendo(pSyono2, pRenno2);

        siharaiDomManager.insert(JT_MisyuupRendo2);

        JT_MisyuupRendo JT_MisyuupRendo3 = new JT_MisyuupRendo(pSyono2, pRenno);

        siharaiDomManager.insert(JT_MisyuupRendo3);

        JT_MisyuupRendo JT_MisyuupRendo1 = new JT_MisyuupRendo(pSyono1, pRenno);

        siharaiDomManager.insert(JT_MisyuupRendo1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllMisyuupRendo());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_MisyuupRendo> JT_MisyuupRendos = siharaiDomManager.getAllMisyuupRendo();

        Assert.assertEquals(3, JT_MisyuupRendos.size());

        Assert.assertEquals(JT_MisyuupRendos.get(0), siharaiDomManager.getMisyuupRendo(pSyono1, pRenno));
        Assert.assertEquals(JT_MisyuupRendos.get(1), siharaiDomManager.getMisyuupRendo(pSyono2, pRenno));
        Assert.assertEquals(JT_MisyuupRendos.get(2), siharaiDomManager.getMisyuupRendo(pSyono2, pRenno2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {
        JT_MisyuupRendo JT_MisyuupRendo1 = siharaiDomManager.getMisyuupRendo(pSyono1, pRenno);

        Assert.assertEquals(pSyono1, JT_MisyuupRendo1.getSyono());
        Assert.assertEquals(pRenno, JT_MisyuupRendo1.getDatarenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyono9 = "SYONO000009";
        Integer pRenno9 = 99;
        JT_MisyuupRendo JT_MisyuupRendo1 = siharaiDomManager.getMisyuupRendo(pSyono9, pRenno9);

        Assert.assertNull(JT_MisyuupRendo1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyonoBlank = "";
        JT_MisyuupRendo JT_MisyuupRendo1 = siharaiDomManager.getMisyuupRendo(pSyonoBlank, pRenno);

        Assert.assertNull(JT_MisyuupRendo1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
