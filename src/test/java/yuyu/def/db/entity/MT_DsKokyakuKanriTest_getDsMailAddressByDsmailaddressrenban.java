package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳメールアドレステーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriTest_getDsMailAddressByDsmailaddressrenban {
    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        if (dsKokyakuKanri1 == null) {
            dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

            MT_DsMailAddress dsMailAddress = dsKokyakuKanri1.getDsMailAddressByDsmailaddressrenban(20011101);
            Assert.assertEquals(null, dsMailAddress);

            MT_DsMailAddress dsMailAddress1 = dsKokyakuKanri1.createDsMailAddress();
            dsMailAddress1.setDsmailaddressrenban(20011101);

            MT_DsMailAddress dsMailAddress2 = dsKokyakuKanri1.createDsMailAddress();
            dsMailAddress2.setDsmailaddressrenban(20011102);

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
        MT_DsMailAddress dsMailAddress = dsKokyakuKanri1.getDsMailAddressByDsmailaddressrenban(20011104);

        Assert.assertEquals(null, dsMailAddress);
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        MT_DsMailAddress dsMailAddress = dsKokyakuKanri1.getDsMailAddressByDsmailaddressrenban(20011101);

        Assert.assertEquals("100001", dsMailAddress.getDskokno());
        Assert.assertEquals(20011101, dsMailAddress.getDsmailaddressrenban().intValue());

    }

}
