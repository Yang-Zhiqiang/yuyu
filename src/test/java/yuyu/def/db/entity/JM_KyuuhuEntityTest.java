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
 * 給付マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JM_KyuuhuEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pKyuuhucd1 = "1111";
    private static final String pKyuuhucd2 = "2222";
    private static final String pKyuuhucd3 = "3333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JM_Kyuuhu JM_Kyuuhu2 = new JM_Kyuuhu(pKyuuhucd2);

        siharaiDomManager.insert(JM_Kyuuhu2);

        JM_Kyuuhu JM_Kyuuhu3 = new JM_Kyuuhu(pKyuuhucd3);

        siharaiDomManager.insert(JM_Kyuuhu3);

        JM_Kyuuhu JM_Kyuuhu1 = new JM_Kyuuhu(pKyuuhucd1);

        siharaiDomManager.insert(JM_Kyuuhu1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JM_Kyuuhu JM_Kyuuhu1 = siharaiDomManager.getKyuuhu(pKyuuhucd1);
        siharaiDomManager.delete(JM_Kyuuhu1);

        JM_Kyuuhu JM_Kyuuhu2 = siharaiDomManager.getKyuuhu(pKyuuhucd2);
        siharaiDomManager.delete(JM_Kyuuhu2);

        JM_Kyuuhu JM_Kyuuhu3 = siharaiDomManager.getKyuuhu(pKyuuhucd3);
        siharaiDomManager.delete(JM_Kyuuhu3);
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JM_Kyuuhu> JM_Kyuuhus = siharaiDomManager.getAllKyuuhu();

        Assert.assertEquals(3, JM_Kyuuhus.size());

        Assert.assertEquals(JM_Kyuuhus.get(0), siharaiDomManager.getKyuuhu(pKyuuhucd1));
        Assert.assertEquals(JM_Kyuuhus.get(1), siharaiDomManager.getKyuuhu(pKyuuhucd2));
        Assert.assertEquals(JM_Kyuuhus.get(2), siharaiDomManager.getKyuuhu(pKyuuhucd3));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JM_Kyuuhu JM_Kyuuhu1 = siharaiDomManager.getKyuuhu(pKyuuhucd1);

        Assert.assertEquals(pKyuuhucd1, JM_Kyuuhu1.getKyuuhucd());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pKyuuhucdNo = "9999";

        JM_Kyuuhu JM_Kyuuhu1 = siharaiDomManager.getKyuuhu(pKyuuhucdNo);

        Assert.assertNull(JM_Kyuuhu1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pKyuuhucdBlank = "";

        JM_Kyuuhu JM_Kyuuhu1 = siharaiDomManager.getKyuuhu(pKyuuhucdBlank);

        Assert.assertNull(JM_Kyuuhu1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
