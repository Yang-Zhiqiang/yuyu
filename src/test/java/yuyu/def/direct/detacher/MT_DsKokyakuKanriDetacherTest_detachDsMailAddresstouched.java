package yuyu.def.direct.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ顧客管理テーブル(MT_DsKokyakuKanri) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriDetacherTest_detachDsMailAddresstouched {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager .class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("D10000001");

        MT_DsMailAddress dsMailAddress1 = dsKokyakuKanri1.createDsMailAddress();
        dsMailAddress1.setDsmailaddressrenban(111111111);

        MT_DsMailAddress dsMailAddress2 = dsKokyakuKanri1.createDsMailAddress();
        dsMailAddress2.setDsmailaddressrenban(222222222);

        MT_DsMailAddress dsMailAddress3 = dsKokyakuKanri1.createDsMailAddress();
        dsMailAddress3.setDsmailaddressrenban(333333333);

        directDomManager.insert(dsKokyakuKanri1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager .class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testDetach1() {

        List<MT_DsKokyakuKanri> dsKokyakuKanri = directDomManager.getAllDsKokyakuKanri();

        List<MT_DsKokyakuKanri> entityList = MT_DsKokyakuKanriDetacher.detachDsMailAddresstouched(dsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(MT_DsKokyakuKanri entity : entityList) {

            List<MT_DsMailAddress> dsMailAddressLst = entity.getDsMailAddresss();

            Assert.assertEquals("D10000001", dsMailAddressLst.get(0).getDskokno());
            Assert.assertEquals(111111111, dsMailAddressLst.get(0).getDsmailaddressrenban().intValue());

            Assert.assertEquals("D10000001", dsMailAddressLst.get(1).getDskokno());
            Assert.assertEquals(222222222, dsMailAddressLst.get(1).getDsmailaddressrenban().intValue());

            Assert.assertEquals("D10000001", dsMailAddressLst.get(2).getDskokno());
            Assert.assertEquals(333333333, dsMailAddressLst.get(2).getDsmailaddressrenban().intValue());

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("D10000001");

        MT_DsMailAddress dsMailAddress1 = dsKokyakuKanri1.createDsMailAddress();
        dsMailAddress1.setDsmailaddressrenban(111111111);

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("D10000002");

        MT_DsMailAddress dsMailAddress2 = dsKokyakuKanri2.createDsMailAddress();
        dsMailAddress2.setDsmailaddressrenban(222222222);

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("D10000003");

        MT_DsMailAddress dsMailAddress3 = dsKokyakuKanri3.createDsMailAddress();
        dsMailAddress3.setDsmailaddressrenban(333333333);

        directDomManager.insert(dsKokyakuKanri3);

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<MT_DsKokyakuKanri> dsKokyakuKanri = directDomManager.getAllDsKokyakuKanri();

        List<MT_DsKokyakuKanri> entityList = MT_DsKokyakuKanriDetacher.detachDsMailAddresstouched(dsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(MT_DsKokyakuKanri entity : entityList) {
            if(entity.getDskokno().equals("D10000001")){

                List<MT_DsMailAddress> dsMailAddressLst = entity.getDsMailAddresss();

                Assert.assertEquals("D10000001", dsMailAddressLst.get(0).getDskokno());
                Assert.assertEquals(111111111, dsMailAddressLst.get(0).getDsmailaddressrenban().intValue());

            }
            if(entity.getDskokno().equals("D10000002")){

                List<MT_DsMailAddress> dsMailAddressLst = entity.getDsMailAddresss();

                Assert.assertEquals("D10000002", dsMailAddressLst.get(0).getDskokno());
                Assert.assertEquals(222222222, dsMailAddressLst.get(0).getDsmailaddressrenban().intValue());

            }
            if(entity.getDskokno().equals("D10000003")){

                List<MT_DsMailAddress> dsMailAddressLst = entity.getDsMailAddresss();

                Assert.assertEquals("D10000003", dsMailAddressLst.get(0).getDskokno());
                Assert.assertEquals(333333333, dsMailAddressLst.get(0).getDsmailaddressrenban().intValue());
            }

            Assert.assertFalse(em.getEntityManager().contains(entity));

        }

    }


    @Test
    @TestOrder(30)
    public void testDetach3() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = new ArrayList<>();

        dsKokyakuKanriLst.add(null);
        dsKokyakuKanriLst.add(null);

        List<MT_DsKokyakuKanri> entityList = MT_DsKokyakuKanriDetacher.detachDsMailAddresstouched(dsKokyakuKanriLst);

        for(MT_DsKokyakuKanri entity : entityList) {

            Assert.assertNull(entity);
        }
    }

}

