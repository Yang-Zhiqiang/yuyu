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
 * 手術給付マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JM_SyujyutuKyuuhuEntityTest implements EntityTestInterface {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSyujyutubunruicd = "111";
    private static final String pSyouhncd = "1111";
    private static final Integer pSyouhnsdno = 11;
    private static final String pKyuuhucd = "1111";
    private static final BizDate pSyujyututekiyoukkanfrom = BizDate.valueOf("11111111");
    private static final BizDate pSyujyututekiyoukkanto = BizDate.valueOf("11111111");

    private static final String pSyujyutubunruicd2 = "222";
    private static final String pSyouhncd2 = "2222";
    private static final Integer pSyouhnsdno2 = 22;
    private static final String pKyuuhucd2 = "2222";
    private static final BizDate pSyujyututekiyoukkanfrom2 = BizDate.valueOf("22222222");
    private static final BizDate pSyujyututekiyoukkanto2 = BizDate.valueOf("22222222");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        JM_SyujyutuKyuuhu JM_SyujyutuKyuuhu1 = new JM_SyujyutuKyuuhu(pSyujyutubunruicd, pSyouhncd, pSyouhnsdno, pKyuuhucd, pSyujyututekiyoukkanfrom, pSyujyututekiyoukkanto);

        siharaiDomManager.insert(JM_SyujyutuKyuuhu1);

        JM_SyujyutuKyuuhu JM_SyujyutuKyuuhu2 = new JM_SyujyutuKyuuhu(pSyujyutubunruicd2, pSyouhncd2, pSyouhnsdno2, pKyuuhucd2, pSyujyututekiyoukkanfrom2, pSyujyututekiyoukkanto2);

        siharaiDomManager.insert(JM_SyujyutuKyuuhu2);

        JM_SyujyutuKyuuhu JM_SyujyutuKyuuhu3 = new JM_SyujyutuKyuuhu(pSyujyutubunruicd2, pSyouhncd, pSyouhnsdno, pKyuuhucd, pSyujyututekiyoukkanfrom, pSyujyututekiyoukkanto);

        siharaiDomManager.insert(JM_SyujyutuKyuuhu3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSyujyutuKyuuhu());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<JM_SyujyutuKyuuhu> JM_SyujyutuKyuuhus = siharaiDomManager.getAllSyujyutuKyuuhu();

        Assert.assertEquals(3, JM_SyujyutuKyuuhus.size());

        Assert.assertEquals(JM_SyujyutuKyuuhus.get(0), siharaiDomManager.getSyujyutuKyuuhu(pSyujyutubunruicd, pSyouhncd, pSyouhnsdno, pKyuuhucd, pSyujyututekiyoukkanfrom, pSyujyututekiyoukkanto));
        Assert.assertEquals(JM_SyujyutuKyuuhus.get(1), siharaiDomManager.getSyujyutuKyuuhu(pSyujyutubunruicd2, pSyouhncd, pSyouhnsdno, pKyuuhucd, pSyujyututekiyoukkanfrom, pSyujyututekiyoukkanto));
        Assert.assertEquals(JM_SyujyutuKyuuhus.get(2), siharaiDomManager.getSyujyutuKyuuhu(pSyujyutubunruicd2, pSyouhncd2, pSyouhnsdno2, pKyuuhucd2, pSyujyututekiyoukkanfrom2, pSyujyututekiyoukkanto2));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {
        JM_SyujyutuKyuuhu JM_SyujyutuKyuuhu1 = siharaiDomManager.getSyujyutuKyuuhu(pSyujyutubunruicd, pSyouhncd, pSyouhnsdno, pKyuuhucd, pSyujyututekiyoukkanfrom, pSyujyututekiyoukkanto);
        Assert.assertEquals(pSyujyutubunruicd, JM_SyujyutuKyuuhu1.getSyujyutubunruicd());
        Assert.assertEquals(pSyouhncd, JM_SyujyutuKyuuhu1.getSyouhncd());
        Assert.assertEquals(pSyouhnsdno, JM_SyujyutuKyuuhu1.getSyouhnsdno());
        Assert.assertEquals(pKyuuhucd, JM_SyujyutuKyuuhu1.getKyuuhucd());
        Assert.assertEquals(pSyujyututekiyoukkanfrom, JM_SyujyutuKyuuhu1.getSyujyututekiyoukkanfrom());
        Assert.assertEquals(pSyujyututekiyoukkanto, JM_SyujyutuKyuuhu1.getSyujyututekiyoukkanto());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyujyutubunruicd9 = "999";
        String pSyouhncd9 = "9999";
        Integer pSyouhnsdno9 = 99;
        String pKyuuhucd9 = "9999";
        BizDate pSyujyututekiyoukkanfrom9 = BizDate.valueOf("99999999");
        BizDate pSyujyututekiyoukkanto9 = BizDate.valueOf("99999999");
        JM_SyujyutuKyuuhu JM_SyujyutuKyuuhu1 = siharaiDomManager.getSyujyutuKyuuhu(pSyujyutubunruicd9, pSyouhncd9, pSyouhnsdno9, pKyuuhucd9, pSyujyututekiyoukkanfrom9, pSyujyututekiyoukkanto9);

        Assert.assertNull(JM_SyujyutuKyuuhu1);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyujyutubunruicdBlank = "";
        String pSyouhncdBlank = "";
        String pKyuuhucdBlank = "";

        JM_SyujyutuKyuuhu JM_SyujyutuKyuuhu1 = siharaiDomManager.getSyujyutuKyuuhu(pSyujyutubunruicdBlank, pSyouhncdBlank, pSyouhnsdno, pKyuuhucdBlank, pSyujyututekiyoukkanfrom, pSyujyututekiyoukkanto);

        Assert.assertNull(JM_SyujyutuKyuuhu1);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
