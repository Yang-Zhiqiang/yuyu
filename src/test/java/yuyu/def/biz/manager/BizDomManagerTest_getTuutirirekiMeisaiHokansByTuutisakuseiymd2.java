package yuyu.def.biz.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTuutirirekiMeisaiHokansByTuutisakuseiymd2() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTuutirirekiMeisaiHokansByTuutisakuseiymd2 {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        try(ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> exDBResBean = bizDomManager.
            getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM.valueOf(201606))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan1 = new BT_TuutirirekiMeisaiHokan("1000000001");
        tuutirirekiMeisaiHokan1.setTuutirirekino("1234567890001");
        tuutirirekiMeisaiHokan1.setTuutisakuseiymd(BizDate.valueOf(20160113));
        tuutirirekiMeisaiHokan1.setTuutisakuseino(11);

        bizDomManager.insert(tuutirirekiMeisaiHokan1);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan2 = new BT_TuutirirekiMeisaiHokan("1000000002");
        tuutirirekiMeisaiHokan2.setTuutirirekino("1234567890001");
        tuutirirekiMeisaiHokan2.setTuutisakuseiymd(BizDate.valueOf(20160213));
        tuutirirekiMeisaiHokan2.setTuutisakuseino(11);

        bizDomManager.insert(tuutirirekiMeisaiHokan2);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan3 = new BT_TuutirirekiMeisaiHokan("1000000003");
        tuutirirekiMeisaiHokan3.setTuutirirekino("1234567890002");
        tuutirirekiMeisaiHokan3.setTuutisakuseiymd(BizDate.valueOf(20160213));
        tuutirirekiMeisaiHokan3.setTuutisakuseino(11);

        bizDomManager.insert(tuutirirekiMeisaiHokan3);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan4 = new BT_TuutirirekiMeisaiHokan("1000000004");
        tuutirirekiMeisaiHokan4.setTuutirirekino("1234567890003");
        tuutirirekiMeisaiHokan4.setTuutisakuseiymd(BizDate.valueOf(20160213));
        tuutirirekiMeisaiHokan4.setTuutisakuseino(11);

        bizDomManager.insert(tuutirirekiMeisaiHokan4);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan5 = new BT_TuutirirekiMeisaiHokan("1000000005");
        tuutirirekiMeisaiHokan5.setTuutirirekino("1234567890003");
        tuutirirekiMeisaiHokan5.setTuutisakuseiymd(BizDate.valueOf(20160313));
        tuutirirekiMeisaiHokan5.setTuutisakuseino(11);

        bizDomManager.insert(tuutirirekiMeisaiHokan5);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan6 = new BT_TuutirirekiMeisaiHokan("1000000006");
        tuutirirekiMeisaiHokan6.setTuutirirekino("1234567890003");
        tuutirirekiMeisaiHokan6.setTuutisakuseiymd(BizDate.valueOf(20160413));
        tuutirirekiMeisaiHokan6.setTuutisakuseino(11);

        bizDomManager.insert(tuutirirekiMeisaiHokan6);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan7 = new BT_TuutirirekiMeisaiHokan("1000000007");
        tuutirirekiMeisaiHokan7.setTuutirirekino("1234567890003");
        tuutirirekiMeisaiHokan7.setTuutisakuseiymd(BizDate.valueOf(20160413));
        tuutirirekiMeisaiHokan7.setTuutisakuseino(12);

        bizDomManager.insert(tuutirirekiMeisaiHokan7);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan8 = new BT_TuutirirekiMeisaiHokan("1000000008");
        tuutirirekiMeisaiHokan8.setTuutirirekino("1234567890003");
        tuutirirekiMeisaiHokan8.setTuutisakuseiymd(BizDate.valueOf(20160413));
        tuutirirekiMeisaiHokan8.setTuutisakuseino(13);

        bizDomManager.insert(tuutirirekiMeisaiHokan8);

        BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan9 = new BT_TuutirirekiMeisaiHokan("1000000009");
        tuutirirekiMeisaiHokan9.setTuutirirekino("1234567890003");
        tuutirirekiMeisaiHokan9.setTuutisakuseiymd(BizDate.valueOf(20160613));
        tuutirirekiMeisaiHokan9.setTuutisakuseino(13);

        bizDomManager.insert(tuutirirekiMeisaiHokan9);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTuutirirekiMeisaiHokan());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try(ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> exDBResBean = bizDomManager.
            getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM.valueOf(201607))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {
        try(ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> exDBResBean = bizDomManager.
            getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM.valueOf(201606))) {

            int iCount = 0;
            Iterator<BT_TuutirirekiMeisaiHokan> iter = exDBResBean.iterator();
            BT_TuutirirekiMeisaiHokan tKTBSDbean = null;
            while (iter.hasNext()) {

                tKTBSDbean = iter.next();
                iCount++;

                Assert.assertEquals("1000000009", tKTBSDbean.getTuutirirekirenno());
                Assert.assertEquals("1234567890003", tKTBSDbean.getTuutirirekino());
                Assert.assertEquals(BizDate.valueOf(20160613), tKTBSDbean.getTuutisakuseiymd());
                Assert.assertEquals(Integer.valueOf(13), tKTBSDbean.getTuutisakuseino());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try(ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> exDBResBean = bizDomManager.
            getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM.valueOf(201602))) {

            int iCount = 0;
            for (BT_TuutirirekiMeisaiHokan entityBean : exDBResBean) {

                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("1000000009", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890003", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160613), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(13), entityBean.getTuutisakuseino());

                }

                if (2 == iCount) {

                    Assert.assertEquals("1000000008", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890003", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160413), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(13), entityBean.getTuutisakuseino());

                }

                if (3 == iCount) {

                    Assert.assertEquals("1000000007", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890003", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160413), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(12), entityBean.getTuutisakuseino());

                }

                if (4 == iCount) {

                    Assert.assertEquals("1000000006", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890003", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160413), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(11), entityBean.getTuutisakuseino());

                }
                if (5 == iCount) {

                    Assert.assertEquals("1000000005", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890003", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160313), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(11), entityBean.getTuutisakuseino());

                }
                if (6 == iCount) {

                    Assert.assertEquals("1000000004", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890003", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160213), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(11), entityBean.getTuutisakuseino());

                }
                if (7 == iCount) {

                    Assert.assertEquals("1000000003", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890002", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160213), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(11), entityBean.getTuutisakuseino());

                }
                if (8 == iCount) {

                    Assert.assertEquals("1000000002", entityBean.getTuutirirekirenno());
                    Assert.assertEquals("1234567890001", entityBean.getTuutirirekino());
                    Assert.assertEquals(BizDate.valueOf(20160213), entityBean.getTuutisakuseiymd());
                    Assert.assertEquals(Integer.valueOf(11), entityBean.getTuutisakuseino());

                }
            }
            Assert.assertEquals(8, iCount);
        }
    }
}