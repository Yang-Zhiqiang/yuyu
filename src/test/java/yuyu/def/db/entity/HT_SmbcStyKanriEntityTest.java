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


@RunWith(SWAKTestRunner.class)
public class HT_SmbcStyKanriEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0,sinkeiyakuDomManager.getAllSmbcStyKanri().size());

        BizDate pDatarenymd1 = BizDate.valueOf(20100101);
        BizDate pDatarenymd2 = BizDate.valueOf(20100202);

        BizNumber pDatasakuseirenno22 = BizNumber.valueOf(22);

        HT_SmbcStyKanri hT_SmbcStyKanri22 = new HT_SmbcStyKanri(pDatarenymd2,pDatasakuseirenno22);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanri22);

        BizNumber pDatasakuseirenno21 = BizNumber.valueOf(21);

        HT_SmbcStyKanri hT_SmbcStyKanri21 = new HT_SmbcStyKanri(pDatarenymd1,pDatasakuseirenno21);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanri21);

        BizNumber pDatasakuseirenno12 = BizNumber.valueOf(12);

        HT_SmbcStyKanri hT_SmbcStyKanri12 = new HT_SmbcStyKanri(pDatarenymd2,pDatasakuseirenno12);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanri12);

        BizNumber pDatasakuseirenno11 = BizNumber.valueOf(11);

        HT_SmbcStyKanri hT_SmbcStyKanri11 = new HT_SmbcStyKanri(pDatarenymd1,pDatasakuseirenno11);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanri11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        BizDate pDatarenymd1 = BizDate.valueOf(20100101);
        BizDate pDatarenymd2 = BizDate.valueOf(20100202);
        BizNumber pDatasakuseirenno22 = BizNumber.valueOf(22);
        BizNumber pDatasakuseirenno21 = BizNumber.valueOf(21);
        BizNumber pDatasakuseirenno12 = BizNumber.valueOf(12);
        BizNumber pDatasakuseirenno11 = BizNumber.valueOf(11);

        List<HT_SmbcStyKanri> hT_SmbcStyKanris = sinkeiyakuDomManager.getAllSmbcStyKanri();

        Assert.assertEquals(pDatarenymd1,hT_SmbcStyKanris.get(0).getDatarenymd());
        Assert.assertEquals(pDatasakuseirenno11, hT_SmbcStyKanris.get(0).getDatasakuseirenno());
        Assert.assertEquals(pDatarenymd1,hT_SmbcStyKanris.get(1).getDatarenymd());
        Assert.assertEquals(pDatasakuseirenno21,hT_SmbcStyKanris.get(1).getDatasakuseirenno());
        Assert.assertEquals(pDatarenymd2,hT_SmbcStyKanris.get(2).getDatarenymd());
        Assert.assertEquals(pDatasakuseirenno12,hT_SmbcStyKanris.get(2).getDatasakuseirenno());
        Assert.assertEquals(pDatarenymd2,hT_SmbcStyKanris.get(3).getDatarenymd());
        Assert.assertEquals(pDatasakuseirenno22,hT_SmbcStyKanris.get(3).getDatasakuseirenno());

        Assert.assertEquals(4, hT_SmbcStyKanris.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        BizDate pDatarenymd1 = BizDate.valueOf(20100101);
        BizNumber pDatasakuseirenno11 = BizNumber.valueOf(11);

        HT_SmbcStyKanri hT_SmbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(pDatarenymd1, pDatasakuseirenno11);
        Assert.assertEquals(pDatarenymd1, hT_SmbcStyKanri.getDatarenymd());
        Assert.assertEquals(pDatasakuseirenno11, hT_SmbcStyKanri.getDatasakuseirenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        BizDate pDatarenymdMax = BizDate.MAX_VALID_DATE;
        BizNumber pDatasakuseirenno33 = BizNumber.valueOf(33);

        HT_SmbcStyKanri hT_SmbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(pDatarenymdMax, pDatasakuseirenno33);
        Assert.assertNull(hT_SmbcStyKanri);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        //        HT_SmbcStyKanri hT_SmbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(Constants.DATARENYMD_BLANK, Constants.DATASAKUSEIRENNO_WRONG);
        //        Assert.assertNull(hT_SmbcStyKanri);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }
}
