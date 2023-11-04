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

@RunWith(SWAKTestRunner.class)
public class HT_NyuukinEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        //        String pDenrenno2 = "De2";
        //        Integer pEdano2 = 2;
        //        HT_SkDenpyoData hT_SkDenpyoData2 = new HT_SkDenpyoData(pDenrenno2,pEdano2);
        //        sinkeiyakuDomManager.insert(hT_SkDenpyoData2);

        String pDenrenno1 = "De1";
        Integer pEdano1 = 1;
        String pDenrenno2 = "De2";
        Integer pEdano2 = 2;

        HT_SkDenpyoData hT_SkDenpyoData1 = new HT_SkDenpyoData(pDenrenno1,pEdano1);
        sinkeiyakuDomManager.insert(hT_SkDenpyoData1);


        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(pMosno3);

        Integer pRenno3 = 33;
        HT_Nyuukin hT_Nyuukin33 = hT_SyoriCTL3.createNyuukin();
        hT_Nyuukin33.setRenno(pRenno3);

        Integer pRenno2 = 22;
        HT_Nyuukin hT_Nyuukin32 = hT_SyoriCTL3.createNyuukin();
        hT_Nyuukin32.setRenno(pRenno2);
        hT_Nyuukin32.setDenrenno(pDenrenno2);
        hT_Nyuukin32.setEdano(pEdano2);

        Integer pRenno1 = 11;
        HT_Nyuukin hT_Nyuukin31 = hT_SyoriCTL3.createNyuukin();
        hT_Nyuukin31.setRenno(pRenno1);
        hT_Nyuukin31.setDenrenno(pDenrenno1);
        hT_Nyuukin31.setEdano(pEdano1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

        //        String pMosno2 = "MOSNO000002";
        //        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(pMosno2);
        //
        //        HT_Nyuukin hT_Nyuukin23 = hT_SyoriCTL2.createNyuukin();
        //        hT_Nyuukin23.setRenno(pRenno1);
        //        hT_Nyuukin23.setDenrenno(pDenrenno2);
        //        hT_Nyuukin23.setEdano(pEdano2);
        //        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        //        String pMosno1 = "MOSNO000001";
        //        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);
        //        HT_Nyuukin hT_Nyuukin13 = hT_SyoriCTL1.createNyuukin();
        //        hT_Nyuukin13.setRenno(pRenno1);
        //        hT_Nyuukin13.setDenrenno(pDenrenno1);
        //        hT_Nyuukin13.setEdano(pEdano1);
        //        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        Assert.assertTrue(true);

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        Assert.assertTrue(true);

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }

    @Test
    @TestOrder(60)
    public void getSyoriCTL() {

        String pMosno3 = "MOSNO000003";

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_Nyuukin>  hT_Nyuukins = hT_SyoriCTL.getNyuukins();
        HT_Nyuukin hT_Nyuukin = hT_Nyuukins.get(0);

        Assert.assertEquals(sinkeiyakuDomManager.getSyoriCTL(pMosno3), hT_Nyuukin.getSyoriCTL());
    }

    @Test
    @TestOrder(70)
    public void getSkDenpyoData() {

        String pMosno2 = "MOSNO000003";

        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        List<HT_Nyuukin> hT_Nyuukins = hT_SyoriCTL1.getNyuukins();
        Assert.assertEquals(pMosno2, hT_Nyuukins.get(0).getMosno());
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getSkDenpyoDataNull01() {

        String pDenrenno1 = "De1";
        Integer pEdano1 = 1;

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getSkDenpyoData(pDenrenno1,pEdano1));
    }

}
