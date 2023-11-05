package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約不備詳細テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailCountByPkHasinkyokakbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByPkHasinkyokakbn("791112220", "123");
        Assert.assertEquals(new Long(0), count);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("123");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(111);
        skHubiDetail1.setHasinkyokakbn(C_HasinkyokaKbn.HORYUU);

        HT_SkHubiDetail skHubiDetail4 = skHubi1.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(112);
        skHubiDetail4.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubi skHubi3 = syoriCTL1.createSkHubi();
        skHubi3.setHubisikibetukey("223");

        HT_SkHubiDetail skHubiDetail3 = skHubi3.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(111);
        skHubiDetail3.setHasinkyokakbn(C_HasinkyokaKbn.HORYUU);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("123");

        HT_SkHubiDetail skHubiDetail2 = skHubi2.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(111);
        skHubiDetail2.setHasinkyokakbn(C_HasinkyokaKbn.HORYUU);

        sinkeiyakuDomManager.insert(syoriCTL2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByPkHasinkyokakbn("791112246", "123");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByPkHasinkyokakbn("791112220", "123");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByPkHasinkyokakbn("", "123");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByPkHasinkyokakbn("791112220", "");
        Assert.assertEquals(new Long(0), count);

    }
}
