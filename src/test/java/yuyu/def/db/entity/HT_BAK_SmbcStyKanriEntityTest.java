package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * ＳＭＢＣ進捗管理バックアップテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_BAK_SmbcStyKanriEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        List<HT_BAK_SmbcStyKanri> hT_BAK_SmbcStyKanris = sinkeiyakuDomManager.getAllBAKSmbcStyKanri();
        Assert.assertEquals(0, hT_BAK_SmbcStyKanris.size());

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri1 = new HT_BAK_SmbcStyKanri(BizDate.valueOf("20151112"), "222", BizNumber.ONE);

        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri1);
        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri2 = new HT_BAK_SmbcStyKanri(BizDate.valueOf("20151113"), "333", BizNumber.ONE);

        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri2);
        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri3 = new HT_BAK_SmbcStyKanri(BizDate.valueOf("20151111"), "111", BizNumber.ONE);

        sinkeiyakuDomManager.insert(hT_BAK_SmbcStyKanri3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBAKSmbcStyKanri());
    }


    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_BAK_SmbcStyKanri> hT_BAK_SmbcStyKanris = sinkeiyakuDomManager.getAllBAKSmbcStyKanri();

        Assert.assertEquals(BizNumber.ONE, hT_BAK_SmbcStyKanris.get(0).getDatasakuseirenno());
        Assert.assertEquals(BizDate.valueOf("20151111"), hT_BAK_SmbcStyKanris.get(0).getDatarenymd());
        Assert.assertEquals("111", hT_BAK_SmbcStyKanris.get(0).getTrkssikibetukey());
        Assert.assertEquals(BizNumber.ONE, hT_BAK_SmbcStyKanris.get(1).getDatasakuseirenno());
        Assert.assertEquals(BizDate.valueOf("20151112"), hT_BAK_SmbcStyKanris.get(1).getDatarenymd());
        Assert.assertEquals("222", hT_BAK_SmbcStyKanris.get(1).getTrkssikibetukey());
        Assert.assertEquals(BizNumber.ONE, hT_BAK_SmbcStyKanris.get(2).getDatasakuseirenno());
        Assert.assertEquals(BizDate.valueOf("20151113"), hT_BAK_SmbcStyKanris.get(2).getDatarenymd());
        Assert.assertEquals("333", hT_BAK_SmbcStyKanris.get(2).getTrkssikibetukey());

        Assert.assertEquals(3, hT_BAK_SmbcStyKanris.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri = sinkeiyakuDomManager.getBAKSmbcStyKanri(BizDate.valueOf("20151111"), "111", BizNumber.ONE);
        Assert.assertEquals(BizNumber.ONE, hT_BAK_SmbcStyKanri.getDatasakuseirenno());
        Assert.assertEquals(BizDate.valueOf("20151111"), hT_BAK_SmbcStyKanri.getDatarenymd());
        Assert.assertEquals("111", hT_BAK_SmbcStyKanri.getTrkssikibetukey());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri = sinkeiyakuDomManager.getBAKSmbcStyKanri(BizDate.valueOf("20151111"), "123", BizNumber.ONE);
        Assert.assertNull(hT_BAK_SmbcStyKanri);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri = sinkeiyakuDomManager.getBAKSmbcStyKanri(BizDate.valueOf("20151111"), "", BizNumber.ONE);
        Assert.assertNull(hT_BAK_SmbcStyKanri);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);
    }

}
