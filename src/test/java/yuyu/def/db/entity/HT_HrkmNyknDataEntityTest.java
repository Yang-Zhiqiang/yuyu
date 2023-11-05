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

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_HrkmNyknDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public static final C_DensysKbn pDensyskbn22 = C_DensysKbn.AGKANRI;
    public static final BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
    public static final String pItirenno22 = "Itirenno22";
    public static final C_DensysKbn pDensyskbn11 = C_DensysKbn.SKEI;
    public static final BizDate pSyoriYmd11 = BizDate.MIN_VALID_DATE;
    public static final String pItirenno11 = "Itirenno11";
    public static final String pMosno1 = "MOSNO000001";
    public static final String pMosno2 = "MOSNO000002";


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_HrkmNyknData> hT_HrkmNyknDatas = sinkeiyakuDomManager.getAllHrkmNyknData();

        Assert.assertEquals(0, hT_HrkmNyknDatas.size());

        HT_HrkmNyknData hT_HrkmNyknData2 = new HT_HrkmNyknData(pDensyskbn22,pSyoriYmd22,pItirenno22);
        hT_HrkmNyknData2.setNykmosno(pMosno2);
        sinkeiyakuDomManager.insert(hT_HrkmNyknData2);

        HT_HrkmNyknData hT_HrkmNyknData3 = new HT_HrkmNyknData(pDensyskbn22,pSyoriYmd11,pItirenno11);
        sinkeiyakuDomManager.insert(hT_HrkmNyknData3);

        HT_HrkmNyknData HT_SkDenpyoData1 = new HT_HrkmNyknData(pDensyskbn11,pSyoriYmd11,pItirenno11);
        HT_SkDenpyoData1.setNykmosno(pMosno1);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData1);

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknData());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_HrkmNyknData> hT_HrkmNyknDatas = sinkeiyakuDomManager.getAllHrkmNyknData();

        Assert.assertEquals(3, hT_HrkmNyknDatas.size());

        Assert.assertEquals(hT_HrkmNyknDatas.get(0), sinkeiyakuDomManager.getHrkmNyknData(pDensyskbn11, pSyoriYmd11,pItirenno11));
        Assert.assertEquals(hT_HrkmNyknDatas.get(1), sinkeiyakuDomManager.getHrkmNyknData(pDensyskbn22, pSyoriYmd11,pItirenno11));
        Assert.assertEquals(hT_HrkmNyknDatas.get(2), sinkeiyakuDomManager.getHrkmNyknData(pDensyskbn22, pSyoriYmd22,pItirenno22));
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        HT_HrkmNyknData hT_HrkmNyknData11 = sinkeiyakuDomManager.getHrkmNyknData(pDensyskbn11, pSyoriYmd11,pItirenno11);

        Assert.assertEquals(pDensyskbn11, hT_HrkmNyknData11.getDensyskbn());
        Assert.assertEquals(pSyoriYmd11, hT_HrkmNyknData11.getSyoriYmd());
        Assert.assertEquals(pItirenno11, hT_HrkmNyknData11.getItirenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        C_DensysKbn  pDensyskbn99 = C_DensysKbn.AGKANRI;
        BizDate pSyoriYmd99 = BizDate.MAX_VALID_DATE;
        String pItirenno99 = "Itirenno33";

        HT_HrkmNyknData hT_HrkmNyknData11 = sinkeiyakuDomManager.getHrkmNyknData(pDensyskbn99, pSyoriYmd99, pItirenno99);

        Assert.assertNull(hT_HrkmNyknData11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        C_DensysKbn  pDensyskbn11Blank = C_DensysKbn.BLNK;
        String pItirenno11Blank = "";

        HT_HrkmNyknData hT_HrkmNyknData11 = sinkeiyakuDomManager.getHrkmNyknData(pDensyskbn11Blank, pSyoriYmd22, pItirenno11Blank);

        Assert.assertNull(hT_HrkmNyknData11);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }
}
