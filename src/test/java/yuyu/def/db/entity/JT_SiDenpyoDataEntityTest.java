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
 * 支払伝票データテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiDenpyoDataEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pDenrenno1 = "1111111111";
    private static final Integer pEdano = 11;

    private static final String pDenrenno2 = "2222222222";
    private static final Integer pEdano2 = 22;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiDenpyoData JT_SiDenpyoData2 = new JT_SiDenpyoData(pDenrenno2, pEdano2);

        siharaiDomManager.insert(JT_SiDenpyoData2);

        JT_SiDenpyoData JT_SiDenpyoData3 = new JT_SiDenpyoData(pDenrenno2, pEdano);

        siharaiDomManager.insert(JT_SiDenpyoData3);

        JT_SiDenpyoData JT_SiDenpyoData1 = new JT_SiDenpyoData(pDenrenno1, pEdano);

        siharaiDomManager.insert(JT_SiDenpyoData1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiDenpyoData());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SiDenpyoData> JT_SiDenpyoDatas = siharaiDomManager.getAllSiDenpyoData();

        Assert.assertEquals(3, JT_SiDenpyoDatas.size());

        Assert.assertEquals(JT_SiDenpyoDatas.get(0), siharaiDomManager.getSiDenpyoData(pDenrenno1, pEdano));
        Assert.assertEquals(JT_SiDenpyoDatas.get(1), siharaiDomManager.getSiDenpyoData(pDenrenno2, pEdano));
        Assert.assertEquals(JT_SiDenpyoDatas.get(2), siharaiDomManager.getSiDenpyoData(pDenrenno2, pEdano2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SiDenpyoData JT_SiDenpyoData1 = siharaiDomManager.getSiDenpyoData(pDenrenno1, pEdano);

        Assert.assertEquals(pDenrenno1, JT_SiDenpyoData1.getDenrenno());
        Assert.assertEquals(pEdano, JT_SiDenpyoData1.getEdano());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pDenrenno9 = "9999999999";
        Integer pEdano9 = 9;
        JT_SiDenpyoData JT_SiDenpyoData1 = siharaiDomManager.getSiDenpyoData(pDenrenno9, pEdano9);

        Assert.assertNull(JT_SiDenpyoData1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pDenrennoBlank = "";
        JT_SiDenpyoData JT_SiDenpyoData1 = siharaiDomManager.getSiDenpyoData(pDenrennoBlank, pEdano);

        Assert.assertNull(JT_SiDenpyoData1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
