package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriTest_getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban {
    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        if (dsKokyakuKanri1 == null) {
            dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

            MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri1.
                    getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.valueOf(20161018), 20011101);
            Assert.assertEquals(null, dsMailAddressSpiralYyk);

            MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk1 = dsKokyakuKanri1.createDsMailAddressSpiralYyk();
            dsMailAddressSpiralYyk1.setDsdatasakuseiymd(BizDate.valueOf(20161018));
            dsMailAddressSpiralYyk1.setDsmailaddressrenban(20011101);

            MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk2 = dsKokyakuKanri1.createDsMailAddressSpiralYyk();
            dsMailAddressSpiralYyk2.setDsdatasakuseiymd(BizDate.valueOf(20161018));
            dsMailAddressSpiralYyk2.setDsmailaddressrenban(20011102);

            MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk3 = dsKokyakuKanri1.createDsMailAddressSpiralYyk();
            dsMailAddressSpiralYyk3.setDsdatasakuseiymd(BizDate.valueOf(20161019));
            dsMailAddressSpiralYyk3.setDsmailaddressrenban(20011101);

            directDomManager.insert(dsKokyakuKanri1);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(20)
    public void noResult1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri1.
                getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.valueOf(20161118), 20011101);

        Assert.assertEquals(null, dsMailAddressSpiralYyk);
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri1.
                getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.valueOf(20161018), 20011101);

        Assert.assertEquals(BizDate.valueOf(20161018), dsMailAddressSpiralYyk.getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsMailAddressSpiralYyk.getDskokno());
        Assert.assertEquals(20011101, dsMailAddressSpiralYyk.getDsmailaddressrenban().intValue());

    }

}
