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

import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ顧客管理テーブル(MT_DsKokyakuKanri) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriDetacherTest_detachDsKokyakuKeiyakuDsHonninKakuninCdDsLoginKanritouched {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager .class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("D10000001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111118");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111129");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono("11807111130");

        MT_DsHonninKakuninCd dsHonninKakuninCd1 = dsKokyakuKanri1.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri1 = dsKokyakuKanri1.createDsLoginKanri();

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

        List<MT_DsKokyakuKanri> entityList = MT_DsKokyakuKanriDetacher.detachDsKokyakuKeiyakuDsHonninKakuninCdDsLoginKanritouched(dsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(MT_DsKokyakuKanri entity : entityList) {

            List<MT_DsKokyakuKeiyaku> kykSyouhnLst = entity.getDsKokyakuKeiyakus();

            Assert.assertEquals("D10000001", kykSyouhnLst.get(0).getDskokno());
            Assert.assertEquals("11807111118", kykSyouhnLst.get(0).getSyono());

            Assert.assertEquals("D10000001", kykSyouhnLst.get(1).getDskokno());
            Assert.assertEquals("11807111129", kykSyouhnLst.get(1).getSyono());

            Assert.assertEquals("D10000001", kykSyouhnLst.get(2).getDskokno());
            Assert.assertEquals("11807111130", kykSyouhnLst.get(2).getSyono());

            MT_DsHonninKakuninCd dsHonninKakuninCd = entity.getDsHonninKakuninCd();

            Assert.assertEquals("D10000001", dsHonninKakuninCd.getDskokno());

            MT_DsLoginKanri dsLoginKanri = entity.getDsLoginKanri();

            Assert.assertEquals("D10000001", dsLoginKanri.getDskokno());


            Assert.assertFalse(em.getEntityManager().contains(entity));
        }

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("D10000001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111118");

        MT_DsHonninKakuninCd dsHonninKakuninCd1 = dsKokyakuKanri1.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri1 = dsKokyakuKanri1.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("D10000002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri2.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111129");

        MT_DsHonninKakuninCd dsHonninKakuninCd2 = dsKokyakuKanri2.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri2 = dsKokyakuKanri2.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("D10000003");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono("11807111130");

        MT_DsHonninKakuninCd dsHonninKakuninCd3 = dsKokyakuKanri3.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri3 = dsKokyakuKanri3.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri3);

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<MT_DsKokyakuKanri> dsKokyakuKanri = directDomManager.getAllDsKokyakuKanri();

        List<MT_DsKokyakuKanri> entityList = MT_DsKokyakuKanriDetacher.detachDsKokyakuKeiyakuDsHonninKakuninCdDsLoginKanritouched(dsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(MT_DsKokyakuKanri entity : entityList) {
            if(entity.getDskokno().equals("D10000001")){

                List<MT_DsKokyakuKeiyaku> kykSyouhnLst = entity.getDsKokyakuKeiyakus();

                Assert.assertEquals("D10000001", kykSyouhnLst.get(0).getDskokno());
                Assert.assertEquals("11807111118", kykSyouhnLst.get(0).getSyono());

                MT_DsHonninKakuninCd dsHonninKakuninCd = entity.getDsHonninKakuninCd();

                Assert.assertEquals("D10000001", dsHonninKakuninCd.getDskokno());

                MT_DsLoginKanri dsLoginKanri = entity.getDsLoginKanri();

                Assert.assertEquals("D10000001", dsLoginKanri.getDskokno());
            }
            if(entity.getDskokno().equals("D10000002")){

                List<MT_DsKokyakuKeiyaku> kykSyouhnLst = entity.getDsKokyakuKeiyakus();

                Assert.assertEquals("D10000002", kykSyouhnLst.get(0).getDskokno());
                Assert.assertEquals("11807111129", kykSyouhnLst.get(0).getSyono());

                MT_DsHonninKakuninCd dsHonninKakuninCd = entity.getDsHonninKakuninCd();

                Assert.assertEquals("D10000002", dsHonninKakuninCd.getDskokno());

                MT_DsLoginKanri dsLoginKanri = entity.getDsLoginKanri();

                Assert.assertEquals("D10000002", dsLoginKanri.getDskokno());
            }
            if(entity.getDskokno().equals("D10000003")){

                List<MT_DsKokyakuKeiyaku> kykSyouhnLst = entity.getDsKokyakuKeiyakus();

                Assert.assertEquals("D10000003", kykSyouhnLst.get(0).getDskokno());
                Assert.assertEquals("11807111130", kykSyouhnLst.get(0).getSyono());

                MT_DsHonninKakuninCd dsHonninKakuninCd = entity.getDsHonninKakuninCd();
                Assert.assertEquals("D10000003", dsHonninKakuninCd.getDskokno());

                MT_DsLoginKanri dsLoginKanri = entity.getDsLoginKanri();

                Assert.assertEquals("D10000003", dsLoginKanri.getDskokno());
            }

        }
    }


    @Test
    @TestOrder(30)
    public void testDetach3() {

        List<MT_DsKokyakuKanri> dsKokyakuKanri = new ArrayList<>();

        dsKokyakuKanri.add(null);
        dsKokyakuKanri.add(null);

        List<MT_DsKokyakuKanri> entityList = MT_DsKokyakuKanriDetacher.detachDsKokyakuKeiyakuDsHonninKakuninCdDsLoginKanritouched(dsKokyakuKanri);

        for(MT_DsKokyakuKanri entity : entityList) {

            Assert.assertNull(entity);
        }
    }

}
