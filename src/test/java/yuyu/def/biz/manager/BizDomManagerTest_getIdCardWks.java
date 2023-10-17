package yuyu.def.biz.manager;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getIdCardWks() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getIdCardWks {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BW_IdCardWk> beans =
            bizDomManager.getIdCardWks()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "100001");

        bizDomManager.insert(idCardWk1);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal10() {

        try (ExDBResults<BW_IdCardWk> beans = bizDomManager.getIdCardWks())
        {

            int iCount = 0;
            Iterator<BW_IdCardWk> iter = beans.iterator();
            BW_IdCardWk BW_IdCardWk = null;
            while (iter.hasNext()) {

                BW_IdCardWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("01", BW_IdCardWk.getIdkbn());
                    Assert.assertEquals("100001", BW_IdCardWk.getIdcd());
                    continue;
                }
            }

            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(11)
    @Transactional
    public void normal11() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllIdCardWk());

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("05", "100006");

        bizDomManager.insert(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("03", "100001");

        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("02", "100006");

        bizDomManager.insert(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("02", "100004");

        bizDomManager.insert(idCardWk4);

        BW_IdCardWk idCardWk5 = new BW_IdCardWk("02", "100003");

        bizDomManager.insert(idCardWk5);

    }

    @Test
    @TestOrder(20)
    public void normal20() {

        try (ExDBResults<BW_IdCardWk> beans = bizDomManager.getIdCardWks())
        {

            int iCount = 0;
            Iterator<BW_IdCardWk> iter = beans.iterator();
            BW_IdCardWk BW_IdCardWk = null;
            while (iter.hasNext()) {

                BW_IdCardWk = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("02", BW_IdCardWk.getIdkbn());
                    Assert.assertEquals("100003", BW_IdCardWk.getIdcd());

                    continue;
                }

                if (2 == iCount) {


                    Assert.assertEquals("02", BW_IdCardWk.getIdkbn());
                    Assert.assertEquals("100004", BW_IdCardWk.getIdcd());
                    continue;
                }

                if (3 == iCount) {


                    Assert.assertEquals("02", BW_IdCardWk.getIdkbn());
                    Assert.assertEquals("100006", BW_IdCardWk.getIdcd());
                    continue;
                }

                if (4 == iCount) {


                    Assert.assertEquals("03", BW_IdCardWk.getIdkbn());
                    Assert.assertEquals("100001", BW_IdCardWk.getIdcd());

                    continue;
                }

                if (5 == iCount) {


                    Assert.assertEquals("05", BW_IdCardWk.getIdkbn());
                    Assert.assertEquals("100006", BW_IdCardWk.getIdcd());

                    continue;
                }

            }
            Assert.assertEquals(5, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BW_IdCardWk> idCardWkList = bizDomManager.getAllIdCardWk();
        if(idCardWkList.size() > 0){
            bizDomManager.delete(idCardWkList);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}

