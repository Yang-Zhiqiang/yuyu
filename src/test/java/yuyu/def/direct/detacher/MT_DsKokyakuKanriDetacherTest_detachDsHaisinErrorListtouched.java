package yuyu.def.direct.detacher;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.MT_DsHaisinErrorList;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ顧客管理テーブル(MT_DsKokyakuKanri) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriDetacherTest_detachDsHaisinErrorListtouched {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager .class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("123456789");

        MT_DsHaisinErrorList dsHaisinErrorList1 = dsKokyakuKanri1.createDsHaisinErrorList();
        dsHaisinErrorList1.setDsdatasakuseiymd(BizDate.valueOf(20160606));
        dsHaisinErrorList1.setDsmailaddressrenban(111111111);

        MT_DsHaisinErrorList dsHaisinErrorList2 = dsKokyakuKanri1.createDsHaisinErrorList();
        dsHaisinErrorList2.setDsdatasakuseiymd(BizDate.valueOf(20160607));
        dsHaisinErrorList2.setDsmailaddressrenban(111111111);

        MT_DsHaisinErrorList dsHaisinErrorList3 = dsKokyakuKanri1.createDsHaisinErrorList();
        dsHaisinErrorList3.setDsdatasakuseiymd(BizDate.valueOf(20160608));
        dsHaisinErrorList3.setDsmailaddressrenban(111111111);

        directDomManager.insert(dsKokyakuKanri1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager .class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = directDomManager.getDsKokyakuKanri("123456789");

        MT_DsKokyakuKanri entity = MT_DsKokyakuKanriDetacher.detachDsHaisinErrorListtouched(mT_DsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<MT_DsHaisinErrorList> dsKokyakuKeiyakuLst = entity.getDsHaisinErrorLists();

        Assert.assertEquals(BizDate.valueOf(20160606), dsKokyakuKeiyakuLst.get(0).getDsdatasakuseiymd());
        Assert.assertEquals("123456789", dsKokyakuKeiyakuLst.get(0).getDskokno());
        Assert.assertEquals(111111111, dsKokyakuKeiyakuLst.get(0).getDsmailaddressrenban().intValue());

        Assert.assertEquals(BizDate.valueOf(20160607), dsKokyakuKeiyakuLst.get(1).getDsdatasakuseiymd());
        Assert.assertEquals("123456789", dsKokyakuKeiyakuLst.get(1).getDskokno());
        Assert.assertEquals(111111111, dsKokyakuKeiyakuLst.get(1).getDsmailaddressrenban().intValue());

        Assert.assertEquals(BizDate.valueOf(20160608), dsKokyakuKeiyakuLst.get(2).getDsdatasakuseiymd());
        Assert.assertEquals("123456789", dsKokyakuKeiyakuLst.get(2).getDskokno());
        Assert.assertEquals(111111111, dsKokyakuKeiyakuLst.get(2).getDsmailaddressrenban().intValue());

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = null;

        Assert.assertNull(MT_DsKokyakuKanriDetacher.detachDsHaisinErrorListtouched(mT_DsKokyakuKanri));
    }
}
