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
 * 応対テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_OutaiEntityTest implements EntityTestInterface {

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


        JT_Outai JT_Outai2 = new JT_Outai(pSyono2, pRenno2);

        siharaiDomManager.insert(JT_Outai2);

        JT_Outai JT_Outai3 = new JT_Outai(pSyono2, pRenno);

        siharaiDomManager.insert(JT_Outai3);

        JT_Outai JT_Outai1 = new JT_Outai(pSyono1, pRenno);

        siharaiDomManager.insert(JT_Outai1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllOutai());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_Outai> JT_Outais = siharaiDomManager.getAllOutai();

        Assert.assertEquals(3, JT_Outais.size());

        Assert.assertEquals(JT_Outais.get(0), siharaiDomManager.getOutai(pSyono1, pRenno));
        Assert.assertEquals(JT_Outais.get(1), siharaiDomManager.getOutai(pSyono2, pRenno));
        Assert.assertEquals(JT_Outais.get(2), siharaiDomManager.getOutai(pSyono2, pRenno2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_Outai JT_Outai1 = siharaiDomManager.getOutai(pSyono1, pRenno);

        Assert.assertEquals(pSyono1, JT_Outai1.getSyono());
        Assert.assertEquals(pRenno, JT_Outai1.getRenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyono9 = "SYONO000009";
        Integer pRenno9 = 99;
        JT_Outai JT_Outai1 = siharaiDomManager.getOutai(pSyono9, pRenno9);

        Assert.assertNull(JT_Outai1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyonoBlank = "";
        JT_Outai JT_Outai1 = siharaiDomManager.getOutai(pSyonoBlank, pRenno);

        Assert.assertNull(JT_Outai1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
