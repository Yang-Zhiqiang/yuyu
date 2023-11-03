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

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * その他特約条件付履歴テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SonotaTkykJktkRirekiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_DakuhiKettei hT_DakuhiKettei = hT_SyoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei.setDakuhiktrenno(1);

        HT_SonotaTkykJktkRireki hT_SonotaTkykJktkRireki = hT_DakuhiKettei.createSonotaTkykJktkRireki();
        hT_SonotaTkykJktkRireki.setPmnjtkkbn(C_PmnjtkKbn.SANDAISIPPMNJTOK);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

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
    public void getDakuhiKettei() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(pMosno1, sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getSonotaTkykJktkRirekis().get(0).getMosno());
        Assert.assertEquals(1, sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getSonotaTkykJktkRirekis().get(0).getDakuhiktrenno().intValue());

    }

}