package yuyu.def.db.entity;

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
public class HT_YuukoukknKykListAtukaiSyaEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno3 = "MOSNO3";
        BizDate pTyouhyouymd3 = BizDate.MAX_VALID_DATE;
        C_KeikaKbn pKeikakbn1 = C_KeikaKbn.YOKOKUKIKAN;
        Integer pRenno1 = 1;

        HT_YuukoukknKykList hT_YuukoukknKykList3 = new HT_YuukoukknKykList(pMosno3, pTyouhyouymd3);

        HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya31 = hT_YuukoukknKykList3.createYuukoukknKykListAtukaiSya();
        hT_YuukoukknKykListAtukaiSya31.setKeikakbn(pKeikakbn1);
        hT_YuukoukknKykListAtukaiSya31.setRenno(pRenno1);

        sinkeiyakuDomManager.insert(hT_YuukoukknKykList3);

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
    public void ToHT_YuukoukknKykList() {

        String pMosno3 = "MOSNO3";
        BizDate pTyouhyouymd3 = BizDate.MAX_VALID_DATE;

        HT_YuukoukknKykList hT_YuukoukknKykList3 = sinkeiyakuDomManager.getYuukoukknKykList(pMosno3, pTyouhyouymd3) ;
        HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya3 = hT_YuukoukknKykList3.getYuukoukknKykListAtukaiSyas().get(0);

        Assert.assertEquals(pMosno3, hT_YuukoukknKykListAtukaiSya3.getYuukoukknKykList().getMosno());


    }

}