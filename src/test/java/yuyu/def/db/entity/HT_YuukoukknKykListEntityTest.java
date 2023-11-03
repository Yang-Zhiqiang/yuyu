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

import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_YuukoukknKykListEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        List<HT_YuukoukknKykList> hT_YuukoukknKykLists = sinkeiyakuDomManager.getAllYuukoukknKykList();
        Assert.assertEquals(0, hT_YuukoukknKykLists.size());

        String pMosno12 = "MOSNO12";
        String pMosno11 = "MOSNO11";
        BizDate pTyouhyouymd22 = BizDate.MAX_VALID_DATE;
        BizDate pTyouhyouymd21 = BizDate.MIN_VALID_DATE;
        HT_YuukoukknKykList hT_YuukoukknKykList22 = new HT_YuukoukknKykList(pMosno12, pTyouhyouymd21);
        sinkeiyakuDomManager.insert(hT_YuukoukknKykList22);

        HT_YuukoukknKykList hT_YuukoukknKykList12 = new HT_YuukoukknKykList(pMosno12, pTyouhyouymd22);
        sinkeiyakuDomManager.insert(hT_YuukoukknKykList12);

        HT_YuukoukknKykList hT_YuukoukknKykList11 = new HT_YuukoukknKykList(pMosno11, pTyouhyouymd22);

        C_KeikaKbn pKeikakbn1 = C_KeikaKbn.YOKOKUKIKAN;
        C_KeikaKbn pKeikakbn2 = C_KeikaKbn.YKKIKANTYOUKA;
        Integer pRenno1 = 1;
        Integer pRenno2 = 2;

        HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya1 = hT_YuukoukknKykList11.createYuukoukknKykListAtukaiSya();
        hT_YuukoukknKykListAtukaiSya1.setKeikakbn(pKeikakbn2);
        hT_YuukoukknKykListAtukaiSya1.setRenno(pRenno1);

        HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya2 = hT_YuukoukknKykList11.createYuukoukknKykListAtukaiSya();
        hT_YuukoukknKykListAtukaiSya2.setKeikakbn(pKeikakbn2);
        hT_YuukoukknKykListAtukaiSya2.setRenno(pRenno2);

        HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya3 = hT_YuukoukknKykList11.createYuukoukknKykListAtukaiSya();
        hT_YuukoukknKykListAtukaiSya3.setKeikakbn(pKeikakbn1);
        hT_YuukoukknKykListAtukaiSya3.setRenno(pRenno2);

        sinkeiyakuDomManager.insert(hT_YuukoukknKykList11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllYuukoukknKykList());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        String pMosno12 = "MOSNO12";
        String pMosno11 = "MOSNO11";
        BizDate pTyouhyouymd22 = BizDate.MAX_VALID_DATE;
        BizDate pTyouhyouymd21 = BizDate.MIN_VALID_DATE;

        List<HT_YuukoukknKykList> hT_YuukoukknKykLists = sinkeiyakuDomManager.getAllYuukoukknKykList();

        Assert.assertEquals(pMosno11,hT_YuukoukknKykLists.get(0).getMosno());
        Assert.assertEquals(pTyouhyouymd22,hT_YuukoukknKykLists.get(0).getTyouhyouymd());
        Assert.assertEquals(pMosno12,hT_YuukoukknKykLists.get(1).getMosno());
        Assert.assertEquals(pTyouhyouymd21,hT_YuukoukknKykLists.get(1).getTyouhyouymd());
        Assert.assertEquals(pMosno12,hT_YuukoukknKykLists.get(2).getMosno());
        Assert.assertEquals(pTyouhyouymd22,hT_YuukoukknKykLists.get(2).getTyouhyouymd());
        Assert.assertEquals(3, hT_YuukoukknKykLists.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pMosno12 = "MOSNO12";
        BizDate pTyouhyouymd22 = BizDate.MAX_VALID_DATE;

        HT_YuukoukknKykList hT_YuukoukknKykList = sinkeiyakuDomManager.getYuukoukknKykList(pMosno12, pTyouhyouymd22) ;
        Assert.assertEquals(pMosno12, hT_YuukoukknKykList.getMosno());
        Assert.assertEquals(pTyouhyouymd22, hT_YuukoukknKykList.getTyouhyouymd());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pMosno33 = "MOSNO33";
        BizDate pTyouhyouymd22 = BizDate.MAX_VALID_DATE;

        HT_YuukoukknKykList hT_YuukoukknKykList = sinkeiyakuDomManager.getYuukoukknKykList(pMosno33, pTyouhyouymd22) ;
        Assert.assertNull(hT_YuukoukknKykList);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pMosno22 = "";
        BizDate pTyouhyouymd22 = BizDate.MAX_VALID_DATE;

        HT_YuukoukknKykList hT_YuukoukknKykList = sinkeiyakuDomManager.getYuukoukknKykList(pMosno22, pTyouhyouymd22) ;
        Assert.assertNull(hT_YuukoukknKykList);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }

    @Test
    @TestOrder(60)
    public void getYuukoukknKykListAtukaiSya() {

        String pMosno11 = "MOSNO11";
        String pMosno12 = "MOSNO12";
        BizDate pTyouhyouymd22 = BizDate.MAX_VALID_DATE;
        BizDate pTyouhyouymd21 = BizDate.MIN_VALID_DATE;
        C_KeikaKbn pKeikakbn1 = C_KeikaKbn.YOKOKUKIKAN;
        C_KeikaKbn pKeikakbn2 = C_KeikaKbn.YKKIKANTYOUKA;
        Integer pRenno1 = 1;
        Integer pRenno2 = 2;

        HT_YuukoukknKykList hT_YuukoukknKykList1 = sinkeiyakuDomManager.getYuukoukknKykList(pMosno11, pTyouhyouymd22) ;
        List<HT_YuukoukknKykListAtukaiSya> hT_YuukoukknKykListAtukaiSyas1 = hT_YuukoukknKykList1.getYuukoukknKykListAtukaiSyas();

        Assert.assertEquals(3, hT_YuukoukknKykListAtukaiSyas1.size());
        Assert.assertEquals(pMosno11, hT_YuukoukknKykListAtukaiSyas1.get(0).getMosno());
        Assert.assertEquals(pTyouhyouymd22, hT_YuukoukknKykListAtukaiSyas1.get(0).getTyouhyouymd());
        Assert.assertEquals(pKeikakbn1, hT_YuukoukknKykListAtukaiSyas1.get(0).getKeikakbn());
        Assert.assertEquals(pRenno2, hT_YuukoukknKykListAtukaiSyas1.get(0).getRenno());
        Assert.assertEquals(pMosno11, hT_YuukoukknKykListAtukaiSyas1.get(1).getMosno());
        Assert.assertEquals(pTyouhyouymd22, hT_YuukoukknKykListAtukaiSyas1.get(1).getTyouhyouymd());
        Assert.assertEquals(pKeikakbn2, hT_YuukoukknKykListAtukaiSyas1.get(1).getKeikakbn());
        Assert.assertEquals(pRenno1, hT_YuukoukknKykListAtukaiSyas1.get(1).getRenno());
        Assert.assertEquals(pMosno11, hT_YuukoukknKykListAtukaiSyas1.get(2).getMosno());
        Assert.assertEquals(pTyouhyouymd22, hT_YuukoukknKykListAtukaiSyas1.get(2).getTyouhyouymd());
        Assert.assertEquals(pKeikakbn2, hT_YuukoukknKykListAtukaiSyas1.get(2).getKeikakbn());
        Assert.assertEquals(pRenno2, hT_YuukoukknKykListAtukaiSyas1.get(2).getRenno());


        HT_YuukoukknKykList hT_YuukoukknKykList2 = sinkeiyakuDomManager.getYuukoukknKykList(pMosno12, pTyouhyouymd21) ;
        Assert.assertEquals(0,hT_YuukoukknKykList2.getYuukoukknKykListAtukaiSyas().size());
        HT_YuukoukknKykList hT_YuukoukknKykList3 = sinkeiyakuDomManager.getYuukoukknKykList(pMosno12, pTyouhyouymd22) ;
        Assert.assertEquals(0,hT_YuukoukknKykList3.getYuukoukknKykListAtukaiSyas().size());

    }

}
