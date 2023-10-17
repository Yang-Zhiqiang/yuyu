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
 * 保険金給付金選択情報登録テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiSentakuInfoTourokuEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyono = "1111111111";
    private static final Integer pRenno = 11;
    private static final String pSyono2 = "2222222222";
    private static final Integer pRenno2 = 22;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        JT_SiSentakuInfoTouroku JT_SiSentakuInfoTouroku2 = new JT_SiSentakuInfoTouroku(pSyono2, pRenno2);

        siharaiDomManager.insert(JT_SiSentakuInfoTouroku2);

        JT_SiSentakuInfoTouroku JT_SiSentakuInfoTouroku3 = new JT_SiSentakuInfoTouroku(pSyono2, pRenno);

        siharaiDomManager.insert(JT_SiSentakuInfoTouroku3);

        JT_SiSentakuInfoTouroku JT_SiSentakuInfoTouroku1 = new JT_SiSentakuInfoTouroku(pSyono, pRenno);

        siharaiDomManager.insert(JT_SiSentakuInfoTouroku1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiSentakuInfoTouroku());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SiSentakuInfoTouroku> JT_SiSentakuInfoTourokus = siharaiDomManager.getAllSiSentakuInfoTouroku();

        Assert.assertEquals(3, JT_SiSentakuInfoTourokus.size());

        Assert.assertEquals(JT_SiSentakuInfoTourokus.get(0), siharaiDomManager.getSiSentakuInfoTouroku(pSyono, pRenno));
        Assert.assertEquals(JT_SiSentakuInfoTourokus.get(1), siharaiDomManager.getSiSentakuInfoTouroku(pSyono2, pRenno));
        Assert.assertEquals(JT_SiSentakuInfoTourokus.get(2), siharaiDomManager.getSiSentakuInfoTouroku(pSyono2, pRenno2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SiSentakuInfoTouroku JT_SiSentakuInfoTouroku1 = siharaiDomManager.getSiSentakuInfoTouroku(pSyono, pRenno);


        Assert.assertEquals(pSyono, JT_SiSentakuInfoTouroku1.getSyono());
        Assert.assertEquals(pRenno, JT_SiSentakuInfoTouroku1.getRenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyono9 = "9999999999";
        Integer pRenno9 = 99;

        JT_SiSentakuInfoTouroku JT_SiSentakuInfoTouroku1 = siharaiDomManager.getSiSentakuInfoTouroku(pSyono9, pRenno9);

        Assert.assertNull(JT_SiSentakuInfoTouroku1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyonoBlank = "";

        JT_SiSentakuInfoTouroku JT_SiSentakuInfoTouroku1 = siharaiDomManager.getSiSentakuInfoTouroku(pSyonoBlank, pRenno);

        Assert.assertNull(JT_SiSentakuInfoTouroku1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
