package yuyu.def.direct.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsKouzokuJimuKakuninsByHasseiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKouzokuJimuKakuninsByHasseiymd {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        try (ExDBResults<MT_DsKouzokuJimuKakunin> exDBUpdatableResults = directDomManager.
            getDsKouzokuJimuKakuninsByHasseiymd(BizDate.valueOf(20161010))) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }

        MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin1 = new MT_DsKouzokuJimuKakunin(BizDate.valueOf("20161010"),
            C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, "11807111222");

        directDomManager.insert(dsKouzokuJimuKakunin1);

        MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin2 = new MT_DsKouzokuJimuKakunin(BizDate.valueOf("20161009"),
            C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, "11807111222");

        directDomManager.insert(dsKouzokuJimuKakunin2);

        MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin3 = new MT_DsKouzokuJimuKakunin(BizDate.valueOf("20161020"),
            C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, "11807111222");

        directDomManager.insert(dsKouzokuJimuKakunin3);

        MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin4 = new MT_DsKouzokuJimuKakunin(BizDate.valueOf("20161020"),
            C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, "11807111211");

        directDomManager.insert(dsKouzokuJimuKakunin4);

        MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin5 = new MT_DsKouzokuJimuKakunin(BizDate.valueOf("20161020"),
            C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, "11807111200");

        directDomManager.insert(dsKouzokuJimuKakunin5);

        MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin6 = new MT_DsKouzokuJimuKakunin(BizDate.valueOf("20161020"),
            C_DsKzkJmKknHsJyKbn.ONLINE, "11807111211");

        directDomManager.insert(dsKouzokuJimuKakunin6);

        MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin7 = new MT_DsKouzokuJimuKakunin(BizDate.valueOf("20161020"),
            C_DsKzkJmKknHsJyKbn.NAYOSESAKIHUMEI, "11807111200");
        directDomManager.insert(dsKouzokuJimuKakunin7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKouzokuJimuKakunin());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<MT_DsKouzokuJimuKakunin> exDBUpdatableResults = directDomManager.
            getDsKouzokuJimuKakuninsByHasseiymd(BizDate.valueOf(20160101))) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }

    }
    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<MT_DsKouzokuJimuKakunin> exDBUpdatableResults = directDomManager.
            getDsKouzokuJimuKakuninsByHasseiymd(BizDate.valueOf(20161010))) {

            int iCount = 0;
            Iterator<MT_DsKouzokuJimuKakunin> iter = exDBUpdatableResults.iterator();
            MT_DsKouzokuJimuKakunin mT_DsKouzokuJimuKakunin = null;
            while (iter.hasNext()) {

                mT_DsKouzokuJimuKakunin = iter.next();
                iCount++;

                Assert.assertEquals(BizDate.valueOf("20161010"), mT_DsKouzokuJimuKakunin.getHasseiymd());
                Assert.assertEquals(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, mT_DsKouzokuJimuKakunin.getDskzkjmkknhsjykbn());
                Assert.assertEquals("11807111222", mT_DsKouzokuJimuKakunin.getSyono());
            }

            Assert.assertEquals(1, iCount);
        }

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<MT_DsKouzokuJimuKakunin> exDBUpdatableResults = directDomManager.
            getDsKouzokuJimuKakuninsByHasseiymd(BizDate.valueOf(20161020))) {

            int iCount = 0;
            Iterator<MT_DsKouzokuJimuKakunin> iter = exDBUpdatableResults.iterator();
            MT_DsKouzokuJimuKakunin mT_DsKouzokuJimuKakunin = null;
            while (iter.hasNext()) {

                mT_DsKouzokuJimuKakunin = iter.next();
                iCount++;

                if (2 == iCount) {

                    Assert.assertEquals(BizDate.valueOf("20161020"), mT_DsKouzokuJimuKakunin.getHasseiymd());
                    Assert.assertEquals(C_DsKzkJmKknHsJyKbn.NAYOSESAKIHUMEI, mT_DsKouzokuJimuKakunin.getDskzkjmkknhsjykbn());
                    Assert.assertEquals("11807111200", mT_DsKouzokuJimuKakunin.getSyono());
                    continue;
                }

                if (1 == iCount) {

                    Assert.assertEquals(BizDate.valueOf("20161020"), mT_DsKouzokuJimuKakunin.getHasseiymd());
                    Assert.assertEquals(C_DsKzkJmKknHsJyKbn.ONLINE, mT_DsKouzokuJimuKakunin.getDskzkjmkknhsjykbn());
                    Assert.assertEquals("11807111211", mT_DsKouzokuJimuKakunin.getSyono());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(BizDate.valueOf("20161020"), mT_DsKouzokuJimuKakunin.getHasseiymd());
                    Assert.assertEquals(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, mT_DsKouzokuJimuKakunin.getDskzkjmkknhsjykbn());
                    Assert.assertEquals("11807111200", mT_DsKouzokuJimuKakunin.getSyono());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(BizDate.valueOf("20161020"), mT_DsKouzokuJimuKakunin.getHasseiymd());
                    Assert.assertEquals(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, mT_DsKouzokuJimuKakunin.getDskzkjmkknhsjykbn());
                    Assert.assertEquals("11807111211", mT_DsKouzokuJimuKakunin.getSyono());
                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(BizDate.valueOf("20161020"), mT_DsKouzokuJimuKakunin.getHasseiymd());
                    Assert.assertEquals(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU, mT_DsKouzokuJimuKakunin.getDskzkjmkknhsjykbn());
                    Assert.assertEquals("11807111222", mT_DsKouzokuJimuKakunin.getSyono());
                    continue;
                }
            }
            Assert.assertEquals(5, iCount);
        }
    }
}
