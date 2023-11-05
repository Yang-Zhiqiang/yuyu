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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 新契約伝票データバックアップテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_BAK_SkDenpyoDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        List<HT_BAK_SkDenpyoData> hT_BAK_SkDenpyoDatas = sinkeiyakuDomManager.getAllBAKSkDenpyoData();
        Assert.assertEquals(0, hT_BAK_SkDenpyoDatas.size());

        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData1 = new HT_BAK_SkDenpyoData("D002", "T002", 2);
        sinkeiyakuDomManager.insert(hT_BAK_SkDenpyoData1);
        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData2 = new HT_BAK_SkDenpyoData("D003", "T003", 3);
        sinkeiyakuDomManager.insert(hT_BAK_SkDenpyoData2);
        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData3 = new HT_BAK_SkDenpyoData("D001", "T001", 1);
        sinkeiyakuDomManager.insert(hT_BAK_SkDenpyoData3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBAKSkDenpyoData());

    }


    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_BAK_SkDenpyoData> hT_BAK_SkDenpyoDatas = sinkeiyakuDomManager.getAllBAKSkDenpyoData();

        Assert.assertEquals("D001", hT_BAK_SkDenpyoDatas.get(0).getDenrenno());
        Assert.assertEquals(1, hT_BAK_SkDenpyoDatas.get(0).getEdano().intValue());
        Assert.assertEquals("T001", hT_BAK_SkDenpyoDatas.get(0).getTrkssikibetukey());
        Assert.assertEquals("D002", hT_BAK_SkDenpyoDatas.get(1).getDenrenno());
        Assert.assertEquals(2, hT_BAK_SkDenpyoDatas.get(1).getEdano().intValue());
        Assert.assertEquals("T002", hT_BAK_SkDenpyoDatas.get(1).getTrkssikibetukey());
        Assert.assertEquals("D003", hT_BAK_SkDenpyoDatas.get(2).getDenrenno());
        Assert.assertEquals(3, hT_BAK_SkDenpyoDatas.get(2).getEdano().intValue());
        Assert.assertEquals("T003", hT_BAK_SkDenpyoDatas.get(2).getTrkssikibetukey());

        Assert.assertEquals(3, hT_BAK_SkDenpyoDatas.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData = sinkeiyakuDomManager.getBAKSkDenpyoData("D001", "T001", 1);
        Assert.assertEquals("D001", hT_BAK_SkDenpyoData.getDenrenno());
        Assert.assertEquals(1, hT_BAK_SkDenpyoData.getEdano().intValue());
        Assert.assertEquals("T001", hT_BAK_SkDenpyoData.getTrkssikibetukey());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData = sinkeiyakuDomManager.getBAKSkDenpyoData("D999", "T001", 1);
        Assert.assertNull(hT_BAK_SkDenpyoData);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData = sinkeiyakuDomManager.getBAKSkDenpyoData("", "T001", 1);
        Assert.assertNull(hT_BAK_SkDenpyoData);

        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData2 = sinkeiyakuDomManager.getBAKSkDenpyoData("D001", "", 1);
        Assert.assertNull(hT_BAK_SkDenpyoData2);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);
    }

}
