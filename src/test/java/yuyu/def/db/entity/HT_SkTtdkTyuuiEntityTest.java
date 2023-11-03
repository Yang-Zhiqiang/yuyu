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

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 新契約手続注意テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SkTtdkTyuuiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_User aM_User1 = new AM_User("001");
        AM_User aM_User2 = new AM_User("002");
        aM_User1.setUserNm("ユーザ００１");
        aM_User1.setPassword("0012");
        aM_User2.setUserNm("ユーザ００２");
        aM_User2.setPassword("0022");

        baseDomManager.insert(aM_User1);
        baseDomManager.insert(aM_User2);

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn1 = C_SkeittdkrenrakuKbn.BLNK;
        Integer pDatarenno1 = 11111;
        C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn2 = C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO;
        Integer pDatarenno2 = 22222;
        C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn3 = C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO;
        Integer pDatarenno3 = 33333;
        HT_SkTtdkTyuui hT_SkTtdkTyuui1 = hT_SyoriCTL1.createSkTtdkTyuui();
        hT_SkTtdkTyuui1.setSkeittdkrenrakukbn(pSkeittdkrenrakukbn1);
        hT_SkTtdkTyuui1.setDatarenno(pDatarenno1);
        hT_SkTtdkTyuui1.setGyoumuKousinsyaId("001");
        HT_SkTtdkTyuui hT_SkTtdkTyuui2 = hT_SyoriCTL1.createSkTtdkTyuui();
        hT_SkTtdkTyuui2.setSkeittdkrenrakukbn(pSkeittdkrenrakukbn2);
        hT_SkTtdkTyuui2.setDatarenno(pDatarenno2);
        hT_SkTtdkTyuui2.setGyoumuKousinsyaId("002");
        HT_SkTtdkTyuui hT_SkTtdkTyuui3 = hT_SyoriCTL1.createSkTtdkTyuui();
        hT_SkTtdkTyuui3.setSkeittdkrenrakukbn(pSkeittdkrenrakukbn3);
        hT_SkTtdkTyuui3.setDatarenno(pDatarenno3);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllUsers());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
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

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(pMosno1, sinkeiyakuDomManager.getSyoriCTL(pMosno1).getSkTtdkTyuuis().get(0).getSyoriCTL().getMosno());
    }

    @Test
    @TestOrder(70)
    public void getUser() {

        String pMosno1 = "MOSNOD00001";
        String pUserId = "001";
        String pUserId2 = "002";

        Assert.assertEquals(baseDomManager.getUser(pUserId), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getSkTtdkTyuuis().get(0).getUser());
        Assert.assertEquals(baseDomManager.getUser(pUserId2), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getSkTtdkTyuuis().get(1).getUser());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getSkTtdkTyuuis().get(2).getUser());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getUserNull01() {

        String pUserId = "002";

        baseDomManager.delete(baseDomManager.getUser(pUserId));
    }

    @Test
    @TestOrder(90)
    public void getUserNull02() {


        String pMosno1 = "MOSNOD00001";
        String pUserId = "001";

        Assert.assertEquals(baseDomManager.getUser(pUserId), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getSkTtdkTyuuis().get(0).getUser());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getSkTtdkTyuuis().get(1).getUser());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getSkTtdkTyuuis().get(2).getUser());
    }
}
