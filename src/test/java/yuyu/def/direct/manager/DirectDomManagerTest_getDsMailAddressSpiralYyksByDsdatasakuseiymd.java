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

import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsMailAddressSpiralYyksByDsdatasakuseiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsMailAddressSpiralYyksByDsdatasakuseiymd {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        try (ExDBResults<MT_DsMailAddressSpiralYyk> exDBResults = directDomManager.
                getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate.valueOf(20161024))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("M100000001");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk1 = dsKokyakuKanri1.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk1.setDsdatasakuseiymd(BizDate.valueOf(20161024));
        dsMailAddressSpiralYyk1.setDsmailaddressrenban(111111111);
        dsMailAddressSpiralYyk1.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk2 = dsKokyakuKanri1.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk2.setDsdatasakuseiymd(BizDate.valueOf(20161023));
        dsMailAddressSpiralYyk2.setDsmailaddressrenban(111111111);
        dsMailAddressSpiralYyk2.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk3 = dsKokyakuKanri1.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk3.setDsdatasakuseiymd(BizDate.valueOf(20161024));
        dsMailAddressSpiralYyk3.setDsmailaddressrenban(111111112);
        dsMailAddressSpiralYyk3.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.BLNK);

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("M100000002");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk6 = dsKokyakuKanri2.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk6.setDsdatasakuseiymd(BizDate.valueOf(20161111));
        dsMailAddressSpiralYyk6.setDsmailaddressrenban(444444444);
        dsMailAddressSpiralYyk6.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("M100000003");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk5 = dsKokyakuKanri3.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk5.setDsdatasakuseiymd(BizDate.valueOf(20161111));
        dsMailAddressSpiralYyk5.setDsmailaddressrenban(222222222);
        dsMailAddressSpiralYyk5.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("M100000004");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk4 = dsKokyakuKanri4.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk4.setDsdatasakuseiymd(BizDate.valueOf(20161111));
        dsMailAddressSpiralYyk4.setDsmailaddressrenban(444444444);
        dsMailAddressSpiralYyk4.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk7 = dsKokyakuKanri4.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk7.setDsdatasakuseiymd(BizDate.valueOf(20161111));
        dsMailAddressSpiralYyk7.setDsmailaddressrenban(333333333);
        dsMailAddressSpiralYyk7.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk8 = dsKokyakuKanri4.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk8.setDsdatasakuseiymd(BizDate.valueOf(20161111));
        dsMailAddressSpiralYyk8.setDsmailaddressrenban(222222222);
        dsMailAddressSpiralYyk8.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);

        directDomManager.insert(dsKokyakuKanri4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<MT_DsMailAddressSpiralYyk> exDBResults = directDomManager.
                getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate.valueOf(20161025))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBResults<MT_DsMailAddressSpiralYyk> exDBResults = directDomManager.
                getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate.valueOf(20161024))) {

            int iCount = 0;
            Iterator<MT_DsMailAddressSpiralYyk> iter = exDBResults.iterator();
            MT_DsMailAddressSpiralYyk mT_DsMailAddressSpiralYyk = null;
            while (iter.hasNext()) {

                mT_DsMailAddressSpiralYyk = iter.next();
                iCount++;

                Assert.assertEquals(BizDate.valueOf(20161024), mT_DsMailAddressSpiralYyk.getDsdatasakuseiymd());
                Assert.assertEquals("M100000001", mT_DsMailAddressSpiralYyk.getDskokno());
                Assert.assertEquals(111111111, mT_DsMailAddressSpiralYyk.getDsmailaddressrenban().intValue());
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<MT_DsMailAddressSpiralYyk> exDBResults = directDomManager.
                getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate.valueOf(20161111))) {

            int iCount = 0;
            Iterator<MT_DsMailAddressSpiralYyk> iter = exDBResults.iterator();
            MT_DsMailAddressSpiralYyk mT_DsMailAddressSpiralYyk = null;
            while (iter.hasNext()) {

                mT_DsMailAddressSpiralYyk = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20161111), mT_DsMailAddressSpiralYyk.getDsdatasakuseiymd());
                    Assert.assertEquals("M100000002", mT_DsMailAddressSpiralYyk.getDskokno());
                    Assert.assertEquals(444444444, mT_DsMailAddressSpiralYyk.getDsmailaddressrenban().intValue());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20161111), mT_DsMailAddressSpiralYyk.getDsdatasakuseiymd());
                    Assert.assertEquals("M100000003", mT_DsMailAddressSpiralYyk.getDskokno());
                    Assert.assertEquals(222222222, mT_DsMailAddressSpiralYyk.getDsmailaddressrenban().intValue());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20161111), mT_DsMailAddressSpiralYyk.getDsdatasakuseiymd());
                    Assert.assertEquals("M100000004", mT_DsMailAddressSpiralYyk.getDskokno());
                    Assert.assertEquals(222222222, mT_DsMailAddressSpiralYyk.getDsmailaddressrenban().intValue());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20161111), mT_DsMailAddressSpiralYyk.getDsdatasakuseiymd());
                    Assert.assertEquals("M100000004", mT_DsMailAddressSpiralYyk.getDskokno());
                    Assert.assertEquals(333333333, mT_DsMailAddressSpiralYyk.getDsmailaddressrenban().intValue());
                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20161111), mT_DsMailAddressSpiralYyk.getDsdatasakuseiymd());
                    Assert.assertEquals("M100000004", mT_DsMailAddressSpiralYyk.getDskokno());
                    Assert.assertEquals(444444444, mT_DsMailAddressSpiralYyk.getDsmailaddressrenban().intValue());
                    continue;
                }
            }
            Assert.assertEquals(5, iCount);
        }
    }
}
