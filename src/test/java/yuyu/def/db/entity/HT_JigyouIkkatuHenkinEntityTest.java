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
public class HT_JigyouIkkatuHenkinEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pDaimosno33 = "DAINO000001";
        HT_JigyouIkkatu HT_JigyouIkkatu1 = new HT_JigyouIkkatu(pDaimosno33);

        Integer pRenno1 = 11;
        HT_JigyouIkkatuHenkin HT_JigyouIkkatuHenkin1 = HT_JigyouIkkatu1.createJigyouIkkatuHenkin();
        HT_JigyouIkkatuHenkin1.setRenno(pRenno1);

        Integer pRenno2 = 22;
        HT_JigyouIkkatuHenkin HT_JigyouIkkatuHenkin2 = HT_JigyouIkkatu1.createJigyouIkkatuHenkin();
        HT_JigyouIkkatuHenkin2.setRenno(pRenno2);

        Integer pRenno3 = 33;
        HT_JigyouIkkatuHenkin HT_JigyouIkkatuHenkin3 = HT_JigyouIkkatu1.createJigyouIkkatuHenkin();
        HT_JigyouIkkatuHenkin3.setRenno(pRenno3);

        sinkeiyakuDomManager.insert(HT_JigyouIkkatu1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJigyouIkkatu());

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
    public void getJigyouIkkatu() {
        String pDaimosno33 = "DAINO000001";

        HT_JigyouIkkatu HT_JigyouIkkatu1 = sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno33);
        List<HT_JigyouIkkatuHenkin> HT_JigyouIkkatuHenkins = HT_JigyouIkkatu1.getJigyouIkkatuHenkins();
        Assert.assertSame(HT_JigyouIkkatuHenkins.get(0).getJigyouIkkatu(), HT_JigyouIkkatu1);
    }
}
