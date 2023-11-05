package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払調書テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SiTyousyoEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyono = "1111111111";
    private static final BizDate pTyouhyouymd = BizDate.valueOf("11111111");
    private static final Long pShrtysyrenno = 1111111111L;
    private static final String pSyono2 = "2222222222";
    private static final BizDate pTyouhyouymd2 = BizDate.valueOf("11111212");
    private static final Long pShrtysyrenno2 = 2222222222L;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiTyousyo JT_SiTyousyo2 = new JT_SiTyousyo(pSyono2, pTyouhyouymd2, pShrtysyrenno2);

        siharaiDomManager.insert(JT_SiTyousyo2);

        JT_SiTyousyo JT_SiTyousyo3 = new JT_SiTyousyo(pSyono2, pTyouhyouymd, pShrtysyrenno);

        siharaiDomManager.insert(JT_SiTyousyo3);

        JT_SiTyousyo JT_SiTyousyo1 = new JT_SiTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);

        siharaiDomManager.insert(JT_SiTyousyo1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiTyousyo());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JT_SiTyousyo> JT_SiTyousyos = siharaiDomManager.getAllSiTyousyo();

        Assert.assertEquals(3, JT_SiTyousyos.size());

        Assert.assertEquals(JT_SiTyousyos.get(0), siharaiDomManager.getSiTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno));
        Assert.assertEquals(JT_SiTyousyos.get(1), siharaiDomManager.getSiTyousyo(pSyono2, pTyouhyouymd, pShrtysyrenno));
        Assert.assertEquals(JT_SiTyousyos.get(2), siharaiDomManager.getSiTyousyo(pSyono2, pTyouhyouymd2, pShrtysyrenno2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        JT_SiTyousyo JT_SiTyousyo1 = siharaiDomManager.getSiTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);


        Assert.assertEquals(pSyono, JT_SiTyousyo1.getSyono());
        Assert.assertEquals(pTyouhyouymd, JT_SiTyousyo1.getTyouhyouymd());
        Assert.assertEquals(pShrtysyrenno, JT_SiTyousyo1.getShrtysyrenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyono9 = "9999999999";
        BizDate pTyouhyouymd9 = BizDate.valueOf("99999999");
        Long pShrtysyrenno9 = 99999999L;

        JT_SiTyousyo JT_SiTyousyo1 = siharaiDomManager.getSiTyousyo(pSyono9, pTyouhyouymd9, pShrtysyrenno9);

        Assert.assertNull(JT_SiTyousyo1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyonoBlank = "";
        Long pShrtysyrennoBlank = 0L;

        JT_SiTyousyo JT_SiTyousyo1 = siharaiDomManager.getSiTyousyo(pSyonoBlank, pTyouhyouymd, pShrtysyrennoBlank);

        Assert.assertNull(JT_SiTyousyo1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
