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

/**
 * 入金テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_GaikaHrkmNyknDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        List<HT_GaikaHrkmNyknData> hT_GaikaHrkmNyknDatas = sinkeiyakuDomManager.getAllGaikaHrkmNyknData();
        Assert.assertEquals(0,hT_GaikaHrkmNyknDatas.size());
        sinkeiyakuDomManager.insert(new HT_SyoriCTL("001"));
        sinkeiyakuDomManager.insert(new HT_SyoriCTL("002"));

        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI,BizDate.valueOf("20151111"),"002");
        hT_GaikaHrkmNyknData1.setNykmosno("001");
        sinkeiyakuDomManager.insert(hT_GaikaHrkmNyknData1);
        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK,BizDate.valueOf("20151110"),"002");
        hT_GaikaHrkmNyknData2.setNykmosno("002");
        sinkeiyakuDomManager.insert(hT_GaikaHrkmNyknData2);
        sinkeiyakuDomManager.insert(new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK,BizDate.valueOf("20151111"),"002"));
        sinkeiyakuDomManager.insert(new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI,BizDate.valueOf("20151111"),"001"));

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_GaikaHrkmNyknData> hT_GaikaHrkmNyknDatas = sinkeiyakuDomManager.getAllGaikaHrkmNyknData();

        Assert.assertEquals(C_DensysKbn.BLNK,hT_GaikaHrkmNyknDatas.get(0).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf("20151110"),hT_GaikaHrkmNyknDatas.get(0).getSyoriYmd());
        Assert.assertEquals("002",hT_GaikaHrkmNyknDatas.get(0).getItirenno());

        Assert.assertEquals(C_DensysKbn.BLNK,hT_GaikaHrkmNyknDatas.get(1).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf("20151111"),hT_GaikaHrkmNyknDatas.get(1).getSyoriYmd());
        Assert.assertEquals("002",hT_GaikaHrkmNyknDatas.get(1).getItirenno());

        Assert.assertEquals(C_DensysKbn.SKEI,hT_GaikaHrkmNyknDatas.get(2).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf("20151111"),hT_GaikaHrkmNyknDatas.get(2).getSyoriYmd());
        Assert.assertEquals("001",hT_GaikaHrkmNyknDatas.get(2).getItirenno());

        Assert.assertEquals(C_DensysKbn.SKEI,hT_GaikaHrkmNyknDatas.get(3).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf("20151111"),hT_GaikaHrkmNyknDatas.get(3).getSyoriYmd());
        Assert.assertEquals("002",hT_GaikaHrkmNyknDatas.get(3).getItirenno());

        Assert.assertEquals(4, hT_GaikaHrkmNyknDatas.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData11 = sinkeiyakuDomManager.getGaikaHrkmNyknData(C_DensysKbn.BLNK,BizDate.valueOf("20151111"),"002");

        Assert.assertEquals(C_DensysKbn.BLNK, hT_GaikaHrkmNyknData11.getDensyskbn());
        Assert.assertEquals(BizDate.valueOf("20151111"), hT_GaikaHrkmNyknData11.getSyoriYmd());
        Assert.assertEquals("002", hT_GaikaHrkmNyknData11.getItirenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        C_DensysKbn  pDensyskbn22 = C_DensysKbn.AGKANRI;
        BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
        String pItirenno33 = "Itirenno33";

        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData11 = sinkeiyakuDomManager.getGaikaHrkmNyknData(pDensyskbn22, pSyoriYmd22,pItirenno33);

        Assert.assertNull(hT_GaikaHrkmNyknData11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        C_DensysKbn  pDensyskbn11 = C_DensysKbn.BLNK;
        BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
        String pItirenno11 = "";

        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData11 = sinkeiyakuDomManager.getGaikaHrkmNyknData(pDensyskbn11, pSyoriYmd22,pItirenno11);

        Assert.assertNull(hT_GaikaHrkmNyknData11);
    }

    @Override
    public void nullCondition() {
        Assert.assertTrue(true);

    }
}
