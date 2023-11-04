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

/**
 * 処理コントロールバックアップテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_BAK_SyoriCTLEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_BAK_SyoriCTL> hT_BAK_SyoriCTLs = sinkeiyakuDomManager.getAllBAKSyoriCTL();
        Assert.assertEquals(0, hT_BAK_SyoriCTLs.size());


        HT_BAK_SyoriCTL hT_BAK_SyoriCTL1 = new HT_BAK_SyoriCTL("MOSNOD00002", "222");

        sinkeiyakuDomManager.insert(hT_BAK_SyoriCTL1);

        HT_BAK_SyoriCTL hT_BAK_SyoriCTL2 = new HT_BAK_SyoriCTL("MOSNOD00003", "333");

        sinkeiyakuDomManager.insert(hT_BAK_SyoriCTL2);

        HT_BAK_SyoriCTL hT_BAK_SyoriCTL3 = new HT_BAK_SyoriCTL("MOSNOD00001", "111");

        sinkeiyakuDomManager.insert(hT_BAK_SyoriCTL3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBAKSyoriCTL());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_BAK_SyoriCTL> hT_BAK_SyoriCTLs = sinkeiyakuDomManager.getAllBAKSyoriCTL();
        Assert.assertEquals("MOSNOD00001", hT_BAK_SyoriCTLs.get(0).getMosno());
        Assert.assertEquals("111", hT_BAK_SyoriCTLs.get(0).getTrkssikibetukey());
        Assert.assertEquals("MOSNOD00002", hT_BAK_SyoriCTLs.get(1).getMosno());
        Assert.assertEquals("222", hT_BAK_SyoriCTLs.get(1).getTrkssikibetukey());
        Assert.assertEquals("MOSNOD00003", hT_BAK_SyoriCTLs.get(2).getMosno());
        Assert.assertEquals("333", hT_BAK_SyoriCTLs.get(2).getTrkssikibetukey());

        Assert.assertEquals(3, hT_BAK_SyoriCTLs.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {
        String pMosno = "MOSNOD00001";
        String pTrkssikibetukey = "111";
        HT_BAK_SyoriCTL hT_BAK_SyoriCTL = sinkeiyakuDomManager.getBAKSyoriCTL(pMosno, pTrkssikibetukey);


        Assert.assertEquals(pMosno, hT_BAK_SyoriCTL.getMosno());
        Assert.assertEquals(pTrkssikibetukey, hT_BAK_SyoriCTL.getTrkssikibetukey() );
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {
        String pMosno = "12345678999";
        String pTrkssikibetukey = "111";
        HT_BAK_SyoriCTL hT_BAK_SyoriCTL = sinkeiyakuDomManager.getBAKSyoriCTL(pMosno, pTrkssikibetukey);

        Assert.assertNull(hT_BAK_SyoriCTL);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {
        String pMosno = "";
        String pTrkssikibetukey = "111";
        HT_BAK_SyoriCTL hT_BAK_SyoriCTL = sinkeiyakuDomManager.getBAKSyoriCTL(pMosno, pTrkssikibetukey);

        Assert.assertNull(hT_BAK_SyoriCTL);
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        String pMosno = "MOSNOD00001";
        String pTrkssikibetukey = "";
        HT_BAK_SyoriCTL hT_BAK_SyoriCTL = sinkeiyakuDomManager.getBAKSyoriCTL(pMosno, pTrkssikibetukey);

        Assert.assertNull(hT_BAK_SyoriCTL);
    }

    @Override
    @Test
    @TestOrder(60)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}