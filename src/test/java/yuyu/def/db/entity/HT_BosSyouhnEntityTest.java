package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_BosSyouhnEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.insert(new BM_SyouhnZokusei("SH01",001));

        HT_BosKihon hT_BosKihon1 = new HT_BosKihon("MOSNOD00001");
        HT_BosSyouhn hT_BosSyouhn1 = hT_BosKihon1.createBosSyouhn();
        hT_BosSyouhn1.setSyouhncd("SH01");
        hT_BosSyouhn1.setSyouhnsdno(001);

        sinkeiyakuDomManager.insert(hT_BosKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());
        sinkeiyakuDomManager.delete(bizDomManager.getAllSyouhnZokusei());

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
    public void getBosKihon() {


        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon("MOSNOD00001") ;
        HT_BosSyouhn hT_BosSyouhn = hT_BosKihon.getBosSyouhns().get(0);
        HT_BosKihon result_hT_BosKihon = hT_BosSyouhn.getBosKihon();

        Assert.assertEquals("MOSNOD00001", result_hT_BosKihon.getMosno());
    }

    @Test
    @TestOrder(70)
    public void getSyouhnZokusei() {
        Assert.assertEquals(bizDomManager.getSyouhnZokusei("SH01", 001), sinkeiyakuDomManager.getBosKihon("MOSNOD00001").getBosSyouhns().get(0).getSyouhnZokusei());
    }
}
