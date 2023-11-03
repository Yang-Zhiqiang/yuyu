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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HW_HrkmNyknTaisyouWkEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
        BizDate pSyoriYmd21 = BizDate.MIN_VALID_DATE;
        String pMosno22 = "MOSNO22";
        Integer pRenno22 = 22;
        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk22 = new HW_HrkmNyknTaisyouWk(pSyoriYmd22,pMosno22,pRenno22);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk22);

        Integer pRenno21 = 21;
        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk21 = new HW_HrkmNyknTaisyouWk(pSyoriYmd22,pMosno22,pRenno21);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk21);

        String pMosno12 = "MOSNO12";
        Integer pRenno12 = 12;
        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk12 = new HW_HrkmNyknTaisyouWk(pSyoriYmd22,pMosno12,pRenno12);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk12);

        String pMosno11 = "MOSNO11";
        Integer pRenno11 = 11;
        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk11 = new HW_HrkmNyknTaisyouWk(pSyoriYmd21,pMosno11,pRenno11);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknTaisyouWk());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {
        BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
        BizDate pSyoriYmd21 = BizDate.MIN_VALID_DATE;
        String pMosno22 = "MOSNO22";
        Integer pRenno22 = 22;

        Integer pRenno21 = 21;

        String pMosno12 = "MOSNO12";
        Integer pRenno12 = 12;

        String pMosno11 = "MOSNO11";
        Integer pRenno11 = 11;


        List<HW_HrkmNyknTaisyouWk> hW_HrkmNyknTaisyouWks = sinkeiyakuDomManager.getAllHrkmNyknTaisyouWk();
        Assert.assertSame(pSyoriYmd21,hW_HrkmNyknTaisyouWks.get(0).getSyoriYmd());
        Assert.assertSame(pMosno11,hW_HrkmNyknTaisyouWks.get(0).getMosno());
        Assert.assertSame(pRenno11,hW_HrkmNyknTaisyouWks.get(0).getRenno());
        Assert.assertSame(pSyoriYmd22,hW_HrkmNyknTaisyouWks.get(1).getSyoriYmd());
        Assert.assertSame(pMosno12,hW_HrkmNyknTaisyouWks.get(1).getMosno());
        Assert.assertSame(pRenno12,hW_HrkmNyknTaisyouWks.get(1).getRenno());

        Assert.assertSame(pSyoriYmd22,hW_HrkmNyknTaisyouWks.get(2).getSyoriYmd());
        Assert.assertSame(pMosno22,hW_HrkmNyknTaisyouWks.get(2).getMosno());
        Assert.assertSame(pRenno21,hW_HrkmNyknTaisyouWks.get(2).getRenno());

        Assert.assertSame(pSyoriYmd22,hW_HrkmNyknTaisyouWks.get(3).getSyoriYmd());
        Assert.assertSame(pMosno22,hW_HrkmNyknTaisyouWks.get(3).getMosno());
        Assert.assertSame(pRenno22,hW_HrkmNyknTaisyouWks.get(3).getRenno());


        Assert.assertEquals(4, hW_HrkmNyknTaisyouWks.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
        String pMosno22 = "MOSNO22";
        Integer pRenno22 = 22;

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk11 = sinkeiyakuDomManager.getHrkmNyknTaisyouWk(pSyoriYmd22, pMosno22,pRenno22);

        Assert.assertEquals(pSyoriYmd22, hW_HrkmNyknTaisyouWk11.getSyoriYmd());
        Assert.assertEquals(pMosno22, hW_HrkmNyknTaisyouWk11.getMosno());
        Assert.assertEquals(pRenno22, hW_HrkmNyknTaisyouWk11.getRenno());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
        String pMosno33 = "MOSNO33";
        Integer pRenno33 = 33;

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk11 = sinkeiyakuDomManager.getHrkmNyknTaisyouWk(pSyoriYmd22, pMosno33,pRenno33);

        Assert.assertNull(hW_HrkmNyknTaisyouWk11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        BizDate pSyoriYmd22 = BizDate.MAX_VALID_DATE;
        String pMosno22 = "";
        Integer pRenno22 = 22;

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk11 = sinkeiyakuDomManager.getHrkmNyknTaisyouWk(pSyoriYmd22, pMosno22,pRenno22);

        Assert.assertNull(hW_HrkmNyknTaisyouWk11);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
